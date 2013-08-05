package sim.components;

import java.util.ArrayList;

public class GPR extends LogicalComponent {
	private ArrayList<REG> regs;
	private ArrayList<AND> ands;
	private DC dekoder;// mora jer se registri ubacuju u sekvencijalnu listu i
						// da bi se znalo
	private IntToBools addressBits;// u koji se upisuje
	private MP mx;

	private Pin read;
	// private Pin write;
	private int size;

	public GPR(int size) {
		super(2, 1, false);
		this.size = size;
		int address = (int)(Math.log(size)/Math.log(2));
		addressBits = new IntToBools(address, address);
		out[0].setIsInt();
		out[0].setNumOfLines(16);
		dekoder = new DC(address);
		dekoder.setE(new Pin(true));
		for(int i = 0; i < address; i++) {
			dekoder.setInputPin(i, addressBits.getOut(i));;
		}
//		dekoder.setInputPin(0, adressBits.getOut(0));
//		dekoder.setInputPin(1, adressBits.getOut(1));
//		dekoder.setInputPin(2, adressBits.getOut(2));
//		dekoder.setInputPin(3, adressBits.getOut(3));
//		dekoder.setInputPin(4, adressBits.getOut(4));
//		dekoder.setInputPin(5, adressBits.getOut(5));
		mx = new MP(size);
		mx.setOutputPin(0, this.out[0]);
		for(int i = 0; i < address; i++) {
			mx.setCtrl(i, addressBits.getOut(i));;
		}
//		mx.setCtrl(0, adressBits.getOut(0));
//		mx.setCtrl(1, adressBits.getOut(1));
//		mx.setCtrl(2, adressBits.getOut(2));
//		mx.setCtrl(3, adressBits.getOut(3));
//		mx.setCtrl(4, adressBits.getOut(4));
//		mx.setCtrl(5, adressBits.getOut(5));

		regs = new ArrayList<REG>(size);
		ands = new ArrayList<AND>(size);
		for (int i = 0; i < size; i++) {

			AND ldreg = new AND();
			ldreg.setInputPin(0, dekoder.getOut(i));
			ands.add(ldreg);

			String name = "Reg" + i;
			REG r = new REG(1, name);
			r.getOut(0).setIsInt();
			r.getOut(0).setNumOfLines(16);
			r.setPinLd(ldreg.getOut(0));
			regs.add(r);

			mx.setInputPin(i, r.getOut(0));

		}

		addSequentialComponent(this);
	}

	public void func() {

		if (read.getBoolVal()) {// nije potrebno ni ovo jer MX je child Pina
								// read

			mx.func();
		}
		// ne ispituje se wrGPR jer to sema sama uradi jer su registri u listi
		// sekvencijalnih

	}

	// Dodato: Djole
	public void clear() {
		for (REG r : regs) {
			r.clear();
		}
	}

	public int getSize() {
		return size;
	}

	public void setRead(Pin read) {
		this.read = read;
		read.addChild(this);
		mx.setE(read);
	}

	public void setWrite(Pin write) {
		// this.write = write;
		// write.addChild(this); nije potrebno jer na write ne reaguje GPR nego
		// registri
		for (int i = 0; i < size; i++) {
			ands.get(i).setInputPin(1, write);// jer na inputpin nula je izlaz
												// DC odgovarajuci
			write.addChild(ands.get(i));
		}

	}

	public void setAdressPin(Pin adress) {
		in[0] = adress;
		addressBits.setInputPin(0, adress);
		adress.addChild(this);// da bi se uradila FUNC na promenu adrese,mada
								// mozda i ne mora
		adress.addChild(addressBits);// Bools To INT

	}

	public void setInputDataPin(Pin datain) {
		in[1] = datain;
		for (int i = 0; i < size; i++) {
			regs.get(i).setInputPin(0, datain);// za registar DATAIN
			datain.addChild(regs.get(i));
		}

	}

	public void write(int adress, int data) {
		regs.get(adress).setVal(data);// mozda ce biti problem jer ovo probudi
										// output pinove

	}

	public int read(int adress) {
		return regs.get(adress).getVal();
	}

	public REG getREG(int i) {
		return regs.get(i);
	}

}
