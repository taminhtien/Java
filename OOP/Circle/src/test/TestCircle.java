package test;

import model.Circle;

public class TestCircle {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		System.out.println(c1.toString());
		Circle c2 = new Circle(2.0);
		System.out.println("The circle has radius of " + c2.getRadius()
				+ " va area of " + c2.getArea());

		System.out.println(c2.toString()); // explicit call
		System.out.println(c2); // println() calls toString() implicitly, same
								// as above
		System.out.println("Operator '+' invokes toString() too: " + c2); // '+'
																			// invokes
																			// toString()
																			// too

		Circle c3 = new Circle(4.0, "blue");
		System.out.println("The circle has radius of " + c3.getRadius()
				+ " va area of " + c3.getArea() + " and has color: "
				+ c3.getColor());
	}
}
