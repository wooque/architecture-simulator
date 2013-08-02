package sim.components;

public class KMBRMEM extends LogicalComponent { // @Darko
	public KMBRMEM() {
		super(3, 1, false);
		out[0].setIsInt();
		out[0].setNumOfLines(2);
	}

	public void func() {
		int i = 0;
		for (i = 0; i < in.length; i++) {
			if (in[i].getBoolVal())
				break;
		}
		switch (i) { // DEC VAL_hex
		case 0:
			out[0].setIntVal(0);
			break; // VAL_00
		case 1:
			out[0].setIntVal(1);
			break; // VAL_01
		case 2:
			out[0].setIntVal(2);
			// VAL_02

		}
	}
}