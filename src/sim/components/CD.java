package sim.components;

public class CD extends LogicalComponent {
	private Pin W;							//TO JE IZGLEDA IZLAZNI PIN
	private Pin E;


	public CD(int in) {
		super(in, calcOut(in), false);
		W=new Pin(false);				
	}

	public void setW(Pin w) {//mislim da je nepotrebno
		this.W = w;
		w.addChild(this);
	}

	public void setE(Pin e) {
		this.E = e;
		e.addChild(this);
	}
	
	private static int calcOut(int in) {
		int ret = 0;
		while (in > 0) {
			in /= 2;
			if (in <= 0)
				continue;
			ret++;
		}
		return ret;
	}

	public void func() {
		if ((E!=null)&&(!E.getBoolVal())) {
			for (int i = 0; i < out.length; i++){
				out[i].clear();
			}
			W.clear();
			return;
		}
		boolean postoji = false;
		for (int l = 0; l < in.length; l++) {
			if (!in[l].getBoolVal())
				continue;
			postoji = true;
			break;
		}

		if (postoji) {
			W.setBoolVal(true);
		} else {
			W.setBoolVal(false);
			for (int it = 0; it < out.length; it++) {
				out[it].clear();
			}
			return;
		}

		boolean izlaz = false;
		int i = 0;

		for (i = in.length - 1; i >= 0; i--) {
			if (!in[i].getBoolVal())
				continue;
			izlaz = true;
			break;
		}
		if (izlaz) {
			int[] binar = toBin(i);
			for (int k = 0; k < binar.length; k++) {
				if (binar[k] == 0) {
					out[k].clear();
				} else {
					out[k].setBoolVal(true);
				}
			}
		}

		return;
	}

	private int[] toBin(int i) {
		int[] ret = new int[out.length];
		for (int j = 0; j < ret.length; j++) {
			int mod = i % 2;
			i /= 2;
			ret[j] = mod;
		}
		return ret;
	}

	public Pin getE() {
		return E;
	}

	public Pin getW() {
		return W;
	}

}
