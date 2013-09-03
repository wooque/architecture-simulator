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
            
            if (last != null) {
                guiLine.removePoint(last); 
            }
            Point curr = new Point(e.getX() - disp.x, e.getY() - disp.y);
            guiLine.addPoint(curr);
            guiRenderer.repaint();
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

        guiScheme = new GuiScheme("");
        guiRenderer = new GuiSchemeRenderer(guiScheme);
        SignalMouseAdapter signalMouseAdapter = new SignalMouseAdapter();
        guiRenderer.addMouseMotionListener(signalMouseAdapter);
        guiRenderer.addMouseListener(signalMouseAdapter);
        
        JPanel east = new JPanel();
        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));

        JPanel northeast = new JPanel();
        zoomPanel = new ZoomPanel(guiScheme.getImage(), 10, 10, 10);
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
				File confFileIn = new File(confFilename.getText());
				BufferedReader confIn = new BufferedReader(new FileReader(confFileIn));
				File confFileOut = new File(confFilename.getText()+"temp");
				PrintWriter confOut = new PrintWriter(new FileWriter(confFileOut), true);
				
				String confLine = confIn.readLine();
				String mode = "coping";
				String schemeName = getTitle().substring(getTitle().lastIndexOf('\\') + 1);
				boolean saved = false;
				
				while(confLine != null || !saved) {
					if(mode.equals("coping") && confLine != null) {
						String[] tokens = confLine.split(",(\\s)*|(\\)){0,1}(\\s)+\\(|\\)");
						if(tokens.length == 1 && tokens[0].equals(schemeName)) {
							mode = "updating";
						} else {
							confOut.println(confLine);
						}
						confLine = confIn.readLine();
					} else if (mode.equals("skipping") && confLine != null) {
						String[] tokens = confLine.split(",(\\s)*|(\\)){0,1}(\\s)+\\(|\\)");
						if(tokens.length == 1 && !tokens[0].isEmpty()) {
							if(!tokens[0].equals(schemeName)) {
								confOut.println(confLine);
								mode = "coping";
							}
						}
						confLine = confIn.readLine();
					} else {
						
						HashMap<String, ArrayList<ArrayList<Point>>> linesToCommit = new HashMap<String, ArrayList<ArrayList<Point>>>();
				        for (Line l : lines) {
				        	if(linesToCommit.containsKey(l.name)) {
				        		ArrayList<ArrayList<Point>> sections = linesToCommit.get(l.name);
				        		sections.add(l.line);
				        	} else {
				        		ArrayList<ArrayList<Point>> sections = new ArrayList<ArrayList<Point>>();
				        		sections.add(l.line);
				        		linesToCommit.put(l.name, sections);
				        	}
				        }
				
				        String schemeToCommit = getTitle().substring(getTitle().lastIndexOf('\\') + 1);
				        confOut.println(schemeToCommit);
				        confOut.println();
				        
				        allLines.put(schemeToCommit, linesToCommit);
				        
				        for (Map.Entry<String, ArrayList<ArrayList<Point>>> entry : linesToCommit.entrySet()) {
				        	String lineName = entry.getKey();
				        	ArrayList<ArrayList<Point>> lineSections = entry.getValue();
				        	confOut.printf("%-19s", lineName);
				        	for(int i = 0; i < lineSections.size(); i++) {
				        		if(i > 0) {
				    				confOut.print("                   ");
				    			}
				        		for (Point point : lineSections.get(i)) {
				        			
				        			confOut.print(" ("+point.x+","+point.y+")");
				        		}
				        		confOut.println();
				        	}
				            
				        }
				        confOut.println();
				        saved = true;
				        if(confLine != null) {
				        	confLine = confIn.readLine();
				        }
				        mode = "skipping";
					}
				}
		        confIn.close();
		        confOut.close();
		        confFileIn.delete();
		        boolean ret = confFileOut.renameTo(confFileIn);
		        
		        if(ret == false) {
		        	JOptionPane.showMessageDialog(DrawSignals.this,	"Configuration saving failed", "Configuration saving failed", JOptionPane.ERROR_MESSAGE);
		        } else {
		        	JOptionPane.showMessageDialog(DrawSignals.this, "Configuration saved", "Configuration saved", JOptionPane.INFORMATION_MESSAGE);
		        }
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
            removeAllSignals();
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
    		ArrayList<ArrayList<Point>> selectedLine = new ArrayList<ArrayList<Point>>();
			for(int i = 0; i < lines.size();) {
				Line line = lines.get(i);
				if(line.name.equals(selected)) {
					selectedLine.add(line.line);
					lines.remove(i);
				} else {
					i++;
				}
			}
			listModel.removeElement(selected);
			selected = null;
			for(ArrayList<Point> section: selectedLine) {
				Point last = null;
				for(Point curr: section) {
					if(last != null) {
						for(int i = 0; i < guiScheme.getLines().size();) {
							GuiLine gl = guiScheme.getLines().get(i);
							// checking only first two points
							// lines should not overlap
							if(gl.getPoints().get(0) == last && gl.getPoints().get(1) == curr) {
								guiScheme.removeLine(gl);
							} else {
								i++;
							}
						}
					}
					last = curr;
				}
			}
			guiRenderer.repaint();
    	}
    }
    
    private void removeAllSignals() {
        if (lines.size() > 0) {
            lines = new ArrayList<Line>();
        }
        selected = null;
        listModel.clear();
        guiScheme.setLines(new ArrayList<GuiLine>());
        guiRenderer.repaint();
    }
    
    private void setPinForSelected(Pin in) {
		if(selected != null) {
			ArrayList<ArrayList<Point>> selectedLine = new ArrayList<ArrayList<Point>>();
			for(Line line: lines) {
				if(line.name.equals(selected)) {
					selectedLine.add(line.line);
				}
			}
			for(ArrayList<Point> section: selectedLine) {
				Point last = null;
				for(Point curr: section) {
					if(last != null) {
						for(GuiLine gl: guiScheme.getLines()) {
							if(gl.getPoints().get(0) == last && gl.getPoints().get(1) == curr) {
								gl.setPin(in);
							}
						}
					}
					last = curr;
				}
			}
			guiRenderer.updateScheme();;
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
