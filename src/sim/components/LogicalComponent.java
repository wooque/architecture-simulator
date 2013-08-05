package sim.components;

import java.util.ArrayList;


public abstract class LogicalComponent {

	// debugging purpose
	public String name;
	protected Pin[] in;
	protected Pin[] out;
	protected boolean isSeq;
	protected int clock; // klok svake komponente
	static public int globalClock = 0; // globalni klok
	public static ArrayList<LogicalComponent> allSequentialComponents = new ArrayList<LogicalComponent>();

	// Dodato: Djole
	protected Pin[] outTemp;
	private static boolean firstTime = true;
	//

	// Darko,za razdvajanje clk:
	private static Pin CPUCLK = new Pin();
	private static Pin BUSCLK = new Pin();
	private static Pin MEMCLK = new Pin();
	
	public static boolean initMemory=true;

	public LogicalComponent(int in, int out, boolean isSeq) {
		this.in = new Pin[in];
		this.out = new Pin[out];

		// Dodato: Djole
		outTemp = new Pin[out];
		//

		for (int i = 0; i < out; i++) {
			this.out[i] = new Pin(); // vise nema da prima this u argumentu
										// konstruktora
		}
		this.isSeq = isSeq;
		clock = 1;
	}

	public void setClock(int clock) {
		this.clock = clock;
	}

	public void clockedFunc() {// omotac za func da se ne bi uvek azurilale
								// komponente nego samo na ofgovarajuci klok

		if ((globalClock % clock) == 0) {
			func();
		}

	}

	public static void addSequentialComponent(LogicalComponent logcomp) {// samo
																			// za
																			// sekvencijalne
																			// komponente
		allSequentialComponents.add(logcomp);
	}

	// poziva se iz glavnog programa, prolazi kroz sve sekvencijalne komponente
	// i rade se njihove funkcije
	public static void CLK() {

		for (LogicalComponent seq : allSequentialComponents) {
			seq.clockedFunc();
		}

		// Dodato: Djole
		if (globalClock == 0 && firstTime)
			for (LogicalComponent seq : allSequentialComponents)
				for (int i = 0; i < seq.out.length; i++) {
					if (seq.out[i].isBool()) {
						seq.outTemp[i] = new Pin(seq.out[i].getBoolVal());
					} else
						seq.outTemp[i] = new Pin(seq.out[i].getIntVal(),
								seq.out[i].getNumOfLines());
				}
		//

		for (LogicalComponent seq : allSequentialComponents) {
			seq.flush();
		}

		globalClock++;

		// ovo sve treba nakon sto se uveca CLK:
		CPUCLK.setBoolVal(true);
		if ((globalClock != 0) && (globalClock % 2 == 0))
			BUSCLK.setBoolVal(true);
		else
			BUSCLK.setBoolVal(false);
		if ((globalClock != 0) && (globalClock % 3 == 0))
			MEMCLK.setBoolVal(true);
		else
			MEMCLK.setBoolVal(false);

	}

	// Dodato: Djole: Sluzi da ocisti vrednosti sekvencijalnih elemenata, recimo
	// da vrednosti registra postavi na 0
	// treba da se preklopi, koristi se u simulation reset
	public void clear() {
	}

	public void flush() {
		for (int i = 0; i < out.length; i++) {
			out[i].flush();
		}
	}

	public void setInputPins(Pin[] in) {
		this.in = in;
		for (int i = 0; i < in.length; i++) {
			in[i].addChild(this);
		}
	}

	public void setInputPin(int index, Pin pin) {
		this.in[index] = pin;
		pin.addChild(this);
	}

	public Pin[] getOut() {
		return this.out;
	}

	public Pin[] getIn() {
		return this.in;
	}

	public Pin getOut(int index) {
		return this.out[index];
	}

	public Pin getIn(int index) {
		return this.in[index];
	}

	public boolean isSeq() {
		return isSeq;
	}

	public abstract void func();

	public void setOutputPin(int index, Pin pin) {
		out[index] = pin;
	}// dodato jer za MPout u GPR potrebno da se dodeli rucno output GPR-a

	// Dodato: Djole
	public static void resetSimulation() {

		// Obelezi da nije prvo pokretanje simulacije
		LogicalComponent.firstTime = false;

		// Vrati stare vrednosti pinova i resetuj registre
		for (LogicalComponent seq : allSequentialComponents) {

			for (int i = 0; i < seq.out.length; i++) {
				if (seq.out[i].isBool())
					seq.out[i].setBoolVal(seq.outTemp[i].getBoolVal(), false);
				else
					seq.out[i].setIntVal(seq.outTemp[i].getIntVal(), false);
			}
			seq.clear();
		}

		// klok na 0
		LogicalComponent.globalClock = 0;

		// odradi flush
		for (LogicalComponent seq : LogicalComponent.allSequentialComponents) {
			seq.flush();
		}

		//globalClock++; //nema potrebe radi i bez toga

	}

	//

	// Darko,za CLK:

	public static Pin getCPUCLK() {
		return CPUCLK;
	}

	public static Pin getBUSCLK() {
		return BUSCLK;
	}

	public static Pin getMEMCLK() {
		return MEMCLK;
	}
	public void init(){
		
	}
	public static void initialise(){
		for (LogicalComponent seq : allSequentialComponents) {
			seq.init();
		}
		for (LogicalComponent seq : allSequentialComponents) {
			seq.flush();
		}
		globalClock=0;
	}
}
