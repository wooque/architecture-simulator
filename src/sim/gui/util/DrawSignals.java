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
    private GuiScheme guiScheme;
    private GuiLine guiLine;
    private ZoomPanel zoomPanel;
    private ArrayList<Point> line;
    private ArrayList<Line> lines;
    private JList<String> listOfLines;
    private DefaultListModel<String> listModel;
    private String selected;
    private Point last;
    private JLabel confFilename;
	HashMap<String, HashMap<String, ArrayList<ArrayList<Point>>>> allLines;

    private class Line {

        final ArrayList<Point> line;
        final String name;

        Line(ArrayList<Point> line, String name) {
            this.line = line;
            this.name = name;
        }
    }

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
                Point curr = new Point(e.getX() - disp.x, e.getY() - disp.y);
                ArrayList<Point> tempPoints = new ArrayList<Point>();
                tempPoints.add(last);
                tempPoints.add(curr);
                guiScheme.removeLine(guiLine);
                guiLine = new GuiLine(tempPoints, Pin.TRUE);
                guiScheme.addLine(guiLine);
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
            line.add(curr);
            if (last != null) {
                ArrayList<Point> tempPoints = new ArrayList<Point>();
                tempPoints.add(last);
                tempPoints.add(curr);
                guiScheme.addLine(new GuiLine(tempPoints, Pin.TRUE));
                guiRenderer.repaint();
            }
            last = curr;
        }

        private void rightClick() {
            guiScheme.removeLine(guiLine);
            guiRenderer.repaint();
            last = null;
            if (line.size() > 1) {
                String s = (String) JOptionPane.showInputDialog(DrawSignals.this, "Signal Name:", "New signal", JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (s == null) {
                    return;
                }
                lines.add(new Line(line, s));
                if(!listModel.contains(s)) {
                	listModel.addElement(s);
                }
                for (GuiLine gl : guiScheme.getLines()) {
                    gl.setPin(Pin.FALSE);
                }
                guiRenderer.repaint();
            }
            line = new ArrayList<Point>();
        }
    }

    private DrawSignals() {
        super("Draw Signals");

        line = new ArrayList<Point>();
        lines = new ArrayList<Line>();

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
			confFilename.setText(chooser.getSelectedFile().getPath());
			try {
				BufferedReader confFileReader = new BufferedReader(new FileReader(confFilename.getText()));
				
				String confLine = confFileReader.readLine();
				
				String lineName = null;
				ArrayList<ArrayList<Point>> lineSections = null;
				String schemeName = null;
				HashMap<String, ArrayList<ArrayList<Point>>> schemeLines = null;
				allLines = new HashMap<String, HashMap<String, ArrayList<ArrayList<Point>>>>();
				
				String schemeFilename = null;
				if(!getTitle().isEmpty()) {
					 schemeFilename = getTitle().substring(getTitle().lastIndexOf('\\') + 1);
				}
				
				while(confLine != null) {
					
					String[] tokens = confLine.split(",(\\s)*|(\\)){0,1}(\\s)*\\(|\\)");
					
					if(!(tokens.length == 1 && tokens[0].isEmpty()) 
						&& !((tokens[0].length() > 1) && tokens[0].substring(0,2).equals("//"))) {
						if(tokens.length == 1  
							&& ((tokens[0].charAt(0) >= 'a' && tokens[0].charAt(0) <= 'z')
								|| (tokens[0].charAt(0) >= 'A' && tokens[0].charAt(0) <= 'Z'))) {
							
							if(lineSections != null) {
								schemeLines.put(lineName, lineSections);
							}
							if(schemeLines != null) {
								allLines.put(schemeName, schemeLines);
							}
							schemeName = tokens[0];
							schemeLines = new HashMap<String, ArrayList<ArrayList<Point>>>();
							lineName = null;
							lineSections = null;
						} else {
							
							int i = 0;
							if(tokens[0].isEmpty()) {
								// workaround for String.split() method not recognizing if delimiter is on begining
								i = 1;
							} else if((tokens[0].charAt(0) >= 'a' && tokens[0].charAt(0) <= 'z')
								|| (tokens[0].charAt(0) >= 'A' && tokens[0].charAt(0) <= 'Z')) {
								
								if(lineSections != null) {
									schemeLines.put(lineName, lineSections);
								}
								lineName = tokens[0];
								lineSections = new ArrayList<ArrayList<Point>>();
								i = 1;
							}
							
							ArrayList<Point> section = new ArrayList<Point>();
							for(; i < tokens.length; i+=2) {
								int x = Integer.parseInt(tokens[i]);
								int y = Integer.parseInt(tokens[i + 1]);
								section.add(new Point(x, y));
							}
							lineSections.add(section);
							if(schemeName.equals(schemeFilename)) {
								lines.add(new Line(section, lineName));
				                if(!listModel.contains(lineName)) {
				                	listModel.addElement(lineName);
				                }
								guiScheme.addLine(new GuiLine(section, Pin.FALSE));
							}
						}
					}
					confLine = confFileReader.readLine();
				}
				
				if(lineSections != null) {
					schemeLines.put(lineName, lineSections);
				}
				
				if(schemeLines != null) {
					allLines.put(schemeName, schemeLines);
				}
				confFileReader.close();
				guiRenderer.repaint();
			} catch (FileNotFoundException e) {
				System.out.println("Conf file not found!");
			} catch (IOException e) {
				System.out.println("Conf file corrupted!");
			}
		}
    }

    private void loadImage() {
        JFileChooser chooser = new JFileChooser("images");
        int returnVal = chooser.showOpenDialog(DrawSignals.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            setTitle(chooser.getSelectedFile().getPath());
            
            guiScheme.setImage(chooser.getSelectedFile().getPath());
            guiRenderer.switchScheme(guiScheme);
            zoomPanel.setImage(guiScheme.getImage());
            
            removeAllSignals();
            
            if(allLines != null) {
            	String schemeName = getTitle().substring(getTitle().lastIndexOf('\\') + 1);
	            HashMap<String, ArrayList<ArrayList<Point>>> schemeLines = allLines.get(schemeName);
	            
	            if(schemeLines != null) {
		            for(Map.Entry<String, ArrayList<ArrayList<Point>>> entry: schemeLines.entrySet()) {
		            	String lineName = entry.getKey();
		            	ArrayList<ArrayList<Point>> lineSections = entry.getValue();
		            	
		            	for(ArrayList<Point> section: lineSections) {
		            		lines.add(new Line(section, lineName));
		            		if(!listModel.contains(lineName)) {
		            			listModel.addElement(lineName);
		            		}
		            		guiScheme.addLine(new GuiLine(section, Pin.FALSE));
		            	}
		            }
	            }
            }
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
