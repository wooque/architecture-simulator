package sim.assembler;

public class Disassembler {
	
	private static String[][] instructions = {
		{"nop",		"halt",  	null,   	null,    	"intd",  	"inte",   	null,    	null},
		{null,		"jmp",   	"jsr",  	"rts",   	"int",   	"rti",    	null,    	null},
		{"beql",	"bneql", 	"bneg", 	"bnneg", 	"bovf",  	"bnovf",  	"bcar",  	"bncar"},
		{"bgrt",	"bgrte", 	"blss", 	"blsse", 	"bgrtu", 	"bgrteu",	"blssu", 	"blsseu"},
		{"ldb",		"ldw",   	"stb",  	"stw",   	"popb", 	"popw",   	"pushb", 	"pushw"},
		{"ldivtp",	"stivtp",	"ldimr", 	"stimr", 	"ldsp", 	"stsp", 	null,   	null},
		{"add",		"sub", 		"inc", 		"dec", 		"and",		"or",		"xor",		"not"},
		{"asr",		"lsr",		"ror",		"rorc",		"asl",		"lsl",		"rol",		"rolc"}
		};
	
	public Disassembler(Object[] code, int startOfCode) {
		for (int i = 0; i < code.length; ) {
			int ins = (Integer)code[i++];
			int group = (ins & 0x38)>>3;
			int opcode = ins & 0x7;
			System.out.print((startOfCode + i - 1)+": "+instructions[group][opcode]+" ");
			
			if (group == 0
				|| group == 1 && (opcode == 3 || opcode == 5)
				|| group == 4 && (opcode >= 4 && opcode <= 7)
				|| group == 5
				|| group == 6 && (opcode == 2 || opcode == 3 || opcode == 7)
				|| group == 7) {
					
				System.out.println();	
			}
			
			if (group == 2 || group == 3 || (group == 0 && opcode == 4)) {
				System.out.println((Integer)code[i++]);
			}
			
			if (group == 1 && (opcode == 1 || opcode == 2)) {
				
				int disp = ((Integer)code[i++] << 8);
				disp |= (Integer)code[i++];
				System.out.println(disp);
			}
			
			if (group == 4 && (opcode >= 0 && opcode <= 3)
				|| group == 6 && (opcode != 2 && opcode != 3 && opcode != 7)) {
				
				int secondByte = (Integer)code[i++];
				int typeOfAddressing = (secondByte & 0xE0) >> 5;
				int register = secondByte & 0x1F;
				
				if (typeOfAddressing == 0) {
					
					System.out.println("r"+register);
					
				} else if (typeOfAddressing == 1) {
					
					System.out.println("(r"+register+")");
					
				} else if (typeOfAddressing == 2) {
					
					int mem = ((Integer)code[i++] << 8);
					mem |= (Integer)code[i++];
					System.out.println(mem);
					
				} else if (typeOfAddressing == 3) {
					
					int mem = ((Integer)code[i++] << 8);
					mem |= (Integer)code[i++];
					System.out.println("("+mem+")");
					
				} else if (typeOfAddressing == 4) {
					
					int disp = ((Integer)code[i++] << 8);
					disp |= (Integer)code[i++];
					System.out.println("(r"+register+")"+disp);
					
				} else if (typeOfAddressing == 5) {
					
					int disp = ((Integer)code[i++] << 8);
					disp |= (Integer)code[i++];
					System.out.println("[r"+register+"]"+disp);
					
				} else if (typeOfAddressing == 6) {
					
					int disp = ((Integer)code[i++] << 8);
					disp |= (Integer)code[i++];
					System.out.println("(pc)"+disp);
					
				} else if (typeOfAddressing == 7) {
					
					int disp;
					if (group == 4 && opcode == 1) {
						disp = ((Integer)code[i++] << 8);
						disp |= (Integer)code[i++];
					} else {
						disp = (Integer)code[i++];
					}
					System.out.println("#"+disp);
				}
			}
		}
	}
}
