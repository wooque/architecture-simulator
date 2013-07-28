package shemes;

import gui.GuiLabel;
import gui.GuiLine;
import gui.GuiScheme;

import java.awt.Point;
import java.util.ArrayList;

import components.*;

public class Exec2 {
	public static IntToBools DBBits;
	public static AND IAND1;
	public static OR IOR1;
	public static AND IAND2;
	public static OR IOR2;
	public static NOT INOT;
	public static RSFF IRSFF;

	public static AND TAND1;
	public static OR TOR1;
	public static AND TAND2;
	public static OR TOR2;
	public static NOT TNOT;
	public static RSFF TRSFF;

	public static AND NAND1;
	public static AND NAND2;
	public static OR NOR1;
	public static NOT NNOT1;
	public static AND NAND3;
	public static NOT NNOT2;
	public static AND NAND4;
	public static OR NOR2;
	public static RSFF NRSFF;

	public static AND ZAND1;
	public static AND ZAND2;
	public static OR ZOR1;
	public static NOT ZNOT1;
	public static AND ZAND3;
	public static NOT ZNOT2;
	public static AND ZAND4;
	public static OR ZOR2;
	public static RSFF ZRSFF;

	public static AND CAND1;
	public static AND CAND2;
	public static OR COR1;
	public static NOT CNOT1;
	public static AND CAND3;
	public static NOT CNOT2;
	public static AND CAND4;
	public static OR COR2;
	public static RSFF CRSFF;

	public static AND VAND1;
	public static AND VAND2;
	public static OR VOR1;
	public static NOT VNOT1;
	public static AND VAND3;
	public static NOT VNOT2;
	public static AND VAND4;
	public static OR VOR2;
	public static RSFF VRSFF;

	public static AND L0AND1;
	public static AND L0AND2;
	public static OR L0OR1;
	public static NOT L0NOT1;
	public static AND L0AND3;
	public static NOT L0NOT2;
	public static AND L0AND4;
	public static OR L0OR2;
	public static RSFF L0RSFF;

	public static AND L1AND1;
	public static AND L1AND2;
	public static OR L1OR1;
	public static NOT L1NOT1;
	public static AND L1AND3;
	public static NOT L1NOT2;
	public static AND L1AND4;
	public static OR L1OR2;
	public static RSFF L1RSFF;

	public static BoolsToInt PSW;
	public static TSB TSBPSWout;

