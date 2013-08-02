package shemes;

import gui.*;

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
