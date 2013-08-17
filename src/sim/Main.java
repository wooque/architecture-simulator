package sim;
import java.awt.BorderLayout;
import java.awt.Dimension;
//import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;

import javax.swing.*;

import sim.assembler.Assembler;
import sim.components.*;
import sim.gui.*;

@SuppressWarnings("serial")
public class Main extends JFrame {

	JPanel east = new JPanel();
	JPanel northeast = new JPanel();
	JPanel southeast = new JPanel();
	JPanel west = new JPanel();

	JLabel CPUclock = new JLabel("CPU clock = 0");
	JLabel BUSclock = new JLabel("BUS clock = 0");
	JLabel MEMclock = new JLabel("MEM clock = 0");
	JLabel Tcpu = new JLabel("Tcpu = 0");
	JLabel Tmem = new JLabel("Tmem = 0");
	JLabel PC = new JLabel("PC = 0");
	JButton CLK = new JButton("CLK+");
	JButton INS = new JButton("INS+");
	JButton PRG = new JButton("PRG+");
	JLabel asmtxt = new JLabel("Asemblerski kod:");

	JButton reset = new JButton("RESET");
	JButton registers = new JButton("REGISTRI");
	JButton memory = new JButton("MEMORIJA");
	JButton resetnomem = new JButton("RESET BEZ MEM");
	JPanel menu = new JPanel();

	// Labela za oznaku faze
	JLabel phaseName = new JLabel("Faza izvrsavanja:");
	// Labela koja kazuje fazu
	JLabel phase = new JLabel("Citanje instrukcije");
	// Dodatne informacije o fazi
	JLabel phaseExtraInfo = new JLabel("-");
	// Labela za oznaku nacina adresiranja
	JLabel adrName = new JLabel("Adresiranje:");
	// Labela koja kazuje nacina adresiranja
	JLabel adr = new JLabel("-");
	// Oznaka operacije
	JLabel operName = new JLabel("Operacija:");
	// Operacija
	JLabel oper = new JLabel("-");

	// treba dodati opcioju da se resetuje sistem na pocetno stanje

	JTextArea asmtext = new JTextArea();
	
	JButton load = new JButton("Ucitaj u memoriju");
	

	List listOfShemes = new List();
	GuiScheme currentScheme;
	PrintStream log;

//	Asembler asm = new Asembler();

//	CPURegister cpuregs = new CPURegister();
//	public static JDialog dialogRegs = new JDialog();
//
//	Memory guimem = new Memory();
//	public static JDialog dialogMem = new JDialog();
//	public void update(Graphics g){
//		paint(g);
//	}
	
