package sim.components;

import java.util.ArrayList;

public class MEM extends LogicalComponent {
	private ArrayList<String> memory;
	private Pin read;
	private Pin write;
	private int size;

	public MEM(int size) {
		super(2, 1, true);
		out[0].setIsInt();
		//samo je jedan izlaz koji se postavlja da je INT
		
		this.size = size;
		memory = new ArrayList<String>(size);
		for (int i = 0; i < size; i++)
			memory.add("0");
		addSequentialComponent(this);
	}

	public void func() {
		if (write.getBoolVal()) {
			memory.set(in[0].getIntVal(), Integer.toString(in[1].getIntVal()));
		}

		if (read.getBoolVal()) {
			out[0].setIntVal(Integer.parseInt(memory.get(in[0].getIntVal())),false);
		}
	}
	
	// Dodato: Djole
	public void clear() {
		for (int i = 0; i < size; i++)
			memory.set(i,"0");
	}

	public int getSize() {
		return size;
	}

	public void setRead(Pin read) {
		this.read = read;
		read.addChild(this);
	}

	public void setWrite(Pin write) {
		this.write = write;
		write.addChild(this);
	}
	
	public void write(int adress,int data){
		memory.set(adress, Integer.toString(data));
	}
	
	public int read(int adress){
		return Integer.parseInt(memory.get(adress));
	}
	
	public void init(){
		if(initMemory)
			for (int i = 0; i < size; i++)
				memory.set(i,"0");
	}

}
