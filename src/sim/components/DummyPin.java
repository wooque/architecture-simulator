package sim.components;

public class DummyPin extends LogicalComponent {
	
	public static final DummyPin TRUE = new DummyPin();
	public static final DummyPin FALSE = new DummyPin();
	public static final DummyPin ZERO = new DummyPin();
	
	static {
		TRUE.setOutputPin(0, Pin.TRUE);
		FALSE.setOutputPin(0, Pin.FALSE);
		ZERO.setOutputPin(0, Pin.ZERO);
	}
	
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
