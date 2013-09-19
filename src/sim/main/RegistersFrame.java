package sim.main;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import sim.components.*;


@SuppressWarnings("serial")
public class RegistersFrame extends JFrame{

	private HashMap<String, LogicalComponent> components;
	private JTextField[] regsTextFields;
	private static 	String[] registers = {"bus.mar", "bus.mdr", "fetch1.pc", "fetch1.ir31_24", "fetch1.ir23_16", "fetch1.ir15_8", "fetch1.ir7_0",
											"addr.gprar", "addr.sp", "exec1.ab", "exec1.bb", "exec1.aw", "exec1.bw", "intr1.imr", "intr3.br", "intr3.ivtp",
											"exec2.pswn", "exec2.pswz", "exec2.pswc", "exec2.pswv", "exec2.pswi", "exec2.pswl0", "exec2.pswl1"};

	public RegistersFrame(HashMap<String, LogicalComponent> components) {

		this.components = components;
		regsTextFields = new JTextField[56];
		
		setTitle("Registri");
		Color bgColor = Color.WHITE;
		setBackground(bgColor);
		
		Registers gpr = (Registers) components.get("addr.gpr");

		JPanel columns = new JPanel(new GridLayout(1, 6));
		columns.setBackground(bgColor);

		for(int j = 0; j < 2; j++) {
			JPanel gprPanel = new JPanel(new GridLayout(16, 2));
			gprPanel.setBackground(bgColor);
			for (int i = 16*j; i < 16*j + 16; i++) {
				JLabel name = new JLabel("R" + i + ": ");
				name.setVerticalAlignment(0);
				name.setHorizontalAlignment(4);
				gprPanel.add(name);
				JPanel val = new JPanel();
				val.setBackground(bgColor);
				regsTextFields[i] = new JTextField(4);
				regsTextFields[i].setText(Integer.toHexString(gpr.getRegValue(i)));
				val.add(regsTextFields[i]);
				gprPanel.add(val);
			}
			columns.add(gprPanel);
		}

		JPanel regsPanel = new JPanel(new GridLayout(16, 2));
		regsPanel.setBackground(bgColor);

		for(int i = 0; i < 16; i++) {
			String reg = registers[i];
			JLabel name = new JLabel(reg.substring(reg.indexOf('.') + 1).toUpperCase()+": ");
			name.setVerticalAlignment(0);
			name.setHorizontalAlignment(4);
			regsPanel.add(name);
			regsTextFields[32 + i] = new JTextField(4);
			regsTextFields[32 + i].setText(Integer.toHexString(components.get(reg).getOut(0).getIntVal()));
			JPanel val = new JPanel();
			val.setBackground(bgColor);
			val.add(regsTextFields[32 + i]);
			regsPanel.add(val);
		}

		columns.add(regsPanel);

		JPanel pswPanel = new JPanel(new GridLayout(16, 2));
		pswPanel.setBackground(bgColor);

		for(int i = 0; i < 7; i++) {
			String reg = registers[16 + i];
			JLabel name = new JLabel(reg.substring(reg.indexOf('.') + 1).toUpperCase()+": ");
			name.setVerticalAlignment(0);
			name.setHorizontalAlignment(4);
			pswPanel.add(name);
			regsTextFields[48 + i] = new JTextField(1);
			Pin out = components.get(reg).getOut(0);
			regsTextFields[48 + i].setText(Integer.toHexString(out.isBool()? (out.getBoolVal()? 1: 0): out.getIntVal()));
			JPanel temp = new JPanel();
			temp.setBackground(bgColor);
			temp.add(regsTextFields[48 + i]);
			pswPanel.add(temp);
		}
		
		for (int i = 0; i < 16; i++) {
			JLabel tmp1 = new JLabel("  ");
			pswPanel.add(tmp1);
		}
		columns.add(pswPanel);

		add(columns, "Center");

		JPanel buttons = new JPanel();
		buttons.setBackground(bgColor);

		JButton changeValues = new JButton("Izmeni");
		changeValues.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				change();
			}
		});

		buttons.add(changeValues);
		add(buttons, "South");
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				setVisible(false);
			}

		});
		setSize(500, 500);
		setLocation(100, 100);
	}

	private void change() {
		ArrayList<String> errorFields = new ArrayList<String>();
		for(int i = 0; i < 55; i++) {
			int val;
			LogicalComponent comp;
			
			try {
				val = Integer.parseInt(regsTextFields[i].getText(), 16);
			} catch (NumberFormatException nfe) {
				val = -1;
			}
			
			if (i >= 0 && i < 32) {
				Registers gpr = ((Registers) components.get("addr.gpr"));
				if(val > 65535 || val == -1){
					errorFields.add("R"+i);
					regsTextFields[i].setText(Integer.toHexString(gpr.getRegValue(i)));
				} else {
					gpr.setRegValue(i, val);
				}
			} else {
				String reg = registers[i - 32];
				comp = components.get(reg);
				
				if(comp.getOut(0).isBool()) {
					if(val == -1 || (val != 0 && val != 1)) {
						errorFields.add(reg.substring(reg.indexOf('.') + 1));
						regsTextFields[i].setText(comp.getOut(0).getBoolVal()? "1": "0");
					} else {
						comp.getOut(0).setBoolVal(val == 1);
					}
				} else {
					if(val >= Math.pow(2.0, comp.getOut(0).getNumOfLines()) || val == -1){
						errorFields.add(reg.substring(reg.indexOf('.') + 1));
						regsTextFields[i].setText(Integer.toHexString(comp.getOut(0).getIntVal()));
					} else {
						((REG) comp).initVal(val);
						comp.getOut(0).setIntVal(val);
					}
				}
			}
		}
		if (errorFields.isEmpty()) {
			JOptionPane.showMessageDialog(RegistersFrame.this, "Promena uspešna", "Promena registara", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(RegistersFrame.this, "Neispravna polja: "+errorFields.toString(), "Greška", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void updateRegistersView() {
		for (int i = 0; i < 32; i++) {
			regsTextFields[i].setText(Integer.toHexString(((Registers) components.get("addr.gpr")).getRegValue(i)));
		}
		for (int i = 32; i < 55; i++) {
			regsTextFields[i].setText(Integer.toHexString(components.get(registers[i - 32]).getOut(0).getIntVal()));
		}
	}
}
