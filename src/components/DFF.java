package components;

public class DFF extends LogicalComponent {
	private Pin E;
	private Pin clear;
	private boolean init=false;

	public DFF() {
		super(1, 2, true);
		addSequentialComponent(this);

	}

	public void func() {
		if ((E!=null)&&(!E.getBoolVal())) {
			return;
		}
		if ((clear!=null)&&(clear.getBoolVal())) {
			out[0].setBoolVal(false,false);
			out[1].setBoolVal(true,false);
			return;
		}

		out[0].setBoolVal(in[0].getBoolVal(),false);
		out[1].setBoolVal(!in[0].getBoolVal(),false);
	}

	public void setPinD(Pin d) {
		setInputPin(0, d);
	}

	public void setPinClear(Pin clir) {
		this.clear = clir;
		clir.addChild(this);
	}

	public void setPinE(Pin e) {
		this.E = e;
		e.addChild(this);
	}
	public void init(){
		out[0].setBoolVal(init,false);
		out[1].setBoolVal(!init,false);
	}
	public void setInit(boolean init){
		this.init=init;
	}

}