	public Main() {
		try {
			log = new PrintStream(new FileOutputStream("log/debug.log"), true);
		} catch (FileNotFoundException e) {
			System.out.println("Log file can't be open, logging on standard output");
		}
		Configurator conf = new Configurator("conf/schemes.conf", log);
		final HashMap<String, LogicalComponent> components = conf.getComponents();
		
		GuiConfigurator guiConf = new GuiConfigurator(components, "conf/gui.conf", log);
		final HashMap<String, GuiScheme> schemes = guiConf.getGuiSchemes();
		
		final Pin pc = components.get("fetch1.pc").getOut(0);
		final Pin cnt = components.get("uprav.cnt").getOut(0);
		final Pin mem_cnt = components.get("mem_uprav.memacc").getOut(0);
		final Pin start = components.get("exec2.start").getOut(0);
		
		currentScheme = schemes.get("adr_1.png");

//		cpuregs.init();
//		guimem.init();

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
            	log.close();
                dispose();
            }
        });
		add("Center",currentScheme);
		
		Dimension d=new Dimension(160, 620);
		east.setMaximumSize(d);
		east.setMinimumSize(d);
		east.setPreferredSize(d);
		east.setSize(d);
		
		northeast.setLayout(new GridLayout(2, 1));
		JPanel northeastI=new JPanel();
		northeastI.setLayout(new BoxLayout(northeastI, BoxLayout.Y_AXIS));
		CPUclock.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(CPUclock);
		BUSclock.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(BUSclock);
		MEMclock.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(MEMclock);
		Tcpu.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(Tcpu);
		Tmem.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(Tmem);
		PC.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(PC);
		northeast.add(northeastI);

		CLK.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				LogicalComponent.CLK();

				CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);

				BUSclock.setText("BUS clock = " + (int)(LogicalComponent.globalClock/2));
				
				MEMclock.setText("MEM clock = " + (int)(LogicalComponent.globalClock/3));
				
				String step = Integer.toHexString(cnt.getIntVal());

				Tcpu.setText("Tcpu = " + step);
				
				String stepmem = Integer.toHexString(mem_cnt.getIntVal());

				Tmem.setText("Tmem = " + stepmem);
				
				PC.setText("PC = "+pc.getIntVal());

				// U zavisnosti od koraka T postavi fazu
				if ("0".equals(step)) {
					phase.setText("Citanje instrukcije");
					adr.setText("-");
					oper.setText("-");
					phaseExtraInfo.setText("-");
				} else if ("2".equals(step))
					phaseExtraInfo.setText("Dohvatanje prvog bajta");
				else if ("9".equals(step))
					phaseExtraInfo.setText("Dohvatanje drugog bajta");
				else if ("11".equals(step))
					phaseExtraInfo.setText("Dohvatanje treceg bajta");
				else if ("16".equals(step))
					phaseExtraInfo.setText("Dohvatanje cetvrtog bajta");
				else if ("1a".equals(step)) {
					phase.setText("Formiranje adr i citanje oper");
					phaseExtraInfo.setText("-");
				} else if ("1b".equals(step))
					adr.setText("Registarsko direktno");
				else if ("1f".equals(step))
					adr.setText("Registarsko ind. sa pomerajem");
				else if ("22".equals(step))
					adr.setText("PC relativno");
				else if ("2c".equals(step))
					adr.setText("Neposredno");
				else if ("2d".equals(step)) {
					phase.setText("Izvrsavanje operacije");
					phaseExtraInfo.setText("-");
				} else if ("2e".equals(step))
					oper.setText("NOP");
				else if ("2f".equals(step))
					oper.setText("HALT");
				else if ("30".equals(step))
					oper.setText("INTD");
				else if ("31".equals(step))
					oper.setText("INTE");
				else if ("32".equals(step))
					oper.setText("TRPD");
				else if ("33".equals(step))
					oper.setText("TRPE");
				else if ("34".equals(step))
					oper.setText("LDB");
				else if ("36".equals(step))
					oper.setText("LDW");
				else if ("37".equals(step))
					oper.setText("STB");
				else if ("3d".equals(step))
					oper.setText("STW");
				else if ("46".equals(step))
					oper.setText("STIVTP");
				else if ("47".equals(step))
					oper.setText("STSP");
				else if ("48".equals(step))
					oper.setText("ADD");
				else if ("4a".equals(step))
					oper.setText("SUB");
				else if ("4c".equals(step))
					oper.setText("AND");
				else if ("4e".equals(step))
					oper.setText("OR");
				else if ("50".equals(step))
					oper.setText("XOR");
				else if ("52".equals(step))
					oper.setText("NOT");
				else if ("54".equals(step)){
//					if(Fetch2.ASR().getBoolVal())oper.setText("ASR");
//					else if (Fetch2.LSR().getBoolVal())oper.setText("LSR");
//					else if (Fetch2.ROR().getBoolVal())oper.setText("ROR");
//					else if (Fetch2.RORC().getBoolVal())oper.setText("RORC");
				}
				else if ("56".equals(step)){
//					if(Fetch2.ASL().getBoolVal())oper.setText("ASL");
//					else if (Fetch2.LSL().getBoolVal())oper.setText("LSL");
//					else if (Fetch2.ROL().getBoolVal())oper.setText("ROL");
//					else if (Fetch2.ROLC().getBoolVal())oper.setText("ROLC");
				}
				else if ("58".equals(step)){
//					if(Fetch2.BEQL().getBoolVal())oper.setText("BEQL");
//					else if (Fetch2.BNEQ().getBoolVal())oper.setText("BNEQ");
//					else if (Fetch2.BNEG().getBoolVal())oper.setText("BNEG");
//					else if (Fetch2.BNNG().getBoolVal())oper.setText("BNNG");
//					else if (Fetch2.BOVF().getBoolVal())oper.setText("BOVF");
//					else if (Fetch2.BNVF().getBoolVal())oper.setText("BNVF");
//					else if (Fetch2.BCR().getBoolVal())oper.setText("BCR");
//					else if (Fetch2.BNCR().getBoolVal())oper.setText("BNCR");
//					else if (Fetch2.BGRT().getBoolVal())oper.setText("BGRT");
//					else if (Fetch2.BGRE().getBoolVal())oper.setText("BGRE");
//					else if (Fetch2.BLSS().getBoolVal())oper.setText("BLSS");
//					else if (Fetch2.BLEQ().getBoolVal())oper.setText("BLEQ");
//					else if (Fetch2.BGRTU().getBoolVal())oper.setText("BGRTU");
//					else if (Fetch2.BGREU().getBoolVal())oper.setText("BGREU");
//					else if (Fetch2.BLSSU().getBoolVal())oper.setText("BLSSU");
//					else if (Fetch2.BLEQU().getBoolVal())oper.setText("BLEQU");
				}
				else if ("5b".equals(step))
					oper.setText("JMP");
				else if ("5c".equals(step))
					oper.setText("INT");
				else if ("5d".equals(step))
					oper.setText("JSR");
				else if ("64".equals(step))
					oper.setText("RTI");
				else if (("6c".equals(step))&&(components.get("fetch2.rts").getOut(0).getBoolVal()))
					oper.setText("RTS");
				else if ("75".equals(step)) {
					phase.setText("Opsluzivanje prekida");
					phaseExtraInfo.setText("-");
				} else if ("76".equals(step))
					phaseExtraInfo.setText("Cuvanje konteksta");
				else if ("8d".equals(step))
					phaseExtraInfo
							.setText("Utvrdjivanje adrese prekidne rutine");

				// System.out.println(step + ":   " +
				// Bus3.FFC.in[0].getBoolVal() + Bus3.FFC.out[0].getBoolVal() +
				// "   " + Bus3.FFC.out[1].getBoolVal());

				currentScheme.repaint();
				// cpuregs.repaint(); suvisno je jer kad se otvori dijalog tada
				// ne moze da se krece kroz simulaciju
				if(start.getBoolVal() == false){
					CLK.setEnabled(false);
					INS.setEnabled(false);
					PRG.setEnabled(false);
				}
			} // pa ne moze da ispadnu lose brojke u pregledu registara ako se
				// ne repaintuje
		});
		CLK.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(CLK);
		
		
		INS.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// par kloka da izadje iz T00
				LogicalComponent.CLK();
				CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);
				BUSclock.setText("BUS clock = " + (int)(LogicalComponent.globalClock/2));
				MEMclock.setText("MEM clock = " + (int)(LogicalComponent.globalClock/3));
				Tcpu.setText("Tcpu = "+ Integer.toHexString(cnt.getIntVal()));
				Tmem.setText("Tmem = "+ Integer.toHexString(mem_cnt.getIntVal()));
				PC.setText("PC = "+pc.getIntVal());
				currentScheme.repaint();
				if(start.getBoolVal() == false){
					CLK.setEnabled(false);
					INS.setEnabled(false);
					PRG.setEnabled(false);
				}
				LogicalComponent.CLK();
				CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);
				BUSclock.setText("BUS clock = " + (int)(LogicalComponent.globalClock/2));
				MEMclock.setText("MEM clock = " + (int)(LogicalComponent.globalClock/3));
				Tcpu.setText("Tcpu = "+ Integer.toHexString(cnt.getIntVal()));
				Tmem.setText("Tmem = "+ Integer.toHexString(mem_cnt.getIntVal()));
				PC.setText("PC = "+pc.getIntVal());
				currentScheme.repaint();
				if(start.getBoolVal() == false){
					CLK.setEnabled(false);
					INS.setEnabled(false);
					PRG.setEnabled(false);
				}
				// vrti se dok ne dodje do T00
				while ((cnt.getIntVal() != 0)&&(start.getBoolVal() == true)){
					LogicalComponent.CLK();
					CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);
					BUSclock.setText("BUS clock = " + (int)(LogicalComponent.globalClock/2));
					MEMclock.setText("MEM clock = " + (int)(LogicalComponent.globalClock/3));
					Tcpu.setText("Tcpu = "+ Integer.toHexString(cnt.getIntVal()));
					Tmem.setText("Tmem = "+ Integer.toHexString(mem_cnt.getIntVal()));
					PC.setText("PC = "+pc.getIntVal());
					currentScheme.repaint();
				}
				if(start.getBoolVal() == false){
					CLK.setEnabled(false);
					INS.setEnabled(false);
					PRG.setEnabled(false);
				}
				phase.setText("Citanje instrukcije");
				adr.setText("-");
				oper.setText("-");
				phaseExtraInfo.setText("-");
			}
		});
		INS.setAlignmentX(CENTER_ALIGNMENT);
		//northeastI.add(INS);
		JPanel child=new JPanel(new GridLayout(1,2));
		child.add(INS);
		
		PRG.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				while (start.getBoolVal() == true) {
					LogicalComponent.CLK();
					CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);
					BUSclock.setText("BUS clock = " + (int)(LogicalComponent.globalClock/2));
					MEMclock.setText("MEM clock = " + (int)(LogicalComponent.globalClock/3));
					Tcpu.setText("Tcpu = "+ Integer.toHexString(cnt.getIntVal()));
					Tmem.setText("Tmem = "+ Integer.toHexString(mem_cnt.getIntVal()));
					PC.setText("PC = "+pc.getIntVal());
					currentScheme.repaint();
				}
				CLK.setEnabled(false);
				INS.setEnabled(false);
				PRG.setEnabled(false);
			}
		});
		PRG.setAlignmentX(CENTER_ALIGNMENT);
		//northeastI.add(PRG);
		child.add(PRG);
		northeastI.add(child);
		
		JPanel northeastII=new JPanel();
		northeastII.setLayout(new BoxLayout(northeastII, BoxLayout.Y_AXIS));
		// Dodati labelu koja kazuje fazu
		phaseName.setAlignmentX(CENTER_ALIGNMENT);
		northeastII.add(phaseName);
		//phaseName.setFont(new Font("D", 10, 13));
		phase.setAlignmentX(CENTER_ALIGNMENT);
		northeastII.add(phase);
		phaseExtraInfo.setAlignmentX(CENTER_ALIGNMENT);
		northeastII.add(phaseExtraInfo);
		// Dodati labelu koja kazuje nacin adresiranja
		adrName.setAlignmentX(CENTER_ALIGNMENT);
		northeastII.add(adrName);
		//adrName.setFont(new Font("D", 10, 13));
		adr.setAlignmentX(CENTER_ALIGNMENT);
		northeastII.add(adr);
		// Dodati labelu koja kazuje vrstu operacije
		operName.setAlignmentX(CENTER_ALIGNMENT);
		northeastII.add(operName);
		//operName.setFont(new Font("D", 10, 13));
		oper.setAlignmentX(CENTER_ALIGNMENT);
		northeastII.add(oper);
		northeast.add(northeastII);
		
		asmtext.setText("ld #4\nst r0\nld #5\nst r1\nadd r0\nhalt");
		asmtext.setAlignmentX(CENTER_ALIGNMENT);

		load.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				//String asmcode = asmtext.getText();
				Assembler asm = new Assembler("asm/test.asm", log);
				Object[] code = asm.getCode();
				int start = asm.getStartOfCode();
				MEM mem = ((MEM)components.get("mem_oper.mem"));
				for(int i = 0; i < code.length; i++) {
					mem.write(start + i, (Integer)code[i]);
				}
				REG pc = ((REG)components.get("fetch1.pc"));
				pc.initVal(start);
				JOptionPane.showMessageDialog(load.getParent().getParent().getParent(), "Program ucitan u memoriju", "Ucitavanje programa", JOptionPane.PLAIN_MESSAGE);
			}
		});
		load.setAlignmentX(CENTER_ALIGNMENT);

