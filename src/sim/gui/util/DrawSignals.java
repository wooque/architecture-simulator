package sim.gui.util;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

import sim.components.Pin;
import sim.gui.*;

@SuppressWarnings("serial")
public class DrawSignals extends JFrame implements ClipboardOwner {

    private GuiScheme guiScheme;
    private GuiLine guiLine;
    private ZoomPanel zoomPanel;
    private ArrayList<Point> line;
    private ArrayList<Line> lines;
    private final JPanel northeast;
    private Point last;

    private class Line {

        final ArrayList<Point> line;
        final String name;

        Line(ArrayList<Point> line, String name) {
            this.line = line;
            this.name = name;
        }
    }

    private class SignalMouseMotionListener implements MouseMotionListener {

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
    }

    private class SignalMouseListener extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent e) {
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
                String s = (String) JOptionPane.showInputDialog(DrawSignals.this, "New signal", "Signal Name:", JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (s == null) {
                    return;
                }
                lines.add(new Line(line, s));
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
        guiScheme.addMouseMotionListener(new SignalMouseMotionListener());
        guiScheme.addMouseListener(new SignalMouseListener());

        zoomPanel = new ZoomPanel(guiScheme.getImage(), 10, 10, 10);

        JPanel east = new JPanel();
        east.setLayout(new GridLayout(2, 1));

        northeast = new JPanel();
        east.add(northeast);

        JPanel southeast = new JPanel();
        southeast.setLayout(new BoxLayout(southeast, BoxLayout.Y_AXIS));
        east.add(southeast);

        northeast.add(zoomPanel);

        JButton removeSignalButton = new JButton("Clear lines");
        removeSignalButton.setAlignmentX(CENTER_ALIGNMENT);
        removeSignalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSignals();
            }
        });

        JButton generateCodeButton = new JButton("Generate code");
        generateCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateCode();
            }
        });
        generateCodeButton.setAlignmentX(CENTER_ALIGNMENT);

        JButton loadImage = new JButton("Image...");
        loadImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadImage();
            }
        });
        loadImage.setAlignmentX(CENTER_ALIGNMENT);

        southeast.add(loadImage);
        southeast.add(removeSignalButton);
        southeast.add(generateCodeButton);

        add("Center", guiScheme);
        add("East", east);
        
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        setBounds(0, 0, guiScheme.getWidth() + zoomPanel.getWidth() + 20, guiScheme.getHeight() + 50);
        validate();
        
        setVisible(true);
    }

    private void generateCode() {
        StringBuilder code = new StringBuilder();
        for (Line l : lines) {
        	System.out.println(l.name+":");
            for (Point point : l.line) {
            	System.out.println("("+point.x+","+point.y+")");
            }
        }
        lines = new ArrayList<Line>();
        line = new ArrayList<Point>();
        Clipboard clipboard = getToolkit().getSystemClipboard();
        StringSelection tempString = new StringSelection(code.toString());
        clipboard.setContents(tempString, DrawSignals.this);
        JOptionPane.showMessageDialog(DrawSignals.this, "Code generated", "Code copied to clipboard", JOptionPane.PLAIN_MESSAGE);
    }

    private void loadImage() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("images"));
        int returnVal = chooser.showOpenDialog(DrawSignals.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            setTitle(chooser.getSelectedFile().getPath());
            remove(guiScheme);
            guiScheme = new GuiScheme(chooser.getSelectedFile().getPath());
            guiScheme.addMouseMotionListener(new SignalMouseMotionListener());
            guiScheme.addMouseListener(new SignalMouseListener());
            add("Center", guiScheme);
            northeast.remove(zoomPanel);
            zoomPanel = new ZoomPanel(guiScheme.getImage(), 10, 10, 10);
            northeast.add(zoomPanel);
            validate();
        }
    }

    private void removeSignals() {
        if (lines.size() > 0) {
            lines = new ArrayList<Line>();
        }
        guiScheme.setLines(new ArrayList<GuiLine>());
        guiScheme.repaint();
    }

    @Override
    public void lostOwnership(Clipboard arg0, Transferable arg1) {
    }

    public static void main(String[] args) {
        new DrawSignals();
    }
}
