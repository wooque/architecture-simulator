package components;

public class Test {

	public static void main(String[] args) {
		
		//registar A
		REG a=new REG(1,"A");
		a.getOut(0).setIsInt();
		Pin inca = new Pin(false); //incA
		a.setPinInc(inca);
		Pin lda = new Pin(false); //ldA
		a.setPinLd(lda);
		
		//registar B
		REG b=new REG(1,"B");
		b.getOut(0).setIsInt();
		Pin incb = new Pin(false);//incB
		b.setPinInc(incb);
		Pin ldb = new Pin(false);//ldB
		b.setPinLd(ldb);
		
		//ALU jedinica
		ALU alu=new ALU();
		alu.setInputPin(0, a.getOut(0));
		alu.setInputPin(1, b.getOut(0));
		Pin add = new Pin(false); //add Pin
		alu.setPinAdd(add);
		
		//trostaticki bafer na izlazu ALU
		TSB aluout=new TSB();
		Pin ctrlaluout = new Pin(false);//aluout signal na TSB
		aluout.setCtrl(ctrlaluout);
		aluout.setInputPin(0, alu.getOut(0));
		
		//Magistrala
		BUS bus=new BUS(1,2,"BUS");
		bus.setClock(1); //osnovni klok
		bus.setInputPin(0, aluout.getOut(0));
		
		a.setInputPin(0, bus.getOut(0));
		b.setInputPin(0, bus.getOut(1));
		
		inca.setBoolVal(true);	//inkrementiramo A;
		incb.setBoolVal(true);	//inkrementiramo B;
		add.setBoolVal(true);	// aktivno sabiranje
		ctrlaluout.setBoolVal(true);	//pustamo na magistralu
		LogicalComponent.CLK();	//posle signala kloka trebalo bi da je A=1, B=1, a na magistrali 2
		System.out.print("A = " + a.getOut(0).getIntVal());
		System.out.print("; B = " + b.getOut(0).getIntVal());
		System.out.println("; BUS = " + bus.getOut(0).getIntVal());
		inca.setBoolVal(false);		//ukidamo inkrementiranje
		incb.setBoolVal(false);		//ukidamo inkrementiranje
		lda.setBoolVal(true);		//ucitavanje sa magistrale u A
		LogicalComponent.CLK();	//trebalo bi A=2, B=1, BUS=3
		System.out.print("A = " + a.getOut(0).getIntVal());
		System.out.print("; B = " + b.getOut(0).getIntVal());
		System.out.println("; BUS = " + bus.getOut(0).getIntVal());
	
	}
}
