package tientm.com.test;

import tientm.com.model.Line;
import tientm.com.model.LineSub;
import tientm.com.model.MyPoint;

public class TestLineSub {
	public static void main(String[] args) {
		LineSub ls1 = new LineSub(0, 0, 0, 4);
		System.out.println(ls1);
		System.out.println(ls1.getLength());
		MyPoint p1 = new MyPoint(1, 1);
		MyPoint p2 = new MyPoint(5, 5);
		LineSub ls2 = new LineSub(p1, p2);
		System.out.println(ls2);
		System.out.println("Diff l2 = " + ls2.getLength());
	}
}
