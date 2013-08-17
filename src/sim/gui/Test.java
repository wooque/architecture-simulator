package sim.gui;

import sim.Configurator;

public class Test {

	public static void main(String[] args) {
		
		long begin = System.currentTimeMillis();
		
		new GuiConfigurator(new Configurator("conf/schemes.conf", null).getComponents(), "conf/gui.conf", null);
		
		long end = System.currentTimeMillis();
		
		System.out.println();
		System.out.println("time taken: " + (end - begin) + " ms");
	}

}
