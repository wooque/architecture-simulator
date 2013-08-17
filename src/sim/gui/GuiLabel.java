package sim.gui;

import java.awt.*;

import sim.components.Pin;

public class GuiLabel {

	private String label;
	private Pin pin;
	private int x;
	private int y;

	public GuiLabel(int x, int y, Pin pin) {
		this.x = x;
		this.y = y;
		if(pin != null) {
			this.pin = pin;
			updateLabel();
		}
	}
	
	public void update(Graphics g) {
		draw(g, false);
	}
	
	public void draw(Graphics g) {
		draw(g, true);
	}

	public void draw(Graphics g, boolean forceDraw) {
		if (updateLabel() || forceDraw) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.BLACK);
			//g2d.setFont(new Font("Arial", Font.BOLD, 12));
			g2d.setFont(g2d.getFont().deriveFont(Font.BOLD).deriveFont(12));
			g2d.drawString(label, x, y);
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
			label = Integer.toHexString(pin.getIntVal());
			return true;
		} else {
			return false;
		}
	}

	public Pin getPin() {
		return pin;
	}

	public void setPin(Pin pin) {
		this.pin = pin;
	}
}
