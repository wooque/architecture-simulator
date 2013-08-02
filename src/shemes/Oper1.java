package shemes;

import gui.*;
import components.*;

public class Oper1 {
	public static OR ldMAR,incMAR, mxMDR1, mxMDR0, ldMDR, readm,writem, MDRout, DS1out;
	public static OR ldPC, incPC, PC1out, PC2out, JAPSout;
	public static OR wrGPR, rdGPR, GPRDout, incSP, decSP,SP1out, ldPR, PRout;
	public static GuiScheme gui;
	
	
	public static GuiScheme getGui() {
		return gui;
	}
	public static void init(){
		ldMAR=new OR(17);
		incMAR=new OR();
		mxMDR1=new OR(4);
		mxMDR0=new OR(5);
		ldMDR=new OR(9);
		readm=new OR(11);
		writem=new OR(9);
		MDRout=new OR(13);
		DS1out=new OR(3);
		ldPC=new OR(5);
		incPC=new OR(4);
		PC1out=new OR(6);
		PC2out=new OR(4);
		JAPSout=new OR();
		wrGPR=new OR();
		rdGPR=new OR(3);
		GPRDout=new OR();
		incSP=new OR(4);
		decSP=new OR(6);
		SP1out=new OR(10);
		ldPR=new OR(4);//sad ima 4 a ne 3
		PRout=new OR(4);
	}
	public static void connect(){
		
		//blok bus
		ldMAR.setInputPin(0, Counter.T02());
		ldMAR.setInputPin(1, Counter.T09());
		ldMAR.setInputPin(2, Counter.T11());
		ldMAR.setInputPin(3, Counter.T16());
		ldMAR.setInputPin(4, Counter.T20());
		ldMAR.setInputPin(5, Counter.T23());
		ldMAR.setInputPin(6, Counter.T5D());
		ldMAR.setInputPin(7, Counter.T60());
		ldMAR.setInputPin(8, Counter.T65());
		ldMAR.setInputPin(9, Counter.T68());
		ldMAR.setInputPin(10, Counter.T6D());
		ldMAR.setInputPin(11, Counter.T70());
		ldMAR.setInputPin(12, Counter.T76());
		ldMAR.setInputPin(13, Counter.T79());
		ldMAR.setInputPin(14, Counter.T7C());
		ldMAR.setInputPin(15, Counter.T7F());
		ldMAR.setInputPin(16, Counter.T8E());
		
		incMAR.setInputPin(0, Counter.T28());
		incMAR.setInputPin(1, Counter.T91());
		
		mxMDR1.setInputPin(0, Counter.T3E());
		mxMDR1.setInputPin(1, Counter.T60());
		mxMDR1.setInputPin(2, Counter.T79());
		mxMDR1.setInputPin(3, Counter.T7F());
		
		mxMDR0.setInputPin(0, Counter.T38());
		mxMDR0.setInputPin(1, Counter.T41());
		mxMDR0.setInputPin(2, Counter.T5D());
		mxMDR0.setInputPin(3, Counter.T76());
		mxMDR0.setInputPin(4, Counter.T7C());
		
		ldMDR.setInputPin(0, Counter.T38());
		ldMDR.setInputPin(1, Counter.T3E());
		ldMDR.setInputPin(2, Counter.T41());
		ldMDR.setInputPin(3, Counter.T5D());
		ldMDR.setInputPin(4, Counter.T60());
		ldMDR.setInputPin(5, Counter.T76());
		ldMDR.setInputPin(6, Counter.T79());
		ldMDR.setInputPin(7, Counter.T7C());
		ldMDR.setInputPin(8, Counter.T7F());
		
		readm.setInputPin(0, Counter.T03());
		readm.setInputPin(1, Counter.T0A());
		readm.setInputPin(2, Counter.T12());
		readm.setInputPin(3, Counter.T17());
		readm.setInputPin(4, Counter.T24());
		readm.setInputPin(5, Counter.T66());
		readm.setInputPin(6, Counter.T69());
		readm.setInputPin(7, Counter.T6E());
		readm.setInputPin(8, Counter.T71());
		readm.setInputPin(9, Counter.T8F());
		readm.setInputPin(10, Counter.T92());
		
		writem.setInputPin(0, Counter.T39());
		writem.setInputPin(1, Counter.T3F());
		writem.setInputPin(2, Counter.T42());
		writem.setInputPin(3, Counter.T5E());
		writem.setInputPin(4, Counter.T61());
		writem.setInputPin(5, Counter.T77());
		writem.setInputPin(6, Counter.T7A());
		writem.setInputPin(7, Counter.T7D());
		writem.setInputPin(8, Counter.T80());
		
		MDRout.setInputPin(0, Counter.T05());
		MDRout.setInputPin(1, Counter.T0C());
		MDRout.setInputPin(2, Counter.T14());
		MDRout.setInputPin(3, Counter.T19());
		MDRout.setInputPin(4, Counter.T27());
		MDRout.setInputPin(5, Counter.T28());
		MDRout.setInputPin(6, Counter.T2B());
		MDRout.setInputPin(7, Counter.T68());
		MDRout.setInputPin(8, Counter.T6B());
		MDRout.setInputPin(9, Counter.T70());
		MDRout.setInputPin(10, Counter.T73());
		MDRout.setInputPin(11, Counter.T91());
		MDRout.setInputPin(12, Counter.T94());
		
		DS1out.setInputPin(0, Counter.T20());
		DS1out.setInputPin(1, Counter.T23());
		DS1out.setInputPin(2, Counter.T8E());
		
		//blok fetch
		ldPC.setInputPin(0, Counter.T5A());
		ldPC.setInputPin(1, Counter.T5B());
		ldPC.setInputPin(2, Counter.T63());
		ldPC.setInputPin(3, Counter.T74());
		ldPC.setInputPin(4, Counter.T95());
		
		incPC.setInputPin(0, Counter.T02());
		incPC.setInputPin(1, Counter.T09());
		incPC.setInputPin(2, Counter.T11());
		incPC.setInputPin(3, Counter.T16());
		
		PC1out.setInputPin(0, Counter.T02());
		PC1out.setInputPin(1, Counter.T09());
		PC1out.setInputPin(2, Counter.T11());
		PC1out.setInputPin(3, Counter.T16());
		PC1out.setInputPin(4, Counter.T22());
		PC1out.setInputPin(5, Counter.T59());
		
		PC2out.setInputPin(0, Counter.T5D());
		PC2out.setInputPin(1, Counter.T60());
		PC2out.setInputPin(2, Counter.T76());
		PC2out.setInputPin(3, Counter.T79());
		
		JAPSout.setInputPin(0, Counter.T5B());
		JAPSout.setInputPin(1, Counter.T63());
		
		wrGPR.setInputPin(0, Counter.T3C());
		wrGPR.setInputPin(1, Counter.T45());
		
		rdGPR.setInputPin(0, Counter.T1F());
		rdGPR.setInputPin(1, Counter.T1D());
		rdGPR.setInputPin(2, Counter.T1E());
		
		GPRDout.setInputPin(0, Counter.T1D());
		GPRDout.setInputPin(1, Counter.T1E());
		
		incSP.setInputPin(0, Counter.T64());
		incSP.setInputPin(1, Counter.T65());
		incSP.setInputPin(2, Counter.T6C());
		incSP.setInputPin(3, Counter.T6D());
		
		decSP.setInputPin(0, Counter.T5D());
		decSP.setInputPin(1, Counter.T63());
		decSP.setInputPin(2, Counter.T76());
		decSP.setInputPin(3, Counter.T79());
		decSP.setInputPin(4, Counter.T7C());
		decSP.setInputPin(5, Counter.T7F());
		
		SP1out.setInputPin(0, Counter.T5D());
		SP1out.setInputPin(1, Counter.T60());
		SP1out.setInputPin(2, Counter.T65());
		SP1out.setInputPin(3, Counter.T68());
		SP1out.setInputPin(4, Counter.T6D());
		SP1out.setInputPin(5, Counter.T70());
		SP1out.setInputPin(6, Counter.T76());
		SP1out.setInputPin(7, Counter.T79());
		SP1out.setInputPin(8, Counter.T7C());
		SP1out.setInputPin(9, Counter.T7F());
		

		ldPR.setInputPin(0, Counter.T1F());
		ldPR.setInputPin(1, Counter.T22());
		ldPR.setInputPin(2, Counter.T59());
		ldPR.setInputPin(3, Counter.T8D());
		
		PRout.setInputPin(0, Counter.T20());
		PRout.setInputPin(1, Counter.T23());
		PRout.setInputPin(2, Counter.T5A());
		PRout.setInputPin(3, Counter.T8E());
		
	}
	
