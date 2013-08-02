package sim.components;

public class KMOPR extends LogicalComponent {		//@Darko

	public KMOPR() {				
		super(46, 1, false);
		out[0].setIsInt();
	}

	public void func() {
		int i = 0;
		for (i = 0; i < in.length; i++) {
			if (in[i].getBoolVal())
				break;
		}
		switch (i) {				 // DEC OPR HEX
		case 0:
			out[0].setIntVal(46);
			break; // NOP 2E
		case 1:
			out[0].setIntVal(47);
			break; // HALT 2F
		case 2:
			out[0].setIntVal(48);
			break; // INTD 30
		case 3:
			out[0].setIntVal(49);
			break; // INTE 31
		case 4:
			out[0].setIntVal(50);
			break; // TRPD 32
		case 5:
			out[0].setIntVal(51);
			break; // TRPE 33
		case 6:
			out[0].setIntVal(52);
			break; // LDB 34
		case 7:
			out[0].setIntVal(54);
			break; // LDW 36
		case 8:
			out[0].setIntVal(55);
			break; // STB 37
		case 9:
			out[0].setIntVal(61);
			break; // STW 3D
		case 10:
			out[0].setIntVal(70);
			break; // STIVTP 46
		case 11:
			out[0].setIntVal(71);
			break; // STSP 47
		case 12:
			out[0].setIntVal(72);
			break; // ADD 48
		case 13:
			out[0].setIntVal(74);
			break; // SUB 4A
		case 14:
			out[0].setIntVal(76);
			break; // AND 4C
		case 15:
			out[0].setIntVal(78);
			break; // OR 4E
		case 16:
			out[0].setIntVal(80);
			break; // XOR 50
		case 17:
			out[0].setIntVal(82);
			break; // NOT 52
		case 18:
			out[0].setIntVal(84);
			break; // ASR 54
		case 19:
			out[0].setIntVal(84);
			break; // LSR 54
		case 20:
			out[0].setIntVal(84);
			break; // ROR 54
		case 21:
			out[0].setIntVal(84);
			break; // RORC 54
		case 22:
			out[0].setIntVal(86);
			break; // ASL 56
		case 23:
			out[0].setIntVal(86);
			break; // LSL 56
		case 24:
			out[0].setIntVal(86);
			break; // ROL 56
		case 25:
			out[0].setIntVal(86);
			break; // ROLC 56
		case 26:
			out[0].setIntVal(88);
			break; // BEQL 58
		case 27:
			out[0].setIntVal(88);
			break; // BNEQ 58
		case 28:
			out[0].setIntVal(88);
			break; // BNEG 58
		case 29:
			out[0].setIntVal(88);
			break; // BNNG 58
		case 30:
			out[0].setIntVal(88);
			break; // BOVF 58
		case 31:
			out[0].setIntVal(88);
			break; // BNVF 58
		case 32:
			out[0].setIntVal(88);
			break; // BCR 58
		case 33:
			out[0].setIntVal(88);
			break; // BNCRT 58
		case 34:
			out[0].setIntVal(88);
			break; // BGRE 58
		case 35:
			out[0].setIntVal(88);
			break; // BLSS 58
		case 36:
			out[0].setIntVal(88);
			break; // BLEQ 58
		case 37:
			out[0].setIntVal(88);
			break; // BGRTU 58
		case 38:
			out[0].setIntVal(88);
			break; // BGREU 58
		case 39:
			out[0].setIntVal(88);
			break; // BLSSU 58
		case 40:
			out[0].setIntVal(88);
			break; // BLEQU 58
		case 41:
			out[0].setIntVal(91);
			break; // JMP 5B
		case 42:
			out[0].setIntVal(92);
			break; // INT 5C
		case 43:
			out[0].setIntVal(93);
			break; // JSR 5D
		case 44:
			out[0].setIntVal(100);
			break; // RTI 64
		case 45:
			out[0].setIntVal(108); 
				   // RTS 6C
		}
	}
}
