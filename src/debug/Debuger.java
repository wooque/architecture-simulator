package debug;

import java.io.*;

import components.LogicalComponent;

import shemes.*;

public class Debuger {

	private PrintWriter pw;
	
	//Arbitay and Bus1
	boolean BG_IN1,MDRin;
	int S1B,S2B,DB,ABUS,DBUS;
	boolean s1bhz,s2bhz,dbhz,abushz,dbushz;
	int MDR,MAR,MX1;
	int S2Doutint,DS1outint,MDRoutToDBint,MARoutint,MDRRDBUSoutint;
	//Bus2
	boolean RDF,RDB,ERDC,ERDA, WRF,WRB,EWRC,EWRAD,brqstart;
	boolean EA,ED,NotRDBUS,NotWRBUS;
	boolean rdbushz,wrbushz;
	//Bus3
	boolean NotFCBUS,NotBUSYBUS,BR1,bgr,setbusy,busy,FFC,NotFFC,FFCD,NotFFCD,JFC, NFC,END,brqstop;
	boolean fcbushz,busybushz;
	//Counter
	boolean T[],CNTINC,CNTLD;
	int CNT,KMADR,KMOPR,KMBR;
	//FETCH:
	boolean IR31,IR30,IR29,IR28,IR27,IR26,IR25,IR24,IR23,IR22;
	int PC;
	boolean G0,G1,G2,G3;
	boolean BEQL,BNEQ,BNEG,BNNG,BOVF,BNVF,BCR,BNCR,BGRT,BGRE,BLSS,BLEQ,BGRTU,BGREU,BLSSU,BLEQU;
	boolean JMP,JSR,INT;
	boolean RTS,RTI,ASR,LSR,ROR,RORC,ASL,LSL,ROL,ROLC,INTE,INTD,TRPE,TRPD,STIVTP,STSP,NOP,HALT;
	boolean LD,LDW,ST,STW,ADD,SUB,AND,OR,XOR,NOT;
	boolean regdir,regindpom,pcrel,immed;
	boolean gropr,gradr,I1,I2_brnch,I2_arlog,I2,I3_jump,I3_arlog,I3,I4,store;
	int IMMoutint,PC1outint,PC2outint,JDISPoutint,PCRDISPoutint,JAPSoutint,REGIDISPoutint;
	//ADR,EXEC,INTR
	int R0,R1,R2,R3,R4,R5,R6,R7,R8,R9;
	int GPRAR,SP,PR;
	int AB,BB,ALU,BW,AW;
	boolean PSWI,PSWT,PSWZ,PSWN,PSWV,PSWC,PSWL0,PSWL1,START;
	int PSW;
	boolean N,C,Z,V;
	boolean brpom;
	boolean PRINS,PRCOD,PRADR,PRINM,prekid;
	int IMR;
	boolean printr;
	int UINT,UEXT,BR,IVTP,IVTDSP;
	int GPRDoutint,GPRS1outint,SP1outint,PRoutint;
	int AB1outint,AB2outint,BBoutint,ALUoutint,BWoutint,AW1outint,AW2outint,PSWoutint;
	int IMRoutint,IVTPoutint,IVTDSPoutint;
	
