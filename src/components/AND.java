package components;

public class AND extends LogicalComponent {

	public AND() {
		this(2);
	}

	public AND(int in) {
		super(in, 1, false);
	}

	public void func() {
		boolean result = true;
		for (int i = 0; i < in.length; i++)
			result = (result) && (in[i].getBoolVal());
		out[0].setBoolVal(result);
	}
}
