package sim.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GuiSchemeRenderer extends JPanel {

	private GuiScheme guiScheme;
	
	public GuiSchemeRenderer(GuiScheme guiScheme) {
		setBackground(Color.WHITE);
		switchScheme(guiScheme);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage image = guiScheme.getImage();
		int x = 0;
		int y = 0;
		if(image != null) {
			x = (getWidth() - image.getWidth())/2;
			y = (getHeight() - image.getHeight())/2;
			g.drawImage(image, x, y, null);
		}
		for(GuiLine gl: guiScheme.getLines()){
			gl.draw(g, x, y);
		}
		for(GuiLabel gl: guiScheme.getLabels()){
			gl.draw(g);
		}
	}
	
	public void updateScheme() {
		Graphics g = getGraphics();
		BufferedImage image = guiScheme.getImage();
		int x = (getWidth() - image.getWidth())/2;
		int y = (getHeight() - image.getHeight())/2;
		for(GuiLine gl: guiScheme.getLines()){
			gl.update(g, x, y);
		}
		for(GuiLabel gl: guiScheme.getLabels()){
			gl.update(g);
		}
	}
	
	public void switchScheme(GuiScheme other) {
		guiScheme = other;
		Dimension size = new Dimension(guiScheme.getImage() != null ? guiScheme.getImage().getWidth() : 600,
										guiScheme.getImage() != null ? guiScheme.getImage().getHeight() : 600);
		setSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}
}
