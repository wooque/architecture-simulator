package schemes_new;

import gui.*;
import components.*;

public class Adr {

	public static IntToInt MDRToGPRAR;
	public static REG GPRAR;
	public static GPR GPR;
    public static IntToInt ABToMX1;
    public static MP MX1;

	public static REG SP;

	public static ADD ADD;
	public static REG CW;
    public static MP MX2;
    public static MP MX3;
    public static IntToInt IRToMX3;

	public static GuiScheme gui;

    private Adr() {

    }

	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui() {
        gui = new GuiScheme("./src/images_new/adr_1.png");
        // TO DO: add GUI
	}

	public static void init() {
		MDRToGPRAR = new IntToInt(8, 5);

		GPRAR = new REG(1, "GPRAR");
		GPRAR.getOut(0).setIsInt();
		GPRAR.getOut(0).setNumOfLines(5);

		GPR = new GPR(32);
		GPR.getOut(0).setNumOfLines(16);

        ABToMX1 = new IntToInt(8, 16);
        MX1 = new MP(2);
        
		SP = new REG(1, "SP");
		SP.getOut(0).setIsInt();
		SP.getOut(0).setNumOfLines(16);
		SP.initVal(4096);//1000h

		ADD = new ADD();
		ADD.getOut(0).setIsInt();
		ADD.getOut(0).setNumOfLines(16);

		CW = new REG(1, "CW");
		CW.getOut(0).setIsInt();
		CW.getOut(0).setNumOfLines(16);

        MX2 = new MP(4);
        MX3 = new MP(4);

        IRToMX3 = new IntToInt(8, 16, false, true);
	}

	public static void connect() {
        MDRToGPRAR.setInputPin(0, Bus1.MDR());

		GPRAR.setInputPin(0, MDRToGPRAR.getOut(0));
		GPRAR.setPinLd(Oper1.ldGPRAR());
        GPRAR.setPinInc(Oper1.incGPRAR());

        ABToMX1.setInputPin(0, Exec1.AB());
        MX1.setInputPin(0, ABToMX1.getOut(0));
        MX1.setInputPin(1, Exec1.AW());
        MX1.setCtrl(0, Oper1.mxGPR());

		GPR.setAdressPin(GPRAR.getOut(0));
		GPR.setInputDataPin(MX1.getOut(0));
		GPR.setWrite(Oper1.wrGPR());
        // TO DO: check if GPR support this
		GPR.setRead(new Pin(true));

		SP.setInputPin(0, Exec1.AW());
		SP.setPinInc(Oper1.incSP());
		SP.setPinDec(Oper1.decSP());
		SP.setPinLd(Oper1.ldSP());

		ADD.setPinA(MX2.getOut(0));
		ADD.setPinB(MX3.getOut(0));

        MX2.setInputPin(0, Intr3.IVTP());
        MX2.setInputPin(1, GPR.getOut(0));
        MX2.setInputPin(2, Fetch1.PC());
        MX2.setInputPin(3, CW.getOut(0));
        MX2.setCtrl(0, Oper1.mxADDA0);
        MX2.setCtrl(1, Oper1.mxADDA1);

		CW.setInputPin(0, ADD.getOut(0));
		CW.setPinLd(Oper1.ldCW());

        IRToMX3.setInputPin(0, Fetch1.IR23_16);

        MX3.setInputPin(0, Intr3.IVTDSP());
        MX3.setInputPin(1, Fetch1.IR15_0());
        MX3.setInputPin(2, GPR.getOut(0));
        MX3.setInputPin(3, IRToMX3.getOut(0));
        MX3.setCtrl(0, Oper1.mxADDB0);
        MX3.setCtrl(1, Oper1.mxADDB1);
	}

	public static Pin SP() {
		return SP.getOut(0);
	}

	public static Pin CW() {
		return CW.getOut(0);
	}

	public static Pin GPRAR() {
		return GPRAR.getOut(0);
	}

	public static int readGPR(int adress) {
		return GPR.read(adress);
	}

	public static Pin GPR() {
		return GPR.getOut(0);
	}

}
