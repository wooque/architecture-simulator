package shemes;

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
