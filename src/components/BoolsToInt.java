package components;

public class BoolsToInt extends LogicalComponent {

	public BoolsToInt(int in, int NumLines) {
		super(in, 1, false);
		out[0].setIsInt();
		out[0].setNumOfLines(NumLines);

	}

	public void func() {
		int val = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i].getBoolVal())
				val = (int) (val + Math.pow(2.0D, i));

		}

		out[0].setIntVal(val);

	}

}
