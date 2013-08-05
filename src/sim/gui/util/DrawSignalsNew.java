package sim.gui.util;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

import sim.components.Pin;
import sim.gui.*;

import java.awt.image.BufferedImage;
import java.util.HashMap;

@SuppressWarnings("serial")
public class DrawSignalsNew extends JFrame implements ClipboardOwner {

    private GuiScheme guiScheme;
    private GuiLine guiLine;
    private GuiRect rect;
    private Point rectBegin;
    private ZoomPanel zoomPanel;
    private ArrayList<Point> sections;
    private ArrayList<ArrayList<Point>> line;
    private ArrayList<Line> lines;
    private final JPanel northeast;
    private Point last;
    private final Pin activePin = new Pin(true);
    private final Pin inactivePin = new Pin(false);
    private Robot robot;
    private GuiComponent lastComponent;
    private final ArrayList<GuiComponent> components;
    private final ArrayList<Connection> connections;
    private Connection currConnection;
    private final HashMap<GuiComponent, Integer> IDs;

    private class Line {

        final ArrayList<ArrayList<Point>> line;
        final String name;

        Line(ArrayList<ArrayList<Point>> line, String name) {
            this.line = line;
            this.name = name;
        }
    }
    
    private class GuiComponent {

        final GuiRect rect;
        final String type;

        GuiComponent(GuiRect rect, String type) {
            this.rect = rect;
            this.type = type;
        }
    }

    private class Connection {

        GuiComponent first;
        GuiComponent second;
        boolean firstToSecond;
        int firstPinOrder;
        int secondPinOrder;

        Connection(GuiComponent first, boolean firstToSecond, int firstPinOrder) {
            this.first = first;
            this.firstToSecond = firstToSecond;
            this.firstPinOrder = firstPinOrder;
        }
    }
    
    private class GuiRect {
        
        final Point begin;
        final Point end;
        private final GuiLine[] lines = new GuiLine[4];
        
        GuiRect(Point begin, Point end) {
            this(begin.x, begin.y, end.x, end.y);
        }
        
        GuiRect(int x1, int y1, int x2, int y2) {
            begin = new Point(x1, y1);
            Point eastOfBegin = new Point(x2, y1);
            Point southOfBegin = new Point(x1, y2);
            end = new Point(x2, y2);
            
            ArrayList<ArrayList<Point>> tempSections = new ArrayList<ArrayList<Point>>();
            ArrayList<Point> tempPoints = new ArrayList<Point>();
            tempPoints.add(begin);
            tempPoints.add(eastOfBegin);
            tempSections.add(tempPoints);
            lines[0] = new GuiLine(tempSections, activePin);
            guiScheme.addLine(lines[0]);
            
            tempSections = new ArrayList<ArrayList<Point>>();
            tempPoints = new ArrayList<Point>();
            tempPoints.add(eastOfBegin);
            tempPoints.add(end);
            tempSections.add(tempPoints);
            lines[1] = new GuiLine(tempSections, activePin);
            guiScheme.addLine(lines[1]);
            
            tempSections = new ArrayList<ArrayList<Point>>();
            tempPoints = new ArrayList<Point>();
            tempPoints.add(begin);
            tempPoints.add(southOfBegin);
            tempSections.add(tempPoints);
            lines[2] = new GuiLine(tempSections, activePin);
            guiScheme.addLine(lines[2]);
            
            tempSections = new ArrayList<ArrayList<Point>>();
            tempPoints = new ArrayList<Point>();
            tempPoints.add(southOfBegin);
            tempPoints.add(end);
            tempSections.add(tempPoints);
            lines[3] = new GuiLine(tempSections, activePin);
            guiScheme.addLine(lines[3]);
            
            guiScheme.repaint();
        }
        
        void removeRect() {
            guiScheme.removeLine(lines[0]);
            guiScheme.removeLine(lines[1]);
            guiScheme.removeLine(lines[2]);
            guiScheme.removeLine(lines[3]);
            guiScheme.repaint();
        }
    }

    private class SignalMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            dragMouse(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            moveMouse(e);
        }

        private void moveMouse(MouseEvent e) {
            zoomPanel.setZoomX(e.getX());
            zoomPanel.setZoomY(e.getY());
            zoomPanel.repaint();
            
            snapMouse(e);
            
            if (last != null) {
                Point curr = new Point(e.getX(), e.getY());
                ArrayList<ArrayList<Point>> tempSections = new ArrayList<ArrayList<Point>>();
                ArrayList<Point> tempPoints = new ArrayList<Point>();
                tempPoints.add(last);
                tempPoints.add(curr);
                tempSections.add(tempPoints);
                guiScheme.removeLine(guiLine);
                guiLine = new GuiLine(tempSections, activePin);
                guiScheme.addLine(guiLine);
                guiScheme.repaint();
            }
        }
        
