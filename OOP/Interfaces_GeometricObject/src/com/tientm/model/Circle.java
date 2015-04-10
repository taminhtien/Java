package com.tientm.model;

public class Circle implements GeometricObject {

	protected double radius;
	
	public Circle() {
		super();
		radius = 1;
	}
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

	
}
