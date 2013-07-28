package gui;

import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class GuiScheme extends Canvas{
	
	private BufferedImage image;
	private File imagefile;
	private ArrayList<GuiLine> lines;
	private ArrayList<GuiLabel> labels;
	
	public GuiScheme(String filename){
		setBackground(Color.WHITE);
		imagefile=new File(filename);
		try {
			image=ImageIO.read(imagefile);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		lines=new ArrayList<GuiLine>();
		labels=new ArrayList<GuiLabel>();
		Dimension size=new Dimension(800, 600);
		setSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}
        
	public void addLine(GuiLine line){ lines.add(line); }
        public void removeLine(GuiLine line) { lines.remove(line); }
	public void addLabel(GuiLabel label){ labels.add(label); }
        
        @Override
	public void update(Graphics g) {
            paint(g); 
        }
	
        @Override
	public void paint(Graphics g){
		//super.paint(g);
		g.drawImage(image, 0, 0, null);
		for(GuiLine gl:lines){
			gl.draw(g);
		}
		for(GuiLabel gl:labels){
			gl.draw(g);
		}
		getToolkit().sync();
	}
	
	public BufferedImage getImage() { return image; }
	public ArrayList<GuiLine> getLines() { return lines; }
	public void setLines(ArrayList<GuiLine> lines) { this.lines = lines; }
	public ArrayList<GuiLabel> getLabels() { return labels; }
	public void setLabels(ArrayList<GuiLabel> labels) { this.labels = labels; }
}
