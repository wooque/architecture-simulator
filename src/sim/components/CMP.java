package sim.components;


public class CMP extends LogicalComponent {

	private Pin E;

	public void setE(Pin e) {
		this.E = e;
		e.addChild(this);
	}

	public Pin getE() {
		return E;
	}

	public CMP(int in) {
		super(in * 2, 3, false);

	}

	public void func() {
		if ((E!=null)&&(!E.getBoolVal())) {
			return;
		}

		int A = 0;
		int B = 0;
		if (in[0].isBool()) {
			for (int i = 0; i < in.length / 2; i++) {
				if (in[i].getBoolVal())
					A = (int) (A + Math.pow(2.0D, i));
				if (!in[(i + in.length / 2)].getBoolVal())
					continue;
				B = (int) (B + Math.pow(2.0D, i));
			}
		} else {
			A = in[0].getIntVal();
			B = in[1].getIntVal();
		}

		if (A > B) {
			out[0].setBoolVal(true);
			out[1].setBoolVal(false);
			out[2].setBoolVal(false);
		} else if (A < B) {
			out[0].setBoolVal(false);
			out[1].setBoolVal(false);
			out[2].setBoolVal(true);
		} else if (A == B) {
			out[0].setBoolVal(false);
			out[1].setBoolVal(true);
			out[2].setBoolVal(false);
		}
		return;
	}
	
	public Pin getEQL(){
		return out[1];
	}
	
	public Pin getGRT(){
		return out[0];
	}
	
	public Pin getLES(){
		return out[2];
	}

	public void setPinA(int index, Pin pin) {
		setInputPin(index, pin);
	}

	public void setPinB(int index, Pin pin) {
		setInputPin(index + in.length / 2, pin);
	}
}
