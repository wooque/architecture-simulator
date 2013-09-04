package sim.gui;

import java.awt.Point;
import java.io.*;
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
			
			GuiLine lastLine = null;
			GuiLine line = null;
			String schemeName = null;
			GuiScheme scheme = null;
			
			while(confLine != null) {
				
				String[] tokens = confLine.split(",(\\s)*|\\)(\\s)*\\(|(\\s)*\\(|\\)");
				
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
						line = null;
						lastLine = null;
					} else {
						
						if(tokens[0].trim().equals("label")) {
							int x = Integer.parseInt(tokens[1]);
							int y = Integer.parseInt(tokens[2]);
							GuiLabel label = new GuiLabel(x, y);
							label.setPin(lastLine.getPin());
							label.setName(lastLine.getName());
							scheme.addLabel(label);
						} else {
						
							int i = 0;
							line = new GuiLine();
							if(tokens[0].isEmpty()) {
								// workaround for String.split() method not recognizing if delimiter is on begining
								i = 1;
							} else if((tokens[0].charAt(0) >= 'a' && tokens[0].charAt(0) <= 'z')
								|| (tokens[0].charAt(0) >= 'A' && tokens[0].charAt(0) <= 'Z')) {
								
								line.setName(tokens[0]);
								i = 1;
							}
							
							for(; i < tokens.length; i+=2) {
								int x = Integer.parseInt(tokens[i]);
								int y = Integer.parseInt(tokens[i + 1]);
								line.addPoint(new Point(x, y));
							}
							
							if(line.getName() == null) {
								line.setName(lastLine.getName());
								line.setPin(lastLine.getPin());
							} else {
								Pin linePin = null;
								if(line.getName().equals("true")) {
									linePin = Pin.TRUE;
								} else if(line.getName().equals("false")) {
									linePin = Pin.FALSE;
								} else {
									if(components != null) {
										LogicalComponent logComp = components.get(line.getName());
										if(logComp == null) {
											log.println("Non existent pin: "+line.getName());
										} else {
											linePin = logComp.getOut(0);
										}
									} else {
										linePin = new Pin();
									}
								}
								line.setPin(linePin);
							}
							scheme.addLine(line);
							lastLine = line;
							line = null;
						}
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
