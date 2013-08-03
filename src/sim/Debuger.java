package sim;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import sim.components.LogicalComponent;

public class Debuger {

	private PrintWriter pw;
	private HashMap<String, LogicalComponent> components;
	private HashMap<String, Object> pastValues;

	public Debuger(Configurator config, String filename){
		try {
			pw=new PrintWriter(new FileWriter(filename),true);
		} catch (IOException e) {
			System.out.println("Debug output file can't be open!");
		}
		
		components = config.getComponents();
		pastValues = new HashMap<String, Object>();
		
		for(Map.Entry<String, LogicalComponent> entry: components.entrySet()){
			
			String componentName = entry.getKey();
			LogicalComponent component = entry.getValue();
			
			if(component.getOut(0).isBool()) {
				pastValues.put(componentName, component.getOut(0).getBoolVal());
			} else {
				pastValues.put(componentName, component.getOut(0).getIntVal());
			}
		}
	}
	
	public void debug(){
		pw.println("CLK = "+LogicalComponent.globalClock);
		
		for(Map.Entry<String, LogicalComponent> entry: components.entrySet()){
			
			String componentName = entry.getKey();
			LogicalComponent component = entry.getValue();
			Object pastValue = pastValues.get(componentName);
			
			if(component.getOut(0).isHighZ()) {
				pw.println(componentName+" = highZ");
			} else {
				if(component.getOut(0).isBool()) {
					
					boolean value = (Boolean) pastValue;
					boolean currValue = component.getOut(0).getBoolVal();
					if(value != currValue){
						
						pastValues.put(componentName, currValue);
						pw.println(componentName+" = "+currValue);
					}
				} else {
					
					int value = (Integer) pastValue;
					int currValue = component.getOut(0).getIntVal();
					if(value != currValue){
						
						pastValues.put(componentName, currValue);
						pw.println(componentName+" = "+currValue);
					}
				}
			}
		}
		
		pw.println("--------------------------------");
		
	}

}
