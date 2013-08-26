package sim.main;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;

import sim.components.*;


@SuppressWarnings("serial")
public class RegistersFrame extends JFrame implements ActionListener {

	private JButton izmeni;
	private JButton izadji;
	private JTextField[] regPolja;
	private REG[] allRegs;
	private Pin pswn, pswv, pswc, pswz, pswi, pswl0, pswl1;
	JTextField [] PSWbits = new JTextField[7];

	public RegistersFrame(HashMap<String, LogicalComponent> components) {

		setTitle("Registri");
		setLayout(new BorderLayout());
		setBackground(Color.white);
		allRegs = new REG[16];
		Registers allRegs = (Registers) components.get("addr.gpr");
		REG mar = (REG) components.get("bus.mar");
		REG mdr = (REG) components.get("bus.mdr");
		REG pc = (REG) components.get("fetch1.pc");
		REG ir0 = (REG) components.get("fetch1.ir31_24");
		REG ir1 = (REG) components.get("fetch1.ir23_16");
		REG ir2 = (REG) components.get("fetch1.ir15_8");
		REG ir3 = (REG) components.get("fetch1.ir7_0");
		REG sp = (REG) components.get("addr.sp");
		REG gprar = (REG) components.get("addr.gprar");
		REG ab = (REG) components.get("exec1.ab");
		REG bb = (REG) components.get("exec1.bb");
		REG aw = (REG) components.get("exec1.aw");
		REG bw = (REG) components.get("exec1.bw");
		REG imr = (REG) components.get("intr1.imr");
		REG br = (REG) components.get("intr3.br");
		REG ivtp = (REG) components.get("intr3.ivtp");
		
		pswn = components.get("exec2.pswn").getOut(0);
		pswz = components.get("exec2.pswz").getOut(0);
		pswc = components.get("exec2.pswc").getOut(0);
		pswv = components.get("exec2.pswv").getOut(0);
		pswi = components.get("exec2.pswi").getOut(0);
		pswl0 = components.get("exec2.pswl0").getOut(0);
		pswl1 = components.get("exec2.pswl1").getOut(0);
		
		
		Color bgcolor = Color.white;
		JPanel registrisvi = new JPanel(new GridLayout(1, 6));
		registrisvi.setBackground(bgcolor);

		this.regPolja = new JTextField[48];

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
			regPolja[i].setText(Integer.toHexString(allRegs.getRegValue(i)));
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
			regPolja[i].setText(Integer.toHexString(allRegs.getRegValue(i)));
			tmp.add(regPolja[i]);
			drugi.add(tmp);
		}

		registrisvi.add(drugi);

		JPanel peti = new JPanel(new GridLayout(16, 2));
		peti.setBackground(bgcolor);

		JLabel name;
		JPanel temp;

