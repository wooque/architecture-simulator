package shemes;

import java.awt.Point;
import java.util.ArrayList;

import gui.GuiLine;
import gui.GuiScheme;
import components.*;

public class Arbitary {
	
	static CD BRCD;
	static DC BGDC;
	//Pinovi sa kojih bi trebalo da dolaze signali sa periferija
	//Posto one ne postoje bice kodovani da su uvek false
	private static Pin BR2,BR3,BR4;
	
	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}
	
public static void gui() {
		
		GuiLine line;									// Pomocna promenljiva
		gui=new GuiScheme("./src/images/Arbitrator.png");
		
		ArrayList<ArrayList<Point>> sections;
		ArrayList<Point> points;
		
		// Iz BR1 na 0-ti ulaz kodera
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(268,38));
		points.add(new Point(268,160));
		sections.add(points);
		line=new GuiLine(sections,Bus3.BR1());
		gui.addLine(line);
		
		// Iz BR2 na 1. ulaz kodera
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(334,38));
		points.add(new Point(334,160));
		sections.add(points);
		line=new GuiLine(sections,Arbitary.BR2);
		gui.addLine(line);
		
		// Iz BR2 na 2. ulaz kodera
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(406,38));
		points.add(new Point(406,160));
		sections.add(points);
		line=new GuiLine(sections,Arbitary.BR3);
		gui.addLine(line);
		
		// Iz BR2 na 3. ulaz kodera
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(476,38));
		points.add(new Point(476,160));
		sections.add(points);
		line=new GuiLine(sections,Arbitary.BR4);
		gui.addLine(line);
		
		// Iz 0tog izlaza kodera u 0ti dekodera
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(328,292));
		points.add(new Point(328,348));
		sections.add(points);
		line=new GuiLine(sections,Arbitary.BRCD.getOut(0));
		gui.addLine(line);
		
		// Iz 1. izlaza kodera u 1. dekodera
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(416,292));
		points.add(new Point(416,348));
		sections.add(points);
		line=new GuiLine(sections,Arbitary.BRCD.getOut(1));
		gui.addLine(line);
		
		// Iz 0. izlaza dekodera
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(270,481));
		points.add(new Point(270,538));
		points.add(new Point(227,538));
		points.add(new Point(227,566));
		sections.add(points);
		line=new GuiLine(sections,Arbitary.BGDC.getOut(0));
		gui.addLine(line);
		
		// Iz 1. izlaza dekodera
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(336,481));
		points.add(new Point(336,566));
		sections.add(points);
		line=new GuiLine(sections,Arbitary.BGDC.getOut(1));
		gui.addLine(line);
		
		// Iz 2. izlaza dekodera
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(408,481));
		points.add(new Point(408,538));
		points.add(new Point(450,538));
		points.add(new Point(450,564));
		sections.add(points);
		line=new GuiLine(sections,Arbitary.BGDC.getOut(2));
		gui.addLine(line);
		
		// Iz 3. izlaza dekodera
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(478,481));
		points.add(new Point(478,538));
		points.add(new Point(564,538));
		points.add(new Point(564,566));
		sections.add(points);
		line=new GuiLine(sections,Arbitary.BGDC.getOut(3));
		gui.addLine(line);


}
	
	private Arbitary(){
		
	}
	
	public static void init(){
		BRCD=new CD(4);
		BGDC=new DC(2);
		BR2=new Pin(false);
		BR3=new Pin(false);
		BR4=new Pin(false);
	}
	
	public static void connect(){
		
		BRCD.setInputPin(0, Bus3.BR1());
		BRCD.setInputPin(1, BR2);
		BRCD.setInputPin(2, BR3);
		BRCD.setInputPin(3, BR4);
		
		BGDC.setInputPin(0, BRCD.getOut(0));
		BGDC.setInputPin(1, BRCD.getOut(1));
		
	}
	
	public static Pin BG_IN1(){
		return BGDC.getOut(0);
	}
	//ne koriste se nigde, jer nema periferija
	//ali mozda u buducnosti...
	public static Pin BG_IN2(){
		return BGDC.getOut(1);
	}
	public static Pin BG_IN3(){
		return BGDC.getOut(2);
	}
	public static Pin BG_IN4(){
		return BGDC.getOut(3);
	}
	
}
