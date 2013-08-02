  package shemes;

import gui.*;
import components.*;

public class Oper2 {
	public static OR ldAB, ldBB, AW2out, ldBWH, ldBWL, BWout, clPSWI, clPSWT;
	public static OR ldN, ldZ, ldC, ldV, PSWout, ALUout, mxBR1, ldBR;
	public static GuiScheme gui;
	
	public static GuiScheme getGui() {
		return gui;
	}

	public static void init() {
		ldAB = new OR(7);
		ldBB = new OR(3);
		AW2out = new OR(4);
		ldBWH = new OR(4);
		ldBWL = new OR(4);
		BWout = new OR(3);
		clPSWI = new OR();
		clPSWT = new OR();
		ldN = new OR(9);
		ldZ = new OR(9);
		ldC = new OR(9);
		ldV = new OR(9);
		PSWout = new OR();
		ALUout = new OR(6);
		mxBR1 = new OR(4);
		ldBR = new OR(6);
		

	}

	public static void connect() {
		ldAB.setInputPin(0, Counter.T34());
		ldAB.setInputPin(1, Counter.T48());
		ldAB.setInputPin(2, Counter.T4A());
		ldAB.setInputPin(3, Counter.T4C());
		ldAB.setInputPin(4, Counter.T4E());
		ldAB.setInputPin(5, Counter.T50());
		ldAB.setInputPin(6, Counter.T52());

		ldBB.setInputPin(0, Counter.T1D());
		ldBB.setInputPin(1, Counter.T27());
		ldBB.setInputPin(2, Counter.T2C());

		AW2out.setInputPin(0, Counter.T3E());
		AW2out.setInputPin(1, Counter.T41());
		AW2out.setInputPin(2, Counter.T46());
		AW2out.setInputPin(3, Counter.T47());

		ldBWH.setInputPin(0, Counter.T1E());
		ldBWH.setInputPin(1, Counter.T2B());
		ldBWH.setInputPin(2, Counter.T70());
		ldBWH.setInputPin(3, Counter.T91());

		ldBWL.setInputPin(0, Counter.T1E());
		ldBWL.setInputPin(1, Counter.T28());
		ldBWL.setInputPin(2, Counter.T73());
		ldBWL.setInputPin(3, Counter.T94());

		BWout.setInputPin(0, Counter.T36());
		BWout.setInputPin(1, Counter.T74());
		BWout.setInputPin(2, Counter.T95());

		clPSWI.setInputPin(0, Counter.T30());
		clPSWI.setInputPin(1, Counter.T95());

		clPSWT.setInputPin(0, Counter.T32());
		clPSWT.setInputPin(1, Counter.T95());

		ldN.setInputPin(0, Counter.T35());
		ldN.setInputPin(1, Counter.T49());
		ldN.setInputPin(2, Counter.T4B());
		ldN.setInputPin(3, Counter.T4D());
		ldN.setInputPin(4, Counter.T4F());
		ldN.setInputPin(5, Counter.T51());
		ldN.setInputPin(6, Counter.T53());
		ldN.setInputPin(7, Counter.T55());
		ldN.setInputPin(8, Counter.T57());

		ldZ.setInputPin(0, Counter.T35());
		ldZ.setInputPin(1, Counter.T49());
		ldZ.setInputPin(2, Counter.T4B());
		ldZ.setInputPin(3, Counter.T4D());
		ldZ.setInputPin(4, Counter.T4F());
		ldZ.setInputPin(5, Counter.T51());
		ldZ.setInputPin(6, Counter.T53());
		ldZ.setInputPin(7, Counter.T55());
		ldZ.setInputPin(8, Counter.T57());

		ldC.setInputPin(0, Counter.T35());
		ldC.setInputPin(1, Counter.T48());
		ldC.setInputPin(2, Counter.T4A());
		ldC.setInputPin(3, Counter.T4D());
		ldC.setInputPin(4, Counter.T4F());
		ldC.setInputPin(5, Counter.T51());
		ldC.setInputPin(6, Counter.T53());
		ldC.setInputPin(7, Counter.T54());
		ldC.setInputPin(8, Counter.T56());

		ldV.setInputPin(0, Counter.T35());
		ldV.setInputPin(1, Counter.T48());
		ldV.setInputPin(2, Counter.T4A());
		ldV.setInputPin(3, Counter.T4D());
		ldV.setInputPin(4, Counter.T4F());
		ldV.setInputPin(5, Counter.T51());
		ldV.setInputPin(6, Counter.T53());
		ldV.setInputPin(7, Counter.T55());
		ldV.setInputPin(8, Counter.T57());

		PSWout.setInputPin(0, Counter.T7C());
		PSWout.setInputPin(1, Counter.T7F());

		ALUout.setInputPin(0, Counter.T48());
		ALUout.setInputPin(1, Counter.T4A());
		ALUout.setInputPin(2, Counter.T4C());
		ALUout.setInputPin(3, Counter.T4E());
		ALUout.setInputPin(4, Counter.T50());
		ALUout.setInputPin(5, Counter.T52());

		mxBR1.setInputPin(0, Counter.T85());
		mxBR1.setInputPin(1, Counter.T87());
		mxBR1.setInputPin(2, Counter.T89());
		mxBR1.setInputPin(3, Counter.T8C());

		ldBR.setInputPin(0, Counter.T83());
		ldBR.setInputPin(1, Counter.T85());
		ldBR.setInputPin(2, Counter.T87());
		ldBR.setInputPin(3, Counter.T89());
		ldBR.setInputPin(4, Counter.T8B());
		ldBR.setInputPin(5, Counter.T8C());

	}
	public static Pin ldAB() {
		return ldAB.getOut(0);
	}
	public static Pin shr() {
		return Counter.T54();
	}
	public static Pin shl() {
		return Counter.T56();
	}
	public static Pin AB1out() {
		return Counter.T3C();
	}
	public static Pin AB2out() {
		return Counter.T38();
	}
	public static Pin ldBB() {
		return ldBB.getOut(0);
	}
	public static Pin BBout() {
		return Counter.T34();
	}
	public static Pin ldAW() {
		return Counter.T36();
	}
	public static Pin AW1out() {
		return Counter.T45();
	}
	public static Pin AW2out() {
		return AW2out.getOut(0);
	}
	public static Pin mxBWH() {
		return Counter.T1E();
	}
		public static Pin ldBWH() {
		return ldBWH.getOut(0);
	}
	public static Pin ldBWL() {
		return ldBWL.getOut(0);
	}
	public static Pin BWout() {
		return BWout.getOut(0);
	}
	public static Pin clPSWI() {
		return clPSWI.getOut(0);
	}
	public static Pin clPSWT() {
		return clPSWT.getOut(0);
	}
	public static Pin stPSWI() {
		return Counter.T31();
	}
	public static Pin stPSWT() {
		return Counter.T33();
	}
	public static Pin ldL() {
		return Counter.T8B();
	}
	public static Pin ldN() {
		return ldN.getOut(0);
	}
	public static Pin ldZ() {
		return ldZ.getOut(0);
	}
	public static Pin ldC() {
		return ldC.getOut(0);
	}
	public static Pin ldV() {
		return ldV.getOut(0);
	}
	public static Pin PSWout() {
		return PSWout.getOut(0);
	}
	public static Pin ldPSWL() {
		return Counter.T6B();
	}
	public static Pin ldPSWH() {
		return Counter.T68();
	}
	public static Pin clSTART() {
		return Counter.T2F();
	}
	public static Pin add() {
		return Counter.T48();
	}
	public static Pin sub() {
		return Counter.T4A();
	}
	public static Pin and() {
		return Counter.T4C();
	}
	public static Pin or() {
		return Counter.T4E();
	}
	public static Pin xor() {
		return Counter.T50();
	}
	public static Pin not() {
		return Counter.T52();
	}
	public static Pin ALUout() {
		return ALUout.getOut(0);
	}
	public static Pin stPRINS() {
		return Counter.T5C();
	}
	public static Pin clPRINS() {
		return Counter.T83();
	}
	public static Pin stPRCOD() {
		return Counter.T07();
	}
	public static Pin clPRCOD() {
		return Counter.T85();
	}
	public static Pin stPRADR() {
		return Counter.T0E();
	}
	public static Pin clPRADR() {
		return Counter.T87();
	}
	public static Pin clPRINM() {
		return Counter.T89();
	}
	public static Pin clINTR() {
		return Counter.T8B();
	}
	public static Pin ldIVTP() {
		return Counter.T46();
	}
	public static Pin IVTPout() {
		return Counter.T8D();
	}
	public static Pin IVTDSPout() {
		return Counter.T8D();
	}
	public static Pin mxBR0() {
		return Counter.T8B();
	}
	public static Pin mxBR1() {
		return mxBR1.getOut(0);
	}
	public static Pin ldBR() {
		return ldBR.getOut(0);	
	}
}
