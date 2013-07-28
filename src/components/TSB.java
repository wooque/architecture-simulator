package components;

public class TSB extends LogicalComponent {
	
	private Pin ctrl;

	public TSB() {
		super(1, 1, false);
		out[0].setIsInt();
		out[0].setHighZ(true);
	}

	public void func() {
		if (((ctrl != null) && (ctrl.getBoolVal())) || (ctrl == null)) {
			if (in[0].isHighZ())
				
				if(out[0].isBool())out[0].setBoolVal(true);//dodato
				else out[0].setIntVal(1);
			
			else
				
				if(out[0].isBool())out[0].setBoolVal(in[0].getBoolVal());//dodato
				else out[0].setIntVal(in[0].getIntVal());
		
		} else {
			out[0].setHighZ(true);
			out[0].clear();
		}
	}

	public Pin getCtrl() {
		return ctrl;
	}

	public void setCtrl(Pin ctrl) {
		this.ctrl = ctrl;
		ctrl.addChild(this);
	}

}
