package sim.components;

public class XOR extends LogicalComponent {

	public XOR() {
		this(2);
	}

	public XOR(int pinin) {
		super(pinin, 1, false);
	}

	public void func() {

		boolean result = in[0].getBoolVal() ^ in[1].getBoolVal();
		for (int i = 2; i < in.length; i++) {
			result ^= in[i].getBoolVal();
		}

		out[0].setBoolVal(result);

	}

}
