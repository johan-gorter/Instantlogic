package org.instantlogic.designer.util.diagram;

import java.io.Serializable;

public final class Point2d implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private double left;
	private double top;
	
	@SuppressWarnings("unused")
	private Point2d() {	
		// For GSON
	}
	
	public Point2d(double left, double top) {
		this.left = left;
		this.top = top;
	}

	public double getLeft() {
		return left;
	}

	public double getTop() {
		return top;
	}
}
