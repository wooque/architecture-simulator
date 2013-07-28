package components;

public class ALU extends LogicalComponent {
	// private Pin asr;
	private Pin add;
	private Pin and;
	// private Pin inc;
	// private Pin dec;
	private Pin sub;
	private Pin xor;
	private Pin not;
	private Pin or;
	// private Pin transferX;
	//private Pin C0;
	private Pin C8;

	public ALU() {
		super(2, 1, false);
		out[0].setIsInt();
		out[0].setNumOfLines(8);
		C8 = new Pin(false);
	}

	public void func() {
		int akc = 0;
		// if ((asr!=null) && (asr.getBoolVal()))
		// akc++;
		if ((add != null) && (add.getBoolVal()))
			akc++;
		if ((and != null) && (and.getBoolVal()))
			akc++;
		// if ((inc!=null) && (inc.getBoolVal()))
		// akc++;
		// if ((dec!=null) && (dec.getBoolVal()))
		// akc++;
		// if ((transferX!=null) && (transferX.getBoolVal()))
		// akc++;
		if ((sub != null) && (sub.getBoolVal()))
			akc++;
		if ((xor != null) && (xor.getBoolVal()))
			akc++;
		if ((not != null) && (not.getBoolVal()))
			akc++;
		if ((or != null) && (or.getBoolVal()))
			akc++;
		if (akc > 1) {
			System.out.println("Error!!! Multiple operations active...");
			return;
		}

		if (akc == 0){
			out[0].setIntVal(0);
			C8.setBoolVal(false);
			return;
		}
			

		int A = in[0].getIntVal();
		int B = in[1].getIntVal();

		if ((xor != null) && (xor.getBoolVal())) {
			int ioutput = A ^ B;
			ioutput=ioutput & 0xff;
			out[0].setIntVal(ioutput);
			return;
		}
		if ((sub != null) && (sub.getBoolVal())) {
			int ioutput = A - B;
			

			if ((((B ^ 0xFFFFFFFF) & 0xFF) + 1 + A & 0x100) == 256) {
				if (C8 != null)
					C8.setBoolVal(true);
			} else {
				if (C8 != null)
					C8.setBoolVal(false);
			}
			ioutput=ioutput & 0xff;
			out[0].setIntVal(ioutput);
			return;
		}

		if ((not != null) && (not.getBoolVal())) {
			int ioutput = A ^ 0xFFFFFFFF;
			ioutput=ioutput & 0xff;
			out[0].setIntVal(ioutput);
			return;
		}

		if ((or != null) && (or.getBoolVal())) {
			int ioutput = A | B;
			ioutput=ioutput & 0xff;
			out[0].setIntVal(ioutput);
			return;
		}

		// if ((transferX!=null) && (transferX.getBoolVal())) {
		// out[0].setIntVal(in[0].getIntVal());
		// return;
		// }
		if ((add != null) && (add.getBoolVal())) {
			int iz = A + B;
			int max = (int) (Math.pow(2.0D, out[0].getNumOfLines()) - 1.0D);
			boolean c16 = false;
			if (iz > max) {
				iz -= max + 1;
				c16 = true;
			}
			iz=iz & 0xff;
			out[0].setIntVal(iz);
			if (C8 != null)
				C8.setBoolVal(c16);
			return;
		}
		// if ((dec!=null) && (dec.getBoolVal())) {
		// int iz = A - 1;
		// int max = (int) (Math.pow(2.0D, out[0].getNumOfLines()) - 1.0D);
		// boolean c16 = false;
		// if (iz > max) {
		// iz -= max + 1;
		// c16 = true;
		// }
		// out[0].setIntVal(iz);
		// if(C16!=null)
		// C16.setBoolVal(c16);
		// return;
		// }
		// if ((inc!=null) && (inc.getBoolVal())) {
		// int iz = A + 1;
		// int max = (int) (Math.pow(2.0D, out[0].getNumOfLines()) - 1.0D);
		// boolean c16 = false;
		// if (iz == -1) {
		// iz = max;
		// c16 = true;
		// }
		// out[0].setIntVal(iz);
		// if(C16!=null)
		// C16.setBoolVal(c16);
		// return;
		// }
		if ((and != null) && (and.getBoolVal())) {
			int iz = A & B;
			iz=iz & 0xff;
			out[0].setIntVal(iz);
			return;
		}
		// if ((asr!=null) && (asr.getBoolVal())) {
		// int pom = A;
		// A >>= 1;
		// out[0].setIntVal(A);
		// if(C0!=null)
		// C0.setBoolVal(pom % 2 == 1);
		// return;
		// }
		

	}

	public void setPinX(Pin pin) {
		setInputPin(0, pin);
	}

	public void setPinY(Pin pin) {
		setInputPin(1, pin);
	}

	public void setPinAdd(Pin add) {
		this.add = add;
		add.addChild(this);
	}

	public void setPinAnd(Pin and) {
		this.and = and;
		and.addChild(this);
	}

	// public void setPinAsr(Pin asr) {
	// this.asr = asr;
	// asr.addChild(this);
	// }

	//public void setPinC0(Pin c0) {
	//	this.C0 = c0;
	//	c0.addChild(this);
	//}

	// public void setPinDec(Pin dec) {
	// this.dec = dec;
	// dec.addChild(this);
	// }

	// public void setPinInc(Pin inc) {
	// this.inc = inc;
	// inc.addChild(this);
	// }

	// public void setPinTransferX(Pin transferX) {
	// this.transferX = transferX;
	// transferX.addChild(this);
	// }

	public void setPinSub(Pin sub) {
		this.sub = sub;
		sub.addChild(this);
	}

	public void setPinXor(Pin xor) {
		this.xor = xor;
		xor.addChild(this);
	}

	public void setPinNot(Pin not) {
		this.not = not;
		not.addChild(this);
	}

	public void setPinOr(Pin or) {
		this.or = or;
		or.addChild(this);
	}

	public Pin getPinC8() {
		return C8;
	}

}
