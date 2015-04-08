package tientm.com.test;

import java.util.Scanner;

import tientm.com.model.Circle;
import tientm.com.model.Rectangle;
import tientm.com.model.Shape;
import tientm.com.model.Square;

class MyValue {
int i;
}

public class TestShape {

	public static void main(String[] args) {
		Shape s = new Circle("yello", false, 8);
		System.out.println(s);
		Shape s2 = new Rectangle("black", false, 3, 1);
		System.out.println(s2);
		Rectangle r = new Square(3, "orange", true);
		System.out.println(r);
		System.out.println("Area: " + r.getArea());
		System.out.println("Perimeter: " + r.getPerimeter());
	}
}
