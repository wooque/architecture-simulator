package sim.main;

import java.io.*;
import java.util.ArrayList;

public class StepsLoader {
	
	ArrayList<String> steps;
	String currStep;
	
	public StepsLoader(String stepsConfFile, PrintStream log) {
		if(log == null) {
			log = System.out;
		}
		
		log.println();
		log.println("StepLoader:");
		log.println();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(stepsConfFile));
			String line = reader.readLine();
			
			while(line != null) {
				
				if(line.charAt(0) == '!') {
					// TODO put somewhere description
					 
				} else if(line.charAt(0) == 'T'){
					
				}
				
				line = reader.readLine();
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			log.println("Conf file not found!");
		} catch (IOException e) {
			log.println("Conf file corrupted!");
		}
	}

}
