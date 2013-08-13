package sim.gui;

import java.awt.*;
import java.util.ArrayList;

import sim.components.Pin;

public class GuiLine {
	private ArrayList<Point> points;
	private Color color;
	private Pin pin;

	public GuiLine(ArrayList<Point> points, Pin pin) {
		this.points = points;
		this.pin = pin;
	}

	public void draw(Graphics g) {
		update();
		Graphics2D g2d = ((Graphics2D) g);
		g2d.setColor(color);
		Point last = null;
		for (Point p : points) {
			if (last != null) {
				g2d.setStroke(new BasicStroke(2));
				g2d.drawLine(last.x, last.y, p.x, p.y);
			}
			last = p;
		}
	}

	private void update() {
		if (pin.isHighZ()) {
			color = Color.GREEN;
		} else {
			if (pin.isBool()) {
				if (pin.getBoolVal())
					color = Color.RED;
				else
					color = Color.BLUE;
			} else {
				color = Color.GRAY;
			}
		}
	}

	public Pin getPin() {
		return pin;
	}

	public void setPin(Pin pin) {
		this.pin = pin;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}
}
