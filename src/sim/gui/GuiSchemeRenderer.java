package sim.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

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
		g.drawImage(guiScheme.getImage(), 0, 0, null);
		for(GuiLine gl: guiScheme.getLines()){
			gl.draw(g);
		}
		for(GuiLabel gl: guiScheme.getLabels()){
			gl.draw(g);
		}
	}
	
	public void updateScheme() {
		Graphics g = getGraphics();
		for(GuiLine gl: guiScheme.getLines()){
			gl.update(g);
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