	public static Pin ldMAR(){
		return ldMAR.getOut(0);	
	}
	public static Pin incMAR(){
		return incMAR.getOut(0);	
	}
	public static Pin mxMDR1(){
		return mxMDR1.getOut(0);	
	}
	public static Pin mxMDR0(){
		return mxMDR0.getOut(0);	
	}
	public static Pin ldMDR(){
		return ldMDR.getOut(0);	
	}
	public static Pin readm(){
		return readm.getOut(0);	
	}
	public static Pin writem(){
		return writem.getOut(0);	
	}
	public static Pin MDRout(){
		return MDRout.getOut(0);	
	}
	public static Pin S2Dout(){
		return Counter.T47();	
	}
	public static Pin DS1out(){
		return DS1out.getOut(0);	
	}
	public static Pin ldPC(){
		return ldPC.getOut(0);	
	}
	public static Pin incPC(){
		return incPC.getOut(0);	
	}
	public static Pin ldIR0(){
		return Counter.T05();	
	}
	public static Pin ldIR1(){
		return Counter.T0C();	
	}
	public static Pin ldIR2(){
		return Counter.T14();	
	}
	public static Pin ldIR3(){
		return Counter.T19();	
	}
	public static Pin PC1out(){
		return PC1out.getOut(0);	
	}
	public static Pin PC2out(){
		return PC2out.getOut(0);	
	}
	public static Pin JDISPout(){
		return Counter.T59();	
	}
	public static Pin INTENTRYout(){
		return Counter.T83();	
	}
	public static Pin PCRDISPout(){
		return Counter.T22();	
	}
	public static Pin REGIDISPout(){
		return Counter.T1F();	
	}
	public static Pin IMMout(){
		return Counter.T2C();	
	}
	public static Pin JAPSout(){
		return JAPSout.getOut(0);	
	}
	public static Pin ldGPRAR(){
		return Counter.T0C();	
	}
	public static Pin wrGPR(){
		return wrGPR.getOut(0);	
	}
	public static Pin rdGPR(){
		return rdGPR.getOut(0);	
	}
	public static Pin GPR1out(){
		return Counter.T1F();	
	}
	public static Pin GPRDout(){
		return GPRDout.getOut(0);	
	}
	public static Pin ldSP(){
		return Counter.T47();	
	}
	public static Pin incSP(){
		return incSP.getOut(0);	
	}
	public static Pin decSP(){
		return decSP.getOut(0);	
	}
	public static Pin SP1out(){
		return SP1out.getOut(0);	
	}
	public static Pin ldPR(){
		return ldPR.getOut(0);	
	}
	public static Pin PRout(){
		return PRout.getOut(0);	
	}

}
