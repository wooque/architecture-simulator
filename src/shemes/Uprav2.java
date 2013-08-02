package shemes;

import gui.GuiScheme;
import components.*;

public class Uprav2 {
	public static OR val00, val1A, val2D, val75, val8D;
	public static GuiScheme gui;
	
	public static GuiScheme getGui() {
		return gui;
	}
	public static void init(){
		val00=new OR(4);
		val1A=new OR();
		val2D=new OR(10);
		val75=new OR(28);
		val8D=new OR(5);
	}
	public static void connect(){
		val00.setInputPin(0, Counter.T00());
		val00.setInputPin(1, Counter.T2F());
		val00.setInputPin(2, Counter.T75());
		val00.setInputPin(3, Counter.T95());
		
		val1A.setInputPin(0, Counter.T10());
		val1A.setInputPin(1, Counter.T15());
		
		val2D.setInputPin(0, Counter.T08());
		val2D.setInputPin(1, Counter.T0F());
		val2D.setInputPin(2, Counter.T14());
		val2D.setInputPin(3, Counter.T1B());
		val2D.setInputPin(4, Counter.T1D());
		val2D.setInputPin(5, Counter.T1E());
		val2D.setInputPin(6, Counter.T20());
		val2D.setInputPin(7, Counter.T23());
		val2D.setInputPin(8, Counter.T27());
		val2D.setInputPin(9, Counter.T2B());
		
		val75.setInputPin(0, Counter.T07());
		val75.setInputPin(1, Counter.T0E());
		val75.setInputPin(2, Counter.T2E());
		val75.setInputPin(3, Counter.T30());
		val75.setInputPin(4, Counter.T31());
		val75.setInputPin(5, Counter.T32());
		val75.setInputPin(6, Counter.T33());
		val75.setInputPin(7, Counter.T35());
		val75.setInputPin(8, Counter.T36());
		val75.setInputPin(9, Counter.T3B());
		val75.setInputPin(10, Counter.T3C());
		val75.setInputPin(11, Counter.T44());
		val75.setInputPin(12, Counter.T45());
		val75.setInputPin(13, Counter.T46());
		val75.setInputPin(14, Counter.T47());
		val75.setInputPin(15, Counter.T49());
		val75.setInputPin(16, Counter.T4B());
		val75.setInputPin(17, Counter.T4D());
		val75.setInputPin(18, Counter.T4F());
		val75.setInputPin(19, Counter.T51());
		val75.setInputPin(20, Counter.T53());
		val75.setInputPin(21, Counter.T55());
		val75.setInputPin(22, Counter.T57());
		val75.setInputPin(23, Counter.T58());
		val75.setInputPin(24, Counter.T5A());
		val75.setInputPin(25, Counter.T5B());
		val75.setInputPin(26, Counter.T63());
		val75.setInputPin(27, Counter.T5C());
		
		val8D.setInputPin(0, Counter.T83());
		val8D.setInputPin(1, Counter.T85());
		val8D.setInputPin(2, Counter.T87());
		val8D.setInputPin(3, Counter.T89());
		val8D.setInputPin(4, Counter.T8B());
		
	}
	public static Pin val01(){
		return Counter.T01();
	}
	public static Pin val04(){
		return Counter.T04();
	}
	public static Pin val08(){
		return Counter.T06();
	}
	public static Pin val0B(){
		return Counter.T0B();
	}
	public static Pin val0F(){
		return Counter.T0D();
	}
	public static Pin val13(){
		return Counter.T13();
	}
	public static Pin val18(){
		return Counter.T18();
	}
	public static Pin val1E(){
		return Counter.T1C();
	}
	public static Pin val24(){
		return Counter.T21();
	}
	public static Pin val25(){
		return Counter.T25();
	}
	public static Pin val28(){
		return Counter.T26();
	}
	public static Pin val2A(){
		return Counter.T2A();
	}
	public static Pin val3A(){
		return Counter.T3A();
	}
	public static Pin val3C(){
		return Counter.T37();
	}
	public static Pin val40(){
		return Counter.T40();
	}
	public static Pin val43(){
		return Counter.T43();
	}
	public static Pin val45(){
		return Counter.T3D();
	}
	public static Pin val5F(){
		return Counter.T5F();
	}
	public static Pin val62(){
		return Counter.T62();
	}
	public static Pin val67(){
		return Counter.T67();
	}
	public static Pin val6A(){
		return Counter.T6A();
	}
	public static Pin val6F(){
		return Counter.T6F();
	}
	public static Pin val72(){
		return Counter.T72();
	}
	public static Pin val78(){
		return Counter.T78();
	}
	public static Pin val7B(){
		return Counter.T7B();
	}
	public static Pin val7E(){
		return Counter.T7E();
	}
	public static Pin val81(){
		return Counter.T81();
	}
	public static Pin val84(){
		return Counter.T82();
	}
	public static Pin val86(){
		return Counter.T84();
	}
	public static Pin val88(){
		return Counter.T86();
	}
	public static Pin val8A(){
		return Counter.T88();
	}
	public static Pin val8C(){
		return Counter.T8A();
	}
	public static Pin val90(){
		return Counter.T90();
	}
	public static Pin val93(){
		return Counter.T93();
	}
	public static Pin val00(){
		return val00.getOut(0);
	}
	public static Pin val1A(){
		return val1A.getOut(0);
	}
	public static Pin val2D(){
		return val2D.getOut(0);
	}
	public static Pin val75(){
		return val75.getOut(0);
	}
	public static Pin val8D(){
		return val8D.getOut(0);
	}
}
