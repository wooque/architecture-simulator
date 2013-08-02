package shemes;

import gui.*;
import components.*;

public class Intr3 {
	public static CD CD1, CD2;
	public static BoolsToInt UINT;
	public static BoolsToInt UEXT;
	public static IntToInt S2BToMX0;
	public static MP MX;
	public static REG BR;
	public static IntToBools BRBits;
	public static BoolsToInt IVTDSP;
	public static TSB TSBIVTDSP;
	public static REG IVTP;
	public static TSB TSBIVTP;
	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void init() {
		CD1 = new CD(4);
		CD2 = new CD(4);
		UINT = new BoolsToInt(8, 8);
		UEXT = new BoolsToInt(8, 8);
		S2BToMX0 = new IntToInt(16, 8);
		MX = new MP(4);
		MX.getOut(0).setIsInt();
		MX.getOut(0).setNumOfLines(8);
		BR = new REG(1, "BR");
		BR.getOut(0).setIsInt();
		BR.getOut(0).setNumOfLines(8);
		BRBits = new IntToBools(8, 8);
		IVTDSP = new BoolsToInt(16, 16);
		TSBIVTDSP = new TSB();
		TSBIVTDSP.getOut(0).setNumOfLines(16);
		IVTP = new REG(1, "IVTP");
		IVTP.getOut(0).setIsInt();
		IVTP.getOut(0).setNumOfLines(16);
		TSBIVTP = new TSB();
		TSBIVTP.getOut(0).setNumOfLines(16);

	}

	public static void connect() {

		CD1.setE(new Pin(true));
		CD1.setInputPin(0, Exec2.PSWT());
		CD1.setInputPin(1, Intr1.PRINM());
		CD1.setInputPin(2, Intr1.PRADR());
		CD1.setInputPin(3, Intr1.PRCOD());

		UINT.setInputPin(0, CD1.getOut(0));
		UINT.setInputPin(1, CD1.getOut(1));
		for (int i = 2; i < 8; i++) {
			UINT.setInputPin(i, new Pin(false));
		}

		CD2.setE(new Pin(true));
		CD2.setInputPin(0, new Pin(false));
		CD2.setInputPin(1, Intr2.irm1());
		CD2.setInputPin(2, Intr2.irm2());
		CD2.setInputPin(3, Intr2.irm3());

		UEXT.setInputPin(0, CD2.getOut(0));
		UEXT.setInputPin(1, CD2.getOut(1));
		UEXT.setInputPin(2, new Pin(true));
		for (int i = 3; i < 8; i++) {
			UEXT.setInputPin(i, new Pin(false));
		}

		S2BToMX0.setInputPin(0, Bus1.S2B());

		MX.setE(new Pin(true));
		MX.setInputPin(0, S2BToMX0.getOut(0));
		MX.setInputPin(1, UINT.getOut(0));
		MX.setInputPin(2, UEXT.getOut(0));
		MX.setInputPin(3, new Pin(false));
		MX.setCtrl(0, Oper2.mxBR0());
		MX.setCtrl(1, Oper2.mxBR1());

		BR.setPinLd(Oper2.ldBR());
		BR.setInputPin(0, MX.getOut(0));

		BRBits.setInputPin(0, BR.getOut(0));

		IVTDSP.setInputPin(0, new Pin(false));
		for (int i = 0; i < 8; i++) {
			IVTDSP.setInputPin(1 + i, BRBits.getOut(i));
		}
		for (int i = 9; i < 16; i++) {
			IVTDSP.setInputPin(i, new Pin(false));
		}

		TSBIVTDSP.setCtrl(Oper2.IVTDSPout());
		TSBIVTDSP.setInputPin(0, IVTDSP.getOut(0));
		Bus1.addOnS2B(TSBIVTDSP.getOut(0));

		IVTP.setPinLd(Oper2.ldIVTP());
		IVTP.setInputPin(0, Bus1.S2B());

		TSBIVTP.setCtrl(Oper2.IVTPout());
		TSBIVTP.setInputPin(0, IVTP.getOut(0));
		Bus1.addOnS1B(TSBIVTP.getOut(0));

	}

	public static Pin UINT() {
		return UINT.getOut(0);
	}

	public static Pin UEXT() {
		return UEXT.getOut(0);
	}

	public static Pin BR() {
		return BR.getOut(0);
	}

	public static Pin IVTP() {
		return IVTP.getOut(0);
	}

	public static Pin IVTDSP() {
		return IVTDSP.getOut(0);
	}

	public static Pin IVTPout() {
		return TSBIVTP.getOut(0);
	}

	public static Pin IVTDSPout() {
		return TSBIVTDSP.getOut(0);
	}

	public static REG RegBR() {
		return BR;
	}

	public static REG RegIVTP() {
		return IVTP;
	}
}
