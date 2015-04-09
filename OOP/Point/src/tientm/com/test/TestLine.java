package tientm.com.test;

import tientm.com.model.Line;
import tientm.com.model.MyPoint;

public class TestLine {

	public static void main(String[] args) {
		Line l1 = new Line(0, 0, 3, 4);
		System.out.println(l1);
			   
		MyPoint p1 = new MyPoint(1, 1);
		MyPoint p2 = new MyPoint(5, 5);
		Line l2 = new Line(p1, p2);
		System.out.println(l2);
		System.out.println("Diff l1 = " + l1.getLength());
		System.out.println("Diff l2 = " + l2.getLength());
	}
}
