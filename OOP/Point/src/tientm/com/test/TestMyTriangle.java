package tientm.com.test;

import tientm.com.model.MyTriangle;

public class TestMyTriangle {
	public static void main(String[] args) {
		MyTriangle tri = new MyTriangle(1,  2, 3, 4, 5, 6);
		System.out.println(tri);
		System.out.println("Perimeter: " + tri.getPerimeter());
		tri.printType();
	}
}
