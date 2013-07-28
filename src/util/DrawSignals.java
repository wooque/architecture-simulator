package util;

import gui.*;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

import components.Pin;


@SuppressWarnings("serial")
public class DrawSignals extends JFrame implements MouseMotionListener, ActionListener, ClipboardOwner {

	private GuiScheme					guis;
	private ZoomPanel					zoomPanel;
	private ArrayList<Point>			sections;
	private ArrayList<ArrayList<Point>> line;
	private ArrayList<Line>				lines;
	private JButton						removeSignalButton;
	private JButton						generateCodeButton;
	private JButton						loadImage;
	private JPanel 						east;
	private JPanel 						northeast;
	private JPanel 						southeast;
	private Point						last=null;
	private Pin							activePin=new Pin(true);
	private Pin							inactivePin=new Pin(false);
	
	private class Line{
		ArrayList<ArrayList<Point>> line;
		String name;
		Line(ArrayList<ArrayList<Point>> line,String name){
			this.line=line;
			this.name=name;
		}
	}

	private class SignalMouseListener extends MouseAdapter {

		private JFrame	parent;
		
		public SignalMouseListener(JFrame parent) {
			this.parent = parent;
		}
		public void mouseReleased(MouseEvent e) {
			switch (e.getButton()) {
				case MouseEvent.BUTTON1:
					Point curr=new Point(e.getX(),e.getY());
					sections.add(curr);
					if(last!=null){
						ArrayList<ArrayList<Point>> tempsections=new ArrayList<ArrayList<Point>>();
						ArrayList<Point> temppoints =new ArrayList<Point>();
						temppoints.add(last);
						temppoints.add(curr);
						tempsections.add(temppoints);
						guis.addLine(new GuiLine(tempsections,activePin));
						guis.repaint();
					}
					last=curr;
					break;
				case MouseEvent.BUTTON2:
					if(line.size()>0){
						String s = (String) JOptionPane.showInputDialog(parent, "New signal", "Signal Name:",JOptionPane.PLAIN_MESSAGE, null, null, null);
						if (s == null) break;
						lines.add(new Line(line,s));
						for(GuiLine gl:guis.getLines()){
							gl.setPin(inactivePin);
						}
						guis.repaint();
					}
					line=new ArrayList<ArrayList<Point>>();
					break;
				case MouseEvent.BUTTON3:
					if (sections.size() > 1) {
						line.add(sections);
					}
					sections=new ArrayList<Point>();
					last=null;
					break;
			}
		}
	}

	public DrawSignals(String imagePath) {
		super("Draw Signals");
		Container container = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		sections=new ArrayList<Point>();
		line=new ArrayList<ArrayList<Point>>();
		lines=new ArrayList<Line>();

		guis = new GuiScheme(imagePath);
		guis.addMouseMotionListener(this);
		guis.addMouseListener(new SignalMouseListener(this));

		zoomPanel = new ZoomPanel(guis.getImage(), 10, 10, 10);
		
		east=new JPanel();
		east.setLayout(new GridLayout(2, 1));
		
		northeast=new JPanel();
		east.add(northeast);
		
		southeast= new JPanel();
		southeast.setLayout(new BoxLayout(southeast, BoxLayout.Y_AXIS));
		east.add(southeast);
		
		northeast.add(zoomPanel);

		removeSignalButton = new JButton("Clear lines");
		removeSignalButton.addActionListener(this);
		removeSignalButton.setAlignmentX(CENTER_ALIGNMENT);

		generateCodeButton = new JButton("Generate code");
		generateCodeButton.addActionListener(this);
		generateCodeButton.setAlignmentX(CENTER_ALIGNMENT);
		
		loadImage = new JButton("Image...");
		loadImage.addActionListener(this);
		loadImage.setAlignmentX(CENTER_ALIGNMENT);
		
		southeast.add(loadImage);
		southeast.add(removeSignalButton);
		southeast.add(generateCodeButton);

		container.add("Center",guis);
		container.add("East",east);
		setBounds(0, 0, guis.getWidth()+zoomPanel.getWidth()+20, guis.getHeight()+50);
		validate();
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == removeSignalButton) {
			if (lines.size() > 0) {
				lines=new ArrayList<Line>();
			}
			guis.setLines(new ArrayList<GuiLine>());
			guis.repaint();
		} else if (e.getSource() == generateCodeButton) {
			StringBuffer code = new StringBuffer("// \n// \n"); 
			//new StringBuffer("ArrayList<ArrayList<Point>> sections=null;\n");
			//code.append("ArrayList<Point> points=null;\n");
			//code.append("GuiLine line=null;\n");
			for(Line line:lines){
				code.append("sections=new ArrayList<ArrayList<Point>>();\n");
				for (ArrayList<Point> section : line.line) {
					code.append("points=new ArrayList<Point>();\n");
					for (Point point : section) {
						code.append("points.add(new Point("+point.x+","+point.y+"));\n");
					}
					code.append("sections.add(points);\n");
				}
				code.append("line=new GuiLine(sections,"+ line.name+");\n");
				code.append("gui.addLine(line);\n\n//\n//\n");
			}
			lines=new ArrayList<Line>();
			line=new ArrayList<ArrayList<Point>>();
			sections=new ArrayList<Point>();
			Clipboard clipboard = getToolkit().getSystemClipboard();
			StringSelection tempString = new StringSelection(code.toString());
			clipboard.setContents(tempString, this);
			JOptionPane.showMessageDialog(this, "Code generated", "Code copied to clipboard", JOptionPane.PLAIN_MESSAGE);
		}else if(e.getSource() == loadImage){
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("./src/images"));
	        int returnVal = chooser.showOpenDialog(this);
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            setTitle(chooser.getSelectedFile().getPath());
	            remove(guis);
	            guis=new GuiScheme(chooser.getSelectedFile().getPath());
	            guis.addMouseMotionListener(this);
	    		guis.addMouseListener(new SignalMouseListener(this));
	    		add("Center",guis);
	    		northeast.remove(zoomPanel);
	    		zoomPanel = new ZoomPanel(guis.getImage(), 10, 10, 10);
	    		northeast.add(zoomPanel);
	            validate();
	            
	        }
		}

	}

	public static void main(String[] args) {
		new DrawSignals("./src/images/bus2.png");

	}

	public void mouseMoved(MouseEvent mouseEvent) {
		zoomPanel.setZoomX(mouseEvent.getX());
		zoomPanel.setZoomY(mouseEvent.getY());
		zoomPanel.repaint();
	}

	public void lostOwnership(Clipboard arg0, Transferable arg1) {
	}

	public void mouseDragged(MouseEvent mouseEvent) {	
		zoomPanel.setZoomX(mouseEvent.getX());
		zoomPanel.setZoomY(mouseEvent.getY());
		zoomPanel.repaint();
	}

}
