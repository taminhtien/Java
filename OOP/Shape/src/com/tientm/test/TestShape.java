package com.tientm.test;

import java.util.Scanner;

import com.tientm.nomalclass.Circle;
import com.tientm.nomalclass.Rectangle;
import com.tientm.nomalclass.Shape;
import com.tientm.nomalclass.Square;

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
