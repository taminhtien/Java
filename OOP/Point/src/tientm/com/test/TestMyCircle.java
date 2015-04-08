package tientm.com.test;

import tientm.com.model.MyCircle;
import tientm.com.model.MyPoint;

public class TestMyCircle {
	public static void main(String[] args) {
		MyCircle circle = new MyCircle(3, 0, 5);
		System.out.println(circle);
		System.out.println(circle.getArea());
		MyPoint center = new MyPoint(0, 4);
		MyCircle circle2 = new MyCircle(center, 3);
		System.out.println(circle2);
		System.out.println(circle2.getArea());
	}
}
