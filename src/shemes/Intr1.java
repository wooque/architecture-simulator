package shemes;

import java.awt.Point;
import java.util.ArrayList;

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

	public static void gui() {
		gui = new GuiScheme("./src/images/intr1.png");
		ArrayList<ArrayList<Point>> sections = null;
		ArrayList<Point> points = null;
		GuiLine line = null;
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(127, 41));
		points.add(new Point(135, 41));
		sections.add(points);
		line = new GuiLine(sections, Oper2.stPRINS());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(127, 104));
		points.add(new Point(135, 104));
		sections.add(points);
		line = new GuiLine(sections, Oper2.clPRINS());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(205, 41));
		points.add(new Point(213, 41));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRINS());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(363, 41));
		points.add(new Point(371, 41));
		sections.add(points);
		line = new GuiLine(sections, Oper2.stPRCOD());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(363, 104));
		points.add(new Point(371, 104));
		sections.add(points);
		line = new GuiLine(sections, Oper2.clPRCOD());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(441, 41));
		points.add(new Point(449, 41));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRCOD());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(600, 41));
		points.add(new Point(608, 41));
		sections.add(points);
		line = new GuiLine(sections, Oper2.stPRADR());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(600, 104));
		points.add(new Point(608, 104));
		sections.add(points);
		line = new GuiLine(sections, Oper2.clPRADR());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(677, 41));
		points.add(new Point(685, 41));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRADR());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(127, 176));
		points.add(new Point(135, 176));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(127, 239));
		points.add(new Point(135, 239));
		sections.add(points);
		line = new GuiLine(sections, Oper2.clPRINM());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(205, 176));
		points.add(new Point(213, 176));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRINM());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(544, 137));
		points.add(new Point(519, 137));
		points.add(new Point(519, 168));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(420, 192));
		points.add(new Point(428, 192));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(519, 216));
		points.add(new Point(519, 248));
		sections.add(points);
		line = new GuiLine(sections, Intr1.IMR.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(525, 263));
		points.add(new Point(532, 263));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(477, 295));
		points.add(new Point(567, 295));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(519, 295));
		points.add(new Point(519, 276));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(126, 338));
		points.add(new Point(134, 338));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(126, 401));
		points.add(new Point(134, 401));
		sections.add(points);
		line = new GuiLine(sections, Intr1.DCintr1.getOut(1));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(204, 338));
		points.add(new Point(212, 338));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRINTR1());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(362, 338));
		points.add(new Point(370, 338));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(362, 401));
		points.add(new Point(370, 401));
		sections.add(points);
		line = new GuiLine(sections, Intr1.DCintr1.getOut(2));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(440, 338));
		points.add(new Point(448, 338));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRINTR2());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(596, 338));
		points.add(new Point(607, 338));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(599, 401));
		points.add(new Point(607, 401));
		sections.add(points);
		line = new GuiLine(sections, Intr1.DCintr1.getOut(3));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(676, 338));
		points.add(new Point(684, 338));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRINTR3());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(190, 453));
		points.add(new Point(204, 453));
		points.add(new Point(204, 476));
		points.add(new Point(207, 476));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRINS());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(190, 471));
		points.add(new Point(199, 471));
		points.add(new Point(199, 485));
		points.add(new Point(207, 485));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRCOD());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(190, 489));
		points.add(new Point(195, 489));
		points.add(new Point(195, 494));
		points.add(new Point(210, 494));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRADR());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(190, 507));
		points.add(new Point(195, 507));
		points.add(new Point(195, 503));
		points.add(new Point(210, 503));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRINM());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(190, 525));
		points.add(new Point(199, 525));
		points.add(new Point(199, 512));
		points.add(new Point(207, 512));
		sections.add(points);
		line = new GuiLine(sections, Intr2.printr());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(154, 561));
		points.add(new Point(162, 561));
		sections.add(points);
		line = new GuiLine(sections, Exec2.PSWT());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(154, 575));
		points.add(new Point(157, 575));
		sections.add(points);
		line = new GuiLine(sections, Fetch2.RTI());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(191, 568));
		points.add(new Point(204, 568));
		points.add(new Point(204, 521));
		points.add(new Point(207, 521));
		sections.add(points);
		line = new GuiLine(sections, Intr1.ANDprekid.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(236, 498));
		points.add(new Point(244, 498));
		sections.add(points);
		line = new GuiLine(sections, Intr1.prekid());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(363, 496));
		points.add(new Point(372, 496));
		sections.add(points);
		line = new GuiLine(sections, Intr2.prl1());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(363, 514));
		points.add(new Point(372, 514));
		sections.add(points);
		line = new GuiLine(sections, Intr2.prl0());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(404, 563));
		points.add(new Point(404, 555));
		sections.add(points);
		line = new GuiLine(sections, Oper2.clINTR());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(437, 482));
		points.add(new Point(445, 482));
		sections.add(points);
		line = new GuiLine(sections, Intr1.DCintr1.getOut(3));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(437, 500));
		points.add(new Point(445, 500));
		sections.add(points);
		line = new GuiLine(sections, Intr1.DCintr1.getOut(2));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(437, 518));
		points.add(new Point(445, 518));
		sections.add(points);
		line = new GuiLine(sections, Intr1.DCintr1.getOut(1));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(437, 536));
		points.add(new Point(445, 536));
		sections.add(points);
		line = new GuiLine(sections, Intr1.DCintr1.getOut(0));
		gui.addLine(line);

		// Docrtano za FlipFlopove linije za komplimente
		//
		// NOT PRINS:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(205, 104));
		points.add(new Point(213, 104));
		sections.add(points);
		line = new GuiLine(sections, PRINS.getOut(1));
		gui.addLine(line);

		//
		// NOT PRCOD:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(441, 104));
		points.add(new Point(449, 104));
		sections.add(points);
		line = new GuiLine(sections, PRCOD.getOut(1));
		gui.addLine(line);

		//
		// NOT PRADR:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(677, 104));
		points.add(new Point(685, 104));
		sections.add(points);
		line = new GuiLine(sections, PRADR.getOut(1));
		gui.addLine(line);

		//
		// NOT PRINM:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(205, 239));
		points.add(new Point(213, 239));
		sections.add(points);
		line = new GuiLine(sections, PRINM.getOut(1));
		gui.addLine(line);

		//
		// NOT PRINTR1:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(204, 401));
		points.add(new Point(212, 401));
		sections.add(points);
		line = new GuiLine(sections, PRINTR1.getOut(1));
		gui.addLine(line);

		//
		// NOT PRINTR2:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(440, 401));
		points.add(new Point(448, 401));
		sections.add(points);
		line = new GuiLine(sections, PRINTR2.getOut(1));
		gui.addLine(line);

		//
		// NOT PRINTR3:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(676, 401));
		points.add(new Point(684, 401));
		sections.add(points);
		line = new GuiLine(sections, PRINTR3.getOut(1));
		gui.addLine(line);

		// LABELE:
		gui.addLabel(new GuiLabel(530, 159, Bus1.DB()));
		gui.addLabel(new GuiLabel(530, 230, IMR.getOut(0)));
		gui.addLabel(new GuiLabel(572, 290, Bus1.S2B()));

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
