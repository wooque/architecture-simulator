package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import sim.components.*;


public class CPURegister extends JPanel implements ActionListener

{

	private static final long serialVersionUID = 1L;
	private JButton izmeni;
	private JButton izadji;
	private JDialog greska;
	private JDialog potvrda;
	private boolean error;
	private JTextField[] regPolja;
	private REG[] allRegs;
	private JDialog sadrzalacRegistara;
	JTextField [] PSWbits = new JTextField[7];

	public JDialog getSadrzalacRegistara() {
		return sadrzalacRegistara;
	}

	public void setSadrzalacRegistara(JDialog sadrzalacRegistara) {
		this.sadrzalacRegistara = sadrzalacRegistara;
	}

	public CPURegister() {

		setLayout(new BorderLayout());
		setBackground(Color.white);
		allRegs = new REG[81];
		for (int i = 0; i < 64; i++) {
			allRegs[i] = Adr.GPR().getREG(i);
		}
		allRegs[64] = Bus1.RegMAR();
		allRegs[65] = Bus1.RegMDR();
		allRegs[66] = Fetch1.RegPC();
		allRegs[67] = Fetch1.RegIR0();
		allRegs[68] = Fetch1.RegIR1();
		allRegs[69] = Fetch1.RegIR2();
		allRegs[70] = Fetch1.RegIR3();
		allRegs[71] = Adr.RegSP();
		allRegs[72] = Adr.RegGPRAR();
		allRegs[73] = Exec1.RegAB();
		allRegs[74] = Exec1.RegBB();
		allRegs[75] = Exec1.RegAW();
		allRegs[76] = Exec1.RegBWH();
		allRegs[77] = Exec1.RegBWL();
		allRegs[78] = Intr1.RegIMR();
		allRegs[79] = Intr3.RegBR();
		allRegs[80] = Intr3.RegIVTP();
	}

