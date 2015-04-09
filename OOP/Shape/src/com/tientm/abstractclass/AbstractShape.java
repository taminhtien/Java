package com.tientm.abstractclass;

public abstract class AbstractShape {
	protected String color;
	protected boolean filled;

	public AbstractShape() {
		color = "RED";
		filled = true;
	}
	
	public AbstractShape(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();

	@Override
	public String toString() {
		return "AbstractShape [color=" + color + ", filled=" + filled + "]";
	}
	
}
