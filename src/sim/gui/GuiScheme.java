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
	private ArrayList<GuiHyperlink> hyperlinks;
	
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

	public ArrayList<GuiLabel> getLabels() {
		return labels;
	}
	
	public ArrayList<GuiHyperlink> getHyperlinks() {
		return hyperlinks;
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
	
	public void addHyperlink(GuiHyperlink hyperlink) {
		hyperlinks.add(hyperlink);
	}
	
	public void removeHyperlinks(GuiHyperlink hyperlink) {
		hyperlinks.remove(hyperlink);
	}
	
	public void clearLines() {
		lines.clear();
	}
	
	public void clearLabels() {
		labels.clear();
	}

	public void clearHyperlinks() {
		hyperlinks.clear();
	}
 }
