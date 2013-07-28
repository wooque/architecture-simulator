package shemes;

import gui.GuiLine;
import gui.GuiScheme;

import java.awt.Point;
import java.util.ArrayList;

import components.*;

public class Exec3 {
	public static OR NOR1;
	public static AND NAND1;
	public static NOT ZNOT0;
	public static NOT ZNOT1;
	public static NOT ZNOT2;
	public static NOT ZNOT3;
	public static NOT ZNOT4;
	public static NOT ZNOT5;
	public static NOT ZNOT6;
	public static NOT ZNOT7;
	public static AND ZAND1;
	public static AND ZAND2;

	public static AND CAND1;
	public static AND CAND2;
	public static NOT CNOT1;
	public static OR COR1;
	public static AND CAND3;
	public static OR COR2;
	public static AND CAND4;
	public static OR COR3;

	public static NOT VNOT1;
	public static NOT VNOT2;
	public static AND VAND1;
	public static NOT VNOT3;
	public static AND VAND2;
	public static OR VOR1;
	public static AND VAND3;

	public static NOT VNOT4;
	public static AND VAND4;
	public static NOT VNOT5;
	public static NOT VNOT6;
	public static AND VAND5;
	public static OR VOR2;
	public static AND VAND6;
	public static OR VOR3;

	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui() {
		
		GuiLine line;									// Pomocna promenljiva
		gui=new GuiScheme("./src/images/exec3.png");		
		
		ArrayList<ArrayList<Point>> sections;
		ArrayList<Point> points;
		
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,23));
		points.add(new Point(258,23));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ABBits.getOut(7));
		gui.addLine(line);
		

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(290,28));
		points.add(new Point(303,28));
		sections.add(points);
		line=new GuiLine(sections,Exec3.N());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(290,509));
		points.add(new Point(300,509));
		sections.add(points);
		line=new GuiLine(sections,Exec3.Z());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(240,234));
		points.add(new Point(249,234));
		points.add(new Point(249,33));
		points.add(new Point(258,33));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(249,235));
		points.add(new Point(249,504));
		points.add(new Point(258,504));
		sections.add(points);
		line=new GuiLine(sections,Exec3.NOR1.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(240,514));
		points.add(new Point(258,514));
		sections.add(points);
		line=new GuiLine(sections,Exec3.ZAND1.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,63));
		points.add(new Point(208,63));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.LD());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,83));
		points.add(new Point(208,83));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ADD());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,103));
		points.add(new Point(208,103));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.SUB());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,144));
		points.add(new Point(208,144));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.OR());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,164));
		points.add(new Point(208,164));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.XOR());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,124));
		points.add(new Point(208,124));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.AND());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,184));
		points.add(new Point(208,184));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ASR());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,204));
		points.add(new Point(208,204));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.LSR());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,224));
		points.add(new Point(209,224));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ROR());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(208,244));
		points.add(new Point(189,244));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.RORC());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,264));
		points.add(new Point(208,264));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ASL());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,284));
		points.add(new Point(208,284));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.LSL());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(188,304));
		points.add(new Point(208,304));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ROL());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,324));
		points.add(new Point(208,324));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ROLC());
		gui.addLine(line);

		
		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,444));
		points.add(new Point(202,444));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ABBits.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,464));
		points.add(new Point(202,464));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ABBits.getOut(1));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(188,484));
		points.add(new Point(202,484));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ABBits.getOut(2));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(187,504));
		points.add(new Point(202,504));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ABBits.getOut(3));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,524));
		points.add(new Point(202,524));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ABBits.getOut(4));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,544));
		points.add(new Point(202,544));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ABBits.getOut(5));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,564));
		points.add(new Point(202,564));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ABBits.getOut(6));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(189,585));
		points.add(new Point(202,585));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ABBits.getOut(7));
		gui.addLine(line);

		//
		//
		
		 
		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(502,26));
		points.add(new Point(522,26));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ADD());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(503,66));
		points.add(new Point(522,66));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.SUB());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(463,96));
		points.add(new Point(513,96));
		points.add(new Point(513,41));
		points.add(new Point(522,41));
		sections.add(points);
		line=new GuiLine(sections,Exec1.C8());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(463,118));
		points.add(new Point(472,118));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ASR());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(462,139));
		points.add(new Point(474,139));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.LSR());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(463,159));
		points.add(new Point(462,159));
		points.add(new Point(473,159));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ROR());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(462,179));
		points.add(new Point(472,179));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.RORC());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(504,149));
		points.add(new Point(522,149));
		sections.add(points);
		line=new GuiLine(sections,Exec3.COR1.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(463,219));
		points.add(new Point(472,219));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ASL());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(462,239));
		points.add(new Point(474,239));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.LSL());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(462,259));
		points.add(new Point(474,259));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ROL());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(460,279));
		points.add(new Point(472,279));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ROLC());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(504,249));
		points.add(new Point(522,249));
		sections.add(points);
		line=new GuiLine(sections,Exec3.COR2.getOut(0));
		gui.addLine(line);

		
		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(463,199));
		points.add(new Point(513,199));
		points.add(new Point(513,159));
		points.add(new Point(522,159));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ABBits.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(462,299));
		points.add(new Point(513,299));
		points.add(new Point(513,259));
		points.add(new Point(522,259));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ABBits.getOut(7));
		gui.addLine(line);
		
		

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(554,33));
		points.add(new Point(573,33));
		points.add(new Point(573,98));
		points.add(new Point(582,98));
		sections.add(points);
		line=new GuiLine(sections,Exec3.CAND1.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(554,73));
		points.add(new Point(563,73));
		points.add(new Point(563,108));
		points.add(new Point(586,108));
		sections.add(points);
		line=new GuiLine(sections,Exec3.CAND2.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(555,154));
		points.add(new Point(563,154));
		points.add(new Point(563,118));
		points.add(new Point(586,118));
		sections.add(points);
		line=new GuiLine(sections,Exec3.CAND3.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(555,254));
		points.add(new Point(573,254));
		points.add(new Point(573,129));
		points.add(new Point(583,129));
		sections.add(points);
		line=new GuiLine(sections,Exec3.CAND4.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(614,113));
		points.add(new Point(625,113));
		sections.add(points);
		line=new GuiLine(sections,Exec3.C());
		gui.addLine(line);

		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(437,347));
		points.add(new Point(487,347));
		points.add(new Point(487,577));
		points.add(new Point(506,577));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(488,537));
		points.add(new Point(501,537));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(488,477));
		points.add(new Point(506,477));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(488,437));
		points.add(new Point(500,437));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ABBits.getOut(7));
		gui.addLine(line);



		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(436,367));
		points.add(new Point(467,367));
		points.add(new Point(467,587));
		points.add(new Point(500,587));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(468,547));
		points.add(new Point(506,547));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(468,447));
		points.add(new Point(501,447));
		sections.add(points);
		line=new GuiLine(sections,Exec1.BBBits.getOut(7));
		gui.addLine(line);




		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(437,387));
		points.add(new Point(447,387));
		points.add(new Point(447,597));
		points.add(new Point(500,597));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(448,557));
		points.add(new Point(506,557));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(448,497));
		points.add(new Point(500,497));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(448,457));
		points.add(new Point(506,457));
		sections.add(points);
		line=new GuiLine(sections,Exec1.ALUBits.getOut(7));
		gui.addLine(line);



		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(437,417));
		points.add(new Point(606,417));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ADD());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(436,517));
		points.add(new Point(606,517));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.SUB());
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(538,447));
		points.add(new Point(547,447));
		points.add(new Point(547,462));
		points.add(new Point(558,462));
		sections.add(points);
		line=new GuiLine(sections, Exec3.VAND1.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(538,487));
		points.add(new Point(547,487));
		points.add(new Point(547,472));
		points.add(new Point(558,472));
		sections.add(points);
		line=new GuiLine(sections, Exec3.VAND2.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(538,547));
		points.add(new Point(547,547));
		points.add(new Point(547,562));
		points.add(new Point(558,562));
		sections.add(points);
		line=new GuiLine(sections, Exec3.VAND4.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(538,587));
		points.add(new Point(547,587));
		points.add(new Point(547,572));
		points.add(new Point(559,572));
		sections.add(points);
		line=new GuiLine(sections, Exec3.VAND5.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(587,469));
		points.add(new Point(597,469));
		points.add(new Point(597,427));
		points.add(new Point(606,427));
		sections.add(points);
		line=new GuiLine(sections,Exec3.VOR1.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(588,570));
		points.add(new Point(597,570));
		points.add(new Point(597,527));
		points.add(new Point(606,527));
		sections.add(points);
		line=new GuiLine(sections,Exec3.VOR2.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(638,422));
		points.add(new Point(657,422));
		points.add(new Point(657,567));
		points.add(new Point(669,567));
		sections.add(points);
		line=new GuiLine(sections, Exec3.VAND3.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(637,522));
		points.add(new Point(647,522));
		points.add(new Point(647,577));
		points.add(new Point(670,577));
		sections.add(points);
		line=new GuiLine(sections, Exec3.VAND6.getOut(0));
		gui.addLine(line);

		//
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(698,572));
		points.add(new Point(707,572));
		sections.add(points);
		line=new GuiLine(sections,Exec3.V());
		gui.addLine(line);
		
		// 
		// Dodata linija sto nije bila iscratana:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(467,487));
		points.add(new Point(506,487));
		sections.add(points);
		line=new GuiLine(sections,Exec1.BB7());
		gui.addLine(line);





		
	}
	private Exec3(){
		
	}

	public static void init(){
		NOR1 = new OR(14);
		NAND1 = new AND();
		ZNOT0 = new NOT();
		ZNOT1 = new NOT();
		ZNOT2 = new NOT();
		ZNOT3 = new NOT();
		ZNOT4 = new NOT();
		ZNOT5 = new NOT();
		ZNOT6 = new NOT();
		ZNOT7 = new NOT();
		ZAND1 = new AND(8);
		ZAND2 = new AND();

		CAND1 = new AND();
		CNOT1 = new NOT();
		CAND2 = new AND();
		COR1 = new OR(4);
		CAND3 = new AND();
		COR2 = new OR(4);
		CAND4 = new AND();
		COR3 = new OR(4);

		VNOT1 = new NOT();
		VNOT2 = new NOT();
		VAND1 = new AND(3);
		VNOT3 = new NOT();
		VAND2 = new AND(3);
		VOR1 = new OR(2);
		VAND3 = new AND(2);

		VNOT4 = new NOT();
		VAND4 = new AND(3);
		VNOT5 = new NOT();
		VNOT6 = new NOT();
		VAND5 = new AND(3);
		VOR2 = new OR();
		VAND6 = new AND();
		VOR3 = new OR();

	}

	public static void connect() {

		NOR1.setInputPin(0, Fetch2.LD());
		NOR1.setInputPin(1, Fetch2.ADD());
		NOR1.setInputPin(2, Fetch2.SUB());
		NOR1.setInputPin(3, Fetch2.AND());
		NOR1.setInputPin(4, Fetch2.OR());
		NOR1.setInputPin(5, Fetch2.XOR());
		NOR1.setInputPin(6, Fetch2.ASR());
		NOR1.setInputPin(7, Fetch2.LSR());
		NOR1.setInputPin(8, Fetch2.ROR());
		NOR1.setInputPin(9, Fetch2.RORC());
		NOR1.setInputPin(10, Fetch2.ASL());
		NOR1.setInputPin(11, Fetch2.LSL());
		NOR1.setInputPin(12, Fetch2.ROL());
		NOR1.setInputPin(13, Fetch2.ROLC());

		NAND1.setInputPin(0, Exec1.AB7());
		NAND1.setInputPin(1, NOR1.getOut(0));

		ZNOT0.setInputPin(0, Exec1.AB0());
		ZNOT1.setInputPin(0, Exec1.AB1());
		ZNOT2.setInputPin(0, Exec1.AB2());
		ZNOT3.setInputPin(0, Exec1.AB3());
		ZNOT4.setInputPin(0, Exec1.AB4());
		ZNOT5.setInputPin(0, Exec1.AB5());
		ZNOT6.setInputPin(0, Exec1.AB6());
		ZNOT7.setInputPin(0, Exec1.AB7());

		ZAND1.setInputPin(0, ZNOT0.getOut(0));
		ZAND1.setInputPin(1, ZNOT1.getOut(0));
		ZAND1.setInputPin(2, ZNOT2.getOut(0));
		ZAND1.setInputPin(3, ZNOT3.getOut(0));
		ZAND1.setInputPin(4, ZNOT4.getOut(0));
		ZAND1.setInputPin(5, ZNOT5.getOut(0));
		ZAND1.setInputPin(6, ZNOT6.getOut(0));
		ZAND1.setInputPin(7, ZNOT7.getOut(0));

		ZAND2.setInputPin(0, NOR1.getOut(0));
		ZAND2.setInputPin(1, ZAND1.getOut(0));

		CAND1.setInputPin(0, Fetch2.ADD());
		CAND1.setInputPin(1, Exec1.C8());

		CNOT1.setInputPin(0, Exec1.C8());
		CAND2.setInputPin(0, Fetch2.SUB());
		CAND2.setInputPin(1, CNOT1.getOut(0));

		COR1.setInputPin(0, Fetch2.ASR());
		COR1.setInputPin(1, Fetch2.LSR());
		COR1.setInputPin(2, Fetch2.ROR());
		COR1.setInputPin(3, Fetch2.RORC());

		CAND3.setInputPin(0, COR1.getOut(0));
		CAND3.setInputPin(1, Exec1.AB0());

		COR2.setInputPin(0, Fetch2.ASL());
		COR2.setInputPin(1, Fetch2.LSL());
		COR2.setInputPin(2, Fetch2.ROL());
		COR2.setInputPin(3, Fetch2.ROLC());

		CAND4.setInputPin(0, COR2.getOut(0));
		CAND4.setInputPin(1, Exec1.AB7());

		COR3.setInputPin(0, CAND1.getOut(0));
		COR3.setInputPin(1, CAND2.getOut(0));
		COR3.setInputPin(2, CAND3.getOut(0));
		COR3.setInputPin(3, CAND4.getOut(0));

		VNOT1.setInputPin(0, Exec1.AB7());
		VNOT2.setInputPin(0, Exec1.BB7());
		VAND1.setInputPin(0, VNOT1.getOut(0));
		VAND1.setInputPin(1, VNOT2.getOut(0));
		VAND1.setInputPin(2, Exec1.ALU7());

		VNOT3.setInputPin(0, Exec1.ALU7());
		VAND2.setInputPin(0, Exec1.AB7());
		VAND2.setInputPin(1, Exec1.BB7());
		VAND2.setInputPin(2, VNOT3.getOut(0));

		VOR1.setInputPin(0, VAND1.getOut(0));
		VOR1.setInputPin(1, VAND2.getOut(0));

		VAND3.setInputPin(0, Fetch2.ADD());
		VAND3.setInputPin(1, VOR1.getOut(0));

		VNOT4.setInputPin(0, Exec1.AB7());
		VAND4.setInputPin(0, VNOT4.getOut(0));
		VAND4.setInputPin(1, Exec1.BB7());
		VAND4.setInputPin(2, Exec1.ALU7());

		VNOT5.setInputPin(0, Exec1.BB7());
		VNOT6.setInputPin(0, Exec1.ALU7());
		VAND5.setInputPin(0, Exec1.AB7());
		VAND5.setInputPin(1, VNOT5.getOut(0));
		VAND5.setInputPin(2, VNOT6.getOut(0));

		VOR2.setInputPin(0, VAND4.getOut(0));
		VOR2.setInputPin(1, VAND5.getOut(0));

		VAND6.setInputPin(0, Fetch2.SUB());
		VAND6.setInputPin(1, VOR2.getOut(0));

		VOR3.setInputPin(0, VAND3.getOut(0));
		VOR3.setInputPin(1, VAND6.getOut(0));

	}

	public static Pin N() {
		return NAND1.getOut(0);
	}

	public static Pin Z() {
		return ZAND2.getOut(0);
	}

	public static Pin C() {
		return COR3.getOut(0);
	}

	public static Pin V() {
		return VOR3.getOut(0);
	}

}
