package sim.assembler;


public class Test {

	public static void main(String[] args) {
		
		Assembler asm = new Assembler("asm/test2.asm");
		new Disassembler(asm.getCode(), asm.getStartOfCode());
	}
}