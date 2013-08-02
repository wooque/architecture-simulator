package shemes;

import gui.*;
import components.*;

public class Adr {
	public static IntToInt DBToGPRAR;
	public static REG GPRAR;
	public static GPR GPRegs; // Izmenjeno
	public static TSB TSBGPRDout;
	public static TSB TSBGPRS1out;
	public static REG SP;
	public static TSB TSBSP1out;
	public static ADD ADDadr;
	public static REG PR;
	public static TSB TSBPRout;

	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void init() {
		DBToGPRAR = new IntToInt(16, 6);

		GPRAR = new REG(1, "GPRAR");
		GPRAR.getOut(0).setIsInt();
		GPRAR.getOut(0).setNumOfLines(6);

		GPRegs = new GPR(64);
		GPRegs.getOut(0).setNumOfLines(16);

		TSBGPRDout = new TSB();
		TSBGPRDout.getOut(0).setNumOfLines(16);

		TSBGPRS1out = new TSB();
		TSBGPRS1out.getOut(0).setNumOfLines(16);

		SP = new REG(1, "SP");
		SP.getOut(0).setIsInt();
		SP.getOut(0).setNumOfLines(16);
		SP.initVal(4096);//1000h

		TSBSP1out = new TSB();
		TSBSP1out.getOut(0).setNumOfLines(16);

		ADDadr = new ADD();
		ADDadr.getOut(0).setIsInt();
		ADDadr.getOut(0).setNumOfLines(16);

		PR = new REG(1, "PR");
		PR.getOut(0).setIsInt();
		PR.getOut(0).setNumOfLines(16);

		TSBPRout = new TSB();
		TSBPRout.getOut(0).setNumOfLines(16);

	}

	public static void connect() {
		DBToGPRAR.setInputPin(0, Bus1.DB());

		GPRAR.setInputPin(0, DBToGPRAR.getOut(0));
		GPRAR.setPinLd(Oper1.ldGPRAR());

		GPRegs.setAdressPin(GPRAR.getOut(0));
		GPRegs.setInputDataPin(Bus1.S1B());
		GPRegs.setWrite(Oper1.wrGPR());
		GPRegs.setRead(Oper1.rdGPR());

		TSBGPRDout.setInputPin(0, GPRegs.getOut(0));
		TSBGPRDout.setCtrl(Oper1.GPRDout());
		Bus1.addOnDB(TSBGPRDout.getOut(0));

		TSBGPRS1out.setInputPin(0, GPRegs.getOut(0));
		TSBGPRS1out.setCtrl(Oper1.GPR1out());
		Bus1.addOnS1B(TSBGPRS1out.getOut(0));

		SP.setInputPin(0, Bus1.DB());
		SP.setPinInc(Oper1.incSP());
		SP.setPinDec(Oper1.decSP());
		SP.setPinLd(Oper1.ldSP());

		TSBSP1out.setInputPin(0, SP.getOut(0));
		TSBSP1out.setCtrl(Oper1.SP1out());
		Bus1.addOnS1B(TSBSP1out.getOut(0));

		ADDadr.setPinA(Bus1.S1B());
		ADDadr.setPinB(Bus1.S2B());

		PR.setInputPin(0, ADDadr.getOut(0));
		PR.setPinLd(Oper1.ldPR());

		TSBPRout.setInputPin(0, PR.getOut(0));
		TSBPRout.setCtrl(Oper1.PRout());
		Bus1.addOnDB(TSBPRout.getOut(0));

	}

	public static Pin SP() {
		return SP.getOut(0);
	}

	public static Pin PR() {
		return PR.getOut(0);
	}

	public static Pin GPRAR() {
		return GPRAR.getOut(0);
	}

	public static int readGPR(int adress) {
		return GPRegs.read(adress);
	}

	public static Pin GPRDout() {
		return TSBGPRDout.getOut(0);
	}

	public static Pin GPRS1out() {
		return TSBGPRS1out.getOut(0);
	}

	public static Pin SP1out() {
		return TSBSP1out.getOut(0);
	}

	public static Pin PRout() {
		return TSBPRout.getOut(0);
	}

	public static GPR GPR() {
		return GPRegs;
	}

	public static REG RegGPRAR() {
		return GPRAR;
	}

	public static REG RegSP() {
		return SP;
	}

}
