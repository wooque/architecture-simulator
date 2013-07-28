package shemes;

import java.awt.Point;
import java.util.ArrayList;

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

	public static void gui() {
		gui = new GuiScheme("./src/images/intr3.png");
		ArrayList<ArrayList<Point>> sections = null;
		ArrayList<Point> points = null;
		GuiLine line = null;
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(43, 32));
		points.add(new Point(43, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(44, 32));
		points.add(new Point(44, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(45, 32));
		points.add(new Point(45, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(46, 32));
		points.add(new Point(46, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(47, 32));
		points.add(new Point(47, 600));
		sections.add(points);
		points.add(new Point(47, 539));
		points.add(new Point(188, 539));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(189, 538));
		points.add(new Point(47, 538));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(92, 32));
		points.add(new Point(92, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(93, 32));
		points.add(new Point(93, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(94, 32));
		points.add(new Point(94, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(95, 32));
		points.add(new Point(95, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(96, 32));
		points.add(new Point(96, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(96, 425));
		points.add(new Point(299, 425));
		points.add(new Point(299, 449));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(97, 371));
		points.add(new Point(229, 371));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(97, 235));
		points.add(new Point(139, 235));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(210, 102));
		points.add(new Point(219, 102));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRCOD());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(210, 120));
		points.add(new Point(219, 120));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRADR());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(210, 137));
		points.add(new Point(219, 137));
		sections.add(points);
		line = new GuiLine(sections, Intr1.PRINM());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(210, 154));
		points.add(new Point(219, 154));
		sections.add(points);
		line = new GuiLine(sections, Exec2.PSWT());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(284, 120));
		points.add(new Point(308, 120));
		sections.add(points);
		line = new GuiLine(sections, Intr3.CD1.getOut(1));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(284, 137));
		points.add(new Point(308, 137));
		sections.add(points);
		line = new GuiLine(sections, Intr3.CD1.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(340, 92));
		points.add(new Point(357, 92));
		sections.add(points);
		line = new GuiLine(sections, Intr3.UINT.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(456, 104));
		points.add(new Point(465, 104));
		sections.add(points);
		line = new GuiLine(sections, Intr2.irm3());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(456, 122));
		points.add(new Point(465, 122));
		sections.add(points);
		line = new GuiLine(sections, Intr2.irm2());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(456, 138));
		points.add(new Point(465, 138));
		sections.add(points);
		line = new GuiLine(sections, Intr2.irm1());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(456, 154));
		points.add(new Point(465, 154));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(530, 121));
		points.add(new Point(554, 121));
		sections.add(points);
		line = new GuiLine(sections, Intr3.CD2.getOut(1));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(530, 138));
		points.add(new Point(554, 138));
		sections.add(points);
		line = new GuiLine(sections, Intr3.CD2.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(587, 94));
		points.add(new Point(604, 94));
		sections.add(points);
		line = new GuiLine(sections, Intr3.UEXT.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(210, 245));
		points.add(new Point(319, 245));
		sections.add(points);
		line = new GuiLine(sections, Intr3.S2BToMX0.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(310, 228));
		points.add(new Point(319, 228));
		sections.add(points);
		line = new GuiLine(sections, Intr3.UEXT());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(310, 212));
		points.add(new Point(319, 212));
		sections.add(points);
		line = new GuiLine(sections, Intr3.UINT());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(310, 193));
		points.add(new Point(319, 193));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(334, 276));
		points.add(new Point(334, 271));
		points.add(new Point(346, 271));
		points.add(new Point(346, 264));
		sections.add(points);
		line = new GuiLine(sections, Oper2.mxBR0());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(381, 276));
		points.add(new Point(381, 271));
		points.add(new Point(370, 271));
		points.add(new Point(370, 264));
		sections.add(points);
		line = new GuiLine(sections, Oper2.mxBR1());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(390, 223));
		points.add(new Point(571, 223));
		points.add(new Point(571, 265));
		sections.add(points);
		line = new GuiLine(sections, Intr3.MX.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(570, 315));
		points.add(new Point(570, 355));
		sections.add(points);
		line = new GuiLine(sections, Intr3.BR.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(548, 417));
		points.add(new Point(548, 445));
		points.add(new Point(440, 445));
		points.add(new Point(440, 371));
		points.add(new Point(258, 371));
		sections.add(points);
		line = new GuiLine(sections, Intr3.IVTDSP());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(244, 386));
		points.add(new Point(244, 379));
		sections.add(points);
		line = new GuiLine(sections, Oper2.IVTDSPout());
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(299, 500));
		points.add(new Point(299, 538));
		points.add(new Point(220, 538));
		sections.add(points);
		line = new GuiLine(sections, Intr3.IVTP.getOut(0));
		gui.addLine(line);
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(204, 553));
		points.add(new Point(204, 546));
		sections.add(points);
		line = new GuiLine(sections, Oper2.IVTPout());
		gui.addLine(line);

		// NIJE BILO NACRTSNO:
		// ldBR:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(462, 302));
		points.add(new Point(471, 302));
		sections.add(points);
		line = new GuiLine(sections, Oper2.ldBR());
		gui.addLine(line);
		//
		// ldIVTP:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(190, 487));
		points.add(new Point(199, 487));
		sections.add(points);
		line = new GuiLine(sections, Oper2.ldIVTP());
		gui.addLine(line);

		//
		// Dodato iscrtavanje za linije koje imaju nula na ulazu:

		// Uint odozgo:
		// 1 nula:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(304, 50));
		points.add(new Point(310, 50));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);

		//
		// 2 nula:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(302, 85));
		points.add(new Point(308, 85));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);

		//
		// 3 nula:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(301, 102));
		points.add(new Point(307, 102));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);

		// UEXT odozgo:
		// 1 nula:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(550, 52));
		points.add(new Point(556, 52));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);

		//
		// 2 nula:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(548, 87));
		points.add(new Point(554, 87));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);

		//
		// 1 jedinica:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(548, 104));
		points.add(new Point(554, 104));
		sections.add(points);
		line = new GuiLine(sections, new Pin(true));
		gui.addLine(line);

		// IVTDSP s leva na desno:
		// 1 nula:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(491, 373));
		points.add(new Point(491, 383));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);

		//
		// 2 nula:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(531, 373));
		points.add(new Point(531, 383));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);

		//
		// najvisi bit od BR:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(551, 373));
		points.add(new Point(551, 383));
		sections.add(points);
		line = new GuiLine(sections, BRBits.getOut(7));
		gui.addLine(line);

		//
		// najnizi bit od BR:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(590, 373));
		points.add(new Point(590, 383));
		sections.add(points);
		line = new GuiLine(sections, BRBits.getOut(0));
		gui.addLine(line);

		//
		// 3 nula:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(610, 373));
		points.add(new Point(610, 383));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);

		// LABELE:
		gui.addLabel(new GuiLabel(53, 46, Bus1.S1B()));
		gui.addLabel(new GuiLabel(101, 46, Bus1.S2B()));
		gui.addLabel(new GuiLabel(338, 84, UINT.getOut(0)));
		gui.addLabel(new GuiLabel(584, 87, UEXT.getOut(0)));
		gui.addLabel(new GuiLabel(225, 260, S2BToMX0.getOut(0)));
		gui.addLabel(new GuiLabel(579, 255, MX.getOut(0)));
		gui.addLabel(new GuiLabel(579, 329, BR.getOut(0)));
		gui.addLabel(new GuiLabel(560, 433, IVTDSP.getOut(0)));
		gui.addLabel(new GuiLabel(308, 440, Bus1.S2B()));
		gui.addLabel(new GuiLabel(308, 515, IVTP.getOut(0)));

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
