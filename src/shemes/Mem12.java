package shemes;

import java.awt.Point;
import java.util.ArrayList;

import gui.*;
import components.*;

public class Mem12 {

	
	public static REG CNT;
	public static DC DC1;
	public static AND OEdata,PDRin,decTIME,ldTIME,fcbus,incCNT1,incCNT2,ldCNT;
	public static NOT NOTaccess,NOTrw;
	public static OR OEfcbus,incCNT;
	public static GuiScheme gui;
	public static BoolsToInt REGCNT;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui(){
		gui=new GuiScheme("./src/images/mem12.png");
		ArrayList<ArrayList<Point>> sections=null;
		ArrayList<Point> points=null;
		GuiLine line=null;
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(338,106));
		points.add(new Point(338,123));
		sections.add(points);
		line=new GuiLine(sections,Mem12.CNT.getOut(1));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(385,106));
		points.add(new Point(385,123));
		sections.add(points);
		line=new GuiLine(sections,Mem12.CNT.getOut(0));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(340,173));
		points.add(new Point(340,474));
		points.add(new Point(183,474));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(340,444));
		points.add(new Point(185,444));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(340,325));
		points.add(new Point(534,325));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(340,264));
		points.add(new Point(186,264));
		sections.add(points);
		line=new GuiLine(sections,Mem12.DC1.getOut(2));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(388,173));
		points.add(new Point(388,486));
		points.add(new Point(183,486));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(388,361));
		points.add(new Point(186,361));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(388,314));
		points.add(new Point(186,314));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(388,228));
		points.add(new Point(534,228));
		sections.add(points);
		line=new GuiLine(sections,Mem12.DC1.getOut(1));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,173));
		points.add(new Point(427,387));
		points.add(new Point(185,387));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(427,269));
		points.add(new Point(534,269));
		sections.add(points);
		line=new GuiLine(sections,Mem12.DC1.getOut(0));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(633,271));
		points.add(new Point(651,271));
		points.add(new Point(651,89));
		points.add(new Point(445,89));
		sections.add(points);
		line=new GuiLine(sections,incCNT.getOut(0));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(564,318));
		points.add(new Point(682,318));
		points.add(new Point(682,72));
		points.add(new Point(445,72));
		sections.add(points);
		line=new GuiLine(sections,ldCNT.getOut(0));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(564,235));
		points.add(new Point(580,235));
		points.add(new Point(580,264));
		points.add(new Point(605,264));
		sections.add(points);
		line=new GuiLine(sections,incCNT1.getOut(0));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(564,276));
		points.add(new Point(605,276));
		sections.add(points);
		line=new GuiLine(sections,incCNT2.getOut(0));
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(232,278));
		points.add(new Point(186,278));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(201,278));
		points.add(new Point(201,306));
		points.add(new Point(186,306));
		sections.add(points);
		line=new GuiLine(sections,Mem11.rds());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(234,321));
		points.add(new Point(186,321));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(201,321));
		points.add(new Point(201,347));
		points.add(new Point(191,347));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(503,243));
		points.add(new Point(534,243));
		sections.add(points);
		line=new GuiLine(sections,Mem11.access());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(231,401));
		points.add(new Point(185,401));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(200,401));
		points.add(new Point(200,429));
		points.add(new Point(185,429));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(502,283));
		points.add(new Point(534,283));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(518,283));
		points.add(new Point(518,311));
		points.add(new Point(528,311));
		sections.add(points);
		line=new GuiLine(sections,Mem11.rw());
		gui.addLine(line);
		
		//Nisu bili iscrtani:
		
		//T3:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(301,173));
		points.add(new Point(301,183));
		sections.add(points);
		line=new GuiLine(sections,DC1.getOut(3));
		gui.addLine(line);
		
		// 
		//OEdata: 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(140,271));
		points.add(new Point(156,271));
		sections.add(points);
		line=new GuiLine(sections,OEdata.getOut(0));
		gui.addLine(line);

		// 
		// PDRin:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(140,314));
		points.add(new Point(155,314));
		sections.add(points);
		line=new GuiLine(sections,PDRin.getOut(0));
		gui.addLine(line);

		// 
		// decTIME:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(140,354));
		points.add(new Point(155,354));
		sections.add(points);
		line=new GuiLine(sections,decTIME.getOut(0));
		gui.addLine(line);

		// 
		// ldTIME:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(139,394));
		points.add(new Point(155,394));
		sections.add(points);
		line=new GuiLine(sections,ldTIME.getOut(0));
		gui.addLine(line);

		// 
		// fcbus:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(139,437));
		points.add(new Point(154,437));
		sections.add(points);
		line=new GuiLine(sections,fcbus.getOut(0));
		gui.addLine(line);

		// 
		// OEfcbus:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(137,479));
		points.add(new Point(156,479));
		sections.add(points);
		line=new GuiLine(sections,OEfcbus.getOut(0));
		gui.addLine(line);

		// Dodate linije za prikaz nula na ulazu CNT:
		// 1 nula:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(337,38));
		points.add(new Point(337,56));
		sections.add(points);
		line=new GuiLine(sections,new Pin(false));
		gui.addLine(line);

		// 
		// 2 nula:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(384,38));
		points.add(new Point(384,56));
		sections.add(points);
		line=new GuiLine(sections,new Pin(false));
		gui.addLine(line);

		// 
		// memCLK kod memCNT:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(264,81));
		points.add(new Point(272,81));
		sections.add(points);
		line=new GuiLine(sections,LogicalComponent.getMEMCLK());
		gui.addLine(line);

		//
		//LABELE nema.
		
	}

	public static void init() {

		CNT = new REG(2,"CNT_mem");
		CNT.setClock(3);
		DC1 = new DC(2);
		DC1.setE(new Pin(true));
		OEdata=new AND();
		PDRin=new AND(3);
		decTIME=new AND(2);
		ldTIME=new AND(2);
		fcbus=new AND(2);
		incCNT1=new AND(2);
		incCNT2=new AND(2);
		ldCNT=new AND(2);
		NOTaccess=new NOT();
		NOTrw=new NOT();
		OEfcbus=new OR();
		incCNT=new OR();
		REGCNT = new BoolsToInt(2, 2);
	}

	public static void connect() {
		
		CNT.setInputPin(0, new Pin(false));
		CNT.setInputPin(1, new Pin(false));
		CNT.setPinLd(ldCNT.getOut(0));
		CNT.setPinInc(incCNT.getOut(0));

		DC1.setInputPin(0, CNT.getOut(0));
		DC1.setInputPin(1, CNT.getOut(1));
		
		OEdata.setInputPin(0, DC1.getOut(2));
		OEdata.setInputPin(1, Mem11.rds());
		PDRin.setInputPin(0, DC1.getOut(1));
		PDRin.setInputPin(1, Mem11.rds());
		PDRin.setInputPin(2, Mem11.access());
		decTIME.setInputPin(0, DC1.getOut(1));
		decTIME.setInputPin(1, NOTaccess.getOut(0));
		ldTIME.setInputPin(0, Mem11.rw());
		ldTIME.setInputPin(1, DC1.getOut(0));
		fcbus.setInputPin(0, Mem11.rw());
		fcbus.setInputPin(1, DC1.getOut(2));
		incCNT1.setInputPin(0, DC1.getOut(1));
		incCNT1.setInputPin(1, Mem11.access());
		incCNT2.setInputPin(0, DC1.getOut(0));
		incCNT2.setInputPin(1, Mem11.rw());
		ldCNT.setInputPin(0, NOTrw.getOut(0));
		ldCNT.setInputPin(1, DC1.getOut(2));
		
		NOTaccess.setInputPin(0, Mem11.access());
		NOTrw.setInputPin(0, Mem11.rw());
		
		OEfcbus.setInputPin(0, DC1.getOut(2));
		OEfcbus.setInputPin(1, DC1.getOut(1));
		incCNT.setInputPin(0, incCNT1.getOut(0));
		incCNT.setInputPin(1, incCNT2.getOut(0));
	
		REGCNT.setInputPin(0, CNT.getOut(0));
		REGCNT.setInputPin(1, CNT.getOut(1));
	}
	
	public static Pin CNT0(){
		return CNT.getOut(0);
	}
	public static Pin CNT1(){
		return CNT.getOut(1);
	}
	public static Pin ldCNT(){
		return ldCNT.getOut(0);
	}
	public static Pin incCNT(){
		return incCNT.getOut(0);
	}

	public static Pin T0() {
		return DC1.getOut(0);
	}

	public static Pin T1() {
		return DC1.getOut(1);
	}

	public static Pin T2() {
		return DC1.getOut(2);
	}
	public static Pin OEdata() {
		return OEdata.getOut(0);
	}
	public static Pin PDRin() {
		return PDRin.getOut(0);
	}
	public static Pin decTIME() {
		return decTIME.getOut(0);
	}
	
	public static Pin ldTIME() {
		return ldTIME.getOut(0);
	}
	public static Pin fcbus() {
		return fcbus.getOut(0);
	}
	public static Pin OEfcbus() {
		return OEfcbus.getOut(0);
	}
	
	
}
