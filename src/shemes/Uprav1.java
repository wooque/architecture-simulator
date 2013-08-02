package shemes;

import gui.GuiScheme;
import components.*;

public class Uprav1 {
	public static AND AND1, AND2, AND3, AND4, AND5, AND6, AND7, AND8, AND9, AND10;
	public static AND AND11, AND12, AND13, AND14, AND15, AND16, AND17, AND18, AND19;
	public static OR bruncnd, brcnd, brnotbrqstop, brstore, brLDW, brregdir;
	public static NOT NOT1, NOT2, NOT3, NOT4, NOT5, NOT6, NOT7, NOT8, NOT9, NOT10;
	public static AND ANDbrqstart;
	public static NOT NOTBRQSTOP;
	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}
	public static void init(){
		AND1 = new AND();
		AND2 = new AND();
		AND3 = new AND();
		AND4 = new AND();
		AND5 = new AND();
		AND6 = new AND();
		AND7 = new AND();
		AND8 = new AND();
		AND9 = new AND();
		AND10 = new AND();
		AND11 = new AND();
		AND12 = new AND();
		AND13 = new AND();
		AND14 = new AND();
		AND15 = new AND();
		AND16 = new AND();
		AND17 = new AND();
		AND18 = new AND();
		AND19 = new AND();
		bruncnd = new OR(39);
		brcnd = new OR(20);//za 1 vise
		brnotbrqstop = new OR(21);//za 1 manje
		brstore = new OR(3);
		brLDW = new OR();
		brregdir = new OR();
		NOT1 = new NOT();
		NOT2 = new NOT();
		NOT3 = new NOT();
		NOT4 = new NOT();
		NOT5 = new NOT();
		NOT6 = new NOT();
		NOT7 = new NOT();
		NOT8 = new NOT();
		NOT9 = new NOT();
		NOT10 = new NOT();
		
		ANDbrqstart=new AND();//ide u brcnd
		NOTBRQSTOP=new NOT();
	}
	public static void connect(){
		bruncnd.setInputPin(0, Counter.T07());
		bruncnd.setInputPin(1, Counter.T0E());
		bruncnd.setInputPin(2, Counter.T1D());
		bruncnd.setInputPin(3, Counter.T1E());
		bruncnd.setInputPin(4, Counter.T21());
		bruncnd.setInputPin(5, Counter.T27());
		bruncnd.setInputPin(6, Counter.T2B());
		bruncnd.setInputPin(7, Counter.T2E());
		bruncnd.setInputPin(8, Counter.T2F());
		bruncnd.setInputPin(9, Counter.T30());
		bruncnd.setInputPin(10, Counter.T31());
		bruncnd.setInputPin(11, Counter.T32());
		bruncnd.setInputPin(12, Counter.T33());
		bruncnd.setInputPin(13, Counter.T35());
		bruncnd.setInputPin(14, Counter.T36());
		bruncnd.setInputPin(15, Counter.T3B());
		bruncnd.setInputPin(16, Counter.T3C());
		bruncnd.setInputPin(17, Counter.T44());
		bruncnd.setInputPin(18, Counter.T45());
		bruncnd.setInputPin(19, Counter.T46());
		bruncnd.setInputPin(20, Counter.T47());
		bruncnd.setInputPin(21, Counter.T49());
		bruncnd.setInputPin(22, Counter.T4B());
		bruncnd.setInputPin(23, Counter.T4D());
		bruncnd.setInputPin(24, Counter.T4F());
		bruncnd.setInputPin(25, Counter.T51());
		bruncnd.setInputPin(26, Counter.T53());
		bruncnd.setInputPin(27, Counter.T55());
		bruncnd.setInputPin(28, Counter.T57());
		bruncnd.setInputPin(29, Counter.T5A());
		bruncnd.setInputPin(30, Counter.T5B());
		bruncnd.setInputPin(31, Counter.T5C());
		bruncnd.setInputPin(32, Counter.T63());
		bruncnd.setInputPin(33, Counter.T83());
		bruncnd.setInputPin(34, Counter.T85());
		bruncnd.setInputPin(35, Counter.T87());
		bruncnd.setInputPin(36, Counter.T89());
		bruncnd.setInputPin(37, Counter.T8B());
		bruncnd.setInputPin(38, Counter.T95());
		
		NOT1.setInputPin(0,Exec2.START());	
		AND1.setInputPin(0, Counter.T00());//brnotSTART=T00
		AND1.setInputPin(1, NOT1.getOut(0));
		brcnd.setInputPin(0, AND1.getOut(0));
		
		NOTBRQSTOP.setInputPin(0, Bus3.brqstop());															//BRBRqstopDODATO  dodato
		AND2.setInputPin(0, brnotbrqstop.getOut(0));
		AND2.setInputPin(1,NOTBRQSTOP.getOut(0));
		brcnd.setInputPin(1, AND2.getOut(0));
		
		NOT2.setInputPin(0,Fetch3.gropr());	
		AND3.setInputPin(0, Counter.T06());//brnotgropr=T06
		AND3.setInputPin(1, NOT2.getOut(0));
		brcnd.setInputPin(2, AND3.getOut(0));
		
		AND4.setInputPin(0, Counter.T08());//brI1=T08
		AND4.setInputPin(1, Fetch3.I1());
		brcnd.setInputPin(3, AND4.getOut(0));
		
		NOT3.setInputPin(0,Fetch3.gradr());	
		AND5.setInputPin(0, Counter.T0D());//brnotgradr=T0D
		AND5.setInputPin(1, NOT3.getOut(0));
		brcnd.setInputPin(4, AND5.getOut(0));
		
		AND6.setInputPin(0, Counter.T0F());//brI2_brnc=T0F
		AND6.setInputPin(1, Fetch3.I2_brnch());
		brcnd.setInputPin(5, AND6.getOut(0));
		
		AND7.setInputPin(0, Counter.T10());//brI2_arlog=T10
		AND7.setInputPin(1, Fetch3.I2_arlog());
		brcnd.setInputPin(6, AND7.getOut(0));
		
		AND8.setInputPin(0, Counter.T14());//brI3_jump=T14
		AND8.setInputPin(1, Fetch3.I3_jump());
		brcnd.setInputPin(7, AND8.getOut(0));
		
		AND9.setInputPin(0, Counter.T15());//brI3_arlog=T15
		AND9.setInputPin(1, Fetch3.I3_arlog());
		brcnd.setInputPin(8, AND9.getOut(0));
		
		AND10.setInputPin(0, brstore.getOut(0));
		AND10.setInputPin(1, Fetch3.store());
		brcnd.setInputPin(9, AND10.getOut(0));
		
		AND11.setInputPin(0, brLDW.getOut(0));
		AND11.setInputPin(1, Fetch2.LDW());
		brcnd.setInputPin(10, AND11.getOut(0));
		
		AND12.setInputPin(0, brregdir.getOut(0));
		AND12.setInputPin(1, Fetch2.regdir());
		brcnd.setInputPin(11, AND12.getOut(0));
		
		NOT4.setInputPin(0,Exec4.brpom());	
		AND13.setInputPin(0, Counter.T58());//brnotpom=T58
		AND13.setInputPin(1, NOT4.getOut(0));
		brcnd.setInputPin(12, AND13.getOut(0));
		
		NOT5.setInputPin(0,Intr1.prekid());	
		AND14.setInputPin(0, Counter.T75());//brnotprekid=T75
		AND14.setInputPin(1, NOT5.getOut(0));
		brcnd.setInputPin(13, AND14.getOut(0));
		
		NOT6.setInputPin(0,Intr1.PRINS());	
		AND15.setInputPin(0, Counter.T82());//brnotPRINS=T82
		AND15.setInputPin(1, NOT6.getOut(0));
		brcnd.setInputPin(14, AND15.getOut(0));
		
		NOT7.setInputPin(0,Intr1.PRCOD());	
		AND16.setInputPin(0, Counter.T84());//brnotPRCOD=T84
		AND16.setInputPin(1, NOT7.getOut(0));
		brcnd.setInputPin(15, AND16.getOut(0));
		
		NOT8.setInputPin(0,Intr1.PRADR());	
		AND17.setInputPin(0, Counter.T86());//brnotPRADR=T75
		AND17.setInputPin(1, NOT8.getOut(0));
		brcnd.setInputPin(16, AND17.getOut(0));
		
		NOT9.setInputPin(0,Intr1.PRINM());	
		AND18.setInputPin(0, Counter.T88());//brnotPRINM=T78
		AND18.setInputPin(1, NOT9.getOut(0));
		brcnd.setInputPin(17, AND18.getOut(0));
		
		NOT10.setInputPin(0,Intr2.printr());	
		AND19.setInputPin(0, Counter.T86());//brnotprintr=T8A
		AND19.setInputPin(1, NOT10.getOut(0));
		brcnd.setInputPin(18, AND19.getOut(0));
		
		ANDbrqstart.setInputPin(0,Counter.T01());
		ANDbrqstart.setInputPin(1,Bus2.brqstart());
		brcnd.setInputPin(19, ANDbrqstart.getOut(0));
		
		//brnotNFC.setInputPin(0, Counter.T01());
		brnotbrqstop.setInputPin(0, Counter.T04());
		brnotbrqstop.setInputPin(1, Counter.T0B());
		brnotbrqstop.setInputPin(2, Counter.T13());
		brnotbrqstop.setInputPin(3, Counter.T18());
		brnotbrqstop.setInputPin(4, Counter.T25());
		brnotbrqstop.setInputPin(5, Counter.T2A());
		brnotbrqstop.setInputPin(6, Counter.T3A());
		brnotbrqstop.setInputPin(7, Counter.T40());
		brnotbrqstop.setInputPin(8, Counter.T43());
		brnotbrqstop.setInputPin(9, Counter.T5F());
		brnotbrqstop.setInputPin(10, Counter.T62());
		brnotbrqstop.setInputPin(11, Counter.T67());
		brnotbrqstop.setInputPin(12, Counter.T6A());
		brnotbrqstop.setInputPin(13, Counter.T6F());
		brnotbrqstop.setInputPin(14, Counter.T72());
		brnotbrqstop.setInputPin(15, Counter.T78());
		brnotbrqstop.setInputPin(16, Counter.T7B());
		brnotbrqstop.setInputPin(17, Counter.T7E());
		brnotbrqstop.setInputPin(18, Counter.T81());
		brnotbrqstop.setInputPin(19, Counter.T90());
		brnotbrqstop.setInputPin(20, Counter.T93());
		
		brstore.setInputPin(0, Counter.T20());
		brstore.setInputPin(1, Counter.T23());
		brstore.setInputPin(2, Counter.T1B());
		
		brLDW.setInputPin(0, Counter.T1C());
		brLDW.setInputPin(1, Counter.T26());
		
		brregdir.setInputPin(0, Counter.T37());
		brregdir.setInputPin(1, Counter.T3D());
		
	}
	public static Pin bradr(){
		return Counter.T1A();
	}
	public static Pin bropr(){
		return Counter.T2D();
	}
	public static Pin brnotSTART(){
		return Counter.T00();
	}
	public static Pin brnotbrpom(){
		return Counter.T58();
	}
	public static Pin brnotprekid(){
		return Counter.T75();
	}
	public static Pin brnotPRINS(){
		return Counter.T82();
	}
	public static Pin brnotPRCOD(){
		return Counter.T84();
	}
	public static Pin brnotPRADR(){
		return Counter.T86();
	}
	public static Pin brnotPRINM(){
		return Counter.T88();
	}
	public static Pin brnotprintr(){
		return Counter.T8A();
	}
	public static Pin brnotgropr(){
		return Counter.T06();
	}
	public static Pin brI1(){
		return Counter.T08();
	}
	public static Pin brnotgradr(){
		return Counter.T0D();
	}
	public static Pin brI2_brnch(){
		return Counter.T0F();
	}
	public static Pin brI2_arlog(){
		return Counter.T10();
	}
	public static Pin brI3_jump(){
		return Counter.T14();
	}
	public static Pin brI3_arlog(){
		return Counter.T15();
	}
	public static Pin bruncnd(){
		return bruncnd.getOut(0);
	}
	public static Pin brcnd(){
		return brcnd.getOut(0);
	}
	public static Pin brnotbrqstop(){
		return brnotbrqstop.getOut(0);
	}
	public static Pin brstore(){
		return brstore.getOut(0);
	}
	public static Pin brLDW(){
		return brLDW.getOut(0);
	}
	public static Pin brregdir(){
		return brregdir.getOut(0);
	}
	
}