		name = new JLabel("MAR: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[32] = new JTextField();
		regPolja[32].setColumns(3);
		regPolja[32].setText(Integer.toHexString(mar.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[32]);
		peti.add(temp);

		name = new JLabel("MDR: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[33] = new JTextField();
		regPolja[33].setColumns(3);
		regPolja[33].setText(Integer.toHexString(mdr.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[33]);
		peti.add(temp);

		name = new JLabel("PC: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[34] = new JTextField();
		regPolja[34].setColumns(3);
		regPolja[34].setText(Integer.toHexString(pc.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[34]);
		peti.add(temp);

		name = new JLabel("IR0: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[35] = new JTextField();
		regPolja[35].setColumns(3);
		regPolja[35].setText(Integer.toHexString(ir0.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[35]);
		peti.add(temp);

		name = new JLabel("IR1: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[36] = new JTextField();
		regPolja[36].setColumns(3);
		regPolja[36].setText(Integer.toHexString(ir1.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[36]);
		peti.add(temp);

		name = new JLabel("IR2: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[37] = new JTextField();
		regPolja[37].setColumns(3);
		regPolja[37].setText(Integer.toHexString(ir2.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[37]);
		peti.add(temp);

		name = new JLabel("IR3: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[38] = new JTextField();
		regPolja[38].setColumns(3);
		regPolja[38].setText(Integer.toHexString(ir3.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[38]);
		peti.add(temp);

		name = new JLabel("SP: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[39] = new JTextField();
		regPolja[39].setColumns(3);
		regPolja[39].setText(Integer.toHexString(sp.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[39]);
		peti.add(temp);

		name = new JLabel("GPRAR: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[40] = new JTextField();
		regPolja[40].setColumns(3);
		regPolja[40].setText(Integer.toHexString(gprar.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[40]);
		peti.add(temp);

		name = new JLabel("AB: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[41] = new JTextField();
		regPolja[41].setColumns(3);
		regPolja[41].setText(Integer.toHexString(ab.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[41]);
		peti.add(temp);

		name = new JLabel("BB: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[42] = new JTextField();
		regPolja[42].setColumns(3);
		regPolja[42].setText(Integer.toHexString(bb.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[42]);
		peti.add(temp);

		name = new JLabel("AW: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[43] = new JTextField();
		regPolja[43].setColumns(3);
		regPolja[43].setText(Integer.toHexString(aw.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[43]);
		peti.add(temp);

		name = new JLabel("BW: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[44] = new JTextField();
		regPolja[44].setColumns(3);
		regPolja[44].setText(Integer.toHexString(bw.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[44]);
		peti.add(temp);

		name = new JLabel("IMR: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[45] = new JTextField();
		regPolja[45].setColumns(3);
		regPolja[45].setText(Integer.toHexString(imr.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[45]);
		peti.add(temp);

		name = new JLabel("BR: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		peti.add(name);
		regPolja[46] = new JTextField();
		regPolja[46].setColumns(3);
		regPolja[46].setText(Integer.toHexString(br.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[46]);
		peti.add(temp);

		registrisvi.add(peti);

		JPanel sesti = new JPanel(new GridLayout(16, 2));
		peti.setBackground(bgcolor);

		name = new JLabel("IVTP: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		regPolja[47] = new JTextField();
		regPolja[47].setColumns(3);
		regPolja[47].setText(Integer.toHexString(ivtp.getVal()));
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(regPolja[47]);
		sesti.add(temp);
		
		//////////////////////
		
		
		name = new JLabel("PSWN: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[0] = new JTextField();
//		PSWbits[0].setEnabled(false);
		PSWbits[0].setColumns(3);
		PSWbits[0].setText( Integer.toString( (pswn.getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[0]);
		sesti.add(temp);
		
		name = new JLabel("PSWZ: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[1] = new JTextField();
//		PSWbits[1].setEnabled(false);
		PSWbits[1].setColumns(3);
		PSWbits[1].setText( Integer.toString( (pswz.getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[1]);
		sesti.add(temp);
		
		name = new JLabel("PSWC: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[2] = new JTextField();
//		PSWbits[2].setEnabled(false);
		PSWbits[2].setColumns(3);
		PSWbits[2].setText( Integer.toString( (pswc.getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[2]);
		sesti.add(temp);
		
		name = new JLabel("PSWV: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[3] = new JTextField();
//		PSWbits[3].setEnabled(false);
		PSWbits[3].setColumns(3);
		PSWbits[3].setText( Integer.toString( (pswv.getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[3]);
		sesti.add(temp);
		
		name = new JLabel("PSWI: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[4] = new JTextField();
//		PSWbits[4].setEnabled(false);
		PSWbits[4].setColumns(3);
		PSWbits[4].setText( Integer.toString( (pswi.getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[4]);
		sesti.add(temp);
		
		name = new JLabel("PSWL0: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[5] = new JTextField();
//		PSWbits[5].setEnabled(false);
		PSWbits[5].setColumns(3);
		PSWbits[5].setText( Integer.toString( (pswl0.getBoolVal()?1:0) ) );
		temp = new JPanel();
		temp.setBackground(Color.white);
		temp.add(PSWbits[5]);
		sesti.add(temp);
		
		name = new JLabel("PSWL1: ");
		name.setVerticalAlignment(0);
		name.setHorizontalAlignment(4);
		sesti.add(name);
		PSWbits[6] = new JTextField();
//		PSWbits[6].setEnabled(false);
		PSWbits[6].setColumns(3);
		PSWbits[6].setText( Integer.toString( (pswl1.getBoolVal()?1:0) ) );
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
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				setVisible(false);
			}

		});
		setSize(500, 500);
		setLocation(100, 100);
	}

	public void actionPerformed(ActionEvent arg0) {

		int[] nizvrednosti = new int[81];
		if (arg0.getActionCommand().equals("Change")) {
			int val = 0;
			for (int i = 0; i < 81; i++) {
				val = proverivred(regPolja[i].getText(), i);
				if (val == -1)
					break;
				nizvrednosti[i] = val;
			}

			if (val != -1) {
				for (int i = 0; i < 81; i++) {
					allRegs[i].setVal(nizvrednosti[i]);
				}
				JOptionPane.showMessageDialog(RegistersFrame.this, "Promena uspe�na", "Promena registara", JOptionPane.INFORMATION_MESSAGE);

			} else {

				JOptionPane.showMessageDialog(RegistersFrame.this, "Promena neuspe�na. Neka od unetih vrednosti je nevalidna.", "Gre�ka", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private int proverivred(String text, int i) {
		int val;
		try {
			val = Integer.parseInt(text, 16);
		} catch (NumberFormatException nfe) {
			return -1;
		}

		int validBits;
		if (allRegs[i].getOut(0).isBool()) {
			validBits = allRegs[i].getOut().length;
		} else {
			validBits = allRegs[i].getOut(0).getNumOfLines();
		}
		if ((int) Math.pow(2.0D, validBits) <= val) {
			return -1;
		}

		return val;
	}

	public void updateRegisters() {
	//	for (int i = 0; i < 48; i++) {
	//		regPolja[i].setText(Integer.toHexString(allRegs[i].getVal()));
	//	}
	
		PSWbits[0].setText( Integer.toString( pswn.getBoolVal()?1:0 ) );
		PSWbits[1].setText( Integer.toString( pswz.getBoolVal()?1:0 ) );
		PSWbits[2].setText( Integer.toString( pswc.getBoolVal()?1:0 ) );
		PSWbits[3].setText( Integer.toString( pswv.getBoolVal()?1:0 ) );
		PSWbits[4].setText( Integer.toString( pswi.getBoolVal()?1:0 ) );
		PSWbits[5].setText( Integer.toString( pswl0.getBoolVal()?1:0 ) );
		PSWbits[6].setText( Integer.toString( pswl1.getBoolVal()?1:0 ) );
	}

}