	//OPER1
	private boolean ldMAR,incMAR,mxMDR1,mxMDR0,ldMDR,readm,writem,MDRout,S2Dout,DS1out,ldPC,incPC,ldIR0,ldIR1,ldIR2,ldIR3, PC1out;
	private boolean PC2out,JDISPout,PCRDISPout,REGIDISPout,IMMout,JAPSout,ldGPRAR,wrGPR,rdGPR,GPR1out,GPRDout,ldSP,incSP,decSP,SP1out,ldPR,PRout;
	//OPER2
	private boolean shr,shl,AB1out,ldAB,AB2out,ldBB,BBout,ldAW,AW1out,AW2out;
	private boolean ldBWH,ldBWL,mxBWH,BWout,clPSWI,clPSWT,stPSWI,stPSWT,ldL,ldN,ldZ,ldC,ldV,PSWout,ldPSWL,ldPSWH,clSTART;
	private boolean add,sub,and,or,xor,not,ALUout,stPRINS,clPRINS,stPRCOD,clPRCOD,stPRADR,clPRADR,clPRINM,clINTR,ldIVTP,IVTPout,IVTDSPout,mxBR0,mxBR1,ldBR;
	//UPRAV1
	private boolean bradr,bropr,brnotSTART,brnotbrpom,brnotprekid,brnotPRINS,brnotPRCOD,brnotPRADR,brnotPRINM;
	private boolean brnotprintr,brnotgropr,brI1,brnotgradr,brI2_brnch,brI2_arlog,brI3_jump,brI3_arlog,bruncnd,brcnd,brnotbrqstop,brstore,brLDW,brregdir;
	//UPRAV2
	private boolean val01,val04,val08,val0B,val0F,val13,val18,val1E,val24,val25,val28,val2A,val3A,val3C,val40,val43,val45,val5F,val62;
	private boolean val67,val6A,val6F, val72,val78,val7B,val7E,val81,val84,val86,val88,val8A,val8C,val90,val93,val00,val2D,val75,val1A,val8D;
	//MEM
	//private boolean rdMEM,wrMEM,REQUEST,memEND,incMEMACC,fcMEM,memT0,memT1,memT2,memT3,memFC,membruncnd, membrcnd,memval0, memval1, memval2;
	//private boolean memCNTLD,memCNTINC;
	//private int memCNT;
	//MEM new
	private boolean memrdbus,memwrbus,memrds,memwrs,memrw,memaccess;
	private int memTime,memPDR,memPDRout;
	private boolean memCNT0,memCNT1,memldCNT,memincCNT,memT0,memT1,memT2;
	private boolean memOEdata,memPDRin,memdecTime,memldTime,memfcbus,memOEfcbus;
	private int PDRoutint;
	public Debuger(){
		try {
			FileWriter f=new FileWriter("debug.txt");
			pw=new PrintWriter(f,true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		T=new boolean[150];
	}
	
	public void debug(){
		pw.println("CLK = "+LogicalComponent.globalClock);
		//Arbitary
		if(BG_IN1!=Arbitary.BG_IN1().getBoolVal()){
			BG_IN1=Arbitary.BG_IN1().getBoolVal();
			pw.println("BG_IN1 = "+BG_IN1);	
		}
		//Bus1
		
		if(S2Doutint!=Bus1.S2Dout().getIntVal()){
			S2Doutint=Bus1.S2Dout().getIntVal();
			pw.println("S2Doutint = "+S2Doutint);	
		}
		if(DS1outint!=Bus1.DS1out().getIntVal()){
			DS1outint=Bus1.DS1out().getIntVal();
			pw.println("DS1outint = "+DS1outint);	
		}
		if(MDRoutToDBint!=Bus1.MDRoutToDB().getIntVal()){
			MDRoutToDBint =Bus1.MDRoutToDB().getIntVal();
			pw.println("MDRoutToDBint = "+MDRoutToDBint);	
		}
		if(MARoutint!=Bus1.MARout().getIntVal()){
			MARoutint=Bus1.MARout().getIntVal();
			pw.println("MARoutint = "+MARoutint);	
		}
		if(MDRRDBUSoutint!=Bus1.MDRRDBUSout().getIntVal()){
			MDRRDBUSoutint=Bus1.MDRRDBUSout().getIntVal();
			pw.println("MDRRDBUSoutint = "+MDRRDBUSoutint);	
		}
		
		if(MX1!=Bus1.MX1().getIntVal()){
			MX1=Bus1.MX1().getIntVal();
			pw.println("MX1 = "+MX1);	
		}
		if(MAR!=Bus1.MAR().getIntVal()){
			MAR=Bus1.MAR().getIntVal();
			pw.println("MAR = "+MAR);	
		}
		if(MDR!=Bus1.MDR().getIntVal()){
			MDR=Bus1.MDR().getIntVal();
			pw.println("MDR = "+MDR);	
		}
		if(s1bhz!=Bus1.S1B().isHighZ()){
			s1bhz=Bus1.S1B().isHighZ();
			pw.println("S1BHIGHZ = "+Bus1.S1B().isHighZ());	
		}
		if(S1B!=Bus1.S1B().getIntVal()){
			S1B=Bus1.S1B().getIntVal();
			pw.println("S1B = "+S1B);	
		}
		if(s2bhz!=Bus1.S2B().isHighZ()){
			s2bhz=Bus1.S2B().isHighZ();
			pw.println("S2BHIGHZ = "+Bus1.S2B().isHighZ());	
		}
		if(S2B!=Bus1.S2B().getIntVal()){
			S2B=Bus1.S2B().getIntVal();
			pw.println("S2B = "+S2B);	
		}
		if(dbhz!=Bus1.DB().isHighZ()){
			dbhz=Bus1.DB().isHighZ();
			pw.println("DBHIGHZ = "+Bus1.DB().isHighZ());	
		}
		if(DB!=Bus1.DB().getIntVal()){
			DB=Bus1.DB().getIntVal();
			pw.println("DB = "+DB);	
		}
		if(abushz!=Bus1.ABUS().isHighZ()){
			abushz=Bus1.ABUS().isHighZ();
			pw.println("ABUSHIGHZ = "+Bus1.ABUS().isHighZ());	
		}
		if(ABUS!=Bus1.ABUS().getIntVal()){
			ABUS=Bus1.ABUS().getIntVal();
			pw.println("ABUS = "+ABUS);	
		}
		if(dbushz!=Bus1.DBUS().isHighZ()){
			dbushz=Bus1.DBUS().isHighZ();
			pw.println("DBUSHIGHZ = "+Bus1.DBUS().isHighZ());	
		}
		if(DBUS!=Bus1.DBUS().getIntVal()){
			DBUS=Bus1.DBUS().getIntVal();
			pw.println("DBUS = "+DBUS);	
		}
		if(MDRin!=Bus1.MDRin().getBoolVal()){
			MDRin=Bus1.MDRin().getBoolVal();
			pw.println("MDRin = "+MDRin);	
		}
		//Bus2
		if(RDF!=Bus2.RDF().getBoolVal()){
			RDF=Bus2.RDF().getBoolVal();
			pw.println("RDF = "+RDF);	
		}
		if(RDB!=Bus2.RDB().getBoolVal()){
			RDB=Bus2.RDB().getBoolVal();
			pw.println("RDB = "+RDB);	
		}
		if(ERDC!=Bus2.ERDC().getBoolVal()){
			ERDC=Bus2.ERDC().getBoolVal();
			pw.println("ERDC = "+ERDC);	
		}
		if(ERDA!=Bus2.ERDA().getBoolVal()){
			ERDA=Bus2.ERDA().getBoolVal();
			pw.println("ERDA = "+ERDA);	
		}
		if(WRF!=Bus2.WRF().getBoolVal()){
			WRF=Bus2.WRF().getBoolVal();
			pw.println("WRF = "+WRF);	
		}
		if(WRB!=Bus2.WRB().getBoolVal()){
			WRB=Bus2.WRB().getBoolVal();
			pw.println("WRB = "+WRB);	
		}
		if(EWRC!=Bus2.EWRC().getBoolVal()){
			EWRC=Bus2.EWRC().getBoolVal();
			pw.println("EWRC = "+EWRC);	
		}
		if(EWRAD!=Bus2.EWRAD().getBoolVal()){
			EWRAD=Bus2.EWRAD().getBoolVal();
			pw.println("EWRAD = "+EWRAD);	
		}
		if(brqstart!=Bus2.brqstart().getBoolVal()){
			brqstart=Bus2.brqstart().getBoolVal();
			pw.println("brqstart = "+brqstart);	
		}
		if(EA!=Bus2.EA().getBoolVal()){
			EA=Bus2.EA().getBoolVal();
			pw.println("EA = "+EA);	
		}
		if(ED!=Bus2.ED().getBoolVal()){
			ED=Bus2.ED().getBoolVal();
			pw.println("ED = "+ED);	
		}
		if(rdbushz!=Bus2.NotRDBUS().isHighZ()){
			rdbushz=Bus2.NotRDBUS().isHighZ();
			pw.println("NotRDBUSHIGHZ = "+Bus2.NotRDBUS().isHighZ());	
		}
		if(NotRDBUS!=Bus2.NotRDBUS().getBoolVal()){
			NotRDBUS=Bus2.NotRDBUS().getBoolVal();
			pw.println("NotRDBUS = "+NotRDBUS);	
		}
		if(wrbushz!=Bus2.NotWRBUS().isHighZ()){
			wrbushz=Bus2.NotWRBUS().isHighZ();
			pw.println("NotWRBUSHIGHZ = "+Bus2.NotWRBUS().isHighZ());	
		}
		if(NotWRBUS!=Bus2.NotWRBUS().getBoolVal()){
			NotWRBUS=Bus2.NotWRBUS().getBoolVal();
			pw.println("NotWRBUS = "+NotWRBUS);	
		}
		if(fcbushz!=Bus3.NotFCBUS().isHighZ()){
			fcbushz=Bus3.NotFCBUS().isHighZ();
			pw.println("NotFCBUSHIGHZ = "+Bus3.NotFCBUS().isHighZ());	
		}
		if(NotFCBUS!=Bus3.NotFCBUS().getBoolVal()){
			NotFCBUS=Bus3.NotFCBUS().getBoolVal();
			pw.println("NotFCBUS = "+NotFCBUS);	
		}
		if(busybushz!=Bus3.NotBUSYBUS().isHighZ()){
			busybushz=Bus3.NotBUSYBUS().isHighZ();
			pw.println("NotBUSYBUSHIGHZ = "+Bus3.NotBUSYBUS().isHighZ());	
		}
		if(NotBUSYBUS!=Bus3.NotBUSYBUS().getBoolVal()){
			NotBUSYBUS=Bus3.NotBUSYBUS().getBoolVal();
			pw.println("NotBUSYBUS = "+NotBUSYBUS);	
		}
		if(BR1!=Bus3.BR1().getBoolVal()){
			BR1=Bus3.BR1().getBoolVal();
			pw.println("BR1 = "+BR1);	
		}
		if(bgr!=Bus3.bgr().getBoolVal()){
			bgr=Bus3.bgr().getBoolVal();
			pw.println("bgr = "+bgr);	
		}
		if(setbusy!=Bus3.setbusy().getBoolVal()){
			setbusy=Bus3.setbusy().getBoolVal();
			pw.println("setbusy = "+setbusy);	
		}
		if(busy!=Bus3.busy().getBoolVal()){
			busy=Bus3.busy().getBoolVal();
			pw.println("busy = "+busy);	
		}
		if(FFC!=Bus3.FFC().getBoolVal()){
			FFC=Bus3.FFC().getBoolVal();
			pw.println("FFC = "+FFC);	
		}
		if(NotFFC!=Bus3.NotFFC().getBoolVal()){
			NotFFC=Bus3.NotFFC().getBoolVal();
			pw.println("NotFFC = "+NotFFC);	
		}

		if(FFCD!=Bus3.FFCD().getBoolVal()){
			FFCD=Bus3.FFCD().getBoolVal();
			pw.println("FFCD = "+FFCD);	
		}
		if(NotFFCD!=Bus3.NotFFCD().getBoolVal()){
			NotFFCD=Bus3.NotFFCD().getBoolVal();
			pw.println("NotFFCD = "+NotFFCD);	
		}
		if(JFC!=Bus3.JFC().getBoolVal()){
			JFC=Bus3.JFC().getBoolVal();
			pw.println("JFC = "+JFC);	
		}
		if(NFC!=Bus3.NFC().getBoolVal()){
			NFC=Bus3.NFC().getBoolVal();
			pw.println("NFC = "+NFC);	
		}
		if(END!=Bus3.END().getBoolVal()){
			END=Bus3.END().getBoolVal();
			pw.println("END = "+END);	
		}
		if(brqstop!=Bus3.brqstop().getBoolVal()){
			brqstop=Bus3.brqstop().getBoolVal();
			pw.println("brqstop = "+brqstop);	
		}
		//COUNTER
		for(int i=0;i<T.length;i++){
			if(T[i]!=Counter.dc.getOut(i).getBoolVal()){
				T[i]=Counter.dc.getOut(i).getBoolVal();
				pw.println("T" + i + " = " + T[i]);	
			}
		}
		if(CNTINC!=Counter.CNTINC().getBoolVal()){
			CNTINC=Counter.CNTINC().getBoolVal();
			pw.println("CNTINC = "+CNTINC);	
		}
		if(CNTLD!=Counter.CNTLD().getBoolVal()){
			CNTLD=Counter.CNTLD().getBoolVal();
			pw.println("CNTLD = "+CNTLD);	
		}
		if(CNT!=Counter.CNT().getIntVal()){
			CNT=Counter.CNT().getIntVal();
			pw.println("CNT = "+CNT);	
		}
		if(KMADR!=Counter.KMADR().getIntVal()){
			KMADR=Counter.KMADR().getIntVal();
			pw.println("KMADR = "+KMADR);	
		}
		if(KMOPR!=Counter.KMOPR().getIntVal()){
			KMOPR=Counter.KMOPR().getIntVal();
			pw.println("KMOPR = "+KMOPR);	
		}
		if(KMBR!=Counter.KMBR().getIntVal()){
			KMBR=Counter.KMBR().getIntVal();
			pw.println("KMBR = "+KMBR);	
		}
		
		//FETCH,EXEC,INTR
		if (IR31 !=Fetch1.IR31().getBoolVal()) {
			IR31 = Fetch1.IR31().getBoolVal();
			pw.println("IR31 = " + IR31);
		}
		if (IR30 !=Fetch1.IR30().getBoolVal()) {
			IR30 = Fetch1.IR30().getBoolVal();
			pw.println("IR30 = " + IR30);
		}
		if (IR29 !=Fetch1.IR29().getBoolVal()) {
			IR29 = Fetch1.IR29().getBoolVal();
			pw.println("IR29 = " + IR29);
		}
		if (IR28 !=Fetch1.IR28().getBoolVal()) {
			IR28 = Fetch1.IR28().getBoolVal();
			pw.println("IR28 = " + IR28);
		}
		if (IR27 !=Fetch1.IR27().getBoolVal()) {
			IR27 = Fetch1.IR27().getBoolVal();
			pw.println("IR27 = " + IR27);
		}
		if (IR26 !=Fetch1.IR26().getBoolVal()) {
			IR26 = Fetch1.IR26().getBoolVal();
			pw.println("IR26 = " + IR26);
		}
		if (IR25 !=Fetch1.IR25().getBoolVal()) {
			IR25 = Fetch1.IR25().getBoolVal();
			pw.println("IR25 = " + IR25);
		}
		
		if (IR24 !=Fetch1.IR24().getBoolVal()) {
			IR24 = Fetch1.IR24().getBoolVal();
			pw.println("IR24 = " + IR24);
		}
		if (IR23 !=Fetch1.IR23().getBoolVal()) {
			IR23 = Fetch1.IR23().getBoolVal();
			pw.println("IR23 = " + IR23);
		}
		if (IR22 !=Fetch1.IR22().getBoolVal()) {
			IR22 = Fetch1.IR22().getBoolVal();
			pw.println("IR22 = " + IR22);
		}
		if (PC !=Fetch1.PC().getIntVal()) {
			PC =Fetch1.PC().getIntVal();
			pw.println("PC = " + PC);
		}
		if (IMMoutint !=Fetch1.IMMout().getIntVal()) {
			IMMoutint =Fetch1.IMMout().getIntVal();
			pw.println("IMMoutint = " + IMMoutint);
		}
		if (PC1outint !=Fetch1.PC1out().getIntVal()) {
			PC1outint =Fetch1.PC1out().getIntVal();
			pw.println("PC1outint = " + PC1outint);
		}
		if (PC2outint !=Fetch1.PC2out().getIntVal()) {
			PC2outint =Fetch1.PC2out().getIntVal();
			pw.println("PC2outint = " + PC2outint);
		}
		if (JDISPoutint !=Fetch1.JDISPout().getIntVal()) {
			JDISPoutint =Fetch1.JDISPout().getIntVal();
			pw.println("JDISPoutint = " + JDISPoutint);
		}
		if (PCRDISPoutint !=Fetch1.PCRDISPout().getIntVal()) {
			PCRDISPoutint =Fetch1.PCRDISPout().getIntVal();
			pw.println("PCRDISPoutint = " + PCRDISPoutint);
		}
		if (JAPSoutint !=Fetch1.JAPSout().getIntVal()) {
			JAPSoutint =Fetch1.JAPSout().getIntVal();
			pw.println("JAPSoutint = " + JAPSoutint);
		}
		if (REGIDISPoutint !=Fetch1.REGIDISPout().getIntVal()) {
			REGIDISPoutint =Fetch1.REGIDISPout().getIntVal();
			pw.println("REGIDISPoutint = " + REGIDISPoutint);
		}
		if (BEQL !=Fetch2.BEQL().getBoolVal()) {
			BEQL = Fetch2.BEQL().getBoolVal();
			pw.println("BEQL = " + BEQL);
		}
		if (BNEQ !=Fetch2.BNEQ().getBoolVal()) {
			BNEQ = Fetch2.BNEQ().getBoolVal();
			pw.println("BNEQ = " + BNEQ);
		}
		if (BNEG !=Fetch2.BNEG().getBoolVal()) {
			BNEG = Fetch2.BNEG().getBoolVal();
			pw.println("BNEG = " + BNEG);
		}
		if (BNNG !=Fetch2.BNNG().getBoolVal()) {
			BNNG = Fetch2.BNNG().getBoolVal();
			pw.println("BNNG = " + BNNG);
		}
		if (BOVF !=Fetch2.BOVF().getBoolVal()) {
			BOVF = Fetch2.BOVF().getBoolVal();
			pw.println("BOVF = " + BOVF);
		}
		if (BNVF !=Fetch2.BNVF().getBoolVal()) {
			BNVF= Fetch2.BNVF().getBoolVal();
			pw.println("BNVF = " + BNVF);
		}
		if (BCR !=Fetch2.BCR().getBoolVal()) {
			BCR = Fetch2.BCR().getBoolVal();
			pw.println("BCR = " + BCR);
		}
		if (BNCR !=Fetch2.BNCR().getBoolVal()) {
			BNCR = Fetch2.BNCR().getBoolVal();
			pw.println("BNCR = " + BNCR);
		}
		if (BGRT !=Fetch2.BGRT().getBoolVal()) {
			BGRT = Fetch2.BGRT().getBoolVal();
			pw.println("BGRT = " + BGRT);
		}
		if (BGRE !=Fetch2.BGRE().getBoolVal()) {
			BGRE = Fetch2.BGRE().getBoolVal();
			pw.println("BGRE = " + BGRE);
		}
		if (BLSS !=Fetch2.BLSS().getBoolVal()) {
			BLSS = Fetch2.BLSS().getBoolVal();
			pw.println("BLSS = " + BLSS);
		}
		if (BLEQ !=Fetch2.BLEQ().getBoolVal()) {
			BLEQ = Fetch2.BLEQ().getBoolVal();
			pw.println("BLEQ = " + BLEQ);
		}
		if (BGRTU !=Fetch2.BGRTU().getBoolVal()) {
			BGRTU = Fetch2.BGRTU().getBoolVal();
			pw.println("BGRTU = " + BGRTU);
		}
		if (BGREU !=Fetch2.BGREU().getBoolVal()) {
			BGREU = Fetch2.BGREU().getBoolVal();
			pw.println("BGREU = " + BGREU);
		}
		if (BLSSU !=Fetch2.BLSSU().getBoolVal()) {
			BLSSU = Fetch2.BLSSU().getBoolVal();
			pw.println("BLSSU = " + BLSSU);
		}
		if (BLEQU !=Fetch2.BLEQU().getBoolVal()) {
			BLEQU = Fetch2.BLEQU().getBoolVal();
			pw.println("BLEQU = " + BLEQU);
		}
		if (JMP !=Fetch2.JMP().getBoolVal()) {
			JMP = Fetch2.JMP().getBoolVal();
			pw.println("JMP = " + JMP);
		}
		if (JSR !=Fetch2.JSR ().getBoolVal()) {
			JSR  = Fetch2.JSR ().getBoolVal();
			pw.println("JSR = " + JSR );
		}
		if (INT !=Fetch2.INT().getBoolVal()) {
			INT = Fetch2.INT().getBoolVal();
			pw.println("INT = " + INT);
		}
		if (RTS !=Fetch2.RTS().getBoolVal()) {
			RTS = Fetch2.RTS().getBoolVal();
			pw.println("RTS = " + RTS);
		}
		if (RTI !=Fetch2.RTI().getBoolVal()) {
			RTI = Fetch2.RTI().getBoolVal();
			pw.println("RTI = " + RTI);
		}
		if (ASR !=Fetch2.ASR().getBoolVal()) {
			ASR = Fetch2.ASR().getBoolVal();
			pw.println("ASR = " + ASR);
		}
		if (LSR !=Fetch2.LSR().getBoolVal()) {
			LSR = Fetch2.LSR().getBoolVal();
			pw.println("LSR = " + LSR);
		}
		if (ROR !=Fetch2.ROR().getBoolVal()) {
			ROR = Fetch2.ROR().getBoolVal();
			pw.println("ROR = " + ROR);
		}
		if (RORC !=Fetch2.RORC().getBoolVal()) {
			RORC = Fetch2.RORC().getBoolVal();
			pw.println("RORC = " + RORC);
		}
		if (ASL !=Fetch2.ASL().getBoolVal()) {
			ASL = Fetch2.ASL().getBoolVal();
			pw.println("ASL = " + ASL);
		}
		if (LSL !=Fetch2.LSL().getBoolVal()) {
			LSL = Fetch2.LSL().getBoolVal();
			pw.println("LSL = " + LSL);
		}
		if (ROL !=Fetch2.ROL().getBoolVal()) {
			ROL = Fetch2.ROL().getBoolVal();
			pw.println("ROL = " + ROL);
		}
		if (ROLC !=Fetch2.ROLC().getBoolVal()) {
			ROLC = Fetch2.ROLC().getBoolVal();
			pw.println("ROLC = " + ROLC);
		}
		if (INTE !=Fetch2.INTE().getBoolVal()) {
			INTE = Fetch2.INTE().getBoolVal();
			pw.println("INTE = " + INTE);
		}
		if (INTD !=Fetch2.INTD().getBoolVal()) {
			INTD = Fetch2.INTD().getBoolVal();
			pw.println("INTD = " + INTD);
		}
		if (TRPE !=Fetch2.TRPE().getBoolVal()) {
			TRPE = Fetch2.TRPE().getBoolVal();
			pw.println("TRPE = " + TRPE);
		}
		if (TRPD !=Fetch2.TRPD().getBoolVal()) {
			TRPD = Fetch2.TRPD().getBoolVal();
			pw.println("TRPD = " + TRPD);
		}
		if (STIVTP !=Fetch2.STIVTP().getBoolVal()) {
			STIVTP = Fetch2.STIVTP().getBoolVal();
			pw.println("STIVTP = " + STIVTP);
		}
		if (STSP !=Fetch2.STSP().getBoolVal()) {
			STSP = Fetch2.STSP().getBoolVal();
			pw.println("STSP = " + STSP);
		}
		if (NOP !=Fetch2.NOP().getBoolVal()) {
			NOP = Fetch2.NOP().getBoolVal();
			pw.println("NOP = " + NOP);
		}
		if (HALT !=Fetch2.HALT().getBoolVal()) {
			HALT = Fetch2.HALT().getBoolVal();
			pw.println("HALT = " + HALT);
		}
		if (LD !=Fetch2.LD().getBoolVal()) {
			LD = Fetch2.LD().getBoolVal();
			pw.println("LD = " + LD);
		}
		if (LDW !=Fetch2.LDW().getBoolVal()) {
			LDW = Fetch2.LDW().getBoolVal();
			pw.println("LDW = " + LDW);
		}
		if (ST !=Fetch2.ST().getBoolVal()) {
			ST = Fetch2.ST().getBoolVal();
			pw.println("ST = " + ST);
		}
		if (STW !=Fetch2.STW().getBoolVal()) {
			STW = Fetch2.STW().getBoolVal();
			pw.println("STW = " + STW);
		}
		if (ADD !=Fetch2.ADD ().getBoolVal()) {
			ADD  = Fetch2.ADD ().getBoolVal();
			pw.println("ADD  = " + ADD );
		}
		if (SUB !=Fetch2.SUB().getBoolVal()) {
			SUB = Fetch2.SUB().getBoolVal();
			pw.println("SUB = " + SUB);
		}
		if (AND !=Fetch2.AND().getBoolVal()) {
			AND = Fetch2.AND().getBoolVal();
			pw.println("AND = " + AND);
		}
		if (OR !=Fetch2.OR().getBoolVal()) {
			OR = Fetch2.OR().getBoolVal();
			pw.println("OR = " + OR);
		}
		if (XOR !=Fetch2.XOR().getBoolVal()) {
			XOR = Fetch2.XOR().getBoolVal();
			pw.println("XOR = " + XOR);
		}
		if (NOT !=Fetch2.NOT().getBoolVal()) {
			NOT = Fetch2.NOT().getBoolVal();
			pw.println("NOT = " + NOT);
		}
		if (regdir!=Fetch2.regdir().getBoolVal()) {
			regdir = Fetch2.regdir().getBoolVal();
			pw.println("regdir = " + regdir);
		}
		if (regindpom !=Fetch2.regindpom().getBoolVal()) {
			regindpom = Fetch2.regindpom().getBoolVal();
			pw.println("regindpom = " + regindpom);
		}
		if (pcrel !=Fetch2.pcrel().getBoolVal()) {
			pcrel = Fetch2.pcrel().getBoolVal();
			pw.println("pcrel = " + pcrel);
		}
		if (immed !=Fetch2.immed().getBoolVal()) {
			immed = Fetch2.immed().getBoolVal();
			pw.println("immed = " + immed);
		}
		if (gropr !=Fetch3.gropr().getBoolVal()) {
			gropr = Fetch3.gropr().getBoolVal();
			pw.println("gropr = " + gropr);
		}
		if (gradr !=Fetch3.gradr().getBoolVal()) {
			gradr = Fetch3.gradr().getBoolVal();
			pw.println("gradr = " + gradr);
		}
		if (I1 !=Fetch3.I1().getBoolVal()) {
			I1 = Fetch3.I1().getBoolVal();
			pw.println("I1 = " + I1);
		}
		if (I2_brnch !=Fetch3.I2_brnch().getBoolVal()) {
			I2_brnch = Fetch3.I2_brnch().getBoolVal();
			pw.println("I2_brnch = " + I2_brnch);
		}
		if (I2_arlog !=Fetch3.I2_arlog().getBoolVal()) {
			I2_arlog = Fetch3.I2_arlog().getBoolVal();
			pw.println("I2_arlog = " + I2_arlog);
		}
		if (I2 !=Fetch3.I2().getBoolVal()) {
			I2 = Fetch3.I2().getBoolVal();
			pw.println("I2 = " + I2);
		}
		if (I3_jump !=Fetch3.I3_jump().getBoolVal()) {
			I3_jump = Fetch3.I3_jump().getBoolVal();
			pw.println("I3_jump = " + I3_jump);
		}
		if (I3_arlog !=Fetch3.I3_arlog().getBoolVal()) {
			I3_arlog = Fetch3.I3_arlog().getBoolVal();
			pw.println("I3_arlog = " + I3_arlog);
		}
		if (I3 !=Fetch3.I3().getBoolVal()) {
			I3 = Fetch3.I3().getBoolVal();
			pw.println("I3 = " + I3);
		} 
		if (I4 !=Fetch3.I4().getBoolVal()) {
			I4 = Fetch3.I4().getBoolVal();
			pw.println("I4 = " + I4);
		}
		if (store !=Fetch3.store().getBoolVal()) {
			store = Fetch3.store().getBoolVal();
			pw.println("store = " + store);
		}
		
		
		//ADR,EXEC,INTR
		if (GPRDoutint !=Adr.GPRDout().getIntVal()) {
			GPRDoutint = Adr.GPRDout().getIntVal();
			pw.println("GPRDoutint = " + GPRDoutint);
		}
		if (GPRS1outint !=Adr.GPRS1out().getIntVal()) {
			GPRS1outint = Adr.GPRS1out().getIntVal();
			pw.println("GPRS1outint = " + GPRS1outint);
		}
		if (SP1outint !=Adr.SP1out().getIntVal()) {
			SP1outint = Adr.SP1out().getIntVal();
			pw.println("SP1outint = " + SP1outint);
		}
		if (PRoutint !=Adr.PRout().getIntVal()) {
			PRoutint = Adr.PRout().getIntVal();
			pw.println("PRoutint = " + PRoutint);
		}
		if (AB1outint !=Exec1.AB1out().getIntVal()) {
			AB1outint = Exec1.AB1out().getIntVal();
			pw.println("AB1outint = " + AB1outint);
		}
		if (AB2outint !=Exec1.AB2out().getIntVal()) {
			AB2outint = Exec1.AB2out().getIntVal();
			pw.println("AB2outint = " + AB2outint);
		}
		if (BBoutint !=Exec1.BBout().getIntVal()) {
			BBoutint = Exec1.BBout().getIntVal();
			pw.println("BBoutint = " + BBoutint);
		}
		if (ALUoutint !=Exec1.ALUout().getIntVal()) {
			ALUoutint = Exec1.ALUout().getIntVal();
			pw.println("ALUoutint = " + ALUoutint);
		}
		if (BWoutint !=Exec1.BWout().getIntVal()) {
			BWoutint = Exec1.BWout().getIntVal();
			pw.println("BWoutint = " + BWoutint);
		}
		if (AW1outint !=Exec1.AW1out().getIntVal()) {
			AW1outint = Exec1.AW1out().getIntVal();
			pw.println("AW1outint = " + AW1outint);
		}
		if (AW2outint !=Exec1.AW2out().getIntVal()) {
			AW2outint = Exec1.AW2out().getIntVal();
			pw.println("AW2outint = " + AW2outint);
		}
		if (PSWoutint !=Exec2.PSWout().getIntVal()) {
			PSWoutint = Exec2.PSWout().getIntVal();
			pw.println("PSWoutint = " + PSWoutint);
		}
		if (IMRoutint !=Intr1.IMRout().getIntVal()) {
			IMRoutint = Intr1.IMRout().getIntVal();
			pw.println("IMRoutint = " + IMRoutint);
		}
		if (IVTPoutint !=Intr3.IVTPout().getIntVal()) {
			IVTPoutint = Intr3.IVTPout().getIntVal();
			pw.println("IVTPoutint = " + IVTPoutint);
		}
		if (IVTDSPoutint !=Intr3.IVTDSPout().getIntVal()) {
			IVTDSPoutint = Intr3.IVTDSPout().getIntVal();
			pw.println("IVTDSPoutint = " + IVTDSPoutint);
		}
		

		if (R0 !=Adr.readGPR(0)) {
			R0 = Adr.readGPR(0);
			pw.println("R0 = " + R0);
		}
		if (R1 !=Adr.readGPR(1)) {
			R1 = Adr.readGPR(1);
			pw.println("R1 = " + R1);
		}
		if (R2 !=Adr.readGPR(2)) {
			R2 = Adr.readGPR(2);
			pw.println("R2 = " + R2);
		}
		if (R3 !=Adr.readGPR(3)) {
			R3 = Adr.readGPR(3);
			pw.println("R3 = " + R3);
		}
		if (R4 !=Adr.readGPR(4)) {
			R4 = Adr.readGPR(4);
			pw.println("R4 = " + R4);
		}
		if (R5 !=Adr.readGPR(5)) {
			R5 = Adr.readGPR(5);
			pw.println("R5 = " + R5);
		}
		if (R6 !=Adr.readGPR(6)) {
			R6 = Adr.readGPR(6);
			pw.println("R6 = " + R6);
		}
		if (R7 !=Adr.readGPR(7)) {
			R7 = Adr.readGPR(0);
			pw.println("R7 = " + R7);
		}
		if (R8 !=Adr.readGPR(8)) {
			R8 = Adr.readGPR(8);
			pw.println("R8 = " + R8);
		}
		if (R9 !=Adr.readGPR(9)) {
			R9 = Adr.readGPR(9);
			pw.println("R9 = " + R9);
		}
		if (SP !=Adr.SP().getIntVal()) {
			SP = Adr.SP().getIntVal();
			pw.println("SP = " + SP);
		}
		if (PR !=Adr.PR().getIntVal()) {
			PR = Adr.PR().getIntVal();
			pw.println("PR = " + PR);
		}
		if (GPRAR !=Adr.GPRAR().getIntVal()) {
			GPRAR = Adr.GPRAR().getIntVal();
			pw.println("GPRAR = " + GPRAR);
		}
		if (AB !=Exec1.AB().getIntVal()) {
			AB = Exec1.AB().getIntVal();
			pw.println("AB = " + AB);
		}
		if (BB !=Exec1.BB().getIntVal()) {
			BB = Exec1.BB().getIntVal();
			pw.println("BB = " + BB);
		}
		if (ALU !=Exec1.ALU().getIntVal()) {
			ALU = Exec1.ALU().getIntVal();
			pw.println("ALU = " + ALU);
		}
		if (BW !=Exec1.BW().getIntVal()) {
			BW = Exec1.BW().getIntVal();
			pw.println("BW = " + BW);
		}
		if (AW !=Exec1.AW().getIntVal()) {
			AW = Exec1.AW().getIntVal();
			pw.println("AW = " + AW);
		}
		if ( PSWI!=Exec2.PSWI().getBoolVal()) {
			PSWI = Exec2.PSWI().getBoolVal();
			pw.println("PSWI = " + PSWI);
		}
		if ( PSWT !=Exec2.PSWT().getBoolVal()) {
			PSWT = Exec2.PSWT().getBoolVal();
			pw.println("PSWT = " + PSWT);
		}
		if ( PSWZ!=Exec2.PSWZ().getBoolVal()) {
			PSWZ = Exec2.PSWZ().getBoolVal();
			pw.println("PSWZ = " + PSWZ);
		}
		if ( PSWN!=Exec2.PSWN().getBoolVal()) {
			PSWN = Exec2.PSWN().getBoolVal();
			pw.println("PSWN = " + PSWN);
		}
		if ( PSWV!=Exec2.PSWV().getBoolVal()) {
			PSWV = Exec2.PSWV().getBoolVal();
			pw.println("PSWV = " + PSWV);
		}
		if ( PSWC!=Exec2.PSWC().getBoolVal()) {
			PSWC = Exec2.PSWC().getBoolVal();
			pw.println("PSWC = " + PSWC);
		}
		if ( PSWL0!=Exec2.PSWL0().getBoolVal()) {
			PSWL0 = Exec2.PSWL0().getBoolVal();
			pw.println("PSWL0 = " + PSWL0);
		}
		if ( PSWL1!=Exec2.PSWL1().getBoolVal()) {
			PSWL1 = Exec2.PSWL1().getBoolVal();
			pw.println("PSWL1 = " + PSWL1);
		}
		
		if ( START!=Exec2.START().getBoolVal()) {
			START = Exec2.START().getBoolVal();
			pw.println("START = " + START);
		}
		if (PSW !=Exec2.PSW().getIntVal()) {
			PSW = Exec2.PSW().getIntVal();
			pw.println("PSW = " + PSW);
		}
		if ( Z!=Exec3.Z().getBoolVal()) {
			Z = Exec3.Z().getBoolVal();
			pw.println("Z = " + Z);
		}
		if ( N!=Exec3.N().getBoolVal()) {
			N = Exec3.N().getBoolVal();
			pw.println("N = " + N);
		}
		if ( V!=Exec3.V().getBoolVal()) {
			V = Exec3.V().getBoolVal();
			pw.println("V = " + V);
		}
		if ( C!=Exec3.C().getBoolVal()) {
			C = Exec3.C().getBoolVal();
			pw.println("C = " + C);
		}
		if ( brpom !=Exec4.brpom().getBoolVal()) {
			brpom = Exec4.brpom().getBoolVal();
			pw.println("brpom = " + brpom);
		}
		if ( PRINS !=Intr1.PRINS().getBoolVal()) {
			PRINS = Intr1.PRINS().getBoolVal();
			pw.println("PRINS = " + PRINS);
		}
		if ( PRCOD !=Intr1.PRCOD().getBoolVal()) {
			PRCOD = Intr1.PRCOD().getBoolVal();
			pw.println("PRCOD = " + PRCOD);
		}
		if ( PRADR !=Intr1.PRADR().getBoolVal()) {
			PRADR = Intr1.PRADR().getBoolVal();
			pw.println("PRADR = " + PRADR);
		}
		if ( PRINM !=Intr1.PRINM().getBoolVal()) {
			PRINM = Intr1.PRINM().getBoolVal();
			pw.println("PRINM = " + PRINM);
		}
		if ( prekid !=Intr1.prekid().getBoolVal()) {
			prekid = Intr1.prekid().getBoolVal();
			pw.println("prekid = " + prekid);
		}
		if (IMR !=Intr1.IMR().getIntVal()) {
			IMR = Intr1.IMR().getIntVal();
			pw.println("IMR = " + IMR);
		}
		if ( printr !=Intr2.printr().getBoolVal()) {
			printr = Intr2.printr().getBoolVal();
			pw.println("printr = " + printr);
		}
		if (UINT !=Intr3.UINT().getIntVal()) {
			UINT = Intr3.UINT().getIntVal();
			pw.println("UINT = " + UINT);
		}
		if (UEXT !=Intr3.UEXT().getIntVal()) {
			UEXT = Intr3.UEXT().getIntVal();
			pw.println("UEXT = " + UEXT);
		}
		if (BR !=Intr3.BR().getIntVal()) {
			BR = Intr3.BR().getIntVal();
			pw.println("BR = " + BR);
		}
		if (IVTP !=Intr3.IVTP().getIntVal()) {
			IVTP = Intr3.IVTP().getIntVal();
			pw.println("IVTP = " + IVTP);
		}
		if (IVTDSP !=Intr3.IVTDSP().getIntVal()) {
			IVTDSP = Intr3.IVTDSP().getIntVal();
			pw.println("IVTDSP = " + IVTDSP);
		}
		
		//OPER1
		if ( ldMAR !=Oper1.ldMAR().getBoolVal()) {
			ldMAR = Oper1.ldMAR().getBoolVal();
			pw.println("ldMAR = " + ldMAR);
		}
		if ( incMAR !=Oper1.incMAR().getBoolVal()) {
			incMAR = Oper1.incMAR().getBoolVal();
			pw.println("incMAR = " + incMAR);
		}
		if ( mxMDR1 !=Oper1.mxMDR1().getBoolVal()) {
			mxMDR1 = Oper1.mxMDR1().getBoolVal();
			pw.println("mxMDR1 = " + mxMDR1);
		}
		if ( mxMDR0 !=Oper1.mxMDR0().getBoolVal()) {
			mxMDR0 = Oper1.mxMDR0().getBoolVal();
			pw.println("mxMDR0 = " + mxMDR0);
		}
		if ( ldMDR !=Oper1.ldMDR().getBoolVal()) {
			ldMDR = Oper1.ldMDR().getBoolVal();
			pw.println("ldMDR = " + ldMDR);
		}
		if ( readm !=Oper1.readm().getBoolVal()) {
			readm = Oper1.readm().getBoolVal();
			pw.println("readm = " + readm);
		}
		if ( writem !=Oper1.writem().getBoolVal()) {
			writem = Oper1.writem().getBoolVal();
			pw.println("writem = " + writem);
		}
		if ( MDRout !=Oper1.MDRout().getBoolVal()) {
			MDRout = Oper1.MDRout().getBoolVal();
			pw.println("MDRout = " + MDRout);
		}
		if ( S2Dout !=Oper1.S2Dout().getBoolVal()) {
			S2Dout = Oper1.S2Dout().getBoolVal();
			pw.println("S2Dout = " + S2Dout);
		}
		if ( DS1out !=Oper1.DS1out().getBoolVal()) {
			DS1out = Oper1.DS1out().getBoolVal();
			pw.println("DS1out = " + DS1out);
		}
		if ( ldPC !=Oper1.ldPC().getBoolVal()) {
			ldPC = Oper1.ldPC().getBoolVal();
			pw.println("ldPC = " + ldPC);
		}
		if ( incPC !=Oper1.incPC().getBoolVal()) {
			incPC = Oper1.incPC().getBoolVal();
			pw.println("incPC = " + incPC);
		}
		if ( ldIR0 !=Oper1.ldIR0().getBoolVal()) {
			ldIR0 = Oper1.ldIR0().getBoolVal();
			pw.println("ldIR0 = " + ldIR0);
		}
		if ( ldIR1 !=Oper1.ldIR1().getBoolVal()) {
			ldIR1 = Oper1.ldIR1().getBoolVal();
			pw.println("ldIR1 = " + ldIR1);
		}
		if ( ldIR2 !=Oper1.ldIR2().getBoolVal()) {
			ldIR2 = Oper1.ldIR2().getBoolVal();
			pw.println("ldIR2 = " + ldIR2);
		}
		if ( ldIR3 !=Oper1.ldIR3().getBoolVal()) {
			ldIR3 = Oper1.ldIR3().getBoolVal();
			pw.println("ldIR3 = " + ldIR3);
		}
		if ( PC1out !=Oper1.PC1out().getBoolVal()) {
			PC1out = Oper1.PC1out().getBoolVal();
			pw.println("PC1out = " + PC1out);
		}
		if ( PC2out !=Oper1.PC2out().getBoolVal()) {
			PC2out = Oper1.PC2out().getBoolVal();
			pw.println("PC2out = " + PC2out);
		}
		if ( JDISPout !=Oper1.JDISPout().getBoolVal()) {
			JDISPout = Oper1.JDISPout().getBoolVal();
			pw.println("JDISPout = " + JDISPout);
		}
		if ( PCRDISPout !=Oper1.PCRDISPout().getBoolVal()) {
			PCRDISPout = Oper1.PCRDISPout().getBoolVal();
			pw.println("PCRDISPout = " + PCRDISPout);
		}
		if ( REGIDISPout !=Oper1.REGIDISPout().getBoolVal()) {
			REGIDISPout = Oper1.REGIDISPout().getBoolVal();
			pw.println("REGIDISPout = " + REGIDISPout);
		}
		if ( IMMout !=Oper1.IMMout().getBoolVal()) {
			IMMout = Oper1.IMMout().getBoolVal();
			pw.println("IMMout = " + IMMout);
		}
		if ( JAPSout !=Oper1.JAPSout().getBoolVal()) {
			JAPSout = Oper1.JAPSout().getBoolVal();
			pw.println("JAPSout = " + JAPSout);
		}
		if ( ldGPRAR !=Oper1.ldGPRAR().getBoolVal()) {
			ldGPRAR = Oper1.ldGPRAR().getBoolVal();
			pw.println("ldGPRAR = " + ldGPRAR);
		}
		if ( wrGPR !=Oper1.wrGPR().getBoolVal()) {
			wrGPR = Oper1.wrGPR().getBoolVal();
			pw.println("wrGPR = " + wrGPR);
		}
		if ( rdGPR !=Oper1.rdGPR().getBoolVal()) {
			rdGPR = Oper1.rdGPR().getBoolVal();
			pw.println("rdGPR = " + rdGPR);
		}
		if ( GPR1out !=Oper1.GPR1out().getBoolVal()) {
			GPR1out = Oper1.GPR1out().getBoolVal();
			pw.println("GPR1out = " + GPR1out);
		}
		if ( GPRDout !=Oper1.GPRDout().getBoolVal()) {
			GPRDout = Oper1.GPRDout().getBoolVal();
			pw.println("GPRDout = " + GPRDout);
		}
		if ( ldSP !=Oper1.ldSP().getBoolVal()) {
			ldSP = Oper1.ldSP().getBoolVal();
			pw.println("ldSP = " + ldSP);
		}
		if ( incSP !=Oper1.incSP().getBoolVal()) {
			incSP = Oper1.incSP().getBoolVal();
			pw.println("incSP = " + incSP);
		}
		if ( decSP !=Oper1.decSP().getBoolVal()) {
			decSP = Oper1.decSP().getBoolVal();
			pw.println("decSP = " + decSP);
		}
		if ( SP1out !=Oper1.SP1out().getBoolVal()) {
			SP1out = Oper1.SP1out().getBoolVal();
			pw.println("SP1out = " + SP1out);
		}
		if ( ldPR !=Oper1.ldPR().getBoolVal()) {
			ldPR = Oper1.ldPR().getBoolVal();
			pw.println("ldPR = " + ldPR);
		}
		if ( PRout !=Oper1.PRout().getBoolVal()) {
			PRout = Oper1.PRout().getBoolVal();
			pw.println("PRout = " + PRout);
		}
		if ( shr !=Oper2.shr().getBoolVal()) {
			shr = Oper2.shr().getBoolVal();
			pw.println("shr = " + shr);
		}
		if ( shl !=Oper2.shl().getBoolVal()) {
			shl = Oper2.shl().getBoolVal();
			pw.println("shl = " + shl);
		}

		if ( AB1out !=Oper2.AB1out().getBoolVal()) {
			AB1out = Oper2.AB1out().getBoolVal();
			pw.println("AB1out = " + AB1out);
		}

		if ( ldAB !=Oper2.ldAB().getBoolVal()) {
			ldAB = Oper2.ldAB().getBoolVal();
			pw.println("ldAB = " + ldAB);
		}

		if ( AB2out !=Oper2.AB2out().getBoolVal()) {
			AB2out = Oper2.AB2out().getBoolVal();
			pw.println("AB2out = " + AB2out);
		}

		if ( ldBB !=Oper2.ldBB().getBoolVal()) {
			ldBB = Oper2.ldBB().getBoolVal();
			pw.println("ldBB = " + ldBB);
		}

		if ( BBout !=Oper2.BBout().getBoolVal()) {
			BBout = Oper2.BBout().getBoolVal();
			pw.println("BBout = " + BBout);
		}

		if ( ldAW !=Oper2.ldAW().getBoolVal()) {
			ldAW = Oper2.ldAW().getBoolVal();
			pw.println("ldAW = " + ldAW);
		}

		if ( AW1out !=Oper2.AW1out().getBoolVal()) {
			AW1out = Oper2.AW1out().getBoolVal();
			pw.println("AW1out = " + AW1out);
		}

		if ( AW2out !=Oper2.AW2out().getBoolVal()) {
			AW2out = Oper2.AW2out().getBoolVal();
			pw.println("AW2out = " + AW2out);
		}
		if ( ldBWH !=Oper2.ldBWH().getBoolVal()) {
			ldBWH = Oper2.ldBWH().getBoolVal();
			pw.println("ldBWH = " + ldBWH);
		}
		if ( ldBWL !=Oper2.ldBWL().getBoolVal()) {
			ldBWL = Oper2.ldBWL().getBoolVal();
			pw.println("ldBWL = " + ldBWL);
		}
		if ( mxBWH !=Oper2.mxBWH().getBoolVal()) {
			mxBWH = Oper2.mxBWH().getBoolVal();
			pw.println("mxBWH = " + mxBWH);
		}
		if ( BWout !=Oper2.BWout().getBoolVal()) {
			BWout = Oper2.BWout().getBoolVal();
			pw.println("BWout = " + BWout);
		}
		if ( clPSWI !=Oper2.clPSWI().getBoolVal()) {
			clPSWI = Oper2.clPSWI().getBoolVal();
			pw.println("clPSWI = " + clPSWI);
		}
		if ( clPSWT !=Oper2.clPSWT().getBoolVal()) {
			clPSWT = Oper2.clPSWT().getBoolVal();
			pw.println("clPSWT = " + clPSWT);
		}
		if ( stPSWI !=Oper2.stPSWI().getBoolVal()) {
			stPSWI = Oper2.stPSWI().getBoolVal();
			pw.println("stPSWI = " + stPSWI);
		}
		if ( stPSWT !=Oper2.stPSWT().getBoolVal()) {
			stPSWT = Oper2.stPSWT().getBoolVal();
			pw.println("stPSWT = " + stPSWT);
		}
		if ( ldL !=Oper2.ldL().getBoolVal()) {
			ldL = Oper2.ldL().getBoolVal();
			pw.println("ldL = " + ldL);
		}
		if ( ldN !=Oper2.ldN().getBoolVal()) {
			ldN = Oper2.ldN().getBoolVal();
			pw.println("ldN = " + ldN);
		}
		if ( ldZ !=Oper2.ldZ().getBoolVal()) {
			ldZ = Oper2.ldZ().getBoolVal();
			pw.println("ldZ = " + ldZ);
		}
		if ( ldC !=Oper2.ldC().getBoolVal()) {
			ldC = Oper2.ldC().getBoolVal();
			pw.println("ldC = " + ldC);
		}
		if ( ldV !=Oper2.ldV().getBoolVal()) {
			ldV = Oper2.ldV().getBoolVal();
			pw.println("ldV = " + ldV);
		}
		if ( PSWout !=Oper2.PSWout().getBoolVal()) {
			PSWout = Oper2.PSWout().getBoolVal();
			pw.println("PSWout = " + PSWout);
		}
		if ( ldPSWL !=Oper2.ldPSWL().getBoolVal()) {
			ldPSWL = Oper2.ldPSWL().getBoolVal();
			pw.println("ldPSWL = " + ldPSWL);
		}
		if ( ldPSWH !=Oper2.ldPSWH().getBoolVal()) {
			ldPSWH = Oper2.ldPSWH().getBoolVal();
			pw.println("ldPSWH = " + ldPSWH);
		}
		if ( clSTART !=Oper2.clSTART().getBoolVal()) {
			clSTART = Oper2.clSTART().getBoolVal();
			pw.println("clSTART = " + clSTART);
		}
		if ( add !=Oper2.add().getBoolVal()) {
			add = Oper2.add().getBoolVal();
			pw.println("add = " + add);
		}
		if ( sub !=Oper2.sub().getBoolVal()) {
			sub = Oper2.sub().getBoolVal();
			pw.println("sub = " + sub);
		}
		if ( and !=Oper2.and().getBoolVal()) {
			and = Oper2.and().getBoolVal();
			pw.println("and = " + and);
		}
		if ( or !=Oper2.or().getBoolVal()) {
			or = Oper2.or().getBoolVal();
			pw.println("or = " + or);
		}
		if ( xor !=Oper2.xor().getBoolVal()) {
			xor = Oper2.xor().getBoolVal();
			pw.println("xor = " + xor);
		}
		if ( not !=Oper2.not().getBoolVal()) {
			not = Oper2.not().getBoolVal();
			pw.println("not = " + not);
		}
		if ( ALUout !=Oper2.ALUout().getBoolVal()) {
			ALUout = Oper2.ALUout().getBoolVal();
			pw.println("ALUout = " + ALUout);
		}
		if ( stPRINS !=Oper2.stPRINS().getBoolVal()) {
			stPRINS = Oper2.stPRINS().getBoolVal();
			pw.println("stPRINS = " + stPRINS);
		}
		if ( clPRINS !=Oper2.clPRINS().getBoolVal()) {
			clPRINS = Oper2.clPRINS().getBoolVal();
			pw.println("clPRINS = " + clPRINS);
		}
		if ( stPRCOD !=Oper2.stPRCOD().getBoolVal()) {
			stPRCOD = Oper2.stPRCOD().getBoolVal();
			pw.println("stPRCOD = " + stPRCOD);
		}
		if ( clPRCOD !=Oper2.clPRCOD().getBoolVal()) {
			clPRCOD = Oper2.clPRCOD().getBoolVal();
			pw.println("clPRCOD = " + clPRCOD);
		}
		if ( stPRADR !=Oper2.stPRADR().getBoolVal()) {
			stPRADR = Oper2.stPRADR().getBoolVal();
			pw.println("stPRADR = " + stPRADR);
		}
		if ( clPRADR !=Oper2.clPRADR().getBoolVal()) {
			clPRADR = Oper2.clPRADR().getBoolVal();
			pw.println("clPRADR = " + clPRADR);
		}
		if ( clPRINM !=Oper2.clPRINM().getBoolVal()) {
			clPRINM = Oper2.clPRINM().getBoolVal();
			pw.println("clPRINM = " + clPRINM);
		}
		if ( clINTR !=Oper2.clINTR().getBoolVal()) {
			clINTR = Oper2.clINTR().getBoolVal();
			pw.println("clINTR = " + clINTR);
		}
		if ( ldIVTP !=Oper2.ldIVTP().getBoolVal()) {
			ldIVTP = Oper2.ldIVTP().getBoolVal();
			pw.println("ldIVTP = " + ldIVTP);
		}
		if ( IVTPout !=Oper2.IVTPout().getBoolVal()) {
			IVTPout = Oper2.IVTPout().getBoolVal();
			pw.println("IVTPout = " + IVTPout);
		}
		if ( IVTDSPout !=Oper2.IVTDSPout().getBoolVal()) {
			IVTDSPout = Oper2.IVTDSPout().getBoolVal();
			pw.println("IVTDSPout = " + IVTDSPout);
		}
		if ( mxBR0 !=Oper2.mxBR0().getBoolVal()) {
			mxBR0 = Oper2.mxBR0().getBoolVal();
			pw.println("mxBR0 = " + mxBR0);
		}
		if ( mxBR1 !=Oper2.mxBR1().getBoolVal()) {
			mxBR1 = Oper2.mxBR1().getBoolVal();
			pw.println("mxBR1 = " + mxBR1);
		}
		if ( ldBR !=Oper2.ldBR().getBoolVal()) {
			ldBR = Oper2.ldBR().getBoolVal();
			pw.println("ldBR = " + ldBR);
		}
		//UPRAV1
		if ( bradr !=Uprav1.bradr().getBoolVal()) {
			bradr = Uprav1.bradr().getBoolVal();
			pw.println("bradr = " + bradr);
		}
		if ( bropr !=Uprav1.bropr().getBoolVal()) {
			bropr = Uprav1.bropr().getBoolVal();
			pw.println("bropr = " + bropr);
		}
		if ( brnotSTART !=Uprav1.brnotSTART().getBoolVal()) {
			brnotSTART = Uprav1.brnotSTART().getBoolVal();
			pw.println("brnotSTART = " + brnotSTART);
		}
		if ( brnotbrpom !=Uprav1.brnotbrpom().getBoolVal()) {
			brnotbrpom = Uprav1.brnotbrpom().getBoolVal();
			pw.println("bradr = " + bradr);
		}
		if ( brnotprekid !=Uprav1.brnotprekid().getBoolVal()) {
			brnotprekid = Uprav1.brnotprekid().getBoolVal();
			pw.println("brnotprekid = " + brnotprekid);
		}
		if ( brnotPRINS !=Uprav1.brnotPRINS().getBoolVal()) {
			brnotPRINS = Uprav1.brnotPRINS().getBoolVal();
			pw.println("brnotPRINS = " + brnotPRINS);
		}
		if ( brnotPRCOD !=Uprav1.brnotPRCOD().getBoolVal()) {
			brnotPRCOD = Uprav1.brnotPRCOD().getBoolVal();
			pw.println("brnotPRCOD = " + brnotPRCOD);
		}
		if ( brnotPRADR !=Uprav1.brnotPRADR().getBoolVal()) {
			brnotPRADR = Uprav1.brnotPRADR().getBoolVal();
			pw.println("brnotPRADR = " + brnotPRADR);
		}
		if ( brnotPRINM !=Uprav1.brnotPRINM().getBoolVal()) {
			brnotPRINM = Uprav1.brnotPRINM().getBoolVal();
			pw.println("brnotPRINM = " + brnotPRINM);
		}
		if ( brnotprintr !=Uprav1.brnotprintr().getBoolVal()) {
			brnotprintr = Uprav1.brnotprintr().getBoolVal();
			pw.println("brnotprintr = " + brnotprintr);
		}
		if ( brnotgropr !=Uprav1.brnotgropr().getBoolVal()) {
			brnotgropr = Uprav1.brnotgropr().getBoolVal();
			pw.println("brnotgropr = " + brnotgropr);
		}
		if ( brI1 !=Uprav1.brI1().getBoolVal()) {
			brI1 = Uprav1.brI1().getBoolVal();
			pw.println("brI1 = " + brI1);
		}
		if ( brnotgradr !=Uprav1.brnotgradr().getBoolVal()) {
			brnotgradr = Uprav1.brnotgradr().getBoolVal();
			pw.println("bradr = " + bradr);
		}
		if ( brnotgradr !=Uprav1.brnotgradr().getBoolVal()) {
			brnotgradr = Uprav1.brnotgradr().getBoolVal();
			pw.println("brnotgradr = " + brnotgradr);
		}
		if ( brI2_brnch !=Uprav1.brI2_brnch().getBoolVal()) {
			brI2_brnch = Uprav1.brI2_brnch().getBoolVal();
			pw.println("brI2_brnch = " + brI2_brnch);
		}
		if ( brI2_arlog !=Uprav1.brI2_arlog().getBoolVal()) {
			brI2_arlog = Uprav1.brI2_arlog().getBoolVal();
			pw.println("brI2_arlog = " + brI2_arlog);
		}
		if ( brI3_jump !=Uprav1.brI3_jump().getBoolVal()) {
			brI3_jump = Uprav1.brI3_jump().getBoolVal();
			pw.println("brI3_jump = " + brI3_jump);
		}
		if ( brI3_arlog !=Uprav1.brI3_arlog().getBoolVal()) {
			brI3_arlog = Uprav1.brI3_arlog().getBoolVal();
			pw.println("brI3_arlog = " + brI3_arlog);
		}
		if ( bruncnd !=Uprav1.bruncnd().getBoolVal()) {
			bruncnd = Uprav1.bruncnd().getBoolVal();
			pw.println("bruncnd = " + bruncnd);
		}
		if ( brcnd !=Uprav1.brcnd().getBoolVal()) {
			brcnd = Uprav1.brcnd().getBoolVal();
			pw.println("brcnd = " + brcnd);
		}
		//if ( brbrqstart !=Uprav1.brbrqstart().getBoolVal()) {
		//	brbrqstart = Uprav1.brbrqstart().getBoolVal();
		//	pw.println("brbrqstart = " + brbrqstart);
		//}
		if ( brnotbrqstop !=Uprav1.brnotbrqstop().getBoolVal()) {
			brnotbrqstop = Uprav1.brnotbrqstop().getBoolVal();
			pw.println("brnotbrqstop = " + brnotbrqstop);
		}
		if ( brstore !=Uprav1.brstore().getBoolVal()) {
			brstore = Uprav1.brstore().getBoolVal();
			pw.println("brstore = " + brstore);
		}
		if ( brLDW !=Uprav1.brLDW().getBoolVal()) {
			brLDW = Uprav1.brLDW().getBoolVal();
			pw.println("brLDW = " + brLDW);
		}
		if ( brregdir !=Uprav1.brregdir().getBoolVal()) {
			brregdir = Uprav1.brregdir().getBoolVal();
			pw.println("brregdir = " + brregdir);
		}
		//UPRAV2
		if ( val01 !=Uprav2.val01().getBoolVal()) {
			val01 = Uprav2.val01().getBoolVal();
			pw.println("val01 = " + val01);
		}
		if ( val04 !=Uprav2.val04().getBoolVal()) {
			val04 = Uprav2.val04().getBoolVal();
			pw.println("val04 = " + val04);
		}
		if ( val08 !=Uprav2.val08().getBoolVal()) {
			val08 = Uprav2.val08().getBoolVal();
			pw.println("val08 = " + val08);
		}
		if ( val0B !=Uprav2.val0B().getBoolVal()) {
			val0B = Uprav2.val0B().getBoolVal();
			pw.println("val0B = " + val0B);
		}
		if ( val0F !=Uprav2.val0F().getBoolVal()) {
			val0F = Uprav2.val0F().getBoolVal();
			pw.println("val0F = " + val0F);
		}
		if ( val13 !=Uprav2.val13().getBoolVal()) {
			val13 = Uprav2.val13().getBoolVal();
			pw.println("val13 = " + val13);
		}
		if ( val18 !=Uprav2.val18().getBoolVal()) {
			val18 = Uprav2.val18().getBoolVal();
			pw.println("val18 = " + val18);
		}
		if ( val1E !=Uprav2.val1E().getBoolVal()) {
			val1E = Uprav2.val1E().getBoolVal();
			pw.println("val1E = " + val1E);
		}
		if ( val24 !=Uprav2.val24().getBoolVal()) {
			val24 = Uprav2.val24().getBoolVal();
			pw.println("val24 = " + val24);
		}
		if ( val25 !=Uprav2.val25().getBoolVal()) {
			val25 = Uprav2.val25().getBoolVal();
			pw.println("val25 = " + val25);
		}
		if ( val28 !=Uprav2.val28().getBoolVal()) {
			val28 = Uprav2.val28().getBoolVal();
			pw.println("val28 = " + val28);
		}
		if ( val2A !=Uprav2.val2A().getBoolVal()) {
			val2A = Uprav2.val2A().getBoolVal();
			pw.println("val2A = " + val2A);
		}
		if ( val3A !=Uprav2.val3A().getBoolVal()) {
			val3A = Uprav2.val3A().getBoolVal();
			pw.println("val3A = " + val3A);
		}
		if ( val3C !=Uprav2.val3C().getBoolVal()) {
			val3C = Uprav2.val3C().getBoolVal();
			pw.println("val3C = " + val3C);
		}
		if ( val40 !=Uprav2.val40().getBoolVal()) {
			val40 = Uprav2.val40().getBoolVal();
			pw.println("val40 = " + val40);
		}
		if ( val43 !=Uprav2.val43().getBoolVal()) {
			val43 = Uprav2.val43().getBoolVal();
			pw.println("val43 = " + val43);
		}
		if ( val45 !=Uprav2.val45().getBoolVal()) {
			val45 = Uprav2.val45().getBoolVal();
			pw.println("val45 = " + val45);
		}
		if ( val5F !=Uprav2.val5F().getBoolVal()) {
			val5F = Uprav2.val5F().getBoolVal();
			pw.println("val5F = " + val5F);
		}
		if ( val62 !=Uprav2.val62().getBoolVal()) {
			val62 = Uprav2.val62().getBoolVal();
			pw.println("val62 = " + val62);
		}
		if ( val67 !=Uprav2.val67().getBoolVal()) {
			val67 = Uprav2.val67().getBoolVal();
			pw.println("val67 = " + val67);
		}
		if ( val6A !=Uprav2.val6A().getBoolVal()) {
			val6A = Uprav2.val6A().getBoolVal();
			pw.println("val6A = " + val6A);
		}
		if ( val6F !=Uprav2.val6F().getBoolVal()) {
			val6F = Uprav2.val6F().getBoolVal();
			pw.println("val6F = " + val6F);
		}
		if ( val72 !=Uprav2.val72().getBoolVal()) {
			val72 = Uprav2.val72().getBoolVal();
			pw.println("val72 = " + val72);
		}
		if ( val78 !=Uprav2.val78().getBoolVal()) {
			val78 = Uprav2.val78().getBoolVal();
			pw.println("val78 = " + val78);
		}
		if ( val7B !=Uprav2.val7B().getBoolVal()) {
			val7B = Uprav2.val7B().getBoolVal();
			pw.println("val7B = " + val7B);
		}
		if ( val7E !=Uprav2.val7E().getBoolVal()) {
			val7E = Uprav2.val7E().getBoolVal();
			pw.println("val7E = " + val7E);
		}
		if ( val81 !=Uprav2.val81().getBoolVal()) {
			val81 = Uprav2.val81().getBoolVal();
			pw.println("val81 = " + val81);
		}
		if ( val84 !=Uprav2.val84().getBoolVal()) {
			val84 = Uprav2.val84().getBoolVal();
			pw.println("val84 = " + val84);
		}
		if ( val86 !=Uprav2.val86().getBoolVal()) {
			val86 = Uprav2.val86().getBoolVal();
			pw.println("val86 = " + val86);
		}
		if ( val88 !=Uprav2.val88().getBoolVal()) {
			val88 = Uprav2.val88().getBoolVal();
			pw.println("val88 = " + val88);
		}
		if ( val8A !=Uprav2.val8A().getBoolVal()) {
			val8A = Uprav2.val8A().getBoolVal();
			pw.println("val8A = " + val8A);
		}
		if ( val8C !=Uprav2.val8C().getBoolVal()) {
			val8C = Uprav2.val8C().getBoolVal();
			pw.println("val8C = " + val8C);
		}
		if ( val90 !=Uprav2.val90().getBoolVal()) {
			val90 = Uprav2.val90().getBoolVal();
			pw.println("val90 = " + val90);
		}
		if ( val93 !=Uprav2.val93().getBoolVal()) {
			val93 = Uprav2.val93().getBoolVal();
			pw.println("val93 = " + val93);
		}
		if ( val00 !=Uprav2.val00().getBoolVal()) {
			val00 = Uprav2.val00().getBoolVal();
			pw.println("val00 = " + val00);
		}
		if ( val2D !=Uprav2.val2D().getBoolVal()) {
			val2D = Uprav2.val2D().getBoolVal();
			pw.println("val2D = " + val2D);
		}
		if ( val75 !=Uprav2.val75().getBoolVal()) {
			val75 = Uprav2.val75().getBoolVal();
			pw.println("val75 = " + val75);
		}
		if ( val1A !=Uprav2.val1A().getBoolVal()) {
			val1A = Uprav2.val1A().getBoolVal();
			pw.println("val1A = " + val1A);
		}
		if ( val8D !=Uprav2.val8D().getBoolVal()) {
			val8D = Uprav2.val8D().getBoolVal();
			pw.println("val8D = " + val8D);
		}
		//MEM
		//if ( rdMEM !=Mem1.rdMEM().getBoolVal()) {
		//	rdMEM = Mem1.rdMEM().getBoolVal();
		//	pw.println("rdMEM = " + rdMEM);
		//}
		//if ( wrMEM !=Mem1.wrMEM().getBoolVal()) {
		//	wrMEM = Mem1.wrMEM().getBoolVal();
		//	pw.println("wrMEM = " + wrMEM);
		//}
		//if ( REQUEST !=Mem1.REQUEST().getBoolVal()) {
		//	REQUEST = Mem1.REQUEST().getBoolVal();
		//	pw.println("REQUEST = " + REQUEST);
		//}
		//if ( memEND !=Mem1.END().getBoolVal()) {
		//	memEND = Mem1.END().getBoolVal();
		//	pw.println("memEND = " + memEND);
		//}
		//if ( incMEMACC !=Mem2.incMEMACC().getBoolVal()) {
		//	incMEMACC = Mem2.incMEMACC().getBoolVal();
		//	pw.println("incMEMACC = " + incMEMACC);
		//}
		//if ( fcMEM !=Mem2.fcMEM().getBoolVal()) {
		//	fcMEM = Mem2.fcMEM().getBoolVal();
		//	pw.println("fcMEM = " + fcMEM);
		//}
		//if ( memCNTINC !=Mem3.CNTINC().getBoolVal()) {
		//	memCNTINC = Mem3.CNTINC().getBoolVal();
		//	pw.println("memCNTINC = " + memCNTINC);
		//}
		//if ( memCNTLD !=Mem3.CNTLD().getBoolVal()) {
		//	memCNTLD = Mem3.CNTLD().getBoolVal();
		//	pw.println("memCNTLD = " + memCNTLD);
		//}
		//if ( memCNT !=Mem3.CNT().getIntVal()) {
		//	memCNT = Mem3.CNT().getIntVal();
		//	pw.println("memCNT = " + memCNT);
		//}
		//if ( memT0 !=Mem3.T0().getBoolVal()) {
		//	memT0 = Mem3.T0().getBoolVal();
		//	pw.println("memT0 = " + memT0);
		//}
		//if ( memT1 !=Mem3.T1().getBoolVal()) {
		//	memT1 = Mem3.T1().getBoolVal();
		//	pw.println("memT1 = " + memT1);
		//}
		//if ( memT2 !=Mem3.T2().getBoolVal()) {
		//	memT2 = Mem3.T2().getBoolVal();
		//	pw.println("memT2 = " + memT2);
		//}
		//if ( memT3 !=Mem3.T3().getBoolVal()) {
		//	memT3 = Mem3.T3().getBoolVal();
		//	pw.println("memT3 = " + memT3);
		//}
		//if ( memFC !=Mem4.FC().getBoolVal()) {
		//	memFC = Mem4.FC().getBoolVal();
		//	pw.println("memFC = " + memFC);
		//}
		//if ( membruncnd !=Mem4.bruncnd().getBoolVal()) {
		//	membruncnd = Mem4.bruncnd().getBoolVal();
		//	pw.println("membruncnd = " + membruncnd);
		//}
		//if ( membrcnd !=Mem4.brcnd().getBoolVal()) {
		//	membrcnd = Mem4.brcnd().getBoolVal();
		//	pw.println("membrcnd = " + membrcnd);
		//}
		//if ( memval0 !=Mem4.val0().getBoolVal()) {
		//	memval0 = Mem4.val0().getBoolVal();
		//	pw.println("memval0 = " + memval0);
		//}
		//if ( memval1 !=Mem4.val1().getBoolVal()) {
		//	memval1 = Mem4.val1().getBoolVal();
		//	pw.println("memval1 = " + memval1);
		//}
		//if ( memval2 !=Mem4.val2().getBoolVal()) {
		//	memval2 = Mem4.val2().getBoolVal();
		//	pw.println("memval2 = " + memval2);
		//}
		//MEM new
		
		
		if ( memrdbus !=Mem11.rdbus().getBoolVal()) {
			memrdbus = Mem11.rdbus().getBoolVal();
			pw.println("memrdbus = " + memrdbus);
			
		}
		if ( memwrbus !=Mem11.wrbus().getBoolVal()) {
			memwrbus = Mem11.wrbus().getBoolVal();
			pw.println("memwrbus = " + memwrbus);
			
		}
		if ( memrds !=Mem11.rds().getBoolVal()) {
			memrds = Mem11.rds().getBoolVal();
			pw.println("memrds = " + memrds);
			
		}
		if ( memwrs !=Mem11.wrs().getBoolVal()) {
			memwrs = Mem11.wrs().getBoolVal();
			pw.println("memwrs = " + memwrs);
			
		}
		if ( memrw !=Mem11.rw().getBoolVal()) {
			memrw = Mem11.rw().getBoolVal();
			pw.println("memrw = " + memrw);
			
		}
		if ( memaccess !=Mem11.access().getBoolVal()) {
			memaccess = Mem11.access().getBoolVal();
			pw.println("memaccess = " + memaccess);
			
		}
		if ( memTime !=Mem11.TIME().getIntVal()) {
			memTime = Mem11.TIME().getIntVal();
			pw.println("memTime = " + memTime);
			
		}
		if ( memPDR !=Mem11.PDR().getIntVal()) {
			memPDR = Mem11.PDR().getIntVal();
			pw.println("memPDR = " + memPDR);
			
		}
		if ( memPDRout !=Mem11.PDRout().getIntVal()) {
			memPDRout = Mem11.PDRout().getIntVal();
			pw.println("memPDRout = " + memPDRout);
			
		}
		if ( memCNT0 !=Mem12.CNT0().getBoolVal()) {
			memCNT0 = Mem12.CNT0().getBoolVal();
			pw.println("memCNT0 = " + memCNT0);
			
		}
		if ( memCNT1 !=Mem12.CNT1().getBoolVal()) {
			memCNT1 = Mem12.CNT1().getBoolVal();
			pw.println("memCNT1 = " + memCNT1);
			
		}
		if ( memldCNT !=Mem12.ldCNT().getBoolVal()) {
			memldCNT = Mem12.ldCNT().getBoolVal();
			pw.println("memldCNT = " + memldCNT);
			
		}
		if ( memincCNT !=Mem12.incCNT().getBoolVal()) {
			memincCNT = Mem12.incCNT().getBoolVal();
			pw.println("memincCNT = " + memincCNT);
			
		}
		if ( memT0 !=Mem12.T0().getBoolVal()) {
			memT0 = Mem12.T0().getBoolVal();
			pw.println("memT0 = " + memT0);
			
		}
		if ( memT1 !=Mem12.T1().getBoolVal()) {
			memT1 = Mem12.T1().getBoolVal();
			pw.println("memT1 = " + memT1);
			
		}
		if ( memT2 !=Mem12.T2().getBoolVal()) {
			memT2 = Mem12.T2().getBoolVal();
			pw.println("memT2 = " + memT2);
			
		}
		if ( memOEdata !=Mem12.OEdata().getBoolVal()) {
			memOEdata = Mem12.OEdata().getBoolVal();
			pw.println("memOEdata = " + memOEdata);
			
		}
		if ( memPDRin !=Mem12.PDRin().getBoolVal()) {
			memPDRin = Mem12.PDRin().getBoolVal();
			pw.println("memPDrin = " + memPDRin);
			
		}
		if ( memdecTime !=Mem12.decTIME().getBoolVal()) {
			memdecTime = Mem12.decTIME().getBoolVal();
			pw.println("memdecTime = " + memdecTime);
			
		}
		if ( memldTime !=Mem12.ldTIME().getBoolVal()) {
			memldTime = Mem12.ldTIME().getBoolVal();
			pw.println("memldTime = " + memldTime);
			
		}
		if ( memfcbus !=Mem12.fcbus().getBoolVal()) {
			memfcbus = Mem12.fcbus().getBoolVal();
			pw.println("memfcbus = " + memfcbus);
			
		}
		if ( memOEfcbus !=Mem12.OEfcbus().getBoolVal()) {
			memOEfcbus = Mem12.OEfcbus().getBoolVal();
			pw.println("memOEfcbus = " + memOEfcbus);
			
		}
		if ( PDRoutint !=Mem11.PDRout().getIntVal()) {
			PDRoutint = Mem11.PDRout().getIntVal();
			pw.println("PDRoutint = " + PDRoutint);
			
		}
		
		
		
		
		pw.println("--------------------------------");
		
	}

}
