package sim.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import sim.components.MEM;

@SuppressWarnings("serial")
public class MemoryFrame extends JFrame {

	private JTextField[] address;
	private JTextField[] data;
	private JTextField adr;
	private JTextField val;
	private MEM mem;
	private int firstAddress;

	public MemoryFrame(MEM mem) {
		this.mem = mem;
		
		setTitle("Memorija");
		Color bgcolor = Color.WHITE;
		setBackground(bgcolor);
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		
		JPanel dataPanel = new JPanel(new GridLayout(10, 1));
		dataPanel.setBackground(bgcolor);
		data = new JTextField[100];
		
		for(int j = 0; j < 100; j+=10) {
			JPanel temp = new JPanel(new GridLayout(1, 10));
			temp.setBackground(bgcolor);
			for (int i = j; i < j + 10; i++) {
	
				data[i] = new JTextField(5);
				data[i].setEnabled(false);
				data[i].setDisabledTextColor(Color.BLACK);
				data[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				data[i].setColumns(3);
				data[i].setText(Integer.toHexString(mem.read(i)).toUpperCase());
				temp.add(data[i]);
			}
			dataPanel.add(temp);
		}
		centerPanel.add(dataPanel, "Center");


		JPanel addressPanel = new JPanel(new GridLayout(10, 1));
		addressPanel.setBackground(bgcolor);
		address = new JTextField[10];
		
		for (int i = 0; i < 10; i++) {

			address[i] = new JTextField(10);
			address[i].setEnabled(false);
			address[i].setDisabledTextColor(Color.BLACK);
			address[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			address[i].setColumns(7);
			String s = Integer.toHexString(i*10).toUpperCase()+"-"+Integer.toHexString(i*10 + 9).toUpperCase()+":";
			address[i].setText(s);
			addressPanel.add(address[i]);
		}
		centerPanel.add(addressPanel, "West");

		JPanel BigSouth = new JPanel(new GridLayout(2, 1));
		BigSouth.setBackground(bgcolor);

		JPanel labeltext = new JPanel(new GridLayout(1, 4));
		labeltext.setBackground(bgcolor);

		JLabel labadr = new JLabel("Addresa:  ");
		labeltext.add(labadr);
		labadr.setHorizontalAlignment(JLabel.RIGHT);

		adr = new JTextField(5);
		adr.setColumns(3);
		adr.setText(Integer.toHexString(0));
		labeltext.add(adr);

		JLabel labval = new JLabel("Vrednost:  ");
		labeltext.add(labval);
		labval.setHorizontalAlignment(JLabel.RIGHT);

		val = new JTextField(5);
		val.setColumns(3);
		val.setText(Integer.toHexString(0));
		labeltext.add(val);

		BigSouth.add(labeltext);

		JPanel buttons = new JPanel(new GridLayout(1, 3));
		buttons.setBackground(bgcolor);

		JButton read = new JButton("Read");
		read.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				read();
			}
		});
		buttons.add(read);

		JButton write = new JButton("Write");
		write.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				write();
			}
		});
		buttons.add(write);

		BigSouth.add(buttons);

		add(centerPanel, "Center");
		add(BigSouth, "South");
		
		setSize(400, 300);
		setLocation(100, 100);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				setVisible(false);
			}

		});
	}
	
	private void read() {
		int adrValue = parseTextAddr(adr.getText());
		if (adrValue != -1) {
			firstAddress = adrValue;
			updateMemoryView();
			adr.setText(Integer.toHexString(0));
			val.setText(Integer.toHexString(0));
			JOptionPane.showMessageDialog(MemoryFrame.this, "Pozicioniranje uspešno", "Pregled memorije", JOptionPane.INFORMATION_MESSAGE);
		} else {
			adr.setText(Integer.toHexString(0));
			val.setText(Integer.toHexString(0));
			JOptionPane.showMessageDialog(MemoryFrame.this, "Uneta adresa ili podatak nisu validni", "Greška!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void write() {
		int adrValue = parseTextAddr(adr.getText());
		int valValue = parseTextVal(val.getText());
		if (adrValue != -1 && valValue != -1) {
			firstAddress = adrValue;
			mem.write(adrValue, valValue);
			updateMemoryView();
			adr.setText(Integer.toHexString(0));
			val.setText(Integer.toHexString(0));
			JOptionPane.showMessageDialog(MemoryFrame.this,"Upis uspešan", "Upis u memoriju", JOptionPane.INFORMATION_MESSAGE);
		} else {
			adr.setText(Integer.toHexString(0));
			val.setText(Integer.toHexString(0));
			JOptionPane.showMessageDialog(MemoryFrame.this, "Uneta adresa ili podatak nisu validni", "Greška!", JOptionPane.ERROR_MESSAGE);
		}
	}

	private int parseTextAddr(String text) {
		try {
			int val = Integer.parseInt(text, 16);
			if (val > Integer.parseInt("EFFF", 16)) {
				return -1;
			}
			return val;
		} catch (NumberFormatException nfe) {
			return -1;
		}
	}

	private int parseTextVal(String text) {
		try {
			int val = Integer.parseInt(text, 16);
			if (255 < val) {
				return -1;
			}
			return val;
		} catch (NumberFormatException nfe) {
			return -1;
		}
	}

	public void updateMemoryView() {
		adr.setText(Integer.toHexString(0));
		val.setText(Integer.toHexString(0));
		if ((firstAddress + 99) >= Integer.parseInt("EFFF", 16))
			firstAddress = Integer.parseInt("EFFF", 16) - 99;
		for (int i = 0; i < 100; i++) {
			String s = Integer.toHexString(mem.read(firstAddress + i)).toUpperCase();
			data[i].setText(s);
		}
		int temp = firstAddress;
		for (int i = 0; i < 10; i++) {
			String s = Integer.toHexString(temp).toUpperCase()+"-"+Integer.toHexString(temp + 9).toUpperCase()+":";
			address[i].setText(s);
			temp = temp + 10;
		}
	}
}
