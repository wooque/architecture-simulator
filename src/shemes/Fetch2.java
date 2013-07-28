package shemes;

import java.awt.Point;
import java.util.ArrayList;

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

	public static void gui(){
		gui=new GuiScheme("./src/images/fetch2.png");
		ArrayList<ArrayList<Point>> sections=null;
		ArrayList<Point> points=null;
		GuiLine line=null;
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(111,46));
		points.add(new Point(111,46));
		points.add(new Point(119,46));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR31());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(111,64));
		points.add(new Point(119,64));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR30());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(153,107));
		points.add(new Point(153,100));
		sections.add(points);
		line=new GuiLine(sections,Exec2.START());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(186,29));
		points.add(new Point(194,29));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G3());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(186,46));
		points.add(new Point(194,46));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G2());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(186,64));
		points.add(new Point(194,64));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G1());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(186,81));
		points.add(new Point(194,81));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G0());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(86,317));
		points.add(new Point(94,317));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR29());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(86,334));
		points.add(new Point(94,334));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR28());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(86,351));
		points.add(new Point(94,351));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR27());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(86,371));
		points.add(new Point(94,371));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR26());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(86,388));
		points.add(new Point(94,388));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR25());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(86,406));
		points.add(new Point(94,406));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR24());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(144,569));
		points.add(new Point(144,549));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G2());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,238));
		points.add(new Point(202,238));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.HALT());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,256));
		points.add(new Point(202,256));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.NOP());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,273));
		points.add(new Point(202,273));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.STSP());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,290));
		points.add(new Point(202,290));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.STIVTP());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,308));
		points.add(new Point(202,308));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.TRPD());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,325));
		points.add(new Point(202,325));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.TRPE());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,343));
		points.add(new Point(202,343));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.INTD());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,360));
		points.add(new Point(202,360));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.INTE());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,378));
		points.add(new Point(202,378));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ROLC());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,395));
		points.add(new Point(202,395));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ROL());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,412));
		points.add(new Point(202,412));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.LSL());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,430));
		points.add(new Point(202,430));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ASL());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,447));
		points.add(new Point(202,447));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.RORC());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,465));
		points.add(new Point(202,465));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ROR());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,482));
		points.add(new Point(202,482));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.LSR());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,500));
		points.add(new Point(202,500));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ASR());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,517));
		points.add(new Point(202,517));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.RTI());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(195,534));
		points.add(new Point(202,534));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.RTS());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(319,147));
		points.add(new Point(327,147));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR29());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(319,164));
		points.add(new Point(327,164));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR28());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(319,181));
		points.add(new Point(327,181));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR27());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(319,201));
		points.add(new Point(327,201));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR26());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(319,219));
		points.add(new Point(327,219));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR25());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(319,236));
		points.add(new Point(327,236));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR24());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,103));
		points.add(new Point(435,103));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BLEQU());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,120));
		points.add(new Point(435,120));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BLSSU());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,138));
		points.add(new Point(435,138));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BGREU());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(428,155));
		points.add(new Point(435,155));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BGRTU());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,173));
		points.add(new Point(435,173));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BLEQ());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,190));
		points.add(new Point(435,190));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BLSS());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,208));
		points.add(new Point(435,208));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BGRE());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,225));
		points.add(new Point(435,225));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BGRT());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,243));
		points.add(new Point(435,243));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BNCR());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,260));
		points.add(new Point(435,260));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BCR());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,277));
		points.add(new Point(435,277));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BNVF());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,295));
		points.add(new Point(435,295));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BOVF());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,312));
		points.add(new Point(435,312));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BNNG());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,330));
		points.add(new Point(435,330));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BNEG());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,347));
		points.add(new Point(435,347));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BNEQ());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(427,365));
		points.add(new Point(435,365));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.BEQL());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(377,399));
		points.add(new Point(377,379));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G0());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(582,32));
		points.add(new Point(591,32));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR29());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(582,49));
		points.add(new Point(591,49));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR28());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(582,67));
		points.add(new Point(591,67));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR27());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(582,86));
		points.add(new Point(591,86));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR26());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(582,104));
		points.add(new Point(591,104));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR25());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(582,121));
		points.add(new Point(591,121));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR24());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(682,101));
		points.add(new Point(690,101));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.INT());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(682,119));
		points.add(new Point(690,119));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.JSR());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(682,136));
		points.add(new Point(690,136));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.JMP());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(632,171));
		points.add(new Point(632,150));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G1());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(570,284));
		points.add(new Point(578,284));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR29());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(570,301));
		points.add(new Point(578,301));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR28());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(570,319));
		points.add(new Point(578,319));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR27());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(570,338));
		points.add(new Point(578,338));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR26());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(570,356));
		points.add(new Point(578,356));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR25());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(570,373));
		points.add(new Point(578,373));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR24());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(628,478));
		points.add(new Point(628,457));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.G3());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(678,286));
		points.add(new Point(686,286));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.NOT());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(678,304));
		points.add(new Point(686,304));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.XOR());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(678,321));
		points.add(new Point(686,321));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.OR());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(678,338));
		points.add(new Point(686,338));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.AND());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(678,356));
		points.add(new Point(686,356));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.SUB());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(678,373));
		points.add(new Point(686,373));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ADD());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(678,391));
		points.add(new Point(686,391));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.STW());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(678,408));
		points.add(new Point(686,408));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ST());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(678,426));
		points.add(new Point(686,426));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.LDW());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(678,443));
		points.add(new Point(686,443));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.LD());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(349,469));
		points.add(new Point(356,469));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR23());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(349,487));
		points.add(new Point(356,487));
		sections.add(points);
		line=new GuiLine(sections,Fetch1.IR22());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(412,450));
		points.add(new Point(420,450));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.immed());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(412,467));
		points.add(new Point(420,467));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.pcrel());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(412,485));
		points.add(new Point(420,485));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.regindpom());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(412,502));
		points.add(new Point(420,502));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.regdir());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(307,564));
		points.add(new Point(307,548));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.LD());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(324,564));
		points.add(new Point(324,548));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.LDW());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(342,564));
		points.add(new Point(342,548));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ST());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(359,564));
		points.add(new Point(359,548));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.STW());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(377,564));
		points.add(new Point(377,546));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ADD());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(394,564));
		points.add(new Point(394,546));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.SUB());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(411,564));
		points.add(new Point(411,548));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.AND());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(429,564));
		points.add(new Point(429,548));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.OR());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(446,564));
		points.add(new Point(446,548));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.XOR());
		gui.addLine(line);
		sections=new ArrayList<ArrayList<Point>>();
		points=new ArrayList<Point>();
		points.add(new Point(385,520));
		points.add(new Point(385,516));
		sections.add(points);
		line=new GuiLine(sections,Fetch2.ORDC6.getOut(0));
		gui.addLine(line);

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
