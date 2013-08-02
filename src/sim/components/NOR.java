package sim.components;

public class NOR extends LogicalComponent {

	public NOR() {
		this(2);
	}

	public NOR(int in) {
		super(in, 1, false);
	}

	public void func() {

		boolean result = false;
		for (int i = 0; i < in.length; i++)
			result = (result) || (in[i].getBoolVal());
		result = !result;
		out[0].setBoolVal(result);

	}

}
