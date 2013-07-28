package gui;

import java.awt.*;
import java.util.ArrayList;
import components.Pin;

// Klasa koja predstavja jednu liniju
// ( linija inace ima jedan ulazni i vise izlaznih pinova, pa zato postoje niz nizova tacaka )
//
public class GuiLine {
	private ArrayList<ArrayList<Point>> sections; 					// Sve tacke svih izlomljenih linja
	private Color color;
	//private String label;
	private Pin pin;
	
	public GuiLine(ArrayList<ArrayList<Point>> sections, Pin pin){
		this.sections=sections;
		this.pin=pin;
	}

	public void draw(Graphics g){
		update();
		g.setColor(color);
		for(ArrayList<Point> section:sections){
			Point last=null;
			for(Point p:section){
				if(last!=null){
					g.drawLine(last.x, last.y, p.x, p.y);
				}
				last=p;
			}
		}
		//if ((!pin.isBool())&&(!pin.isHighZ())) {
		//	g.setColor(Color.BLACK);
		//	Point first = sections.get(0).get(0);
		//	Point last = sections.get(0).get(1);
		//	int X = first.x + (last.x - first.x) / 2-3 ;
		//	int Y = first.y + (last.y - first.y) / 2 ;
		//	if(first.x==last.x)
		//		X+=6;
		//	if(first.y==last.y)
		//		Y-=3;
		//	g.drawString(label, X, Y);
		//}
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
				//label=""+pin.getIntVal();
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
