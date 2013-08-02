package sim.components;

public class JKFF extends LogicalComponent {
	private Pin E;
	private Pin clear;
	private boolean init;

	public JKFF() {
		super(2, 2, true);
		addSequentialComponent(this);

	}

	public void func() {
		if ((E!=null)&&(!E.getBoolVal())) {
			return;
		}
		if ((clear!=null)&&(clear.getBoolVal())) {
			out[0].setBoolVal(false,false);
			out[1].setBoolVal(true, false);
			return;
		}
		//JKFF func: J(!Q)+kQ
		out[0].setBoolVal((in[0].getBoolVal() && out[1].getBoolVal()) || ((!in[1].getBoolVal()) && (out[0].getBoolVal())),false);
		out[1].setBoolVal(!out[0].getBoolVal(),false);

	}

	public void setPinK(Pin r){
		setInputPin(1, r);
	}

	public void setPinJ(Pin s) {
		setInputPin(0, s);
	}

	public void setPinClear(Pin clir) {
		this.clear = clir;
		clir.addChild(this);
	}

	public void setPinE(Pin e) {
		this.E = e;
	}
	public void init(){
		out[0].setBoolVal(init,false);
		out[1].setBoolVal(!init,false);
	}
	public void setInit(boolean init){
		this.init=init;
	}

}
