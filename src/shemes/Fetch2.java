package shemes;

import gui.*;
import components.*;

public class Fetch2 {
	public static DC DC1;
	public static DC DC2;
	public static DC DC3;
	public static DC DC4;
	public static DC DC5;
	public static DC DC6;
	//public static AND ANDDC6;
	//public static NOT NOTDC6;
	public static OR ORDC6;
	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void init() {

		DC1 = new DC(2);
		DC2 = new DC(6);
		DC3 = new DC(6);
		DC4 = new DC(6);
		DC5 = new DC(6);
		DC6 = new DC(2);
		//ANDDC6=new AND();
		//NOTDC6=new NOT();
		ORDC6=new OR(9);
	}

	public static void connect() {

		DC1.setE(Exec2.START());
		DC1.setInputPin(1, Fetch1.IR31());
		DC1.setInputPin(0, Fetch1.IR30());

		DC2.setE(DC1.getOut(0));
		DC2.setInputPin(5, Fetch1.IR29());
		DC2.setInputPin(4, Fetch1.IR28());
		DC2.setInputPin(3, Fetch1.IR27());
		DC2.setInputPin(2, Fetch1.IR26());
		DC2.setInputPin(1, Fetch1.IR25());
		DC2.setInputPin(0, Fetch1.IR24());

		DC3.setE(DC1.getOut(1));
		DC3.setInputPin(5, Fetch1.IR29());
		DC3.setInputPin(4, Fetch1.IR28());
		DC3.setInputPin(3, Fetch1.IR27());
		DC3.setInputPin(2, Fetch1.IR26());
		DC3.setInputPin(1, Fetch1.IR25());
		DC3.setInputPin(0, Fetch1.IR24());

		DC4.setE(DC1.getOut(2));
		DC4.setInputPin(5, Fetch1.IR29());
		DC4.setInputPin(4, Fetch1.IR28());
		DC4.setInputPin(3, Fetch1.IR27());
		DC4.setInputPin(2, Fetch1.IR26());
		DC4.setInputPin(1, Fetch1.IR25());
		DC4.setInputPin(0, Fetch1.IR24());

		DC5.setE(DC1.getOut(3));
		DC5.setInputPin(5, Fetch1.IR29());
		DC5.setInputPin(4, Fetch1.IR28());
		DC5.setInputPin(3, Fetch1.IR27());
		DC5.setInputPin(2, Fetch1.IR26());
		DC5.setInputPin(1, Fetch1.IR25());
		DC5.setInputPin(0, Fetch1.IR24());

		
		//NOTDC6.setInputPin(0, Fetch2.NOT());
		//ANDDC6.setInputPin(0, NOTDC6.getOut(0));
		//ANDDC6.setInputPin(1, Fetch2.G3());
		ORDC6.setInputPin(0, Fetch2.LD());
		ORDC6.setInputPin(1, Fetch2.LDW());
		ORDC6.setInputPin(2, Fetch2.ST());
		ORDC6.setInputPin(3, Fetch2.STW());
		ORDC6.setInputPin(4, Fetch2.ADD());
		ORDC6.setInputPin(5, Fetch2.SUB());
		ORDC6.setInputPin(6, Fetch2.AND());
		ORDC6.setInputPin(7, Fetch2.OR());
		ORDC6.setInputPin(8, Fetch2.XOR());
		DC6.setE(ORDC6.getOut(0));
		DC6.setInputPin(1, Fetch1.IR23());
		DC6.setInputPin(0, Fetch1.IR22());

	}
	public static Pin G0() {
		return DC1.getOut(0);
	}
	public static Pin G1() {
		return DC1.getOut(1);
	}
	public static Pin G2() {
		return DC1.getOut(2);
	}
	public static Pin G3() {
		return DC1.getOut(3);
	}

	public static Pin BEQL() {
		return DC2.getOut(0);
	}

	public static Pin BNEQ() {
		return DC2.getOut(1);
	}

	public static Pin BNEG() {
		return DC2.getOut(2);
	}

	public static Pin BNNG() {
		return DC2.getOut(3);
	}

	public static Pin BOVF() {
		return DC2.getOut(4);
	}

