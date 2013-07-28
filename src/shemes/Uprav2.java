package shemes;

import java.awt.Point;
import java.util.ArrayList;

import gui.GuiLine;
import gui.GuiScheme;
import components.*;

public class Uprav2 {
	public static OR val00, val1A, val2D, val75, val8D;
	public static GuiScheme gui;
	
	public static GuiScheme getGui() {
		return gui;
	}
	public static void gui(){
		gui=new GuiScheme("./src/images/uprav-val.png");
		ArrayList<ArrayList<Point>> sections=null;
		ArrayList<Point> points=null;
		GuiLine line=null;
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(73,17));
		points.add(new Point(92,17));
		sections.add(points);
		line=new GuiLine(sections,Counter.T00());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(73,36));
		points.add(new Point(92,36));
		sections.add(points);
		line=new GuiLine(sections,Counter.T2F());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(73,56));
		points.add(new Point(93,56));
		sections.add(points);
		line=new GuiLine(sections,Counter.T75());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(73,76));
		points.add(new Point(92,76));
		sections.add(points);
		line=new GuiLine(sections,Counter.T95());
		gui.addLine(line);
		
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(124,46));
		points.add(new Point(142,46));
		sections.add(points);
		line=new GuiLine(sections,Uprav2.val00());
		gui.addLine(line);
		
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(76,100));
		points.add(new Point(143,100));
		sections.add(points);
		line=new GuiLine(sections,Counter.T01());
		gui.addLine(line);
		
		// Promenio Djole iz T06 u T04
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(76,125));
		points.add(new Point(143,125));
		sections.add(points);
		line=new GuiLine(sections,Counter.T04());
		gui.addLine(line);
		
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(76,154));
		points.add(new Point(143,154));
		sections.add(points);
		line=new GuiLine(sections,Counter.T06());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(76,180));
		points.add(new Point(143,180));
		sections.add(points);
		line=new GuiLine(sections,Counter.T0B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(76,204));
		points.add(new Point(143,204));
		sections.add(points);
		line=new GuiLine(sections,Counter.T0D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(76,234));
		points.add(new Point(143,234));
		sections.add(points);
		line=new GuiLine(sections,Counter.T13());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(76,264));
		points.add(new Point(143,264));
		sections.add(points);
		line=new GuiLine(sections,Counter.T18());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(77,293));
		points.add(new Point(87,293));
		sections.add(points);
		line=new GuiLine(sections,Counter.T10());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(77,308));
		points.add(new Point(88,308));
		sections.add(points);
		line=new GuiLine(sections,Counter.T15());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(117,301));
		points.add(new Point(142,301));
		sections.add(points);
		line=new GuiLine(sections,Uprav2.val1A());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(76,346));
		points.add(new Point(143,346));
		sections.add(points);
		line=new GuiLine(sections,Counter.T1C());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(76,370));
		points.add(new Point(143,370));
		sections.add(points);
		line=new GuiLine(sections,Counter.T21());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(76,400));
		points.add(new Point(143,400));
		sections.add(points);
		line=new GuiLine(sections,Counter.T25());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(76,425));
		points.add(new Point(143,425));
		sections.add(points);
		line=new GuiLine(sections,Counter.T26());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(76,450));
		points.add(new Point(143,450));
		sections.add(points);
		line=new GuiLine(sections,Counter.T2A());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(270,13));
		points.add(new Point(289,13));
		sections.add(points);
		line=new GuiLine(sections,Counter.T08());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(270,33));
		points.add(new Point(289,33));
		sections.add(points);
		line=new GuiLine(sections,Counter.T0F());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(270,53));
		points.add(new Point(289,53));
		sections.add(points);
		line=new GuiLine(sections,Counter.T14());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(270,72));
		points.add(new Point(289,72));
		sections.add(points);
		line=new GuiLine(sections,Counter.T1B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(270,89));
		points.add(new Point(290,89));
		sections.add(points);
		line=new GuiLine(sections,Counter.T1D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(270,107));
		points.add(new Point(291,107));
		sections.add(points);
		line=new GuiLine(sections,Counter.T1E());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(270,124));
		points.add(new Point(289,124));
		sections.add(points);
		line=new GuiLine(sections,Counter.T20());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(270,144));
		points.add(new Point(289,144));
		sections.add(points);
		line=new GuiLine(sections,Counter.T23());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(270,164));
		points.add(new Point(289,164));
		sections.add(points);
		line=new GuiLine(sections,Counter.T27());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(270,184));
		points.add(new Point(289,184));
		sections.add(points);
		line=new GuiLine(sections,Counter.T2B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(320,99));
		points.add(new Point(337,99));
		sections.add(points);
		line=new GuiLine(sections,Uprav2.val2D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(269,208));
		points.add(new Point(335,208));
		sections.add(points);
		line=new GuiLine(sections,Counter.T3A());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(269,234));
		points.add(new Point(335,234));
		sections.add(points);
		line=new GuiLine(sections,Counter.T37());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(269,259));
		points.add(new Point(335,259));
		sections.add(points);
		line=new GuiLine(sections,Counter.T40());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(269,288));
		points.add(new Point(335,288));
		sections.add(points);
		line=new GuiLine(sections,Counter.T43());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(269,313));
		points.add(new Point(335,313));
		sections.add(points);
		line=new GuiLine(sections,Counter.T3D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(269,338));
		points.add(new Point(335,338));
		sections.add(points);
		line=new GuiLine(sections,Counter.T5F());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(269,367));
		points.add(new Point(335,367));
		sections.add(points);
		line=new GuiLine(sections,Counter.T62());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(269,398));
		points.add(new Point(335,398));
		sections.add(points);
		line=new GuiLine(sections,Counter.T67());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(269,425));
		points.add(new Point(335,425));
		sections.add(points);
		line=new GuiLine(sections,Counter.T6A());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(269,454));
		points.add(new Point(335,454));
		sections.add(points);
		line=new GuiLine(sections,Counter.T6F());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(269,484));
		points.add(new Point(335,484));
		sections.add(points);
		line=new GuiLine(sections,Counter.T72());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,17));
		points.add(new Point(488,17));
		sections.add(points);
		line=new GuiLine(sections,Counter.T07());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,37));
		points.add(new Point(488,37));
		sections.add(points);
		line=new GuiLine(sections,Counter.T0E());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,57));
		points.add(new Point(488,57));
		sections.add(points);
		line=new GuiLine(sections,Counter.T2E());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,76));
		points.add(new Point(488,76));
		sections.add(points);
		line=new GuiLine(sections,Counter.T30());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,96));
		points.add(new Point(488,96));
		sections.add(points);
		line=new GuiLine(sections,Counter.T31());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,116));
		points.add(new Point(488,116));
		sections.add(points);
		line=new GuiLine(sections,Counter.T32());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,136));
		points.add(new Point(488,136));
		sections.add(points);
		line=new GuiLine(sections,Counter.T33());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,156));
		points.add(new Point(488,156));
		sections.add(points);
		line=new GuiLine(sections,Counter.T35());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,176));
		points.add(new Point(488,176));
		sections.add(points);
		line=new GuiLine(sections,Counter.T36());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,196));
		points.add(new Point(488,196));
		sections.add(points);
		line=new GuiLine(sections,Counter.T3B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,216));
		points.add(new Point(488,216));
		sections.add(points);
		line=new GuiLine(sections,Counter.T3C());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,236));
		points.add(new Point(488,236));
		sections.add(points);
		line=new GuiLine(sections,Counter.T44());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,255));
		points.add(new Point(488,255));
		sections.add(points);
		line=new GuiLine(sections,Counter.T45());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(469,275));
		points.add(new Point(490,275));
		sections.add(points);
		line=new GuiLine(sections,Counter.T46());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,295));
		points.add(new Point(490,295));
		sections.add(points);
		line=new GuiLine(sections,Counter.T47());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,318));
		points.add(new Point(488,318));
		sections.add(points);
		line=new GuiLine(sections,Counter.T49());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,337));
		points.add(new Point(488,337));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,357));
		points.add(new Point(488,357));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,376));
		points.add(new Point(488,376));
		sections.add(points);
		line=new GuiLine(sections,Counter.T4F());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,396));
		points.add(new Point(488,396));
		sections.add(points);
		line=new GuiLine(sections,Counter.T51());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,416));
		points.add(new Point(488,416));
		sections.add(points);
		line=new GuiLine(sections,Counter.T53());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,436));
		points.add(new Point(488,436));
		sections.add(points);
		line=new GuiLine(sections,Counter.T55());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,456));
		points.add(new Point(488,456));
		sections.add(points);
		line=new GuiLine(sections,Counter.T57());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,475));
		points.add(new Point(488,475));
		sections.add(points);
		line=new GuiLine(sections,Counter.T58());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,495));
		points.add(new Point(488,495));
		sections.add(points);
		line=new GuiLine(sections,Counter.T5A());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,515));
		points.add(new Point(488,515));
		sections.add(points);
		line=new GuiLine(sections,Counter.T5B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,535));
		points.add(new Point(488,535));
		sections.add(points);
		line=new GuiLine(sections,Counter.T5C());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(470,555));
		points.add(new Point(488,555));
		sections.add(points);
		line=new GuiLine(sections,Counter.T63());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(520,285));
		points.add(new Point(539,285));
		sections.add(points);
		line=new GuiLine(sections,Uprav2.val75());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(652,14));
		points.add(new Point(718,14));
		sections.add(points);
		line=new GuiLine(sections,Counter.T78());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(652,39));
		points.add(new Point(718,39));
		sections.add(points);
		line=new GuiLine(sections,Counter.T7B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(652,68));
		points.add(new Point(718,68));
		sections.add(points);
		line=new GuiLine(sections,Counter.T7E());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(652,94));
		points.add(new Point(718,94));
		sections.add(points);
		line=new GuiLine(sections,Counter.T81());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(652,119));
		points.add(new Point(718,119));
		sections.add(points);
		line=new GuiLine(sections,Counter.T82());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(652,148));
		points.add(new Point(718,148));
		sections.add(points);
		line=new GuiLine(sections,Counter.T84());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(652,178));
		points.add(new Point(718,178));
		sections.add(points);
		line=new GuiLine(sections,Counter.T86());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(652,207));
		points.add(new Point(718,207));
		sections.add(points);
		line=new GuiLine(sections,Counter.T88());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(653,234));
		points.add(new Point(719,234));
		sections.add(points);
		line=new GuiLine(sections,Counter.T8A());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(654,261));
		points.add(new Point(672,261));
		sections.add(points);
		line=new GuiLine(sections,Counter.T83());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(654,281));
		points.add(new Point(672,281));
		sections.add(points);
		line=new GuiLine(sections,Counter.T85());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(653,301));
		points.add(new Point(674,301));
		sections.add(points);
		line=new GuiLine(sections,Counter.T87());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(654,321));
		points.add(new Point(674,321));
		sections.add(points);
		line=new GuiLine(sections,Counter.T89());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(654,341));
		points.add(new Point(672,341));
		sections.add(points);
		line=new GuiLine(sections,Counter.T8B());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(704,311));
		points.add(new Point(721,311));
		sections.add(points);
		line=new GuiLine(sections,Uprav2.val8D());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(654,362));
		points.add(new Point(721,362));
		sections.add(points);
		line=new GuiLine(sections,Counter.T90());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(654,391));
		points.add(new Point(721,391));
		sections.add(points);
		line=new GuiLine(sections,Counter.T93());
		gui.addLine(line);

	}
	public static void init(){
		val00=new OR(4);
		val1A=new OR();
		val2D=new OR(10);
		val75=new OR(28);
		val8D=new OR(5);
	}
	public static void connect(){
		val00.setInputPin(0, Counter.T00());
		val00.setInputPin(1, Counter.T2F());
		val00.setInputPin(2, Counter.T75());
		val00.setInputPin(3, Counter.T95());
		
		val1A.setInputPin(0, Counter.T10());
		val1A.setInputPin(1, Counter.T15());
		
		val2D.setInputPin(0, Counter.T08());
		val2D.setInputPin(1, Counter.T0F());
		val2D.setInputPin(2, Counter.T14());
		val2D.setInputPin(3, Counter.T1B());
		val2D.setInputPin(4, Counter.T1D());
		val2D.setInputPin(5, Counter.T1E());
		val2D.setInputPin(6, Counter.T20());
		val2D.setInputPin(7, Counter.T23());
		val2D.setInputPin(8, Counter.T27());
		val2D.setInputPin(9, Counter.T2B());
		
		val75.setInputPin(0, Counter.T07());
		val75.setInputPin(1, Counter.T0E());
		val75.setInputPin(2, Counter.T2E());
		val75.setInputPin(3, Counter.T30());
		val75.setInputPin(4, Counter.T31());
		val75.setInputPin(5, Counter.T32());
		val75.setInputPin(6, Counter.T33());
		val75.setInputPin(7, Counter.T35());
		val75.setInputPin(8, Counter.T36());
		val75.setInputPin(9, Counter.T3B());
		val75.setInputPin(10, Counter.T3C());
		val75.setInputPin(11, Counter.T44());
		val75.setInputPin(12, Counter.T45());
		val75.setInputPin(13, Counter.T46());
		val75.setInputPin(14, Counter.T47());
		val75.setInputPin(15, Counter.T49());
		val75.setInputPin(16, Counter.T4B());
		val75.setInputPin(17, Counter.T4D());
		val75.setInputPin(18, Counter.T4F());
		val75.setInputPin(19, Counter.T51());
		val75.setInputPin(20, Counter.T53());
		val75.setInputPin(21, Counter.T55());
		val75.setInputPin(22, Counter.T57());
		val75.setInputPin(23, Counter.T58());
		val75.setInputPin(24, Counter.T5A());
		val75.setInputPin(25, Counter.T5B());
		val75.setInputPin(26, Counter.T63());
		val75.setInputPin(27, Counter.T5C());
		
		val8D.setInputPin(0, Counter.T83());
		val8D.setInputPin(1, Counter.T85());
		val8D.setInputPin(2, Counter.T87());
		val8D.setInputPin(3, Counter.T89());
		val8D.setInputPin(4, Counter.T8B());
		
	}
	public static Pin val01(){
		return Counter.T01();
	}
	public static Pin val04(){
		return Counter.T04();
	}
	public static Pin val08(){
		return Counter.T06();
	}
	public static Pin val0B(){
		return Counter.T0B();
	}
	public static Pin val0F(){
		return Counter.T0D();
	}
	public static Pin val13(){
		return Counter.T13();
	}
	public static Pin val18(){
		return Counter.T18();
	}
	public static Pin val1E(){
		return Counter.T1C();
	}
	public static Pin val24(){
		return Counter.T21();
	}
	public static Pin val25(){
		return Counter.T25();
	}
	public static Pin val28(){
		return Counter.T26();
	}
	public static Pin val2A(){
		return Counter.T2A();
	}
	public static Pin val3A(){
		return Counter.T3A();
	}
	public static Pin val3C(){
		return Counter.T37();
	}
	public static Pin val40(){
		return Counter.T40();
	}
	public static Pin val43(){
		return Counter.T43();
	}
	public static Pin val45(){
		return Counter.T3D();
	}
	public static Pin val5F(){
		return Counter.T5F();
	}
	public static Pin val62(){
		return Counter.T62();
	}
	public static Pin val67(){
		return Counter.T67();
	}
	public static Pin val6A(){
		return Counter.T6A();
	}
	public static Pin val6F(){
		return Counter.T6F();
	}
	public static Pin val72(){
		return Counter.T72();
	}
	public static Pin val78(){
		return Counter.T78();
	}
	public static Pin val7B(){
		return Counter.T7B();
	}
	public static Pin val7E(){
		return Counter.T7E();
	}
	public static Pin val81(){
		return Counter.T81();
	}
	public static Pin val84(){
		return Counter.T82();
	}
	public static Pin val86(){
		return Counter.T84();
	}
	public static Pin val88(){
		return Counter.T86();
	}
	public static Pin val8A(){
		return Counter.T88();
	}
	public static Pin val8C(){
		return Counter.T8A();
	}
	public static Pin val90(){
		return Counter.T90();
	}
	public static Pin val93(){
		return Counter.T93();
	}
	public static Pin val00(){
		return val00.getOut(0);
	}
	public static Pin val1A(){
		return val1A.getOut(0);
	}
	public static Pin val2D(){
		return val2D.getOut(0);
	}
	public static Pin val75(){
		return val75.getOut(0);
	}
	public static Pin val8D(){
		return val8D.getOut(0);
	}
}
