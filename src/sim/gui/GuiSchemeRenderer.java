package sim.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
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
		if(guiScheme != null) {
			BufferedImage image = guiScheme.getImage();
			Point disp = getDisplacement();
			if(image != null) {
				g.drawImage(image, disp.x, disp.y, null);
			}
			for(GuiLine gl: guiScheme.getLines()){
				gl.draw(g, disp.x, disp.y);
			}
			for(GuiLabel gl: guiScheme.getLabels()){
				gl.draw(g, disp.x, disp.y);
			}
		}
	}
	
	public void updateScheme() {
		if(guiScheme != null) {
			Graphics g = getGraphics();
			Point disp = getDisplacement();
			for(GuiLine gl: guiScheme.getLines()){
				gl.update(g, disp.x, disp.y);
			}
			for(GuiLabel gl: guiScheme.getLabels()){
				gl.update(g, disp.x, disp.y);
			}
		}
	}
	
	public Point getDisplacement() {
		Point disp = new Point(0, 0);
		if(guiScheme != null) {
			BufferedImage image = guiScheme.getImage();
			if(image != null) {
				disp.setLocation((getWidth() - image.getWidth())/2, (getHeight() - image.getHeight())/2);
			}
		}
		return disp;
	}
	
	public void switchScheme(GuiScheme other) {
		guiScheme = other;
		Dimension size = new Dimension(guiScheme != null && guiScheme.getImage() != null ? guiScheme.getImage().getWidth() : 600,
										guiScheme != null && guiScheme.getImage() != null ? guiScheme.getImage().getHeight() : 600);
		setSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}
}
