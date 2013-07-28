package shemes;

import gui.GuiLabel;
import gui.GuiLine;
import gui.GuiScheme;

import java.awt.Point;
import java.util.ArrayList;

import components.*;

public class Bus1 {

	public static REG MAR, MDR;
	public static MP MX1;
	public static OR OR1;
	public static AND AND1;
	public static TSB S2Dout, DS1out, MDRout, MARABUSOut, MDRDBUSOut;
	public static BUS S1B, S2B, DB;
	public static BUS ABUS, DBUS;
	private static IntToInt S2Bhigh, S2Blow;
	// private static IntToInt DBlow;
	private static IntToInt MDRlow;
	private static int abusi = 0, dbusi = 0, dbi = 0, s1bi = 0, s2bi = 0;

	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui() {

		GuiLine line; // Pomocna promenljiva
		gui = new GuiScheme("./src/images/bus1.png");

		ArrayList<ArrayList<Point>> sections;
		ArrayList<Point> points;

		// Magistrala S1B
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(71, 23));
		points.add(new Point(71, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(70, 23));
		points.add(new Point(70, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(72, 23));
		points.add(new Point(72, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(73, 109));
		points.add(new Point(299, 109));
		points.add(new Point(299, 139));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);

		// Magistrala S2B
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(106, 23));
		points.add(new Point(106, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(107, 23));
		points.add(new Point(107, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(108, 23));
		points.add(new Point(108, 600));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(109, 42));
		points.add(new Point(203, 42));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(109, 419));
		points.add(new Point(609, 419));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);

