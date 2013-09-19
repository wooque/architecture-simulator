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
	private JLabel clockLabel = new JLabel("CLK = 0", SwingConstants.CENTER);
	private JLabel cntLabel = new JLabel("T = 0", SwingConstants.CENTER);
	private JLabel memTimeLabel = new JLabel("MEM time = 0", SwingConstants.CENTER);
	private JLabel pcLabel = new JLabel("PC = 0", SwingConstants.CENTER);
	private JLabel descLabel = new JLabel("! Čitanje instrukcije !", SwingConstants.CENTER);
	private JLabel stepLabel = new JLabel("<html>brnotSTART, val00;", SwingConstants.CENTER);
	private RegistersFrame regsWindow;
	private MemoryFrame memWindow;
	private int codeStart, codeSize;
	
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
		
		memWindow = new MemoryFrame((MEM) components.get("mem_oper.mem"));
		regsWindow = new RegistersFrame(components);
		
		LogicalComponent.initMemory = false;
		LogicalComponent.initialise();
		
		StepsLoader stepLoader = new StepsLoader("conf/steps.conf", log);
		steps = stepLoader.getSteps();
		desc = stepLoader.getDesc();
		
		schemeRenderer = new GuiSchemeRenderer(schemes.get("adr_1.gif"));
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
				memWindow.updateMemoryView();
				memWindow.setVisible(true);
			}
		});
		memory.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton registers = new JButton("Registri");
		registers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				regsWindow.updateRegistersView();
				regsWindow.setVisible(true);
			}
		});
		registers.setAlignmentX(CENTER_ALIGNMENT);

		add("Center", scrollPane);
		
		JPanel west = new JPanel();
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		
		JPanel west1 = new JPanel();
		west1.setLayout(new BoxLayout(west1, BoxLayout.Y_AXIS));
		west1.setBorder(BorderFactory.createTitledBorder("Navigacija"));
		west1.add(menuItems);
		west.add(west1);
		
		west.add(Box.createVerticalGlue());
		
		JPanel west2 = new JPanel();
		west2.setLayout(new GridLayout(2, 1, 5, 5));
		west2.setBorder(BorderFactory.createTitledBorder("Program"));
		west2.add(load);
		west2.add(reset);
		west.add(west2);
		
		add("West", west);
		
		JPanel east = new JPanel();
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.setPreferredSize(new Dimension(175, 700));
		
		JPanel east1 = new JPanel();
		east1.setLayout(new GridLayout(4, 1));
		east1.setBorder(BorderFactory.createTitledBorder("Status"));
		east1.add(clockLabel);
		east1.add(cntLabel);
		east1.add(pcLabel);
		east1.add(memTimeLabel);
		east.add(east1);
		
		JPanel east2 = new JPanel();
		
		east2.setLayout(new GridLayout(2, 1));
		east2.setPreferredSize(new Dimension(175, 100));
		east2.setBorder(BorderFactory.createTitledBorder("Mikrokod"));
		east2.add(descLabel);
		east2.add(stepLabel);
		east.add(east2);
		
		JPanel east3 = new JPanel();
		east3.setLayout(new GridLayout(3, 1, 5, 5));
		east3.setBorder(BorderFactory.createTitledBorder("Kontrole"));
		east3.add(clk);
		east3.add(ins);
		east3.add(prg);
		east.add(east3);
		
		east.add(Box.createVerticalGlue());
		
		JPanel east4 = new JPanel();
		east4.setLayout(new GridLayout(2, 1, 5, 5));
		east4.setBorder(BorderFactory.createTitledBorder("Pregled"));
		east4.add(memory);
		east4.add(registers);
		east.add(east4);
		
		add("East", east);

		validate();
		setSize(new Dimension(scrollPane.getWidth() + west.getWidth() + east.getWidth() + 400, scrollPane.getHeight() + 100));
		
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
            	log.close();
            	memWindow.dispose();
            	regsWindow.dispose();
                dispose();
            }
        });
		
		setVisible(true);
	}

	private void setLabels() {
		clockLabel.setText("CLK = " + LogicalComponent.globalClock);
		int step = cnt.getIntVal();
		cntLabel.setText("T = "+ Integer.toHexString(step));
		pcLabel.setText("PC ="+pc.getIntVal());
		memTimeLabel.setText("MEM time = "+ Integer.toHexString(memTime.getIntVal()));
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
		MEM mem = ((MEM)components.get("mem_oper.mem"));
		for(int i = 0; i < mem.getSize(); i++) {
			if(i < codeStart || i >= codeStart + codeSize) {
				mem.write(i, 0);
			}
		}
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
			codeStart = asm.getStartOfCode();
			codeSize = code.length;
			MEM mem = ((MEM)components.get("mem_oper.mem"));
			for(int i = 0; i < mem.getSize(); i++) {
				if(i >= codeStart && i < codeStart + codeSize) {
					mem.write(i, (Integer)code[i - codeStart]);
				} else {
					mem.write(i, 0);
				}
			}
			REG pc = ((REG)components.get("fetch1.pc"));
			pc.initVal(codeStart);
			LogicalComponent.initMemory = false;
			LogicalComponent.initialise();
			setLabels();
			enableButtons();
			schemeRenderer.repaint();
			JOptionPane.showMessageDialog(Main.this, "Program učitan u memoriju", "Učitavanje programa", JOptionPane.INFORMATION_MESSAGE);
        }
	}
	
	private void updateView() {
		schemeRenderer.updateScheme();
		if(memWindow.isVisible()) {
			memWindow.updateMemoryView();
		}
		if(regsWindow.isVisible()) {
			regsWindow.updateRegistersView();
		}
	}
	
	private void executeCLK() {
		LogicalComponent.CLK();
		checkEnd();
		setLabels();
		updateView();
	}
	
	private void executeINS() {
		LogicalComponent.CLK();
		checkEnd();
		LogicalComponent.CLK();
		checkEnd();
		while ((cnt.getIntVal() != 0) && (start.getBoolVal() == true)) {
			LogicalComponent.CLK();
		}
		checkEnd();
		setLabels();
		updateView();
	}
	
	private void executePRG() {
		while (start.getBoolVal() == true) {
			LogicalComponent.CLK();
		}
		setLabels();
		checkEnd();
		updateView();
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