	public static RSFF STARTRSFF;

	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui() {
		
		GuiLine line;									// Pomocna promenljiva
		gui=new GuiScheme("./src/images/exec2.png");		
		
		ArrayList<ArrayList<Point>> sections;
		ArrayList<Point> points;
		
		
		// ldPSWH
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(197,17));
		points.add(new Point(197,172));
		points.add(new Point(204,172));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(198,46));
		points.add(new Point(202,46));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(198,82));
		points.add(new Point(202,82));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(198,136));
		points.add(new Point(204,136));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldPSWH());
		gui.addLine(line);

	
		// DB7
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(184,92));
		points.add(new Point(199,92));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(190,91));
		points.add(new Point(190,56));
		points.add(new Point(202,56));
		sections.add(points);
		line=new GuiLine(sections,Exec2.DBBits.getOut(7));
		gui.addLine(line);
		

		// DB6
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(185,182));
		points.add(new Point(201,182));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(192,181));
		points.add(new Point(192,146));
		points.add(new Point(204,146));
		sections.add(points);
		line=new GuiLine(sections,Exec2.DBBits.getOut(6));
		gui.addLine(line);
		
		
		// Izlaz prvog I kola
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(224,51));
		points.add(new Point(269,51));
		sections.add(points);
		line=new GuiLine(sections,Exec2.IAND1.getOut(0));
		gui.addLine(line);

		// Izlaz drugog I kola
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(224,87));
		points.add(new Point(270,87));
		sections.add(points);
		line=new GuiLine(sections,Exec2.IAND2.getOut(0));
		gui.addLine(line);

		// Izlaz treceg I kola
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(226,141));
		points.add(new Point(271,141));
		sections.add(points);
		line=new GuiLine(sections,Exec2.TAND1.getOut(0));
		gui.addLine(line);

		// Izlaz 4. I kola
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(225,177));
		points.add(new Point(270,177));
		sections.add(points);
		line=new GuiLine(sections,Exec2.TAND2.getOut(0) );
		gui.addLine(line);

		// stPSWI
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(264,41));
		points.add(new Point(270,41));
		sections.add(points);
		line=new GuiLine(sections,Oper2.stPSWI());
		gui.addLine(line);

		// clPSWI
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(264,97));
		points.add(new Point(270,97));
		sections.add(points);
		line=new GuiLine(sections, Oper2.clPSWI());
		gui.addLine(line);

		// stPSWT
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(266,131));
		points.add(new Point(271,131));
		sections.add(points);
		line=new GuiLine(sections,Oper2.stPSWT());
		gui.addLine(line);

		// clPSWT
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(266,186));
		points.add(new Point(272,186));
		sections.add(points);
		line=new GuiLine(sections,Oper2.clPSWT());
		gui.addLine(line);

		// 1. ILI kolo
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(289,46));
		points.add(new Point(294,46));
		sections.add(points);
		line=new GuiLine(sections,Exec2.IOR1.getOut(0));
		gui.addLine(line);

		// 2. ILI kolo
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(289,92));
		points.add(new Point(294,92));
		sections.add(points);
		line=new GuiLine(sections,Exec2.IOR2.getOut(0));
		gui.addLine(line);

		// 3. ILI kolo
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(291,136));
		points.add(new Point(295,136));
		sections.add(points);
		line=new GuiLine(sections,Exec2.TOR1.getOut(0));
		gui.addLine(line);

		// 4. ILI kolo
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(290,182));
		points.add(new Point(295,182));
		sections.add(points);
		line=new GuiLine(sections,Exec2.TOR2.getOut(0));
		gui.addLine(line);
		
		// PSWI
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(344,46));
		points.add(new Point(350,46));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(195,242));
		points.add(new Point(202,242));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWI());
		gui.addLine(line);
		
		// 
		// not PSWI:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(344,92));
		points.add(new Point(350,92));
		sections.add(points);
		line=new GuiLine(sections,IRSFF.getOut(1));
		gui.addLine(line);

		// PSWT
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(346,136));
		points.add(new Point(353,136));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(195,255));
		points.add(new Point(202,255));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWT());
		gui.addLine(line);
		
		// 
		// not PSWT:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(346,182));
		points.add(new Point(352,182));
		sections.add(points);
		line=new GuiLine(sections,TRSFF.getOut(1));
		gui.addLine(line);

		// PSWL1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,379));
		points.add(new Point(202,379));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(610,532));
		points.add(new Point(616,532));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWL1());
		gui.addLine(line);
		
		// 
		// NOT PSWL1:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(610,578));
		points.add(new Point(616,578));
		sections.add(points);
		line=new GuiLine(sections,L1RSFF.getOut(1));
		gui.addLine(line);

		// PSWL0
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,392));
		points.add(new Point(202,392));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(610,434));
		points.add(new Point(616,434));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWL0());
		gui.addLine(line);
		
		// 
		// NOT PSWL0:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(610,480));
		points.add(new Point(616,480));
		sections.add(points);
		line=new GuiLine(sections,L0RSFF.getOut(1));
		gui.addLine(line);

		// PSWV
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,405));
		points.add(new Point(203,405));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(610,340));
		points.add(new Point(616,340));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWV());
		gui.addLine(line);

		// 
		// NOT PSWV:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(610,386));
		points.add(new Point(616,386));
		sections.add(points);
		line=new GuiLine(sections,VRSFF.getOut(1));
		gui.addLine(line);

		// PSWC
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,418));
		points.add(new Point(204,418));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(616,242));
		points.add(new Point(610,242));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWC());
		gui.addLine(line);

		// 
		// NOT PSWC:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(610,288));
		points.add(new Point(616,288));
		sections.add(points);
		line=new GuiLine(sections,CRSFF.getOut(1));
		gui.addLine(line);

		// PSWZ
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,431));
		points.add(new Point(202,431));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(610,144));
		points.add(new Point(617,144));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWZ());
		gui.addLine(line);
		
		// 
		// NOT PSWZ:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(610,190));
		points.add(new Point(616,190));
		sections.add(points);
		line=new GuiLine(sections,ZRSFF.getOut(1));
		gui.addLine(line);

		// PSWN
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,444));
		points.add(new Point(203,444));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(610,46));
		points.add(new Point(616,46));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWN());
		gui.addLine(line);
		
		// 
		// NOT PSWN:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(610,92));
		points.add(new Point(616,92));
		sections.add(points);
		line=new GuiLine(sections,NRSFF.getOut(1));
		gui.addLine(line);

		// PSWout izlaz
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(313,336));
		points.add(new Point(338,336));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(339,358));
		points.add(new Point(339,312));
		sections.add(points);
		line=new GuiLine(sections,Exec2.PSWout());
		gui.addLine(line);
		
		//  PSWout
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(306,339));
		points.add(new Point(306,346));
		sections.add(points);
		line=new GuiLine(sections,Oper2.PSWout());
		gui.addLine(line);

		// ldPSWL
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(463,16));
		points.add(new Point(463,568));
		points.add(new Point(468,568));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(463,532));
		points.add(new Point(468,532));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(464,470));
		points.add(new Point(468,470));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(464,434));
		points.add(new Point(468,434));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(464,376));
		points.add(new Point(468,376));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(464,340));
		points.add(new Point(468,340));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(464,278));
		points.add(new Point(468,278));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(464,180));
		points.add(new Point(468,180));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(464,144));
		points.add(new Point(468,144));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(464,82));
		points.add(new Point(468,82));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(464,46));
		points.add(new Point(468,46));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(464,242));
		points.add(new Point(468,242));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldPSWL());
		gui.addLine(line);
		
		//////////////////////////
		
		// ldN
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(448,33));
		points.add(new Point(502,33));
		points.add(new Point(502,95));
		points.add(new Point(507,95));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(503,33));
		points.add(new Point(507,33));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldN());
		gui.addLine(line);

		
		// N
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(449,69));
		points.add(new Point(495,69));
		points.add(new Point(495,43));
		points.add(new Point(507,43));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(495,70));
		points.add(new Point(495,105));
		points.add(new Point(503,105));
		sections.add(points);
		line=new GuiLine(sections,Exec3.N());
		gui.addLine(line);

		// DB0
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(449,92));
		points.add(new Point(465,92));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(456,91));
		points.add(new Point(456,56));
		points.add(new Point(468,56));
		sections.add(points);
		line=new GuiLine(sections,Exec2.DBBits.getOut(0));
		gui.addLine(line);

		// N-AND1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(490,51));
		points.add(new Point(535,51));
		sections.add(points);
		line=new GuiLine(sections,Exec2.NAND1.getOut(0));
		gui.addLine(line);
		
		// N-AND2
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(529,38));
		points.add(new Point(531,38));
		points.add(new Point(531,42));
		points.add(new Point(536,42));
		sections.add(points);
		line=new GuiLine(sections,Exec2.NAND2.getOut(0));
		gui.addLine(line);

		// N-AND3
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(490,87));
		points.add(new Point(535,87));
		sections.add(points);
		line=new GuiLine(sections,Exec2.NAND3.getOut(0));
		gui.addLine(line);

		// N-AND4
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(529,100));
		points.add(new Point(531,100));
		points.add(new Point(531,97));
		points.add(new Point(535,97));
		sections.add(points);
		line=new GuiLine(sections,Exec2.NAND4.getOut(0));
		gui.addLine(line);

		// N-OR1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(554,46));
		points.add(new Point(559,46));
		sections.add(points);
		line=new GuiLine(sections,Exec2.NOR1.getOut(0));
		gui.addLine(line);

		// N-OR2
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(555,92));
		points.add(new Point(559,92));
		sections.add(points);
		line=new GuiLine(sections,Exec2.NOR2.getOut(0));
		gui.addLine(line);
		
