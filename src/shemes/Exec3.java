package shemes;

import gui.GuiScheme;

import components.*;

public class Exec3 {
	public static OR NOR1;
	public static AND NAND1;
	public static NOT ZNOT0;
	public static NOT ZNOT1;
	public static NOT ZNOT2;
	public static NOT ZNOT3;
	public static NOT ZNOT4;
	public static NOT ZNOT5;
	public static NOT ZNOT6;
	public static NOT ZNOT7;
	public static AND ZAND1;
	public static AND ZAND2;

	public static AND CAND1;
	public static AND CAND2;
	public static NOT CNOT1;
	public static OR COR1;
	public static AND CAND3;
	public static OR COR2;
	public static AND CAND4;
	public static OR COR3;

	public static NOT VNOT1;
	public static NOT VNOT2;
	public static AND VAND1;
	public static NOT VNOT3;
	public static AND VAND2;
	public static OR VOR1;
	public static AND VAND3;

	public static NOT VNOT4;
	public static AND VAND4;
	public static NOT VNOT5;
	public static NOT VNOT6;
	public static AND VAND5;
	public static OR VOR2;
	public static AND VAND6;
	public static OR VOR3;

	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	private Exec3(){
		
	}

	public static void init(){
		NOR1 = new OR(14);
		NAND1 = new AND();
		ZNOT0 = new NOT();
		ZNOT1 = new NOT();
		ZNOT2 = new NOT();
		ZNOT3 = new NOT();
		ZNOT4 = new NOT();
		ZNOT5 = new NOT();
		ZNOT6 = new NOT();
		ZNOT7 = new NOT();
		ZAND1 = new AND(8);
		ZAND2 = new AND();

		CAND1 = new AND();
		CNOT1 = new NOT();
		CAND2 = new AND();
		COR1 = new OR(4);
		CAND3 = new AND();
		COR2 = new OR(4);
		CAND4 = new AND();
		COR3 = new OR(4);

		VNOT1 = new NOT();
		VNOT2 = new NOT();
		VAND1 = new AND(3);
		VNOT3 = new NOT();
		VAND2 = new AND(3);
		VOR1 = new OR(2);
		VAND3 = new AND(2);

		VNOT4 = new NOT();
		VAND4 = new AND(3);
		VNOT5 = new NOT();
		VNOT6 = new NOT();
		VAND5 = new AND(3);
		VOR2 = new OR();
		VAND6 = new AND();
		VOR3 = new OR();

	}

