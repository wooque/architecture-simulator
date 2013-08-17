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
		updateColor();
	}

	public void draw(Graphics g) {
		if(updateColor()) {
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
	}

	private boolean updateColor() {
		if (pin.isHighZ() && (color == null || color != Color.GREEN)) {
			color = Color.GREEN;
			return true;
		} else {
			if (pin.isBool()) {
				if (pin.getBoolVal() && (color == null || color != Color.RED)) {
					color = Color.RED;
					return true;
				} else if(!pin.getBoolVal() && (color == null || color != Color.BLUE)) {
					color = Color.BLUE;
					return true;
				} else {
					return false;
				}
			} else {
				color = Color.GRAY;
				return false;
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
