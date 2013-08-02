package sim.components;

public class Spliter extends LogicalComponent {
	
	private int begin, end;
	
	public Spliter(int begin, int end) {
		super(1, 1, false);
		out[0].setIsInt();
		out[0].setNumOfLines(end - begin);
		this.begin = begin / (end - begin);
		this.end = end / (end - begin);
	}

	public void func() {
		int value = in[0].getIntVal();
		value >>= begin;
		int mask = 0;
		for(int i = 0; i < end + 1; i++) {
			mask <<= 1;
			mask |= 1;
		}
		value &= mask;
		out[0].setIntVal(value);
	}

	public static void main(String[] args) {
		Spliter split = new Spliter(2, 3);
		split.setInputPin(0, new Pin(10, 8));
		split.func();
		System.out.printf("%x\n", split.getOut(0).getIntVal()); //2 expected
	}

}