	public static Pin BNVF() {
		return DC2.getOut(5);
	}

	public static Pin BCR() {
		return DC2.getOut(6);
	}

	public static Pin BNCR() {
		return DC2.getOut(7);
	}

	public static Pin BGRT() {
		return DC2.getOut(8);
	}

	public static Pin BGRE() {
		return DC2.getOut(9);
	}

	public static Pin BLSS() {
		return DC2.getOut(10);
	}

	public static Pin BLEQ() {
		return DC2.getOut(11);
	}

	public static Pin BGRTU() {
		return DC2.getOut(12);
	}

	public static Pin BGREU() {
		return DC2.getOut(13);
	}

	public static Pin BLSSU() {
		return DC2.getOut(14);
	}

	public static Pin BLEQU() {
		return DC2.getOut(15);
	}

	public static Pin[] G0_OP_16_63() {
		Pin[] niz = new Pin[48];
		for (int i = 0; i < 48; i++)
			niz[i] = DC2.getOut(16 + i);
		return niz;

	}

	public static Pin JMP() {
		return DC3.getOut(0);
	}

	public static Pin JSR() {
		return DC3.getOut(1);
	}

	public static Pin INT() {
		return DC3.getOut(2);
	}

	public static Pin[] G1_OP_3_63() {
		Pin[] niz = new Pin[61];
		for (int i = 0; i < 61; i++)
			niz[i] = DC3.getOut(3 + i);
		return niz;
	}

	public static Pin RTS() {
		return DC4.getOut(0);
	}

	public static Pin RTI() {
		return DC4.getOut(1);
	}

	public static Pin ASR() {
		return DC4.getOut(2);
	}

	public static Pin LSR() {
		return DC4.getOut(3);
	}

	public static Pin ROR() {
		return DC4.getOut(4);
	}

	public static Pin RORC() {
		return DC4.getOut(5);
	}

	public static Pin ASL() {
		return DC4.getOut(6);
	}

	public static Pin LSL() {
		return DC4.getOut(7);
	}

	public static Pin ROL() {
		return DC4.getOut(8);
	}

	public static Pin ROLC() {
		return DC4.getOut(9);
	}

	public static Pin INTE() {
		return DC4.getOut(10);
	}

	public static Pin INTD() {
		return DC4.getOut(11);
	}

	public static Pin TRPE() {
		return DC4.getOut(12);
	}

	public static Pin TRPD() {
		return DC4.getOut(13);
	}

	public static Pin STIVTP() {
		return DC4.getOut(14);
	}

	public static Pin STSP() {
		return DC4.getOut(15);
	}

	public static Pin NOP() {
		return DC4.getOut(16);
	}

	public static Pin HALT() {
		return DC4.getOut(17);
	}

	public static Pin[] G2_OP_18_63() {
		Pin[] niz = new Pin[46];
		for (int i = 0; i < 46; i++)
			niz[i] = DC4.getOut(18 + i);
		return niz;

	}

	public static Pin LD() {
		return DC5.getOut(0);
	}

	public static Pin LDW() {
		return DC5.getOut(1);
	}

	public static Pin ST() {
		return DC5.getOut(2);
	}

	public static Pin STW() {
		return DC5.getOut(3);
	}

	public static Pin ADD() {
		return DC5.getOut(4);
	}

	public static Pin SUB() {
		return DC5.getOut(5);
	}

	public static Pin AND() {
		return DC5.getOut(6);
	}

	public static Pin OR() {
		return DC5.getOut(7);
	}

	public static Pin XOR() {
		return DC5.getOut(8);
	}

	public static Pin NOT() {
		return DC5.getOut(9);
	}

	public static Pin[] G3_OP_10_63() {
		Pin[] niz = new Pin[54];
		for (int i = 0; i < 54; i++)
			niz[i] = DC5.getOut(10 + i);
		return niz;
	}

	public static Pin regdir() {
		return DC6.getOut(0);
	}

	public static Pin regindpom() {
		return DC6.getOut(1);
	}

	public static Pin pcrel() {
		return DC6.getOut(2);
	}

	public static Pin immed() {
		return DC6.getOut(3);
	}
	
	

}
