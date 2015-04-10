package com.tientm.test;

import com.tientm.model.Circle;
import com.tientm.model.ResizableCircle;

public class TestCircle {
	public static void main(String[] args) {
		Circle c = new Circle();
		System.out.println(c);
		Circle c2 = new Circle(2);
		System.out.println(c2);
		ResizableCircle rc = new ResizableCircle();
		System.out.println(rc);
		ResizableCircle rc2 = new ResizableCircle(4);
		System.out.println(rc2);
	}
}
