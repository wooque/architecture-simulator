package sim.gui;

import java.awt.*;

import sim.components.Pin;

public class GuiLabel {

	private String label;
	private Pin pin;
	private int x;
	private int y;

	public GuiLabel(int xx, int yy, Pin pinko) {
		x = xx;
		y = yy;
		pin = pinko;
		updateLabel();
	}

	public void draw(Graphics g) {
		if (updateLabel()) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.BLACK);
			//g2d.setFont(new Font("Arial", Font.BOLD, 12));
			g2d.setFont(g2d.getFont().deriveFont(Font.BOLD).deriveFont(12));
			g2d.drawString(label, x, y);
		}
	}

	private boolean updateLabel() {
		if(pin.isHighZ() && (label == null || !label.equals("Z"))) {
			label = "Z";
			return true;
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
