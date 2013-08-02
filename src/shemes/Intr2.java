package shemes;

import gui.*;
import components.*;

public class Intr2 {

	public static AND AND1, AND2, AND3, AND4;
	public static OR OR1;
	public static CD CDP;
	public static CMP AB;
	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void init() {
		AND1 = new AND();
		AND2 = new AND();
		AND3 = new AND();
		AND4 = new AND(3);
		OR1 = new OR(3);
		CDP = new CD(4);
		AB = new CMP(2);
	}

	public static void connect() {
		AND1.setInputPin(0, Intr1.IMR3());
		AND1.setInputPin(1, Intr1.PRINTR3());

		AND2.setInputPin(0, Intr1.IMR2());
		AND2.setInputPin(1, Intr1.PRINTR2());

		AND3.setInputPin(0, Intr1.IMR1());
		AND3.setInputPin(1, Intr1.PRINTR1());

		CDP.setE(new Pin(true));
		CDP.setInputPin(0, new Pin(false));
		CDP.setInputPin(1, AND3.getOut(0));
		CDP.setInputPin(2, AND2.getOut(0));
		CDP.setInputPin(3, AND1.getOut(0));

		AB.setE(new Pin(true));
		AB.setPinA(0, CDP.getOut(0));
		AB.setPinA(1, CDP.getOut(1));
		AB.setPinB(0, Exec2.PSWL0());
		AB.setPinB(1, Exec2.PSWL1());

		OR1.setInputPin(0, AND1.getOut(0));
		OR1.setInputPin(1, AND2.getOut(0));
		OR1.setInputPin(2, AND3.getOut(0));

		AND4.setInputPin(0, OR1.getOut(0));
		AND4.setInputPin(1, AB.getOut(0));
		AND4.setInputPin(2, Exec2.PSWI());

	}

	public static Pin irm1() {
		return AND3.getOut(0);
	}

	public static Pin irm2() {
		return AND2.getOut(0);
	}

	public static Pin irm3() {
		return AND1.getOut(0);
	}

	public static Pin prl0() {
		return CDP.getOut(0);
	}

	public static Pin prl1() {
		return CDP.getOut(1);
	}

	public static Pin printr() {
		return AND4.getOut(0);
	}

}
