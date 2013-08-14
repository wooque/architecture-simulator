package sim.gui.util;

import java.awt.Point;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

import sim.components.Pin;
import sim.gui.*;

@SuppressWarnings("serial")
public class DrawSignals extends JFrame {

    private GuiScheme guiScheme;
    private GuiLine guiLine;
    private ZoomPanel zoomPanel;
    private ArrayList<Point> line;
    private ArrayList<Line> lines;
    private JList<String> listOfLines;
    private DefaultListModel<String> listModel;
    private String selected;
    private Point last;

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
            zoomPanel.setZoomX(e.getX());
            zoomPanel.setZoomY(e.getY());
            zoomPanel.repaint();
            
            if (last != null) {
                Point curr = new Point(e.getX(), e.getY());
                ArrayList<Point> tempPoints = new ArrayList<Point>();
                tempPoints.add(last);
                tempPoints.add(curr);
                guiScheme.removeLine(guiLine);
                guiLine = new GuiLine(tempPoints, Pin.TRUE);
                guiScheme.addLine(guiLine);
                guiScheme.repaint();
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
                Point curr = new Point(e.getX(), e.getY());
                line.add(curr);
                if (last != null) {
                    ArrayList<Point> tempPoints = new ArrayList<Point>();
                    tempPoints.add(last);
                    tempPoints.add(curr);
                    guiScheme.addLine(new GuiLine(tempPoints, Pin.TRUE));
                    guiScheme.repaint();
                }
                last = curr;
        }

        private void rightClick() {
            guiScheme.removeLine(guiLine);
            guiScheme.repaint();
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
                guiScheme.repaint();
            }
            line = new ArrayList<Point>();
        }
    }

    private DrawSignals() {
        super("Draw Signals");

        line = new ArrayList<Point>();
        lines = new ArrayList<Line>();

        guiScheme = new GuiScheme("");
        SignalMouseAdapter signalMouseAdapter = new SignalMouseAdapter();
        guiScheme.addMouseMotionListener(signalMouseAdapter);
        guiScheme.addMouseListener(signalMouseAdapter);
        
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
        JButton loadImage = new JButton("Image...");
        loadImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadImage();
            }
        });
        loadImage.setAlignmentX(CENTER_ALIGNMENT);
        southeast.add(loadImage);

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
        JButton generateCodeButton = new JButton("Generate code");
        generateCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveConf();
            }
        });
        generateCodeButton.setAlignmentX(CENTER_ALIGNMENT);
        southeast.add(generateCodeButton);
        
        southeast.add(Box.createVerticalGlue());
        
        JScrollPane scrollPane = new JScrollPane(guiScheme);
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

    // TODO: save gui conf in file
    private void saveConf() {
        for (Line l : lines) {
        	System.out.println(l.name+":");
            for (Point point : l.line) {
            	System.out.println("("+point.x+","+point.y+")");
            }
        }
        JOptionPane.showMessageDialog(DrawSignals.this, "Code generated", "Code generated", JOptionPane.PLAIN_MESSAGE);
    }
    
    private void loadConf() {
    	// TODO: load gui conf from file 
    }

    private void loadImage() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("images"));
        int returnVal = chooser.showOpenDialog(DrawSignals.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            setTitle(chooser.getSelectedFile().getPath());
            guiScheme.setImage(chooser.getSelectedFile().getPath());
            zoomPanel.setImage(guiScheme.getImage());
            removeAllSignals();
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
			guiScheme.repaint();
    	}
    }
    
    private void removeAllSignals() {
        if (lines.size() > 0) {
            lines = new ArrayList<Line>();
        }
        selected = null;
        listModel.clear();
        guiScheme.setLines(new ArrayList<GuiLine>());
        guiScheme.repaint();
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
			guiScheme.repaint();
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
