package sim.main;

import java.io.*;
import java.util.ArrayList;

public class StepsLoader {
	
	private ArrayList<String> steps = new ArrayList<String>();
	private ArrayList<String> desc = new ArrayList<String>();
	private String currStep;
	private int currStepNumber;
	private String currDesc;
	
	public StepsLoader(String stepsConfFile, PrintStream log) {
		if(log == null) {
			log = System.out;
		}
		
		long begin = System.currentTimeMillis();
		
		log.println();
		log.println("StepLoader:");
		log.println();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(stepsConfFile));
			String line = reader.readLine();
			
			while(line != null) {
				
				if(line.charAt(0) == '!') {
					if(currStep != null) {
						steps.add(currStep);
						desc.add(currDesc);
						currStep = null;
					}
					currDesc = line;
					 
				} else if(line.charAt(0) == 'T'){
					
					if(currStep != null) {
						steps.add(currStep);
						desc.add(currDesc);
						currStep = null;
					}
					int lastStepNumber = currStepNumber;
					currStepNumber = Integer.parseInt(line.substring(1, 3), 16);
					for(int i = 0; i < currStepNumber - lastStepNumber - 1; i++) {
						steps.add("");
						desc.add(currDesc);
					}
					currStep = "<html>"+line;
				} else {
					
					currStep = currStep+"<br>    "+line;
				}
				
				line = reader.readLine();
			}
			
			if(currStep != null) {
				steps.add(currStep);
				desc.add(currDesc);
			}
			
			reader.close();
			log.println("time taken: "+(System.currentTimeMillis() - begin)+" ms");
		} catch (FileNotFoundException e) {
			log.println("Conf file not found!");
		} catch (IOException e) {
			log.println("Conf file corrupted!");
		}
	}
	
	public ArrayList<String> getSteps() {
		return steps;
	}
	
	public ArrayList<String> getDesc() {
		return desc;
	}
	
	public static void main(String[] args) {
		ArrayList<String> steps = new StepsLoader("conf/steps.conf", null).getSteps();
		ArrayList<String> desc = new StepsLoader("conf/steps.conf", null).getDesc();
		for(int i = 0; i < steps.size(); i++) {
			System.out.println(Integer.toHexString(i)+": "+steps.get(i));
		}
		for(int i = 0; i < desc.size(); i++) {
			System.out.println(Integer.toHexString(i)+": "+desc.get(i));
		}
	}
}
