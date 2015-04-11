package com.tientm.shapes;

public class Sphere extends ThreeDimensionalShape implements GetArea, GetVolume {

	private double r;

	public Sphere(double r) {
		super();
		this.r = r;
	}

	public double getVolume() {
		return (4 / 3) * Math.PI * Math.pow(r, 3);
	}

	public double getArea() {
		return 4 * Math.PI * Math.pow(r, 2);
	}

	@Override
	public String toString() {
		return "Sphere [r=" + r + ", getVolume()=" + getVolume()
				+ ", getArea()=" + getArea() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
