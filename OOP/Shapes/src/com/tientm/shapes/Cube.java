package com.tientm.shapes;

public class Cube extends ThreeDimensionalShape implements GetArea, GetVolume {

	private double a;

	public Cube(double a) {
		super();
		this.a = a;
	}

	public double getVolume() {
		return Math.pow(a, 3);
	}

	public double getArea() {
		return 6 * Math.pow(a, 2);
	}

	@Override
	public String toString() {
		return "Cube [a=" + a + ", getVolume()=" + getVolume() + ", getArea()="
				+ getArea() + ", toString()=" + super.toString() + "]";
	}
	
	
}
