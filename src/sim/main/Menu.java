package sim.main;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.*;
import javax.swing.event.*;

import sim.gui.GuiScheme;
import sim.gui.GuiSchemeRenderer;

@SuppressWarnings("serial")
public class Menu extends JList<String>{
	
	public Menu(final HashMap<String, GuiScheme> schemes, final GuiSchemeRenderer renderer, String menuConfFilename, PrintStream log) {
		if(log == null) {
			log = System.out;
		}
		
		log.println();
		log.println("MenuLoader: ");
		log.println();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(menuConfFilename));
			
			String line = reader.readLine();

			final LinkedHashMap<String, String> items = new LinkedHashMap<String, String>();
			int identUnit = 4;
			StringBuilder singleIdent = new StringBuilder("");
			
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			
			while(line != null) {
				
				String tokens[] = line.split("( )+");
				if(tokens[0].equals("ident")) {
					if(tokens[1].equals("=")) {
						identUnit = Integer.parseInt(tokens[2]);
						
						for(int i = 0; i < identUnit; i++) {
							singleIdent.append(" ");
						}
					}
				} else if(line.length() > 1 && !line.substring(0, 2).equals("//")){
					int numOfIdents = 0;
					while(line.charAt(numOfIdents) == ' ' || line.charAt(numOfIdents) == '\t') {
						numOfIdents++;
					}
					String menuTokens[] = line.split("\\[|\\]");
					StringBuilder builder = new StringBuilder("");
					for(int i = 0; i < numOfIdents; i++) {
						builder.append(singleIdent.toString());
					}
					builder.append(menuTokens[0].trim());
					listModel.addElement(builder.toString());
					items.put(builder.toString(), menuTokens[1].trim());
				}
				
				line = reader.readLine();
			}
			reader.close();

			setModel(listModel);
			
	        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        setLayoutOrientation(JList.VERTICAL);
	        
	        addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					renderer.switchScheme(schemes.get(items.get(Menu.this.getSelectedValue())));
					renderer.repaint();
				}
			});
			
		} catch (FileNotFoundException e) {
			log.println("Conf file not found!");
		} catch (IOException e) {
			log.println("Conf file corrupted!");
		}
	}
}
