package sim.main;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import sim.Configurator;
import sim.assembler.Assembler;
import sim.components.*;
import sim.gui.*;

@SuppressWarnings("serial")
public class Main extends JFrame {

	GuiScheme currentScheme;
	PrintStream log;
	JScrollPane scrollPane;
	ArrayList<String> steps;
	ArrayList<String> desc;

//	CPURegister cpuregs = new CPURegister();
//	public static JDialog dialogRegs = new JDialog();
//
//	Memory guimem = new Memory();
//	public static JDialog dialogMem = new JDialog();
	
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
		
		StepsLoader stepLoader = new StepsLoader("conf/steps.conf", log);
		steps = stepLoader.getSteps();
		desc = stepLoader.getDesc();
		
		currentScheme = schemes.get("adr_1.png");
		JPanel east = new JPanel();
		JPanel northeast = new JPanel();
		JPanel southeast = new JPanel();
		JPanel west = new JPanel();

		final JButton CLK = new JButton("CLK+");
		final JButton INS = new JButton("INS+");
		final JButton PRG = new JButton("PRG+");
		

		final JLabel CPUclock = new JLabel("CPU clock = 0");
		final JLabel Tcpu = new JLabel("Tcpu = 0");
		final JLabel memCnt = new JLabel("Mem = 0");
		final JLabel PC = new JLabel("PC = 0");
		JLabel asmtxt = new JLabel("Asemblerski kod:");

		JButton reset = new JButton("RESET");
		JButton registers = new JButton("REGISTRI");
		JButton memory = new JButton("MEMORIJA");
		JButton resetnomem = new JButton("RESET BEZ MEM");
		JPanel menu = new JPanel();

		final JLabel descLabel = new JLabel("! Čitanje instrukcije !");
		final JLabel stepLabel = new JLabel("<html>T00 brnotSTART, val00;", SwingConstants.CENTER);
		
		JButton load = new JButton("Ucitaj u memoriju");

		JTextArea asmtext = new JTextArea();

		final List listOfShemes = new List();

//		cpuregs.init();
//		guimem.init();

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
            	log.close();
                dispose();
            }
        });
        scrollPane = new JScrollPane(currentScheme);
		add("Center", scrollPane);
		
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
		Tcpu.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(Tcpu);
		memCnt.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(memCnt);
		PC.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(PC);
		northeast.add(northeastI);

		CLK.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				LogicalComponent.CLK();

				CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);

				String step = Integer.toHexString(cnt.getIntVal());

				Tcpu.setText("Tcpu = " + step);
				
				String stepmem = Integer.toHexString(mem_cnt.getIntVal());

				memCnt.setText("Mem = " + stepmem);
				
				PC.setText("PC = "+pc.getIntVal());

				currentScheme.repaint();
				if(start.getBoolVal() == false){
					CLK.setEnabled(false);
					INS.setEnabled(false);
					PRG.setEnabled(false);
				}
				int stepNum = cnt.getIntVal();
				descLabel.setText(desc.get(stepNum));
				stepLabel.setText(steps.get(stepNum));
			}
		});
		CLK.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(CLK);
		
		
		INS.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				LogicalComponent.CLK();
				CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);
				Tcpu.setText("Tcpu = "+ Integer.toHexString(cnt.getIntVal()));
				memCnt.setText("Mem = "+ Integer.toHexString(mem_cnt.getIntVal()));
				PC.setText("PC = "+pc.getIntVal());
				currentScheme.repaint();
				if(start.getBoolVal() == false){
					CLK.setEnabled(false);
					INS.setEnabled(false);
					PRG.setEnabled(false);
				}
				LogicalComponent.CLK();
				CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);
				Tcpu.setText("Tcpu = "+ Integer.toHexString(cnt.getIntVal()));
				memCnt.setText("Mem = "+ Integer.toHexString(mem_cnt.getIntVal()));
				PC.setText("PC = "+pc.getIntVal());
				currentScheme.repaint();
				if(start.getBoolVal() == false){
					CLK.setEnabled(false);
					INS.setEnabled(false);
					PRG.setEnabled(false);
				}
				while ((cnt.getIntVal() != 0)&&(start.getBoolVal() == true)){
					LogicalComponent.CLK();
					CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);
					Tcpu.setText("Tcpu = "+ Integer.toHexString(cnt.getIntVal()));
					memCnt.setText("Mem = "+ Integer.toHexString(mem_cnt.getIntVal()));
					PC.setText("PC = "+pc.getIntVal());
					currentScheme.repaint();
				}
				if(start.getBoolVal() == false){
					CLK.setEnabled(false);
					INS.setEnabled(false);
					PRG.setEnabled(false);
				}
				int step = cnt.getIntVal();
				descLabel.setText(desc.get(step));
				stepLabel.setText(steps.get(step));
			}
		});
		INS.setAlignmentX(CENTER_ALIGNMENT);
		JPanel child=new JPanel(new GridLayout(1,2));
		child.add(INS);
		
		PRG.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				while (start.getBoolVal() == true) {
					LogicalComponent.CLK();
					CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);
					Tcpu.setText("Tcpu = "+ Integer.toHexString(cnt.getIntVal()));
					memCnt.setText("Mem = "+ Integer.toHexString(mem_cnt.getIntVal()));
					PC.setText("PC = "+pc.getIntVal());
					currentScheme.repaint();
				}
				CLK.setEnabled(false);
				INS.setEnabled(false);
				PRG.setEnabled(false);
			}
		});
		PRG.setAlignmentX(CENTER_ALIGNMENT);
		child.add(PRG);
		northeastI.add(child);
		
		JPanel northeastII=new JPanel();
		northeastII.setLayout(new BoxLayout(northeastII, BoxLayout.Y_AXIS));
		descLabel.setAlignmentX(CENTER_ALIGNMENT);
		northeastII.add(descLabel);
		stepLabel.setAlignmentX(CENTER_ALIGNMENT);
		northeastII.add(stepLabel);
		northeast.add(northeastII);
		
		asmtext.setText("ld #4\nst r0\nld #5\nst r1\nadd r0\nhalt");
		asmtext.setAlignmentX(CENTER_ALIGNMENT);

		load.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Assembler asm = new Assembler("asm/test.asm", log);
				Object[] code = asm.getCode();
				int start = asm.getStartOfCode();
				MEM mem = ((MEM)components.get("mem_oper.mem"));
				for(int i = 0; i < code.length; i++) {
					mem.write(start + i, (Integer)code[i]);
				}
				REG pc = ((REG)components.get("fetch1.pc"));
				pc.initVal(start);
				JOptionPane.showMessageDialog(Main.this, "Program ucitan u memoriju", "Ucitavanje programa", JOptionPane.PLAIN_MESSAGE);
			}
		});
		load.setAlignmentX(CENTER_ALIGNMENT);

