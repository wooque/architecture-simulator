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
	}

	public void draw(Graphics g) {
		updateLabel();
		if (!pin.isHighZ()) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 12));
			g.drawString(label, x, y);
		}
	}

	private void updateLabel() {
		if (!pin.isHighZ()) {
			label = Integer.toHexString(pin.getIntVal());
		}
	}

	public Pin getPin() {
		return pin;
	}

	public void setPin(Pin pin) {
		this.pin = pin;
	}
}
