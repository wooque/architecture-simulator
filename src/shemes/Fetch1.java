package shemes;

import gui.GuiScheme;

import components.*;

public class Fetch1 {
	public static REG PC;
	public static TSB TSBPC1out;
	public static TSB TSBPC2out;
	public static IntToInt DBToTemp;
	public static IntToBools TempToIR;
	public static REG IR0;
	public static REG IR1;
	public static REG IR2;
	public static REG IR3;
	public static BoolsToInt IR1ToTemp;
	public static IntToInt TempToJDISP;
	public static TSB TSBJDISPout;
	public static IntToInt TempToIENTRY;// INT entry
	public static TSB TSBINTENTRYout;
	public static BoolsToInt IR2ToTemp;
	public static IntToInt TempToIMM;
	public static IntToInt TempToPCRDISP;
	public static TSB TSBIMMout;
	public static TSB TSBPCRDISPout;
	public static BoolsToInt IR12ToJAPS;
	public static TSB TSBJAPSout;
	public static BoolsToInt IR23ToREGIDISP;
	public static TSB TSBREGIDISPout;

	public static BoolsToInt JDISP, INTENTRY, PCRDISP, IMM;
	// potrebni samo za iscrtavanje linija za prosirivanje znakom ili nulom

	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	private Fetch1() {

	}

	public static void init() {

		PC = new REG(1, "PC");
		PC.getOut(0).setIsInt();
		PC.getOut(0).setNumOfLines(16);

		TSBPC1out = new TSB();
		TSBPC1out.getOut(0).setNumOfLines(16);

		TSBPC2out = new TSB();
		TSBPC2out.getOut(0).setNumOfLines(16);

		DBToTemp = new IntToInt(16, 8);

		TempToIR = new IntToBools(8, 8);

		IR0 = new REG(8, "IR0");

		IR1 = new REG(8, "IR1");

		IR2 = new REG(8, "IR2");

		IR3 = new REG(8, "IR3");

		IR1ToTemp = new BoolsToInt(8, 8);

		TempToJDISP = new IntToInt(8, 16, false, true);

		TSBJDISPout = new TSB();
		TSBJDISPout.getOut(0).setNumOfLines(16);

		TempToIENTRY = new IntToInt(8, 16);

		TSBINTENTRYout = new TSB();
		TSBINTENTRYout.getOut(0).setNumOfLines(16);

		IR2ToTemp = new BoolsToInt(8, 8);

		TempToIMM = new IntToInt(8, 16);

		TempToPCRDISP = new IntToInt(8, 16, false, true);

		TSBIMMout = new TSB();
		TSBIMMout.getOut(0).setNumOfLines(16);

		TSBPCRDISPout = new TSB();
		TSBPCRDISPout.getOut(0).setNumOfLines(16);

		IR12ToJAPS = new BoolsToInt(16, 16);

		TSBJAPSout = new TSB();
		TSBJAPSout.getOut(0).setNumOfLines(16);

		IR23ToREGIDISP = new BoolsToInt(16, 16);

		TSBREGIDISPout = new TSB();
		TSBREGIDISPout.getOut(0).setNumOfLines(16);

		// BoolsToInt samo za iscrtavanje:
		JDISP = new BoolsToInt(8, 8);
		INTENTRY = new BoolsToInt(8, 8);
		PCRDISP = new BoolsToInt(8, 8);
		IMM = new BoolsToInt(8, 8);
	}

