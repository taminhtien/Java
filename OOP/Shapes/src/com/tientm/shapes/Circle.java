package com.tientm.shapes;

public class Circle extends TwoDimensionalShape implements GetArea {

	private double r;

	public Circle(double r) {
		super();
		this.r = r;
	}

	public double getArea() {
		return Math.PI * Math.pow(r, 2);
	}

	@Override
	public String toString() {
		return "Circle [r=" + r + ", getArea()=" + getArea() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	

}