//////////////////////////
		
		// ldZ
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(448,131));
		points.add(new Point(502,131));
		points.add(new Point(502,193));
		points.add(new Point(507,193));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(503,131));
		points.add(new Point(507,131));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldZ());
		gui.addLine(line);

		
		// Z
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(449,167));
		points.add(new Point(495,167));
		points.add(new Point(495,141));
		points.add(new Point(507,141));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(495,168));
		points.add(new Point(495,203));
		points.add(new Point(503,203));
		sections.add(points);
		line=new GuiLine(sections,Exec3.Z());
		gui.addLine(line);

		// DB1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(449,190));
		points.add(new Point(465,190));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(456,189));
		points.add(new Point(456,154));
		points.add(new Point(468,154));
		sections.add(points);
		line=new GuiLine(sections,Exec2.DBBits.getOut(1));
		gui.addLine(line);

		// Z-AND1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(490,149));
		points.add(new Point(535,149));
		sections.add(points);
		line=new GuiLine(sections,Exec2.ZAND1.getOut(0));
		gui.addLine(line);
		
		// z-AND2
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(529,136));
		points.add(new Point(531,136));
		points.add(new Point(531,139));
		points.add(new Point(536,139));
		sections.add(points);
		line=new GuiLine(sections,Exec2.ZAND2.getOut(0));
		gui.addLine(line);

		// Z-AND3
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(490,185));
		points.add(new Point(535,185));
		sections.add(points);
		line=new GuiLine(sections,Exec2.ZAND3.getOut(0));
		gui.addLine(line);

		// Z-AND4
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(529,198));
		points.add(new Point(531,198));
		points.add(new Point(531,195));
		points.add(new Point(535,195));
		sections.add(points);
		line=new GuiLine(sections,Exec2.ZAND4.getOut(0));
		gui.addLine(line);

		// Z-OR1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(554,144));
		points.add(new Point(559,144));
		sections.add(points);
		line=new GuiLine(sections,Exec2.ZOR1.getOut(0));
		gui.addLine(line);

		// Z-OR2
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(555,190));
		points.add(new Point(559,190));
		sections.add(points);
		line=new GuiLine(sections,Exec2.ZOR2.getOut(0));
		gui.addLine(line);
		

		
