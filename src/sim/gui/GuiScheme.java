package sim.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GuiScheme extends JPanel{
	
	private BufferedImage image;
	private ArrayList<GuiLine> lines;
	private ArrayList<GuiLabel> labels;
	
	public GuiScheme(String filename){
		setImage(filename);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		for(GuiLine gl:lines){
			gl.draw(g);
		}
		for(GuiLabel gl:labels){
			gl.draw(g);
		}
		//getToolkit().sync();
	}
	
	public void updateScheme() {
		Graphics g = getGraphics();
		for(GuiLine gl:lines){
			gl.draw(g);
		}
		for(GuiLabel gl:labels){
			gl.draw(g);
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(String filename) {
		setBackground(Color.WHITE);
		if (filename != null && !filename.isEmpty()) {
			try {
				image = ImageIO.read(new File(filename));
			} catch (IOException e) {
				System.out.println("Can't read image!");
			}
		}
		lines = new ArrayList<GuiLine>();
		labels = new ArrayList<GuiLabel>();
		Dimension size = new Dimension(image != null ? image.getWidth() : 600, image != null ? image.getHeight() : 600);
		setSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}

	public ArrayList<GuiLine> getLines() {
		return lines;
	}

	public void setLines(ArrayList<GuiLine> lines) {
		this.lines = lines;
	}

	public ArrayList<GuiLabel> getLabels() {
		return labels;
	}

	public void setLabels(ArrayList<GuiLabel> labels) {
		this.labels = labels;
	}
	
	public void addLine(GuiLine line) {
		lines.add(line);
	}
	
	public void removeLine(GuiLine line) {
		lines.remove(line);
	}
	
	public void addLabel(GuiLabel label) {
		labels.add(label);
	}
	
	public void removeLabel(GuiLabel label) {
		labels.remove(label);
	}
}
