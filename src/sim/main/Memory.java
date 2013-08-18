package sim.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import sim.components.*;

@SuppressWarnings("serial")
public class Memory extends JPanel implements ActionListener {

	private JButton read;
	private JButton write;
	private JButton cancel;
	private JDialog greska;
	private JDialog potvrdaread;
	private JDialog potvrdawrite;
	private boolean error;
	private JTextField[] address;
	private JTextField[] data;
	private JTextField adr;
	private JTextField val;
	private MEM mem;
	private JDialog sadrzalacMemorije;
	private static int firstAddress = 0;

	public JDialog getSadrzalacMemorije() {
		return sadrzalacMemorije;
	}

	public void setSadrzalacMemorije(JDialog sadrzalacMemorije) {
		this.sadrzalacMemorije = sadrzalacMemorije;
	}

	public Memory(MEM mem) {

		this.mem = mem;
		setLayout(new BorderLayout());
		setBackground(Color.white);
		Color bgcolor = Color.white;
		JPanel dataPanel = new JPanel(new GridLayout(10, 1));
		dataPanel.setBackground(bgcolor);

		data = new JTextField[100];

		for(int j = 0; j < 100; j+=10) {
			JPanel temp = new JPanel(new GridLayout(1, 10));
			temp.setBackground(bgcolor);
			for (int i = j; i < j + 10; i++) {
	
				data[i] = new JTextField(5);// 5 je broj kolona
				data[i].setEnabled(false);
				data[i].setDisabledTextColor(Color.BLACK);
				data[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				data[i].setColumns(3);
				data[i].setText(Integer.toHexString(mem.read(i)));
				temp.add(data[i]);
			}
			dataPanel.add(temp);
		}

		JPanel BigCenter = new JPanel(new BorderLayout());
		BigCenter.add(dataPanel, "Center");

		JPanel addressPanel = new JPanel(new GridLayout(10, 1));
		addressPanel.setBackground(bgcolor);

		address = new JTextField[10];

		int temp = firstAddress;
		for (int i = 0; i < 10; i++) {

			address[i] = new JTextField(10);// 10 je broj kolona
			address[i].setEnabled(false);
			address[i].setDisabledTextColor(Color.BLACK);
			address[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			address[i].setColumns(7);
			String s = Integer.toHexString(temp) + "-"
					+ Integer.toHexString(temp + 9) + ":";
			address[i].setText(s);
			temp = temp + 10;
			addressPanel.add(address[i]);
		}

		BigCenter.add(addressPanel, "West");

		JPanel BigSouth = new JPanel(new GridLayout(2, 1));
		BigSouth.setBackground(bgcolor);

		JPanel labeltext = new JPanel(new GridLayout(1, 4));
		labeltext.setBackground(bgcolor);

		JLabel labadr = new JLabel("Address:  ");
		labeltext.add(labadr);
		labadr.setHorizontalAlignment(JLabel.RIGHT);

		adr = new JTextField(5);
		adr.setColumns(3);
		adr.setText(Integer.toHexString(0));
		labeltext.add(adr);

		JLabel labval = new JLabel("Value:  ");
		labeltext.add(labval);
		labval.setHorizontalAlignment(JLabel.RIGHT);

		val = new JTextField(5);
		val.setColumns(3);
		val.setText(Integer.toHexString(0));
		labeltext.add(val);

		BigSouth.add(labeltext);

		JPanel buttons = new JPanel(new GridLayout(1, 3));
		buttons.setBackground(bgcolor);

		read = new JButton("Read");
		read.addActionListener(this);
		buttons.add(read);

		write = new JButton("Write");
		write.addActionListener(this);
		buttons.add(write);

		cancel = new JButton("Cancel ");
		cancel.addActionListener(this);
		buttons.add(cancel);

		BigSouth.add(buttons);

		add(BigCenter, "Center");
		add(BigSouth, "South");
	}

	public void actionPerformed(ActionEvent arg0) {

		int adrtext, valtext;

		if (arg0.getActionCommand().equals("Read")) {

			adrtext = proveriadresu(adr.getText());
			if (!error) {
				firstAddress = adrtext;
				repaint();
				adr.setText(Integer.toHexString(0));
				val.setText(Integer.toHexString(0));
				potvrdaread = new JDialog();
				potvrdaread.setSize(550, 100);
				potvrdaread.setLocation(200, 200);
				potvrdaread.setModal(true);
				potvrdaread.setTitle("Potvrda citanja");
				JPanel osnovni = new JPanel(new GridLayout(2, 1));
				JLabel lab = new JLabel(
						"Uspesno ste pozicionirani na pregled memorije od zadate adrese!");
				lab.setHorizontalAlignment(0);
				osnovni.add(lab);
				JButton ok = new JButton("U redu");
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						potvrdaread.setVisible(false);

					}
				});
				JPanel tmp = new JPanel();
				tmp.add(ok);
				tmp.setBackground(Color.white);
				osnovni.add(tmp);
				osnovni.setBackground(Color.white);
				potvrdaread.add(osnovni);
				potvrdaread.setVisible(true);

			} else {
				error = false;
				adr.setText(Integer.toHexString(0));
				val.setText(Integer.toHexString(0));
				greska = new JDialog();
				greska.setSize(550, 150);
				greska.setLocation(200, 200);
				greska.setModal(true);
				greska.setTitle("Greska!");
				JPanel osnovni = new JPanel(new GridLayout(2, 1));
				JLabel lab = new JLabel(
						"Zbog unete pogresne adrese nije uspelo pozicioniranje pregleda memorije na zadatu adresu!");
				lab.setHorizontalAlignment(0);
				osnovni.add(lab);
				JButton ok = new JButton("U redu");
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						greska.setVisible(false);

					}
				});
				JPanel tmp = new JPanel();
				tmp.add(ok);
				tmp.setBackground(Color.white);
				osnovni.add(tmp);
				osnovni.setBackground(Color.white);
				greska.add(osnovni);
				greska.setVisible(true);
			}
		} else if (arg0.getActionCommand().equals("Write")) {
			adrtext = proveriadresu(adr.getText());
			valtext = proverivred(val.getText());
			if (!error) {
				firstAddress = adrtext;
				mem.write(adrtext, valtext);
				repaint();
				adr.setText(Integer.toHexString(0));
				val.setText(Integer.toHexString(0));
				potvrdawrite = new JDialog();
				potvrdawrite.setSize(550, 100);
				potvrdawrite.setLocation(200, 200);
				potvrdawrite.setModal(true);
				potvrdawrite.setTitle("Potvrda upisa");
				JPanel osnovni = new JPanel(new GridLayout(2, 1));
				JLabel lab = new JLabel(
						"Uspesno ste upisali vrednost na zadatu adresu!");
				lab.setHorizontalAlignment(0);
				osnovni.add(lab);
				JButton ok = new JButton("U redu");
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						potvrdawrite.setVisible(false);

					}
				});
				JPanel tmp = new JPanel();
				tmp.add(ok);
				tmp.setBackground(Color.white);
				osnovni.add(tmp);
				osnovni.setBackground(Color.white);
				potvrdawrite.add(osnovni);
				potvrdawrite.setVisible(true);

			} else {

				error = false;
				adr.setText(Integer.toHexString(0));
				val.setText(Integer.toHexString(0));
				greska = new JDialog();
				greska.setSize(550, 150);
				greska.setLocation(200, 200);
				greska.setModal(true);
				greska.setTitle("Greska!");
				JPanel osnovni = new JPanel(new GridLayout(2, 1));
				JLabel lab = new JLabel(
						"Zbog unete pogresne adrese ili podatka nije uspeo upis u memoriju na zadatu adresu!");
				lab.setHorizontalAlignment(0);
				osnovni.add(lab);
				JButton ok = new JButton("U redu");
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						greska.setVisible(false);

					}
				});
				JPanel tmp = new JPanel();
				tmp.add(ok);
				tmp.setBackground(Color.white);
				osnovni.add(tmp);
				osnovni.setBackground(Color.white);
				greska.add(osnovni);
				greska.setVisible(true);
			}
		}

		else {// ako je cancel
			sadrzalacMemorije.setVisible(false);
		}
	}

	private int proveriadresu(String text) {
		int val = 0;
		try {

			val = Integer.parseInt(text, 16);
			if (val > Integer.parseInt("EFFF", 16))
				error = true;
			return val;
		} catch (Exception e) { // ZBOG NUMBER FORMAT EXCEPTION!
			error = true;
			return 0;
		}

	}

	private int proverivred(String text) {
		int val;
		try {
			val = Integer.parseInt(text, 16);
		} catch (Exception e) { // ZBOG NUMBER FORMAT EXCEPTION!
			error = true;
			return 0;
		}
		if ((int) Math.pow(2.0D, 8) <= val) {
			error = true;
		}
		return val;
	}

	public void paint(Graphics g) {
		super.paint(g);
		adr.setText(Integer.toHexString(0));
		val.setText(Integer.toHexString(0));
		if ((firstAddress + 99) >= Integer.parseInt("EFFF", 16))
			firstAddress = Integer.parseInt("EFFF", 16) - 99;
		for (int i = 0; i < 100; i++) {
			String s = Integer.toHexString(mem.read(firstAddress + i));
			data[i].setText(s);
		}
		int temp = firstAddress;
		for (int i = 0; i < 10; i++) {
			String s = Integer.toHexString(temp) + "-"
					+ Integer.toHexString(temp + 9) + ":";
			address[i].setText(s);
			temp = temp + 10;

		}

	}

	public static void main(String[] args) {
		Memory guimem = new Memory(new MEM(64 * 1024));
		JDialog dialogMem = new JDialog();
		dialogMem.setResizable(false);
		dialogMem.setTitle("Pregled Memorije");
		dialogMem.setModal(true);
		dialogMem.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent arg0) {
				// dialogMem.setVisible(false);
			}

		});
		guimem.setSadrzalacMemorije(dialogMem);
		dialogMem.add(guimem);
		dialogMem.setSize(500, 300);
		dialogMem.setLocation(100, 100);
		dialogMem.setVisible(true);

	}

}
