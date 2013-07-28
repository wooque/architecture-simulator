  package shemes;

import java.awt.Point;
import java.util.ArrayList;

import gui.*;
import components.*;

public class Oper2 {
	public static OR ldAB, ldBB, AW2out, ldBWH, ldBWL, BWout, clPSWI, clPSWT;
	public static OR ldN, ldZ, ldC, ldV, PSWout, ALUout, mxBR1, ldBR;
	public static GuiScheme gui;
	
	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui(){
		gui=new GuiScheme("./src/images/oper-exec i intr.png");
		ArrayList<ArrayList<Point>> sections=null;
		ArrayList<Point> points=null;
		GuiLine line=null;
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(63,39));
		points.add(new Point(80,39));
		sections.add(points);
		line=new GuiLine(sections,Counter.T34());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(63,57));
		points.add(new Point(80,57));
		sections.add(points);
		line=new GuiLine(sections,Counter.T48());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(63,75));
		points.add(new Point(82,75));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4A());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(63,93));
		points.add(new Point(82,93));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4C());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(63,111));
		points.add(new Point(80,111));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4E());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(63,129));
		points.add(new Point(80,129));
		sections.add(points);
		line=new GuiLine(sections,Counter.T50());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(63,147));
		points.add(new Point(80,147));
		sections.add(points);
		line=new GuiLine(sections,Counter.T52());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(109,84));
		points.add(new Point(126,84));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldAB());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(62,165));
		points.add(new Point(120,165));
		sections.add(points);
		line=new GuiLine(sections,Counter.T54());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(63,190));
		points.add(new Point(122,190));
		sections.add(points);
		line=new GuiLine(sections,Counter.T56());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(63,219));
		points.add(new Point(122,219));
		sections.add(points);
		line=new GuiLine(sections,Counter.T3C());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(62,249));
		points.add(new Point(120,249));
		sections.add(points);
		line=new GuiLine(sections,Counter.T38());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(61,272));
		points.add(new Point(69,272));
		sections.add(points);
		line=new GuiLine(sections,Counter.T1D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(61,290));
		points.add(new Point(72,290));
		sections.add(points);
		line=new GuiLine(sections,Counter.T27());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(61,308));
		points.add(new Point(69,308));
		sections.add(points);
		line=new GuiLine(sections,Counter.T2C());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(98,290));
		points.add(new Point(115,290));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldBB());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(65,326));
		points.add(new Point(124,326));
		sections.add(points);
		line=new GuiLine(sections,Counter.T34());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(65,355));
		points.add(new Point(124,355));
		sections.add(points);
		line=new GuiLine(sections,Counter.T36());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(64,384));
		points.add(new Point(123,384));
		sections.add(points);
		line=new GuiLine(sections,Counter.T45());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(235,37));
		points.add(new Point(252,37));
		sections.add(points);
		line=new GuiLine(sections,Counter.T3E());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(235,55));
		points.add(new Point(254,55));
		sections.add(points);
		line=new GuiLine(sections,Counter.T41());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(235,74));
		points.add(new Point(254,74));
		sections.add(points);
		line=new GuiLine(sections,Counter.T46());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(235,92));
		points.add(new Point(252,92));
		sections.add(points);
		line=new GuiLine(sections,Counter.T47());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(281,65));
		points.add(new Point(298,65));
		sections.add(points);
		line=new GuiLine(sections,Oper2.AW2out());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(236,110));
		points.add(new Point(253,110));
		sections.add(points);
		line=new GuiLine(sections,Counter.T1E());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(236,128));
		points.add(new Point(255,128));
		sections.add(points);
		line=new GuiLine(sections,Counter.T2B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(236,146));
		points.add(new Point(255,146));
		sections.add(points);
		line=new GuiLine(sections,Counter.T70());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(236,164));
		points.add(new Point(253,164));
		sections.add(points);
		line=new GuiLine(sections,Counter.T91());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(282,137));
		points.add(new Point(299,137));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldBWH());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(236,182));
		points.add(new Point(253,182));
		sections.add(points);
		line=new GuiLine(sections,Counter.T1E());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(236,200));
		points.add(new Point(255,200));
		sections.add(points);
		line=new GuiLine(sections,Counter.T28());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(236,218));
		points.add(new Point(255,218));
		sections.add(points);
		line=new GuiLine(sections,Counter.T73());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(236,236));
		points.add(new Point(253,236));
		sections.add(points);
		line=new GuiLine(sections,Counter.T94());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(282,209));
		points.add(new Point(299,209));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldBWL());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(236,254));
		points.add(new Point(294,254));
		sections.add(points);
		line=new GuiLine(sections,Counter.T1E());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(237,267));
		points.add(new Point(245,267));
		sections.add(points);
		line=new GuiLine(sections,Counter.T36());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(236,285));
		points.add(new Point(248,285));
		sections.add(points);
		line=new GuiLine(sections,Counter.T74());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(237,303));
		points.add(new Point(245,303));
		sections.add(points);
		line=new GuiLine(sections,Counter.T95());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(274,285));
		points.add(new Point(291,285));
		sections.add(points);
		line=new GuiLine(sections,Oper2.BWout());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(235,327));
		points.add(new Point(294,327));
		sections.add(points);
		line=new GuiLine(sections,Counter.T31());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(233,343));
		points.add(new Point(244,343));
		sections.add(points);
		line=new GuiLine(sections,Counter.T30());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(233,356));
		points.add(new Point(244,356));
		sections.add(points);
		line=new GuiLine(sections,Counter.T95());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(270,350));
		points.add(new Point(294,350));
		sections.add(points);
		line=new GuiLine(sections,Oper2.clPSWI());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(233,376));
		points.add(new Point(292,376));
		sections.add(points);
		line=new GuiLine(sections,Counter.T33());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(399,35));
		points.add(new Point(409,35));
		sections.add(points);
		line=new GuiLine(sections,Counter.T32());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(399,48));
		points.add(new Point(410,48));
		sections.add(points);
		line=new GuiLine(sections,Counter.T95());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(436,41));
		points.add(new Point(446,41));
		sections.add(points);
		line=new GuiLine(sections,Oper2.clPSWT());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,76));
		points.add(new Point(420,76));
		sections.add(points);
		line=new GuiLine(sections,Counter.T35());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,94));
		points.add(new Point(420,94));
		sections.add(points);
		line=new GuiLine(sections,Counter.T49());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,112));
		points.add(new Point(420,112));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,130));
		points.add(new Point(420,130));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,148));
		points.add(new Point(421,148));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4F());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,166));
		points.add(new Point(421,166));
		sections.add(points);
		line=new GuiLine(sections,Counter.T51());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,184));
		points.add(new Point(420,184));
		sections.add(points);
		line=new GuiLine(sections,Counter.T53());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,202));
		points.add(new Point(420,202));
		sections.add(points);
		line=new GuiLine(sections,Counter.T55());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,220));
		points.add(new Point(420,220));
		sections.add(points);
		line=new GuiLine(sections,Counter.T57());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(449,157));
		points.add(new Point(466,157));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldN());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,245));
		points.add(new Point(420,245));
		sections.add(points);
		line=new GuiLine(sections,Counter.T35());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,263));
		points.add(new Point(420,263));
		sections.add(points);
		line=new GuiLine(sections,Counter.T49());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,281));
		points.add(new Point(420,281));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,299));
		points.add(new Point(420,299));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,317));
		points.add(new Point(421,317));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4F());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,335));
		points.add(new Point(421,335));
		sections.add(points);
		line=new GuiLine(sections,Counter.T51());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,353));
		points.add(new Point(420,353));
		sections.add(points);
		line=new GuiLine(sections,Counter.T51());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,353));
		points.add(new Point(420,353));
		sections.add(points);
		line=new GuiLine(sections,Counter.T53());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,371));
		points.add(new Point(420,371));
		sections.add(points);
		line=new GuiLine(sections,Counter.T55());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,389));
		points.add(new Point(420,389));
		sections.add(points);
		line=new GuiLine(sections,Counter.T57());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(449,326));
		points.add(new Point(466,326));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldZ());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(530,54));
		points.add(new Point(589,54));
		sections.add(points);
		line=new GuiLine(sections,Counter.T8B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,76));
		points.add(new Point(552,76));
		sections.add(points);
		line=new GuiLine(sections,Counter.T35());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,94));
		points.add(new Point(552,94));
		sections.add(points);
		line=new GuiLine(sections,Counter.T48());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,112));
		points.add(new Point(552,112));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4A());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,130));
		points.add(new Point(552,130));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,148));
		points.add(new Point(554,148));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4F());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,166));
		points.add(new Point(554,166));
		sections.add(points);
		line=new GuiLine(sections,Counter.T51());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,184));
		points.add(new Point(552,184));
		sections.add(points);
		line=new GuiLine(sections,Counter.T53());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,202));
		points.add(new Point(552,202));
		sections.add(points);
		line=new GuiLine(sections,Counter.T54());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,220));
		points.add(new Point(552,220));
		sections.add(points);
		line=new GuiLine(sections,Counter.T56());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(581,157));
		points.add(new Point(598,157));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldC());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,247));
		points.add(new Point(552,247));
		sections.add(points);
		line=new GuiLine(sections,Counter.T35());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,265));
		points.add(new Point(552,265));
		sections.add(points);
		line=new GuiLine(sections,Counter.T48());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,283));
		points.add(new Point(552,283));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4A());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,301));
		points.add(new Point(552,301));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,319));
		points.add(new Point(553,319));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4F());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,337));
		points.add(new Point(554,337));
		sections.add(points);
		line=new GuiLine(sections,Counter.T51());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,355));
		points.add(new Point(552,355));
		sections.add(points);
		line=new GuiLine(sections,Counter.T53());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,373));
		points.add(new Point(552,373));
		sections.add(points);
		line=new GuiLine(sections,Counter.T55());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(535,391));
		points.add(new Point(552,391));
		sections.add(points);
		line=new GuiLine(sections,Counter.T57());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(581,328));
		points.add(new Point(598,328));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldV());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(677,49));
		points.add(new Point(687,49));
		sections.add(points);
		line=new GuiLine(sections,Counter.T7C());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(677,63));
		points.add(new Point(687,63));
		sections.add(points);
		line=new GuiLine(sections,Counter.T7F());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(714,56));
		points.add(new Point(738,56));
		sections.add(points);
		line=new GuiLine(sections,Oper2.PSWout());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(680,81));
		points.add(new Point(739,81));
		sections.add(points);
		line=new GuiLine(sections,Counter.T6B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(680,108));
		points.add(new Point(739,108));
		sections.add(points);
		line=new GuiLine(sections,Counter.T68());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(680,137));
		points.add(new Point(739,137));
		sections.add(points);
		line=new GuiLine(sections,Counter.T2F());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(680,162));
		points.add(new Point(739,162));
		sections.add(points);
		line=new GuiLine(sections,Counter.T48());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(680,185));
		points.add(new Point(739,185));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4A());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(680,203));
		points.add(new Point(739,203));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4C());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(678,221));
		points.add(new Point(737,221));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4E());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(677,243));
		points.add(new Point(736,243));
		sections.add(points);
		line=new GuiLine(sections,Counter.T50());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(677,270));
		points.add(new Point(736,270));
		sections.add(points);
		line=new GuiLine(sections,Counter.T52());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(675,294));
		points.add(new Point(692,294));
		sections.add(points);
		line=new GuiLine(sections,Counter.T48());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(675,312));
		points.add(new Point(692,312));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4A());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(674,330));
		points.add(new Point(693,330));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4C());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(675,348));
		points.add(new Point(693,348));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4E());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(675,366));
		points.add(new Point(692,366));
		sections.add(points);
		line=new GuiLine(sections,Counter.T50());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(675,384));
		points.add(new Point(692,384));
		sections.add(points);
		line=new GuiLine(sections,Counter.T52());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(720,339));
		points.add(new Point(738,339));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ALUout());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(67,430));
		points.add(new Point(126,430));
		sections.add(points);
		line=new GuiLine(sections,Counter.T5C());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(67,460));
		points.add(new Point(126,460));
		sections.add(points);
		line=new GuiLine(sections,Counter.T83());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(67,487));
		points.add(new Point(126,487));
		sections.add(points);
		line=new GuiLine(sections,Counter.T07());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(67,516));
		points.add(new Point(126,516));
		sections.add(points);
		line=new GuiLine(sections,Counter.T85());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(67,548));
		points.add(new Point(126,548));
		sections.add(points);
		line=new GuiLine(sections,Counter.T0E());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(243,430));
		points.add(new Point(302,430));
		sections.add(points);
		line=new GuiLine(sections,Counter.T87());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(243,457));
		points.add(new Point(302,457));
		sections.add(points);
		line=new GuiLine(sections,Counter.T89());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(243,481));
		points.add(new Point(302,481));
		sections.add(points);
		line=new GuiLine(sections,Counter.T8B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(243,513));
		points.add(new Point(302,513));
		sections.add(points);
		line=new GuiLine(sections,Counter.T46());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(243,542));
		points.add(new Point(302,542));
		sections.add(points);
		line=new GuiLine(sections,Counter.T8D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(426,429));
		points.add(new Point(485,429));
		sections.add(points);
		line=new GuiLine(sections,Counter.T8D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(420,454));
		points.add(new Point(437,454));
		sections.add(points);
		line=new GuiLine(sections,Counter.T85());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(420,472));
		points.add(new Point(438,472));
		sections.add(points);
		line=new GuiLine(sections,Counter.T87());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(420,490));
		points.add(new Point(438,490));
		sections.add(points);
		line=new GuiLine(sections,Counter.T89());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(420,508));
		points.add(new Point(437,508));
		sections.add(points);
		line=new GuiLine(sections,Counter.T8C());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(466,481));
		points.add(new Point(483,481));
		sections.add(points);
		line=new GuiLine(sections,Oper2.mxBR1());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(425,527));
		points.add(new Point(484,527));
		sections.add(points);
		line=new GuiLine(sections,Counter.T8B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(626,432));
		points.add(new Point(643,432));
		sections.add(points);
		line=new GuiLine(sections,Counter.T83());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(626,450));
		points.add(new Point(643,450));
		sections.add(points);
		line=new GuiLine(sections,Counter.T85());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(626,468));
		points.add(new Point(645,468));
		sections.add(points);
		line=new GuiLine(sections,Counter.T87());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(626,486));
		points.add(new Point(645,486));
		sections.add(points);
		line=new GuiLine(sections,Counter.T89());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(626,504));
		points.add(new Point(643,504));
		sections.add(points);
		line=new GuiLine(sections,Counter.T8B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(626,522));
		points.add(new Point(643,522));
		sections.add(points);
		line=new GuiLine(sections,Counter.T8C());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(672,477));
		points.add(new Point(689,477));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldBR());
		gui.addLine(line);

	}

	public static void init() {
		ldAB = new OR(7);
		ldBB = new OR(3);
		AW2out = new OR(4);
		ldBWH = new OR(4);
		ldBWL = new OR(4);
		BWout = new OR(3);
		clPSWI = new OR();
		clPSWT = new OR();
		ldN = new OR(9);
		ldZ = new OR(9);
		ldC = new OR(9);
		ldV = new OR(9);
		PSWout = new OR();
		ALUout = new OR(6);
		mxBR1 = new OR(4);
		ldBR = new OR(6);
		

	}

	public static void connect() {
		ldAB.setInputPin(0, Counter.T34());
		ldAB.setInputPin(1, Counter.T48());
		ldAB.setInputPin(2, Counter.T4A());
		ldAB.setInputPin(3, Counter.T4C());
		ldAB.setInputPin(4, Counter.T4E());
		ldAB.setInputPin(5, Counter.T50());
		ldAB.setInputPin(6, Counter.T52());

		ldBB.setInputPin(0, Counter.T1D());
		ldBB.setInputPin(1, Counter.T27());
		ldBB.setInputPin(2, Counter.T2C());

		AW2out.setInputPin(0, Counter.T3E());
		AW2out.setInputPin(1, Counter.T41());
		AW2out.setInputPin(2, Counter.T46());
		AW2out.setInputPin(3, Counter.T47());

		ldBWH.setInputPin(0, Counter.T1E());
		ldBWH.setInputPin(1, Counter.T2B());
		ldBWH.setInputPin(2, Counter.T70());
		ldBWH.setInputPin(3, Counter.T91());

		ldBWL.setInputPin(0, Counter.T1E());
		ldBWL.setInputPin(1, Counter.T28());
		ldBWL.setInputPin(2, Counter.T73());
		ldBWL.setInputPin(3, Counter.T94());

		BWout.setInputPin(0, Counter.T36());
		BWout.setInputPin(1, Counter.T74());
		BWout.setInputPin(2, Counter.T95());

		clPSWI.setInputPin(0, Counter.T30());
		clPSWI.setInputPin(1, Counter.T95());

		clPSWT.setInputPin(0, Counter.T32());
		clPSWT.setInputPin(1, Counter.T95());

		ldN.setInputPin(0, Counter.T35());
		ldN.setInputPin(1, Counter.T49());
		ldN.setInputPin(2, Counter.T4B());
		ldN.setInputPin(3, Counter.T4D());
		ldN.setInputPin(4, Counter.T4F());
		ldN.setInputPin(5, Counter.T51());
		ldN.setInputPin(6, Counter.T53());
		ldN.setInputPin(7, Counter.T55());
		ldN.setInputPin(8, Counter.T57());

		ldZ.setInputPin(0, Counter.T35());
		ldZ.setInputPin(1, Counter.T49());
		ldZ.setInputPin(2, Counter.T4B());
		ldZ.setInputPin(3, Counter.T4D());
		ldZ.setInputPin(4, Counter.T4F());
		ldZ.setInputPin(5, Counter.T51());
		ldZ.setInputPin(6, Counter.T53());
		ldZ.setInputPin(7, Counter.T55());
		ldZ.setInputPin(8, Counter.T57());

		ldC.setInputPin(0, Counter.T35());
		ldC.setInputPin(1, Counter.T48());
		ldC.setInputPin(2, Counter.T4A());
		ldC.setInputPin(3, Counter.T4D());
		ldC.setInputPin(4, Counter.T4F());
		ldC.setInputPin(5, Counter.T51());
		ldC.setInputPin(6, Counter.T53());
		ldC.setInputPin(7, Counter.T54());
		ldC.setInputPin(8, Counter.T56());

		ldV.setInputPin(0, Counter.T35());
		ldV.setInputPin(1, Counter.T48());
		ldV.setInputPin(2, Counter.T4A());
		ldV.setInputPin(3, Counter.T4D());
		ldV.setInputPin(4, Counter.T4F());
		ldV.setInputPin(5, Counter.T51());
		ldV.setInputPin(6, Counter.T53());
		ldV.setInputPin(7, Counter.T55());
		ldV.setInputPin(8, Counter.T57());

		PSWout.setInputPin(0, Counter.T7C());
		PSWout.setInputPin(1, Counter.T7F());

		ALUout.setInputPin(0, Counter.T48());
		ALUout.setInputPin(1, Counter.T4A());
		ALUout.setInputPin(2, Counter.T4C());
		ALUout.setInputPin(3, Counter.T4E());
		ALUout.setInputPin(4, Counter.T50());
		ALUout.setInputPin(5, Counter.T52());

		mxBR1.setInputPin(0, Counter.T85());
		mxBR1.setInputPin(1, Counter.T87());
		mxBR1.setInputPin(2, Counter.T89());
		mxBR1.setInputPin(3, Counter.T8C());

		ldBR.setInputPin(0, Counter.T83());
		ldBR.setInputPin(1, Counter.T85());
		ldBR.setInputPin(2, Counter.T87());
		ldBR.setInputPin(3, Counter.T89());
		ldBR.setInputPin(4, Counter.T8B());
		ldBR.setInputPin(5, Counter.T8C());

	}
	public static Pin ldAB() {
		return ldAB.getOut(0);
	}
	public static Pin shr() {
		return Counter.T54();
	}
	public static Pin shl() {
		return Counter.T56();
	}
	public static Pin AB1out() {
		return Counter.T3C();
	}
	public static Pin AB2out() {
		return Counter.T38();
	}
	public static Pin ldBB() {
		return ldBB.getOut(0);
	}
	public static Pin BBout() {
		return Counter.T34();
	}
	public static Pin ldAW() {
		return Counter.T36();
	}
	public static Pin AW1out() {
		return Counter.T45();
	}
	public static Pin AW2out() {
		return AW2out.getOut(0);
	}
	public static Pin mxBWH() {
		return Counter.T1E();
	}
		public static Pin ldBWH() {
		return ldBWH.getOut(0);
	}
	public static Pin ldBWL() {
		return ldBWL.getOut(0);
	}
	public static Pin BWout() {
		return BWout.getOut(0);
	}
	public static Pin clPSWI() {
		return clPSWI.getOut(0);
	}
	public static Pin clPSWT() {
		return clPSWT.getOut(0);
	}
	public static Pin stPSWI() {
		return Counter.T31();
	}
	public static Pin stPSWT() {
		return Counter.T33();
	}
	public static Pin ldL() {
		return Counter.T8B();
	}
	public static Pin ldN() {
		return ldN.getOut(0);
	}
	public static Pin ldZ() {
		return ldZ.getOut(0);
	}
	public static Pin ldC() {
		return ldC.getOut(0);
	}
	public static Pin ldV() {
		return ldV.getOut(0);
	}
	public static Pin PSWout() {
		return PSWout.getOut(0);
	}
	public static Pin ldPSWL() {
		return Counter.T6B();
	}
	public static Pin ldPSWH() {
		return Counter.T68();
	}
	public static Pin clSTART() {
		return Counter.T2F();
	}
	public static Pin add() {
		return Counter.T48();
	}
	public static Pin sub() {
		return Counter.T4A();
	}
	public static Pin and() {
		return Counter.T4C();
	}
	public static Pin or() {
		return Counter.T4E();
	}
	public static Pin xor() {
		return Counter.T50();
	}
	public static Pin not() {
		return Counter.T52();
	}
	public static Pin ALUout() {
		return ALUout.getOut(0);
	}
	public static Pin stPRINS() {
		return Counter.T5C();
	}
	public static Pin clPRINS() {
		return Counter.T83();
	}
	public static Pin stPRCOD() {
		return Counter.T07();
	}
	public static Pin clPRCOD() {
		return Counter.T85();
	}
	public static Pin stPRADR() {
		return Counter.T0E();
	}
	public static Pin clPRADR() {
		return Counter.T87();
	}
	public static Pin clPRINM() {
		return Counter.T89();
	}
	public static Pin clINTR() {
		return Counter.T8B();
	}
	public static Pin ldIVTP() {
		return Counter.T46();
	}
	public static Pin IVTPout() {
		return Counter.T8D();
	}
	public static Pin IVTDSPout() {
		return Counter.T8D();
	}
	public static Pin mxBR0() {
		return Counter.T8B();
	}
	public static Pin mxBR1() {
		return mxBR1.getOut(0);
	}
	public static Pin ldBR() {
		return ldBR.getOut(0);	
	}
}
