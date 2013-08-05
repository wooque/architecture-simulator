package sim.components;

public class REG extends LogicalComponent {

	private Pin CL;
	private Pin LD;
	private Pin inc;
	private Pin dec;
	private Pin shr;
	private Pin shl;
	private Pin carry;
	private Pin IR;
	private Pin IL;
	private int value;
	private String name;
	private int init;

	public REG(int in, String n) {
		super(in, in, true);
		value = 0;
		name = n;
		addSequentialComponent(this);
	}

	public void func() {

		int val = 0;
		if ((CL != null) && (CL.getBoolVal()))
			val++;
		if ((dec != null) && (dec.getBoolVal()))
			val++;
		if ((inc != null) && (inc.getBoolVal()))
			val++;
		if ((LD != null) && (LD.getBoolVal()))
			val++;
		if (val > 1) {
			System.out.println("Error!!! Multiple register action...");
			return;
		}
		if ((CL != null) && (CL.getBoolVal())) {
			for (int i = 0; i < out.length; i++) {
				out[i].clear(false);
				value = 0;
			}
			setOutput();
			return;
		}
		if ((LD != null) && (LD.getBoolVal())) {
			value = setInput() & createMask();
			setOutput();
			return;
		}
		if ((shl != null) && (shl.getBoolVal())) {
			value <<= 1;
			if ((IL != null) && (IL.getBoolVal())) {
				value |= 1;
			}
			value = value & createMask();
			setOutput();
			return;
		}

		if ((shr != null) && (shr.getBoolVal())) {
			value >>= 1;
			if ((IR != null) && (IR.getBoolVal())) {
				value |= (int) Math.pow(2.0D, in[0].getNumOfLines() - 1);
			} else {
				value &= ((int) Math.pow(2.0D, in[0].getNumOfLines() - 1) ^ 0xFFFFFFFF);
			}
			value = value & createMask();
			setOutput();
			return;
		}

		if ((inc != null) && (inc.getBoolVal())) {
			if (out[0].isBool()) {
				value += 1;
				// in->out
				if (value % (int) Math.pow(2.0D, out.length) == 0) {
					value = 0;
					if (carry != null)
						carry.setBoolVal(true, false);
				} else {
					if (carry != null)
						carry.setBoolVal(false, false);
				}
			} else {
				value += 1;
				// in->out
				if (value % (int) Math.pow(2.0D, out[0].getNumOfLines()) == 0) {
					value = 0;
					if (carry != null)
						carry.setBoolVal(true, false);
				} else {
					if (carry != null)
						carry.setBoolVal(false, false);
				}
			}
			value = value & createMask();
			setOutput();
			return;
		}
		if ((dec != null) && (dec.getBoolVal())) {
			if (value > 0) {
				value -= 1;
				if (carry != null)
					carry.setBoolVal(false, false);
			} else {
				//in->out
				value = (int) Math.pow(2.0D, out.length);
				if (carry != null)
					carry.setBoolVal(true, false);
			}
			value = value & createMask();
			setOutput();
			return;
		}
		setOutput();// ako se ne radi ni jedna operacija, sve jedno treba da se
					// na izlazne pinove stavi vredost registra
	}

	// Dodato: Djole
	public void clear() {
		value = 0;
	}

	private void setOutput() {

		if (out[0].isBool()) {
			int priv = value;
			for (int j = 0; j < out.length; j++) {
				int mod = priv % 2;
				priv /= 2;
				if (mod == 1)
					out[j].setBoolVal(true, false);
				else {
					out[j].setBoolVal(false, false);
				}
			}
		} else {
			out[0].setIntVal(value, false);
		}
	}

	private int setInput() {
		if (in[0].isBool()) {
			int suma = 0;
			for (int j = 0; j < in.length; j++) {
				if (in[j].getBoolVal()) {
					suma = (int) (suma + Math.pow(2.0D, j));
				}
			}
			return suma;
		}
		return in[0].getIntVal();
	}

	public void flush() {
		super.flush();
		if (carry != null)
			carry.flush();
	}

	public void setPinInc(Pin inc) {
		this.inc = inc;
		inc.addChild(this);
	}

	public void setPinDec(Pin dec) {
		this.dec = dec;
		dec.addChild(this);
	}

	public void setPinCL(Pin CL) {
		this.CL = CL;
		CL.addChild(this);
	}

	public void setPinLd(Pin LD) {
		this.LD = LD;
		LD.addChild(this);
	}

	public int getVal() {
		return value;
	}

	public void initVal(int value) {
		this.value = value;
		init = value;
	}

	public void setVal(int vr) {

		if (in[0].isBool()) {
			value = (vr % (int) Math.pow(2.0D, in.length));
		} else {
			value = (vr % (int) Math.pow(2.0D, in[0].getNumOfLines()));
		}
		setOutput();
	}

	public void setShr(Pin shr) {
		this.shr = shr;
		shr.addChild(this);
	}

	public void setShl(Pin shl) {
		this.shl = shl;
		shr.addChild(this);
	}

	public Pin getC() {
		return carry;
	}

	public void setIR(Pin ir) {
		this.IR = ir;
		ir.addChild(this);
	}

	public void setIL(Pin il) {
		this.IL = il;
		il.addChild(this);
	}

	public String getName() {
		return name;
	}

	public void init() {
		value = init;
		setOutput();
	}

	public int createMask() {
		int mask;
		if (getOut(0).isBool())
			mask = out.length;
		else
			mask = getOut(0).getNumOfLines();
		switch (mask) { // DEC VAL_hex
		case 6:
			return 0x3f;// jer GPRAR je 6 bita registar
		case 8:
			return 0xff;
		case 16:
			return 0xffff;
		}
		return 0xffff;// za svaki slucaj
	}
}
