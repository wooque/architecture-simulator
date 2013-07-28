package shemes;

import gui.GuiLabel;
import gui.GuiLine;
import gui.GuiScheme;

import java.awt.Point;
import java.util.ArrayList;

import components.*;

public class Exec1 {
	public static CD CD1;
	public static MP MX1;
	public static CD CD2;
	public static MP MX2;
	public static IntToInt DBToAB;
	public static REG AB;
	public static IntToBools ABBits;
	public static IntToInt ABToTemp;
	public static TSB TSBAB1out;
	public static TSB TSBAB2out;
	public static REG BB;
	public static IntToBools BBBits;
	public static IntToInt BBToTemp;
	public static TSB TSBBBout;
	public static ALU ALUExec;
	public static IntToBools ALUBits;
	public static IntToInt ALUToTemp;
	public static TSB TSBALUout;
	public static IntToBools DBToBW;
	public static BoolsToInt DBHighBools;
	public static BoolsToInt DBLowBools;
	public static MP MPBWH;
	public static IntToBools MPBits;
	public static REG BWH;
	public static REG BWL;
	public static BoolsToInt BW;
	public static TSB TSBBWout;
	public static REG AW;
	public static TSB TSBAW1out;
	public static TSB TSBAW2out;

	public static GuiScheme gui;

	public static GuiScheme getGui() {
		return gui;
	}

