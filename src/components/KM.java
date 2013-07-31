package components;

import java.io.*;
import java.util.ArrayList;

public class KM extends LogicalComponent {
	
	private ArrayList<Integer> outputs = new ArrayList<Integer>();
	
	public KM(String filename) {
		super(1, 1, false);
		out[0].setIsInt();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {
				int comment = line.indexOf('/');
				if(comment != -1) {
					line = line.substring(0, comment);
				}
				line = line.trim();
				int op = Integer.parseInt(line, 16);
				outputs.add(op);
				line = reader.readLine();
			}
			in = new Pin[outputs.size()];
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("KM config file not found");
		} catch (IOException e) {
			System.out.println("KM config file corupted");
		}
	}

	public void func() {
		int i = 0;
		for (i = 0; i < in.length; i++) {
			if (in[i] != null && in[i].getBoolVal()) {
				out[0].setIntVal(outputs.get(i));
				break;
			}
		}
	}
}
