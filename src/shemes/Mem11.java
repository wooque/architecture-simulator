package shemes;

import gui.*;
import components.*;

public class Mem11 {
	public static TSB TSBRDB;
	public static NOT NOTRDB;
	public static AND ANDrdMEM;

	public static IntToBools ABUSBits;
	public static AND ANDselect;
	public static NOT NOTselect;

	public static TSB TSBWRB;
	public static NOT NOTWRB;
	public static AND ANDwrMEM;

	public static DFF rds;
	public static DFF wrs;
	public static OR rw;

	public static MEM RAM;
	public static REG PDR;
	public static TSB PDROUT;

	public static TSB TSBFCB;
	public static NOT NOTFCB;

	public static REG Mikroprekidaci;
	public static REG Time;
	public static OR ORTime;
	public static NOT NOTTime;
	public static BoolsToInt TIME;
	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void init() {
		TSBRDB = new TSB();
		TSBRDB.getOut(0).setIsBool();
		NOTRDB = new NOT();
		ANDrdMEM = new AND();

		ABUSBits = new IntToBools(16, 16);
		ANDselect = new AND(4);
		NOTselect = new NOT();

		TSBWRB = new TSB();
		TSBWRB.getOut(0).setIsBool();
		NOTWRB = new NOT();
		ANDwrMEM = new AND();

		rds = new DFF();
		rds.setPinClear(new Pin(false));
		rds.setPinE(new Pin(true));
		rds.setClock(3);
		wrs = new DFF();
		wrs.setPinClear(new Pin(false));
		wrs.setPinE(new Pin(true));
		wrs.setClock(3);
		rw = new OR();

		RAM = new MEM(64 * 1024); // 64 Kb
		RAM.getOut(0).setIsInt();
		RAM.getOut(0).setNumOfLines(8);
		RAM.setClock(3);
		PDR = new REG(1, "PDR");
		PDR.getOut(0).setIsInt();
		PDR.getOut(0).setNumOfLines(8);
		PDR.setClock(3);
		PDROUT = new TSB();
		PDROUT.getOut(0).setNumOfLines(8);

		TSBFCB = new TSB();
		TSBFCB.getOut(0).setIsBool();
		NOTFCB = new NOT();

		Mikroprekidaci = new REG(8, "Mikroprekidaci");// BOOLS
		Mikroprekidaci.setClock(3);
		Time = new REG(8, "TIME");
		Time.setClock(3);
		ORTime = new OR(8);
		NOTTime = new NOT();
		TIME = new BoolsToInt(8, 8);

	}

	public static void connect() {
		TSBRDB.setInputPin(0, Bus2.NotRDBUS());
		TSBRDB.setCtrl(new Pin(true));
		NOTRDB.setInputPin(0, TSBRDB.getOut(0));
		ANDrdMEM.setInputPin(0, NOTRDB.getOut(0));
		ANDrdMEM.setInputPin(1, NOTselect.getOut(0));

		ABUSBits.setInputPin(0, Bus1.ABUS());
		ANDselect.setInputPin(0, ABUSBits.getOut(12));
		ANDselect.setInputPin(1, ABUSBits.getOut(13));
		ANDselect.setInputPin(2, ABUSBits.getOut(14));
		ANDselect.setInputPin(3, ABUSBits.getOut(15));
		NOTselect.setInputPin(0, ANDselect.getOut(0));

		TSBWRB.setInputPin(0, Bus2.NotWRBUS());
		TSBWRB.setCtrl(new Pin(true));
		NOTWRB.setInputPin(0, TSBWRB.getOut(0));
		ANDwrMEM.setInputPin(0, NOTselect.getOut(0));
		ANDwrMEM.setInputPin(1, NOTWRB.getOut(0));

		rds.setPinD(ANDrdMEM.getOut(0));
		wrs.setPinD(ANDwrMEM.getOut(0));
		rw.setInputPin(0, rds.getOut(0));
		rw.setInputPin(1, wrs.getOut(0));

		RAM.setRead(rds.getOut(0));
		RAM.setWrite(wrs.getOut(0));
		RAM.setInputPin(0, Bus1.ABUS());
		RAM.setInputPin(1, Bus1.DBUS());
		PDR.setInputPin(0, RAM.getOut(0));
		PDR.setPinLd(Mem12.PDRin());
		PDROUT.setCtrl(Mem12.OEdata());
		PDROUT.setInputPin(0, PDR.getOut(0));
		Bus1.addOnDBUS(PDROUT.getOut(0));

		TSBFCB.setCtrl(Mem12.fcbus());
		TSBFCB.setInputPin(0, new Pin(true));
		NOTFCB.setInputPin(0, TSBFCB.getOut(0));
		Bus3.addOnNotFCBUS(NOTFCB.getOut(0));

		Mikroprekidaci.initVal(3);
		Time.setPinLd(Mem12.ldTIME());
		Time.setPinDec(Mem12.decTIME());
		for (int i = 0; i < 8; i++) {
			Time.setInputPin(i, Mikroprekidaci.getOut(i));
		}
		for (int i = 0; i < 8; i++) {
			ORTime.setInputPin(i, Time.getOut(i));
		}
		NOTTime.setInputPin(0, ORTime.getOut(0));
		for (int i = 0; i < 8; i++) {
			TIME.setInputPin(i, Time.getOut(i));
		}

	}

	public static Pin rdbus() {
		return NOTRDB.getOut(0);
	}

	public static Pin wrbus() {
		return NOTWRB.getOut(0);
	}

	public static Pin rds() {
		return rds.getOut(0);
	}

	public static Pin wrs() {
		return wrs.getOut(0);
	}

	public static Pin rw() {
		return rw.getOut(0);
	}

	public static Pin access() {
		return NOTTime.getOut(0);
	}

	public static Pin PDR() {
		return PDR.getOut(0);
	}

	public static Pin PDRout() {
		return PDROUT.getOut(0);
	}

	public static Pin TIME() {
		return TIME.getOut(0);
	}

	public static void writeMEM(int adress, int data) {
		RAM.write(adress, data);
	}

	public static int readMEM(int adress) {
		return RAM.read(adress);
	}

	public static MEM getMEM() {
		return RAM;
	}
}
