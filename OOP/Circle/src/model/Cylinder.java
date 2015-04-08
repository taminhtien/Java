package model;

public class Cylinder extends Circle {

	private double height;

	// Constructor with default color, radius and height
	public Cylinder() {
		super(); // Call superclass no-arg constructor Circle()
		height = 1.0;
	}

	// Constructor with default radius, color but given height
	public Cylinder(double height) {
		super(); // Call superclass no-arg constructor Circle()
		this.height = height;
	}

	public Cylinder(double radius, double height) {
		super(radius); // Call superclass constructor Circle(r)
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	/*
	 * public double getVolume() { return getArea() * height; }
	 */

	public double getVolume() {
		return super.getArea() * height;
	}

	public double getArea() {
		return 2 * Math.PI * height + 2 * Math.PI * super.getRadius();
	}

	public String toString() {
		return "Cylinder: subclass of "
				+ super.toString() // use Circle's toString()
				+ " height = " + height + ", area = " + super.getArea()
				+ "\nArea = " + getArea() + "\nVolumn = "
				+ getVolume();
	}

}
