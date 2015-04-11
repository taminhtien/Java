package com.tientm.shapes;

public class Tetrahedron extends ThreeDimensionalShape implements GetArea,
		GetVolume {

	private double a;

	public Tetrahedron(double a) {
		super();
		this.a = a;
	}

	public double getVolume() {
		return (Math.sqrt(2) / 12) * Math.pow(a, 3);
	}

	public double getArea() {
		return Math.sqrt(3) * Math.pow(a, 3);
	}

	@Override
	public String toString() {
		return "Tetrahedron [a=" + a + ", getVolume()=" + getVolume()
				+ ", getArea()=" + getArea() + ", toString()="
				+ super.toString() + "]";
	}
}