//		memory.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
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
//				dialogRegs.setVisible(true);
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
				
				CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);
				Tcpu.setText("Tcpu = "+ Integer.toHexString(cnt.getIntVal()));
				memCnt.setText("Mem = "+ Integer.toHexString(mem_cnt.getIntVal()));
				PC.setText("PC ="+pc.getIntVal());
				int step = cnt.getIntVal();
				descLabel.setText(desc.get(step));
				stepLabel.setText(steps.get(step));

				JOptionPane.showMessageDialog(Main.this, "Simulacija resetovana","Resetovanje simulacije...", JOptionPane.PLAIN_MESSAGE);
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
				
				CPUclock.setText("CPU clock = " + LogicalComponent.globalClock);
				Tcpu.setText("Tcpu = "+ Integer.toHexString(cnt.getIntVal()));
				memCnt.setText("Mem = "+ Integer.toHexString(mem_cnt.getIntVal()));
				PC.setText("PC ="+pc.getIntVal());
				int step = cnt.getIntVal();
				descLabel.setText(desc.get(step));
				stepLabel.setText(steps.get(step));
				
				JOptionPane.showMessageDialog(Main.this, "Simulator resetovan, memorija nepromenjena.","Resetovanje simulacije...", JOptionPane.PLAIN_MESSAGE);
				CLK.setEnabled(true);
				INS.setEnabled(true);
				PRG.setEnabled(true);
				currentScheme.repaint();

			}
		});
		resetnomem.setAlignmentX(CENTER_ALIGNMENT);

		southeast.setLayout(new BoxLayout(southeast, BoxLayout.Y_AXIS));


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

		listOfShemes.add("Procesor");
		listOfShemes.add("     Operaciona");
		listOfShemes.add("          Addr");
		listOfShemes.add("          Bus");
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
//		listOfShemes.add("          Operacioni 1");
//		listOfShemes.add("          Operacioni 2");
//		listOfShemes.add("          Upravljacki 1");
//		listOfShemes.add("          Upravljacki 2");
//		listOfShemes.add("Memorija");
//		listOfShemes.add("      Operaciona jedinica");
//		listOfShemes.add("      Upravljacka jedinica");

		listOfShemes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (listOfShemes.getSelectedItem().equals("          Addr")
						|| listOfShemes.getSelectedItem().equals("Procesor")
						|| listOfShemes.getSelectedItem().equals("     Operaciona")) {
					currentScheme = schemes.get("adr_1.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Bus")) {
					currentScheme = schemes.get("bus_1.png");
				} else if (listOfShemes.getSelectedItem().equals(
						"          Brojac koraka") || listOfShemes.getSelectedItem().equals(
						"     Upravljacka")) {
					currentScheme = schemes.get("upr_jed_hard.png");
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
				remove(scrollPane);
				add("Center", new JScrollPane(currentScheme));
				validate();
			}
		});
		west.setLayout(new BorderLayout());
		west.add("Center", listOfShemes);
		menu.setLayout(new GridLayout(4, 1));
		menu.add(memory);
		menu.add(registers);
		menu.add(reset);
		menu.add(resetnomem);
		west.add("South", menu);
		add("West", west);
		validate();
		setBounds(0, 0, currentScheme.getWidth() + listOfShemes.getWidth() + asmtext.getWidth() + 320, currentScheme.getHeight() + 40);
		

		LogicalComponent.initMemory = false;
		LogicalComponent.initialise();
		
		setVisible(true);

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
		long begin = System.currentTimeMillis();
		new Main();
		System.out.println("startup: "+(System.currentTimeMillis() - begin)+" ms");
	}
}