//		memory.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//
//				// JFrame mem = new JFrame();
//
//				// mem.setBounds(currentScheme.getX() + currentScheme.getWidth()
//				// 8, currentScheme.getY(), 600, 600);
//
//				// mem.setLayout(new GridLayout(8 * 32, 8 * 32));
//
//				// mem.getContentPane().setBackground(Color.WHITE);
//
//				// for (int i = 0; i < 64 * 1024; i++)
//				// mem.add(new JLabel(" mem" + i + ": " + Mem11.readMEM(i)));
//
//				// mem.setVisible(true);
//
//				dialogMem.setVisible(true);
//				currentScheme.repaint();
//
//			}
//		});
//		memory.setAlignmentX(CENTER_ALIGNMENT);
//
//		registers.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//
//				// JFrame regs = new JFrame();
//
//				// regs.setBounds(currentScheme.getX() +
//				// currentScheme.getWidth()
//				// / 8, currentScheme.getY(), 600, 600);
//
//				// regs.setLayout(new GridLayout(8, 8));
//
//				// regs.getContentPane().setBackground(Color.WHITE);
//
//				// for (int i = 0; i < 64; i++)
//				// regs.add(new JLabel(" Reg" + i + ": " + Adr.readGPR(i)));
//
//				dialogRegs.setVisible(true);
//
//				currentScheme.repaint();
//
//			}
//		});
//		registers.setAlignmentX(CENTER_ALIGNMENT);

		reset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				//LogicalComponent.resetSimulation();
				LogicalComponent.initMemory=true;
				LogicalComponent.initialise();
				
				// Podesi labele
				CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);
				BUSclock.setText("BUS clock = " + (int)(LogicalComponent.globalClock/2));
				MEMclock.setText("MEM clock = " + (int)(LogicalComponent.globalClock/3));
				Tcpu.setText("Tcpu = "+ Integer.toHexString(cnt.getIntVal()));
				Tmem.setText("Tmem = "+ Integer.toHexString(mem_cnt.getIntVal()));
				PC.setText("PC ="+pc.getIntVal());
				phase.setText("Citanje instrukcije");
				adr.setText("-");
				oper.setText("-");
				phaseExtraInfo.setText("-");

				// Ucitaj na pocetku program iz text-area
				//String asmcode = asmtext.getText();
				//asm.asembly(asmcode);

				JOptionPane.showMessageDialog(load.getParent().getParent()
						.getParent(), "Simulacija resetovana",
						"Resetovanje simulacije...", JOptionPane.PLAIN_MESSAGE);
				CLK.setEnabled(true);
				INS.setEnabled(true);
				PRG.setEnabled(true);
				currentScheme.repaint();

			}
		});
		reset.setAlignmentX(CENTER_ALIGNMENT);
		
		resetnomem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				//LogicalComponent.resetSimulation();
				LogicalComponent.initMemory=false;
				LogicalComponent.initialise();
				
				// Podesi labele
				CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);
				BUSclock.setText("BUS clock = " + (int)(LogicalComponent.globalClock/2));
				MEMclock.setText("MEM clock = " + (int)(LogicalComponent.globalClock/3));
				Tcpu.setText("Tcpu = "+ Integer.toHexString(cnt.getIntVal()));
				Tmem.setText("Tmem = "+ Integer.toHexString(mem_cnt.getIntVal()));
				PC.setText("PC ="+pc.getIntVal());
				phase.setText("Citanje instrukcije");
				adr.setText("-");
				oper.setText("-");
				phaseExtraInfo.setText("-");

				// Ucitaj na pocetku program iz text-area
				//String asmcode = asmtext.getText();
				//asm.asembly(asmcode);

				JOptionPane.showMessageDialog(load.getParent().getParent()
						.getParent(), "Simulator resetovan, memorija nepromenjena.",
						"Resetovanje simulacije...", JOptionPane.PLAIN_MESSAGE);
				CLK.setEnabled(true);
				INS.setEnabled(true);
				PRG.setEnabled(true);
				currentScheme.repaint();

			}
		});
		resetnomem.setAlignmentX(CENTER_ALIGNMENT);

		southeast.setLayout(new BoxLayout(southeast, BoxLayout.Y_AXIS));

		// Dodat scroll bar za asemblerski tekst
		//
		asmtxt.setAlignmentX(CENTER_ALIGNMENT);
		southeast.add(asmtxt);

		JScrollPane scrolltxt = new JScrollPane(asmtext);
		scrolltxt.setName("KOD");
		scrolltxt.setAlignmentX(CENTER_ALIGNMENT);
		southeast.add(scrolltxt);
		
		southeast.add(load);
		

		east.setLayout(new GridLayout(2, 1));
		east.add(northeast);
		east.add(southeast);
		add("East", east);

		listOfShemes.add("Arbitrator");
		listOfShemes.add("Procesor");
		listOfShemes.add("     Operaciona");
		listOfShemes.add("          Addr");
		listOfShemes.add("          Bus 1");
		listOfShemes.add("          Bus 2");
		listOfShemes.add("          Bus 3");
		listOfShemes.add("          Exec 1");
		listOfShemes.add("          Exec 2");
		listOfShemes.add("          Exec 3");
		listOfShemes.add("          Exec 4");
		listOfShemes.add("          Fetch 1");
		listOfShemes.add("          Fetch 2");
		listOfShemes.add("          Fetch 3");
		listOfShemes.add("          Intr 1");
		listOfShemes.add("          Intr 2");
		listOfShemes.add("          Intr 3");
		listOfShemes.add("     Upravljacka");
		listOfShemes.add("          Brojac koraka");
		listOfShemes.add("          Operacioni 1");
		listOfShemes.add("          Operacioni 2");
		listOfShemes.add("          Upravljacki 1");
		listOfShemes.add("          Upravljacki 2");
		listOfShemes.add("Memorija");
		listOfShemes.add("      Operaciona jedinica");
		listOfShemes.add("      Upravljacka jedinica");

		listOfShemes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				remove(currentScheme);
				if (listOfShemes.getSelectedItem().equals("          Addr") || listOfShemes.getSelectedItem().equals("Procesor") || listOfShemes.getSelectedItem().equals("     Operaciona")) {
					currentScheme = schemes.get("adr_1.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Bus")) {
					currentScheme = schemes.get("bus_1.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Brojac koraka") || listOfShemes.getSelectedItem().equals(
						"     Upravljacka")) {
					currentScheme = schemes.get("uprav_jed_hard.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Exec 1")) {
					currentScheme = schemes.get("exec_1.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Exec 2")) {
					currentScheme = schemes.get("exec_2.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Exec 3")) {
					currentScheme = schemes.get("exec_3.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Exec 4")) {
					currentScheme = schemes.get("exec_4.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Fetch 1")) {
					currentScheme = schemes.get("fetch_1.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Fetch 2")) {
					currentScheme = schemes.get("fetch_2.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Fetch 3")) {
					currentScheme = schemes.get("fetch_3.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Intr 1")) {
					currentScheme = schemes.get("intr_1.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Intr 2")) {
					currentScheme =schemes.get("intr_2.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Intr 3")) {
					currentScheme = schemes.get("intr_3.png");
				}
