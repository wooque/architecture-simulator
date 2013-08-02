package shemes;

import gui.GuiScheme;

import components.*;

public class Exec1 {
	public static CD CD1;
	public static MP MX1;
	public static CD CD2;
	public static MP MX2;
	public static IntToInt DBToAB;
	public static REG AB;
	public static IntToBools ABBits;
	public static IntToInt ABToTemp;
	public static TSB TSBAB1out;
	public static TSB TSBAB2out;
	public static REG BB;
	public static IntToBools BBBits;
	public static IntToInt BBToTemp;
	public static TSB TSBBBout;
	public static ALU ALUExec;
	public static IntToBools ALUBits;
	public static IntToInt ALUToTemp;
	public static TSB TSBALUout;
	public static IntToBools DBToBW;
	public static BoolsToInt DBHighBools;
	public static BoolsToInt DBLowBools;
	public static MP MPBWH;
	public static IntToBools MPBits;
	public static REG BWH;
	public static REG BWL;
	public static BoolsToInt BW;
	public static TSB TSBBWout;
	public static REG AW;
	public static TSB TSBAW1out;
	public static TSB TSBAW2out;

	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	private Exec1() {

	}

	public static void init() {

		CD1 = new CD(4);
		CD1.setE(new Pin(true));

		MX1 = new MP(4);

		CD2 = new CD(4);
		CD2.setE(new Pin(true));

		MX2 = new MP(4);

		DBToAB = new IntToInt(16, 8);

		AB = new REG(1, "AB");
		AB.getOut(0).setIsInt();
		AB.getOut(0).setNumOfLines(8);

		ABBits = new IntToBools(8, 8);

		ABToTemp = new IntToInt(8, 16);

		TSBAB1out = new TSB();
		TSBAB1out.getOut(0).setNumOfLines(16);

		TSBAB2out = new TSB();
		TSBAB2out.getOut(0).setNumOfLines(16);

		BB = new REG(1, "BB");
		BB.getOut(0).setIsInt();
		BB.getOut(0).setNumOfLines(8);

		BBBits = new IntToBools(8, 8);

		BBToTemp = new IntToInt(8, 16);

		TSBBBout = new TSB();
		TSBBBout.getOut(0).setNumOfLines(16);

		ALUExec = new ALU();

		ALUBits = new IntToBools(8, 8);

		ALUToTemp = new IntToInt(8, 16);

		TSBALUout = new TSB();
		TSBALUout.getOut(0).setNumOfLines(16);

		DBToBW = new IntToBools(16, 16);
		DBHighBools = new BoolsToInt(8, 8);
		DBLowBools = new BoolsToInt(8, 8);
		MPBWH = new MP(2);
		MPBWH.setE(new Pin(true));
		MPBits = new IntToBools(8, 8);

		BWH = new REG(8, "BWH");

		BWL = new REG(8, "BWL");

		BW = new BoolsToInt(16, 16);

		TSBBWout = new TSB();
		TSBBWout.getOut(0).setNumOfLines(16);

		AW = new REG(1, "AW");
		AW.getOut(0).setIsInt();
		AW.getOut(0).setNumOfLines(16);

		TSBAW1out = new TSB();
		TSBAW1out.getOut(0).setNumOfLines(16);

		TSBAW2out = new TSB();
		TSBAW2out.getOut(0).setNumOfLines(16);

	}