	public static void gui() {

		GuiLine line; // Pomocna promenljiva
		gui = new GuiScheme("./src/images/Exec1.png");

		ArrayList<ArrayList<Point>> sections;
		ArrayList<Point> points;

		// Magistrala S1B
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(44, 24));
		points.add(new Point(45, 598));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(45, 24));
		points.add(new Point(46, 598));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(46, 24));
		points.add(new Point(47, 598));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);

		// Magistrala S2B
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(83, 24));
		points.add(new Point(83, 598));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(84, 24));
		points.add(new Point(84, 598));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(85, 24));
		points.add(new Point(85, 598));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);

		// Magistrala DB
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(756, 24));
		points.add(new Point(756, 598));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(757, 24));
		points.add(new Point(757, 598));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(758, 24));
		points.add(new Point(758, 598));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// 0. izlaz kodera
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(216, 82));
		points.add(new Point(244, 82));
		points.add(new Point(244, 17));
		points.add(new Point(311, 17));
		points.add(new Point(311, 25));
		sections.add(points);
		line = new GuiLine(sections, Exec1.CD1.getOut(0));
		gui.addLine(line);

		// 1. izlaz kodera
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(216, 63));
		points.add(new Point(229, 63));
		points.add(new Point(229, 9));
		points.add(new Point(330, 9));
		points.add(new Point(330, 25));
		sections.add(points);
		line = new GuiLine(sections, Exec1.CD1.getOut(1));
		gui.addLine(line);

		// RORC u koder
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(149, 44));
		points.add(new Point(156, 44));
		sections.add(points);
		line = new GuiLine(sections, Fetch2.RORC());
		gui.addLine(line);

		// ROR u koder
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(149, 63));
		points.add(new Point(156, 63));
		sections.add(points);
		line = new GuiLine(sections, Fetch2.ROR());
		gui.addLine(line);

		// LSR u koder
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(149, 82));
		points.add(new Point(156, 82));
		sections.add(points);
		line = new GuiLine(sections, Fetch2.LSR());
		gui.addLine(line);

		// ASR u koder
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(149, 102));
		points.add(new Point(156, 102));
		sections.add(points);
		line = new GuiLine(sections, Fetch2.ASR());
		gui.addLine(line);

		// PSWC u MX1
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(286, 45));
		points.add(new Point(292, 45));
		sections.add(points);
		line = new GuiLine(sections, Exec2.PSWC());
		gui.addLine(line);

		// AB0 u MX1
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(286, 64));
		points.add(new Point(292, 64));
		sections.add(points);
		line = new GuiLine(sections, Exec1.AB0());
		gui.addLine(line);

		// 0 u MX1
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(286, 83));
		points.add(new Point(292, 83));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);

		// AB7 u MX1
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(286, 103));
		points.add(new Point(292, 103));
		sections.add(points);
		line = new GuiLine(sections, Exec1.AB7());
		gui.addLine(line);

		// IR kao izlaz MX1
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(358, 74));
		points.add(new Point(370, 74));
		points.add(new Point(370, 129));
		points.add(new Point(131, 129));
		points.add(new Point(131, 219));
		points.add(new Point(199, 219));
		sections.add(points);
		line = new GuiLine(sections, Exec1.MX1.getOut(0));
		gui.addLine(line);

		// ROLC kao ulaz CD2
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(455, 44));
		points.add(new Point(462, 44));
		sections.add(points);
		line = new GuiLine(sections, Fetch2.ROLC());
		gui.addLine(line);

		// ROL kao ulaz CD2
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(455, 63));
		points.add(new Point(462, 63));
		sections.add(points);
		line = new GuiLine(sections, Fetch2.ROL());
		gui.addLine(line);

		// LSL kao ulaz CD2
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(455, 82));
		points.add(new Point(462, 82));
		sections.add(points);
		line = new GuiLine(sections, Fetch2.LSL());
		gui.addLine(line);

		// ASL kao ulaz CD2
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(455, 102));
		points.add(new Point(462, 102));
		sections.add(points);
		line = new GuiLine(sections, Fetch2.ASL());
		gui.addLine(line);

		// prvi izlaz CD2
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(522, 82));
		points.add(new Point(550, 82));
		points.add(new Point(550, 17));
		points.add(new Point(622, 17));
		points.add(new Point(622, 24));
		sections.add(points);
		line = new GuiLine(sections, Exec1.CD2.getOut(0));
		gui.addLine(line);

		// drugi izlaz CD2
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(522, 63));
		points.add(new Point(535, 63));
		points.add(new Point(535, 9));
		points.add(new Point(642, 9));
		points.add(new Point(642, 24));
		sections.add(points);
		line = new GuiLine(sections, Exec1.CD2.getOut(1));
		gui.addLine(line);

		// ZA MX2 ulazi niisu bili:

		// PSWC:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(596, 44));
		points.add(new Point(603, 44));
		sections.add(points);
		line = new GuiLine(sections, Exec2.PSWC());
		gui.addLine(line);

		//
		// AB7:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(596, 63));
		points.add(new Point(603, 63));
		sections.add(points);
		line = new GuiLine(sections, Exec1.AB7());
		gui.addLine(line);

		//
		// prva nula:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(596, 82));
		points.add(new Point(596, 82));
		points.add(new Point(603, 82));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);

		//
		// donja nula na ulazu nula mx2
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(596, 102));
		points.add(new Point(603, 102));
		sections.add(points);
		line = new GuiLine(sections, new Pin(false));
		gui.addLine(line);

		// izlaz MX2 - IL
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(663, 73));
		points.add(new Point(681, 73));
		points.add(new Point(681, 129));
		points.add(new Point(400, 129));
		points.add(new Point(400, 219));
		points.add(new Point(355, 219));
		sections.add(points);
		line = new GuiLine(sections, Exec1.MX2.getOut(0));
		gui.addLine(line);

		// nije bilo
		// DB do rastavljaca ka AB i BB:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(755, 156));
		points.add(new Point(665, 156));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		//
		// Ulaz u AB:(nije bilo)
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(610, 159));
		points.add(new Point(277, 159));
		points.add(new Point(277, 186));
		sections.add(points);
		line = new GuiLine(sections, DBToAB.getOut(0));
		gui.addLine(line);

		// nije bilo
		// SHR:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(193, 208));
		points.add(new Point(199, 208));
		sections.add(points);
		line = new GuiLine(sections, Oper2.shr());
		gui.addLine(line);

		// nije bilo
		// SHL:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(355, 208));
		points.add(new Point(361, 208));
		sections.add(points);
		line = new GuiLine(sections, Oper2.shl());
		gui.addLine(line);

		//
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(355, 208));
		points.add(new Point(361, 208));
		sections.add(points);
		line = new GuiLine(sections, Oper2.shl());
		gui.addLine(line);

		// nije bilo
		// ldAB:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(355, 197));
		points.add(new Point(362, 197));
		sections.add(points);
		line = new GuiLine(sections, Oper2.ldAB());
		gui.addLine(line);

		//
		// DB to BB(nije bilo):
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(573, 160));
		points.add(new Point(573, 185));
		sections.add(points);
		line = new GuiLine(sections, DBToAB.getOut(0));
		gui.addLine(line);

		// nije bilo
		// ldBB:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(489, 207));
		points.add(new Point(495, 207));
		sections.add(points);
		line = new GuiLine(sections, Oper2.ldBB());
		gui.addLine(line);

		// Izlaz AB
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(277, 231));
		points.add(new Point(277, 289));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(188, 277));
		points.add(new Point(276, 277));
		sections.add(points);
		line = new GuiLine(sections, Exec1.AB());
		gui.addLine(line);

		// Izlaz BB do ALU:
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(573, 230));
		points.add(new Point(573, 275));
		points.add(new Point(342, 275));
		points.add(new Point(342, 289));
		sections.add(points);
		line = new GuiLine(sections, Exec1.BB());
		gui.addLine(line);

		//
		// BB do prosirivaca nulama:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(573, 275));
		points.add(new Point(641, 275));
		sections.add(points);
		line = new GuiLine(sections, Exec1.BB());
		gui.addLine(line);

		// Ulaz u TSB BBout
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(655, 266));
		points.add(new Point(679, 266));
		sections.add(points);
		line = new GuiLine(sections, BBToTemp.getOut(0));// bilo samo BB()
		gui.addLine(line);

		// Izlaz iz TSB BBout
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(703, 266));
		points.add(new Point(755, 266));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// BBout
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(692, 255));
		points.add(new Point(692, 261));
		sections.add(points);
		line = new GuiLine(sections, Oper2.BBout());
		gui.addLine(line);

		// Ulaz u TSB AB2out i AB1out
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(178, 269));
		points.add(new Point(150, 269));
		sections.add(points);
		points = new ArrayList<Point>();
		points.add(new Point(159, 270));
		points.add(new Point(159, 334));
		points.add(new Point(150, 334));
		sections.add(points);
		line = new GuiLine(sections, ABToTemp.getOut(0));// bilo samo AB
		gui.addLine(line);

		// Izlaz iz AB2out
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(126, 269));
		points.add(new Point(86, 269));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);

		// Izlaz iz AB1out
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(126, 334));
		points.add(new Point(48, 334));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);

		// AB2out
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(138, 252));
		points.add(new Point(138, 263));
		sections.add(points);
		line = new GuiLine(sections, Oper2.AB2out());
		gui.addLine(line);

		// AB1out
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(138, 315));
		points.add(new Point(138, 328));
		sections.add(points);
		line = new GuiLine(sections, Oper2.AB1out());
		gui.addLine(line);

		// Izlaz ALU
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(310, 376));
		points.add(new Point(310, 393));
		points.add(new Point(640, 393));
		sections.add(points);
		line = new GuiLine(sections, Exec1.ALU());
		gui.addLine(line);

		// Izlaz C8 ALU
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(274, 376));
		points.add(new Point(274, 390));
		points.add(new Point(255, 390));
		sections.add(points);
		line = new GuiLine(sections, Exec1.C8());
		gui.addLine(line);

		// not signal u ALU
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(232, 309));
		points.add(new Point(239, 309));
		sections.add(points);
		line = new GuiLine(sections, Oper2.not());
		gui.addLine(line);

		// xor signal u ALU
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(232, 325));
		points.add(new Point(239, 325));
		sections.add(points);
		line = new GuiLine(sections, Oper2.xor());
		gui.addLine(line);

		//
		// or
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(232, 340));
		points.add(new Point(239, 340));
		sections.add(points);
		line = new GuiLine(sections, Oper2.or());
		gui.addLine(line);

		//
		// and
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(232, 355));
		points.add(new Point(239, 355));
		sections.add(points);
		line = new GuiLine(sections, Oper2.and());
		gui.addLine(line);

		//
		// sub
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(391, 340));
		points.add(new Point(397, 340));
		sections.add(points);
		line = new GuiLine(sections, Oper2.sub());
		gui.addLine(line);

		//
		// add
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(391, 355));
		points.add(new Point(397, 355));
		sections.add(points);
		line = new GuiLine(sections, Oper2.add());
		gui.addLine(line);

		// Int ALU do TSB
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(654, 384));
		points.add(new Point(678, 384));
		sections.add(points);
		line = new GuiLine(sections, ALUToTemp.getOut(0));
		gui.addLine(line);

		// nije bilo
		// TSB ALU do DB:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(702, 384));
		points.add(new Point(755, 384));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		//
		// ALUout
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(691, 373));
		points.add(new Point(691, 379));
		sections.add(points);
		line = new GuiLine(sections, Oper2.ALUout());
		gui.addLine(line);

		// nije bilo
		// DB to rastavljac za BW:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(755, 426));
		points.add(new Point(726, 426));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// nije bilo
		// DB to MX ulaz1:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(667, 417));
		points.add(new Point(488, 417));
		points.add(new Point(488, 441));
		sections.add(points);
		line = new GuiLine(sections, DBHighBools.getOut(0));
		gui.addLine(line);

		// nije bilo
		// DB to MX ulaz0:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(666, 431));
		points.add(new Point(506, 431));
		points.add(new Point(506, 441));
		sections.add(points);
		line = new GuiLine(sections, DBLowBools.getOut(0));
		gui.addLine(line);

		// nije bilo
		// DB low bits to BHL:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(620, 432));
		points.add(new Point(620, 463));
		points.add(new Point(680, 463));
		points.add(new Point(680, 484));
		sections.add(points);
		line = new GuiLine(sections, DBLowBools.getOut(0));
		gui.addLine(line);

		// nije bilo
		// mxBWH:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(526, 457));
		points.add(new Point(536, 457));
		sections.add(points);
		line = new GuiLine(sections, Oper2.mxBWH());
		gui.addLine(line);

		// izlaz MX3
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(498, 472));
		points.add(new Point(498, 484));
		sections.add(points);
		line = new GuiLine(sections, Exec1.MPBWH.getOut(0));
		gui.addLine(line);

		// moralo je da se odavde izbaci prikaz izlaza registra BWH i BWL jer su
		// to osmobitni nitski registri a ne obicni registri i imaju 8 izlaza a
		// ne 1 izlaz kako je bilo povezano za liniju gde se dohvatao samo 0
		// izlazni pin

		// nije bilo
		// BW do TSB:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(589, 544));
		points.add(new Point(589, 564));
		points.add(new Point(677, 564));
		sections.add(points);
		line = new GuiLine(sections, BW.getOut(0));
		gui.addLine(line);

		// izlaz TSB BWout
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(701, 564));
		points.add(new Point(755, 564));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// BWout
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(690, 553));
		points.add(new Point(690, 559));
		sections.add(points);
		line = new GuiLine(sections, Oper2.BWout());
		gui.addLine(line);

		// nije bilo
		// DB to AW:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(755, 583));
		points.add(new Point(369, 583));
		points.add(new Point(369, 427));
		points.add(new Point(285, 427));
		points.add(new Point(285, 446));
		sections.add(points);
		line = new GuiLine(sections, Bus1.DB());
		gui.addLine(line);

		// AW izlaz do tsbAW1
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(285, 488));
		points.add(new Point(285, 519));
		points.add(new Point(151, 519));
		sections.add(points);
		line = new GuiLine(sections, Exec1.AW());
		gui.addLine(line);

		//
		// AW to TSBAW2:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(192, 520));
		points.add(new Point(192, 575));
		points.add(new Point(152, 575));
		sections.add(points);
		line = new GuiLine(sections, Exec1.AW());
		gui.addLine(line);

		// AW2out izlaz
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(128, 575));
		points.add(new Point(86, 575));
		sections.add(points);
		line = new GuiLine(sections, Exec1.AW2out());
		gui.addLine(line);

		// AW1out izlaz
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(127, 519));
		points.add(new Point(48, 519));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S1B());
		gui.addLine(line);

		// AW1out
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(139, 502));
		points.add(new Point(139, 513));
		sections.add(points);
		line = new GuiLine(sections, Oper2.AW1out());
		gui.addLine(line);

		// AW2out
		//
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(140, 559));
		points.add(new Point(140, 569));
		sections.add(points);
		line = new GuiLine(sections, Bus1.S2B());
		gui.addLine(line);

		// NIJE BILO:

		// ldAW:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(207, 466));
		points.add(new Point(213, 466));
		sections.add(points);
		line = new GuiLine(sections, Oper2.ldAW());
		gui.addLine(line);

		//
		// ldBWH:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(434, 500));
		points.add(new Point(441, 500));
		sections.add(points);
		line = new GuiLine(sections, Oper2.ldBWH());
		gui.addLine(line);

		//
		// ldBWL:
		sections = new ArrayList<ArrayList<Point>>();
		points = new ArrayList<Point>();
		points.add(new Point(615, 500));
		points.add(new Point(621, 500));
		sections.add(points);
		line = new GuiLine(sections, Oper2.ldBWL());
		gui.addLine(line);

		// LABELE:

		gui.addLabel(new GuiLabel(51, 34, Bus1.S1B()));
		gui.addLabel(new GuiLabel(90, 34, Bus1.S2B()));
		gui.addLabel(new GuiLabel(763, 34, Bus1.DB()));
		gui.addLabel(new GuiLabel(287, 177, DBToAB.getOut(0)));
		gui.addLabel(new GuiLabel(287, 245, AB.getOut(0)));
		gui.addLabel(new GuiLabel(583, 177, DBToAB.getOut(0)));
		gui.addLabel(new GuiLabel(583, 245, BB.getOut(0)));
		gui.addLabel(new GuiLabel(283, 288, AB.getOut(0)));
		gui.addLabel(new GuiLabel(347, 288, BB.getOut(0)));
		gui.addLabel(new GuiLabel(322, 388, ALUExec.getOut(0)));
		gui.addLabel(new GuiLabel(153, 266, ABToTemp.getOut(0)));
		gui.addLabel(new GuiLabel(662, 261, BBToTemp.getOut(0)));
		gui.addLabel(new GuiLabel(659, 379, ALUToTemp.getOut(0)));
		gui.addLabel(new GuiLabel(515, 428, DBLowBools.getOut(0)));
		gui.addLabel(new GuiLabel(515, 414, DBHighBools.getOut(0)));
		gui.addLabel(new GuiLabel(687, 477, DBLowBools.getOut(0)));
		gui.addLabel(new GuiLabel(600, 557, BW.getOut(0)));
		gui.addLabel(new GuiLabel(508, 482, MPBWH.getOut(0)));
		gui.addLabel(new GuiLabel(296, 442, Bus1.DB()));
		gui.addLabel(new GuiLabel(296, 503, AW.getOut(0)));

	}

	private Exec1() {

	}

	public static void init() {

		CD1 = new CD(4);
		CD1.setE(new Pin(true));

		MX1 = new MP(4);

		CD2 = new CD(4);
		CD2.setE(new Pin(true));

		MX2 = new MP(4);

		DBToAB = new IntToInt(16, 8);

		AB = new REG(1, "AB");
		AB.getOut(0).setIsInt();
		AB.getOut(0).setNumOfLines(8);

		ABBits = new IntToBools(8, 8);

		ABToTemp = new IntToInt(8, 16);

		TSBAB1out = new TSB();
		TSBAB1out.getOut(0).setNumOfLines(16);

		TSBAB2out = new TSB();
		TSBAB2out.getOut(0).setNumOfLines(16);

		BB = new REG(1, "BB");
		BB.getOut(0).setIsInt();
		BB.getOut(0).setNumOfLines(8);

		BBBits = new IntToBools(8, 8);

		BBToTemp = new IntToInt(8, 16);

		TSBBBout = new TSB();
		TSBBBout.getOut(0).setNumOfLines(16);

		ALUExec = new ALU();

		ALUBits = new IntToBools(8, 8);

		ALUToTemp = new IntToInt(8, 16);

		TSBALUout = new TSB();
		TSBALUout.getOut(0).setNumOfLines(16);

		DBToBW = new IntToBools(16, 16);
		DBHighBools = new BoolsToInt(8, 8);
		DBLowBools = new BoolsToInt(8, 8);
		MPBWH = new MP(2);
		MPBWH.setE(new Pin(true));
		MPBits = new IntToBools(8, 8);

		BWH = new REG(8, "BWH");

		BWL = new REG(8, "BWL");

		BW = new BoolsToInt(16, 16);

		TSBBWout = new TSB();
		TSBBWout.getOut(0).setNumOfLines(16);

		AW = new REG(1, "AW");
		AW.getOut(0).setIsInt();
		AW.getOut(0).setNumOfLines(16);

		TSBAW1out = new TSB();
		TSBAW1out.getOut(0).setNumOfLines(16);

		TSBAW2out = new TSB();
		TSBAW2out.getOut(0).setNumOfLines(16);

	}

	public static void connect() {
		CD1.setInputPin(0, Fetch2.ASR());
		CD1.setInputPin(1, Fetch2.LSR());
		CD1.setInputPin(2, Fetch2.ROR());
		CD1.setInputPin(3, Fetch2.RORC());

		MX1.setCtrl(0, CD1.getOut(0));
		MX1.setCtrl(1, CD1.getOut(1));
		MX1.setInputPin(0, ABBits.getOut(7));
		MX1.setInputPin(1, new Pin(false));
		MX1.setInputPin(2, ABBits.getOut(0));
		MX1.setInputPin(3, Exec2.PSWC());

		CD2.setInputPin(0, Fetch2.ASL());
		CD2.setInputPin(1, Fetch2.LSL());
		CD2.setInputPin(2, Fetch2.ROL());
		CD2.setInputPin(3, Fetch2.ROLC());

		MX2.setCtrl(0, CD2.getOut(0));
		MX2.setCtrl(1, CD2.getOut(1));
		MX2.setInputPin(0, new Pin(false));
		MX2.setInputPin(1, new Pin(false));
		MX2.setInputPin(2, ABBits.getOut(7));
		MX2.setInputPin(3, Exec2.PSWC());

		DBToAB.setInputPin(0, Bus1.DB());

		AB.setInputPin(0, DBToAB.getOut(0));
		AB.setPinLd(Oper2.ldAB());
		AB.setShr(Oper2.shr());
		AB.setIR(MX1.getOut(0));
		AB.setShl(Oper2.shl());
		AB.setIL(MX2.getOut(0));

		ABBits.setInputPin(0, AB.getOut(0));

		ABToTemp.setInputPin(0, AB.getOut(0));

		TSBAB1out.setInputPin(0, ABToTemp.getOut(0));
		TSBAB1out.setCtrl(Oper2.AB1out());
		Bus1.addOnS1B(TSBAB1out.getOut(0));

		TSBAB2out.setInputPin(0, ABToTemp.getOut(0));
		TSBAB2out.setCtrl(Oper2.AB2out());
		Bus1.addOnS2B(TSBAB2out.getOut(0));

		BB.setInputPin(0, DBToAB.getOut(0));
		BB.setPinLd(Oper2.ldBB());

		BBBits.setInputPin(0, BB.getOut(0));

		BBToTemp.setInputPin(0, BB.getOut(0));

		TSBBBout.setInputPin(0, BBToTemp.getOut(0));
		TSBBBout.setCtrl(Oper2.BBout());
		Bus1.addOnDB(TSBBBout.getOut(0));

		ALUExec.setPinX(AB.getOut(0));
		ALUExec.setPinY(BB.getOut(0));
		ALUExec.setPinAdd(Oper2.add());
		ALUExec.setPinSub(Oper2.sub());
		ALUExec.setPinAnd(Oper2.and());
		ALUExec.setPinOr(Oper2.or());
		ALUExec.setPinXor(Oper2.xor());
		ALUExec.setPinNot(Oper2.not());

		ALUBits.setInputPin(0, ALUExec.getOut(0));

		ALUToTemp.setInputPin(0, ALUExec.getOut(0));

		TSBALUout.setInputPin(0, ALUToTemp.getOut(0));
		TSBALUout.setCtrl(Oper2.ALUout());
		Bus1.addOnDB(TSBALUout.getOut(0));

		DBToBW.setInputPin(0, Bus1.DB());
		for (int i = 0; i < 8; i++) {
			DBHighBools.setInputPin(i, DBToBW.getOut(8 + i));
			DBLowBools.setInputPin(i, DBToBW.getOut(i));
		}
		MPBWH.setInputPin(0, DBLowBools.getOut(0));
		MPBWH.setInputPin(1, DBHighBools.getOut(0));
		MPBWH.setCtrl(0, Oper2.mxBWH());
		MPBits.setInputPin(0, MPBWH.getOut(0));

		BWH.setPinLd(Oper2.ldBWH());
		BWL.setPinLd(Oper2.ldBWL());
		for (int i = 0; i < 8; i++) {
			BWH.setInputPin(i, MPBits.getOut(i));
			BWL.setInputPin(i, DBToBW.getOut(i));
		}

		for (int i = 0; i < 8; i++) {
			BW.setInputPin(i, BWL.getOut(i));
			BW.setInputPin(8 + i, BWH.getOut(i));
		}

		TSBBWout.setInputPin(0, BW.getOut(0));
		TSBBWout.setCtrl(Oper2.BWout());
		Bus1.addOnDB(TSBBWout.getOut(0));

		AW.setInputPin(0, Bus1.DB());
		AW.setPinLd(Oper2.ldAW());

		TSBAW1out.setInputPin(0, AW.getOut(0));
		TSBAW1out.setCtrl(Oper2.AW1out());
		Bus1.addOnS1B(TSBAW1out.getOut(0));

		TSBAW2out.setInputPin(0, AW.getOut(0));
		TSBAW2out.setCtrl(Oper2.AW2out());
		Bus1.addOnS2B(TSBAW2out.getOut(0));

	}

	public static Pin AB0() {
		return ABBits.getOut(0);
	}

	public static Pin AB1() {
		return ABBits.getOut(1);
	}

	public static Pin AB2() {
		return ABBits.getOut(2);
	}

	public static Pin AB3() {
		return ABBits.getOut(3);
	}

	public static Pin AB4() {
		return ABBits.getOut(4);
	}

	public static Pin AB5() {
		return ABBits.getOut(5);
	}

	public static Pin AB6() {
		return ABBits.getOut(6);
	}

	public static Pin AB7() {
		return ABBits.getOut(7);
	}

	public static Pin C8() {
		return ALUExec.getPinC8();
	}

	public static Pin ALU7() {
		return ALUBits.getOut(7);
	}

	public static Pin BB7() {
		return BBBits.getOut(7);
	}

	public static Pin AB() {
		return AB.getOut(0);
	}

	public static Pin BB() {
		return BB.getOut(0);
	}

	public static Pin ALU() {
		return ALUExec.getOut(0);
	}

	public static Pin BW() {
		return BW.getOut(0);
	}

	public static Pin AW() {
		return AW.getOut(0);
	}

	public static Pin AB1out() {
		return TSBAB1out.getOut(0);
	}

	public static Pin AB2out() {
		return TSBAB2out.getOut(0);
	}

	public static Pin BBout() {
		return TSBBBout.getOut(0);
	}

	public static Pin ALUout() {
		return TSBALUout.getOut(0);
	}

	public static Pin BWout() {
		return TSBBWout.getOut(0);
	}

	public static Pin AW1out() {
		return TSBAW1out.getOut(0);
	}

	public static Pin AW2out() {
		return TSBAW2out.getOut(0);
	}

	public static REG RegAB() {
		return AB;
	}

	public static REG RegBB() {
		return BB;
	}

	public static REG RegAW() {
		return AW;
	}

	public static REG RegBWH() {
		return BWH;
	}

	public static REG RegBWL() {
		return BWL;
	}
}
