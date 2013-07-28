package components;

public class Adapter extends LogicalComponent {

	private boolean mTos;
	private boolean mTom;

	public Adapter(int in, int out) {
		super(in, out, false);
		if (in == 1) {
			this.mTos = true;
		} else if (out == 1)
			this.mTos = false;
		else
			System.out.println("Error!!! Bad adapter arguments...");
	}

	public void func() {
		if (mTos) {				//IntToArrayBool
			int mval = in[0].getIntVal();
			if (mval > 0) {			//Int>0
				for (int j = 0; j < out.length; j++) {
					int mod = mval % 2;
					mval /= 2;
					out[j].setBoolVal(mod == 1);
				}
			} else {
				mval = (int) Math.pow(2.0D, out.length) + mval;
				for (int j = 0; j < out.length; j++) {
					int mod = mval % 2;
					mval /= 2;
					out[j].setBoolVal(mod == 1);
				}
			}
		} else if (!mTom) {
			int val = 0;
			for (int i = 0; i < in.length; i++) {
				if (in[i].getBoolVal())
					val = (int) (val + Math.pow(2.0D, i));
				else if (!in[i].getBoolVal()) {
					val = (int) (val + in[i].getIntVal()* Math.pow(2.0D, i * in[0].getNumOfLines()));
				}
			}
			out[0].setIntVal(val);
		} else {
			int val = 0;
			String b = "";
			for (int i = 0; i < in.length; i++) {
				int temp = 0;
				if (in[i].isBool()) {
					if (in[i].getBoolVal())
						temp = 1;
					else {
						temp = 0;
					}

				} else if (in[i].getIntVal() >= 0)
					temp = in[i].getIntVal();
				else {
					temp = (int) (Math.pow(2.0D, in[i].getNumOfLines()) + in[i]
							.getIntVal());
				}
				String tb = Integer.toBinaryString(temp);
				while (tb.length() < in[i].getNumOfLines())
					tb = 0 + tb;
				b = tb + b;
			}

			for (int j = 0; j < b.length(); j++)
				try {
					val = (int) (val + Math.pow(2.0D, j)* toInt(b.substring(b.length() - j - 1, b.length()- j)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			out[0].setIntVal(val);

		}
	}

	private int toInt(String string) throws Exception {
		int ret = 0;
		try {
			ret = Integer.parseInt(string);
		} catch (NumberFormatException e) {
			char c = string.charAt(0);
			switch (c) {
			case 'A':
			case 'a':
				ret = 10;
				break;
			case 'B':
			case 'b':
				ret = 11;
				break;
			case 'C':
			case 'c':
				ret = 12;
				break;
			case 'D':
			case 'd':
				ret = 13;
				break;
			case 'E':
			case 'e':
				ret = 14;
				break;
			case 'F':
			case 'f':
				ret = 15;
				break;

			default:

				throw new Exception("Nesto nevalja sa brojevima");
			}
			return ret;
		}
		return ret;
	}

	public boolean isMTom() {
		return this.mTom;
	}

	public void setMTom(boolean tom) {
		this.mTom = tom;
	}

}
