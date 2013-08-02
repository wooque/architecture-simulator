package sim.components;

public class KMADR extends LogicalComponent {	//@Darko
	public KMADR() {
		super(4, 1, false);
		out[0].setIsInt();
	}

	public void func() {

		int i = 0;
		for (i = 0; i < in.length; i++) {
			if (in[i].getBoolVal())
				break;
		}
		switch (i) { // DEC OPR HEX
		case 0:
			out[0].setIntVal(27);
			break; // regdir 1B
		case 1:
			out[0].setIntVal(31);
			break; // regiinddisp 1F
		case 2:
			out[0].setIntVal(34);
			break; // pcdisp 22
		case 3:
			out[0].setIntVal(44);
			break; // imm 2C

		}
	}
}
