package shemes;

import gui.GuiScheme;
import components.*;

public class Arbitary {
	
	static CD BRCD;
	static DC BGDC;
	//Pinovi sa kojih bi trebalo da dolaze signali sa periferija
	//Posto one ne postoje bice kodovani da su uvek false
	private static Pin BR2,BR3,BR4;
	
	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}
	
private Arbitary(){
		
	}
	
	public static void init(){
		BRCD=new CD(4);
		BGDC=new DC(2);
		BR2=new Pin(false);
		BR3=new Pin(false);
		BR4=new Pin(false);
	}
	
	public static void connect(){
		
		BRCD.setInputPin(0, Bus3.BR1());
		BRCD.setInputPin(1, BR2);
		BRCD.setInputPin(2, BR3);
		BRCD.setInputPin(3, BR4);
		
		BGDC.setInputPin(0, BRCD.getOut(0));
		BGDC.setInputPin(1, BRCD.getOut(1));
		
	}
	
	public static Pin BG_IN1(){
		return BGDC.getOut(0);
	}
	//ne koriste se nigde, jer nema periferija
	//ali mozda u buducnosti...
	public static Pin BG_IN2(){
		return BGDC.getOut(1);
	}
	public static Pin BG_IN3(){
		return BGDC.getOut(2);
	}
	public static Pin BG_IN4(){
		return BGDC.getOut(3);
	}
	
}
