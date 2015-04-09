package com.tientm.nomalclass;

public class Shape {
	private String color;
	private boolean filled;
	public Shape() {
		super();
		color = "green";
		filled = true;
	}
	public Shape(String color, boolean filled) {
		super();
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

	public String toString() {
		return "A Shape with color of " + color + " and " + filled;
	}
	
}