//				} else if (listOfShemes.getSelectedItem().equals(
//						"      Operaciona jedinica") || listOfShemes.getSelectedItem().equals(
//						"Memorija")) {
//					currentScheme = Mem11.getGui();
//				} else if (listOfShemes.getSelectedItem().equals(
//						"      Upravljacka jedinica")) {
//					currentScheme = Mem12.getGui();
//				} else if (listOfShemes.getSelectedItem().equals(
//						"          Operacioni 1")) {
//					currentScheme = Oper1.getGui();
//				} else if (listOfShemes.getSelectedItem().equals(
//						"          Operacioni 2")) {
//					currentScheme = Oper2.getGui();
//				} else if (listOfShemes.getSelectedItem().equals(
//						"          Upravljacki 1")) {
//					currentScheme = Uprav2.getGui();
//				} else if (listOfShemes.getSelectedItem().equals(
//						"          Upravljacki 2")) {
//					currentScheme = Uprav1.getGui();
//				}
				add(currentScheme);
				repaint();
				validate();
			}
		});
		west.setLayout(new BorderLayout());
		west.add(listOfShemes, BorderLayout.CENTER);
		menu.setLayout(new GridLayout(4, 1));
		menu.add(memory);
		menu.add(registers);
		menu.add(reset);
		menu.add(resetnomem);
		west.add(menu, BorderLayout.SOUTH);
		add("West", west);
		;
		validate();
		setBounds(0, 0, currentScheme.getWidth() + listOfShemes.getWidth()
				+ asmtext.getWidth() + 320, currentScheme.getHeight() + 40);
		setVisible(true);

		// Ucitaj na pocetku default program
		//String asmcode = asmtext.getText();
		//asm.asembly(asmcode);

