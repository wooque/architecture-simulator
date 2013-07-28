package shemes;

import java.awt.Point;
import java.util.ArrayList;
import gui.*;
import components.*;

public class Adr {
	public static IntToInt DBToGPRAR;
	public static REG GPRAR;
	public static GPR GPRegs; // Izmenjeno
	public static TSB TSBGPRDout;
	public static TSB TSBGPRS1out;
	public static REG SP;
	public static TSB TSBSP1out;
	public static ADD ADDadr;
	public static REG PR;
	public static TSB TSBPRout;

	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui() {

		GuiLine line; // Pomocna promenljiva
		gui = new GuiScheme("./src/images/adr1.png");

		ArrayList<ArrayList<Point>> sections;
		ArrayList<Point> points;

		// Magistrala S1B
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(50, 26));
		points.add(new Point(50, 598));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(51, 26));
		points.add(new Point(51, 598));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(49, 26));
		points.add(new Point(49, 598));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);

		// Magistrala S2B
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(79, 24));
		points.add(new Point(79, 598));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(78, 24));
		points.add(new Point(78, 598));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(80, 24));
		points.add(new Point(80, 598));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);

		// Magistrala DB
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(754, 28));
		points.add(new Point(754, 599));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(755, 28));
		points.add(new Point(755, 599));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(753, 28));
		points.add(new Point(753, 599));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// Iz magistrale S1B u GPR
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(52, 66));
		points.add(new Point(329, 66));
		points.add(new Point(329, 133));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);

		// Iz GPRAR u GPR
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(566, 144));
		points.add(new Point(566, 172));
		points.add(new Point(408, 172));
		sections.add(points);
		line = new GuiLine(sections, Adr.GPRAR());
		gui.addLine(line);

		// Iz GPR u trostaticke bafere
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(330, 212));
		points.add(new Point(330, 251));
		points.add(new Point(214, 251));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(331, 251));
		points.add(new Point(619, 251));
		sections.add(points);
		line = new GuiLine(sections, Adr.GPR().getOut(0));
		gui.addLine(line);

		// Iz GPRS1 trostatickog na magistralu
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(190, 251));
		points.add(new Point(52, 251));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);

		// Iz GPRD trostatickog na magistralu
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(643, 251));
		points.add(new Point(752, 251));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// Sa DB magistrale u SP
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(752, 301));
		points.add(new Point(528, 301));
		points.add(new Point(528, 320));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// Iz SP u trostaticki bafer
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(528, 360));
		points.add(new Point(528, 379));
		points.add(new Point(216, 379));
		sections.add(points);
		line = new GuiLine(sections, Adr.SP());
		gui.addLine(line);

		// Iz SP1 na magistralu S1B
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(191, 379));
		points.add(new Point(52, 379));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);

		// Iz ADD u PR
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(272, 462));
		points.add(new Point(272, 426));
		points.add(new Point(517, 426));
		points.add(new Point(517, 462));
		sections.add(points);
		line = new GuiLine(sections, Adr.ADDadr.getOut(0));
		gui.addLine(line);

		// Sa magistrale S1B na prvi ulaz sabiraca
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(52, 521));
		points.add(new Point(234, 521));
		points.add(new Point(234, 503));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);

		// Sa magistrale S2B na drugi ulaz sabiraca
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(81, 541));
		points.add(new Point(311, 541));
		points.add(new Point(311, 503));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);

		// Sa izlaza PR na trostaticki bafer
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(517, 503));
		points.add(new Point(517, 542));
		points.add(new Point(617, 542));
		sections.add(points);
		line = new GuiLine(sections, Adr.PR());
		gui.addLine(line);

		// Sa izlaza trostatickog bafera PRout na magistralu DB
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(642, 542));
		points.add(new Point(752, 542));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// Iz upravljacke jedinice u WR GPR-a
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(239, 155));
		points.add(new Point(252, 155));
		sections.add(points);
		line = new GuiLine(sections, Oper1.wrGPR());
		gui.addLine(line);

		// Iz upravljacke jedinice u RD GPR-a
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(239, 182));
		points.add(new Point(252, 182));
		sections.add(points);
		line = new GuiLine(sections, Oper1.rdGPR());
		gui.addLine(line);

		// Iz upravljacke jedinice u LD GPRAR-a
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(481, 134));
		points.add(new Point(487, 134));
		sections.add(points);
		line = new GuiLine(sections, Oper1.ldGPRAR());
		gui.addLine(line);

		// Iz upravljacke jedinice u incSP
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(443, 330));
		points.add(new Point(450, 330));
		sections.add(points);
		line = new GuiLine(sections, Oper1.incSP());
		gui.addLine(line);

		// Iz upravljacke jedinice u decSP
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(443, 350));
		points.add(new Point(450, 350));
		sections.add(points);
		line = new GuiLine(sections, Oper1.decSP());
		gui.addLine(line);

		// Iz upravljacke jedinice u ldSP
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(606, 330));
		points.add(new Point(612, 330));
		sections.add(points);
		line = new GuiLine(sections, Oper1.ldSP());
		gui.addLine(line);

		// Iz upravljacke jedinice u ldPR
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(602, 473));
		points.add(new Point(595, 473));
		sections.add(points);
		line = new GuiLine(sections, Oper1.ldPR());
		gui.addLine(line);

		// Iz upravljacke jedinice u GPRS1out
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(202, 264));
		points.add(new Point(202, 257));
		sections.add(points);
		line = new GuiLine(sections, Oper1.GPR1out());
		gui.addLine(line);

		// Iz upravljacke jedinice u GPRDBout
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(631, 236));
		points.add(new Point(631, 246));
		sections.add(points);
		line = new GuiLine(sections, Oper1.GPRDout());
		gui.addLine(line);

		// Iz upravljacke jedinice u SP1out
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(203, 392));
		points.add(new Point(203, 385));
		sections.add(points);
		line = new GuiLine(sections, Oper1.SP1out());
		gui.addLine(line);

		// Iz upravljacke jedinice u PRout
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(630, 548));
		points.add(new Point(630, 560));
		sections.add(points);
		line = new GuiLine(sections, Oper1.PRout());
		gui.addLine(line);

		//
		// Int to GPRAR:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(751, 43));
		points.add(new Point(667, 43));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		//
		// Int to GPRAR:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(616, 47));
		points.add(new Point(566, 47));
		points.add(new Point(566, 103));
		sections.add(points);
		line = new GuiLine(sections, DBToGPRAR.getOut(0));
		gui.addLine(line);

		//
		// Labele:

		gui.addLabel(new GuiLabel(57, 40, Bus1.S1B()));
		gui.addLabel(new GuiLabel(86, 40, Bus1.S2B()));
		gui.addLabel(new GuiLabel(761, 40, Bus1.DB()));
		gui.addLabel(new GuiLabel(339, 120, Bus1.S1B()));
		gui.addLabel(new GuiLabel(339, 229, GPRegs.getOut(0)));
		gui.addLabel(new GuiLabel(578, 157, GPRAR.getOut(0)));
		gui.addLabel(new GuiLabel(677, 38, Bus1.DB()));
		gui.addLabel(new GuiLabel(578, 90, DBToGPRAR.getOut(0)));
		gui.addLabel(new GuiLabel(536, 298, Bus1.DB()));
		gui.addLabel(new GuiLabel(536, 374, SP.getOut(0)));
		gui.addLabel(new GuiLabel(242, 521, Bus1.S1B()));
		gui.addLabel(new GuiLabel(322, 521, Bus1.S2B()));
		gui.addLabel(new GuiLabel(528, 448, ADDadr.getOut(0)));
		gui.addLabel(new GuiLabel(528, 521, PR.getOut(0)));

	}

	public static void init() {
		DBToGPRAR = new IntToInt(16, 6);

		GPRAR = new REG(1, "GPRAR");
		GPRAR.getOut(0).setIsInt();
		GPRAR.getOut(0).setNumOfLines(6);

		GPRegs = new GPR(64);
		GPRegs.getOut(0).setNumOfLines(16);

		TSBGPRDout = new TSB();
		TSBGPRDout.getOut(0).setNumOfLines(16);

		TSBGPRS1out = new TSB();
		TSBGPRS1out.getOut(0).setNumOfLines(16);

		SP = new REG(1, "SP");
		SP.getOut(0).setIsInt();
		SP.getOut(0).setNumOfLines(16);
		SP.initVal(4096);//1000h

		TSBSP1out = new TSB();
		TSBSP1out.getOut(0).setNumOfLines(16);

		ADDadr = new ADD();
		ADDadr.getOut(0).setIsInt();
		ADDadr.getOut(0).setNumOfLines(16);

		PR = new REG(1, "PR");
		PR.getOut(0).setIsInt();
		PR.getOut(0).setNumOfLines(16);

		TSBPRout = new TSB();
		TSBPRout.getOut(0).setNumOfLines(16);

	}

	public static void connect() {
		DBToGPRAR.setInputPin(0, Bus1.DB());

		GPRAR.setInputPin(0, DBToGPRAR.getOut(0));
		GPRAR.setPinLd(Oper1.ldGPRAR());

		GPRegs.setAdressPin(GPRAR.getOut(0));
		GPRegs.setInputDataPin(Bus1.S1B());
		GPRegs.setWrite(Oper1.wrGPR());
		GPRegs.setRead(Oper1.rdGPR());

		TSBGPRDout.setInputPin(0, GPRegs.getOut(0));
		TSBGPRDout.setCtrl(Oper1.GPRDout());
		Bus1.addOnDB(TSBGPRDout.getOut(0));

		TSBGPRS1out.setInputPin(0, GPRegs.getOut(0));
		TSBGPRS1out.setCtrl(Oper1.GPR1out());
		Bus1.addOnS1B(TSBGPRS1out.getOut(0));

		SP.setInputPin(0, Bus1.DB());
		SP.setPinInc(Oper1.incSP());
		SP.setPinDec(Oper1.decSP());
		SP.setPinLd(Oper1.ldSP());

		TSBSP1out.setInputPin(0, SP.getOut(0));
		TSBSP1out.setCtrl(Oper1.SP1out());
		Bus1.addOnS1B(TSBSP1out.getOut(0));

		ADDadr.setPinA(Bus1.S1B());
		ADDadr.setPinB(Bus1.S2B());

		PR.setInputPin(0, ADDadr.getOut(0));
		PR.setPinLd(Oper1.ldPR());

		TSBPRout.setInputPin(0, PR.getOut(0));
		TSBPRout.setCtrl(Oper1.PRout());
		Bus1.addOnDB(TSBPRout.getOut(0));

	}

	public static Pin SP() {
		return SP.getOut(0);
	}

	public static Pin PR() {
		return PR.getOut(0);
	}

	public static Pin GPRAR() {
		return GPRAR.getOut(0);
	}

	public static int readGPR(int adress) {
		return GPRegs.read(adress);
	}

	public static Pin GPRDout() {
		return TSBGPRDout.getOut(0);
	}

	public static Pin GPRS1out() {
		return TSBGPRS1out.getOut(0);
	}

	public static Pin SP1out() {
		return TSBSP1out.getOut(0);
	}

	public static Pin PRout() {
		return TSBPRout.getOut(0);
	}

	public static GPR GPR() {
		return GPRegs;
	}

	public static REG RegGPRAR() {
		return GPRAR;
	}

	public static REG RegSP() {
		return SP;
	}

}