//////////////////////////
		
		// ldC
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(448,131+98));
		points.add(new Point(502,131+98));
		points.add(new Point(502,193+98));
		points.add(new Point(507,193+98));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(503,131+98));
		points.add(new Point(507,131+98));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldC());
		gui.addLine(line);

		
		// C
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(449,167+98));
		points.add(new Point(495,167+98));
		points.add(new Point(495,141+98));
		points.add(new Point(507,141+98));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(495,168+98));
		points.add(new Point(495,203+98));
		points.add(new Point(503,203+98));
		sections.add(points);
		line=new GuiLine(sections,Exec3.C());
		gui.addLine(line);

		// DB2
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(449,190+98));
		points.add(new Point(465,190+98));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(456,189+98));
		points.add(new Point(456,154+98));
		points.add(new Point(468,154+98));
		sections.add(points);
		line=new GuiLine(sections,Exec2.DBBits.getOut(2));
		gui.addLine(line);

		// C-AND1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(490,149+98));
		points.add(new Point(535,149+98));
		sections.add(points);
		line=new GuiLine(sections,Exec2.CAND1.getOut(0));
		gui.addLine(line);
		
		// C-AND2
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(529,136+98));
		points.add(new Point(531,136+98));
		points.add(new Point(531,139+98));
		points.add(new Point(536,139+98));
		sections.add(points);
		line=new GuiLine(sections,Exec2.CAND2.getOut(0));
		gui.addLine(line);

		// C-AND3
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(490,185+98));
		points.add(new Point(535,185+98));
		sections.add(points);
		line=new GuiLine(sections,Exec2.CAND3.getOut(0));
		gui.addLine(line);

		// C-AND4
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(529,198+98));
		points.add(new Point(531,198+98));
		points.add(new Point(531,195+98));
		points.add(new Point(535,195+98));
		sections.add(points);
		line=new GuiLine(sections,Exec2.CAND4.getOut(0));
		gui.addLine(line);

		// C-OR1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(554,144+98));
		points.add(new Point(559,144+98));
		sections.add(points);
		line=new GuiLine(sections,Exec2.COR1.getOut(0));
		gui.addLine(line);

		// C-OR2
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(555,190+98));
		points.add(new Point(559,190+98));
		sections.add(points);
		line=new GuiLine(sections,Exec2.COR2.getOut(0));
		gui.addLine(line);
	
//////////////////////////
		
		// ldV 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(448,131+196));
		points.add(new Point(502,131+196));
		points.add(new Point(502,193+196));
		points.add(new Point(507,193+196));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(503,131+196));
		points.add(new Point(507,131+196));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldV());
		gui.addLine(line);

		
		// V
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(449,167+196));
		points.add(new Point(495,167+196));
		points.add(new Point(495,141+196));
		points.add(new Point(507,141+196));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(495,168+196));
		points.add(new Point(495,203+196));
		points.add(new Point(503,203+196));
		sections.add(points);
		line=new GuiLine(sections,Exec3.V());
		gui.addLine(line);

		// DB3
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(449,190+196));
		points.add(new Point(465,190+196));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(456,189+196));
		points.add(new Point(456,154+196));
		points.add(new Point(468,154+196));
		sections.add(points);
		line=new GuiLine(sections,Exec2.DBBits.getOut(3));
		gui.addLine(line);

		// V-AND1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(490,149+196));
		points.add(new Point(535,149+196));
		sections.add(points);
		line=new GuiLine(sections,Exec2.VAND1.getOut(0));
		gui.addLine(line);
		
		// V-AND2
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(529,136+196));
		points.add(new Point(531,136+196));
		points.add(new Point(531,139+196));
		points.add(new Point(536,139+196));
		sections.add(points);
		line=new GuiLine(sections,Exec2.VAND2.getOut(0));
		gui.addLine(line);

		// V-AND3
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(490,185+196));
		points.add(new Point(535,185+196));
		sections.add(points);
		line=new GuiLine(sections,Exec2.VAND3.getOut(0));
		gui.addLine(line);

		// V-AND4
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(529,198+196));
		points.add(new Point(531,198+196));
		points.add(new Point(531,194+196));
		points.add(new Point(535,194+196));
		sections.add(points);
		line=new GuiLine(sections,Exec2.VAND4.getOut(0));
		gui.addLine(line);

		// V-OR1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(554,144+196));
		points.add(new Point(559,144+196));
		sections.add(points);
		line=new GuiLine(sections,Exec2.VOR1.getOut(0));
		gui.addLine(line);

		// V-OR2
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(555,190+196));
		points.add(new Point(559,190+196));
		sections.add(points);
		line=new GuiLine(sections,Exec2.VOR2.getOut(0));
		gui.addLine(line);
		
