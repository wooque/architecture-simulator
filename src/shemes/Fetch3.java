package shemes;

import java.awt.Point;
import java.util.ArrayList;

import gui.*;
import components.*;

public class Fetch3 {
	public static OR ORgropr;
	public static OR ORgradr;
	public static AND ANDgradr;
	public static OR ORI1;
	public static OR ORI2_brnch;
	public static AND ANDI2_arlog;
	public static OR ORI2;
	public static OR ORI3_jump;
	public static OR ORI3_arlog;
	public static AND ANDI3_arlog;
	public static OR ORI3;
	public static AND ANDI4;
	public static OR ORstore;
	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui(){
		gui=new GuiScheme("./src/images/fetch3.png");
		ArrayList<ArrayList<Point>> sections=null;
		ArrayList<Point> points=null;
		GuiLine line=null;
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(133,253));
		points.add(new Point(141,253));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.gropr());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(48,415));
		points.add(new Point(58,415));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.STW());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(48,434));
		points.add(new Point(58,434));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ST());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(87,424));
		points.add(new Point(104,424));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.ORgradr.getOut(0));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(48,450));
		points.add(new Point(95,450));
		points.add(new Point(95,438));
		points.add(new Point(104,438));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.immed());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(134,431));
		points.add(new Point(142,431));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.gradr());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(266,204));
		points.add(new Point(287,204));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G2());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(267,218));
		points.add(new Point(287,218));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.NOT());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(315,211));
		points.add(new Point(323,211));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I1());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(266,277));
		points.add(new Point(287,277));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G0());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(266,291));
		points.add(new Point(287,291));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.INT());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(314,284));
		points.add(new Point(323,284));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I2_brnch());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(276,343));
		points.add(new Point(284,343));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G3());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(276,357));
		points.add(new Point(284,357));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.regdir());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(315,350));
		points.add(new Point(323,350));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I2_arlog());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(278,415));
		points.add(new Point(288,415));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I2_arlog());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(278,429));
		points.add(new Point(288,429));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I2_brnch());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(316,422));
		points.add(new Point(324,422));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I2());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(477,258));
		points.add(new Point(488,258));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.JSR());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(477,272));
		points.add(new Point(488,272));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.JMP());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(515,265));
		points.add(new Point(524,265));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I3_jump());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(488,312));
		points.add(new Point(506,312));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G3());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(450,337));
		points.add(new Point(461,337));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.pcrel());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(450,351));
		points.add(new Point(461,351));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.immed());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(489,344));
		points.add(new Point(497,344));
		points.add(new Point(497,326));
		points.add(new Point(506,326));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.ORI3_arlog.getOut(0));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(536,319));
		points.add(new Point(544,319));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I3_arlog());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(484,398));
		points.add(new Point(495,398));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I3_arlog());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(484,412));
		points.add(new Point(495,412));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I3_jump());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(523,405));
		points.add(new Point(531,405));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I3());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(693,264));
		points.add(new Point(701,264));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G3());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(693,278));
		points.add(new Point(701,278));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.regindpom());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(732,271));
		points.add(new Point(740,271));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I4());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(661,367));
		points.add(new Point(681,367));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.STW());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(661,383));
		points.add(new Point(681,383));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ST());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(709,375));
		points.add(new Point(718,375));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.store());
		gui.addLine(line);

	}

	public static void init() {
		ORgropr = new OR(209);

		ORgradr = new OR();
		ANDgradr = new AND();

		ORI1 = new OR();

		ORI2_brnch = new OR();

		ANDI2_arlog = new AND();

		ORI2 = new OR();

		ORI3_jump = new OR();

		ANDI3_arlog = new AND();
		ORI3_arlog = new OR();

		ORI3 = new OR();

		ANDI4 = new AND();

		ORstore = new OR();

	}

	public static void connect() {

		Pin[] g0 = Fetch2.G0_OP_16_63();
		for (int i = 0; i < 48; i++) {
			ORgropr.setInputPin(i, g0[i]);
		}
		Pin[] g1 = Fetch2.G1_OP_3_63();
		for (int i = 0; i < 61; i++) {
			ORgropr.setInputPin(48 + i, g1[i]);
		}
		Pin[] g2 = Fetch2.G2_OP_18_63();
		for (int i = 0; i < 46; i++) {
			ORgropr.setInputPin(109 + i, g2[i]);
		}
		Pin[] g3 = Fetch2.G3_OP_10_63();
		for (int i = 0; i < 54; i++) {
			ORgropr.setInputPin(155 + i, g3[i]);
		}

		ORgradr.setInputPin(0, Fetch2.ST());
		ORgradr.setInputPin(1, Fetch2.STW());
		ANDgradr.setInputPin(0, ORgradr.getOut(0));
		ANDgradr.setInputPin(1, Fetch2.immed());

		ORI1.setInputPin(0, Fetch2.G2());
		ORI1.setInputPin(1, Fetch2.NOT());

		ORI2_brnch.setInputPin(0, Fetch2.G0());
		ORI2_brnch.setInputPin(1, Fetch2.INT());

		ANDI2_arlog.setInputPin(0, Fetch2.G3());
		ANDI2_arlog.setInputPin(1, Fetch2.regdir());

		ORI2.setInputPin(0, ANDI2_arlog.getOut(0));
		ORI2.setInputPin(1, ORI2_brnch.getOut(0));

		ORI3_jump.setInputPin(0, Fetch2.JSR());
		ORI3_jump.setInputPin(1, Fetch2.JMP());

		ORI3_arlog.setInputPin(0, Fetch2.pcrel());
		ORI3_arlog.setInputPin(1, Fetch2.immed());
		ANDI3_arlog.setInputPin(0, Fetch2.G3());
		ANDI3_arlog.setInputPin(1, ORI3_arlog.getOut(0));

		ORI3.setInputPin(0, ANDI3_arlog.getOut(0));
		ORI3.setInputPin(1, ORI3_jump.getOut(0));

		ANDI4.setInputPin(0, Fetch2.G3());
		ANDI4.setInputPin(1, Fetch2.regindpom());

		ORstore.setInputPin(0, Fetch2.STW());
		ORstore.setInputPin(1, Fetch2.ST());

	}

	public static Pin gropr() {
		return ORgropr.getOut(0);
	}

	public static Pin gradr() {
		return ANDgradr.getOut(0);
	}

	public static Pin I1() {
		return ORI1.getOut(0);
	}

	public static Pin I2_brnch() {
		return ORI2_brnch.getOut(0);
	}

	public static Pin I2_arlog() {
		return ANDI2_arlog.getOut(0);
	}

	public static Pin I2() {
		return ORI2.getOut(0);
	}

	public static Pin I3_jump() {
		return ORI3_jump.getOut(0);
	}

	public static Pin I3_arlog() {
		return ANDI3_arlog.getOut(0);
	}

	public static Pin I3() {
		return ORI3.getOut(0);
	}

	public static Pin I4() {
		return ANDI4.getOut(0);
	}

	public static Pin store() {
		return ORstore.getOut(0);
	}

}
