package sim.main;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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

	private PrintStream log;
	private HashMap<String, LogicalComponent> components;
	private HashMap<String, GuiScheme> schemes;
	private Pin pc;
	private Pin cnt;
	private Pin memTime;
	private Pin start;
	private ArrayList<String> steps;
	private ArrayList<String> desc;
	private GuiSchemeRenderer schemeRenderer;
	private JScrollPane scrollPane;
	private JButton clk = new JButton("CLK+");
	private JButton ins = new JButton("INS+");
	private JButton prg = new JButton("PRG+");
	private JLabel clockLabel = new JLabel("clock = 0");
	private JLabel cntLabel = new JLabel("T = 0");
	private JLabel memTimeLabel = new JLabel("MEM time = 0");
	private JLabel pcLabel = new JLabel("PC = 0");
	private JLabel descLabel = new JLabel("! Čitanje instrukcije !", SwingConstants.CENTER);
	private JLabel stepLabel = new JLabel("<html>T00 brnotSTART, val00;", SwingConstants.CENTER);

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
		
		components = new Configurator("conf/schemes.conf", log).getComponents();
		schemes = new GuiConfigurator(components, "conf/gui.conf", log).getGuiSchemes();
		
		pc = components.get("fetch1.pc").getOut(0);
		cnt = components.get("uprav.cnt").getOut(0);
		memTime = components.get("mem_uprav.memacc").getOut(0);
		start = components.get("exec2.start").getOut(0);
		
		StepsLoader stepLoader = new StepsLoader("conf/steps.conf", log);
		steps = stepLoader.getSteps();
		desc = stepLoader.getDesc();
		
		schemeRenderer = new GuiSchemeRenderer(schemes.get("adr_1.png"));
		
		JPanel east = new JPanel();
		JPanel northeast = new JPanel();
		JPanel southeast = new JPanel();
		JPanel west = new JPanel();
		
		JButton reset = new JButton("RESET");
		JButton registers = new JButton("REGISTRI");
		JButton memory = new JButton("MEMORIJA");
		JPanel menu = new JPanel();
		JButton load = new JButton("Učitaj u memoriju");
		Menu menuItems = new Menu(schemes, schemeRenderer, "conf/menu.conf", log);

