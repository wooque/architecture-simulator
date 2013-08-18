package sim.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class GuiScheme{
	
	private BufferedImage image;
	private ArrayList<GuiLine> lines;
	private ArrayList<GuiLabel> labels;
	
	public GuiScheme(String filename){
		setImage(filename);
	}
	
	public void setImage(String filename) {
		if (filename != null && !filename.isEmpty()) {
			try {
				image = ImageIO.read(new File(filename));
			} catch (IOException e) {
				System.out.println("Can't read image!");
			}
		}
		lines = new ArrayList<GuiLine>();
		labels = new ArrayList<GuiLabel>();
	}
	
	public BufferedImage getImage() {
		return image;
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
