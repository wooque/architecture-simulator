package sim.components;

public class DummyPin extends LogicalComponent {
	
	public DummyPin() {
		super(1, 1, false);
	}
	
	public DummyPin(Pin in) {
		super(1, 1, false);
		setInputPin(0, in);
	}

	public void func() {
		out[0].setBoolVal(in[0].getBoolVal());
	}

}
