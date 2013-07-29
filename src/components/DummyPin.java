package components;

public class DummyPin extends LogicalComponent {
	
	private boolean value;
	
	public DummyPin(boolean value) {
		super(0, 1, false);
		this.value = value;
	}

	public void func() {
		out[0].setBoolVal(value);
	}

}
