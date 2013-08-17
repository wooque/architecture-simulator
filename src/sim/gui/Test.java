package sim.gui;

import java.util.HashMap;
import java.util.Map;

import sim.Configurator;

public class Test {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		
		Configurator conf = new Configurator("conf/schemes.conf");
		GuiConfigurator guiConf = new GuiConfigurator(conf.getComponents(), "conf/gui.conf");
		HashMap<String, GuiScheme> schemes = guiConf.getGuiSchemes();
		
		long end = System.currentTimeMillis();
		
		for(Map.Entry<String, GuiScheme> schemeEntry: schemes.entrySet()) {
			String schemeName = schemeEntry.getKey();
			GuiScheme scheme = schemeEntry.getValue();
			System.out.println(schemeName+": "+(scheme != null));
		}
		System.out.println();
		System.out.println("time taken: " + (end - begin) + " ms");
	}

}
