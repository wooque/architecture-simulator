package shemes;

import java.awt.Point;
import java.util.ArrayList;

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

	public static void gui() {
		gui = new GuiScheme("./src/images/mem11.png");
		ArrayList<ArrayList<Point>> sections = null;
		ArrayList<Point> points = null;
		GuiLine line = null;
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(78, 79));
		points.add(new Point(778, 79));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(527, 79));
		points.add(new Point(527, 220));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(643, 79));
		points.add(new Point(643, 95));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DBUS());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(78, 101));
		points.add(new Point(496, 101));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(478, 101));
		points.add(new Point(478, 220));
		sections.add(points);
		line = new GuiLine(sections, Bus1.ABUS());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(644, 126));
		points.add(new Point(644, 140));
		sections.add(points);
		line = new GuiLine(sections, Mem11.PDR.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(642, 220));
		points.add(new Point(642, 186));
		sections.add(points);
		line = new GuiLine(sections, Mem11.RAM.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(303, 141));
		points.add(new Point(422, 141));
		points.add(new Point(422, 252));
		points.add(new Point(447, 252));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(327, 141));
		points.add(new Point(327, 227));
		points.add(new Point(337, 227));
		sections.add(points);
		line = new GuiLine(sections, Mem11.rds.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(303, 274));
		points.add(new Point(447, 274));
		points.add(new Point(327, 274));
		points.add(new Point(327, 241));
		points.add(new Point(337, 241));
		sections.add(points);
		line = new GuiLine(sections, Mem11.wrs.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(79, 134));
		points.add(new Point(100, 134));
		sections.add(points);
		line = new GuiLine(sections, Bus2.NotRDBUS());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(135, 134));
		points.add(new Point(169, 134));
		sections.add(points);
		line = new GuiLine(sections, Mem11.NOTRDB.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(135, 186));
		points.add(new Point(148, 186));
		points.add(new Point(148, 147));
		points.add(new Point(169, 147));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(148, 186));
		points.add(new Point(148, 265));
		points.add(new Point(169, 265));
		sections.add(points);
		line = new GuiLine(sections, Mem11.NOTselect.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(78, 281));
		points.add(new Point(100, 281));
		sections.add(points);
		line = new GuiLine(sections, Bus2.NotWRBUS());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(134, 280));
		points.add(new Point(169, 280));
		sections.add(points);
		line = new GuiLine(sections, Mem11.NOTWRB.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(198, 140));
		points.add(new Point(234, 140));
		sections.add(points);
		line = new GuiLine(sections, Mem11.ANDrdMEM.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(198, 274));
		points.add(new Point(234, 274));
		sections.add(points);
		line = new GuiLine(sections, Mem11.ANDwrMEM.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(82, 163));
		points.add(new Point(100, 163));
		sections.add(points);
		line = new GuiLine(sections, ABUSBits.getOut(15));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(82, 179));
		points.add(new Point(100, 179));
		sections.add(points);
		line = new GuiLine(sections, ABUSBits.getOut(14));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(82, 197));
		points.add(new Point(100, 197));
		sections.add(points);
		line = new GuiLine(sections, ABUSBits.getOut(13));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(82, 212));
		points.add(new Point(100, 212));
		sections.add(points);
		line = new GuiLine(sections, ABUSBits.getOut(12));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(171, 428));
		points.add(new Point(134, 428));
		sections.add(points);
		line = new GuiLine(sections, Mem12.fcbus());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(120, 421));
		points.add(new Point(120, 410));
		sections.add(points);
		line = new GuiLine(sections, Mem12.OEfcbus());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(100, 429));
		points.add(new Point(77, 429));
		sections.add(points);
		line = new GuiLine(sections, Bus3.NotFCBUS());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(636, 503));
		points.add(new Point(636, 514));
		sections.add(points);
		line = new GuiLine(sections, Mem11.access());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(714, 406));
		points.add(new Point(725, 406));
		sections.add(points);
		line = new GuiLine(sections, Mem12.ldTIME());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(714, 422));
		points.add(new Point(726, 422));
		sections.add(points);
		line = new GuiLine(sections, Mem12.decTIME());
		gui.addLine(line);

		// Nisu bile iscrtane:
		// PDRin:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(724, 154));
		points.add(new Point(735, 154));
		sections.add(points);
		line = new GuiLine(sections, Mem12.PDRin());
		gui.addLine(line);

		//
		// NOT rds:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(303, 203));
		points.add(new Point(311, 203));
		sections.add(points);
		line = new GuiLine(sections, rds.getOut(1));
		gui.addLine(line);

		//
		// NOT wrs:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(303, 336));
		points.add(new Point(311, 336));
		sections.add(points);
		line = new GuiLine(sections, wrs.getOut(1));
		gui.addLine(line);

		//
		// Najvisi bit mikroprekidaca:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(576, 375));
		points.add(new Point(576, 391));
		sections.add(points);
		line = new GuiLine(sections, Mikroprekidaci.getOut(7));
		gui.addLine(line);

		//
		// Najnizi bit mikroprekidaca:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(685, 375));
		points.add(new Point(685, 391));
		sections.add(points);
		line = new GuiLine(sections, Mikroprekidaci.getOut(0));
		gui.addLine(line);

		//
		// Najvisi bit registra TIME:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(576, 438));
		points.add(new Point(576, 455));
		points.add(new Point(620, 455));
		points.add(new Point(620, 469));
		sections.add(points);
		line = new GuiLine(sections, Time.getOut(7));
		gui.addLine(line);

		//
		// Najnizi bit registra TIME:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(685, 438));
		points.add(new Point(685, 455));
		points.add(new Point(651, 455));
		points.add(new Point(651, 469));
		sections.add(points);
		line = new GuiLine(sections, Time.getOut(0));
		gui.addLine(line);

		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(363, 234));
		points.add(new Point(373, 234));
		sections.add(points);
		line = new GuiLine(sections, Mem11.rw());
		gui.addLine(line);

		//
		// memCLK kod RD ff:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(226, 172));
		points.add(new Point(234, 172));
		sections.add(points);
		line = new GuiLine(sections, LogicalComponent.getMEMCLK());
		gui.addLine(line);

		//
		// memCLK kod WR ff:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(226, 305));
		points.add(new Point(234, 305));
		sections.add(points);
		line = new GuiLine(sections, LogicalComponent.getMEMCLK());
		gui.addLine(line);

		//
		// memCLK kod PDR:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(555, 163));
		points.add(new Point(563, 163));
		sections.add(points);
		line = new GuiLine(sections, LogicalComponent.getMEMCLK());
		gui.addLine(line);

		//
		// memCLK kod TIME:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(544, 414));
		points.add(new Point(552, 414));
		sections.add(points);
		line = new GuiLine(sections, LogicalComponent.getMEMCLK());
		gui.addLine(line);

		//
		// LABELE:
		gui.addLabel(new GuiLabel(131, 75, Bus1.DBUS()));
		gui.addLabel(new GuiLabel(131, 97, Bus1.ABUS()));
		gui.addLabel(new GuiLabel(651, 137, PDR.getOut(0)));
		gui.addLabel(new GuiLabel(483, 200, Bus1.ABUS()));
		gui.addLabel(new GuiLabel(532, 200, Bus1.DBUS()));
		gui.addLabel(new GuiLabel(647, 200, RAM.getOut(0)));
		gui.addLabel(new GuiLabel(667, 470, Mem11.TIME()));
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
