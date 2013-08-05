package sim;

import sim.components.*;

public class Test {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		Configurator config = new Configurator("schemes.conf");
		Debugger debug = new Debugger(config, "debug.txt");
		
		Assembler asm = new Assembler("test.txt");
		Object[] code = asm.getCode();
		int start = asm.getStartOfCode();
		MEM mem = ((MEM)config.getComponents().get("mem_oper.mem"));
		for(int i = 0; i < code.length; i++) {
			mem.write(start + i, (Integer)code[i]);
		}
		REG pc = ((REG)config.getComponents().get("fetch1.pc"));
		pc.initVal(start);
		LogicalComponent.initMemory = false;
		LogicalComponent.initialise();
		for(int i = 0; i < 1000; i++) {
			debug.debug();
			LogicalComponent.CLK();
		}
		long end = System.currentTimeMillis();
		System.out.println("Test took "+(end - begin)+" ms");
	}
}