	public static void connect() {
		CD1.setInputPin(0, Fetch2.ASR());
		CD1.setInputPin(1, Fetch2.LSR());
		CD1.setInputPin(2, Fetch2.ROR());
		CD1.setInputPin(3, Fetch2.RORC());

		MX1.setCtrl(0, CD1.getOut(0));
		MX1.setCtrl(1, CD1.getOut(1));
		MX1.setInputPin(0, ABBits.getOut(7));
		MX1.setInputPin(1, new Pin(false));
		MX1.setInputPin(2, ABBits.getOut(0));
		MX1.setInputPin(3, Exec2.PSWC());

		CD2.setInputPin(0, Fetch2.ASL());
		CD2.setInputPin(1, Fetch2.LSL());
		CD2.setInputPin(2, Fetch2.ROL());
		CD2.setInputPin(3, Fetch2.ROLC());

		MX2.setCtrl(0, CD2.getOut(0));
		MX2.setCtrl(1, CD2.getOut(1));
		MX2.setInputPin(0, new Pin(false));
		MX2.setInputPin(1, new Pin(false));
		MX2.setInputPin(2, ABBits.getOut(7));
		MX2.setInputPin(3, Exec2.PSWC());

		DBToAB.setInputPin(0, Bus1.DB());

		AB.setInputPin(0, DBToAB.getOut(0));
		AB.setPinLd(Oper2.ldAB());
		AB.setShr(Oper2.shr());
		AB.setIR(MX1.getOut(0));
		AB.setShl(Oper2.shl());
		AB.setIL(MX2.getOut(0));

		ABBits.setInputPin(0, AB.getOut(0));

		ABToTemp.setInputPin(0, AB.getOut(0));

		TSBAB1out.setInputPin(0, ABToTemp.getOut(0));
		TSBAB1out.setCtrl(Oper2.AB1out());
		Bus1.addOnS1B(TSBAB1out.getOut(0));

		TSBAB2out.setInputPin(0, ABToTemp.getOut(0));
		TSBAB2out.setCtrl(Oper2.AB2out());
		Bus1.addOnS2B(TSBAB2out.getOut(0));

		BB.setInputPin(0, DBToAB.getOut(0));
		BB.setPinLd(Oper2.ldBB());

		BBBits.setInputPin(0, BB.getOut(0));

		BBToTemp.setInputPin(0, BB.getOut(0));

		TSBBBout.setInputPin(0, BBToTemp.getOut(0));
		TSBBBout.setCtrl(Oper2.BBout());
		Bus1.addOnDB(TSBBBout.getOut(0));

		ALUExec.setPinX(AB.getOut(0));
		ALUExec.setPinY(BB.getOut(0));
		ALUExec.setPinAdd(Oper2.add());
		ALUExec.setPinSub(Oper2.sub());
		ALUExec.setPinAnd(Oper2.and());
		ALUExec.setPinOr(Oper2.or());
		ALUExec.setPinXor(Oper2.xor());
		ALUExec.setPinNot(Oper2.not());

		ALUBits.setInputPin(0, ALUExec.getOut(0));

		ALUToTemp.setInputPin(0, ALUExec.getOut(0));

		TSBALUout.setInputPin(0, ALUToTemp.getOut(0));
		TSBALUout.setCtrl(Oper2.ALUout());
		Bus1.addOnDB(TSBALUout.getOut(0));

		DBToBW.setInputPin(0, Bus1.DB());
		for (int i = 0; i < 8; i++) {
			DBHighBools.setInputPin(i, DBToBW.getOut(8 + i));
			DBLowBools.setInputPin(i, DBToBW.getOut(i));
		}
		MPBWH.setInputPin(0, DBLowBools.getOut(0));
		MPBWH.setInputPin(1, DBHighBools.getOut(0));
		MPBWH.setCtrl(0, Oper2.mxBWH());
		MPBits.setInputPin(0, MPBWH.getOut(0));

		BWH.setPinLd(Oper2.ldBWH());
		BWL.setPinLd(Oper2.ldBWL());
		for (int i = 0; i < 8; i++) {
			BWH.setInputPin(i, MPBits.getOut(i));
			BWL.setInputPin(i, DBToBW.getOut(i));
		}

		for (int i = 0; i < 8; i++) {
			BW.setInputPin(i, BWL.getOut(i));
			BW.setInputPin(8 + i, BWH.getOut(i));
		}

		TSBBWout.setInputPin(0, BW.getOut(0));
		TSBBWout.setCtrl(Oper2.BWout());
		Bus1.addOnDB(TSBBWout.getOut(0));

		AW.setInputPin(0, Bus1.DB());
		AW.setPinLd(Oper2.ldAW());

		TSBAW1out.setInputPin(0, AW.getOut(0));
		TSBAW1out.setCtrl(Oper2.AW1out());
		Bus1.addOnS1B(TSBAW1out.getOut(0));

		TSBAW2out.setInputPin(0, AW.getOut(0));
		TSBAW2out.setCtrl(Oper2.AW2out());
		Bus1.addOnS2B(TSBAW2out.getOut(0));

	}

	public static Pin AB0() {
		return ABBits.getOut(0);
	}

	public static Pin AB1() {
		return ABBits.getOut(1);
	}

	public static Pin AB2() {
		return ABBits.getOut(2);
	}

	public static Pin AB3() {
		return ABBits.getOut(3);
	}

	public static Pin AB4() {
		return ABBits.getOut(4);
	}

	public static Pin AB5() {
		return ABBits.getOut(5);
	}

	public static Pin AB6() {
		return ABBits.getOut(6);
	}

	public static Pin AB7() {
		return ABBits.getOut(7);
	}

	public static Pin C8() {
		return ALUExec.getPinC8();
	}

	public static Pin ALU7() {
		return ALUBits.getOut(7);
	}

	public static Pin BB7() {
		return BBBits.getOut(7);
	}

	public static Pin AB() {
		return AB.getOut(0);
	}

	public static Pin BB() {
		return BB.getOut(0);
	}

	public static Pin ALU() {
		return ALUExec.getOut(0);
	}

	public static Pin BW() {
		return BW.getOut(0);
	}

	public static Pin AW() {
		return AW.getOut(0);
	}

	public static Pin AB1out() {
		return TSBAB1out.getOut(0);
	}

	public static Pin AB2out() {
		return TSBAB2out.getOut(0);
	}

	public static Pin BBout() {
		return TSBBBout.getOut(0);
	}

	public static Pin ALUout() {
		return TSBALUout.getOut(0);
	}

	public static Pin BWout() {
		return TSBBWout.getOut(0);
	}

	public static Pin AW1out() {
		return TSBAW1out.getOut(0);
	}

	public static Pin AW2out() {
		return TSBAW2out.getOut(0);
	}

	public static REG RegAB() {
		return AB;
	}

	public static REG RegBB() {
		return BB;
	}

	public static REG RegAW() {
		return AW;
	}

	public static REG RegBWH() {
		return BWH;
	}

	public static REG RegBWL() {
		return BWL;
	}
}
