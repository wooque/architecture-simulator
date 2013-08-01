package components;

public class Aggregator extends LogicalComponent {
	
	public Aggregator(int in, int numOfLines) {
		super(in, 1, false);
		out[0].setIsInt();
		out[0].setNumOfLines(numOfLines);
	}

	public void func() {
		int currNumOfLines = 0;
		int value = 0;
		for(int i = 0; i < in.length; i++) {
			value += (in[i].getIntVal() << currNumOfLines);
			currNumOfLines += in[i].getNumOfLines();
		}
		out[0].setIntVal(value);
	}

	public static void main(String[] args) {
		Aggregator agg = new Aggregator(3, 16);
		agg.setInputPin(0, new Pin(1, 1));
		agg.setInputPin(1, new Pin(256, 9));
		agg.setInputPin(2, new Pin(15, 6));
		agg.func();
		System.out.printf("%x\n", agg.getOut(0).getIntVal()); //3e01 expected
	}

}
