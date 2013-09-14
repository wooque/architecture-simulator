package sim.gui.util;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.event.*;

import sim.Configurator;
import sim.components.LogicalComponent;
import sim.components.Pin;
import sim.gui.*;

@SuppressWarnings("serial")
public class DrawSignals extends JFrame {

    private GuiSchemeRenderer guiRenderer;
    private HashMap<String, GuiScheme> allSchemes;
    private LinkedHashMap<String, LogicalComponent> components;
    private GuiScheme guiScheme;
    private GuiLine guiLine;
    private ZoomPanel zoomPanel;
    private JList<String> listOfLines;
    private DefaultListModel<String> lineModel;
    private JList<String> listOfLabels;
    private DefaultListModel<String> labelModel;
    private String selectedLine;
    private String selectedLabel;
    private Point last;
    private JLabel confFilename;

    private class SignalMouseAdapter extends MouseAdapter{
    	
        @Override
        public void mouseDragged(MouseEvent e) {
            moveMouse(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            moveMouse(e);
        }

        private void moveMouse(MouseEvent e) {
        	Point disp = guiRenderer.getDisplacement();
            zoomPanel.setZoomX(e.getX() - disp.x);
            zoomPanel.setZoomY(e.getY() - disp.y);
            zoomPanel.repaint();
            
            if(guiLine != null) {
	            if (last != null) {
	                guiLine.removePoint(last); 
	            }
	            Point curr = new Point(e.getX() - disp.x, e.getY() - disp.y);
	            guiLine.addPoint(curr);
	            last = curr;
	            guiRenderer.repaint();
            }
        }
    	
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (e.getButton()) {
                case MouseEvent.BUTTON1:
                    leftClick(e);
                    break;
                case MouseEvent.BUTTON3:
                    rightClick(e);
                    break;
            }
        }

        private void leftClick(MouseEvent e) {
        	Point disp = guiRenderer.getDisplacement();
            Point curr = new Point(e.getX() - disp.x, e.getY() - disp.y);
            
        	if(guiLine == null) {
            	guiLine = new GuiLine();
            	guiLine.setPin(Pin.TRUE);
            	guiScheme.addLine(guiLine);
            } else {
            	last = curr;
            }
        	guiLine.addPoint(curr);
        }

        private void rightClick(MouseEvent e) {
        	if(last != null) {
	            guiLine.removePoint(last);
	            last = null;
	            if (guiLine.size() < 2) {
	            	guiScheme.removeLine(guiLine);
	            	guiLine = null;
	            } else {
	                String s = (String) JOptionPane.showInputDialog(DrawSignals.this, "Signal Name:", "New signal", JOptionPane.PLAIN_MESSAGE, null, null, null);
	                if (s != null) {
	                	if(components != null && !components.containsKey(s)) {
	                		JOptionPane.showMessageDialog(DrawSignals.this, "Signal does not exist", "Signal does not exist", JOptionPane.ERROR_MESSAGE);
	                	} else {
			                guiLine.setName(s);
			                if(!lineModel.contains(s)) {
			                	lineModel.addElement(s);
			                }
			                guiLine.setPin(Pin.FALSE);
			                guiLine = null;
	                	}
	                }
	            }
        	} else {
        		String s = (String) JOptionPane.showInputDialog(DrawSignals.this, "Signal Name:", "New label", JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (s != null) {
                	if(components != null && !components.containsKey(s)) {
                		JOptionPane.showMessageDialog(DrawSignals.this, "Signal does not exist", "Signal does not exist", JOptionPane.ERROR_MESSAGE);
                	} else {
	                	Point disp = guiRenderer.getDisplacement();
	                	GuiLabel label = new GuiLabel(e.getX() - disp.x, e.getY() - disp.y);
		                label.setName(s);
		                label.setPin(Pin.FALSE);
		                if(!labelModel.contains(s)) {
		                	labelModel.addElement(s);
		                }
		                guiScheme.addLabel(label);
	                }
                }
        	}
            guiRenderer.repaint();
        }
    }

