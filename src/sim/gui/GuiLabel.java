package sim.gui;

import java.awt.*;

import sim.components.Pin;

public class GuiLabel {

	private String label;
	private Color color;
	private String name;
	private Pin pin;
	private int x;
	private int y;
	private boolean changed;

	public GuiLabel(int x, int y) {
		this.x = x;
		this.y = y;
		this.color = Color.BLACK;
	}
	
	public void update(Graphics g, int dispx, int dispy) {
		draw(g, dispx, dispy, false);
	}
	
	public void draw(Graphics g, int dispx, int dispy) {
		draw(g, dispx, dispy, true);
	}

	public void draw(Graphics g, int dispx, int dispy, boolean forceDraw) {
		if (updateLabel() || forceDraw) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(color);
			g2d.setFont(new Font("Arial", Font.BOLD, 12));
			g2d.drawString(label, x + dispx, y + dispy);
			changed = true;
		} else {
			changed = false;
		}
	}

	private boolean updateLabel() {
		if(pin.isHighZ()) {
			if (label == null || !label.equals("Z")) {
				label = "Z";
				return true;
			} else {
				return false;
			}
		} else if (label == null || !label.equals(Integer.toHexString(pin.getIntVal()))) {
			label = Integer.toHexString(pin.getIntVal()).toUpperCase();
			
			int leadingZeros = pin.getNumOfLines() / 4 + (pin.getNumOfLines() % 4 > 0? 1: 0) - label.length();
			
			StringBuilder str = new StringBuilder();
			for(int i = 0; i < leadingZeros; i++) {
				str.append("0");
			}
			str.append(label);
			
			label = str.toString();
			return true;
		} else {
			return false;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Pin getPin() {
		return pin;
	}

	public void setPin(Pin pin) {
		this.pin = pin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isChanged() {
		return changed;
	}
}
