package shemes;

import gui.*;

import java.awt.Point;
import java.util.ArrayList;

import components.*;

public class Bus3{
	static RSFF BR1, busy, END;
	static public DFF FFC, FFCD, brqstop;
	static AND bgr, setbusy, JFC, NFC;
	static TSB TSB1, TSB2, busyout, FFCin;
	static BUS NotBUSYBUS,NotFCBUS;
	static NOT NOT1,NOT2, FFCinNOT, busyoutNOT;
	static private Pin one;
	static private int nbbi=0,nfci=0;
	static public GuiScheme gui;
	
	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui(){
		
		
		GuiLine line;									// Pomocna promenljiva
		gui=new GuiScheme("./src/images/bus3.png");		
		
		ArrayList<ArrayList<Point>> sections;
		ArrayList<Point> points;
		
		
		// FFC signal
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(245,62));
		points.add(new Point(315,62));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(278,62));
		points.add(new Point(278,15));
		points.add(new Point(512,15));
		sections.add(points);
		line=new GuiLine(sections,Bus3.FFC());
		gui.addLine(line);
		
		// sa !FCBUS na negirano kolo
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(97,62));
		points.add(new Point(113,62));
		sections.add(points);
		line=new GuiLine(sections, Bus3.NotFCBUS());
		gui.addLine(line);
		
		// izlaz NOT kola
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(166,62));
		points.add(new Point(153,62));
		sections.add(points);
		line=new GuiLine(sections,Bus3.FFCinNOT.getOut(0));
		gui.addLine(line);

		
		// !FFC signal
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(246,136));
		points.add(new Point(261,136));
		points.add(new Point(261,173));
		points.add(new Point(464,173));
		points.add(new Point(464,73));
		points.add(new Point(511,73));
		sections.add(points);
		line=new GuiLine(sections,Bus3.NotFFC());
		gui.addLine(line);
		
		// FFCD signal
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(395,62));
		points.add(new Point(511,62));
		sections.add(points);
		line=new GuiLine(sections,Bus3.FFCD());
		gui.addLine(line);
		
		// !FFCD signal
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(395,136));
		points.add(new Point(443,136));
		points.add(new Point(443,25));
		points.add(new Point(511,25));
		sections.add(points);
		line=new GuiLine(sections,Bus3.NotFFCD());
		gui.addLine(line);

		// Izlaz JFC I kola
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(544,20));
		points.add(new Point(572,20));
		sections.add(points);
		line=new GuiLine(sections,Bus3.JFC());
		gui.addLine(line);
		
		// Izlaz NFC I kola
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(544,67));
		points.add(new Point(572,67));
		sections.add(points);
		line=new GuiLine(sections,Bus3.NFC());
		gui.addLine(line);

		// NFC u END flip flop
		//	
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(145,212));
		points.add(new Point(167,212));
		sections.add(points);
		line=new GuiLine(sections,Bus3.NFC());
		gui.addLine(line);
		
		// END signal
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(248,212));
		points.add(new Point(319,212));
		sections.add(points);
		line=new GuiLine(sections,Bus3.END());
		gui.addLine(line);
		
		// 
		// NOT END:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(248,285));
		points.add(new Point(263,285));
		sections.add(points);
		line=new GuiLine(sections,END.getOut(1));
		gui.addLine(line);

		// brqstop
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(400,213));
		points.add(new Point(428,213));
		points.add(new Point(428,325));
		points.add(new Point(145,325));
		points.add(new Point(145,285));
		points.add(new Point(168,285));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(429,213));
		points.add(new Point(443,213));
		sections.add(points);
		line=new GuiLine(sections,Bus3.brqstop());
		gui.addLine(line);
	
		// 
		// NOT brqstop:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(400,285));
		points.add(new Point(415,285));
		sections.add(points);
		line=new GuiLine(sections,brqstop.getOut(1));
		gui.addLine(line);
		
		// brqstart u flip flop
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(134,463));
		points.add(new Point(156,463));
		sections.add(points);
		line=new GuiLine(sections, Bus2.brqstart());
		gui.addLine(line);
		
		// brqstop u flip flop
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(134,536));
		points.add(new Point(156,536));
		sections.add(points);
		line=new GuiLine(sections,Bus3.brqstop());
		gui.addLine(line);
		
		// BR1 signal
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(237,463));
		points.add(new Point(316,463));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(267,464));
		points.add(new Point(267,578));
		sections.add(points);
		line=new GuiLine(sections,Bus3.BR1());
		gui.addLine(line);
		
		// 
		// NOT BR1:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(237,536));
		points.add(new Point(252,536));
		sections.add(points);
		line=new GuiLine(sections,BR1.getOut(1));
		gui.addLine(line);

		// BG_IN 1 u flip flop
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(301,578));
		points.add(new Point(301,473));
		points.add(new Point(316,473));
		sections.add(points);
		line=new GuiLine(sections,Arbitary.BG_IN1());
		gui.addLine(line);
		
		// bgr signal
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(350,468));
		points.add(new Point(404,468));
		sections.add(points);
		line=new GuiLine(sections,Bus3.bgr());
		gui.addLine(line);

		// setbusy signal
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(438,463));
		points.add(new Point(510,463));
		sections.add(points);
		line=new GuiLine(sections,Bus3.setbusy());
		gui.addLine(line);
		
		// busy signal
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(591,464));
		points.add(new Point(645,464));
		points.add(new Point(645,437));
		sections.add(points);
		line=new GuiLine(sections,Bus3.busy());
		gui.addLine(line);
		
		// 
		// not busy
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(591,536));
		points.add(new Point(606,536));
		sections.add(points);
		line=new GuiLine(sections,busy.getOut(1));
		gui.addLine(line);

		// ulaz u TSB
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(616,429));
		points.add(new Point(630,429));
		sections.add(points);
		line=new GuiLine(sections,new Pin(true));
		gui.addLine(line);
		
		// !BUSYBUS
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(670,429));
		points.add(new Point(724,429));
		points.add(new Point(724,376));
		points.add(new Point(252,376));
		points.add(new Point(252,403));
		points.add(new Point(277,403));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(724,375));
		points.add(new Point(724,353));
		sections.add(points);
		line=new GuiLine(sections,Bus3.NotBUSYBUS());
		gui.addLine(line);

		// Izlaz NOT1
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(317,403));
		points.add(new Point(331,403));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(317,402));
		points.add(new Point(331,402));
		sections.add(points);
		line=new GuiLine(sections,Bus3.NOT1.getOut(0));
		gui.addLine(line);

		// Izlaz NOT2
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(371,402));
		points.add(new Point(383,402));
		points.add(new Point(383,455));
		points.add(new Point(404,455));
		sections.add(points);
		line=new GuiLine(sections,Bus3.NOT2.getOut(0));
		gui.addLine(line);
		
		// brqstop u FF
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(510,537));
		points.add(new Point(510,536));
		points.add(new Point(488,536));
		sections.add(points);
		line=new GuiLine(sections,Bus3.brqstop());
		gui.addLine(line);
		
		//BCLK donje:
		
		// 
		// 1.deo
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(146,358));
		points.add(new Point(146,429));
		points.add(new Point(500,429));
		points.add(new Point(500,500));
		points.add(new Point(510,500));
		sections.add(points);
		line=new GuiLine(sections,LogicalComponent.getBUSCLK());
		gui.addLine(line);

		// 
		// 2.deo
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(146,429));
		points.add(new Point(146,500));
		points.add(new Point(156,500));
		sections.add(points);
		line=new GuiLine(sections,LogicalComponent.getBUSCLK());
		gui.addLine(line);

		// 
		//kod brqstop: 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(309,249));
		points.add(new Point(319,249));
		sections.add(points);
		line=new GuiLine(sections,LogicalComponent.getBUSCLK());
		gui.addLine(line);

		//
		//





	}

	public static void init() {
		
		BR1 = new RSFF("BR1");
		BR1.setClock(2);
		busy = new RSFF("busy");
		busy.setClock(2);
		END = new RSFF("END");
		
		FFC = new DFF();
		FFCD = new DFF();
		brqstop = new DFF();
		brqstop.setClock(2);
		
		bgr = new AND();
		setbusy = new AND();
		JFC = new AND();
		NFC = new AND();
		
		TSB1=new TSB();
		TSB1.getOut(0).setNumOfLines(1);
		TSB1.getOut(0).setIsBool();					//dodato
		TSB2=new TSB();
		TSB2.getOut(0).setNumOfLines(1);
		TSB2.getOut(0).setIsBool();					//dodato
		busyout=new TSB();
		busyout.getOut(0).setNumOfLines(1);
		busyout.getOut(0).setIsBool();				//dodato
		FFCin=new TSB();						//moze i sa jednim not kolom samo
		FFCin.getOut(0).setNumOfLines(1);
		FFCin.getOut(0).setIsBool();				//dodato
		
		NOT1=new NOT();
		NOT2=new NOT();
		busyoutNOT=new NOT();
		FFCinNOT=new NOT();							
		
		NotBUSYBUS=new BUS(8,1,"NotBUSYBUS");
		NotBUSYBUS.getOut(0).setIsBool();			//dodato	
		NotFCBUS=new BUS(8,1,"NotFCBUS");
		NotFCBUS.getOut(0).setIsBool();	
		
		one=new Pin(true);							//promenjeno
		
		
	}
	public static void connect(){
		BR1.setPinS(Bus2.brqstart());
		BR1.setPinR(brqstop.getOut(0));
		//BR1 treba da se klokuje na dva puta sporiji klok od onovnog
		//BR1.setClock(2);
		bgr.setInputPin(0, BR1.getOut(0));
		bgr.setInputPin(1, Arbitary.BG_IN1());
		
		setbusy.setInputPin(0, bgr.getOut(0));
		setbusy.setInputPin(1, NOT2.getOut(0));
		
		busy.setPinR(brqstop.getOut(0));
		busy.setPinS(setbusy.getOut(0));
		//busy treba da se klokuje na dva puta sporiji klok od onovnog
		//busy.setClock(2);
		busyout.setCtrl(busy.getOut(0));
		busyout.setInputPin(0, one);
		
		busyoutNOT.setInputPin(0, busyout.getOut(0));
		Bus3.addOnNotBUSYBUS(busyoutNOT.getOut(0));
		
		TSB1.setInputPin(0, NotBUSYBUS.getOut(0));
		NOT1.setInputPin(0, TSB1.getOut(0));
		TSB2.setInputPin(0, NOT1.getOut(0));
		NOT2.setInputPin(0, TSB2.getOut(0));
		
		FFCin.setInputPin(0, NotFCBUS.getOut(0));
		FFCinNOT.setInputPin(0, FFCin.getOut(0));
		
		FFC.setPinD(FFCinNOT.getOut(0));
		FFCD.setPinD(FFC.getOut(0));
		
		JFC.setInputPin(0, FFC.getOut(0));
		JFC.setInputPin(1, FFCD.getOut(1));
		
		NFC.setInputPin(0, FFCD.getOut(0));
		NFC.setInputPin(1, FFC.getOut(1));
		
		END.setPinS(NFC.getOut(0));
		END.setPinR(brqstop.getOut(0));
		
		brqstop.setPinD(END.getOut(0));
		//brqstop treba da se klokuje na dva puta sporiji klok od onovnog
		//brqstop.setClock(2);
		
	}
	public static void addOnNotBUSYBUS(Pin pin) {
		NotBUSYBUS.setInputPin(nbbi++, pin);
		
	}
	public static void addOnNotFCBUS(Pin pin){
		NotFCBUS.setInputPin(nfci++, pin);
	}
	public static Pin NotFCBUS(){
		return NotFCBUS.getOut(0);
	}
	public static Pin NotBUSYBUS(){
		return NotBUSYBUS.getOut(0);
	}
	public static Pin BR1(){
		return BR1.getOut(0);
	}
	public static Pin bgr(){
		return bgr.getOut(0);
	}
	public static Pin setbusy(){
		return setbusy.getOut(0);
	}
	public static Pin busy(){
		return busy.getOut(0);
	}
	public static Pin FFC(){
		return FFC.getOut(0);
	}
	public static Pin NotFFC(){
		return FFC.getOut(1);
	}
	public static Pin FFCD(){
		return FFCD.getOut(0);
	}
	public static Pin NotFFCD(){
		return FFCD.getOut(1);
	}
	public static Pin JFC(){
		return JFC.getOut(0);
	}
	public static Pin NFC(){
		return NFC.getOut(0);
	}
	public static Pin END(){
		return END.getOut(0);
	}
	public static Pin brqstop(){
		return brqstop.getOut(0);
	}
}