	public static void connect() {
		PC.setInputPin(0, Bus1.DB());
		PC.setPinInc(Oper1.incPC());
		PC.setPinLd(Oper1.ldPC());

		TSBPC1out.setInputPin(0, PC.getOut(0));
		TSBPC1out.setCtrl(Oper1.PC1out());
		Bus1.addOnS1B(TSBPC1out.getOut(0));

		TSBPC2out.setInputPin(0, PC.getOut(0));
		TSBPC2out.setCtrl(Oper1.PC2out());
		Bus1.addOnS2B(TSBPC2out.getOut(0));

		DBToTemp.setInputPin(0, Bus1.DB());

		TempToIR.setInputPin(0, DBToTemp.getOut(0));

		IR0.setPinLd(Oper1.ldIR0());
		IR1.setPinLd(Oper1.ldIR1());
		IR2.setPinLd(Oper1.ldIR2());
		IR3.setPinLd(Oper1.ldIR3());
		for (int i = 0; i < 8; i++) {
			Pin p = TempToIR.getOut(i);
			IR0.setInputPin(i, p);
			IR1.setInputPin(i, p);
			IR2.setInputPin(i, p);
			IR3.setInputPin(i, p);
		}

		for (int i = 0; i < 8; i++) {
			IR1ToTemp.setInputPin(i, IR1.getOut(i));
		}

		TempToJDISP.setInputPin(0, IR1ToTemp.getOut(0));

		TSBJDISPout.setInputPin(0, TempToJDISP.getOut(0));
		TSBJDISPout.setCtrl(Oper1.JDISPout());
		Bus1.addOnS2B(TSBJDISPout.getOut(0));

		TempToIENTRY.setInputPin(0, IR1ToTemp.getOut(0));

		TSBINTENTRYout.setInputPin(0, TempToIENTRY.getOut(0));
		TSBINTENTRYout.setCtrl(Oper1.INTENTRYout());
		Bus1.addOnS2B(TSBINTENTRYout.getOut(0));

		for (int i = 0; i < 8; i++) {
			IR2ToTemp.setInputPin(i, IR2.getOut(i));
		}

		TempToIMM.setInputPin(0, IR2ToTemp.getOut(0));

		TempToPCRDISP.setInputPin(0, IR2ToTemp.getOut(0));

		TSBIMMout.setInputPin(0, TempToIMM.getOut(0));
		TSBIMMout.setCtrl(Oper1.IMMout());
		Bus1.addOnDB(TSBIMMout.getOut(0));

		TSBPCRDISPout.setInputPin(0, TempToPCRDISP.getOut(0));
		TSBPCRDISPout.setCtrl(Oper1.PCRDISPout());
		Bus1.addOnS2B(TSBPCRDISPout.getOut(0));

		for (int i = 0; i < 8; i++) {
			IR12ToJAPS.setInputPin(i, IR2.getOut(i));
			IR12ToJAPS.setInputPin(i + 8, IR1.getOut(i));
		}

		TSBJAPSout.setInputPin(0, IR12ToJAPS.getOut(0));
		TSBJAPSout.setCtrl(Oper1.JAPSout());
		Bus1.addOnDB(TSBJAPSout.getOut(0));

		for (int i = 0; i < 8; i++) {
			IR23ToREGIDISP.setInputPin(i, IR3.getOut(i));
			IR23ToREGIDISP.setInputPin(i + 8, IR2.getOut(i));
		}

		TSBREGIDISPout.setInputPin(0, IR23ToREGIDISP.getOut(0));
		TSBREGIDISPout.setCtrl(Oper1.REGIDISPout());
		Bus1.addOnS2B(TSBREGIDISPout.getOut(0));

		// BoolsToInt samo za iscrtavanje:
		for (int i = 0; i < 8; i++) {
			JDISP.setInputPin(i, IR1.getOut(0));
			INTENTRY.setInputPin(i, new Pin(false));
			PCRDISP.setInputPin(i, IR2.getOut(0));
			IMM.setInputPin(i, new Pin(false));
		}

	}

	public static Pin IR31() {
		return IR0.getOut(7);
	}

	public static Pin IR30() {
		return IR0.getOut(6);
	}

	public static Pin IR29() {
		return IR0.getOut(5);
	}

	public static Pin IR28() {
		return IR0.getOut(4);
	}

	public static Pin IR27() {
		return IR0.getOut(3);
	}

	public static Pin IR26() {
		return IR0.getOut(2);
	}

	public static Pin IR25() {
		return IR0.getOut(1);
	}

	public static Pin IR24() {
		return IR0.getOut(0);
	}

	public static Pin IR23() {
		return IR1.getOut(7);
	}

	public static Pin IR22() {
		return IR1.getOut(6);
	}

	public static Pin PC() {
		return PC.getOut(0);
	}

	public static Pin IMMout() {
		return TSBIMMout.getOut(0);
	}

	public static Pin PC1out() {
		return TSBPC1out.getOut(0);
	}

	public static Pin PC2out() {
		return TSBPC2out.getOut(0);
	}

	public static Pin JDISPout() {
		return TSBJDISPout.getOut(0);
	}

	public static Pin PCRDISPout() {
		return TSBPCRDISPout.getOut(0);
	}

	public static Pin JAPSout() {
		return TSBJAPSout.getOut(0);
	}

	public static Pin REGIDISPout() {
		return TSBREGIDISPout.getOut(0);
	}

	public static REG RegPC() {
		return PC;
	}

	public static REG RegIR0() {
		return IR0;
	}

	public static REG RegIR1() {
		return IR1;
	}

	public static REG RegIR2() {
		return IR2;
	}

	public static REG RegIR3() {
		return IR3;
	}

}
