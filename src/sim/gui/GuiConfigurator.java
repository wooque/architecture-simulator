package sim.gui;

import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import sim.components.LogicalComponent;
import sim.components.Pin;

public class GuiConfigurator {

	private LinkedHashMap<String, GuiScheme> guiSchemes = new LinkedHashMap<String, GuiScheme>();
	
	public GuiConfigurator(HashMap<String, LogicalComponent> components, String guiConfFilename, PrintStream log) {
		
		try {
			if(log == null) {
				log = System.out;
			}
			log.println();
			log.println("GuiConfigurator:");
			log.println();
			
			long begin = System.currentTimeMillis();
			
			BufferedReader confFileReader = new BufferedReader(new FileReader(guiConfFilename));
			
			String confLine = confFileReader.readLine();
			
			String lineName = null;
			ArrayList<Point> lineSections = null;
			String schemeName = null;
			GuiScheme scheme = null;
			
			while(confLine != null) {
				
				String[] tokens = confLine.split(",(\\s)*|(\\)){0,1}(\\s)*\\(|\\)");
				
				if(!(tokens.length == 1 && tokens[0].isEmpty()) 
					&& !((tokens[0].length() > 1) && tokens[0].substring(0,2).equals("//"))) {
					if(tokens.length == 1  
						&& ((tokens[0].charAt(0) >= 'a' && tokens[0].charAt(0) <= 'z')
							|| (tokens[0].charAt(0) >= 'A' && tokens[0].charAt(0) <= 'Z'))) {
						
						if(scheme != null) {
							guiSchemes.put(schemeName, scheme);
						}
						schemeName = tokens[0];
						scheme = new GuiScheme("images/"+tokens[0]);
						lineName = null;
					} else {
						
						int i = 0;
						if(tokens[0].isEmpty()) {
							// workaround for String.split() method not recognizing if delimiter is on begining
							i = 1;
						} else if((tokens[0].charAt(0) >= 'a' && tokens[0].charAt(0) <= 'z')
							|| (tokens[0].charAt(0) >= 'A' && tokens[0].charAt(0) <= 'Z')) {
							
							lineName = tokens[0];
							i = 1;
						}
						
						lineSections = new ArrayList<Point>();
						for(; i < tokens.length; i+=2) {
							int x = Integer.parseInt(tokens[i]);
							int y = Integer.parseInt(tokens[i + 1]);
							lineSections.add(new Point(x, y));
						}
						Pin linePin = null;
						if(lineName.equals("true")) {
							linePin = Pin.TRUE;
						} else if(lineName.equals("false")) {
							linePin = Pin.FALSE;
						} else {
							if(components != null) {
								LogicalComponent logComp = components.get(lineName);
								if(logComp == null) {
									log.println("Non existent pin: "+lineName);
								} else {
									linePin = logComp.getOut(0);
								}
							} else {
								linePin = new Pin();
							}
						}
						// TODO replace linesection with GuiLine
						scheme.addLine(new GuiLine(lineSections, linePin));
						lineSections = null;
					}
				}
				confLine = confFileReader.readLine();
			}

			if(scheme != null) {
				guiSchemes.put(schemeName, scheme);
			}
			
			
			confFileReader.close();
			
			long end = System.currentTimeMillis();
			
			for(Map.Entry<String, GuiScheme> schemeEntry: guiSchemes.entrySet()) {
				String name = schemeEntry.getKey();
				GuiScheme guiScheme = schemeEntry.getValue();
				log.println(name+": "+(guiScheme != null));
			}
			log.println();
			log.println("time taken: " + (end - begin) + " ms");
			
		} catch (FileNotFoundException e) {
			log.println("Conf file not found!");
		} catch (IOException e) {
			log.println("Conf file corrupted!");
		}
	}

	public HashMap<String, GuiScheme> getGuiSchemes() {
		return guiSchemes;
	}
}