//////////////////////////
		
		// ldL
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(448,131+290));
		points.add(new Point(502,131+290));
		points.add(new Point(502,193+290));
		points.add(new Point(507,193+290));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(503,131+290));
		points.add(new Point(507,131+290));
		sections.add(points);
		line=new GuiLine(sections,Oper2.ldL());
		gui.addLine(line);

		
		// 
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(449,167+290));
		points.add(new Point(495,167+290));
		points.add(new Point(495,141+290));
		points.add(new Point(507,141+290));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(495,168+290));
		points.add(new Point(495,203+290));
		points.add(new Point(503,203+290));
		sections.add(points);
		line=new GuiLine(sections,Intr2.prl0());
		gui.addLine(line);

		// DB4
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(449,190+290));
		points.add(new Point(465,190+290));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(456,189+290));
		points.add(new Point(456,154+290));
		points.add(new Point(468,154+290));
		sections.add(points);
		line=new GuiLine(sections,Exec2.DBBits.getOut(4));
		gui.addLine(line);

		// L0-AND1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(490,149+290));
		points.add(new Point(535,149+290));
		sections.add(points);
		line=new GuiLine(sections,Exec2.L0AND1.getOut(0));
		gui.addLine(line);
		
		// L0-AND2
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(529,136+290));
		points.add(new Point(531,136+290));
		points.add(new Point(531,139+290));
		points.add(new Point(536,139+290));
		sections.add(points);
		line=new GuiLine(sections,Exec2.L0AND2.getOut(0));
		gui.addLine(line);

		// L0-AND3
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(490,185+290));
		points.add(new Point(535,185+290));
		sections.add(points);
		line=new GuiLine(sections,Exec2.L0AND3.getOut(0));
		gui.addLine(line);

		// L0-AND4
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(529,198+290));
		points.add(new Point(531,198+290));
		points.add(new Point(531,195+290));
		points.add(new Point(535,195+290));
		sections.add(points);
		line=new GuiLine(sections,Exec2.L0AND4.getOut(0));
		gui.addLine(line);

		// L0-OR1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(554,144+290));
		points.add(new Point(559,144+290));
		sections.add(points);
		line=new GuiLine(sections,Exec2.L0OR1.getOut(0));
		gui.addLine(line);

		// L0-OR2
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(555,190+290));
		points.add(new Point(559,190+290));
		sections.add(points);
		line=new GuiLine(sections,Exec2.L0OR2.getOut(0));
		gui.addLine(line);