	public void init() {
		Color bgcolor = Color.white;
		JPanel registrisvi = new JPanel(new GridLayout(1, 6));
		registrisvi.setBackground(bgcolor);

		this.regPolja = new JTextField[81];

		JPanel prvi = new JPanel(new GridLayout(16, 2));
		prvi.setBackground(bgcolor);
		for (int i = 0; i < 16; i++) {
			JLabel ime = new JLabel("R" + i + ": ");
			ime.setVerticalAlignment(0);
			ime.setHorizontalAlignment(4);
			prvi.add(ime);
			JPanel tmp = new JPanel();
			tmp.setBackground(bgcolor);
			regPolja[i] = new JTextField(5);// 5 je broj kolona
			regPolja[i].setColumns(3);
			regPolja[i].setText(Integer.toHexString(allRegs[i].getVal()));
			tmp.add(regPolja[i]);
			prvi.add(tmp);
		}

		registrisvi.add(prvi);

		JPanel drugi = new JPanel(new GridLayout(16, 2));
		drugi.setBackground(bgcolor);
		for (int i = 16; i < 32; i++) {
			JLabel ime = new JLabel("R" + i + ": ");
			ime.setVerticalAlignment(0);
			ime.setHorizontalAlignment(4);
			drugi.add(ime);
			JPanel tmp = new JPanel();
			tmp.setBackground(Color.white);
			regPolja[i] = new JTextField(5);
			regPolja[i].setColumns(3);
			regPolja[i].setText(Integer.toHexString(allRegs[i].getVal()));
			tmp.add(regPolja[i]);
			drugi.add(tmp);
		}

		registrisvi.add(drugi);

		JPanel treci = new JPanel(new GridLayout(16, 2));
		treci.setBackground(bgcolor);
		for (int i = 32; i < 48; i++) {
			JLabel ime = new JLabel("R" + i + ": ");
			ime.setVerticalAlignment(0);
			ime.setHorizontalAlignment(4);
			treci.add(ime);
			JPanel tmp = new JPanel();
			tmp.setBackground(Color.white);
			regPolja[i] = new JTextField(5);
			regPolja[i].setColumns(3);
			regPolja[i].setText(Integer.toHexString(allRegs[i].getVal()));
			tmp.add(regPolja[i]);
			treci.add(tmp);
		}

		registrisvi.add(treci);

		JPanel cetvrti = new JPanel(new GridLayout(16, 2));
		cetvrti.setBackground(bgcolor);
		for (int i = 48; i < 64; i++) {
			JLabel ime = new JLabel("R" + i + ": ");
			ime.setVerticalAlignment(0);
			ime.setHorizontalAlignment(4);
			cetvrti.add(ime);
			JPanel tmp = new JPanel();
			tmp.setBackground(Color.white);
			this.regPolja[i] = new JTextField(5);
			this.regPolja[i].setColumns(3);
			this.regPolja[i].setText(Integer.toHexString(allRegs[i].getVal()));
			tmp.add(regPolja[i]);
			cetvrti.add(tmp);
		}

		registrisvi.add(cetvrti);

		JPanel peti = new JPanel(new GridLayout(16, 2));
		peti.setBackground(bgcolor);

		JLabel name;
		JPanel temp;

		name = new JLabel("MAR: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[64] = new JTextField();
		regPolja[64].setColumns(3);
		regPolja[64].setText(Integer.toHexString(allRegs[64].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[64]);
		peti.add(temp);

		name = new JLabel("MDR: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[65] = new JTextField();
		regPolja[65].setColumns(3);
		regPolja[65].setText(Integer.toHexString(allRegs[65].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[65]);
		peti.add(temp);

		name = new JLabel("PC: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[66] = new JTextField();
		regPolja[66].setColumns(3);
		regPolja[66].setText(Integer.toHexString(allRegs[66].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[66]);
		peti.add(temp);

		name = new JLabel("IR0: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[67] = new JTextField();
		regPolja[67].setColumns(3);
		regPolja[67].setText(Integer.toHexString(allRegs[67].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[67]);
		peti.add(temp);

		name = new JLabel("IR1: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[68] = new JTextField();
		regPolja[68].setColumns(3);
		regPolja[68].setText(Integer.toHexString(allRegs[68].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[68]);
		peti.add(temp);

		name = new JLabel("IR2: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[69] = new JTextField();
		regPolja[69].setColumns(3);
		regPolja[69].setText(Integer.toHexString(allRegs[69].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[69]);
		peti.add(temp);

		name = new JLabel("IR3: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[70] = new JTextField();
		regPolja[70].setColumns(3);
		regPolja[70].setText(Integer.toHexString(allRegs[70].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[70]);
		peti.add(temp);

		name = new JLabel("SP: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[71] = new JTextField();
		regPolja[71].setColumns(3);
		regPolja[71].setText(Integer.toHexString(allRegs[71].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[71]);
		peti.add(temp);

		name = new JLabel("GPRAR: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[72] = new JTextField();
		regPolja[72].setColumns(3);
		regPolja[72].setText(Integer.toHexString(allRegs[72].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[72]);
		peti.add(temp);

		name = new JLabel("AB: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[73] = new JTextField();
		regPolja[73].setColumns(3);
		regPolja[73].setText(Integer.toHexString(allRegs[73].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[73]);
		peti.add(temp);

		name = new JLabel("BB: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[74] = new JTextField();
		regPolja[74].setColumns(3);
		regPolja[74].setText(Integer.toHexString(allRegs[74].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[74]);
		peti.add(temp);

		name = new JLabel("AW: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[75] = new JTextField();
		regPolja[75].setColumns(3);
		regPolja[75].setText(Integer.toHexString(allRegs[75].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[75]);
		peti.add(temp);

		name = new JLabel("BWH: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[76] = new JTextField();
		regPolja[76].setColumns(3);
		regPolja[76].setText(Integer.toHexString(allRegs[76].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[76]);
		peti.add(temp);

		name = new JLabel("BWL: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[77] = new JTextField();
		regPolja[77].setColumns(3);
		regPolja[77].setText(Integer.toHexString(allRegs[77].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[77]);
		peti.add(temp);

		name = new JLabel("IMR: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[78] = new JTextField();
		regPolja[78].setColumns(3);
		regPolja[78].setText(Integer.toHexString(allRegs[78].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[78]);
		peti.add(temp);

		name = new JLabel("BR: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[79] = new JTextField();
		regPolja[79].setColumns(3);
		regPolja[79].setText(Integer.toHexString(allRegs[79].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[79]);
		peti.add(temp);

		registrisvi.add(peti);

		JPanel sesti = new JPanel(new GridLayout(16, 2));
		peti.setBackground(bgcolor);

		name = new JLabel("IVTP: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		regPolja[80] = new JTextField();
		regPolja[80].setColumns(3);
		regPolja[80].setText(Integer.toHexString(allRegs[80].getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[80]);
		sesti.add(temp);
		
		//////////////////////
		
		
		name = new JLabel("PSWN: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[0] = new JTextField();
		PSWbits[0].setEnabled(false);
		PSWbits[0].setColumns(3);
		PSWbits[0].setText( Integer.toString( (Exec2.PSWN().getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[0]);
		sesti.add(temp);
		
		name = new JLabel("PSWZ: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[1] = new JTextField();
		PSWbits[1].setEnabled(false);
		PSWbits[1].setColumns(3);
		PSWbits[1].setText( Integer.toString( (Exec2.PSWZ().getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[1]);
		sesti.add(temp);
		
		name = new JLabel("PSWC: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[2] = new JTextField();
		PSWbits[2].setEnabled(false);
		PSWbits[2].setColumns(3);
		PSWbits[2].setText( Integer.toString( (Exec2.PSWC().getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[2]);
		sesti.add(temp);
		
		name = new JLabel("PSWV: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[3] = new JTextField();
		PSWbits[3].setEnabled(false);
		PSWbits[3].setColumns(3);
		PSWbits[3].setText( Integer.toString( (Exec2.PSWV().getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[3]);
		sesti.add(temp);
		
		name = new JLabel("PSWI: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[4] = new JTextField();
		PSWbits[4].setEnabled(false);
		PSWbits[4].setColumns(3);
		PSWbits[4].setText( Integer.toString( (Exec2.PSWI().getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[4]);
		sesti.add(temp);
		
		name = new JLabel("PSWL0: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[5] = new JTextField();
		PSWbits[5].setEnabled(false);
		PSWbits[5].setColumns(3);
		PSWbits[5].setText( Integer.toString( (Exec2.PSWL0().getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[5]);
		sesti.add(temp);
		
		name = new JLabel("PSWL1: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[6] = new JTextField();
		PSWbits[6].setEnabled(false);
		PSWbits[6].setColumns(3);
		PSWbits[6].setText( Integer.toString( (Exec2.PSWL1().getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[6]);
		sesti.add(temp);

		for (int i = 0; i < 16; i++) {
			JLabel tmp1 = new JLabel("  ");
			sesti.add(tmp1);
		}
		////////////////////////
		sesti.setBackground(Color.white);

		registrisvi.add(sesti);

		add(registrisvi, "Center");

		JPanel komande = new JPanel();
		komande.setBackground(bgcolor);

		izmeni = new JButton("Change");
		izmeni.addActionListener(this);

		izadji = new JButton("Cancel ");
		izadji.addActionListener(this);

		komande.add(this.izmeni);
		komande.add(this.izadji);
		add(komande, "South");
	}

	public void actionPerformed(ActionEvent arg0) {

		int[] nizvrednosti = new int[81];
		if (arg0.getActionCommand().equals("Change")) {
			for (int i = 0; i < 81; i++) {
				int val = proverivred(regPolja[i].getText(), i);
				if (error)
					break;
				nizvrednosti[i] = val;
			}

			if (!error) {
				for (int i = 0; i < 81; i++) {
					allRegs[i].setVal(nizvrednosti[i]);
				}
				potvrda = new JDialog();
				potvrda.setSize(350, 100);
				potvrda.setLocation(200, 200);
				potvrda.setModal(true);
				potvrda.setTitle("Potvrda");
				JPanel osnovni = new JPanel(new GridLayout(2, 1));
				JLabel lab = new JLabel(
						"Promena sadrzaja registara je uspesno odradjena!");
				lab.setHorizontalAlignment(0);
				osnovni.add(lab);
				JButton ok = new JButton("U redu");
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						potvrda.setVisible(false);

					}
				});
				JPanel tmp = new JPanel();
				tmp.add(ok);
				tmp.setBackground(Color.white);
				osnovni.add(tmp);
				osnovni.setBackground(Color.white);
				potvrda.add(osnovni);
				potvrda.setVisible(true);

			} else {
				error = false;
				greska = new JDialog();
				greska.setSize(550, 150);
				greska.setLocation(200, 200);
				greska.setModal(true);
				greska.setTitle("Greska!");
				JPanel osnovni = new JPanel(new GridLayout(3, 1));
				JLabel lab = new JLabel(
						"Neka od unetih vrednosti nije dobra (ili prelazi velicinu registra ili je unet netacan hex. broj).");
				lab.setHorizontalAlignment(0);
				osnovni.add(lab);
				JLabel lab1 = new JLabel(
						"Zato se brisu sve tekuce izmene registara!");
				lab1.setHorizontalAlignment(0);
				osnovni.add(lab1);
				JButton ok = new JButton("U redu");
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						greska.setVisible(false);
						sadrzalacRegistara.setVisible(false);// da se ugasi i
																// pregled
																// registara jer
					} // ako se on ne ugasi onda ostaju da se vide te nevalidne
						// vrednosti koje
				}); // idu van opsega
				JPanel tmp = new JPanel();
				tmp.add(ok);
				tmp.setBackground(Color.white);
				osnovni.add(tmp);
				osnovni.setBackground(Color.white);
				greska.add(osnovni);
				greska.setVisible(true);
			}
		} else {// ako je izadji
			sadrzalacRegistara.setVisible(false);
		}
	}

	private int proverivred(String text, int i) {
		int val;
		try {
			val = Integer.parseInt(text, 16);
		} catch (Exception e) { // ZBOG NUMBER FORMAT EXCEPTION!
			error = true;
			return 0;
		}

		int validBits;
		if (allRegs[i].getOut(0).isBool()) {
			validBits = allRegs[i].getOut().length;
		} else {
			validBits = allRegs[i].getOut(0).getNumOfLines();
		}
		if ((int) Math.pow(2.0D, validBits) <= val) {
			error = true;
		}

		return val;
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < 81; i++) {
			regPolja[i].setText(Integer.toHexString(allRegs[i].getVal()));
		}
		
		PSWbits[0].setText( Integer.toString( Exec2.PSWN().getBoolVal()?1:0 ) );
		PSWbits[1].setText( Integer.toString( Exec2.PSWZ().getBoolVal()?1:0 ) );
		PSWbits[2].setText( Integer.toString( Exec2.PSWC().getBoolVal()?1:0 ) );
		PSWbits[3].setText( Integer.toString( Exec2.PSWV().getBoolVal()?1:0 ) );
		PSWbits[4].setText( Integer.toString( Exec2.PSWI().getBoolVal()?1:0 ) );
		PSWbits[5].setText( Integer.toString( Exec2.PSWL0().getBoolVal()?1:0 ) );
		PSWbits[6].setText( Integer.toString( Exec2.PSWL1().getBoolVal()?1:0 ) );

	}

}
