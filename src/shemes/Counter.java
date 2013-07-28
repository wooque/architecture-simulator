package shemes;

import gui.GuiLabel;
import gui.GuiLine;
import gui.GuiScheme;

import java.awt.Point;
import java.util.ArrayList;

import components.*;

public class Counter {
	public static KMOPR kmopr;
	public static KMADR kmadr;
	public static KMBR kmbr;
	public static MP mp;
	public static REG CNT;
	public static OR cntOR;
	public static TSB cntTSB;
	public static NOT cntNOT;
	public static DC dc;
	private static Pin mpin3;
	private static IntToBools adapt;
	
	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui() {
		
		GuiLine line;									// Pomocna promenljiva
		gui=new GuiScheme("./src/images/brojacKoraka.png");		
		
		ArrayList<ArrayList<Point>> sections;
		ArrayList<Point> points;
		
		// Iz KMOPR u 2 ulaz MX
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(248,113));
		points.add(new Point(248,163));
		sections.add(points);
		line=new GuiLine(sections,Counter.KMOPR());
		gui.addLine(line);
		
		// Iz KMADR u 1 ulaz MX
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(388,113));
		points.add(new Point(388,137));
		points.add(new Point(276,137));
		points.add(new Point(276,164));
		sections.add(points);
		line=new GuiLine(sections,Counter.KMADR());
		gui.addLine(line);
		
		// Iz KMBR u 0 ulaz MX
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(527,113));
		points.add(new Point(527,146));
		points.add(new Point(304,146));
		points.add(new Point(304,163));
		sections.add(points);
		line=new GuiLine(sections,Counter.KMBR());
		gui.addLine(line);

		// Visetruki uslovni na osnovu nacina adresiranja
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(333,172));
		points.add(new Point(325,172));
		sections.add(points);
		line=new GuiLine(sections,Uprav1.bradr());
		gui.addLine(line);

		// Visetruki uslovni na osnovu operacije
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(333,190));
		points.add(new Point(325,190));
		sections.add(points);
		line=new GuiLine(sections,Uprav1.bropr());
		gui.addLine(line);
		
		// Iz multipleksera u brojac koraka
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(262,200));
		points.add(new Point(262,232));
		sections.add(points);
		line=new GuiLine(sections,Counter.mp.getOut(0));
		gui.addLine(line);

		// Iz brojaca u dekoder
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(262,269));
		points.add(new Point(262,302));
		sections.add(points);
		line=new GuiLine(sections,Counter.CNT());
		gui.addLine(line);
		
		// bradr u ILI kolo
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(418,235));
		points.add(new Point(410,235));
		sections.add(points);
		line=new GuiLine(sections,Uprav1.bradr());
		gui.addLine(line);
		
		// bropr u ILI kolo
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(418,246));
		points.add(new Point(410,246));
		sections.add(points);
		line=new GuiLine(sections,Uprav1.bropr());
		gui.addLine(line);
		
		// bruncnd u ILI kolo
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(418,256));
		points.add(new Point(410,256));
		sections.add(points);
		line=new GuiLine(sections,Uprav1.bruncnd());
		gui.addLine(line);
		
		// brcnd u ILI kolo
		// 
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(418,267));
		points.add(new Point(410,267));
		sections.add(points);
		line=new GuiLine(sections,Uprav1.brcnd());
		gui.addLine(line);
		
		// izlaz ILI kola
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(387,251));
		points.add(new Point(381,251));
		points.add(new Point(381,242));
		points.add(new Point(326,242));
		sections.add(points);
		points=new ArrayList<Point>();
		points.add(new Point(381,252));
		points.add(new Point(381,260));
		points.add(new Point(375,260));
		sections.add(points);
		line=new GuiLine(sections,Counter.cntOR.getOut(0));
		gui.addLine(line);

		// Izlaz NOT kola
		//
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(348,260));
		points.add(new Point(326,260));
		sections.add(points);
		line=new GuiLine(sections,Counter.cntNOT.getOut(0));
		gui.addLine(line);
		
		
		// 
		// DC do operacionog bloka:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(262,360));
		points.add(new Point(262,390));
		points.add(new Point(234,390));
		points.add(new Point(234,407));
		sections.add(points);
		line=new GuiLine(sections,CNT.getOut(0));
		gui.addLine(line);

		// 
		// DC do upravljackog bloka:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(263,390));
		points.add(new Point(489,390));
		points.add(new Point(489,407));
		sections.add(points);
		line=new GuiLine(sections,CNT.getOut(0));
		gui.addLine(line);

		//dodate i sitne linije vezane za blokove jer tako bi bi lepse izgledalo:
		
		// 
		// NOP:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(205,59));
		points.add(new Point(205,67));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.NOP());
		gui.addLine(line);

		// 
		// INTE:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(219,59));
		points.add(new Point(219,67));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.INTE());
		gui.addLine(line);

		// 
		// RTS:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(292,59));
		points.add(new Point(292,67));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.RTS());
		gui.addLine(line);

		// 
		// regdir:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(344,58));
		points.add(new Point(344,67));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.regdir());
		gui.addLine(line);

		// 
		// reginddisp:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(358,59));
		points.add(new Point(358,67));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.regindpom());
		gui.addLine(line);

		// 
		// imm:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(431,59));
		points.add(new Point(431,67));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.immed());
		gui.addLine(line);

		// 
		// VAL00:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(484,59));
		points.add(new Point(484,67));
		sections.add(points);
		line=new GuiLine(sections,Uprav2.val00());
		gui.addLine(line);

		// 
		// VAL01:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(498,57));
		points.add(new Point(498,67));
		sections.add(points);
		line=new GuiLine(sections,Uprav2.val01());
		gui.addLine(line);

		// 
		// val93:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(569,59));
		points.add(new Point(569,67));
		sections.add(points);
		line=new GuiLine(sections,Uprav2.val93());
		gui.addLine(line);

		// 
		// START:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(409,415));
		points.add(new Point(422,415));
		sections.add(points);
		line=new GuiLine(sections,Exec2.START());
		gui.addLine(line);

		// 
		// I1:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(409,429));
		points.add(new Point(422,429));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.I1());
		gui.addLine(line);

		// 
		// regdir donji:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(409,471));
		points.add(new Point(422,471));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.regdir());
		gui.addLine(line);

		// 
		// LDW:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(409,485));
		points.add(new Point(422,485));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.LDW());
		gui.addLine(line);

		// 
		// store:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(409,499));
		points.add(new Point(422,499));
		sections.add(points);
		line=new GuiLine(sections,Fetch3.store());
		gui.addLine(line);

		// 
		// brpom:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(409,513));
		points.add(new Point(422,513));
		sections.add(points);
		line=new GuiLine(sections,Exec4.brpom());
		gui.addLine(line);

		// 
		// prekid:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(409,527));
		points.add(new Point(422,527));
		sections.add(points);
		line=new GuiLine(sections,Intr1.prekid());
		gui.addLine(line);

		// 
		// bradr:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(440,544));
		points.add(new Point(440,535));
		sections.add(points);
		line=new GuiLine(sections,Uprav1.bradr());
		gui.addLine(line);

		// 
		// bropr:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(454,544));
		points.add(new Point(454,535));
		sections.add(points);
		line=new GuiLine(sections,Uprav1.bropr());
		gui.addLine(line);

		// 
		// bruncnd:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(468,544));
		points.add(new Point(468,535));
		sections.add(points);
		line=new GuiLine(sections,Uprav1.bruncnd());
		gui.addLine(line);

		// 
		// brcnd:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(482,544));
		points.add(new Point(482,535));
		sections.add(points);
		line=new GuiLine(sections,Uprav1.brcnd());
		gui.addLine(line);

		// 
		// VAL00:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(496,544));
		points.add(new Point(496,535));
		sections.add(points);
		line=new GuiLine(sections,Uprav2.val00());
		gui.addLine(line);

		// 
		// VAL01:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(510,544));
		points.add(new Point(510,535));
		sections.add(points);
		line=new GuiLine(sections,Uprav2.val01());
		gui.addLine(line);

		// 
		// VAL93:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(538,544));
		points.add(new Point(538,535));
		sections.add(points);
		line=new GuiLine(sections,Uprav2.val93());
		gui.addLine(line);

		// 
		// CPUCLK:
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(192,251));
		points.add(new Point(198,251));
		sections.add(points);
		line=new GuiLine(sections,LogicalComponent.getCPUCLK());
		gui.addLine(line);

		//
		//

		//LABELE:
		
		gui.addLabel(new GuiLabel(258,124,kmopr.getOut(0)));
		gui.addLabel(new GuiLabel(398,124,kmadr.getOut(0)));
		gui.addLabel(new GuiLabel(537,124,kmbr.getOut(0)));
		gui.addLabel(new GuiLabel(272,214,mp.getOut(0)));
		gui.addLabel(new GuiLabel(272,283,CNT.getOut(0)));

	}
	
	private Counter(){
		
	}
	
	public static void init(){
		kmopr=new KMOPR();
		kmopr.getOut(0).setNumOfLines(8);
		kmadr=new KMADR();
		kmadr.getOut(0).setNumOfLines(8);
		kmbr=new KMBR();
		kmbr.getOut(0).setNumOfLines(8);
		mp=new MP(4);
		mp.getOut(0).setNumOfLines(8);
		mp.getOut(0).setIsInt();
		CNT=new REG(1,"CNT CPU");
		CNT.getOut(0).setNumOfLines(8);
		CNT.getOut(0).setIsInt();
		cntOR=new OR(4);
		cntTSB=new TSB();
		cntNOT=new NOT();
		dc=new DC(8);
		mpin3=new Pin(0,1);
		mpin3.setIsInt();
		adapt=new IntToBools(1, 8);
	}
	public static void connect(){
		kmopr.setInputPin(0, Fetch2.NOP());
		kmopr.setInputPin(1, Fetch2.HALT());
		kmopr.setInputPin(2, Fetch2.INTD());
		kmopr.setInputPin(3, Fetch2.INTE());
		kmopr.setInputPin(4, Fetch2.TRPD());
		kmopr.setInputPin(5, Fetch2.TRPE());
		kmopr.setInputPin(6, Fetch2.LD());
		kmopr.setInputPin(7, Fetch2.LDW());
		kmopr.setInputPin(8, Fetch2.ST());
		kmopr.setInputPin(9, Fetch2.STW());
		kmopr.setInputPin(10, Fetch2.STIVTP());
		kmopr.setInputPin(11, Fetch2.STSP());
		kmopr.setInputPin(12, Fetch2.ADD());
		kmopr.setInputPin(13, Fetch2.SUB());
		kmopr.setInputPin(14, Fetch2.AND());
		kmopr.setInputPin(15, Fetch2.OR());
		kmopr.setInputPin(16, Fetch2.XOR());
		kmopr.setInputPin(17, Fetch2.NOT());
		kmopr.setInputPin(18, Fetch2.ASR());
		kmopr.setInputPin(19, Fetch2.LSR());
		kmopr.setInputPin(20, Fetch2.ROR());
		kmopr.setInputPin(21, Fetch2.RORC());
		kmopr.setInputPin(22, Fetch2.ASL());
		kmopr.setInputPin(23, Fetch2.LSL());
		kmopr.setInputPin(24, Fetch2.ROL());
		kmopr.setInputPin(25, Fetch2.ROLC());
		kmopr.setInputPin(26, Fetch2.BEQL());
		kmopr.setInputPin(27, Fetch2.BNEQ());
		kmopr.setInputPin(28, Fetch2.BNEG());
		kmopr.setInputPin(29, Fetch2.BNNG());
		kmopr.setInputPin(30, Fetch2.BOVF());
		kmopr.setInputPin(31, Fetch2.BNVF());
		kmopr.setInputPin(32, Fetch2.BCR());
		kmopr.setInputPin(33, Fetch2.BNCR());
		kmopr.setInputPin(34, Fetch2.BGRE());
		kmopr.setInputPin(35, Fetch2.BLSS());
		kmopr.setInputPin(36, Fetch2.BLEQ());
		kmopr.setInputPin(37, Fetch2.BGRTU());
		kmopr.setInputPin(38, Fetch2.BGREU());
		kmopr.setInputPin(39, Fetch2.BLSSU());
		kmopr.setInputPin(40, Fetch2.BLEQU());
		kmopr.setInputPin(41, Fetch2.JMP());
		kmopr.setInputPin(42, Fetch2.INT());
		kmopr.setInputPin(43, Fetch2.JSR());
		kmopr.setInputPin(44, Fetch2.RTI());
		kmopr.setInputPin(45, Fetch2.RTS());
		
		kmadr.setInputPin(0, Fetch2.regdir());
		kmadr.setInputPin(1, Fetch2.regindpom());
		kmadr.setInputPin(2, Fetch2.pcrel());
		kmadr.setInputPin(3, Fetch2.immed());
		
		kmbr.setInputPin(0, Uprav2.val00());
		kmbr.setInputPin(1, Uprav2.val01());
		kmbr.setInputPin(2, Uprav2.val04());
		kmbr.setInputPin(3, Uprav2.val08());
		kmbr.setInputPin(4, Uprav2.val0B());
		kmbr.setInputPin(5, Uprav2.val0F());
		kmbr.setInputPin(6, Uprav2.val13());
		kmbr.setInputPin(7, Uprav2.val18());
		kmbr.setInputPin(8, Uprav2.val1A());
		kmbr.setInputPin(9, Uprav2.val1E());
		kmbr.setInputPin(10, Uprav2.val24());
		kmbr.setInputPin(11, Uprav2.val25());
		kmbr.setInputPin(12, Uprav2.val28());
		kmbr.setInputPin(13, Uprav2.val2A());
		kmbr.setInputPin(14, Uprav2.val2D());
		kmbr.setInputPin(15, Uprav2.val3A());
		kmbr.setInputPin(16, Uprav2.val3C());
		kmbr.setInputPin(17, Uprav2.val40());
		kmbr.setInputPin(18, Uprav2.val43());
		kmbr.setInputPin(19, Uprav2.val45());
		kmbr.setInputPin(20, Uprav2.val5F());
		kmbr.setInputPin(21, Uprav2.val62());
		kmbr.setInputPin(22, Uprav2.val67());
		kmbr.setInputPin(23, Uprav2.val6A());
		kmbr.setInputPin(24, Uprav2.val6F());
		kmbr.setInputPin(25, Uprav2.val72());
		kmbr.setInputPin(26, Uprav2.val75());
		kmbr.setInputPin(27, Uprav2.val78());
		kmbr.setInputPin(28, Uprav2.val7B());
		kmbr.setInputPin(29, Uprav2.val7E());
		kmbr.setInputPin(30, Uprav2.val81());
		kmbr.setInputPin(31, Uprav2.val84());
		kmbr.setInputPin(32, Uprav2.val86());
		kmbr.setInputPin(33, Uprav2.val88());
		kmbr.setInputPin(34, Uprav2.val8A());
		kmbr.setInputPin(35, Uprav2.val8C());
		kmbr.setInputPin(36, Uprav2.val8D());
		kmbr.setInputPin(37, Uprav2.val90());
		kmbr.setInputPin(38, Uprav2.val93());
		
		mp.setInputPin(0, kmbr.getOut(0));
		mp.setInputPin(1, kmadr.getOut(0));
		mp.setInputPin(2, kmopr.getOut(0));
		mp.setInputPin(3, mpin3);
		mp.setCtrl(0, Uprav1.bradr());
		mp.setCtrl(1, Uprav1.bropr());
		
		CNT.setInputPin(0, mp.getOut(0));
		CNT.setPinLd(cntOR.getOut(0));
		CNT.setPinInc(cntNOT.getOut(0));
		
		cntOR.setInputPin(0, Uprav1.bradr());
		cntOR.setInputPin(1, Uprav1.bropr());
		cntOR.setInputPin(2, Uprav1.bruncnd());
		cntOR.setInputPin(3, Uprav1.brcnd());
		
		cntNOT.setInputPin(0, cntOR.getOut(0));
		
		adapt.setInputPin(0, CNT.getOut(0));
		
		dc.setInputPin(0, adapt.getOut(0));
		dc.setInputPin(1, adapt.getOut(1));
		dc.setInputPin(2, adapt.getOut(2));
		dc.setInputPin(3, adapt.getOut(3));
		dc.setInputPin(4, adapt.getOut(4));
		dc.setInputPin(5, adapt.getOut(5));
		dc.setInputPin(6, adapt.getOut(6));
		dc.setInputPin(7, adapt.getOut(7));
		
		
	}
	public static Pin KMADR(){
		return kmadr.getOut(0);
	}
	public static Pin KMOPR(){
		return kmopr.getOut(0);
	}
	public static Pin KMBR(){
		return kmbr.getOut(0);
	}
	public static Pin CNTLD(){
		return cntOR.getOut(0);
	}
	public static Pin CNTINC(){
		return cntNOT.getOut(0);
	}
	public static Pin CNT(){
		return CNT.getOut(0);
	}
	public static Pin T00(){
		return dc.getOut(0);
	}
	public static Pin T01(){
		return dc.getOut(1);
	}
	public static Pin T02(){
		return dc.getOut(2);
	}
	public static Pin T03(){
		return dc.getOut(3);
	}
	public static Pin T04(){
		return dc.getOut(4);
	}
	public static Pin T05(){
		return dc.getOut(5);
	}
	public static Pin T06(){
		return dc.getOut(6);
	}
	public static Pin T07(){
		return dc.getOut(7);
	}
	public static Pin T08(){
		return dc.getOut(8);
	}
	public static Pin T09(){
		return dc.getOut(9);
	}
	public static Pin T0A(){
		return dc.getOut(10);
	}
	public static Pin T0B(){
		return dc.getOut(11);
	}
	public static Pin T0C(){
		return dc.getOut(12);
	}
	public static Pin T0D(){
		return dc.getOut(13);
	}
	public static Pin T0E(){
		return dc.getOut(14);
	}
	public static Pin T0F(){
		return dc.getOut(15);
	}
	public static Pin T10(){
		return dc.getOut(16);
	}
	public static Pin T11(){
		return dc.getOut(17);
	}
	public static Pin T12(){
		return dc.getOut(18);
	}
	public static Pin T13(){
		return dc.getOut(19);
	}
	public static Pin T14(){
		return dc.getOut(20);
	}
	public static Pin T15(){
		return dc.getOut(21);
	}
	public static Pin T16(){
		return dc.getOut(22);
	}
	public static Pin T17(){
		return dc.getOut(23);
	}
	public static Pin T18(){
		return dc.getOut(24);
	}
	public static Pin T19(){
		return dc.getOut(25);
	}
	public static Pin T1A(){
		return dc.getOut(26);
	}
	public static Pin T1B(){
		return dc.getOut(27);
	}
	public static Pin T1C(){
		return dc.getOut(28);
	}
	public static Pin T1D(){
		return dc.getOut(29);
	}
	public static Pin T1E(){
		return dc.getOut(30);
	}
	public static Pin T1F(){
		return dc.getOut(31);
	}
	public static Pin T20(){
		return dc.getOut(32);
	}
	public static Pin T21(){
		return dc.getOut(33);
	}
	public static Pin T22(){
		return dc.getOut(34);
	}
	public static Pin T23(){
		return dc.getOut(35);
	}
	public static Pin T24(){
		return dc.getOut(36);
	}
	public static Pin T25(){
		return dc.getOut(37);
	}
	public static Pin T26(){
		return dc.getOut(38);
	}
	public static Pin T27(){
		return dc.getOut(39);
	}
	public static Pin T28(){
		return dc.getOut(40);
	}
	public static Pin T29(){
		return dc.getOut(41);
	}
	public static Pin T2A(){
		return dc.getOut(42);
	}
	public static Pin T2B(){
		return dc.getOut(43);
	}
	public static Pin T2C(){
		return dc.getOut(44);
	}
	public static Pin T2D(){
		return dc.getOut(45);
	}
	public static Pin T2E(){
		return dc.getOut(46);
	}
	public static Pin T2F(){
		return dc.getOut(47);
	}
	public static Pin T30(){
		return dc.getOut(48);
	}
	public static Pin T31(){
		return dc.getOut(49);
	}
	public static Pin T32(){
		return dc.getOut(50);
	}
	public static Pin T33(){
		return dc.getOut(51);
	}
	public static Pin T34(){
		return dc.getOut(52);
	}
	public static Pin T35(){
		return dc.getOut(53);
	}
	public static Pin T36(){
		return dc.getOut(54);
	}
	public static Pin T37(){
		return dc.getOut(55);
	}
	public static Pin T38(){
		return dc.getOut(56);
	}
	public static Pin T39(){
		return dc.getOut(57);
	}
	public static Pin T3A(){
		return dc.getOut(58);
	}
	public static Pin T3B(){
		return dc.getOut(59);
	}
	public static Pin T3C(){
		return dc.getOut(60);
	}
	public static Pin T3D(){
		return dc.getOut(61);
	}
	public static Pin T3E(){
		return dc.getOut(62);
	}
	public static Pin T3F(){
		return dc.getOut(63);
	}
	public static Pin T40(){
		return dc.getOut(64);
	}
	public static Pin T41(){
		return dc.getOut(65);
	}
	public static Pin T42(){
		return dc.getOut(66);
	}
	public static Pin T43(){
		return dc.getOut(67);
	}
	public static Pin T44(){
		return dc.getOut(68);
	}
	public static Pin T45(){
		return dc.getOut(69);
	}
	public static Pin T46(){
		return dc.getOut(70);
	}
	public static Pin T47(){
		return dc.getOut(71);
	}
	public static Pin T48(){
		return dc.getOut(72);
	}
	public static Pin T49(){
		return dc.getOut(73);
	}
	public static Pin T4A(){
		return dc.getOut(74);
	}
	public static Pin T4B(){
		return dc.getOut(75);
	}
	public static Pin T4C(){
		return dc.getOut(76);
	}
	public static Pin T4D(){
		return dc.getOut(77);
	}
	public static Pin T4E(){
		return dc.getOut(78);
	}
	public static Pin T4F(){
		return dc.getOut(79);
	}
	public static Pin T50(){
		return dc.getOut(80);
	}
	public static Pin T51(){
		return dc.getOut(81);
	}
	public static Pin T52(){
		return dc.getOut(82);
	}
	public static Pin T53(){
		return dc.getOut(83);
	}
	public static Pin T54(){
		return dc.getOut(84);
	}
	public static Pin T55(){
		return dc.getOut(85);
	}
	public static Pin T56(){
		return dc.getOut(86);
	}
	public static Pin T57(){
		return dc.getOut(87);
	}
	public static Pin T58(){
		return dc.getOut(88);
	}
	public static Pin T59(){
		return dc.getOut(89);
	}
	public static Pin T5A(){
		return dc.getOut(90);
	}
	public static Pin T5B(){
		return dc.getOut(91);
	}
	public static Pin T5C(){
		return dc.getOut(92);
	}
	public static Pin T5D(){
		return dc.getOut(93);
	}
	public static Pin T5E(){
		return dc.getOut(94);
	}
	public static Pin T5F(){
		return dc.getOut(95);
	}
	public static Pin T60(){
		return dc.getOut(96);
	}
	public static Pin T61(){
		return dc.getOut(97);
	}
	public static Pin T62(){
		return dc.getOut(98);
	}
	public static Pin T63(){
		return dc.getOut(99);
	}
	public static Pin T64(){
		return dc.getOut(100);
	}
	public static Pin T65(){
		return dc.getOut(101);
	}
	public static Pin T66(){
		return dc.getOut(102);
	}
	public static Pin T67(){
		return dc.getOut(103);
	}
	public static Pin T68(){
		return dc.getOut(104);
	}
	public static Pin T69(){
		return dc.getOut(105);
	}
	public static Pin T6A(){
		return dc.getOut(106);
	}
	public static Pin T6B(){
		return dc.getOut(107);
	}
	public static Pin T6C(){
		return dc.getOut(108);
	}
	public static Pin T6D(){
		return dc.getOut(109);
	}
	public static Pin T6E(){
		return dc.getOut(110);
	}
	public static Pin T6F(){
		return dc.getOut(111);
	}
	public static Pin T70(){
		return dc.getOut(112);
	}
	public static Pin T71(){
		return dc.getOut(113);
	}
	public static Pin T72(){
		return dc.getOut(114);
	}
	public static Pin T73(){
		return dc.getOut(115);
	}
	public static Pin T74(){
		return dc.getOut(116);
	}
	public static Pin T75(){
		return dc.getOut(117);
	}
	public static Pin T76(){
		return dc.getOut(118);
	}
	public static Pin T77(){
		return dc.getOut(119);
	}
	public static Pin T78(){
		return dc.getOut(120);
	}
	public static Pin T79(){
		return dc.getOut(121);
	}
	public static Pin T7A(){
		return dc.getOut(122);
	}
	public static Pin T7B(){
		return dc.getOut(123);
	}
	public static Pin T7C(){
		return dc.getOut(124);
	}
	public static Pin T7D(){
		return dc.getOut(125);
	}
	public static Pin T7E(){
		return dc.getOut(126);
	}
	public static Pin T7F(){
		return dc.getOut(127);
	}
	public static Pin T80(){
		return dc.getOut(128);
	}
	public static Pin T81(){
		return dc.getOut(129);
	}
	public static Pin T82(){
		return dc.getOut(130);
	}
	public static Pin T83(){
		return dc.getOut(131);
	}
	public static Pin T84(){
		return dc.getOut(132);
	}
	public static Pin T85(){
		return dc.getOut(133);
	}
	public static Pin T86(){
		return dc.getOut(134);
	}
	public static Pin T87(){
		return dc.getOut(135);
	}
	public static Pin T88(){
		return dc.getOut(136);
	}
	public static Pin T89(){
		return dc.getOut(137);
	}
	public static Pin T8A(){
		return dc.getOut(138);
	}
	public static Pin T8B(){
		return dc.getOut(139);
	}
	public static Pin T8C(){
		return dc.getOut(140);
	}
	public static Pin T8D(){
		return dc.getOut(141);
	}
	public static Pin T8E(){
		return dc.getOut(142);
	}
	public static Pin T8F(){
		return dc.getOut(143);
	}
	public static Pin T90(){
		return dc.getOut(144);
	}
	public static Pin T91(){
		return dc.getOut(145);
	}
	public static Pin T92(){
		return dc.getOut(146);
	}
	public static Pin T93(){
		return dc.getOut(147);
	}
	public static Pin T94(){
		return dc.getOut(148);
	}
	public static Pin T95(){
		return dc.getOut(149);
	}
	public static REG CNTREG(){
		return CNT;
	}
	
	
}
