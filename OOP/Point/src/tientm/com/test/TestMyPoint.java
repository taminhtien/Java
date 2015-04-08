package tientm.com.test;

import tientm.com.model.MyPoint;

public class TestMyPoint {
	public static void main(String[] args) {
		MyPoint p1 = new MyPoint(3, 0);
		MyPoint p2 = new MyPoint(0, 4);
		System.out.println(p1.distance(p2));
		System.out.println(p1.distance(5, 6));
		MyPoint[] arrPoint = new MyPoint[10];
		for (int i = 0; i < arrPoint.length; i++) {
			arrPoint[i] = new MyPoint(i + 1, i + 1);
		}
		for (int i = 0; i < arrPoint.length; i++) {
			System.out.println(arrPoint[i]);
		}
	}
}
