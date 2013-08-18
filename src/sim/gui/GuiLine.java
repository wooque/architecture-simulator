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
		if(pin != null) {
			this.pin = pin;
			updateColor();
		}
	}
	
	public void update(Graphics g, int x, int y) {
		draw(g, x, y, false);
	}

	public void draw(Graphics g, int x, int y) {
		draw(g, x, y, true);
	}
	
	public void draw(Graphics g, int x, int y, boolean forceDraw) {
		if(updateColor() || forceDraw) {
			Graphics2D g2d = ((Graphics2D) g);
			g2d.setColor(color);
			Point last = null;
			for (Point p : points) {
				if (last != null) {
					g2d.setStroke(new BasicStroke(2));
					g2d.drawLine(x + last.x, y + last.y, x + p.x, y + p.y);
				}
				last = p;
			}
		}
	}

	private boolean updateColor() {
		if (pin.isHighZ()) { 
			if (color == null || color != Color.GREEN) {
				color = Color.GREEN;
				return true;
			} else {
				return false;
			}
		} else {
			if (pin.isBool()) {
				if (pin.getBoolVal()) { 
					if(color == null || color != Color.RED) {
						color = Color.RED;
						return true;
					} else {
						return false;
					}
				} else if(color == null || color != Color.BLUE) {
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
