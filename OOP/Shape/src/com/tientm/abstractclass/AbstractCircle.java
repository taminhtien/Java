package com.tientm.abstractclass;

public class AbstractCircle extends AbstractShape {

	protected double radius;

	public AbstractCircle() {
		radius = 1;
	}

	public AbstractCircle(double radius) {
		this.radius = radius;
	}

	public AbstractCircle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}

	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return "AbstractCircle [radius=" + radius + "] " + super.toString();
	}
	
	

}
