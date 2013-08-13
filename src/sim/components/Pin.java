package sim.components;

import java.util.ArrayList;

public class Pin { // Izmene:prvi konstruktor Pin ne prima argumente jer to
					// ostalo od ranije
					// signalAll->stavljeno not(isSeq)
	public static final Pin TRUE = new Pin(true);
	public static final Pin FALSE = new Pin(false);
	public static final Pin HIGHZ = new Pin();
	private int intVal;
	private boolean boolVal;
	private int tempIntVal;
	private boolean tempBoolVal;
	private boolean isBool;
	private int numOfLines;
	private boolean highZ;
	private boolean tempHighZ;
	//uklonjen forcedFlush, nema potreba, umesto uslova forcedFlush==true, globalClock==0
	//ekvivalentni jer je forcedFlush==true za globalClock==0
	//potrebno samo u prvom kloku

	private ArrayList<LogicalComponent> children = new ArrayList<LogicalComponent>();

	static {
		HIGHZ.setHighZ(true);
	}
	
	public Pin() {

		boolVal = false;
		isBool = true;
		intVal = 0;
		numOfLines = 1;
		highZ = false;
	}

	public Pin(boolean val) {
		boolVal = val;
		isBool = true;
		intVal = 0;
		numOfLines = 1;
		highZ = false;
	}

	public Pin(int val, int brlin) {
		intVal = val;
		isBool = false;
		boolVal = false;
		numOfLines = brlin;
		highZ = false;

	}

	public void clear() {
        if(boolVal==true || intVal!=0 || LogicalComponent.globalClock==0){
			boolVal = false;
            intVal = 0;
            signalAll();
		}
	}

	public void clear(boolean autoFlush) {
        if(boolVal==true || intVal!=0 || (LogicalComponent.globalClock==0)){
			if (autoFlush) {
				boolVal = false;
				intVal = 0;
				signalAll();
			}
			else{
				tempBoolVal=false;
				tempIntVal=0;
			}
        }
	}

	public boolean isBool() {
		return isBool;
	}

	public void setIsInt() {
		isBool = false;
	}
	public void setIsBool() {
		isBool = true;
	}

	public void setBoolVal(boolean bval) {
		if (isBool) {	
			if ((boolVal != bval)||(highZ==true)||(LogicalComponent.globalClock==0)) {
				this.boolVal = bval;
				this.highZ=false;
				signalAll();
			}
		}
	}

	public void setBoolVal(boolean bval, boolean autoFlush) {
		if (isBool) {
			if ((boolVal != bval) ||(highZ==true)|| (LogicalComponent.globalClock==0)) {
				if (autoFlush) {
					this.boolVal = bval;
					this.highZ=false;
					signalAll();
				}
				else{
					tempBoolVal=bval;
					tempHighZ=false;
				}
			}
		}
	}

	public boolean getBoolVal() {
		return boolVal;
	}

	public int getIntVal() {
		return intVal;
	}

	public void setIntVal(int ival) {
		if (!isBool) {
			if ((intVal != ival)||(highZ==true)||(LogicalComponent.globalClock==0)) {
				this.intVal = ival;	
				this.highZ = false;
				signalAll();
			}
		}
	}

	public void setIntVal(int ival, boolean autoFlush) {
		if (!isBool) {
			if ((intVal != ival)||(highZ==true)||(LogicalComponent.globalClock==0)) {
				if (autoFlush){
					this.intVal = ival;
					this.highZ = false;
					signalAll();
				}
				else{
					tempIntVal=ival;
					tempHighZ=false;
				}
			}
		}
	}

	public int getNumOfLines() {
		return numOfLines;
	}

	public void setNumOfLines(int numOfLines) {
		this.numOfLines = numOfLines;
	}

	public boolean isHighZ() {
		return highZ;
	}

	public void setHighZ(boolean highZboolValue) {

		if ((highZ != highZboolValue)||(LogicalComponent.globalClock==0)) {
			this.highZ = highZboolValue;
			signalAll();
		}
	}

	public void setHighZ(boolean highZboolValue, boolean autoFlush) {

		if ((highZ != highZboolValue)||(LogicalComponent.globalClock==0)) {
			if (autoFlush){
				this.highZ = highZboolValue;
				signalAll();	
			}
			else{
				tempHighZ=highZboolValue;
			}
		}
	}
	
	public void flush() {
		boolVal=tempBoolVal;
		intVal=tempIntVal;
		highZ=tempHighZ;
		signalAll();

	}

	void addChild(LogicalComponent logcomp) {
		children.add(logcomp);
	}

	void signalAll() {
        LogicalComponent child = null;
        for(int i=0;i<children.size();i++){
            child=children.get(i);
			if (!child.isSeq())
				child.clockedFunc();
			if(child instanceof Registers)
				((Registers) child).read();
		}
	}
}
