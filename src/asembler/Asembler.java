package asembler;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;



public class Asembler {

	//structure for one unpacked line of source code
	private class unpackedLine {

		int jumpOrOther; // 0 - jump, 1 - other
		int typeOfInstruction; // for jump: 0-conditional, 1 -unconditional
								// for others: 0-nonaddressing, 1-addressing
		int opcode;
		int typeOfAddressing;
		int register;
		int disp1;	//Displacement, if displacement 8-bit
					//higher byte of displacement, if displacement 16-bit
					//8-bit data if addressing immediate
		int disp2;	//lower byte of displacement if displacement 16-bit
		boolean needPatching;	//flag, shows that line needs patching, 
								//because label is not known in first pass
		String label; //label used in instruction that is not known in first pass
	}
	
	private BufferedReader read;
	private HashMap<String, Integer> labels;	//all labels with their location in code
	private ArrayList<unpackedLine> unpackedSource;	//all unpacked lines of source code
	private int[] code;	//code
	private int length=0;
	private int startOfCode=256;

	//method for assembling, argument is filename of file with assembly code
	//return array of int of coded instruction
	public void asembly(String asmcode) {
		
		length=0;
		StringReader strread=new StringReader(asmcode);
		read=new BufferedReader(strread);
		unpackedSource=new ArrayList<unpackedLine>();
		labels=new HashMap<String, Integer>();
		code = new int[1000];
		firstPass();
		secondPass();
		//loadInMemory();
	}

