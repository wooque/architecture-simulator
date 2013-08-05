package sim;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import sim.components.LogicalComponent;

public class Debugger {

	private PrintWriter pw;
	private HashMap<String, LogicalComponent> components;
	private HashMap<String, Object> pastValues;

	public Debugger(Configurator config, String filename){
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
			
			if(component.getOut(0).isHighZ()) {
				pastValues.put(componentName, "HighZ");
			} else if(component.getOut(0).isBool()) {
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
				
				if(!(pastValue instanceof String)){
					
					pastValues.put(componentName, "highZ");
					pw.println(componentName+" = highZ");
				}
			} else if(component.getOut(0).isBool()) {
					
				boolean currValue = component.getOut(0).getBoolVal();
				if (pastValue instanceof String) {
					
					pastValues.put(componentName, currValue);
					pw.println(componentName+" = "+currValue);
				} else {
					boolean value = (Boolean) pastValue;
					if(value != currValue){
						
						pastValues.put(componentName, currValue);
						pw.println(componentName+" = "+currValue);
					}
				}
			} else {
				
				int currValue = component.getOut(0).getIntVal();
				if (pastValue instanceof String) {
					
					pastValues.put(componentName, currValue);
					pw.println(componentName+" = "+currValue);
				} else {
					int value = (Integer) pastValue;
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
