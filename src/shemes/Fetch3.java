package shemes;

import gui.*;
import components.*;

public class Fetch3 {
	public static OR ORgropr;
	public static OR ORgradr;
	public static AND ANDgradr;
	public static OR ORI1;
	public static OR ORI2_brnch;
	public static AND ANDI2_arlog;
	public static OR ORI2;
	public static OR ORI3_jump;
	public static OR ORI3_arlog;
	public static AND ANDI3_arlog;
	public static OR ORI3;
	public static AND ANDI4;
	public static OR ORstore;
	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void init() {
		ORgropr = new OR(209);

		ORgradr = new OR();
		ANDgradr = new AND();

		ORI1 = new OR();

		ORI2_brnch = new OR();

		ANDI2_arlog = new AND();

		ORI2 = new OR();

		ORI3_jump = new OR();

		ANDI3_arlog = new AND();
		ORI3_arlog = new OR();

		ORI3 = new OR();

		ANDI4 = new AND();

		ORstore = new OR();

	}

	public static void connect() {

		Pin[] g0 = Fetch2.G0_OP_16_63();
		for (int i = 0; i < 48; i++) {
			ORgropr.setInputPin(i, g0[i]);
		}
		Pin[] g1 = Fetch2.G1_OP_3_63();
		for (int i = 0; i < 61; i++) {
			ORgropr.setInputPin(48 + i, g1[i]);
		}
		Pin[] g2 = Fetch2.G2_OP_18_63();
		for (int i = 0; i < 46; i++) {
			ORgropr.setInputPin(109 + i, g2[i]);
		}
		Pin[] g3 = Fetch2.G3_OP_10_63();
		for (int i = 0; i < 54; i++) {
			ORgropr.setInputPin(155 + i, g3[i]);
		}

		ORgradr.setInputPin(0, Fetch2.ST());
		ORgradr.setInputPin(1, Fetch2.STW());
		ANDgradr.setInputPin(0, ORgradr.getOut(0));
		ANDgradr.setInputPin(1, Fetch2.immed());

		ORI1.setInputPin(0, Fetch2.G2());
		ORI1.setInputPin(1, Fetch2.NOT());

		ORI2_brnch.setInputPin(0, Fetch2.G0());
		ORI2_brnch.setInputPin(1, Fetch2.INT());

		ANDI2_arlog.setInputPin(0, Fetch2.G3());
		ANDI2_arlog.setInputPin(1, Fetch2.regdir());

		ORI2.setInputPin(0, ANDI2_arlog.getOut(0));
		ORI2.setInputPin(1, ORI2_brnch.getOut(0));

		ORI3_jump.setInputPin(0, Fetch2.JSR());
		ORI3_jump.setInputPin(1, Fetch2.JMP());

		ORI3_arlog.setInputPin(0, Fetch2.pcrel());
		ORI3_arlog.setInputPin(1, Fetch2.immed());
		ANDI3_arlog.setInputPin(0, Fetch2.G3());
		ANDI3_arlog.setInputPin(1, ORI3_arlog.getOut(0));

		ORI3.setInputPin(0, ANDI3_arlog.getOut(0));
		ORI3.setInputPin(1, ORI3_jump.getOut(0));

		ANDI4.setInputPin(0, Fetch2.G3());
		ANDI4.setInputPin(1, Fetch2.regindpom());

		ORstore.setInputPin(0, Fetch2.STW());
		ORstore.setInputPin(1, Fetch2.ST());

	}

	public static Pin gropr() {
		return ORgropr.getOut(0);
	}

	public static Pin gradr() {
		return ANDgradr.getOut(0);
	}

	public static Pin I1() {
		return ORI1.getOut(0);
	}

	public static Pin I2_brnch() {
		return ORI2_brnch.getOut(0);
	}

	public static Pin I2_arlog() {
		return ANDI2_arlog.getOut(0);
	}

	public static Pin I2() {
		return ORI2.getOut(0);
	}

	public static Pin I3_jump() {
		return ORI3_jump.getOut(0);
	}

	public static Pin I3_arlog() {
		return ANDI3_arlog.getOut(0);
	}

	public static Pin I3() {
		return ORI3.getOut(0);
	}

	public static Pin I4() {
		return ANDI4.getOut(0);
	}

	public static Pin store() {
		return ORstore.getOut(0);
	}

}
