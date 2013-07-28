package configurator;

import java.io.*;
import java.util.*;
import java.util.regex.*;

import components.*;

public class Configurator {

	private HashMap<String, ArrayList<ComponentInfo>> componentInfos = new HashMap<String, ArrayList<ComponentInfo>>();
	private HashMap<String, LogicalComponent> components = new HashMap<String, LogicalComponent>();
	private ComponentInfo currScheme;
	private ArrayList<ComponentInfo> currComponents;

	private static class ComponentPins {
		String type;
		String[] names;
	}

	private static class ComponentType {
		String name;
		String[] args;
	}

	private static class ComponentInfo {
		String name;
		ComponentType type;
		ArrayList<ComponentPins> pins = new ArrayList<ComponentPins>();
	}
	
	@SuppressWarnings("serial")
	public static class BadArgs extends Exception {
		public BadArgs(String scheme, String component, String type){
			super(scheme+"."+component+" : Bad arguments for "+type+" component");
		}
	}

	public Configurator() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("dvov.conf"));
			String line = reader.readLine();

			while (line != null) {
				if (!line.isEmpty()) {

					Matcher matcher = Pattern.compile("([a-zA-Z0-9]+(\\[[a-zA-Z0-9_\\.]+(,( )*[a-zA-Z0-9_\\.]+)*\\])*)|(//.*)").matcher(line);

					if (matcher.find() != false && !matcher.group().substring(0, 2).equals("//")) {

						ComponentInfo info = new ComponentInfo();
						info.name = matcher.group();

						if (matcher.find()) {

							String[] tokens = matcher.group().split(",( )*|\\[|\\]");
							ComponentType type = new ComponentType();
							type.name = tokens[0];
							type.args = new String[tokens.length - 1];
							for (int i = 1; i < tokens.length; i++) {
								type.args[i - 1] = tokens[i];
							}
							info.type = type;
						} else {
							System.out.println("Config file corupted!");
							reader.close();
							return;
						}

						if (info.type.name.equals("scheme")) {
							if (currComponents != null) {
								componentInfos.put(currScheme.name, currComponents);
							}
							currScheme = info;
							currComponents = new ArrayList<ComponentInfo>();
						} else {

							while (matcher.find()) {

								String[] tokens = matcher.group().split(",( )*|\\[|\\]");
								ComponentPins pins = new ComponentPins();
								pins.type = tokens[0];
								pins.names = new String[tokens.length - 1];
								for (int i = 1; i < tokens.length; i++) {
									pins.names[i - 1] = tokens[i];
								}
								info.pins.add(pins);
							}
						}
						if(!info.type.name.equals("scheme")) {
							currComponents.add(info);
						}

						// output for debuging purpose
//
//						System.out.println(info.name);
//						System.out.println("---TYPE--------------------");
//						System.out.print(info.type.name);
//						for (String arg : info.type.args) {
//							System.out.print(" " + arg);
//						}
//						System.out.println();
//						System.out.println("---PINS--------------------");
//						for (ComponentPins currPins : info.pins) {
//							System.out.println(currPins.type);
//							for (String name : currPins.names) {
//								System.out.println("    " + name);
//							}
//
//						}
//						System.out.println("-----------------------------");
					}
				}

				line = reader.readLine();
			}

			if (currComponents != null) {
				componentInfos.put(currScheme.name, currComponents);
			}

			reader.close();

			// Instantiating components

			for (Map.Entry<String, ArrayList<ComponentInfo>> entry : componentInfos.entrySet()) {
				
				String schemeName = entry.getKey();
				ArrayList<ComponentInfo> schemeComponents = entry.getValue();
				
				for (ComponentInfo comp : schemeComponents) {
					
					LogicalComponent logComp = null;
					String compName = comp.type.name;
					String[] compArgs = comp.type.args;
					
					if(compName.equals("inttoint")) {
						
						if(compArgs.length == 2) {
							logComp = new IntToInt(Integer.parseInt(compArgs[0]), Integer.parseInt(compArgs[1]));
						} else if(compArgs.length == 3) {
							logComp = new IntToInt(Integer.parseInt(compArgs[0]), Integer.parseInt(compArgs[1]), false, Boolean.parseBoolean(compArgs[2]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("reg")) {
						
						if(compArgs.length == 1) {
							logComp = new REG(1, comp.name);
							logComp.getOut(0).setIsInt();
							logComp.getOut(0).setNumOfLines(Integer.parseInt(compArgs[0]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("mp")) {
						
						if(compArgs.length == 1) {
							logComp = new MP(Integer.parseInt(compArgs[0]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("add")) {
						
						if(compArgs.length == 1) {
							logComp = new ADD();
							logComp.getOut(0).setIsInt();
							logComp.getOut(0).setNumOfLines(Integer.parseInt(compArgs[0]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("gpr")) {
						
						if(compArgs.length == 2) {
							logComp = new GPR(Integer.parseInt(compArgs[0]));
							logComp.getOut(0).setNumOfLines(Integer.parseInt(compArgs[1]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					}
					
					if(logComp != null) {
						components.put(schemeName+"."+comp.name, logComp);
					}
				}
			}

		} catch (FileNotFoundException ignored) {
			System.out.println("Config file not found!");
		} catch (IOException e) {
			System.out.println("Config file corrupted!");
		} catch (BadArgs b) {
			System.out.println(b.getMessage());
		}
	}

	public static void main(String[] args) {
		new Configurator();
	}
}
