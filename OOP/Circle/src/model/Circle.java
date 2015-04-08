package model;

public class Circle {
	private double radius; // private instance variable, not accessible from
							// outside this class
	private String color;

	public Circle(double radius) {
		super();
		this.radius = radius;
		this.color = "red";
	}

	public Circle() {
		super();
		this.radius = 1;
		this.color = "red";
	}

	public double getRadius() {
		return this.radius;
	}
	
	public double getArea() {
		return radius * radius * Math.PI;
	}

	public Circle(double radius, String color) {
		super();
		this.radius = radius;
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String toString() {
		return "Circle: radius = " + radius + ", color = " + color;
	}
	
	

}
