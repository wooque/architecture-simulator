package sim.components;

public class IntToBools extends LogicalComponent {

	public IntToBools(int NumLines, int out) {
		super(1, out, false);

	}

	public void func() {
		int mval = in[0].getIntVal();
		if (mval > 0) { // Int>0
			for (int j = 0; j < out.length; j++) {
				int mod = mval % 2;
				mval /= 2;
				out[j].setBoolVal(mod == 1);
			}
		} else { // Int<0
			mval = (int) Math.pow(2.0D, out.length) + mval;
			for (int j = 0; j < out.length; j++) {
				int mod = mval % 2;
				mval /= 2;
				out[j].setBoolVal(mod == 1);
			}
		}

	}
	public static void main(String args[]){
		IntToBools i=new IntToBools(1,8);
		i.setInputPin(0, new Pin(117,8));
		i.func();
		for(int j=0;j<8;j++){
			System.out.println(" Izlaz :"+j+" "+i.getOut(j).getBoolVal());
		}
		
		
	}
}
