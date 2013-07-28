package components;

public class MP extends LogicalComponent {
	
	private Pin[] ctrl;
	private Pin E;

	public MP(int in) {
		super(in, 1, false);
		ctrl = new Pin[calcCtrlPins(in)];

	}

	public void setCtrl(Pin[] ctrl) {
		this.ctrl = ctrl;
		for(int i=0;i<ctrl.length;i++){
			ctrl[i].addChild(this);
		}
	}
	
	public void setCtrl(int index, Pin ctrl) {
		this.ctrl[index] = ctrl;
		ctrl.addChild(this);
	}

	public void setE(Pin e) {
		this.E = e;
		e.addChild(this);
	}

	private int calcCtrlPins(int in) {
		int ret = 0;
		while (in > 0) {
			in /= 2;
			if (in > 0)
				ret++;
		}
		return ret;
	}

	public void func() {
		if ((E!=null)&&(!E.getBoolVal())) {
			out[0].clear();
			return;
		}
		int index = 0;
		for (int i = 0; i < ctrl.length; i++) {
			if (!ctrl[i].getBoolVal())
				continue;
			index += (int) Math.pow(2.0D, i);
		}

		if (out[0].isBool()) {
			out[0].setBoolVal(in[index].getBoolVal());
		} else {

			out[0].setIntVal(in[index].getIntVal());
		}
	}
	
	public Pin getE() {
		return E;
	}
	
	public Pin[] getCtrl() {
		return ctrl;
	}
	
	public Pin getCtrl(int index) {
		return ctrl[index];
	}
}
