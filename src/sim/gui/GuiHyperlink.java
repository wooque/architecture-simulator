package sim.gui;

import java.awt.Point;

public class GuiHyperlink {

	private Point begin;
	private Point end;
	private String scheme;
	
	public GuiHyperlink(Point begin, Point end, String scheme) {
		this.begin = begin;
		this.end = end;
		this.scheme = scheme;
	}

	public Point getBegin() {
		return begin;
	}

	public Point getEnd() {
		return end;
	}

	public String getScheme() {
		return scheme;
	}
}
