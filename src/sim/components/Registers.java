package sim.components;

public class Registers extends LogicalComponent {

	private Pin read;
	private Pin write;
	private int[] regs;

	public Registers(int numOfRegisters, int sizeOfRegister) {
		super(2, 1, true);
		out[0].setIsInt();
		out[0].setNumOfLines(sizeOfRegister);
		regs = new int[numOfRegisters];
		for(int i = 0; i < numOfRegisters; i++) {
			regs[i] = 0;
		}
		addSequentialComponent(this);
	}

	public void func() {
		if(write.getBoolVal()) {
			regs[in[0].getIntVal()] = in[1].getIntVal();
		}
	}
	
	public void read() {
		if(read.getBoolVal()) {
			out[0].setIntVal(regs[in[0].getIntVal()], false);
		}
	}

	public void clear() {
		for(int i = 0; i < regs.length; i++) {
			regs[i] = 0;
		}
	}

	public int getSize() {
		return regs.length;
	}

	public void setRead(Pin read) {
		this.read = read;
		read.addChild(this);
	}

	public void setWrite(Pin write) {
		this.write = write;
		write.addChild(this);
	}
	
	public int getRegValue(int index) {
		return regs[index];
	}

}
