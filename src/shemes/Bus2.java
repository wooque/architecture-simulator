package shemes;

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