        private boolean isEdge(BufferedImage image, int x, int y) {
            try{
                if (image.getRGB(x, y) != 0xffffffff) {
                    if (((image.getRGB(x + 1, y) != 0xffffffff) && image.getRGB(x - 1, y) == 0xffffffff) ||
                            (image.getRGB(x + 1, y) == 0xffffffff && (image.getRGB(x - 1, y) != 0xffffffff)) ||
                            ((image.getRGB(x, y - 1) != 0xffffffff) && image.getRGB(x, y + 1) == 0xffffffff) ||
                            (image.getRGB(x, y - 1) == 0xffffffff && (image.getRGB(x, y + 1) != 0xffffffff))) {
                        return true;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
            return false;
        }
        
        private void snapMouse(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            BufferedImage image = guiScheme.getImage();
            
            int currColor = 0xff000000;
            try {
                currColor = image.getRGB(x, y);
            } catch (Exception ignored) {}
            
            if (currColor == 0xffffffff) {
                Point window = DrawSignalsNew.this.getLocation();
                for(int i = 1; i < 2; i++) {
                    int fix = y - i;
                    for (int j = x - i; j <= x + i; j++) {
                        if (isEdge(image, j, fix)) {
                            robot.mouseMove(window.x + j + 8, window.y + fix + 30);
                            return;
                        }
                    }
                    fix = x + i;
                    for (int j = y - i; j <= y + i; j++) {
                        if (isEdge(image, fix, j)) {
                            robot.mouseMove(window.x + fix + 8, window.y + j + 30);
                            return;
                        }
                    }
                    fix = y + i;
                    for (int j = x - i; j <= x + i; j++) {
                        if (isEdge(image, j, fix)) {
                            robot.mouseMove(window.x + j + 8, window.y + fix + 30);
                            return;
                        }
                    }
                    fix = x - i;
                    for (int j = y - i; j <= y + i; j++) {
                        if (isEdge(image, fix, j)) {
                            robot.mouseMove(window.x + fix + 8, window.y + j + 30);
                            return;
                        }
                    }
                }
            }
        }

        private void dragMouse(MouseEvent e) {
            zoomPanel.setZoomX(e.getX());
            zoomPanel.setZoomY(e.getY());
            zoomPanel.repaint();

            if(rect != null) {
                rect.removeRect();
            }
            snapMouse(e);
            Point rectEnd = e.getPoint();
            rect = new GuiRect(rectBegin, rectEnd);
            
        }
    }

    private class SignalMouseListener extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent e) {
            switch (e.getButton()) {
                case MouseEvent.BUTTON1:
                    leftClick(e);
                    break;
                case MouseEvent.BUTTON2:
                    middleClick();
                    break;
                case MouseEvent.BUTTON3:
                    rightClick();
                    break;
            }
        }
        
        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1){
                rectBegin = e.getPoint();
            }
        }

        private void leftClick(MouseEvent e) {
            if(rect != null) {
                String type = (String) JOptionPane.showInputDialog(DrawSignalsNew.this, "New component", "Component type:", JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (type == null) {
                    rect = null;
                    return;
                }
                lastComponent = new GuiComponent(rect, type);
                components.add(lastComponent);
                rect = null;
            } else {
                Point curr = new Point(e.getX(), e.getY());
                sections.add(curr);
                if (last != null) {
                    ArrayList<ArrayList<Point>> tempSections = new ArrayList<ArrayList<Point>>();
                    ArrayList<Point> tempPoints = new ArrayList<Point>();
                    tempPoints.add(last);
                    tempPoints.add(curr);
                    tempSections.add(tempPoints);
                    guiScheme.addLine(new GuiLine(tempSections, activePin));
                    guiScheme.repaint();
                } else {
                    for (GuiComponent gc : components) {
                        if(isInComponent(gc, curr)){
                            String type = (String) JOptionPane.showInputDialog(DrawSignalsNew.this, "Pin type", "Pin type:", JOptionPane.PLAIN_MESSAGE, null, null, null);
                            if (type == null) {
                                type = "input";
                            }
                            String num = (String) JOptionPane.showInputDialog(DrawSignalsNew.this, "Number of pin", "Number:", JOptionPane.PLAIN_MESSAGE, null, null, null);
                            if (num == null) {
                                num = "0";
                            }
                            currConnection = new Connection(gc, type.equals("output"), Integer.parseInt(num));
                            break;
                        }
                    }
                }
                last = curr;
            }
        }

        private boolean isInComponent(GuiComponent gc, Point p) {
            return (p.x >= gc.rect.begin.x) && (p.x <= gc.rect.end.x) && (p.y >= gc.rect.begin.y) && (p.y <= gc.rect.end.y);
        }

        private void middleClick() {
            if (line.size() > 0) {
                String s = (String) JOptionPane.showInputDialog(DrawSignalsNew.this, "New signal", "Signal Name:", JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (s == null) {
                    return;
                }
                lines.add(new Line(line, s));
                for (GuiLine gl : guiScheme.getLines()) {
                    gl.setPin(inactivePin);
                }
                guiScheme.repaint();
            }
            line = new ArrayList<ArrayList<Point>>();
        }

        private void rightClick() {
            guiScheme.removeLine(guiLine);
            guiScheme.repaint();
            if (sections.size() > 1) {
                line.add(sections);
            }
            if(currConnection != null) {
                for (GuiComponent gc : components) {
                    if (isInComponent(gc, last)) {
                        String num = (String) JOptionPane.showInputDialog(DrawSignalsNew.this, "Number of pin", "Number:", JOptionPane.PLAIN_MESSAGE, null, null, null);
                        if (num == null) {
                            num = "0";
                        }
                        currConnection.second = gc;
                        currConnection.secondPinOrder = Integer.parseInt(num);
                        connections.add(currConnection);
                        currConnection = null;
                        break;
                    }
                }
            }
            sections = new ArrayList<Point>();
            last = null;
        }
    }

    private DrawSignalsNew() {
        super("Draw Signals");

        sections = new ArrayList<Point>();
        line = new ArrayList<ArrayList<Point>>();
        lines = new ArrayList<Line>();

        guiScheme = new GuiScheme("./src/images/bus2.png");
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

        JButton removeLastComponent = new JButton("Remove last component");
        removeLastComponent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                components.remove(lastComponent);
                lastComponent.rect.removeRect();
                guiScheme.repaint();
                lastComponent = null;
            }
        });
        removeLastComponent.setAlignmentX(CENTER_ALIGNMENT);

        southeast.add(loadImage);
        southeast.add(removeSignalButton);
        southeast.add(generateCodeButton);
        southeast.add(removeLastComponent);

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
        try {
            robot = new Robot();
        } catch (AWTException ignored) {}
        
        components = new ArrayList<GuiComponent>();
        connections = new ArrayList<Connection>();
        IDs = new HashMap<GuiComponent, Integer>();
        
        setVisible(true);
    }

    private void generateCode() {
        int index = 0;
        StringBuilder code = new StringBuilder();
        for(GuiComponent gc: components) {
            code.append("public static ").append(gc.type).append(index).append(";\n");
            IDs.put(gc, index);
            index++;
        }
        code.append("private static void gui {\n");
        code.append("    ").append("ArrayList<ArrayList<Point>> sections;\n");
        code.append("    ").append("ArrayList<Point> points;\n");
        code.append("    ").append("GuiLine line;\n");
        for (Line l : lines) {
            code.append("    ").append("sections=new ArrayList<ArrayList<Point>>();\n");
            for (ArrayList<Point> section : l.line) {
                code.append("    ").append("points=new ArrayList<Point>();\n");
                for (Point point : section) {
                    code.append("    ").append("points.add(new Point(").append(point.x).append(",").append(point.y).append("));\n");
                }
                code.append("    ").append("sections.add(points);\n");
            }
            code.append("    ").append("line=new GuiLine(sections,").append(l.name).append(");\n");
            code.append("    ").append("gui.addLine(line);\n");
        }
        code.append("}\n");
        index = 0;
        code.append("public static void init {\n");
        for(GuiComponent gc: components) {
            code.append("    ").append(gc.type).append(index).append(" = new ").append(gc.type).append("();\n");
            index++;
        }
        code.append("}\n");
        code.append("public static void connect {\n");
        for(Connection c: connections) {
            int firstID = IDs.get(c.first);
            int secondID = IDs.get(c.second);
            if (c.firstToSecond) {
                code.append("    ").append(c.second.type).append(secondID).append(".setInputPin(").append(c.secondPinOrder).append(", ");
                code.append(c.first.type).append(firstID).append(".getOutputPin(").append(c.firstPinOrder).append("));\n");
            } else {
                code.append("    ").append(c.first.type).append(firstID).append(".setInputPin(").append(c.firstPinOrder).append(", ");
                code.append(c.second.type).append(secondID).append(".getOutputPin(").append(c.secondPinOrder).append("));\n");
            }
        }
        code.append("}\n");
        lines = new ArrayList<Line>();
        line = new ArrayList<ArrayList<Point>>();
        sections = new ArrayList<Point>();
        Clipboard clipboard = getToolkit().getSystemClipboard();
        StringSelection tempString = new StringSelection(code.toString());
        clipboard.setContents(tempString, DrawSignalsNew.this);
        JOptionPane.showMessageDialog(DrawSignalsNew.this, "Code generated", "Code copied to clipboard", JOptionPane.PLAIN_MESSAGE);
    }

    private void loadImage() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("./src/images"));
        int returnVal = chooser.showOpenDialog(DrawSignalsNew.this);
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
        new DrawSignalsNew();
    }
}
