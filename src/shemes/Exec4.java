package shemes;

import gui.GuiLine;
import gui.GuiScheme;

import java.awt.Point;
import java.util.ArrayList;

import components.*;

public class Exec4 {

	public static NOT NOT1;
	public static XOR XOR1;
	public static NOT NOT2;
	public static OR OR1;
	public static NOT NOT3;
	public static OR OR2;
	public static NOT NOT4;
	public static NOT NOT5;
	public static NOT NOT6;
	public static NOT NOT7;
	public static MP MX3;

	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui() {
		
		GuiLine line;									// Pomocna promenljiva
		gui=new GuiScheme("./src/images/exec4.png");		
		
		ArrayList<ArrayList<Point>> sections;
		ArrayList<Point> points;
		
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(131,16));
		points.add(new Point(320,16));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(253,17));
		points.add(new Point(253,44));
		points.add(new Point(264,44));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWZ());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(310,44));
		points.add(new Point(320,44));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT1.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(131,80));
		points.add(new Point(140,80));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWN());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(131,99));
		points.add(new Point(140,99));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWV());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(180,89));
		points.add(new Point(320,89));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(192,89));
		points.add(new Point(192,154));
		points.add(new Point(205,154));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(253,90));
		points.add(new Point(253,117));
		points.add(new Point(264,117));
		sections.add(points);
		line=new GuiLine(sections,Exec4.XOR1.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(311,117));
		points.add(new Point(320,117));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT2.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(131,172));
		points.add(new Point(206,172));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWZ());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(241,163));
		points.add(new Point(320,163));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(253,163));
		points.add(new Point(253,190));
		points.add(new Point(264,190));
		sections.add(points);
		line=new GuiLine(sections,Exec4.OR1.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(310,190));
		points.add(new Point(321,190));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT3.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(131,227));
		points.add(new Point(144,227));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWC());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(131,245));
		points.add(new Point(145,245));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWZ());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(180,236));
		points.add(new Point(320,236));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(253,237));
		points.add(new Point(253,263));
		points.add(new Point(264,263));
		sections.add(points);
		line=new GuiLine(sections,Exec4.OR2.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(309,263));
		points.add(new Point(320,263));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT4.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(133,376));
		points.add(new Point(317,376));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(250,377));
		points.add(new Point(250,404));
		points.add(new Point(261,404));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWC());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(307,404));
		points.add(new Point(317,404));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT5.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(133,450));
		points.add(new Point(133,450));
		points.add(new Point(317,450));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(250,451));
		points.add(new Point(250,477));
		points.add(new Point(261,477));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWV());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(307,477));
		points.add(new Point(318,477));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT6.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(133,523));
		points.add(new Point(317,523));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(250,524));
		points.add(new Point(250,550));
		points.add(new Point(261,550));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWN());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(307,550));
		points.add(new Point(317,550));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT7.getOut(0));
		gui.addLine(line);

		
		
		
		/// Desni deo
		
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,38));
		points.add(new Point(530,38));
		sections.add(points);
		line=new GuiLine(sections,Exec4.OR2.getOut(0));
		gui.addLine(line);

		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,68));
		points.add(new Point(530,68));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWC());
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,99));
		points.add(new Point(530,99));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT5.getOut(0));
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,129));
		points.add(new Point(530,129));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT4.getOut(0));
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,160));
		points.add(new Point(530,160));
		sections.add(points);
		line=new GuiLine(sections,Exec4.OR1.getOut(0));
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,190));
		points.add(new Point(530,190));
		sections.add(points);
		line=new GuiLine(sections,Exec4.XOR1.getOut(0));
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,221));
		points.add(new Point(530,221));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT2.getOut(0));
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,251));
		points.add(new Point(530,251));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT3.getOut(0));
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,279));
		points.add(new Point(530,279));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT5.getOut(0));
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,309));
		points.add(new Point(530,309));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWC());
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,340));
		points.add(new Point(530,340));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT6.getOut(0));
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,370));
		points.add(new Point(530,370));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWV());
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,401));
		points.add(new Point(530,401));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT7.getOut(0));
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,431));
		points.add(new Point(530,431));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWN());
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,462));
		points.add(new Point(530,462));
		sections.add(points);
		line=new GuiLine(sections,Exec4.NOT1.getOut(0));
		gui.addLine(line);
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(518,492));
		points.add(new Point(530,492));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWZ());
		gui.addLine(line);

		
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(531,547));
		points.add(new Point(531,535));
		points.add(new Point(552,535));
		points.add(new Point(552,524));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR27());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(567,547));
		points.add(new Point(567,524));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR26());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(589,548));
		points.add(new Point(589,524));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR25());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(629,548));
		points.add(new Point(629,535));
		points.add(new Point(607,535));
		points.add(new Point(607,524));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR24());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(623,263));
		points.add(new Point(622,263));
		points.add(new Point(676,263));
		sections.add(points);
		line=new GuiLine(sections,Exec4.MX3.getOut(0));
		gui.addLine(line);

		//
		//

		
	}
	
	private Exec4(){
		
	}

	public static void init() {
		NOT1 = new NOT();
		XOR1 = new XOR();
		NOT2 = new NOT();
		OR1 = new OR();
		NOT3 = new NOT();
		OR2 = new OR();
		NOT4 = new NOT();
		NOT5 = new NOT();
		NOT6 = new NOT();
		NOT7 = new NOT();
		MX3 = new MP(16);

	}

	public static void connect() {

		NOT1.setInputPin(0, Exec2.PSWZ());
		XOR1.setInputPin(0, Exec2.PSWN());
		XOR1.setInputPin(1, Exec2.PSWV());
		NOT2.setInputPin(0, XOR1.getOut(0));
		OR1.setInputPin(0, XOR1.getOut(0));
		OR1.setInputPin(1, Exec2.PSWZ());
		NOT3.setInputPin(0, OR1.getOut(0));
		OR2.setInputPin(0, Exec2.PSWC());
		OR2.setInputPin(1, Exec2.PSWZ());
		NOT4.setInputPin(0, OR2.getOut(0));
		NOT5.setInputPin(0, Exec2.PSWC());
		NOT6.setInputPin(0, Exec2.PSWV());
		NOT7.setInputPin(0, Exec2.PSWN());

		MX3.setInputPin(0, Exec2.PSWZ());
		MX3.setInputPin(1, NOT1.getOut(0));
		MX3.setInputPin(2, Exec2.PSWN());
		MX3.setInputPin(3, NOT7.getOut(0));
		MX3.setInputPin(4, Exec2.PSWV());
		MX3.setInputPin(5, NOT6.getOut(0));
		MX3.setInputPin(6, Exec2.PSWC());
		MX3.setInputPin(7, NOT5.getOut(0));
		MX3.setInputPin(8, NOT3.getOut(0));
		MX3.setInputPin(9, NOT2.getOut(0));
		MX3.setInputPin(10, XOR1.getOut(0));
		MX3.setInputPin(11, OR1.getOut(0));
		MX3.setInputPin(12, NOT4.getOut(0));
		MX3.setInputPin(13, NOT5.getOut(0));
		MX3.setInputPin(14, Exec2.PSWC());
		MX3.setInputPin(15, OR2.getOut(0));
		MX3.setCtrl(0, Fetch1.IR24());
		MX3.setCtrl(1, Fetch1.IR25());
		MX3.setCtrl(2, Fetch1.IR26());
		MX3.setCtrl(3, Fetch1.IR27());

	}

	public static Pin brpom() {
		return MX3.getOut(0);
	}
}
