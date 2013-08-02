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
	static private int notID = 0;
	private long begin, end;

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

	public Configurator(String filename) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filename));
			begin = System.currentTimeMillis();
			String line = reader.readLine();

			while (line != null) {
				if (!line.isEmpty()) {

					Matcher matcher = Pattern.compile("([a-zA-Z0-9_]+(\\[[/a-zA-Z0-9_\\.]+(,( )*[/a-zA-Z0-9_\\.]+)*\\])*)|(//.*)").matcher(line);

					if (matcher.find() != false && !(matcher.group().length() > 1 && matcher.group().substring(0, 2).equals("//"))) {

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
				System.out.println("----------------- Initializing "+schemeName+" -----------------");
				
				for (ComponentInfo comp : schemeComponents) {
					
					LogicalComponent logComp = null;
					String compName = comp.type.name;
					String[] compArgs = comp.type.args;
					
					if(compName.equals("int_to_int")) {
						
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
						
						if(compArgs.length == 2) {
							logComp = new MP(Integer.parseInt(compArgs[0]));
							logComp.getOut(0).setIsInt();
							logComp.getOut(0).setNumOfLines(Integer.parseInt(compArgs[1]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("mp_bool")) {
						
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
					} else if(compName.equals("pin")) {
						
						if(compArgs.length == 0) {
							logComp = new DummyPin();
						} else if(compArgs.length == 1) {
							logComp = new DummyPin(new Pin(Boolean.parseBoolean(compArgs[0])));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("or")) {
						
						if(compArgs.length == 1) {
							logComp = new OR(Integer.parseInt(compArgs[0]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("and")) {
						
						if(compArgs.length == 1) {
							logComp = new AND(Integer.parseInt(compArgs[0]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("not")) {
						
						if(compArgs.length == 0) {
							logComp = new NOT();
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("tsb")) {
						
						if(compArgs.length == 1) {
							logComp = new TSB();
							logComp.getOut(0).setNumOfLines(Integer.parseInt(compArgs[0]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("alu")) {
						
						if(compArgs.length == 0) {
							logComp = new ALU();
							components.put(schemeName+"."+comp.name+"_c8", new DummyPin(((ALU)logComp).getPinC8()));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("int_to_bool")) {
						
						if(compArgs.length == 1) {
							logComp = new IntToBools(1, Integer.parseInt(compArgs[0]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("cd")) {
						
						if(compArgs.length == 1) {
							logComp = new CD(Integer.parseInt(compArgs[0]));
							boolean outExist = false;
							for(ComponentPins pins: comp.pins) {
								if(pins.type.equals("out")){
									outExist = true;
									for(int i = 0; i < pins.names.length; i++){
										components.put(schemeName+"."+pins.names[i], new DummyPin(logComp.getOut(i)));
									}
								}
							}
							if(!outExist) {
								for(int i = 0; i < logComp.getOut().length; i++){
									components.put(schemeName+"."+comp.name+i, new DummyPin(logComp.getOut(i)));
								}
							}
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("rsff")) {
						
						if(compArgs.length == 0) {
							logComp = new RSFF(schemeName+"."+comp.name);
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("bool_to_int")) {
						
						if(compArgs.length == 1) {
							logComp = new BoolsToInt(Integer.parseInt(compArgs[0]), Integer.parseInt(compArgs[0]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("xor")) {
						
						if(compArgs.length == 1) {
							logComp = new XOR(Integer.parseInt(compArgs[0]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("dc")) {
						
						if(compArgs.length == 1 || compArgs.length == 2) {
							logComp = new DC(Integer.parseInt(compArgs[0]));
							if(compArgs.length == 1) {
								boolean outExist = false;
								for(ComponentPins pins: comp.pins) {
									if(pins.type.equals("out")){
										outExist = true;
										for(int i = 0; i < pins.names.length; i++){
											components.put(schemeName+"."+pins.names[i], new DummyPin(logComp.getOut(i)));
										}
									}
								}
								if(!outExist) {
									for(int i = 0; i < logComp.getOut().length; i++){
										components.put(schemeName+"."+comp.name+i, new DummyPin(logComp.getOut(i)));
									}
								}
							} else if (compArgs[1].equals("hex")){
								for(int i = 0; i < logComp.getOut().length; i++){
									components.put(schemeName+"."+comp.name+Integer.toHexString(i).toUpperCase(), new DummyPin(logComp.getOut(i)));
								}
							} else {
								throw new BadArgs(schemeName, comp.name, compName);
							}
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("cmp")) {
						
						if(compArgs.length == 1) {
							logComp = new CMP(Integer.parseInt(compArgs[0]));
							boolean eqlExist = false, grtExist = false, lesExist = false;
							for(ComponentPins pins: comp.pins) {
								if(pins.type.equals("grt")){
									grtExist = true;
									components.put(schemeName+"."+pins.names[0], new DummyPin(logComp.getOut(0)));
								}
								if(pins.type.equals("eql")){
									eqlExist = true;
									components.put(schemeName+"."+pins.names[0], new DummyPin(logComp.getOut(1)));
								}
								if(pins.type.equals("les")){
									lesExist = true;
									components.put(schemeName+"."+pins.names[0], new DummyPin(logComp.getOut(2)));
								}
							}
							if(!grtExist) {
								components.put(schemeName+"."+comp.name+"_grt", new DummyPin(logComp.getOut(0)));
							}
							if(!eqlExist) {
								components.put(schemeName+"."+comp.name+"_eql", new DummyPin(logComp.getOut(1)));
							}
							if(!lesExist) {
								components.put(schemeName+"."+comp.name+"_les", new DummyPin(logComp.getOut(2)));
							}
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("km")) {
						
						if(compArgs.length == 2) {
							logComp = new KM(compArgs[0]);
							logComp.getOut(0).setNumOfLines(Integer.parseInt(compArgs[1]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("agg")) {
						
						if(compArgs.length == 2) {
							logComp = new Aggregator(Integer.parseInt(compArgs[0]), Integer.parseInt(compArgs[1]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("split")) {
						
						if(compArgs.length == 2) {
							logComp = new Spliter(Integer.parseInt(compArgs[0]), Integer.parseInt(compArgs[1]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("bus")) {
						
						if(compArgs.length == 2) {
							logComp = new BUS(Integer.parseInt(compArgs[0]), Integer.parseInt(compArgs[1]), comp.name);
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else if(compName.equals("mem")) {
						
						if(compArgs.length == 2) {
							logComp = new MEM(Integer.parseInt(compArgs[0]));
							logComp.getOut(0).setIsInt();
							logComp.getOut(0).setNumOfLines(Integer.parseInt(compArgs[1]));
						} else {
							throw new BadArgs(schemeName, comp.name, compName);
						}
					} else {
						
						System.out.println(compName + " does not exist");
					}
					
					if (logComp != null) {
						components.put(schemeName+"."+comp.name, logComp);
					}
				}
			}
			
			// Connecting components
			
			for(Map.Entry<String, ArrayList<ComponentInfo>> entry: componentInfos.entrySet()) {
				
				String schemeName = entry.getKey();
				ArrayList<ComponentInfo> schemeComponents = entry.getValue();
				System.out.println("----------------- Connecting "+schemeName+" ---------------");
				
				for (ComponentInfo comp : schemeComponents) {
					
					ArrayList<ComponentPins> allPins = comp.pins;
					LogicalComponent logComp = components.get(schemeName+"."+comp.name);
					
					for(ComponentPins pins: allPins) {
							
						if (!pins.type.equals("out") && !pins.type.equals("eql") && !pins.type.equals("grt") && !pins.type.equals("les")) {
							for (int i = 0; i < pins.names.length; i++) {

								String pinName = pins.names[i];
								LogicalComponent parentComp = null;

								if (!pins.type.equals("init")) {

									boolean anonimousNOT = false;
									if (pinName.charAt(0) == '/') {
										pinName = pinName.substring(1);
										anonimousNOT = true;
									}

									if (pinName.indexOf(".") == -1) {
										pinName = schemeName + "." + pinName;
									}

									parentComp = components.get(pinName);

									if (anonimousNOT && parentComp != null) {
										LogicalComponent tempComp = new NOT();
										components.put(schemeName+".NOT"+notID, tempComp);
										notID++;
										tempComp.setInputPin(0, parentComp.getOut(0));
										parentComp = tempComp;
									}
								}

								if ((parentComp != null) || pins.type.equals("init")) {

									try {
										if (pins.type.equals("in")) {
											logComp.setInputPin(i, parentComp.getOut(0));
											if (logComp instanceof IntToBools) {

												for (int k = 0; k < logComp.getOut().length; k++) {
													components .put(pinName + k, new DummyPin(logComp.getOut(i)));
												}
											}

										} else if (pins.type.equals("ld")) {
											((REG) logComp).setPinLd(parentComp.getOut(0));
											
										} else if (pins.type.equals("cl")) {
											((REG) logComp).setPinCL(parentComp.getOut(0));

										} else if (pins.type.equals("inc")) {
											if(logComp instanceof REG) {
												((REG) logComp).setPinInc(parentComp.getOut(0));
											} else if(logComp instanceof ALU) {
												((ALU) logComp).setPinInc(parentComp.getOut(0));
											} else {
												System.out.println("Non existent atribute inc for component: "+schemeName+"."+comp.name);
											}

										} else if (pins.type.equals("dec")) {
											if(logComp instanceof REG) {
												((REG) logComp).setPinDec(parentComp.getOut(0));
											} else if(logComp instanceof ALU) {
												((ALU) logComp).setPinDec(parentComp.getOut(0));
											} else {
												System.out.println("Non existent atribute inc for component: "+schemeName+"."+comp.name);
											}

										} else if (pins.type.equals("ctrl")) {
											if(logComp instanceof MP) {
												((MP) logComp).setCtrl(i, parentComp.getOut(0));
											} else if(logComp instanceof TSB) {
												((TSB) logComp).setCtrl(parentComp.getOut(0));
											} else {
												System.out.println("Non existent atribute ctrl for component: "+schemeName+"."+comp.name);
											}

										} else if (pins.type.equals("init")) {
											if (logComp instanceof REG) {
												((REG) logComp).initVal(Integer.parseInt(pinName));
											} else if (logComp instanceof RSFF) {
												((RSFF) logComp).setInit(Boolean.parseBoolean(pinName));
											} else {
												System.out.println("Non existent atribute init for component: "+schemeName+"."+comp.name);
											}

										} else if (pins.type.equals("addr")) {
											((GPR) logComp).setAdressPin(parentComp.getOut(0));

										} else if (pins.type.equals("wr")) {
											if(logComp instanceof GPR) {
												((GPR) logComp).setWrite(parentComp.getOut(0));
											} else if(logComp instanceof MEM) {
												((MEM) logComp).setWrite(parentComp.getOut(0));
											} else {
												System.out.println("Non existent atribute wr for component: "+schemeName+"."+comp.name);
											}

										} else if (pins.type.equals("rd")) {
											if(logComp instanceof GPR) {
												((GPR) logComp).setRead(parentComp.getOut(0));
											} else if(logComp instanceof MEM) {
												((MEM) logComp).setRead(parentComp.getOut(0));
											} else {
												System.out.println("Non existent atribute rd for component: "+schemeName+"."+comp.name);
											}

										} else if (pins.type.equals("not")) {
											((ALU) logComp).setPinNot(parentComp.getOut(0));

										} else if (pins.type.equals("xor")) {
											((ALU) logComp).setPinXor(parentComp.getOut(0));

										} else if (pins.type.equals("and")) {
											((ALU) logComp).setPinAnd(parentComp.getOut(0));

										} else if (pins.type.equals("or")) {
											((ALU) logComp).setPinOr(parentComp.getOut(0));

										} else if (pins.type.equals("dec")) {
											((ALU) logComp).setPinDec(parentComp.getOut(0));

										} else if (pins.type.equals("inc")) {
											((ALU) logComp).setPinInc(parentComp.getOut(0));

										} else if (pins.type.equals("sub")) {
											((ALU) logComp).setPinSub(parentComp.getOut(0));

										} else if (pins.type.equals("add")) {
											((ALU) logComp).setPinAdd(parentComp.getOut(0));

										} else if (pins.type.equals("shr")) {
											((REG) logComp).setShr(parentComp.getOut(0));

										} else if (pins.type.equals("shl")) {
											((REG) logComp).setShl(parentComp.getOut(0));

										} else if (pins.type.equals("ir")) {
											((REG) logComp).setIR(parentComp.getOut(0));

										} else if (pins.type.equals("il")) {
											((REG) logComp).setIL(parentComp.getOut(0));
										
										} else if (pins.type.equals("e")) {
											((DC) logComp).setE(parentComp.getOut(0));
										
										} else if (pins.type.equals("a")) {
											((CMP) logComp).setPinA(i, parentComp.getOut(0));
										
										} else if (pins.type.equals("b")) {
											((CMP) logComp).setPinB(i, parentComp.getOut(0));
											
										} else {
											System.out.println("Non existent atribute "+pins.type+" for component: "+schemeName+"."+comp.name);
										}
									} catch (ClassCastException cce) {
										System.out.println("Non existent atribute "+pins.type+" for component: "+schemeName+"."+comp.name);
									}
								} else {
									System.out.println(pins.names[i]+" does not exist");
								}
							}
						}
					}
				}
			}
			
			end = System.currentTimeMillis();
			System.out.println("-----------------------------");
			System.out.println("| Initializing time: "+(end - begin)/1000.0+" s |");
			System.out.println("-----------------------------");

		} catch (FileNotFoundException ignored) {
			System.out.println("Config file not found!");
		} catch (IOException e) {
			System.out.println("Config file corrupted!");
		} catch (BadArgs b) {
			System.out.println(b.getMessage());
		}
	}

	public static void main(String[] args) {
		new Configurator("schemes.conf");
	}
}
