package configurator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Configurator {
	
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

    public Configurator() {
    	BufferedReader reader;
		try {
			 reader = new BufferedReader(new FileReader("dvov.conf"));
			 String line = reader.readLine();
			 
			 while(line != null){
				 if(!line.isEmpty()) {
					 
					 Matcher matcher = Pattern.compile("([a-zA-Z0-9]+(\\[[a-zA-Z0-9_\\.]+(,( )*[a-zA-Z0-9_\\.]+)*\\])*)|(//.*)").matcher(line);
					 
					 if(matcher.find() != false && !matcher.group().substring(0,2).equals("//")) {
						 
						 ComponentInfo info = new ComponentInfo();
						 info.name = matcher.group();
						 
						 if(matcher.find()) {
							 String[] tokens = matcher.group().split(",( )*|\\[|\\]");
							 ComponentType type = new ComponentType();
							 type.name = tokens[0];
							 type.args = new String[tokens.length - 1];
							 for(int i = 1; i < tokens.length; i++) {
								 type.args[i - 1] = tokens[i];
							 }
							 info.type = type;
						 } else {
							 System.out.println("Config file corupted!");
							 reader.close();
							 return;
						 }
						 
						 while(matcher.find()) {
							 String[] tokens = matcher.group().split(",( )*|\\[|\\]");
							 ComponentPins pins = new ComponentPins();
							 pins.type = tokens[0];
							 pins.names = new String[tokens.length - 1];
							 for(int i = 1; i < tokens.length; i++){
								 pins.names[i - 1] = tokens[i];
							 }
							 info.pins.add(pins);
						 }
						 
						 System.out.println(info.name);
						 System.out.println("---TYPE--------------------");
						 System.out.print(info.type.name);
						 for(String arg: info.type.args) {
							 System.out.print(" " + arg);
						 }
						 System.out.println();
						 System.out.println("---PINS--------------------");
						 for(ComponentPins currPins: info.pins) {
							 System.out.println(currPins.type);
							 for(String name: currPins.names){
								 System.out.println("    " + name);
							 }
							 
						 }
						 System.out.println("-----------------------------");
					 }
				 }
				 
				 line = reader.readLine();
			 }
			 
			 reader.close();
			 
        } catch (FileNotFoundException ignored) {
			System.out.println("Config file not found!");
		} catch (IOException e) {
			System.out.println("Config file corrupted!");
		}
    }
    
    public static void main(String[] args) {
		new Configurator();
	}
}
