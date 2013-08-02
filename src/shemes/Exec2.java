package shemes;

import gui.GuiScheme;

import components.*;

public class Exec2 {
	public static IntToBools DBBits;
	public static AND IAND1;
	public static OR IOR1;
	public static AND IAND2;
	public static OR IOR2;
	public static NOT INOT;
	public static RSFF IRSFF;

	public static AND TAND1;
	public static OR TOR1;
	public static AND TAND2;
	public static OR TOR2;
	public static NOT TNOT;
	public static RSFF TRSFF;

	public static AND NAND1;
	public static AND NAND2;
	public static OR NOR1;
	public static NOT NNOT1;
	public static AND NAND3;
	public static NOT NNOT2;
	public static AND NAND4;
	public static OR NOR2;
	public static RSFF NRSFF;

	public static AND ZAND1;
	public static AND ZAND2;
	public static OR ZOR1;
	public static NOT ZNOT1;
	public static AND ZAND3;
	public static NOT ZNOT2;
	public static AND ZAND4;
	public static OR ZOR2;
	public static RSFF ZRSFF;

	public static AND CAND1;
	public static AND CAND2;
	public static OR COR1;
	public static NOT CNOT1;
	public static AND CAND3;
	public static NOT CNOT2;
	public static AND CAND4;
	public static OR COR2;
	public static RSFF CRSFF;

	public static AND VAND1;
	public static AND VAND2;
	public static OR VOR1;
	public static NOT VNOT1;
	public static AND VAND3;
	public static NOT VNOT2;
	public static AND VAND4;
	public static OR VOR2;
	public static RSFF VRSFF;

	public static AND L0AND1;
	public static AND L0AND2;
	public static OR L0OR1;
	public static NOT L0NOT1;
	public static AND L0AND3;
	public static NOT L0NOT2;
	public static AND L0AND4;
	public static OR L0OR2;
	public static RSFF L0RSFF;

	public static AND L1AND1;
	public static AND L1AND2;
	public static OR L1OR1;
	public static NOT L1NOT1;
	public static AND L1AND3;
	public static NOT L1NOT2;
	public static AND L1AND4;
	public static OR L1OR2;
	public static RSFF L1RSFF;

	public static BoolsToInt PSW;
	public static TSB TSBPSWout;

	public static RSFF STARTRSFF;

	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	private Exec2() {

	}

	public static void init() {
		DBBits = new IntToBools(16, 16);
		IAND1 = new AND();
		IOR1 = new OR();
		INOT = new NOT();
		IAND2 = new AND();
		IOR2 = new OR();
		IRSFF = new RSFF("I");

		TAND1 = new AND();
		TOR1 = new OR();
		TNOT = new NOT();
		TAND2 = new AND();
		TOR2 = new OR();
		TRSFF = new RSFF("T");

		NAND1 = new AND();
		NAND2 = new AND();
		NOR1 = new OR();
		NNOT1 = new NOT();
		NAND3 = new AND();
		NNOT2 = new NOT();
		NAND4 = new AND();
		NOR2 = new OR();
		NRSFF = new RSFF("N");

		ZAND1 = new AND();
		ZAND2 = new AND();
		ZOR1 = new OR();
		ZNOT1 = new NOT();
		ZAND3 = new AND();
		ZNOT2 = new NOT();
		ZAND4 = new AND();
		ZOR2 = new OR();
		ZRSFF = new RSFF("Z");

		CAND1 = new AND();
		CAND2 = new AND();
		COR1 = new OR();
		CNOT1 = new NOT();
		CAND3 = new AND();
		CNOT2 = new NOT();
		CAND4 = new AND();
		COR2 = new OR();
		CRSFF = new RSFF("C");

		VAND1 = new AND();
		VAND2 = new AND();
		VOR1 = new OR();
		VNOT1 = new NOT();
		VAND3 = new AND();
		VNOT2 = new NOT();
		VAND4 = new AND();
		VOR2 = new OR();
		VRSFF = new RSFF("V");

		L0AND1 = new AND();
		L0AND2 = new AND();
		L0OR1 = new OR();
		L0NOT1 = new NOT();
		L0AND3 = new AND();
		L0NOT2 = new NOT();
		L0AND4 = new AND();
		L0OR2 = new OR();
		L0RSFF = new RSFF("L0");

		L1AND1 = new AND();
		L1AND2 = new AND();
		L1OR1 = new OR();
		L1NOT1 = new NOT();
		L1AND3 = new AND();
		L1NOT2 = new NOT();
		L1AND4 = new AND();
		L1OR2 = new OR();
		L1RSFF = new RSFF("L1");

		PSW = new BoolsToInt(16, 16);
		TSBPSWout = new TSB();
		TSBPSWout.getOut(0).setNumOfLines(16);

		STARTRSFF = new RSFF("START");
	}