//		cpuregs.init();
//		guimem.init();
        
        scrollPane = new JScrollPane(schemeRenderer);
        scrollPane.setSize(700, 700);
		add("Center", scrollPane);
		
		Dimension d = new Dimension(160, 620);
		east.setMaximumSize(d);
		east.setMinimumSize(d);
		east.setPreferredSize(d);
		east.setSize(d);

		northeast.setLayout(new GridLayout(2, 1));
		JPanel northeastI=new JPanel();
		northeastI.setLayout(new BoxLayout(northeastI, BoxLayout.Y_AXIS));
		clockLabel.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(clockLabel);
		cntLabel.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(cntLabel);
		memTimeLabel.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(memTimeLabel);
		pcLabel.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(pcLabel);
		northeast.add(northeastI);

		clk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				executeCLK();
			}
		});
		clk.setAlignmentX(CENTER_ALIGNMENT);
		northeastI.add(clk);
		
		
		ins.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				executeINS();
			}
		});
		ins.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel child=new JPanel(new GridLayout(1,2));
		child.add(ins);
		
		prg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				executePRG();
			}
		});
		prg.setAlignmentX(CENTER_ALIGNMENT);
		child.add(prg);
		northeastI.add(child);
		
		JPanel northeastII=new JPanel();
		northeastII.setLayout(new BoxLayout(northeastII, BoxLayout.Y_AXIS));
		descLabel.setAlignmentX(CENTER_ALIGNMENT);
		northeastII.add(descLabel);
		stepLabel.setAlignmentX(CENTER_ALIGNMENT);
		northeastII.add(stepLabel);
		northeast.add(northeastII);

		load.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadMem();
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

			@Override
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		});
		reset.setAlignmentX(CENTER_ALIGNMENT);

		southeast.setLayout(new BoxLayout(southeast, BoxLayout.Y_AXIS));
		
		southeast.add(load);
		east.setLayout(new GridLayout(2, 1));
		east.add(northeast);
		east.add(southeast);
		add("East", east);

		west.setLayout(new BorderLayout());
		west.add("Center", menuItems);
		menu.setLayout(new GridLayout(4, 1));
		menu.add(memory);
		menu.add(registers);
		menu.add(reset);
		west.add("South", menu);
		add("West", west);
		validate();
		setBounds(0, 0, scrollPane.getWidth() + menuItems.getWidth() + 400, scrollPane.getHeight() + 40);

		LogicalComponent.initMemory = false;
		LogicalComponent.initialise();
		
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
            	log.close();
                dispose();
            }
        });
		
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

	private void setLabels() {
		clockLabel.setText("CPU clock = " + LogicalComponent.globalClock);
		int step = cnt.getIntVal();
		cntLabel.setText("Tcpu = "+ Integer.toHexString(step));
		pcLabel.setText("PC ="+pc.getIntVal());
		memTimeLabel.setText("Mem cnt = "+ Integer.toHexString(memTime.getIntVal()));
		descLabel.setText(desc.get(step));
		stepLabel.setText(steps.get(step));
	}
	
	private void checkEnd() {
		if(start.getBoolVal() == false) {
			clk.setEnabled(false);
			ins.setEnabled(false);
			prg.setEnabled(false);
		}
	}
	
	private void enableButtons() {
		clk.setEnabled(true);
		ins.setEnabled(true);
		prg.setEnabled(true);
	}
	
	private void reset() {
		LogicalComponent.initMemory = false;
		LogicalComponent.initialise();
		setLabels();
		JOptionPane.showMessageDialog(Main.this, "Simulacija resetovana", "Resetovanje simulacije", JOptionPane.INFORMATION_MESSAGE);
		enableButtons();
		schemeRenderer.repaint();
	}
	
	private void loadMem() {
        JFileChooser chooser = new JFileChooser("asm");
        int returnVal = chooser.showOpenDialog(Main.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            setTitle(chooser.getSelectedFile().getName());
			Assembler asm = new Assembler(chooser.getSelectedFile().getPath(), log);
			Object[] code = asm.getCode();
			int start = asm.getStartOfCode();
			MEM mem = ((MEM)components.get("mem_oper.mem"));
			for(int i = 0; i < mem.getSize(); i++) {
				if(i >= start && i < start + code.length) {
					mem.write(i, (Integer)code[i - start]);
				} else {
					mem.write(i, 0);
				}
			}
			REG pc = ((REG)components.get("fetch1.pc"));
			pc.initVal(start);
			LogicalComponent.initMemory = false;
			LogicalComponent.initialise();
			setLabels();
			enableButtons();
			schemeRenderer.repaint();
			JOptionPane.showMessageDialog(Main.this, "Program ucitan u memoriju", "Ucitavanje programa", JOptionPane.INFORMATION_MESSAGE);
        }
	}
	
	private void executeCLK() {
		LogicalComponent.CLK();
		checkEnd();
		setLabels();
		schemeRenderer.updateScheme();
	}
	
	private void executeINS() {
		LogicalComponent.CLK();
		schemeRenderer.repaint();
		checkEnd();
		LogicalComponent.CLK();
		schemeRenderer.repaint();
		checkEnd();
		while ((cnt.getIntVal() != 0) && (start.getBoolVal() == true)) {
			LogicalComponent.CLK();
			schemeRenderer.repaint();
		}
		checkEnd();
		setLabels();
	}
	
	private void executePRG() {
		while (start.getBoolVal() == true) {
			LogicalComponent.CLK();
			schemeRenderer.repaint();
		}
		setLabels();
		checkEnd();
	}
	
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		new Main();
		System.out.println("startup: "+(System.currentTimeMillis() - begin)+" ms");
	}
}
