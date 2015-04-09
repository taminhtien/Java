package test;

import model.CylinderComposition;

public class TestCylinderComposition {
	public static void main(String[] args) {
		CylinderComposition c1 = new CylinderComposition();
		System.out.println(c1);
		CylinderComposition c2 = new CylinderComposition(2);
		System.out.println(c2);
		CylinderComposition c3 = new CylinderComposition(2, 6);
		System.out.println(c3);
		System.out.println(c1.getArea());
		System.out.println(c2.getArea());
		System.out.println(c3.getArea());
	}
}

