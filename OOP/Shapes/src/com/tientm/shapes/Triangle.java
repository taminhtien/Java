package com.tientm.shapes;

public class Triangle extends TwoDimensionalShape implements GetArea{

	private double a, b, c;

	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getArea() {
		double p = 0.5 * (a + b + c);
		double temp = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		return temp;
	}
	
	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + ", getArea()="
				+ getArea() + ", toString()=" + super.toString() + "]";
	}
}
