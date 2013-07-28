package shemes;

import gui.GuiLabel;
import gui.GuiLine;
import gui.GuiScheme;

import java.awt.Point;
import java.util.ArrayList;

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

	public static void gui() {

		GuiLine line; // Pomocna promenljiva
		gui = new GuiScheme("./src/images/fetch1.png");
		ArrayList<ArrayList<Point>> sections;
		ArrayList<Point> points;

		// DB to PC:
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(732, 45));
		points.add(new Point(360, 45));
		points.add(new Point(360, 86));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		//
		// incPC
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(281, 95));
		points.add(new Point(288, 95));
		sections.add(points);
		line = new GuiLine(sections, Oper1.incPC());
		gui.addLine(line);

		//
		// ldPC:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(281, 113));
		points.add(new Point(287, 113));
		sections.add(points);
		line = new GuiLine(sections, Oper1.ldPC());
		gui.addLine(line);

		// PC to S2B:
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(360, 123));
		points.add(new Point(360, 147));
		points.add(new Point(169, 147));
		sections.add(points);
		line = new GuiLine(sections, Fetch1.PC());
		gui.addLine(line);

		//
		// PC to S1B:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(360, 147));
		points.add(new Point(360, 195));
		points.add(new Point(176, 195));
		sections.add(points);
		line = new GuiLine(sections, Fetch1.PC());
		gui.addLine(line);

		//
		// PC2out:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(157, 129));
		points.add(new Point(157, 142));
		sections.add(points);
		line = new GuiLine(sections, Oper1.PC2out());
		gui.addLine(line);

		//
		// PC@out to S2B:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(147, 147));
		points.add(new Point(107, 147));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);

		//
		// PC1out:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(164, 178));
		points.add(new Point(164, 190));
		sections.add(points);
		line = new GuiLine(sections, Oper1.PC1out());
		gui.addLine(line);

		//
		// PC1out to S1B:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(154, 195));
		points.add(new Point(71, 195));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);

		// S1B:
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(68, 23));
		points.add(new Point(68, 599));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(69, 23));
		points.add(new Point(69, 599));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(70, 23));
		points.add(new Point(70, 599));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);

		// S2B:
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(104, 23));
		points.add(new Point(104, 599));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(105, 23));
		points.add(new Point(105, 599));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(106, 23));
		points.add(new Point(106, 599));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);

		// DB:
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(732, 23));
		points.add(new Point(732, 599));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(733, 23));
		points.add(new Point(733, 599));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(734, 23));
		points.add(new Point(734, 599));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		//
		// DB to IR:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(731, 209));
		points.add(new Point(645, 209));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		//
		// DB to IR0:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(599, 213));
		points.add(new Point(216, 213));
		points.add(new Point(216, 257));
		sections.add(points);
		line = new GuiLine(sections, DBToTemp.getOut(0));
		gui.addLine(line);

		//
		// DB to IR1:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(372, 213));
		points.add(new Point(372, 257));
		sections.add(points);
		line = new GuiLine(sections, DBToTemp.getOut(0));
		gui.addLine(line);

		//
		// DB to IR2:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(517, 214));
		points.add(new Point(517, 257));
		sections.add(points);
		line = new GuiLine(sections, DBToTemp.getOut(0));
		gui.addLine(line);

		//
		// DB To IR3:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(582, 214));
		points.add(new Point(582, 236));
		points.add(new Point(671, 236));
		points.add(new Point(671, 257));
		sections.add(points);
		line = new GuiLine(sections, DBToTemp.getOut(0));
		gui.addLine(line);

		//
		// ldIR0:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(155, 278));
		points.add(new Point(160, 278));
		sections.add(points);
		line = new GuiLine(sections, Oper1.ldIR0());
		gui.addLine(line);

		//
		// ldIR1:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(308, 277));
		points.add(new Point(315, 277));
		sections.add(points);
		line = new GuiLine(sections, Oper1.ldIR1());
		gui.addLine(line);

		//
		// ldIR2:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(456, 279));
		points.add(new Point(461, 279));
		sections.add(points);
		line = new GuiLine(sections, Oper1.ldIR2());
		gui.addLine(line);

		//
		// ldIR3:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(607, 279));
		points.add(new Point(614, 279));
		sections.add(points);
		line = new GuiLine(sections, Oper1.ldIR3());
		gui.addLine(line);

		//
		// IR1 to JDISP:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(370, 313));
		points.add(new Point(370, 356));
		points.add(new Point(201, 356));
		sections.add(points);
		line = new GuiLine(sections, IR1ToTemp.getOut(0));
		gui.addLine(line);

		//
		// IR1 to INTENTRY:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(370, 356));
		points.add(new Point(370, 410));
		points.add(new Point(203, 410));
		sections.add(points);
		line = new GuiLine(sections, IR1ToTemp.getOut(0));
		gui.addLine(line);

		//
		// IR23...:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(217, 338));
		points.add(new Point(201, 338));
		sections.add(points);
		line = new GuiLine(sections, JDISP.getOut(0));
		gui.addLine(line);

		//
		// 0... za INT:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(219, 392));
		points.add(new Point(203, 392));
		sections.add(points);
		line = new GuiLine(sections, INTENTRY.getOut(0));
		gui.addLine(line);

		//
		// IR1 to JDISP TSB:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(195, 349));
		points.add(new Point(166, 349));
		sections.add(points);
		line = new GuiLine(sections, TempToJDISP.getOut(0));
		gui.addLine(line);

		//
		// JDISPout:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(154, 332));
		points.add(new Point(154, 344));
		sections.add(points);
		line = new GuiLine(sections, Oper1.JDISPout());
		gui.addLine(line);

		//
		// JDISPout to S2B:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(144, 349));
		points.add(new Point(107, 349));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);

		//
		// IR1 to TSB ENTRY:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(197, 403));
		points.add(new Point(168, 403));
		sections.add(points);
		line = new GuiLine(sections, TempToIENTRY.getOut(0));
		gui.addLine(line);

		//
		// INTENTRYout:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(156, 385));
		points.add(new Point(156, 398));
		sections.add(points);
		line = new GuiLine(sections, Oper1.INTENTRYout());
		gui.addLine(line);

		//
		// INTENTRY to S2B:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(146, 403));
		points.add(new Point(107, 403));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);

		//
		// IR15... za PCRDISP:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(221, 466));
		points.add(new Point(205, 466));
		sections.add(points);
		line = new GuiLine(sections, PCRDISP.getOut(0));
		gui.addLine(line);

		//
		// IR2 to PCRDISP:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(519, 314));
		points.add(new Point(519, 484));
		points.add(new Point(205, 484));
		sections.add(points);
		line = new GuiLine(sections, IR2ToTemp.getOut(0));
		gui.addLine(line);

		//
		// PCRDISP:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(199, 477));
		points.add(new Point(170, 477));
		sections.add(points);
		line = new GuiLine(sections, TempToPCRDISP.getOut(0));
		gui.addLine(line);

		//
		// PCRDISPout:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(158, 459));
		points.add(new Point(158, 472));
		sections.add(points);
		line = new GuiLine(sections, Oper1.PCRDISPout());
		gui.addLine(line);

		//
		// TSB PCRDISP to S2B:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(148, 477));
		points.add(new Point(107, 477));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);

		//
		// IR23 to TSB REGIDISP:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(595, 356));
		points.add(new Point(595, 378));
		points.add(new Point(573, 378));
		points.add(new Point(573, 548));
		points.add(new Point(169, 548));
		sections.add(points);
		line = new GuiLine(sections, IR23ToREGIDISP.getOut(0));
		gui.addLine(line);

		//
		// REGIDISPout
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(157, 531));
		points.add(new Point(157, 543));
		sections.add(points);
		line = new GuiLine(sections, Oper1.REGIDISPout());
		gui.addLine(line);

		//
		// TSB REGIDISPout to S2B:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(147, 548));
		points.add(new Point(107, 548));
		sections.add(points);
		line = new GuiLine(sections, TSBREGIDISPout.getOut(0));
		gui.addLine(line);

		//
		// 0...0 za IMM:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(608, 399));
		points.add(new Point(626, 399));
		sections.add(points);
		line = new GuiLine(sections, IMM.getOut(0));
		gui.addLine(line);

		//
		// IR2 to TSB IMMout:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(520, 414));
		points.add(new Point(628, 414));
		sections.add(points);
		line = new GuiLine(sections, IR2ToTemp.getOut(0));
		gui.addLine(line);

		//
		// 0..0,IR2 to TSB IMMout:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(631, 405));
		points.add(new Point(660, 405));
		sections.add(points);
		line = new GuiLine(sections, TempToIMM.getOut(0));
		gui.addLine(line);

		//
		// IMMout:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(672, 394));
		points.add(new Point(672, 400));
		sections.add(points);
		line = new GuiLine(sections, Oper1.IMMout());
		gui.addLine(line);

		//
		// TSB IMM to DB:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(681, 405));
		points.add(new Point(731, 405));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		//
		// IR23 to TSB JAPSout:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(444, 336));
		points.add(new Point(444, 460));
		points.add(new Point(661, 460));
		sections.add(points);
		line = new GuiLine(sections, IR12ToJAPS.getOut(0));
		gui.addLine(line);

		//
		// JAPSout:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(673, 450));
		points.add(new Point(673, 455));
		sections.add(points);
		line = new GuiLine(sections, Oper1.JAPSout());
		gui.addLine(line);

		//
		// TSB JAPSoujt to DB:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(682, 460));
		points.add(new Point(731, 460));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// LABELE:
		gui.addLabel(new GuiLabel(75, 37, Bus1.S1B()));
		gui.addLabel(new GuiLabel(111, 37, Bus1.S2B()));
		gui.addLabel(new GuiLabel(739, 37, Bus1.DB()));
		gui.addLabel(new GuiLabel(368, 137, PC.getOut(0)));
		gui.addLabel(new GuiLabel(368, 76, Bus1.DB()));
		gui.addLabel(new GuiLabel(651, 205, Bus1.DB()));
		gui.addLabel(new GuiLabel(228, 248, DBToTemp.getOut(0)));
		gui.addLabel(new GuiLabel(383, 248, DBToTemp.getOut(0)));
		gui.addLabel(new GuiLabel(529, 248, DBToTemp.getOut(0)));
		gui.addLabel(new GuiLabel(682, 248, DBToTemp.getOut(0)));
		gui.addLabel(new GuiLabel(170, 344, TempToJDISP.getOut(0)));
		gui.addLabel(new GuiLabel(172, 398, TempToIENTRY.getOut(0)));
		gui.addLabel(new GuiLabel(174, 472, TempToPCRDISP.getOut(0)));
		gui.addLabel(new GuiLabel(173, 543, IR23ToREGIDISP.getOut(0)));
		gui.addLabel(new GuiLabel(375, 347, IR1ToTemp.getOut(0)));
		gui.addLabel(new GuiLabel(449, 370, IR12ToJAPS.getOut(0)));
		gui.addLabel(new GuiLabel(524, 370, IR2ToTemp.getOut(0)));
		gui.addLabel(new GuiLabel(602, 370, IR23ToREGIDISP.getOut(0)));
		gui.addLabel(new GuiLabel(637, 399, TempToIMM.getOut(0)));
		gui.addLabel(new GuiLabel(639, 455, IR12ToJAPS.getOut(0)));

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
