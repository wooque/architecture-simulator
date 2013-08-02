package sim.components;

public class KMBR extends LogicalComponent {	//@Darko
	public KMBR() {
		super(39, 1, false); 
		out[0].setIsInt();
	}

	public void func() {
		int i = 0;
		for (i = 0; i < this.in.length; i++) {
			if (this.in[i].getBoolVal())
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
			out[0].setIntVal(4);
			break; // VAL_04
		case 3:
			out[0].setIntVal(8);
			break; // VAL_08
		case 4:
			out[0].setIntVal(11);
			break; // VAL_0B
		case 5:
			out[0].setIntVal(15);
			break; // VAL_0F
		case 6:
			out[0].setIntVal(19);
			break; // VAL_13
		case 7:
			out[0].setIntVal(24);
			break; // VAL_18
		case 8:
			out[0].setIntVal(26);
			break; // VAL_1A
		case 9:
			out[0].setIntVal(30);
			break; // VAL_1E
		case 10:
			out[0].setIntVal(36);
			break; // VAL_24
		case 11:
			out[0].setIntVal(37);
			break; // VAL_25
		case 12:
			out[0].setIntVal(40);
			break; // VAL_28
		case 13:
			out[0].setIntVal(42);
			break; // VAL_2A
		case 14:
			out[0].setIntVal(45);
			break; // VAL_2D
		case 15:
			out[0].setIntVal(58);
			break; // VAL_3A
		case 16:
			out[0].setIntVal(60);
			break; // VAL_3C
		case 17:
			out[0].setIntVal(64);
			break; // VAL_40
		case 18:
			out[0].setIntVal(67);
			break; // VAL_43
		case 19:
			out[0].setIntVal(69);
			break; // VAL_45
		case 20:
			out[0].setIntVal(95);
			break; // VAL_5F
		case 21:
			out[0].setIntVal(98);
			break; // VAL_62
		case 22:
			out[0].setIntVal(103);
			break; // VAL_67
		case 23:
			out[0].setIntVal(106);
			break; // VAL_6A
		case 24:
			out[0].setIntVal(111);
			break; // VAL_6F
		case 25:
			out[0].setIntVal(114);
			break; // VAL_72
		case 26:
			out[0].setIntVal(117);
			break; // VAL_75
		case 27:
			out[0].setIntVal(120);
			break; // VAL_78
		case 28:
			out[0].setIntVal(123);
			break; // VAL_7B
		case 29:
			out[0].setIntVal(126);
			break; // VAL_7E
		case 30:
			out[0].setIntVal(129);
			break; // VAL_81
		case 31:
			out[0].setIntVal(132);
			break; // VAL_84
		case 32:
			out[0].setIntVal(134);
			break; // VAL_86
		case 33:
			out[0].setIntVal(136);
			break; // VAL_88
		case 34:
			out[0].setIntVal(138);
			break; // VAL_8A
		case 35:
			out[0].setIntVal(140);
			break; // VAL_8C
		case 36:
			out[0].setIntVal(141);
			break; // VAL_8D
		case 37:
			out[0].setIntVal(144);
			break; // VAL_90
		case 38:
			out[0].setIntVal(147);
				   // VAL_93

		}
	}
}