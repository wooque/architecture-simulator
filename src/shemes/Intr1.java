package shemes;

import gui.*;
import components.*;

public class Intr1 {
	public static RSFF PRINS, PRCOD, PRADR, PRINM, PRINTR1, PRINTR2, PRINTR3;
	public static REG IMR;
	public static IntToBools IMRBits;
	public static TSB TSBIMR;
	public static DC DCintr1;
	public static OR ORprekid;
	public static AND ANDprekid;
	public static NOT NOTprekid;
	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void init() {

		PRINS = new RSFF("PRINS");
		PRINS.setPinE(new Pin(true));
		PRINS.setPinClear(new Pin(false));

		PRCOD = new RSFF("PRCOD");
		PRCOD.setPinE(new Pin(true));
		PRCOD.setPinClear(new Pin(false));

		PRADR = new RSFF("PRADR");
		PRADR.setPinE(new Pin(true));
		PRADR.setPinClear(new Pin(false));

		PRINM = new RSFF("PRINM");
		PRINM.setPinE(new Pin(true));
		PRINM.setPinClear(new Pin(false));

		PRINTR1 = new RSFF("PRINTR1");
		PRINTR1.setPinE(new Pin(true));
		PRINTR1.setPinClear(new Pin(false));

		PRINTR2 = new RSFF("PRINTR2");
		PRINTR2.setPinE(new Pin(true));
		PRINTR2.setPinClear(new Pin(false));

		PRINTR3 = new RSFF("PRINTR3");
		PRINTR3.setPinE(new Pin(true));
		PRINTR3.setPinClear(new Pin(false));

		IMR = new REG(1, "IMR");
		IMR.getOut(0).setIsInt();
		IMR.getOut(0).setNumOfLines(16);
		IMR.initVal(15); // DOZVOLI MASKIRAJUCI SVE PREKIDE

		IMRBits = new IntToBools(16, 16);

		TSBIMR = new TSB();
		TSBIMR.getOut(0).setNumOfLines(16);

		ORprekid = new OR(6);
		NOTprekid = new NOT();
		ANDprekid = new AND();

		DCintr1 = new DC(2);

	}

	public static void connect() {
		PRINS.setInputPin(0, Oper2.stPRINS());
		PRINS.setInputPin(1, Oper2.clPRINS());

		PRCOD.setInputPin(0, Oper2.stPRCOD());
		PRCOD.setInputPin(1, Oper2.clPRCOD());

		PRADR.setInputPin(0, Oper2.stPRADR());
		PRADR.setInputPin(1, Oper2.clPRADR());

		PRINM.setInputPin(0, new Pin(false));// odakle dovuci ovaj INM->Fixirati
												// Pin sa False
		PRINM.setInputPin(1, Oper2.clPRINM());

		PRINTR1.setInputPin(0, new Pin(false));
		PRINTR1.setInputPin(1, DCintr1.getOut(1));

		PRINTR2.setInputPin(0, new Pin(false));
		PRINTR2.setInputPin(1, DCintr1.getOut(2));

		PRINTR3.setInputPin(0, new Pin(false));
		PRINTR3.setInputPin(1, DCintr1.getOut(3));

		IMR.setInputPin(0, Bus1.DB());
		IMR.setPinLd(new Pin(false)); // /JER NE POSTOJI STORE IMR I SLICNO

		IMRBits.setInputPin(0, IMR.getOut(0));

		TSBIMR.setInputPin(0, IMR.getOut(0));
		TSBIMR.setCtrl(new Pin(false));
		Bus1.addOnS2B(TSBIMR.getOut(0));

		NOTprekid.setInputPin(0, Fetch2.RTI());
		ANDprekid.setInputPin(0, Exec2.PSWT());
		ANDprekid.setInputPin(1, NOTprekid.getOut(0));

		ORprekid.setInputPin(0, PRINS.getOut(0));
		ORprekid.setInputPin(1, PRCOD.getOut(0));
		ORprekid.setInputPin(2, PRADR.getOut(0));
		ORprekid.setInputPin(3, PRINM.getOut(0));
		ORprekid.setInputPin(4, Intr2.printr());
		ORprekid.setInputPin(5, ANDprekid.getOut(0));

		DCintr1.setE(Oper2.clINTR());
		DCintr1.setInputPin(0, Intr2.prl0());
		DCintr1.setInputPin(1, Intr2.prl1());
	}

	public static Pin prekid() {
		return ORprekid.getOut(0);
	}

	public static Pin PRINS() {
		return PRINS.getOut(0);
	}

	public static Pin PRCOD() {
		return PRCOD.getOut(0);
	}

	public static Pin PRADR() {
		return PRADR.getOut(0);
	}

	public static Pin PRINM() {
		return PRINM.getOut(0);
	}

	public static Pin PRINTR1() {
		return PRINTR1.getOut(0);
	}

	public static Pin PRINTR2() {
		return PRINTR2.getOut(0);
	}

	public static Pin PRINTR3() {
		return PRINTR3.getOut(0);
	}

	public static Pin IMR1() {
		return IMRBits.getOut(1);
	}

	public static Pin IMR2() {
		return IMRBits.getOut(2);
	}

	public static Pin IMR3() {
		return IMRBits.getOut(3);
	}

	public static Pin IMR() {
		return IMR.getOut(0);
	}

	public static Pin IMRout() {
		return TSBIMR.getOut(0);
	}

	public static REG RegIMR() {
		return IMR;
	}
}
