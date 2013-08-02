package sim.components;

public class RSFF extends LogicalComponent {
	private Pin E;
	private Pin clear;
	private String name;
	private boolean init;

	public RSFF(String name) {
		super(2, 2, true);
		this.name=name;
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

		if ((in[0].getBoolVal()) && (in[1].getBoolVal())) {
			System.out.println("Error!!! Unexpected RSFF  state..."+name);
			return;
		}
		out[0].setBoolVal((in[0].getBoolVal()) || ((!in[1].getBoolVal()) && (out[0].getBoolVal())),false);
		out[1].setBoolVal(!out[0].getBoolVal(),false);

	}
	
	public void setPinR(Pin r){
		setInputPin(1, r);
	}

	public void setPinS(Pin s) {
		setInputPin(0, s);
	}

	public void setPinClear(Pin clir) {
		this.clear = clir;
		clir.addChild(this);
	}

	public void setPinE(Pin e) {
		this.E = e;
	}

	public String getName() {
		return name;
	}
	public void init(){
		out[0].setBoolVal(init,false);
		out[1].setBoolVal(!init,false);
	}
	public void setInit(boolean init){
		this.init=init;
	}

}