	public static void connect() {
		DBBits.setInputPin(0, Bus1.DB());

		IAND1.setInputPin(0, Oper2.ldPSWH());
		IAND1.setInputPin(1, DBBits.getOut(7));
		IOR1.setInputPin(0, Oper2.stPSWI());
		IOR1.setInputPin(1, IAND1.getOut(0));
		INOT.setInputPin(0, DBBits.getOut(7));
		IAND2.setInputPin(0, Oper2.ldPSWH());
		IAND2.setInputPin(1, INOT.getOut(0));
		IOR2.setInputPin(0, IAND2.getOut(0));
		IOR2.setInputPin(1, Oper2.clPSWI());
		IRSFF.setPinE(new Pin(true));
		IRSFF.setPinClear(new Pin(false));
		IRSFF.setPinS(IOR1.getOut(0));
		IRSFF.setPinR(IOR2.getOut(0));

		TAND1.setInputPin(0, Oper2.ldPSWH());
		TAND1.setInputPin(1, DBBits.getOut(6));
		TOR1.setInputPin(0, Oper2.stPSWT());
		TOR1.setInputPin(1, TAND1.getOut(0));
		TNOT.setInputPin(0, DBBits.getOut(6));
		TAND2.setInputPin(0, Oper2.ldPSWH());
		TAND2.setInputPin(1, TNOT.getOut(0));
		TOR2.setInputPin(0, TAND2.getOut(0));
		TOR2.setInputPin(1, Oper2.clPSWT());
		TRSFF.setPinE(new Pin(true));
		TRSFF.setPinClear(new Pin(false));
		TRSFF.setPinS(TOR1.getOut(0));
		TRSFF.setPinR(TOR2.getOut(0));

		NAND1.setInputPin(0, Oper2.ldPSWL());
		NAND1.setInputPin(1, DBBits.getOut(0));
		NAND2.setInputPin(0, Oper2.ldN());
		NAND2.setInputPin(1, Exec3.N());
		NOR1.setInputPin(0, NAND2.getOut(0));
		NOR1.setInputPin(1, NAND1.getOut(0));
		NNOT1.setInputPin(0, DBBits.getOut(0));
		NAND3.setInputPin(0, Oper2.ldPSWL());
		NAND3.setInputPin(1, NNOT1.getOut(0));
		NNOT2.setInputPin(0, Exec3.N());
		NAND4.setInputPin(0, Oper2.ldN());
		NAND4.setInputPin(1, NNOT2.getOut(0));
		NOR2.setInputPin(0, NAND3.getOut(0));
		NOR2.setInputPin(1, NAND4.getOut(0));
		NRSFF.setPinE(new Pin(true));
		NRSFF.setPinClear(new Pin(false));
		NRSFF.setPinS(NOR1.getOut(0));
		NRSFF.setPinR(NOR2.getOut(0));

		ZAND1.setInputPin(0, Oper2.ldPSWL());
		ZAND1.setInputPin(1, DBBits.getOut(1));
		ZAND2.setInputPin(0, Oper2.ldZ());
		ZAND2.setInputPin(1, Exec3.Z());
		ZOR1.setInputPin(0, ZAND2.getOut(0));
		ZOR1.setInputPin(1, ZAND1.getOut(0));
		ZNOT1.setInputPin(0, DBBits.getOut(1));
		ZAND3.setInputPin(0, Oper2.ldPSWL());
		ZAND3.setInputPin(1, ZNOT1.getOut(0));
		ZNOT2.setInputPin(0, Exec3.Z());
		ZAND4.setInputPin(0, Oper2.ldZ());
		ZAND4.setInputPin(1, ZNOT2.getOut(0));
		ZOR2.setInputPin(0, ZAND3.getOut(0));
		ZOR2.setInputPin(1, ZAND4.getOut(0));
		ZRSFF.setPinE(new Pin(true));
		ZRSFF.setPinClear(new Pin(false));
		ZRSFF.setPinS(ZOR1.getOut(0));
		ZRSFF.setPinR(ZOR2.getOut(0));

		CAND1.setInputPin(0, Oper2.ldPSWL());
		CAND1.setInputPin(1, DBBits.getOut(2));
		CAND2.setInputPin(0, Oper2.ldC());
		CAND2.setInputPin(1, Exec3.C());
		COR1.setInputPin(0, CAND2.getOut(0));
		COR1.setInputPin(1, CAND1.getOut(0));
		CNOT1.setInputPin(0, DBBits.getOut(2));
		CAND3.setInputPin(0, Oper2.ldPSWL());
		CAND3.setInputPin(1, CNOT1.getOut(0));
		CNOT2.setInputPin(0, Exec3.C());
		CAND4.setInputPin(0, Oper2.ldC());
		CAND4.setInputPin(1, CNOT2.getOut(0));
		COR2.setInputPin(0, CAND3.getOut(0));
		COR2.setInputPin(1, CAND4.getOut(0));
		CRSFF.setPinE(new Pin(true));
		CRSFF.setPinClear(new Pin(false));
		CRSFF.setPinS(COR1.getOut(0));
		CRSFF.setPinR(COR2.getOut(0));

		VAND1.setInputPin(0, Oper2.ldPSWL());
		VAND1.setInputPin(1, DBBits.getOut(3));
		VAND2.setInputPin(0, Oper2.ldV());
		VAND2.setInputPin(1, Exec3.V());
		VOR1.setInputPin(0, VAND2.getOut(0));
		VOR1.setInputPin(1, VAND1.getOut(0));
		VNOT1.setInputPin(0, DBBits.getOut(3));
		VAND3.setInputPin(0, Oper2.ldPSWL());
		VAND3.setInputPin(1, VNOT1.getOut(0));
		VNOT2.setInputPin(0, Exec3.V());
		VAND4.setInputPin(0, Oper2.ldV());
		VAND4.setInputPin(1, VNOT2.getOut(0));
		VOR2.setInputPin(0, VAND3.getOut(0));
		VOR2.setInputPin(1, VAND4.getOut(0));
		VRSFF.setPinE(new Pin(true));
		VRSFF.setPinClear(new Pin(false));
		VRSFF.setPinS(VOR1.getOut(0));
		VRSFF.setPinR(VOR2.getOut(0));

		L0AND1.setInputPin(0, Oper2.ldPSWL());
		L0AND1.setInputPin(1, DBBits.getOut(4));
		L0AND2.setInputPin(0, Oper2.ldL());
		L0AND2.setInputPin(1, Intr2.prl0());
		L0OR1.setInputPin(0, L0AND2.getOut(0));
		L0OR1.setInputPin(1, L0AND1.getOut(0));
		L0NOT1.setInputPin(0, DBBits.getOut(4));
		L0AND3.setInputPin(0, Oper2.ldPSWL());
		L0AND3.setInputPin(1, L0NOT1.getOut(0));
		L0NOT2.setInputPin(0, Intr2.prl0());
		L0AND4.setInputPin(0, Oper2.ldL());
		L0AND4.setInputPin(1, L0NOT2.getOut(0));
		L0OR2.setInputPin(0, L0AND3.getOut(0));
		L0OR2.setInputPin(1, L0AND4.getOut(0));
		L0RSFF.setPinE(new Pin(true));
		L0RSFF.setPinClear(new Pin(false));
		L0RSFF.setPinS(L0OR1.getOut(0));
		L0RSFF.setPinR(L0OR2.getOut(0));

		L1AND1.setInputPin(0, Oper2.ldPSWL());
		L1AND1.setInputPin(1, DBBits.getOut(5));
		L1AND2.setInputPin(0, Oper2.ldL());
		L1AND2.setInputPin(1, Intr2.prl1());
		L1OR1.setInputPin(0, L1AND2.getOut(0));
		L1OR1.setInputPin(1, L1AND1.getOut(0));
		L1NOT1.setInputPin(0, DBBits.getOut(5));
		L1AND3.setInputPin(0, Oper2.ldPSWL());
		L1AND3.setInputPin(1, L1NOT1.getOut(0));
		L1NOT2.setInputPin(0, Intr2.prl1());
		L1AND4.setInputPin(0, Oper2.ldL());
		L1AND4.setInputPin(1, L1NOT2.getOut(0));
		L1OR2.setInputPin(0, L1AND3.getOut(0));
		L1OR2.setInputPin(1, L1AND4.getOut(0));
		L1RSFF.setPinE(new Pin(true));
		L1RSFF.setPinClear(new Pin(false));
		L1RSFF.setPinS(L1OR1.getOut(0));
		L1RSFF.setPinR(L1OR2.getOut(0));

		PSW.setInputPin(0, NRSFF.getOut(0));
		PSW.setInputPin(1, ZRSFF.getOut(0));
		PSW.setInputPin(2, CRSFF.getOut(0));
		PSW.setInputPin(3, VRSFF.getOut(0));
		PSW.setInputPin(4, L0RSFF.getOut(0));
		PSW.setInputPin(5, L1RSFF.getOut(0));
		for (int i = 6; i < 14; i++) {
			PSW.setInputPin(i, new Pin(false));
		}
		PSW.setInputPin(14, TRSFF.getOut(0));
		PSW.setInputPin(15, IRSFF.getOut(0));

		TSBPSWout.setInputPin(0, PSW.getOut(0));
		TSBPSWout.setCtrl(Oper2.PSWout());
		Bus1.addOnS2B(TSBPSWout.getOut(0));

		STARTRSFF.setInputPin(0, new Pin(false));
		STARTRSFF.setInputPin(1, Oper2.clSTART()); // izmenjeno
		//STARTRSFF.getOut(0).setBoolVal(true); 	//na pocetku setovan izlaz START na true
												//nema vise potrebe za STSTART i posebnim setovanjem izlaza RSFF
		STARTRSFF.setInit(true);

	}

	public static Pin PSWI() {
		return IRSFF.getOut(0);
	}

	public static Pin PSWT() {
		return TRSFF.getOut(0);
	}

	public static Pin PSWN() {
		return NRSFF.getOut(0);
	}

	public static Pin PSWZ() {
		return ZRSFF.getOut(0);
	}

	public static Pin PSWC() {
		return CRSFF.getOut(0);
	}

	public static Pin PSWV() {
		return VRSFF.getOut(0);
	}

	public static Pin PSWL0() {
		return L0RSFF.getOut(0);
	}

	public static Pin PSWL1() {
		return L1RSFF.getOut(0);
	}

	public static Pin START() {
		return STARTRSFF.getOut(0);
	}

	public static Pin PSW() {
		return PSW.getOut(0);
	}
	public static Pin PSWout() {
		return TSBPSWout.getOut(0);
	}

}
