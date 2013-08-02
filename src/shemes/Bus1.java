package shemes;

import gui.GuiScheme;

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