    private DrawSignals() {
        super("Draw Signals");

        guiRenderer = new GuiSchemeRenderer(null);
        SignalMouseAdapter signalMouseAdapter = new SignalMouseAdapter();
        guiRenderer.addMouseMotionListener(signalMouseAdapter);
        guiRenderer.addMouseListener(signalMouseAdapter);
        
        JPanel east = new JPanel();
        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));

        JPanel northeast = new JPanel();
        zoomPanel = new ZoomPanel(null, 10, 10, 10);
        northeast.add(zoomPanel);
        east.add(northeast);

        JPanel southeast = new JPanel();
        southeast.setLayout(new BoxLayout(southeast, BoxLayout.Y_AXIS));
        east.add(southeast);
        
        southeast.add(Box.createVerticalGlue());
        JPanel loadPanel = new JPanel();
        
        JButton loadImage = new JButton("Image...");
        loadImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadImage();
            }
        });
        loadImage.setAlignmentX(CENTER_ALIGNMENT);
        loadPanel.add(loadImage);
        
        JButton loadConf = new JButton("Conf...");
        loadConf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadConf();
            }
        });
        loadConf.setAlignmentX(CENTER_ALIGNMENT);
        loadPanel.add(loadConf);
        
        southeast.add(loadPanel);

        southeast.add(Box.createVerticalGlue());
        listOfLines = new JList<String>();
        lineModel = new DefaultListModel<String>();
        listOfLines.setModel(lineModel);
        listOfLines.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				highlightLine(e);
			}
		});
        listOfLines.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfLines.setLayoutOrientation(JList.VERTICAL);
        JScrollPane linesScrollPane = new JScrollPane(listOfLines);
        linesScrollPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        southeast.add(linesScrollPane);

        southeast.add(Box.createVerticalGlue());
        JPanel removeSignalPanel = new JPanel();
        
        JButton removeSelectedSignalButton = new JButton("Clear selected");
        removeSelectedSignalButton.setAlignmentX(CENTER_ALIGNMENT);
        removeSelectedSignalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedSignal();
            }
        });
        removeSignalPanel.add(removeSelectedSignalButton);
        
        JButton removeAllSignalsButton = new JButton("Clear all lines");
        removeAllSignalsButton.setAlignmentX(CENTER_ALIGNMENT);
        removeAllSignalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAllSignals();
            }
        });
        removeSignalPanel.add(removeAllSignalsButton);
        
        southeast.add(removeSignalPanel);
        
        southeast.add(Box.createVerticalGlue());
        listOfLabels = new JList<String>();
        labelModel = new DefaultListModel<String>();
        listOfLabels.setModel(labelModel);
        listOfLabels.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				highlightLabel(e);
			}
		});
        listOfLabels.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfLabels.setLayoutOrientation(JList.VERTICAL);
        JScrollPane labelsScrollPane = new JScrollPane(listOfLabels);
        labelsScrollPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        southeast.add(labelsScrollPane);
        
        southeast.add(Box.createVerticalGlue());
        JPanel removeLabelPanel = new JPanel();
        
        JButton removeSelectedLabelButton = new JButton("Clear selected");
        removeSelectedLabelButton.setAlignmentX(CENTER_ALIGNMENT);
        removeSelectedLabelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedLabel();
            }
        });
        removeLabelPanel.add(removeSelectedLabelButton);
        
        JButton removeAlllabelssButton = new JButton("Clear all labels");
        removeAlllabelssButton.setAlignmentX(CENTER_ALIGNMENT);
        removeAlllabelssButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAllLabels();
            }
        });
        removeLabelPanel.add(removeAlllabelssButton);
        
        southeast.add(removeLabelPanel);
        
        southeast.add(Box.createVerticalGlue());
        confFilename = new JLabel();
        confFilename.setAlignmentX(CENTER_ALIGNMENT);
        southeast.add(confFilename);
        
        southeast.add(Box.createVerticalGlue());
        JButton generateCodeButton = new JButton("Save conf");
        generateCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveConf();
            }
        });
        generateCodeButton.setAlignmentX(CENTER_ALIGNMENT);
        southeast.add(generateCodeButton);
        
        southeast.add(Box.createVerticalGlue());
        
        JScrollPane scrollPane = new JScrollPane(guiRenderer);
        scrollPane.setSize(800, 600);
        add("Center", scrollPane);
        add("East", east);
        
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        setBounds(0, 0, scrollPane.getWidth() + zoomPanel.getWidth() + 20, scrollPane.getHeight() + 50);
        validate();
        
        setVisible(true);
    }

	private void saveConf() {
    	if(!confFilename.getText().isEmpty()) {
			try {
				PrintWriter confOut = new PrintWriter(new FileWriter(confFilename.getText()), true);
				for(Map.Entry<String, GuiScheme> entry: allSchemes.entrySet()) {
					String schemeName = entry.getKey();
					GuiScheme scheme = entry.getValue();
					
			        confOut.println(schemeName);
			        confOut.println();
			        
			        TreeMap<String, ArrayList<GuiLine>> linesToCommit = new TreeMap<String, ArrayList<GuiLine>>(); 
			        TreeMap<String, ArrayList<GuiLabel>> labelsToCommit = new TreeMap<String, ArrayList<GuiLabel>>();
			        
			        for(GuiLine gl: scheme.getLines()) {
			        	if(!linesToCommit.containsKey(gl.getName())) {
			        		linesToCommit.put(gl.getName(), new ArrayList<GuiLine>());
			        	}
			        	linesToCommit.get(gl.getName()).add(gl);
			        }
			        for(GuiLabel gl: scheme.getLabels()) {
			        	if(!labelsToCommit.containsKey(gl.getName())) {
			        		labelsToCommit.put(gl.getName(), new ArrayList<GuiLabel>());
			        	}
			        	labelsToCommit.get(gl.getName()).add(gl);
			        }
			        
			        for (Map.Entry<String, ArrayList<GuiLine>> lineEntry : linesToCommit.entrySet()) {
			        	String lineName = lineEntry.getKey();
			        	ArrayList<GuiLine> lineSections = lineEntry.getValue();
			        	
			        	confOut.printf("%-19s", lineName);
			        	boolean first = true;
			        	for(GuiLine gl: lineSections) {
			        		if(!first) {
			    				confOut.print("                   ");
			    			}
			        		for (Point point : gl.getPoints()) {
			        			confOut.print(" ("+point.x+","+point.y+")");
			        		}
			        		confOut.println();
			        		first = false;
			        	}
			        	if(labelsToCommit.containsKey(lineName)) {
			        		ArrayList<GuiLabel> labels = labelsToCommit.get(lineName);
			        		for(GuiLabel label: labels) {
			        			confOut.println("                    label("+label.getX()+","+label.getY()+")");
			        		}
			        	}
			        }
			        confOut.println();
				}
		        confOut.close();
		        JOptionPane.showMessageDialog(DrawSignals.this, "Configuration saved", "Configuration saved", JOptionPane.INFORMATION_MESSAGE);
			} catch (FileNotFoundException e) {
				System.out.println("Conf file not found!");
			} catch (IOException e) {
				System.out.println("Conf file corrupted!");
			}
    	}
    }
    
    private void loadConf() {
    	JFileChooser chooser = new JFileChooser("conf");
		int retVal = chooser.showOpenDialog(DrawSignals.this);
		if(retVal == JFileChooser.APPROVE_OPTION) {
			String filename = chooser.getSelectedFile().getPath();
			confFilename.setText(filename);
			// TODO schemes.conf is hardcoded, put schems.conf filename in gui.conf for example
			components = new Configurator("conf/schemes.conf", null).getComponents();
			allSchemes = new GuiConfigurator(components, filename, null).getGuiSchemes();
			GuiScheme oldScheme = guiScheme;
			guiScheme = allSchemes.get(getTitle());
			if (guiScheme == null) {
				guiScheme = oldScheme;
				if(!getTitle().equals("Draw Signals")) {
					allSchemes.put(getTitle(), guiScheme);
				}
			} else {
	            lineModel.clear();
	            selectedLine = null;
	            labelModel.clear();
	            selectedLabel = null;
	            
	            for(GuiLine gl: guiScheme.getLines()) {
            		if(!lineModel.contains(gl.getName())) {
            			lineModel.addElement(gl.getName());
            		}
	            }
            	for(GuiLabel gl: guiScheme.getLabels()) {
            		if(!labelModel.contains(gl.getName())) {
            			labelModel.addElement(gl.getName());
            		}
            	}
	            guiRenderer.switchScheme(guiScheme);
	            zoomPanel.setImage(guiScheme.getImage());
	            validate();
			}
		}
    }

    private void loadImage() {
        JFileChooser chooser = new JFileChooser("images");
        int returnVal = chooser.showOpenDialog(DrawSignals.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	String imagePath = chooser.getSelectedFile().getPath();
        	String imageName = chooser.getSelectedFile().getName();
            setTitle(imageName);
            
            lineModel.clear();
            selectedLine = null;
            labelModel.clear();
            selectedLabel = null;
            guiScheme = null;
            
            if(allSchemes != null) {
            	guiScheme = allSchemes.get(imageName);
            }
            if(guiScheme == null) {
            	guiScheme = new GuiScheme(imagePath);
            	if(allSchemes != null) {
            		allSchemes.put(imageName, guiScheme);
            	}
            } else {
            	for(GuiLine gl: guiScheme.getLines()) {
            		if(!lineModel.contains(gl.getName())) {
            			lineModel.addElement(gl.getName());
            		}
	            }
            	for(GuiLabel gl: guiScheme.getLabels()) {
            		if(!labelModel.contains(gl.getName())) {
            			labelModel.addElement(gl.getName());
            		}
            	}
            }
            guiRenderer.switchScheme(guiScheme);
            zoomPanel.setImage(guiScheme.getImage());
            validate();
        }
    }

    private void removeSelectedSignal() {
    	if(selectedLine != null) {
			ArrayList<GuiLine> toRemove = new ArrayList<GuiLine>();
			for(GuiLine gl: guiScheme.getLines()) {
				if(gl.getName().equals(selectedLine)) {
					toRemove.add(gl);
				}
			}
			for(GuiLine gl: toRemove) {
				guiScheme.removeLine(gl);
			}

			lineModel.removeElement(selectedLine);
			selectedLine = null;
			guiRenderer.repaint();
		}
    }
    
    private void removeAllSignals() {
        guiScheme.clearLines();
        lineModel.clear();
        selectedLine = null;
        guiRenderer.repaint();
    }
    
    private void setSelectedLinePin(Pin in) {
		if(selectedLine != null) {
			for(GuiLine gl: guiScheme.getLines()) {
				if(gl.getName().equals(selectedLine)) {
					gl.setPin(in);
				}
			}
			guiRenderer.updateScheme();
		}
    }
    
    private void highlightLine(ListSelectionEvent e) {
    	setSelectedLinePin(Pin.FALSE);
		selectedLine = (String) listOfLines.getSelectedValue();
		setSelectedLinePin(Pin.HIGHZ);
    }

    protected void removeAllLabels() {
        guiScheme.clearLabels();
        labelModel.clear();
        selectedLabel = null;
        guiRenderer.repaint();
	}

	protected void removeSelectedLabel() {
    	if(selectedLabel != null) {
			ArrayList<GuiLabel> toRemove = new ArrayList<GuiLabel>();
			for(GuiLabel gl: guiScheme.getLabels()) {
				if(gl.getName().equals(selectedLabel)) {
					toRemove.add(gl);
				}
			}
			
			for(GuiLabel label: toRemove) {
				guiScheme.removeLabel(label);
			}
			
			labelModel.removeElement(selectedLabel);
			selectedLabel = null;
			guiRenderer.repaint();
		}
	}

	protected void highlightLabel(ListSelectionEvent e) {
    	setSelectedLabelPin(Pin.FALSE);
		selectedLabel = (String) listOfLabels.getSelectedValue();
		setSelectedLabelPin(Pin.HIGHZ);
	}

    private void setSelectedLabelPin(Pin pin) {
		if(selectedLabel != null) {
			for(GuiLabel gl: guiScheme.getLabels()) {
				if(gl.getName().equals(selectedLabel)) {
					gl.setPin(pin);
					gl.setColor(pin == Pin.FALSE? Color.BLACK: Color.GREEN);
				}
			}
			guiRenderer.repaint();
		}
	}

	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        new DrawSignals();
    }
}
