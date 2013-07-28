package components;

public class IntToInt extends LogicalComponent {	//@Darko
	
	//Adaptira value tipa INT sa npr: 16 na 8 linija ili sa 8 na 16 linija
	private int numInputLines; // broj ulaznih linija
	private int numOutputLines; // broj izlaznih linija
	private boolean withSign; // ako je true->treba prosiriti sa npr 8 input
								// na 16 output linija ZNAKOM,false->prosiriti nulama
	private boolean seeHighBits;

	// ako se npr sa 16 na 8 linija suzava da li na izlaz ide nizih ili visih 8 bita
	// pojavljuje se u bus1 kada treba podatak od 16 bita smestiti u memoriju u
	// MDR koji je 8 bita pa se smesta prvo visih a potom i nizih 8 bita
	public IntToInt(int nil, int nol) {
		this(nil, nol, false, false);
	}

	public IntToInt(int nil, int nol, boolean shb, boolean withS) {
		super(1, 1, false);
		numInputLines = nil;
		numOutputLines = nol;
		seeHighBits = shb;
		withSign = withS;
		out[0].setIsInt();
		out[0].setNumOfLines(nol);
		

	}

	public void func() {

		int input = in[0].getIntVal() & calculateArrayOfOnes(numInputLines);
		if (numInputLines > numOutputLines) {// suzavanje

			if (seeHighBits) {
				input = input >> (numInputLines-numOutputLines);
				out[0].setIntVal(input);// na izlaz idu visi biti
			} else {
				int flag = calculateArrayOfOnes(numOutputLines);
				input = input & flag;// izdvojeni samo nizi biti
				out[0].setIntVal(input);// na izlaz idu nizi biti
			}
		}
		if (numInputLines < numOutputLines) {// prosirivanje
			if (withSign) {
				int flagForSign = 1 << (numInputLines - 1);
				if ((input & flagForSign) > 0) {// najvisi bit ulaza je 1 pa
												// treba prosiriti sa 1
					int pos = 1 << numInputLines;
					for (int i = numInputLines; i < numOutputLines; i++) {
						input = input | pos;
						pos = pos << 1;
					}
					out[0].setIntVal(input);// na izlaz ide ulaz prosiren sa 1 jer
					// najvisi bit ulaza je 1 pa treba prosiriti sa 1

				} else {
					out[0].setIntVal(input);// na izlaz ide ulaz prosiren nulama jer
					// najvisi bit ulaza je 0 pa treba prosiriti sa 0
				}

			} else {
				out[0].setIntVal(input);// na izlaz ide ulaz prosiren nulama
			}

		}

	}
	private int calculateArrayOfOnes(int numOnes) {
		int flag = 1;
		for (int i = 1; i < numInputLines; i++) {
			flag = flag << 1;// pomeri udesno
			flag = flag | 1;// umetne 1
			
		}
		return flag;
	}
	public static void main(String[] args){
		IntToInt iti=new IntToInt(16,8);
		Pin p=new Pin();
		p.setNumOfLines(16);
		p.setIsInt();
		p.setIntVal(3);
		iti.setInputPin(0, p);
		iti.func();
		System.out.println("Izlaz je "+iti.getOut(0).getIntVal());
	}
}