//		dialogRegs.setResizable(false);
//		dialogRegs.setTitle("CPU registri");
//		dialogRegs.setModal(true);
//		dialogRegs.addWindowListener(new WindowAdapter() {
//
//			public void windowClosing(WindowEvent arg0) {
//				dialogRegs.setVisible(false);
//				currentScheme.repaint();
//			}
//
//		});
//		cpuregs.setSadrzalacRegistara(dialogRegs);
//		dialogRegs.add(cpuregs);
//		dialogRegs.setSize(600, 600);
//		dialogRegs.setLocation(100, 100);
//		dialogRegs.setVisible(false);
//
//		dialogMem.setResizable(false);
//		dialogMem.setTitle("Pregled Memorije");
//		dialogMem.setModal(true);
//		dialogMem.addWindowListener(new WindowAdapter() {
//
//			public void windowClosing(WindowEvent arg0) {
//				dialogMem.setVisible(false);
//				currentScheme.repaint();
//			}
//
//		});
//		guimem.setSadrzalacMemorije(dialogMem);
//		dialogMem.add(guimem);
//		dialogMem.setSize(500, 300);
//		dialogMem.setLocation(100, 100);
//		dialogMem.setVisible(false);
	}

	public static void main(String[] args) {
		LogicalComponent.initialise();
		new Main();
	}
}