		// Magistrala DB
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(731, 23));
		points.add(new Point(731, 596));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(730, 23));
		points.add(new Point(730, 596));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(732, 23));
		points.add(new Point(732, 596));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(729, 483));
		points.add(new Point(229, 483));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// Izlaz S2Dout
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(631, 420));
		points.add(new Point(729, 420));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// Izlaz DS1out
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(207, 483));
		points.add(new Point(73, 483));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);

		//
		// DBUS kod MX:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(455, 102));
		points.add(new Point(499, 102));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DBUS());
		gui.addLine(line);

		// Sa DBUS na Mx
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(478, 102));
		points.add(new Point(478, 59));
		points.add(new Point(546, 59));
		points.add(new Point(546, 87));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DBUS());
		gui.addLine(line);

		// S2Blow to MX:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(250, 54));
		points.add(new Point(563, 54));
		points.add(new Point(563, 87));
		sections.add(points);
		line = new GuiLine(sections, S2Blow.getOut(0));
		gui.addLine(line);

		//
		// S2Bhigh to MX:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(250, 38));
		points.add(new Point(581, 38));
		points.add(new Point(581, 87));
		sections.add(points);
		line = new GuiLine(sections, S2Bhigh.getOut(0));
		gui.addLine(line);

		// Sa izlaza MX
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(571, 125));
		points.add(new Point(571, 139));
		sections.add(points);
		line = new GuiLine(sections, Bus1.MX1());
		gui.addLine(line);

		// Sa izlaza MDR-a
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(571, 176));
		points.add(new Point(571, 232));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(571, 204));
		points.add(new Point(640, 204));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(676, 197));
		points.add(new Point(689, 197));
		sections.add(points);
		line = new GuiLine(sections, Bus1.MDR());
		gui.addLine(line);

		// Izlaz MDRout-a
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(712, 198));
		points.add(new Point(729, 198));
		sections.add(points);
		line = new GuiLine(sections, Bus1.MDRoutToDB());
		gui.addLine(line);

		// Izlaz trostatickog bafera iz MDR-a na magistralu DB
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(571, 254));
		points.add(new Point(571, 276));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// Izlaz MAR-a
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(299, 176));
		points.add(new Point(299, 201));
		sections.add(points);
		line = new GuiLine(sections, Bus1.MAR());
		gui.addLine(line);

		// Izlaz trostatickog bafera na izlazu MAR-a
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(299, 224));
		points.add(new Point(299, 246));
		sections.add(points);
		line = new GuiLine(sections, Bus1.MARABUSOut.getOut(0));
		gui.addLine(line);

		//
		// ABUS ispod MAR:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(276, 247));
		points.add(new Point(321, 247));
		sections.add(points);
		line = new GuiLine(sections, Bus1.ABUS());
		gui.addLine(line);

		// ldMAR
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(219, 149));
		points.add(new Point(227, 149));
		sections.add(points);
		line = new GuiLine(sections, Oper1.ldMAR());
		gui.addLine(line);

		// incMAR
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(219, 167));
		points.add(new Point(227, 167));
		sections.add(points);
		line = new GuiLine(sections, Oper1.incMAR());
		gui.addLine(line);

		// mxMDR0
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(616, 101));
		points.add(new Point(607, 101));
		sections.add(points);
		line = new GuiLine(sections, Oper1.mxMDR0());
		gui.addLine(line);

		// mxMDR1
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(616, 113));
		points.add(new Point(607, 113));
		sections.add(points);
		line = new GuiLine(sections, Oper1.mxMDR1());
		gui.addLine(line);

		// iz JFCa u I kolo
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(426, 170));
		points.add(new Point(435, 170));
		sections.add(points);
		line = new GuiLine(sections, Bus3.JFC());
		gui.addLine(line);

		// iz RDFa u I kolo
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(426, 179));
		points.add(new Point(435, 179));
		sections.add(points);
		line = new GuiLine(sections, Bus2.RDF());
		gui.addLine(line);

		// MDRin
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(466, 188));
		points.add(new Point(466, 161));
		points.add(new Point(472, 161));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(463, 174));
		points.add(new Point(464, 174));
		sections.add(points);
		line = new GuiLine(sections, Bus1.MDRin());
		gui.addLine(line);

		// Izlaz ILI kola
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(493, 158));
		points.add(new Point(498, 158));
		sections.add(points);
		line = new GuiLine(sections, Bus1.OR1.getOut(0));
		gui.addLine(line);

		// ldMDR
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(458, 150));
		points.add(new Point(464, 150));
		points.add(new Point(464, 154));
		points.add(new Point(472, 154));
		sections.add(points);
		line = new GuiLine(sections, Oper1.ldMDR());
		gui.addLine(line);

		// Ulaz u trostaticki bafer kod MAR-a
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(277, 213));
		points.add(new Point(294, 213));
		sections.add(points);
		line = new GuiLine(sections, Bus2.EA());
		gui.addLine(line);

		// Ulaz u trostaticki bafer kod MDR-a
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(547, 243));
		points.add(new Point(565, 243));
		sections.add(points);
		line = new GuiLine(sections, Bus2.ED());
		gui.addLine(line);

		// Ulaz u trostaticki bafer S2Dout
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(621, 437));
		points.add(new Point(621, 425));
		sections.add(points);
		line = new GuiLine(sections, Oper1.S2Dout());
		gui.addLine(line);

		// Ulaz u trostaticki bafer DS1out
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(217, 493));
		points.add(new Point(217, 488));
		sections.add(points);
		line = new GuiLine(sections, Oper1.DS1out());
		gui.addLine(line);

		// Ulaz u trostaticki bafer MDRout
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(701, 204));
		points.add(new Point(701, 215));
		sections.add(points);
		line = new GuiLine(sections, Oper1.MDRout());
		gui.addLine(line);

		//
		// DBUS ispod MDR:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(547, 277));
		points.add(new Point(592, 277));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DBUS());
		gui.addLine(line);

		// LABELE:
		gui.addLabel(new GuiLabel(77, 32, Bus1.S1B()));
		gui.addLabel(new GuiLabel(113, 32, Bus1.S2B()));
		gui.addLabel(new GuiLabel(737, 32, Bus1.DB()));
		gui.addLabel(new GuiLabel(278, 51, S2Blow.getOut(0)));
		gui.addLabel(new GuiLabel(278, 35, S2Bhigh.getOut(0)));
		gui.addLabel(new GuiLabel(499, 99, Bus1.DBUS()));
		gui.addLabel(new GuiLabel(552, 138, MX1.getOut(0)));
		gui.addLabel(new GuiLabel(552, 190, MDR.getOut(0)));
		gui.addLabel(new GuiLabel(590, 414, Bus1.S2B()));
		gui.addLabel(new GuiLabel(248, 478, Bus1.DB()));
		gui.addLabel(new GuiLabel(677, 187, MDRlow.getOut(0)));
		gui.addLabel(new GuiLabel(312, 130, Bus1.S1B()));
		gui.addLabel(new GuiLabel(312, 190, MAR.getOut(0)));
		gui.addLabel(new GuiLabel(592, 274, Bus1.DBUS()));
		gui.addLabel(new GuiLabel(321, 244, Bus1.ABUS()));
	}

	private Bus1() {

	}

	public static void init() {

		MAR = new REG(1, "MAR");
		MAR.getOut(0).setIsInt();
		MAR.getOut(0).setNumOfLines(16);

		MDR = new REG(1, "MDR");
		MDR.getOut(0).setIsInt();
		MDR.getOut(0).setNumOfLines(8);

		MX1 = new MP(4);
		MX1.getOut(0).setIsInt();
		MX1.getOut(0).setNumOfLines(8);

		OR1 = new OR();
		AND1 = new AND();

		S2Dout = new TSB();
		S2Dout.getOut(0).setNumOfLines(16);

		DS1out = new TSB();
		DS1out.getOut(0).setNumOfLines(16);

		MARABUSOut = new TSB();
		MARABUSOut.getOut(0).setNumOfLines(16);

		MDRDBUSOut = new TSB();
		MDRDBUSOut.getOut(0).setNumOfLines(8);

		MDRout = new TSB();
		MDRout.getOut(0).setNumOfLines(16);

		// ne znam koliko je njih nakaceno na magistralu, neka bude 16
		S1B = new BUS(16, 1, "S1B");
		S1B.getOut(0).setNumOfLines(16);
		S2B = new BUS(16, 1, "S2B");
		S2B.getOut(0).setNumOfLines(16);
		DB = new BUS(16, 1, "DB");
		DB.getOut(0).setNumOfLines(16);

		ABUS = new BUS(16, 1, "ABUS");
		ABUS.getOut(0).setNumOfLines(16);

		DBUS = new BUS(16, 1, "DBUS");
		DBUS.getOut(0).setNumOfLines(8);

		S2Bhigh = new IntToInt(16, 8, true, false);
		S2Blow = new IntToInt(16, 8, false, false);
		// DBlow =new IntToInt(16,8,false,false);
		MDRlow = new IntToInt(8, 16, false, false);
	}

	public static void connect() {

		S2Bhigh.setInputPin(0, S2B.getOut(0));// pisalo je S1B.getOut
		S2Blow.setInputPin(0, S2B.getOut(0));
		// DBlow.setInputPin(0, DBUS.getOut(0));
		MDRlow.setInputPin(0, MDR.getOut(0));

		AND1.setInputPin(0, Bus3.JFC());
		AND1.setInputPin(1, Bus2.RDF());

		OR1.setInputPin(0, AND1.getOut(0));
		OR1.setInputPin(1, Oper1.ldMDR());

		MX1.setInputPin(0, DBUS.getOut(0));
		MX1.setInputPin(1, S2Blow.getOut(0));
		MX1.setInputPin(2, S2Bhigh.getOut(0));
		MX1.setInputPin(3, new Pin(0, 8));
		MX1.setCtrl(0, Oper1.mxMDR0());
		MX1.setCtrl(1, Oper1.mxMDR1());

		MAR.setInputPin(0, S1B.getOut(0));
		MAR.setPinLd(Oper1.ldMAR());
		MAR.setPinInc(Oper1.incMAR());

		MDR.setInputPin(0, MX1.getOut(0));
		MDR.setPinLd(OR1.getOut(0));

		MARABUSOut.setInputPin(0, MAR.getOut(0));
		MARABUSOut.setCtrl(Bus2.EA());
		Bus1.addOnABUS(MARABUSOut.getOut(0));

		MDRDBUSOut.setInputPin(0, MDR.getOut(0));
		MDRDBUSOut.setCtrl(Bus2.ED());
		Bus1.addOnDBUS(MDRDBUSOut.getOut(0));

		MDRout.setInputPin(0, MDRlow.getOut(0));
		MDRout.setCtrl(Oper1.MDRout());
		Bus1.addOnDB(MDRout.getOut(0));

		S2Dout.setInputPin(0, S2B.getOut(0));
		S2Dout.setCtrl(Oper1.S2Dout());
		Bus1.addOnDB(S2Dout.getOut(0));

		DS1out.setInputPin(0, DB.getOut(0));
		DS1out.setCtrl(Oper1.DS1out());
		Bus1.addOnS1B(DS1out.getOut(0)); // /

	}

	public static void addOnS1B(Pin pin) {
		S1B.setInputPin(s1bi++, pin);
	}

	public static void addOnS2B(Pin pin) {
		S2B.setInputPin(s2bi++, pin);
	}

	public static void addOnDB(Pin pin) {
		DB.setInputPin(dbi++, pin);
	}

	public static void addOnDBUS(Pin pin) {
		DBUS.setInputPin(dbusi++, pin);
	}

	public static void addOnABUS(Pin pin) {
		ABUS.setInputPin(abusi++, pin);
	}

	public static Pin S1B() {
		return S1B.getOut(0);
	}

	public static Pin S2B() {
		return S2B.getOut(0);
	}

	public static Pin DB() {
		return DB.getOut(0);
	}

	public static Pin ABUS() {
		return ABUS.getOut(0);
	}

	public static Pin DBUS() {
		return DBUS.getOut(0);
	}

	public static Pin MDRin() {
		return AND1.getOut(0);
	}

	public static Pin MDR() {

		return MDR.getOut(0);
	}

	public static Pin MAR() {

		return MAR.getOut(0);
	}

	public static Pin MX1() {
		return MX1.getOut(0);

	}

	public static Pin S2Dout() {
		return S2Dout.getOut(0);
	}

	public static Pin DS1out() {
		return DS1out.getOut(0);
	}

	public static Pin MDRoutToDB() {
		return MDRout.getOut(0);
	}

	public static Pin MARout() {
		return MARABUSOut.getOut(0);
	}

	public static Pin MDRRDBUSout() {
		return MDRDBUSOut.getOut(0);
	}

	public static REG RegMAR() {
		return MAR;
	}

	public static REG RegMDR() {
		return MDR;
	}

}
