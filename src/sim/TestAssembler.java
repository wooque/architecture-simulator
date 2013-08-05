package sim;

public class TestAssembler {

	public static void main(String[] args) {
		
		Assembler asm = new Assembler("test.txt");
		new Disassembler(asm.getCode());
	}
}
