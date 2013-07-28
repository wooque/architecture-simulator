package shemes;

import java.awt.Point;
import java.util.ArrayList;

import gui.*;
import components.*;

public class Intr2 {

	public static AND AND1, AND2, AND3, AND4;
	public static OR OR1;
	public static CD CDP;
	public static CMP AB;
	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui(){
		gui=new GuiScheme("./src/images/intr2.png");
		ArrayList<ArrayList<Point>> sections=null;
		ArrayList<Point> points=null;
		GuiLine line=null;
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(364,17));
		points.add(new Point(523,17));
		points.add(new Point(523,165));
		sections.add(points);
		line=new GuiLine(sections,Intr1.IMR1());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(364,69));
		points.add(new Point(465,69));
		points.add(new Point(465,165));
		sections.add(points);
		line=new GuiLine(sections,Intr1.IMR2());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(364,108));
		points.add(new Point(406,108));
		points.add(new Point(406,165));
		sections.add(points);
		line=new GuiLine(sections,Intr1.IMR3());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(578,17));
		points.add(new Point(539,17));
		points.add(new Point(539,165));
		sections.add(points);
		line=new GuiLine(sections,Intr1.PRINTR1());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(578,69));
		points.add(new Point(481,69));
		points.add(new Point(481,165));
		sections.add(points);
		line=new GuiLine(sections,Intr1.PRINTR2());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(578,108));
		points.add(new Point(423,108));
		points.add(new Point(423,165));
		sections.add(points);
		line=new GuiLine(sections,Intr1.PRINTR3());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(413,206));
		points.add(new Point(413,388));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(617,253));
		points.add(new Point(358,253));
		points.add(new Point(358,276));
		points.add(new Point(322,276));
		sections.add(points);
		line=new GuiLine(sections,Intr2.irm3());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(617,282));
		points.add(new Point(322,282));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(471,206));
		points.add(new Point(471,337));
		points.add(new Point(438,337));
		points.add(new Point(438,388));
		sections.add(points);
		line=new GuiLine(sections,Intr2.irm2());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(617,309));
		points.add(new Point(358,309));
		points.add(new Point(358,289));
		points.add(new Point(323,289));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(529,206));
		points.add(new Point(529,357));
		points.add(new Point(464,357));
		points.add(new Point(464,388));
		sections.add(points);
		line=new GuiLine(sections,Intr2.irm1());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(490,380));
		points.add(new Point(490,388));
		sections.add(points);
		line=new GuiLine(sections,new Pin(false));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(468,448));
		points.add(new Point(468,515));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(520,515));
		points.add(new Point(337,515));
		sections.add(points);
		line=new GuiLine(sections,Intr2.prl0());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(441,448));
		points.add(new Point(441,485));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(520,485));
		points.add(new Point(337,485));
		sections.add(points);
		line=new GuiLine(sections,Intr2.prl1());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(254,515));
		points.add(new Point(266,515));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWL0());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(254,486));
		points.add(new Point(266,486));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWL1());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(303,446));
		points.add(new Point(303,337));
		points.add(new Point(251,337));
		sections.add(points);
		line=new GuiLine(sections,Intr2.AB.getOut(0));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(286,282));
		points.add(new Point(262,282));
		points.add(new Point(262,328));
		points.add(new Point(251,328));
		sections.add(points);
		line=new GuiLine(sections,OR1.getOut(0));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(263,360));
		points.add(new Point(263,347));
		points.add(new Point(251,347));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWI());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(210,337));
		points.add(new Point(198,337));
		sections.add(points);
		line=new GuiLine(sections,Intr2.printr());
		gui.addLine(line);

	}
	public static void init() {
		AND1 = new AND();
		AND2 = new AND();
		AND3 = new AND();
		AND4 = new AND(3);
		OR1 = new OR(3);
		CDP = new CD(4);
		AB = new CMP(2);
	}

	public static void connect() {
		AND1.setInputPin(0, Intr1.IMR3());
		AND1.setInputPin(1, Intr1.PRINTR3());

		AND2.setInputPin(0, Intr1.IMR2());
		AND2.setInputPin(1, Intr1.PRINTR2());

		AND3.setInputPin(0, Intr1.IMR1());
		AND3.setInputPin(1, Intr1.PRINTR1());

		CDP.setE(new Pin(true));
		CDP.setInputPin(0, new Pin(false));
		CDP.setInputPin(1, AND3.getOut(0));
		CDP.setInputPin(2, AND2.getOut(0));
		CDP.setInputPin(3, AND1.getOut(0));

		AB.setE(new Pin(true));
		AB.setPinA(0, CDP.getOut(0));
		AB.setPinA(1, CDP.getOut(1));
		AB.setPinB(0, Exec2.PSWL0());
		AB.setPinB(1, Exec2.PSWL1());

		OR1.setInputPin(0, AND1.getOut(0));
		OR1.setInputPin(1, AND2.getOut(0));
		OR1.setInputPin(2, AND3.getOut(0));

		AND4.setInputPin(0, OR1.getOut(0));
		AND4.setInputPin(1, AB.getOut(0));
		AND4.setInputPin(2, Exec2.PSWI());

	}

	public static Pin irm1() {
		return AND3.getOut(0);
	}

	public static Pin irm2() {
		return AND2.getOut(0);
	}

	public static Pin irm3() {
		return AND1.getOut(0);
	}

	public static Pin prl0() {
		return CDP.getOut(0);
	}

	public static Pin prl1() {
		return CDP.getOut(1);
	}

	public static Pin printr() {
		return AND4.getOut(0);
	}

}