//////////////////////////
	
	// ldL 
	// 
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(448,131+388));
	points.add(new Point(502,131+388));
	points.add(new Point(502,193+388));
	points.add(new Point(507,193+388));
	sections.add(points);
	points=new ArrayList<Point>();
	points.add(new Point(503,131+388));
	points.add(new Point(507,131+388));
	sections.add(points);
	line=new GuiLine(sections,Oper2.ldL());
	gui.addLine(line);

	
	// 
	// 
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(449,167+388));
	points.add(new Point(495,167+388));
	points.add(new Point(495,141+388));
	points.add(new Point(507,141+388));
	sections.add(points);
	points=new ArrayList<Point>();
	points.add(new Point(495,168+388));
	points.add(new Point(495,203+388));
	points.add(new Point(503,203+388));
	sections.add(points);
	line=new GuiLine(sections,Intr2.prl1());
	gui.addLine(line);

	// DB5
	//
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(449,190+388));
	points.add(new Point(465,190+388));
	sections.add(points);
	points=new ArrayList<Point>();
	points.add(new Point(456,189+388));
	points.add(new Point(456,154+388));
	points.add(new Point(468,154+388));
	sections.add(points);
	line=new GuiLine(sections,Exec2.DBBits.getOut(5));
	gui.addLine(line);

	// L1-AND1
	//
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(490,149+388));
	points.add(new Point(535,149+388));
	sections.add(points);
	line=new GuiLine(sections,Exec2.L1AND1.getOut(0));
	gui.addLine(line);
	
	// L1-AND2
	//
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(529,136+388));
	points.add(new Point(531,136+388));
	points.add(new Point(531,139+388));
	points.add(new Point(536,139+388));
	sections.add(points);
	line=new GuiLine(sections,Exec2.L1AND2.getOut(0));
	gui.addLine(line);

	// L1-AND3
	//
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(490,185+388));
	points.add(new Point(535,185+388));
	sections.add(points);
	line=new GuiLine(sections,Exec2.L1AND3.getOut(0));
	gui.addLine(line);

	// L1-AND4
	//
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(529,198+388));
	points.add(new Point(531,198+388));
	points.add(new Point(531,195+388));
	points.add(new Point(535,195+388));
	sections.add(points);
	line=new GuiLine(sections,Exec2.L1AND4.getOut(0));
	gui.addLine(line);

	// L1-OR1
	//
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(554,144+388));
	points.add(new Point(559,144+388));
	sections.add(points);
	line=new GuiLine(sections,Exec2.L1OR1.getOut(0));
	gui.addLine(line);

	// L1-OR2
	//
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(555,190+388));
	points.add(new Point(559,190+388));
	sections.add(points);
	line=new GuiLine(sections,Exec2.L1OR2.getOut(0));
	gui.addLine(line);
	
	
	// TSTART:
	// 
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(218,509));
	points.add(new Point(223,509));
	sections.add(points);
	line=new GuiLine(sections,new Pin(true));
	gui.addLine(line);

	//
	//TSTOP:
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(217,555));
	points.add(new Point(223,555));
	sections.add(points);
	line=new GuiLine(sections,new Pin(false));
	gui.addLine(line);
	

	// START
	//
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(274,509));
	points.add(new Point(280,509));
	sections.add(points);
	line=new GuiLine(sections,Exec2.START());
	gui.addLine(line);
	
	// 
	//NOT START: 
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(274,555));
	points.add(new Point(280,555));
	sections.add(points);
	line=new GuiLine(sections,STARTRSFF.getOut(1));
	gui.addLine(line);

	//dodate linije za nule da prikazuju da su uvek plave linije:
	// odozgo:
	// 1 nula:
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(195,268));
	points.add(new Point(202,268));
	sections.add(points);
	line=new GuiLine(sections,new Pin(false));
	gui.addLine(line);

	// 
	// 2 nula:
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(195,281));
	points.add(new Point(202,281));
	sections.add(points);
	line=new GuiLine(sections,new Pin(false));
	gui.addLine(line);

	// 
	// 3 nula:
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(195,294));
	points.add(new Point(202,294));
	sections.add(points);
	line=new GuiLine(sections,new Pin(false));
	gui.addLine(line);

	// 
	// 4 nula:
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(195,307));
	points.add(new Point(202,307));
	sections.add(points);
	line=new GuiLine(sections,new Pin(false));
	gui.addLine(line);

	// 
	// 5 nula:
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(195,320));
	points.add(new Point(202,320));
	sections.add(points);
	line=new GuiLine(sections,new Pin(false));
	gui.addLine(line);

	// 
	// 6 nula:
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(195,333));
	points.add(new Point(202,333));
	sections.add(points);
	line=new GuiLine(sections,new Pin(false));
	gui.addLine(line);

	// 
	// 7 nula:
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(195,353));
	points.add(new Point(202,353));
	sections.add(points);
	line=new GuiLine(sections,new Pin(false));
	gui.addLine(line);

	// 
	// 8 nula:
	sections=new ArrayList<ArrayList<Point>>();
	points=new ArrayList<Point>();
	points.add(new Point(195,366));
	points.add(new Point(202,366));
	sections.add(points);
	line=new GuiLine(sections,new Pin(false));
	gui.addLine(line);

	
	//LABELE:
	gui.addLabel(new GuiLabel(279,326,PSW.getOut(0)));
	gui.addLabel(new GuiLabel(342,358,Bus1.S2B()));

	}
	
	private Exec2() {

	}

	public static void init() {
		DBBits = new IntToBools(16, 16);
		IAND1 = new AND();
		IOR1 = new OR();
		INOT = new NOT();
		IAND2 = new AND();
		IOR2 = new OR();
		IRSFF = new RSFF("I");

		TAND1 = new AND();
		TOR1 = new OR();
		TNOT = new NOT();
		TAND2 = new AND();
		TOR2 = new OR();
		TRSFF = new RSFF("T");

		NAND1 = new AND();
		NAND2 = new AND();
		NOR1 = new OR();
		NNOT1 = new NOT();
		NAND3 = new AND();
		NNOT2 = new NOT();
		NAND4 = new AND();
		NOR2 = new OR();
		NRSFF = new RSFF("N");

		ZAND1 = new AND();
		ZAND2 = new AND();
		ZOR1 = new OR();
		ZNOT1 = new NOT();
		ZAND3 = new AND();
		ZNOT2 = new NOT();
		ZAND4 = new AND();
		ZOR2 = new OR();
		ZRSFF = new RSFF("Z");

		CAND1 = new AND();
		CAND2 = new AND();
		COR1 = new OR();
		CNOT1 = new NOT();
		CAND3 = new AND();
		CNOT2 = new NOT();
		CAND4 = new AND();
		COR2 = new OR();
		CRSFF = new RSFF("C");

		VAND1 = new AND();
		VAND2 = new AND();
		VOR1 = new OR();
		VNOT1 = new NOT();
		VAND3 = new AND();
		VNOT2 = new NOT();
		VAND4 = new AND();
		VOR2 = new OR();
		VRSFF = new RSFF("V");

		L0AND1 = new AND();
		L0AND2 = new AND();
		L0OR1 = new OR();
		L0NOT1 = new NOT();
		L0AND3 = new AND();
		L0NOT2 = new NOT();
		L0AND4 = new AND();
		L0OR2 = new OR();
		L0RSFF = new RSFF("L0");

		L1AND1 = new AND();
		L1AND2 = new AND();
		L1OR1 = new OR();
		L1NOT1 = new NOT();
		L1AND3 = new AND();
		L1NOT2 = new NOT();
		L1AND4 = new AND();
		L1OR2 = new OR();
		L1RSFF = new RSFF("L1");

		PSW = new BoolsToInt(16, 16);
		TSBPSWout = new TSB();
		TSBPSWout.getOut(0).setNumOfLines(16);

		STARTRSFF = new RSFF("START");
	}

	public static void connect() {
		DBBits.setInputPin(0, Bus1.DB());

		IAND1.setInputPin(0, Oper2.ldPSWH());
		IAND1.setInputPin(1, DBBits.getOut(7));
		IOR1.setInputPin(0, Oper2.stPSWI());
		IOR1.setInputPin(1, IAND1.getOut(0));
		INOT.setInputPin(0, DBBits.getOut(7));
		IAND2.setInputPin(0, Oper2.ldPSWH());
		IAND2.setInputPin(1, INOT.getOut(0));
		IOR2.setInputPin(0, IAND2.getOut(0));
		IOR2.setInputPin(1, Oper2.clPSWI());
		IRSFF.setPinE(new Pin(true));
		IRSFF.setPinClear(new Pin(false));
		IRSFF.setPinS(IOR1.getOut(0));
		IRSFF.setPinR(IOR2.getOut(0));

		TAND1.setInputPin(0, Oper2.ldPSWH());
		TAND1.setInputPin(1, DBBits.getOut(6));
		TOR1.setInputPin(0, Oper2.stPSWT());
		TOR1.setInputPin(1, TAND1.getOut(0));
		TNOT.setInputPin(0, DBBits.getOut(6));
		TAND2.setInputPin(0, Oper2.ldPSWH());
		TAND2.setInputPin(1, TNOT.getOut(0));
		TOR2.setInputPin(0, TAND2.getOut(0));
		TOR2.setInputPin(1, Oper2.clPSWT());
		TRSFF.setPinE(new Pin(true));
		TRSFF.setPinClear(new Pin(false));
		TRSFF.setPinS(TOR1.getOut(0));
		TRSFF.setPinR(TOR2.getOut(0));

		NAND1.setInputPin(0, Oper2.ldPSWL());
		NAND1.setInputPin(1, DBBits.getOut(0));
		NAND2.setInputPin(0, Oper2.ldN());
		NAND2.setInputPin(1, Exec3.N());
		NOR1.setInputPin(0, NAND2.getOut(0));
		NOR1.setInputPin(1, NAND1.getOut(0));
		NNOT1.setInputPin(0, DBBits.getOut(0));
		NAND3.setInputPin(0, Oper2.ldPSWL());
		NAND3.setInputPin(1, NNOT1.getOut(0));
		NNOT2.setInputPin(0, Exec3.N());
		NAND4.setInputPin(0, Oper2.ldN());
		NAND4.setInputPin(1, NNOT2.getOut(0));
		NOR2.setInputPin(0, NAND3.getOut(0));
		NOR2.setInputPin(1, NAND4.getOut(0));
		NRSFF.setPinE(new Pin(true));
		NRSFF.setPinClear(new Pin(false));
		NRSFF.setPinS(NOR1.getOut(0));
		NRSFF.setPinR(NOR2.getOut(0));

		ZAND1.setInputPin(0, Oper2.ldPSWL());
		ZAND1.setInputPin(1, DBBits.getOut(1));
		ZAND2.setInputPin(0, Oper2.ldZ());
		ZAND2.setInputPin(1, Exec3.Z());
		ZOR1.setInputPin(0, ZAND2.getOut(0));
		ZOR1.setInputPin(1, ZAND1.getOut(0));
		ZNOT1.setInputPin(0, DBBits.getOut(1));
		ZAND3.setInputPin(0, Oper2.ldPSWL());
		ZAND3.setInputPin(1, ZNOT1.getOut(0));
		ZNOT2.setInputPin(0, Exec3.Z());
		ZAND4.setInputPin(0, Oper2.ldZ());
		ZAND4.setInputPin(1, ZNOT2.getOut(0));
		ZOR2.setInputPin(0, ZAND3.getOut(0));
		ZOR2.setInputPin(1, ZAND4.getOut(0));
		ZRSFF.setPinE(new Pin(true));
		ZRSFF.setPinClear(new Pin(false));
		ZRSFF.setPinS(ZOR1.getOut(0));
		ZRSFF.setPinR(ZOR2.getOut(0));

		CAND1.setInputPin(0, Oper2.ldPSWL());
		CAND1.setInputPin(1, DBBits.getOut(2));
		CAND2.setInputPin(0, Oper2.ldC());
		CAND2.setInputPin(1, Exec3.C());
		COR1.setInputPin(0, CAND2.getOut(0));
		COR1.setInputPin(1, CAND1.getOut(0));
		CNOT1.setInputPin(0, DBBits.getOut(2));
		CAND3.setInputPin(0, Oper2.ldPSWL());
		CAND3.setInputPin(1, CNOT1.getOut(0));
		CNOT2.setInputPin(0, Exec3.C());
		CAND4.setInputPin(0, Oper2.ldC());
		CAND4.setInputPin(1, CNOT2.getOut(0));
		COR2.setInputPin(0, CAND3.getOut(0));
		COR2.setInputPin(1, CAND4.getOut(0));
		CRSFF.setPinE(new Pin(true));
		CRSFF.setPinClear(new Pin(false));
		CRSFF.setPinS(COR1.getOut(0));
		CRSFF.setPinR(COR2.getOut(0));

		VAND1.setInputPin(0, Oper2.ldPSWL());
		VAND1.setInputPin(1, DBBits.getOut(3));
		VAND2.setInputPin(0, Oper2.ldV());
		VAND2.setInputPin(1, Exec3.V());
		VOR1.setInputPin(0, VAND2.getOut(0));
		VOR1.setInputPin(1, VAND1.getOut(0));
		VNOT1.setInputPin(0, DBBits.getOut(3));
		VAND3.setInputPin(0, Oper2.ldPSWL());
		VAND3.setInputPin(1, VNOT1.getOut(0));
		VNOT2.setInputPin(0, Exec3.V());
		VAND4.setInputPin(0, Oper2.ldV());
		VAND4.setInputPin(1, VNOT2.getOut(0));
		VOR2.setInputPin(0, VAND3.getOut(0));
		VOR2.setInputPin(1, VAND4.getOut(0));
		VRSFF.setPinE(new Pin(true));
		VRSFF.setPinClear(new Pin(false));
		VRSFF.setPinS(VOR1.getOut(0));
		VRSFF.setPinR(VOR2.getOut(0));

		L0AND1.setInputPin(0, Oper2.ldPSWL());
		L0AND1.setInputPin(1, DBBits.getOut(4));
		L0AND2.setInputPin(0, Oper2.ldL());
		L0AND2.setInputPin(1, Intr2.prl0());
		L0OR1.setInputPin(0, L0AND2.getOut(0));
		L0OR1.setInputPin(1, L0AND1.getOut(0));
		L0NOT1.setInputPin(0, DBBits.getOut(4));
		L0AND3.setInputPin(0, Oper2.ldPSWL());
		L0AND3.setInputPin(1, L0NOT1.getOut(0));
		L0NOT2.setInputPin(0, Intr2.prl0());
		L0AND4.setInputPin(0, Oper2.ldL());
		L0AND4.setInputPin(1, L0NOT2.getOut(0));
		L0OR2.setInputPin(0, L0AND3.getOut(0));
		L0OR2.setInputPin(1, L0AND4.getOut(0));
		L0RSFF.setPinE(new Pin(true));
		L0RSFF.setPinClear(new Pin(false));
		L0RSFF.setPinS(L0OR1.getOut(0));
		L0RSFF.setPinR(L0OR2.getOut(0));

		L1AND1.setInputPin(0, Oper2.ldPSWL());
		L1AND1.setInputPin(1, DBBits.getOut(5));
		L1AND2.setInputPin(0, Oper2.ldL());
		L1AND2.setInputPin(1, Intr2.prl1());
		L1OR1.setInputPin(0, L1AND2.getOut(0));
		L1OR1.setInputPin(1, L1AND1.getOut(0));
		L1NOT1.setInputPin(0, DBBits.getOut(5));
		L1AND3.setInputPin(0, Oper2.ldPSWL());
		L1AND3.setInputPin(1, L1NOT1.getOut(0));
		L1NOT2.setInputPin(0, Intr2.prl1());
		L1AND4.setInputPin(0, Oper2.ldL());
		L1AND4.setInputPin(1, L1NOT2.getOut(0));
		L1OR2.setInputPin(0, L1AND3.getOut(0));
		L1OR2.setInputPin(1, L1AND4.getOut(0));
		L1RSFF.setPinE(new Pin(true));
		L1RSFF.setPinClear(new Pin(false));
		L1RSFF.setPinS(L1OR1.getOut(0));
		L1RSFF.setPinR(L1OR2.getOut(0));

		PSW.setInputPin(0, NRSFF.getOut(0));
		PSW.setInputPin(1, ZRSFF.getOut(0));
		PSW.setInputPin(2, CRSFF.getOut(0));
		PSW.setInputPin(3, VRSFF.getOut(0));
		PSW.setInputPin(4, L0RSFF.getOut(0));
		PSW.setInputPin(5, L1RSFF.getOut(0));
		for (int i = 6; i < 14; i++) {
			PSW.setInputPin(i, new Pin(false));
		}
		PSW.setInputPin(14, TRSFF.getOut(0));
		PSW.setInputPin(15, IRSFF.getOut(0));

		TSBPSWout.setInputPin(0, PSW.getOut(0));
		TSBPSWout.setCtrl(Oper2.PSWout());
		Bus1.addOnS2B(TSBPSWout.getOut(0));

		STARTRSFF.setInputPin(0, new Pin(false));
		STARTRSFF.setInputPin(1, Oper2.clSTART()); // izmenjeno
		//STARTRSFF.getOut(0).setBoolVal(true); 	//na pocetku setovan izlaz START na true
												//nema vise potrebe za STSTART i posebnim setovanjem izlaza RSFF
		STARTRSFF.setInit(true);

	}

	public static Pin PSWI() {
		return IRSFF.getOut(0);
	}

	public static Pin PSWT() {
		return TRSFF.getOut(0);
	}

	public static Pin PSWN() {
		return NRSFF.getOut(0);
	}

	public static Pin PSWZ() {
		return ZRSFF.getOut(0);
	}

	public static Pin PSWC() {
		return CRSFF.getOut(0);
	}

	public static Pin PSWV() {
		return VRSFF.getOut(0);
	}

	public static Pin PSWL0() {
		return L0RSFF.getOut(0);
	}

	public static Pin PSWL1() {
		return L1RSFF.getOut(0);
	}

	public static Pin START() {
		return STARTRSFF.getOut(0);
	}

	public static Pin PSW() {
		return PSW.getOut(0);
	}
	public static Pin PSWout() {
		return TSBPSWout.getOut(0);
	}

}
