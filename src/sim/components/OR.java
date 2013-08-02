package sim.components;

public class OR extends LogicalComponent {

	public OR() {
		this(2);
	}

	public OR(int in) {
		super(in, 1, false);
	}

	public void func() {

		boolean result = false;
		for (int i = 0; i < in.length; i++)
			result = (result) || (in[i].getBoolVal());
		out[0].setBoolVal(result);
	}

}
