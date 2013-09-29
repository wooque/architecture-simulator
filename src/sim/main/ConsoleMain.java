package sim.main;

import sim.Configurator;
import sim.Debugger;
import sim.assembler.Assembler;
import sim.components.*;

public class ConsoleMain {

	public static void main(String[] args) {
		
		if(args.length != 4) {
			System.out.println("Wrong number of arguments");
		}
		
		int numOfCLKs = 0;
		try {
			numOfCLKs = Integer.parseInt(args[2]);
		} catch (NumberFormatException nfe) {
			System.out.println("Number of clocks is not valid!");
		}
		if(numOfCLKs <= 0) {
			System.out.println("Number of clocks is not valid!");
		}
		
		long begin = System.currentTimeMillis();
		
		Configurator config = new Configurator(args[0], null);
		Debugger debug = new Debugger(config, args[3]);
		
		if(!args[1].equals("null")) {
			Assembler asm = new Assembler(args[1], null);
			Object[] code = asm.getCode();
			int start = asm.getStartOfCode();
			MEM mem = ((MEM)config.getComponents().get("mem_oper.mem"));
			if(mem != null) {
				for(int i = 0; i < code.length; i++) {
					mem.write(start + i, (Integer)code[i]);
				}
			}
			REG pc = ((REG)config.getComponents().get("fetch1.pc"));
			if(pc != null) {
				pc.initVal(start);
			}
		}
		
		LogicalComponent.initMemory = false;
		LogicalComponent.initialise();
		for(int i = 0; i < numOfCLKs; i++) {
			debug.debug();
			LogicalComponent.CLK();
		}
		
		Registers regs = (Registers) config.getComponents().get("addr.gpr");
		if(regs != null) {
			for(int i = 0; i < regs.getSize(); i++) {
				if(regs.getRegValue(i) != 0) {
					System.out.println("r"+i+" is: "+regs.getRegValue(i));
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Test took "+(end - begin)+" ms");
	}
}