	public static void connect() {

		NOR1.setInputPin(0, Fetch2.LD());
		NOR1.setInputPin(1, Fetch2.ADD());
		NOR1.setInputPin(2, Fetch2.SUB());
		NOR1.setInputPin(3, Fetch2.AND());
		NOR1.setInputPin(4, Fetch2.OR());
		NOR1.setInputPin(5, Fetch2.XOR());
		NOR1.setInputPin(6, Fetch2.ASR());
		NOR1.setInputPin(7, Fetch2.LSR());
		NOR1.setInputPin(8, Fetch2.ROR());
		NOR1.setInputPin(9, Fetch2.RORC());
		NOR1.setInputPin(10, Fetch2.ASL());
		NOR1.setInputPin(11, Fetch2.LSL());
		NOR1.setInputPin(12, Fetch2.ROL());
		NOR1.setInputPin(13, Fetch2.ROLC());

		NAND1.setInputPin(0, Exec1.AB7());
		NAND1.setInputPin(1, NOR1.getOut(0));

		ZNOT0.setInputPin(0, Exec1.AB0());
		ZNOT1.setInputPin(0, Exec1.AB1());
		ZNOT2.setInputPin(0, Exec1.AB2());
		ZNOT3.setInputPin(0, Exec1.AB3());
		ZNOT4.setInputPin(0, Exec1.AB4());
		ZNOT5.setInputPin(0, Exec1.AB5());
		ZNOT6.setInputPin(0, Exec1.AB6());
		ZNOT7.setInputPin(0, Exec1.AB7());

		ZAND1.setInputPin(0, ZNOT0.getOut(0));
		ZAND1.setInputPin(1, ZNOT1.getOut(0));
		ZAND1.setInputPin(2, ZNOT2.getOut(0));
		ZAND1.setInputPin(3, ZNOT3.getOut(0));
		ZAND1.setInputPin(4, ZNOT4.getOut(0));
		ZAND1.setInputPin(5, ZNOT5.getOut(0));
		ZAND1.setInputPin(6, ZNOT6.getOut(0));
		ZAND1.setInputPin(7, ZNOT7.getOut(0));

		ZAND2.setInputPin(0, NOR1.getOut(0));
		ZAND2.setInputPin(1, ZAND1.getOut(0));

		CAND1.setInputPin(0, Fetch2.ADD());
		CAND1.setInputPin(1, Exec1.C8());

		CNOT1.setInputPin(0, Exec1.C8());
		CAND2.setInputPin(0, Fetch2.SUB());
		CAND2.setInputPin(1, CNOT1.getOut(0));

		COR1.setInputPin(0, Fetch2.ASR());
		COR1.setInputPin(1, Fetch2.LSR());
		COR1.setInputPin(2, Fetch2.ROR());
		COR1.setInputPin(3, Fetch2.RORC());

		CAND3.setInputPin(0, COR1.getOut(0));
		CAND3.setInputPin(1, Exec1.AB0());

		COR2.setInputPin(0, Fetch2.ASL());
		COR2.setInputPin(1, Fetch2.LSL());
		COR2.setInputPin(2, Fetch2.ROL());
		COR2.setInputPin(3, Fetch2.ROLC());

		CAND4.setInputPin(0, COR2.getOut(0));
		CAND4.setInputPin(1, Exec1.AB7());

		COR3.setInputPin(0, CAND1.getOut(0));
		COR3.setInputPin(1, CAND2.getOut(0));
		COR3.setInputPin(2, CAND3.getOut(0));
		COR3.setInputPin(3, CAND4.getOut(0));

		VNOT1.setInputPin(0, Exec1.AB7());
		VNOT2.setInputPin(0, Exec1.BB7());
		VAND1.setInputPin(0, VNOT1.getOut(0));
		VAND1.setInputPin(1, VNOT2.getOut(0));
		VAND1.setInputPin(2, Exec1.ALU7());

		VNOT3.setInputPin(0, Exec1.ALU7());
		VAND2.setInputPin(0, Exec1.AB7());
		VAND2.setInputPin(1, Exec1.BB7());
		VAND2.setInputPin(2, VNOT3.getOut(0));

		VOR1.setInputPin(0, VAND1.getOut(0));
		VOR1.setInputPin(1, VAND2.getOut(0));

		VAND3.setInputPin(0, Fetch2.ADD());
		VAND3.setInputPin(1, VOR1.getOut(0));

		VNOT4.setInputPin(0, Exec1.AB7());
		VAND4.setInputPin(0, VNOT4.getOut(0));
		VAND4.setInputPin(1, Exec1.BB7());
		VAND4.setInputPin(2, Exec1.ALU7());

		VNOT5.setInputPin(0, Exec1.BB7());
		VNOT6.setInputPin(0, Exec1.ALU7());
		VAND5.setInputPin(0, Exec1.AB7());
		VAND5.setInputPin(1, VNOT5.getOut(0));
		VAND5.setInputPin(2, VNOT6.getOut(0));

		VOR2.setInputPin(0, VAND4.getOut(0));
		VOR2.setInputPin(1, VAND5.getOut(0));

		VAND6.setInputPin(0, Fetch2.SUB());
		VAND6.setInputPin(1, VOR2.getOut(0));

		VOR3.setInputPin(0, VAND3.getOut(0));
		VOR3.setInputPin(1, VAND6.getOut(0));

	}

	public static Pin N() {
		return NAND1.getOut(0);
	}

	public static Pin Z() {
		return ZAND2.getOut(0);
	}

	public static Pin C() {
		return COR3.getOut(0);
	}

	public static Pin V() {
		return VOR3.getOut(0);
	}

}