	public int getLength() {
		return length;
	}
	//first pass
	private void firstPass() {
		try {

			int location = 0;	//location in code

			String lineOfCode = read.readLine(); //one line of source code

			while (lineOfCode!=null) {

				StringTokenizer tokenizer = new StringTokenizer(lineOfCode);
				String token = tokenizer.nextToken();	//one token
				unpackedLine unpacked = new unpackedLine();	//one line of unpacked source
				
				//if token is label, for example "lab:"
				if (token.indexOf(':') != -1) {
					labels.put(token.substring(0, token.indexOf(':')), new Integer(location));
					token = tokenizer.nextToken();
				}
				//which instruction is token
				if (token.equalsIgnoreCase("ORG")) {
					startOfCode=Integer.parseInt(tokenizer.nextToken());
					location=startOfCode;
					lineOfCode=read.readLine();
					continue;
				}
				if (token.equalsIgnoreCase("RTS")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 0;
				}
				if (token.equalsIgnoreCase("RTI")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 1;
				}
				if (token.equalsIgnoreCase("ASR")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 2;
				}
				if (token.equalsIgnoreCase("LSR")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 3;
				}
				if (token.equalsIgnoreCase("ROR")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 4;

				}
				if (token.equalsIgnoreCase("RORC")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 5;

				}
				if (token.equalsIgnoreCase("ASL")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 6;

				}
				if (token.equalsIgnoreCase("LSL")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 7;

				}
				if (token.equalsIgnoreCase("ROL")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 8;

				}
				if (token.equalsIgnoreCase("ROLC")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 9;

				}
				if (token.equalsIgnoreCase("INTE")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 10;

				}
				if (token.equalsIgnoreCase("INTD")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 11;

				}
				if (token.equalsIgnoreCase("TRPE")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 12;

				}
				if (token.equalsIgnoreCase("TRPD")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 13;

				}
				if (token.equalsIgnoreCase("STIVTP")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 14;

				}
				if (token.equalsIgnoreCase("STSP")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 15;

				}
				if (token.equalsIgnoreCase("NOP")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 16;

				}
				if (token.equalsIgnoreCase("HALT")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 17;

				}
				if (token.equalsIgnoreCase("BEQL")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 0;
				}
				if (token.equalsIgnoreCase("BNEQ")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 1;
				}
				if (token.equalsIgnoreCase("BNEG")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 2;
				}
				if (token.equalsIgnoreCase("BNNG")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 3;
				}
				if (token.equalsIgnoreCase("BOVF")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 4;
				}
				if (token.equalsIgnoreCase("BNVF")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 5;
				}
				if (token.equalsIgnoreCase("BCR")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 6;
				}
				if (token.equalsIgnoreCase("BNCR")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 7;
				}
				if (token.equalsIgnoreCase("BGRT")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 8;
				}
				if (token.equalsIgnoreCase("BGRE")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 9;
				}
				if (token.equalsIgnoreCase("BLSS")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 10;
				}
				if (token.equalsIgnoreCase("BLEQ")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 11;
				}
				if (token.equalsIgnoreCase("BGTRU")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 12;
				}
				if (token.equalsIgnoreCase("BGREU")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 13;
				}
				if (token.equalsIgnoreCase("BLSSU")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 14;
				}
				if (token.equalsIgnoreCase("BLEQU")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 0;
					unpacked.opcode = 15;
				}
				if (token.equalsIgnoreCase("JMP")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 0;
				}
				if (token.equalsIgnoreCase("JSR")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 1;
				}
				if (token.equalsIgnoreCase("INT")) {
					unpacked.jumpOrOther = 0;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 2;
				}
				if (token.equalsIgnoreCase("LD")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 0;
				}
				if (token.equalsIgnoreCase("LDW")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 1;
				}
				if (token.equalsIgnoreCase("ST")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 2;
				}
				if (token.equalsIgnoreCase("STW")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 3;
				}
				if (token.equalsIgnoreCase("ADD")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 4;
				}
				if (token.equalsIgnoreCase("SUB")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 5;
				}
				if (token.equalsIgnoreCase("AND")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 6;
				}
				if (token.equalsIgnoreCase("OR")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 7;
				}
				if (token.equalsIgnoreCase("XOR")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 8;
				}
				if (token.equalsIgnoreCase("NOT")) {
					unpacked.jumpOrOther = 1;
					unpacked.typeOfInstruction = 1;
					unpacked.opcode = 9;
				}
				//none addressing instructions
				if ((unpacked.jumpOrOther == 1)&& (unpacked.typeOfInstruction == 0)) {
					location++;
					unpackedSource.add(unpacked);
					lineOfCode = read.readLine();
					continue;
				}
				//branch conditional instructions
				if ((unpacked.jumpOrOther == 0)&& (unpacked.typeOfInstruction == 0)) {
					token = tokenizer.nextToken();
					
					if (token.charAt(0) == '#') {	//immediate displacement, for example #3
						unpacked.disp1 = Integer.parseInt(token.substring(1));
					} else {	//label, displacement needs calculating
						if (labels.containsKey(token)) {
							unpacked.disp1 = labels.get(token)-location-2;
						} else {
							unpacked.disp1 = -location-2;
							unpacked.label = token;
							unpacked.needPatching = true;
						}
					}
					location+=2;
					unpackedSource.add(unpacked);
					lineOfCode = read.readLine();
					continue;
				}
				//branch unconditional instructions
				if ((unpacked.jumpOrOther == 0)&& (unpacked.typeOfInstruction == 1)) {
					token = tokenizer.nextToken();
					if (token.charAt(0) == '#') {	//immediate displacement, for example #3
						int temp = Integer.parseInt(token.substring(1));
						if(unpacked.opcode!=2){
							unpacked.disp1 = temp >> 8;
							unpacked.disp2 = temp & 0xFF;
						}
						else{
							unpacked.disp1=temp;
						}
					} else {	//label, displacement needs calculating
						///
						///  Mislim da ovde treba promeniti nesto
						///
						if (labels.containsKey(token)) {
							unpacked.disp1 = labels.get(token)>>8;
							unpacked.disp2 = labels.get(token)&0xFF;
						} else {
							unpacked.disp1 = 0;
							unpacked.label = token;
							unpacked.needPatching = true;
						}
					}
					location += 3;
					unpackedSource.add(unpacked);
					lineOfCode = read.readLine();
					continue;
				}
				//addressing instructions
				if ((unpacked.jumpOrOther == 1)&& (unpacked.typeOfInstruction == 1)&&(unpacked.opcode!=9)) {
					token = tokenizer.nextToken();
					if (token.charAt(0) == '#') { //immediate addressing
						unpacked.typeOfAddressing = 3;
						unpacked.disp1 = Integer.parseInt(token.substring(1));
						location += 3;
					} else if ((token.charAt(0) == 'R')|| (token.charAt(0) == 'r')) { //direct register addressing 
						unpacked.typeOfAddressing = 0;
						unpacked.register = Integer.parseInt(token.substring(1));
						location += 2;
					} else if (token.charAt(0) == '(') { //indirect addressing
						if ((token.charAt(1) == 'R') || (token.charAt(1) == 'r')) { 
							//indirect register addressing  with displacement, for example ADD (R4)4
							unpacked.typeOfAddressing = 1;
							int limit = token.indexOf(")");
							unpacked.register = Integer.parseInt(token.substring(2, limit));
							int temp = Integer.parseInt(token.substring(limit + 1));
							unpacked.disp1 = temp >> 8;
							unpacked.disp2 = temp & 0xFF;
							location += 4;
						} else if ((token.charAt(1) == 'P') || (token.charAt(1) == 'p')) {
							//PC relative addressing, for example ADD (PC)4
							unpacked.typeOfAddressing = 2;
							int limit = token.indexOf(")");
							unpacked.disp1 = Integer.parseInt(token.substring(limit + 1));
							location += 3;
						} else
							System.out.println("Error!!! Wrong addressing...");
					} else
						System.out.println("Error!!! Wrong addressing...");
					unpackedSource.add(unpacked);
					lineOfCode = read.readLine();
				}
				if ((unpacked.jumpOrOther == 1)&& (unpacked.typeOfInstruction == 1)&&(unpacked.opcode==9)){
					unpacked.typeOfAddressing = 0;
					location += 2;
					unpackedSource.add(unpacked);
					lineOfCode = read.readLine();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//second pass
	private void secondPass() {
		for (unpackedLine line : unpackedSource) {
			int first = 0;	//first byte of instruction
			first |= (line.jumpOrOther & 0x1) << 7;
			first |= (line.typeOfInstruction & 0x1) << 6;
			first |= (line.opcode & 0x1F);
			code[length++] = first;
			if (line.needPatching) {	//patching unpacked line if needed
				int temp = labels.get(line.label);
				//branch conditional instructions
				if ((line.jumpOrOther == 0) && (line.typeOfInstruction == 0)) {
					line.disp1 += temp;
				}
				//branch unconditional instructions
				if ((line.jumpOrOther == 0) && (line.typeOfInstruction == 1)) {
					line.disp1 = temp >> 8;
					line.disp2 = temp & 0xFF;
				}
			}
			//branch conditional instructions
			if ((line.jumpOrOther == 0) && (line.typeOfInstruction == 0)) {
				code[length++] = line.disp1;
			}
			//branch unconditional instructions
			if ((line.jumpOrOther == 0) && (line.typeOfInstruction == 1)) {
				if(line.opcode!=2){
					code[length++] = line.disp1;
					code[length++] = line.disp2;
				}
				else{
					code[length++] = line.disp1;
				}
			}
			//addressing instructions
			if ((line.jumpOrOther == 1) && (line.typeOfInstruction == 1)&&(line.opcode!=9)) {
				int second = 0; //second byte with type of addressing and register if used
				second |= (line.typeOfAddressing & 0x3) << 6;
				second |= (line.register & 0x1F);
				code[length++] = second;
				if (line.typeOfAddressing != 0) {
					code[length++] = line.disp1;
					if (line.typeOfAddressing == 1)
						code[length++] = line.disp2;
				}
			}
				
		}
	}
//	private void loadInMemory(){
//		for(int i=0;i<length;i++){
//			Mem11.writeMEM(startOfCode+i, code[i]);
//		}
//		Fetch1.PC.initVal(startOfCode);
//	}
}
