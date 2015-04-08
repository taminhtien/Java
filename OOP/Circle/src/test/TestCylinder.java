package test;

import model.Cylinder;

public class TestCylinder {
	public static void main(String[] args) {
		Cylinder c = new Cylinder();
		System.out.println(c);
		// Constructor with default radius, color and height
		Cylinder c2 = new Cylinder(10);
		System.out.println(c2);
		// Constructor with default color, specifying radius and height
		Cylinder c3 = new Cylinder(2, 10);
		System.out.println(c3);
	}
}
