package com.tientm.shapes;

public class Square extends TwoDimensionalShape implements GetArea {

	private double a;

	public Square(double a) {
		super();
		this.a = a;
	}

	public double getArea() {
		return Math.pow(a, 2);
	}

	@Override
	public String toString() {
		return "Square [a=" + a + ", getArea()=" + getArea() + ", toString()="
				+ super.toString() + "]";
	}

}
