package sim.main;

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
	private JButton clk = new JButton("CLK+");
	private JButton ins = new JButton("INS+");
	private JButton prg = new JButton("PRG+");
	private JLabel clockLabel = new JLabel("clock = 0");
	private JLabel cntLabel = new JLabel("T = 0");
	private JLabel memTimeLabel = new JLabel("MEM time = 0");
	private JLabel pcLabel = new JLabel("PC = 0");
	private JLabel descLabel = new JLabel("! Čitanje instrukcije !", SwingConstants.CENTER);
	private JLabel stepLabel = new JLabel("<html>brnotSTART, val00;", SwingConstants.CENTER);

//	private Register cpuregs;
//	private JDialog dialogRegs = new JDialog();
	private Memory guimem;
	private JDialog dialogMem = new JDialog();
	
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
		
		guimem = new Memory((MEM) components.get("mem_oper.mem"));
//		cpuregs = new Register(components);
		
		LogicalComponent.initMemory = false;
		LogicalComponent.initialise();
		
		StepsLoader stepLoader = new StepsLoader("conf/steps.conf", log);
		steps = stepLoader.getSteps();
		desc = stepLoader.getDesc();
		
		schemeRenderer = new GuiSchemeRenderer(schemes.get("adr_1.png"));
		Menu menuItems = new Menu(schemes, schemeRenderer, "conf/menu.conf", log);
		JScrollPane scrollPane = new JScrollPane(schemeRenderer);
		Dimension scrollSize = new Dimension(800, 600);
        scrollPane.setSize(scrollSize);
        scrollPane.setPreferredSize(scrollSize);
        
        clockLabel.setAlignmentX(CENTER_ALIGNMENT);
		descLabel.setAlignmentX(CENTER_ALIGNMENT);
		stepLabel.setAlignmentX(CENTER_ALIGNMENT);
		cntLabel.setAlignmentX(CENTER_ALIGNMENT);
		memTimeLabel.setAlignmentX(CENTER_ALIGNMENT);
		pcLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		clk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				executeCLK();
			}
		});
		clk.setAlignmentX(CENTER_ALIGNMENT);
		
		ins.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				executeINS();
			}
		});
		ins.setAlignmentX(CENTER_ALIGNMENT);
		
		prg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				executePRG();
			}
		});
		prg.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton load = new JButton("Učitaj program");
		load.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadMem();
			}
		});
		load.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		});
		reset.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton memory = new JButton("Memorija");
		memory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialogMem.setVisible(true);
				schemeRenderer.repaint();
			}
		});
		memory.setAlignmentX(CENTER_ALIGNMENT);
		
//		JButton registers = new JButton("Registri");
//		registers.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				dialogRegs.setVisible(true);
//				schemeRenderer.repaint();
//			}
//		});
//		registers.setAlignmentX(CENTER_ALIGNMENT);

		add("Center", scrollPane);
		
		JPanel west = new JPanel();
		west.add(menuItems);
		add("West", west);
		
		JPanel east = new JPanel();
		Dimension size = new Dimension(200, 700);
		east.setSize(size);
		east.setPreferredSize(size);
		east.setMinimumSize(size);
		east.setLayout(new GridLayout(5, 1));
		
		
		JPanel east1 = new JPanel();
		east1.setLayout(new BoxLayout(east1, BoxLayout.Y_AXIS));
		east1.add(Box.createVerticalGlue());
		east1.add(clockLabel);
		east1.add(Box.createVerticalGlue());
		east1.add(cntLabel);
		east1.add(Box.createVerticalGlue());
		east1.add(memTimeLabel);
		east1.add(Box.createVerticalGlue());
		east1.add(pcLabel);
		east1.add(Box.createVerticalGlue());
		east1.add(descLabel);
		east1.add(Box.createVerticalGlue());
		east1.add(stepLabel);
		east1.add(Box.createVerticalGlue());
		east.add(east1);
		
		JPanel east2 = new JPanel();
		east2.setLayout(new BoxLayout(east2, BoxLayout.Y_AXIS));
		east2.add(Box.createVerticalGlue());
		east2.add(clk);
		east2.add(Box.createVerticalGlue());
		east2.add(ins);
		east2.add(Box.createVerticalGlue());
		east2.add(prg);
		east2.add(Box.createVerticalGlue());
		east.add(east2);
		
		east.add(new JPanel());
		
		JPanel east3 = new JPanel();
		east3.setLayout(new BoxLayout(east3, BoxLayout.Y_AXIS));
		east3.add(Box.createVerticalGlue());
		east3.add(load);
		east3.add(Box.createVerticalGlue());
		east3.add(reset);
		east3.add(Box.createVerticalGlue());
		east3.add(memory);
		east3.add(Box.createVerticalGlue());
//		east3.add(registers);
		east3.add(Box.createVerticalGlue());
		
		east.add(east3);
		
		add("East", east);

		validate();
		size = new Dimension(scrollPane.getWidth() + menuItems.getWidth() + east.getWidth(), scrollPane.getHeight());
		setSize(size);
		setPreferredSize(size);
		
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
            	log.close();
            	dialogMem.dispose();
                dispose();
            }
        });
		
		setVisible(true);

//		dialogRegs.setResizable(false);
//		dialogRegs.setTitle("CPU registri");
//		dialogRegs.setModal(true);
//		dialogRegs.addWindowListener(new WindowAdapter() {
//
//			@Override
//			public void windowClosing(WindowEvent arg0) {
//				dialogRegs.setVisible(false);
//				schemeRenderer.repaint();
//			}
//
//		});
//		cpuregs.setSadrzalacRegistara(dialogRegs);
//		dialogRegs.add(cpuregs);
//		dialogRegs.setSize(600, 600);
//		dialogRegs.setLocation(100, 100);
//		dialogRegs.setVisible(false);

		dialogMem.setResizable(false);
		dialogMem.setTitle("Pregled Memorije");
		dialogMem.setModal(true);
		dialogMem.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				dialogMem.setVisible(false);
				schemeRenderer.repaint();
			}

		});
		guimem.setSadrzalacMemorije(dialogMem);
		dialogMem.add(guimem);
		dialogMem.setSize(500, 300);
		dialogMem.setLocation(100, 100);
		dialogMem.setVisible(false);
	}

	private void setLabels() {
		clockLabel.setText("clock = " + LogicalComponent.globalClock);
		int step = cnt.getIntVal();
		cntLabel.setText("T = "+ Integer.toHexString(step));
		pcLabel.setText("PC ="+pc.getIntVal());
		memTimeLabel.setText("Mem time = "+ Integer.toHexString(memTime.getIntVal()));
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
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		long begin = System.currentTimeMillis();
		new Main();
		System.out.println("startup: "+(System.currentTimeMillis() - begin)+" ms");
	}
}
