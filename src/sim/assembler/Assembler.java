package sim.assembler;

import java.io.*;
import java.util.*;

public class Assembler {

	
	private static class UnpackedLine {

		Instruction instruction;
		int typeOfAddressing;
		int register;
		int low;
		int high;
		boolean needPatching;
		String label;
	}
	
	private static class Instruction {
		
		int group;
		int opcode;
		
		Instruction(int group, int opcode) {
			this.group = group;
			this.opcode = opcode;
		}
	}
	
	@SuppressWarnings("serial")
	public static class BadInstruction extends Exception{
		
		public BadInstruction(int line) {
			super("Bad instruction at line "+line);
		}
	}
	
	private static HashMap<String, Instruction> instructions = new HashMap<String, Instruction>();
	private BufferedReader read;
	private int line;
	private ArrayList<UnpackedLine> unpackedSource;
	private HashMap<String, Integer> labels;
	private ArrayList<Integer> code;
	private int startOfCode = 256;

	public Assembler(String asmcode) {
		try {
			read = new BufferedReader(new FileReader(asmcode));
			unpackedSource = new ArrayList<UnpackedLine>();
			labels = new HashMap<String, Integer>();
			code = new ArrayList<Integer>();
			try {
				firstPass();
				secondPass();
			} catch (BadInstruction be) {
				System.out.println(be.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Assembly file not found!");
		}
	}
	
	public Object[] getCode() {
		return code.toArray();
	}
	
	public int getStartOfCode() {
		return startOfCode;
	}
	
	private static void addInstruction(String name, int group, int opcode) {
		Instruction ins = new Instruction(group, opcode);
		instructions.put(name, ins);
		if(name.charAt(0) >= 'A' && name.charAt(0) <= 'Z') {
			instructions.put(name.toLowerCase(), ins);
		} else if(name.charAt(0) >= 'a' && name.charAt(0) <= 'z'){
			instructions.put(name.toUpperCase(), ins);
		} else {
			System.out.println("Bad instruction: "+name);
		}
	}

	static {
		addInstruction("nop", 0, 0);
		addInstruction("halt", 0, 1);
		addInstruction("intd", 0, 4);
		addInstruction("inte", 0, 5);
		addInstruction("trpd", 0, 6);
		addInstruction("trpe", 0, 7);
		addInstruction("jmp", 1, 1);
		addInstruction("jsr", 1, 2);
		addInstruction("rts", 1, 3);
		addInstruction("int", 1, 4);
		addInstruction("rti", 1, 5);
		addInstruction("beql", 2, 0);
		addInstruction("bneql", 2, 1);
		addInstruction("bneg", 2, 2);
		addInstruction("bnneg", 2, 3);
		addInstruction("bovf", 2, 4);
		addInstruction("bnovf", 2, 5);
		addInstruction("bcar", 2, 6);
		addInstruction("bncar", 2, 7);
		addInstruction("bgrt", 3, 0);
		addInstruction("bgrte", 3, 1);
		addInstruction("blss", 3, 2);
		addInstruction("blsse", 3, 3);
		addInstruction("bgrtu", 3, 4);
		addInstruction("bgrteu", 3, 5);
		addInstruction("blssu", 3, 6);
		addInstruction("blsseu", 3, 7);
		addInstruction("ldb", 4, 0);
		addInstruction("ldw", 4, 1);
		addInstruction("stb", 4, 2);
		addInstruction("stw", 4, 3);
		addInstruction("popb", 4, 4);
		addInstruction("popw", 4, 5);
		addInstruction("pushb", 4, 6);
		addInstruction("pushw", 4, 7);
		addInstruction("ldivtp", 5, 0);
		addInstruction("stivtp", 5, 1);
		addInstruction("ldimr", 5, 2);
		addInstruction("stimr", 5, 3);
		addInstruction("ldsp", 5, 4);
		addInstruction("stsp", 5, 5);
		addInstruction("add", 6, 0);
		addInstruction("sub", 6, 1);
		addInstruction("inc", 6, 2);
		addInstruction("dec", 6, 3);
		addInstruction("and", 6, 4);
		addInstruction("or", 6, 5);
		addInstruction("xor", 6, 6);
		addInstruction("not", 6, 7);
		addInstruction("asr", 7, 0);
		addInstruction("lsr", 7, 1);
		addInstruction("ror", 7, 2);
		addInstruction("rorc", 7, 3);
		addInstruction("asl", 7, 4);
		addInstruction("lsl", 7, 5);
		addInstruction("rol", 7, 6);
		addInstruction("rolc", 7, 7);
	}
	
	private String readSourceLine() {
		line++;
		try {
			return read.readLine();
		} catch (IOException e) {
			System.out.println("Error reading source!");
			return null;
		}
	}
	
	private void firstPass() throws BadInstruction {
		int location = 256;
		String lineOfCode = readSourceLine();

		while (lineOfCode != null) {

			String[] tokens = lineOfCode.split("( )+");
			if(tokens[0].equals("") || tokens[0].substring(0,2).equals("//")) {
				lineOfCode = readSourceLine();
				continue;
			}
			int currToken = 0;
			UnpackedLine unpacked = new UnpackedLine();
			String token = tokens[currToken++];

			if (token.equalsIgnoreCase("ORG")) {
				
				token = tokens[currToken++];
				startOfCode = Integer.parseInt(token);
				location = startOfCode;
				lineOfCode = readSourceLine();
				continue;
			}
			
			if (token.indexOf(':') != -1) {
				
				labels.put(token.substring(0, token.indexOf(':')), location);
				token = tokens[currToken++];
			}
			
			Instruction ins = instructions.get(token);
			if(ins == null) {
				throw new BadInstruction(line);
			}
			unpacked.instruction = ins;
			
			// non-adressing instructions
			if (ins.group == 0
				|| ins.group == 1 && (ins.opcode == 3 || ins.opcode == 5)
				|| ins.group == 4 && (ins.opcode >= 4 && ins.opcode <= 7)
				|| ins.group == 5
				|| ins.group == 6 && (ins.opcode == 2 || ins.opcode == 3 || ins.opcode == 7)
				|| ins.group == 7) {
				
				location++;
				unpackedSource.add(unpacked);
				lineOfCode = readSourceLine();
				continue;
			}
			
			// branch conditional instructions
			if (ins.group == 2 || ins.group == 3) {
				token = tokens[currToken++];
				
				// immediate displacement (for example: #3)
				if (token.charAt(0) == '#') {
					
					unpacked.low = Integer.parseInt(token.substring(1));
				
				// label, displacement needs calculating	
				} else { 
					
					if (labels.containsKey(token)) {
						unpacked.low = labels.get(token) - location - 2;
					} else {
						unpacked.low = -location - 2;
						unpacked.label = token;
						unpacked.needPatching = true;
					}
				}
				location += 2;
				unpackedSource.add(unpacked);
				lineOfCode = readSourceLine();
				continue;
			}
			
			// branch unconditional instructions
			if (ins.group == 1 && (ins.opcode == 1 || ins.opcode == 2)) {
				token = tokens[currToken++];
				
				// immediate displacement (for example: #3)
				if (token.charAt(0) == '#') {
					
					int temp = Integer.parseInt(token.substring(1));
					unpacked.high = temp >> 8;
					unpacked.low = temp & 0xFF;
					
				// label, displacement needs calculating
				} else {
					
					if (labels.containsKey(token)) {
						int temp = labels.get(token);
						unpacked.high = temp >> 8;
						unpacked.low = temp & 0xFF;
					} else {
						unpacked.low = 0;
						unpacked.label = token;
						unpacked.needPatching = true;
					}
				}
				location += 3;
				unpackedSource.add(unpacked);
				lineOfCode = readSourceLine();
				continue;
			}
			
			// INT instruction
			if (ins.group == 1 && ins.opcode == 4) {
				token = tokens[currToken++];
				
				// immediate displacement (for example: #3)
				if (token.charAt(0) == '#') {
					
					unpacked.low = Integer.parseInt(token.substring(1));
				} else {
					throw new BadInstruction(line);
				}
				location += 2;
				unpackedSource.add(unpacked);
				lineOfCode = readSourceLine();
				continue;
			}
			
			// addressing instructions
			if (ins.group == 4 && (ins.opcode >= 0 && ins.opcode <= 3)
				|| ins.group == 6 && (ins.opcode != 2 && ins.opcode != 3 && ins.opcode != 7)) {
				
				token = tokens[currToken++];
				
				// immediate addressing
				if (token.charAt(0) == '#') {
					unpacked.typeOfAddressing = 7;
					if (ins.group == 4 && ins.opcode == 1) {
						int temp = Integer.parseInt(token.substring(1));
						unpacked.high = temp >> 8;
						unpacked.low = temp & 0xFF;
						location += 4;
					} else {
						unpacked.high = Integer.parseInt(token.substring(1));
						location += 3;
					}
					
				// direct register addressing
				} else if ((token.charAt(0) == 'R') || (token.charAt(0) == 'r')) {
					unpacked.typeOfAddressing = 0;
					unpacked.register = Integer.parseInt(token.substring(1));
					location += 2;
					
				// indirect addressing
				} else if (token.charAt(0) == '(') {
					
					// indirect register addressing (for example ADD (R4))
					if ((token.charAt(1) == 'R') || (token.charAt(1) == 'r')) {
						
						unpacked.typeOfAddressing = 1;
						int limit = token.indexOf(")");
						unpacked.register = Integer.parseInt(token.substring(2, limit));
						location += 2;
						
						// indirect register addressing with displacement (for example: ADD (R4)4)
						if (limit < token.length() - 1) {
							unpacked.typeOfAddressing = 4;
							int temp = Integer.parseInt(token.substring(limit + 1));
							unpacked.high = temp >> 8;
							unpacked.low = temp & 0xFF;
							location += 2;
						}
						
					// PC relative addressing with displacement (for example: ADD (PC)4)	
					} else if (token.substring(1, 3).equals("PC") || token.substring(1, 3).equals("pc")) {
						
						unpacked.typeOfAddressing = 6;
						int limit = token.indexOf(")");
						unpacked.low = Integer.parseInt(token.substring(limit + 1));
						location += 4;
						
					// indirect memory addressing
					} else if (token.charAt(1) >= '0' && token.charAt(1) <= '9') {
						
						unpacked.typeOfAddressing = 3;
						int hloc = token.indexOf('h');
						if (hloc != -1) {
							token = token.substring(0, hloc);
						}
						int limit = token.indexOf(')');
						int temp = Integer.parseInt(token.substring(1, limit));
						unpacked.high = temp >> 8;
						unpacked.low = temp & 0xFF;
						location += 4;
					} else {
						throw new BadInstruction(line);
					}
					
				// direct memory addressing
				} else if (token.charAt(0) >= '0' && token.charAt(0) <= '9') {
					
					unpacked.typeOfAddressing = 2;
					int hloc = token.indexOf('h');
					if (hloc != -1) {
						token = token.substring(0, hloc);
					}
					int temp = Integer.parseInt(token);
					unpacked.high = temp >> 8;
					unpacked.low = temp & 0xFF;
					location += 4;
					
				// base-index addressing with displacement
				} else if (token.charAt(0) == '[' && ((token.charAt(1) == 'R') || (token.charAt(1) == 'r'))) {
					
					unpacked.typeOfAddressing = 5;
					int limit = token.indexOf("]");
					unpacked.register = Integer.parseInt(token.substring(2, limit));
					int temp = Integer.parseInt(token.substring(limit + 1));
					unpacked.high = temp >> 8;
					unpacked.low = temp & 0xFF;
					location += 4;
				} else {
					throw new BadInstruction(line);
				}
				unpackedSource.add(unpacked);
				lineOfCode = readSourceLine();
			}
		}
	}

	private void secondPass() {
		for (UnpackedLine line : unpackedSource) {
			
			Instruction ins = line.instruction;
			int first = 0;
			first |= (ins.group & 0x7) << 3;
			first |= (ins.opcode & 0x7);
			code.add(first);
			
			// patching unpacked line if needed
			if (line.needPatching) {
				int temp = labels.get(line.label);
				
				// branch conditional instructions
				if (ins.group == 2 || ins.group == 3) {
					line.low += temp;
				}
				
				// branch unconditional instructions
				if (ins.group == 1 && (ins.opcode == 1 || ins.opcode == 2)) {
					line.high = temp >> 8;
					line.low = temp & 0xFF;
				}
			}
			
			// branch conditional instructions and INT
			if (ins.group == 2 || ins.group == 3 || (ins.group == 1 && ins.opcode == 4)) {
				code.add(line.low);
			}
			
			// branch unconditional instructions
			if (ins.group == 1 && (ins.opcode == 1 || ins.opcode == 2)) {
				code.add(line.high);
				code.add(line.low);
			}
			
			// addressing instructions
			if (ins.group == 4 && (ins.opcode >= 0 && ins.opcode <= 3)
				|| ins.group == 6 && (ins.opcode != 2 && ins.opcode != 3 && ins.opcode != 7)) {
				
				int second = 0;
				second |= (line.typeOfAddressing & 0x7) << 5;
				second |= (line.register & 0x1F);
				code.add(second);
				if (line.typeOfAddressing != 0 && line.typeOfAddressing != 1) {
					code.add(line.high);
					if (line.typeOfAddressing != 7 || (line.typeOfAddressing == 7 && ins.group == 4 && ins.opcode == 1)) {
						code.add(line.low);
					}
				}
			}
		}
	}
}
