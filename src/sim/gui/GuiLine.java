package sim.gui;

import java.awt.*;
import java.util.ArrayList;

import sim.components.Pin;

// Klasa koja predstavja jednu liniju
// ( linija inace ima jedan ulazni i vise izlaznih pinova, pa zato postoje niz nizova tacaka )
//
public class GuiLine {
	private ArrayList<ArrayList<Point>> sections; 					// Sve tacke svih izlomljenih linja
	private Color color;
	private Pin pin;
	
	public GuiLine(ArrayList<ArrayList<Point>> sections, Pin pin){
		this.sections=sections;
		this.pin=pin;
	}

	public void draw(Graphics g){
		update();
		Graphics2D g2d = ((Graphics2D) g);
		g2d.setColor(color);
		for(ArrayList<Point> section:sections){
			Point last=null;
			for(Point p:section){
				if(last!=null){
					g2d.setStroke(new BasicStroke(2));
					g2d.drawLine(last.x, last.y, p.x, p.y);
				}
				last=p;
			}
		}
	}
	private void update(){
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
}
