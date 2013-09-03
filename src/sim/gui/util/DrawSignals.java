package sim.gui.util;

import java.awt.Point;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.*;

import sim.components.Pin;
import sim.gui.*;

@SuppressWarnings("serial")
public class DrawSignals extends JFrame {

    private GuiSchemeRenderer guiRenderer;
    private HashMap<String, GuiScheme> allSchemes;
    private GuiScheme guiScheme;
    private GuiLine guiLine;
    private ZoomPanel zoomPanel;
    private JList<String> listOfLines;
    private DefaultListModel<String> listModel;
    private String selected;
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
                    rightClick();
                    break;
            }
        }

        private void leftClick(MouseEvent e) {
        	Point disp = guiRenderer.getDisplacement();
            Point curr = new Point(e.getX() - disp.x, e.getY() - disp.y);
            
        	if(guiLine == null) {
            	// TODO make constructor without ArrayList
            	guiLine = new GuiLine(new ArrayList<Point>(), Pin.TRUE);
            } else {
            	last = curr;
            }
        	guiLine.addPoint(curr);
        }

        private void rightClick() {
            guiLine.removePoint(last);
            last = null;
            if (guiLine.size() < 2) {
            	guiScheme.removeLine(guiLine);
            	guiLine = null;
            } else {
                String s = (String) JOptionPane.showInputDialog(DrawSignals.this, "Signal Name:", "New signal", JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (s != null) {
	                guiLine.setName(s);
	                if(!listModel.contains(s)) {
	                	listModel.addElement(s);
	                }
	                guiLine.setPin(Pin.FALSE);
	                guiLine = null;
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
        listModel = new DefaultListModel<String>();
        listOfLines.setModel(listModel);
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
			        
			        HashMap<String, ArrayList<GuiLine>> linesToCommit = new HashMap<String, ArrayList<GuiLine>>(); 
			        
			        for(GuiLine gl: scheme.getLines()) {
			        	if(!linesToCommit.containsKey(gl.getName())) {
			        		linesToCommit.put(gl.getName(), new ArrayList<GuiLine>());
			        	}
			        	linesToCommit.get(gl.getName()).add(gl);
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
			            
			        }
				}
		        confOut.println();
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
			allSchemes = new GuiConfigurator(null, filename, null).getGuiSchemes();
			// TODO check if there is some ongoing scheme drawing 
		}
    }

    private void loadImage() {
        JFileChooser chooser = new JFileChooser("images");
        int returnVal = chooser.showOpenDialog(DrawSignals.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	String imagePath = chooser.getSelectedFile().getPath();
        	String imageName = imagePath.substring(imagePath.lastIndexOf('\\') + 1);
            setTitle(imagePath);
            listModel.clear();
            selected = null;
            guiScheme = allSchemes.get(imageName);
            if(guiScheme == null) {
            	guiScheme = new GuiScheme(imageName);
            } else {
	            for(GuiLine gl: guiScheme.getLines()) {
            		if(!listModel.contains(gl.getName())) {
            			listModel.addElement(gl.getName());
            		}
	            }
            }
            guiRenderer.switchScheme(guiScheme);
            zoomPanel.setImage(guiScheme.getImage());
            pack();
        }
    }

    private void removeSelectedSignal() {
    	if(selected != null) {
			ArrayList<GuiLine> toRemove = new ArrayList<GuiLine>();
			for(GuiLine gl: guiScheme.getLines()) {
				if(gl.getName().equals(selected)) {
					toRemove.add(gl);
				}
			}
			for(GuiLine gl: toRemove) {
				guiScheme.removeLine(gl);
			}

			listModel.removeElement(selected);
			selected = null;
			guiRenderer.repaint();
		}
    }
    
    private void removeAllSignals() {
    	// TODO add method for clearing lines
        guiScheme.setLines(new ArrayList<GuiLine>());
        listModel.clear();
        selected = null;
        guiRenderer.repaint();
    }
    
    private void setPinForSelected(Pin in) {
		if(selected != null) {
			for(GuiLine gl: guiScheme.getLines()) {
				if(gl.getName().equals(selected)) {
					gl.setPin(in);
				}
			}
			guiRenderer.updateScheme();
		}
    }
    
    private void highlightLine(ListSelectionEvent e) {
    	setPinForSelected(Pin.FALSE);
		selected = (String) listOfLines.getSelectedValue();
		setPinForSelected(Pin.HIGHZ);
    }

    public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
        new DrawSignals();
    }
}
