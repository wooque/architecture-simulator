package shemes;

import gui.GuiScheme;

import components.*;

public class Exec4 {

	public static NOT NOT1;
	public static XOR XOR1;
	public static NOT NOT2;
	public static OR OR1;
	public static NOT NOT3;
	public static OR OR2;
	public static NOT NOT4;
	public static NOT NOT5;
	public static NOT NOT6;
	public static NOT NOT7;
	public static MP MX3;

	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	private Exec4(){
		
	}

	public static void init() {
		NOT1 = new NOT();
		XOR1 = new XOR();
		NOT2 = new NOT();
		OR1 = new OR();
		NOT3 = new NOT();
		OR2 = new OR();
		NOT4 = new NOT();
		NOT5 = new NOT();
		NOT6 = new NOT();
		NOT7 = new NOT();
		MX3 = new MP(16);

	}

	public static void connect() {

		NOT1.setInputPin(0, Exec2.PSWZ());
		XOR1.setInputPin(0, Exec2.PSWN());
		XOR1.setInputPin(1, Exec2.PSWV());
		NOT2.setInputPin(0, XOR1.getOut(0));
		OR1.setInputPin(0, XOR1.getOut(0));
		OR1.setInputPin(1, Exec2.PSWZ());
		NOT3.setInputPin(0, OR1.getOut(0));
		OR2.setInputPin(0, Exec2.PSWC());
		OR2.setInputPin(1, Exec2.PSWZ());
		NOT4.setInputPin(0, OR2.getOut(0));
		NOT5.setInputPin(0, Exec2.PSWC());
		NOT6.setInputPin(0, Exec2.PSWV());
		NOT7.setInputPin(0, Exec2.PSWN());

		MX3.setInputPin(0, Exec2.PSWZ());
		MX3.setInputPin(1, NOT1.getOut(0));
		MX3.setInputPin(2, Exec2.PSWN());
		MX3.setInputPin(3, NOT7.getOut(0));
		MX3.setInputPin(4, Exec2.PSWV());
		MX3.setInputPin(5, NOT6.getOut(0));
		MX3.setInputPin(6, Exec2.PSWC());
		MX3.setInputPin(7, NOT5.getOut(0));
		MX3.setInputPin(8, NOT3.getOut(0));
		MX3.setInputPin(9, NOT2.getOut(0));
		MX3.setInputPin(10, XOR1.getOut(0));
		MX3.setInputPin(11, OR1.getOut(0));
		MX3.setInputPin(12, NOT4.getOut(0));
		MX3.setInputPin(13, NOT5.getOut(0));
		MX3.setInputPin(14, Exec2.PSWC());
		MX3.setInputPin(15, OR2.getOut(0));
		MX3.setCtrl(0, Fetch1.IR24());
		MX3.setCtrl(1, Fetch1.IR25());
		MX3.setCtrl(2, Fetch1.IR26());
		MX3.setCtrl(3, Fetch1.IR27());

	}

	public static Pin brpom() {
		return MX3.getOut(0);
	}
}
