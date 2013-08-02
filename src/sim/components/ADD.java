package sim.components;


public class ADD extends LogicalComponent {

	public ADD() {
		this(2);
	}

	public ADD(int in) {
		super(in, 1, false);
	}

	public void setPinA(Pin pin) {
		setInputPin(0, pin);
	}

	public void setPinB(Pin pin){
		setInputPin(1, pin);
	}

	public void func() {
		int A = 0;
		int B = 0;
		if (in[0].isBool()) {
			for (int i = 0; i < in.length; i++) {
				if (in[i].isBool())
					A = (int) (A + Math.pow(2.0D, i));
				if (!in[(i + in.length / 2)].isBool())
					continue;
				B = (int) (B + Math.pow(2.0D, i));
			}
		} else {
			A = this.in[0].getIntVal();
			B = this.in[1].getIntVal();
		}

		int result = A + B;
		int max = (int) (Math.pow(2.0D, out[0].getNumOfLines()) - 1.0D);
		if (result > max)
			result -= max + 1;
		out[0].setIntVal(result);
		return;
	}

}
