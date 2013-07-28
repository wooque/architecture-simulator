package components;

public class DC extends LogicalComponent {
	private Pin E;

	public DC(int in) {
		super(in, (int) Math.pow(2.0D, in), false);

	}

	public void setE(Pin e) {
		this.E = e;
		e.addChild(this);
	}

	public void func() {

		if ((E!=null)&&(!E.getBoolVal())) {
			for (int i = 0; i < out.length; i++) {
				out[i].clear();
			}
			return;
		}
		int index = 0;
		if (in[0].isBool()) {
			for (int i = 0; i < in.length; i++) {
				if (!in[i].getBoolVal())
					continue;
				index += (int) Math.pow(2.0D, i);
			}
		} else {
			index = in[0].getIntVal();
		}
		for (int i = 0; i < out.length; i++) {
			out[i].clear();
		}
		if (index < out.length)
			out[index].setBoolVal(true);
		return;
	}

	public Pin getE() {
		return E;
	}

}
