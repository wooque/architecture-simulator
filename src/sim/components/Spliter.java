package sim.components;

public class Spliter extends LogicalComponent {
	
	private int begin, end;
	
	public Spliter(int begin, int end) {
		super(1, 1, false);
		out[0].setIsInt();
		out[0].setNumOfLines(end - begin);
		this.begin = begin;
		this.end = end;
	}

	public void func() {
		if (begin >= in[0].getNumOfLines()) {
			begin %= in[0].getNumOfLines();
		}
		if (end >= in[0].getNumOfLines()) {
			end %= in[0].getNumOfLines();
		}
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
		Spliter split = new Spliter(0, 4);
		split.setInputPin(0, new Pin(224, 8));
		split.func();
		System.out.printf("%x\n", split.getOut(0).getIntVal());
	}

}
