package shemes;

import java.awt.Point;
import java.util.ArrayList;

import gui.*;
import components.*;

public class Bus2{
	
	static RSFF RDF, ERDA, WRF, EWRAD;
	static JKFF RDB, JK1, ERDC, WRB, JK2, EWRC;
	static AND RDBJ, WRBJ;
	static OR brqstart, EA;
	static TSB EWRCout,ERDCout;
	static Pin EWRCoutin,ERDCoutin;
	static NOT EWRCoutout,ERDCoutout;
	static BUS NotRDBUS,NotWRBUS;
	static private int nrdi=0,nwri=0;
	public static GuiScheme gui;
	
	public static GuiScheme getGui() {
		return gui;
	}
	public static void gui(){
		
		GuiLine line;
		gui=new GuiScheme("./src/images/bus2.png");
		
		ArrayList<ArrayList<Point>> sections;
		ArrayList<Point> points;
		
		
		
		// readm signal u JK flip flop
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(130,64));
		points.add(new Point(148,64));
		sections.add(points);
		line=new GuiLine(sections,Oper1.readm());
		gui.addLine(line);


		// RDF signal u gornje I kolo
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(211, 64));
		points.add(new Point(263, 64));
		sections.add(points);
		line = new GuiLine(sections, Bus2.RDF());
		gui.addLine(line);
	
		// 
		// NOT RDF:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(210,121));
		points.add(new Point(222,121));
		sections.add(points);
		line=new GuiLine(sections,RDF.getOut(1));
		gui.addLine(line);


		// JFC signal koji ide u flip flopove
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(121, 158));
		points.add(new Point(519, 158));
		points.add(new Point(519, 121));
		points.add(new Point(537, 121));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(130, 158));
		points.add(new Point(130, 121));
		points.add(new Point(149, 121));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(287, 158));
		points.add(new Point(287, 123));
		points.add(new Point(305, 123));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(402, 158));
		points.add(new Point(402, 121));
		points.add(new Point(421, 121));
		sections.add(points);
		line = new GuiLine(sections, Bus3.JFC());
		gui.addLine(line);
		
		// busy u gornje I kolo
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(249,35));
		points.add(new Point(249,57));
		points.add(new Point(263,57));
		sections.add(points);
		line=new GuiLine(sections,Bus3.busy());
		gui.addLine(line);
		
		// Izlaz gornjeg I kola
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(290,60));
		points.add(new Point(304,60));
		sections.add(points);
		line=new GuiLine(sections,Bus2.RDBJ.getOut(0));
		gui.addLine(line);

		
		// RDB signal
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(368,64));
		points.add(new Point(420,64));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(393,65));
		points.add(new Point(393,207));
		points.add(new Point(421,207));
		sections.add(points);
		line=new GuiLine(sections,Bus2.RDB());
		gui.addLine(line);
		
		// 
		// NOT RDB:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(368,121));
		points.add(new Point(379,121));
		sections.add(points);
		line=new GuiLine(sections,RDB.getOut(1));
		gui.addLine(line);

		// Izlaz treceg JK ff
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(484,64));
		points.add(new Point(536,64));
		sections.add(points);
		line=new GuiLine(sections,Bus2.JK1.getOut(0));
		gui.addLine(line);
		
		// 
		// Not JK treceg FF
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(484,121));
		points.add(new Point(495,121));
		sections.add(points);
		line=new GuiLine(sections,JK1.getOut(1));
		gui.addLine(line);

		
		// Izlaz cetvrtog JK flip flopa
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(599,64));
		points.add(new Point(671,64));
		points.add(new Point(671,37));
		sections.add(points);
		line=new GuiLine(sections,Bus2.ERDC());
		gui.addLine(line);
		
		// 
		// NOT ERDC:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(599,121));
		points.add(new Point(611,121));
		sections.add(points);
		line=new GuiLine(sections,ERDC.getOut(1));
		gui.addLine(line);
		
		// 1 na ulazu gornjeg TSB
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(646,31));
		points.add(new Point(657,31));
		sections.add(points);
		line=new GuiLine(sections,new Pin(true));
		gui.addLine(line);
		
	/*	// Izlaz gornjeg TSB
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(689,31));
		points.add(new Point(699,31));
		sections.add(points);
		line=new GuiLine(sections,Bus2.ERDCout.getOut(0));
		gui.addLine(line);*/
		
		// 
		// NOT RDBUS:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(700,17));
		points.add(new Point(700,45));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(689,31));
		points.add(new Point(699,31));
		sections.add(points);
		line=new GuiLine(sections,Bus2.NotRDBUS());
		gui.addLine(line);

		// 
		// NFC:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,264));
		points.add(new Point(421,264));
		sections.add(points);
		line=new GuiLine(sections,Bus3.NFC());
		gui.addLine(line);

		// ERDA
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(484,207));
		points.add(new Point(495,207));
		sections.add(points);
		line=new GuiLine(sections,Bus2.ERDA());
		gui.addLine(line);
		
		// 
		// NOT ERDA
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(484,264));
		points.add(new Point(495,264));
		sections.add(points);
		line=new GuiLine(sections,ERDA.getOut(1));
		gui.addLine(line);

		
		// DONJI DEO SLIKE:
		
		// writem
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(130,358));
		points.add(new Point(148,358));
		sections.add(points);
		line=new GuiLine(sections,Oper1.writem());
		gui.addLine(line);
		
		// JFC u donje flip flopove
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(121,452));
		points.add(new Point(519,452));
		points.add(new Point(519,416));
		points.add(new Point(536,416));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(130,451));
		points.add(new Point(130,416));
		points.add(new Point(148,416));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(287,451));
		points.add(new Point(287,418));
		points.add(new Point(304,418));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(402,451));
		points.add(new Point(402,416));
		points.add(new Point(420,416));
		sections.add(points);
		line=new GuiLine(sections,Bus3.JFC());
		gui.addLine(line);
		
		// WRF signal u donje I kolo
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(211, 358));
		points.add(new Point(263, 358));
		sections.add(points);
		line = new GuiLine(sections, Bus2.WRF());
		gui.addLine(line);
		
		// 
		// NOT WRF:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(211,416));
		points.add(new Point(222,416));
		sections.add(points);
		line=new GuiLine(sections,WRF.getOut(1));
		gui.addLine(line);

		// busy u donje I kolo
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(249,329));
		points.add(new Point(249,351));
		points.add(new Point(263,351));
		sections.add(points);
		line=new GuiLine(sections,Bus3.busy());
		gui.addLine(line);
		
		// Izlaz donjeg I kola
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(290,354));
		points.add(new Point(304,354));
		sections.add(points);
		line=new GuiLine(sections,Bus2.WRBJ.getOut(0));
		gui.addLine(line);

		
		// WRB signal
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(368,358));
		points.add(new Point(420,358));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(393,359));
		points.add(new Point(393,501));
		points.add(new Point(421,501));
		sections.add(points);
		line=new GuiLine(sections,Bus2.WRB());
		gui.addLine(line);
		
		// 
		// NOT WRB:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(368,416));
		points.add(new Point(379,416));
		sections.add(points);
		line=new GuiLine(sections,WRB.getOut(1));
		gui.addLine(line);

		// Izlaz treceg JK ff
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(484,358));
		points.add(new Point(536,358));
		sections.add(points);
		line=new GuiLine(sections,Bus2.JK2.getOut(0));
		gui.addLine(line);
		
		// 
		// NOT treceg JK ff:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(484,416));
		points.add(new Point(495,416));
		sections.add(points);
		line=new GuiLine(sections,JK2.getOut(1));
		gui.addLine(line);


		// Izlaz cetvrtog JK flip flopa
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(599,358));
		points.add(new Point(671,358));
		points.add(new Point(671,331));
		sections.add(points);
		line=new GuiLine(sections,Bus2.EWRC());
		gui.addLine(line);
		
		// 
		// NOT EWRC:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(599,416));
		points.add(new Point(611,416));
		sections.add(points);
		line=new GuiLine(sections,EWRC.getOut(1));
		gui.addLine(line);

		// 1 na ulazu gornjeg TSB
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(646,326));
		points.add(new Point(657,326));
		sections.add(points);
		line=new GuiLine(sections,new Pin(true));
		gui.addLine(line);
		
		// Izlaz gornjeg TSB
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(689,325));
		points.add(new Point(699,325));
		sections.add(points);
		line=new GuiLine(sections,Bus2.EWRCout.getOut(0));
		gui.addLine(line);
		
		// 
		// NOT WRBUS:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(700,311));
		points.add(new Point(700,340));
		sections.add(points);
		line=new GuiLine(sections,Bus2.NotWRBUS());
		gui.addLine(line);

		// 
		// NFC za EWRAD:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(403,559));
		points.add(new Point(421,559));
		sections.add(points);
		line=new GuiLine(sections,Bus3.NFC());
		gui.addLine(line);

		// EWRAD
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(484,501));
		points.add(new Point(495,501));
		sections.add(points);
		line=new GuiLine(sections,Bus2.EWRAD());
		gui.addLine(line);

		// 
		// NOT EWRAD:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(484,559));
		points.add(new Point(495,559));
		sections.add(points);
		line=new GuiLine(sections,EWRAD.getOut(1));
		gui.addLine(line);

		
		// RDF u ILI kolo
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(607,481));
		points.add(new Point(616,481));
		points.add(new Point(616,489));
		points.add(new Point(630,489));
		sections.add(points);
		line=new GuiLine(sections,Bus2.RDF());
		gui.addLine(line);
		
		// WRF u ILI kolo
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(608,509));
		points.add(new Point(616,509));
		points.add(new Point(616,500));
		points.add(new Point(630,500));
		sections.add(points);
		line=new GuiLine(sections,Bus2.WRF());
		gui.addLine(line);
		
		// Izlaz prvog ILI kola
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(668,495));
		points.add(new Point(653,495));
		sections.add(points);
		line=new GuiLine(sections,Bus2.brqstart.getOut(0));
		gui.addLine(line);
		
		// ERDA u drugo ILI kolo
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(608,538));
		points.add(new Point(617,538));
		points.add(new Point(617,546));
		points.add(new Point(630,546));
		sections.add(points);
		line=new GuiLine(sections,Bus2.ERDA());
		gui.addLine(line);

		// EWRAD u drugo ILI kolo
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(608,561));
		points.add(new Point(616,561));
		points.add(new Point(616,553));
		points.add(new Point(630,553));
		sections.add(points);
		line=new GuiLine(sections,Bus2.EWRAD());
		gui.addLine(line);

		// EA
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(654,550));
		points.add(new Point(668,550));
		sections.add(points);
		line=new GuiLine(sections,Bus2.EA.getOut(0));
		gui.addLine(line);
		
		// ED
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(640,591));
		points.add(new Point(667,591));
		sections.add(points);
		line=new GuiLine(sections,Bus2.ED());
		gui.addLine(line);



	}
	public static void init() {
		RDF=new RSFF("RDF");
		ERDA=new RSFF("ERDA");
		WRF=new RSFF("WRF");
		EWRAD=new RSFF("EWRAD");
		
		RDB=new JKFF();
		JK1=new JKFF();
		ERDC=new JKFF();
		WRB=new JKFF();
		JK2=new JKFF();
		EWRC=new JKFF();
		
		RDBJ=new AND();
		WRBJ=new AND();
		
		brqstart=new OR();
		EA=new OR();
		
		EWRCout=new TSB();
		EWRCout.getOut(0).setNumOfLines(1);
		EWRCout.getOut(0).setIsBool();      	//dodato
		ERDCout=new TSB();
		ERDCout.getOut(0).setNumOfLines(1);
		ERDCout.getOut(0).setIsBool();			//dodato
		
		EWRCoutout=new NOT();
		ERDCoutout=new NOT();
		
		NotRDBUS=new BUS(8,1, "NotRDBUS");
		NotRDBUS.getOut(0).setIsBool();			//dodato
		NotWRBUS=new BUS(8,1, "NotWRBUS");
		NotWRBUS.getOut(0).setIsBool();			//dodato
		
		EWRCoutin=new Pin(true);  				//promenjeno
		ERDCoutin=new Pin(true);
		
	}
	
	public static void connect(){
		RDF.setPinS(Oper1.readm());//pisalo je uprav
		RDF.setPinR(Bus3.JFC());
		
		RDBJ.setInputPin(0, Bus3.busy());
		RDBJ.setInputPin(1, RDF.getOut(0));
		
		RDB.setPinJ(RDBJ.getOut(0));
		RDB.setPinK(Bus3.JFC());
		
		JK1.setPinJ(RDB.getOut(0));
		JK1.setPinK(Bus3.JFC());
		
		ERDC.setPinJ(JK1.getOut(0));
		ERDC.setPinK(Bus3.JFC());
		
		ERDCout.setInputPin(0, ERDCoutin);
		ERDCout.setCtrl(ERDC.getOut(0));
		
		ERDCoutout.setInputPin(0, ERDCout.getOut(0));
		Bus2.addOnNotRDBUS(ERDCoutout.getOut(0));
		
		ERDA.setPinS(RDB.getOut(0));
		ERDA.setPinR(Bus3.NFC());
		
		WRF.setPinS(Oper1.writem());
		WRF.setPinR(Bus3.JFC());
		
		WRBJ.setInputPin(0, WRF.getOut(0));
		WRBJ.setInputPin(1, Bus3.busy());
		
		WRB.setPinJ(WRBJ.getOut(0));
		WRB.setPinK(Bus3.JFC());
		
		JK2.setPinJ(WRB.getOut(0));
		JK2.setPinK(Bus3.JFC());
		
		EWRC.setPinJ(JK2.getOut(0));
		EWRC.setPinK(Bus3.JFC());
		
		EWRCout.setCtrl(EWRC.getOut(0));
		EWRCout.setInputPin(0, EWRCoutin);
		
		EWRCoutout.setInputPin(0, EWRCout.getOut(0));
		Bus2.addOnNotWRBUS(EWRCoutout.getOut(0));
		
		EWRAD.setPinS(WRB.getOut(0));
		EWRAD.setPinR(Bus3.NFC());
		
		brqstart.setInputPin(0, RDF.getOut(0));
		brqstart.setInputPin(1, WRF.getOut(0));
		
		EA.setInputPin(0, ERDA.getOut(0));
		EA.setInputPin(1, EWRAD.getOut(0));
	}
	
	public static void addOnNotWRBUS(Pin pin) {
		NotWRBUS.setInputPin(nwri++, pin);
		
	}

	public static void addOnNotRDBUS(Pin pin) {
		NotRDBUS.setInputPin(nrdi++, pin);
	}

	public static Pin RDF(){
		return RDF.getOut(0);
	}
	public static Pin RDB(){
		return RDB.getOut(0);
	}
	public static Pin ERDC(){
		return ERDC.getOut(0);
	}
	public static Pin ERDA(){
		return ERDA.getOut(0);
	}
	public static Pin WRF(){
		return WRF.getOut(0);
	}
	public static Pin WRB(){
		return WRB.getOut(0);
	}
	public static Pin EWRC(){
		return EWRC.getOut(0);
	}
	public static Pin EWRAD(){
		return EWRAD.getOut(0);
	}
	public static Pin brqstart(){
		return brqstart.getOut(0);
	}
	public static Pin EA(){
		return EA.getOut(0);
	}
	public static Pin ED(){
		return EWRAD.getOut(0);
	}
	public static Pin NotRDBUS(){
		return NotRDBUS.getOut(0);
	}
	public static Pin NotWRBUS(){
		return NotWRBUS.getOut(0);
	}
}
