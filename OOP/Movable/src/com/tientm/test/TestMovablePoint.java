package com.tientm.test;

import com.tientm.model.MovablePoint;

public class TestMovablePoint {
	public static void main(String[] args) {
		MovablePoint mp = new MovablePoint(0, 0, 1, 1);
		System.out.println(mp);
		mp.moveUp();
		System.out.println(mp);
		mp.moveUp();
		System.out.println(mp);
		mp.moveUp();
		System.out.println(mp);
		mp.moveDown();
		System.out.println(mp);
		mp.moveDown();
		System.out.println(mp);
		mp.moveLeft();
		System.out.println(mp);
		mp.moveLeft();
		System.out.println(mp);
		mp.moveLeft();
		System.out.println(mp);
		mp.moveRight();
		System.out.println(mp);
		mp.moveRight();
		System.out.println(mp);
		mp.moveRight();
		System.out.println(mp);
	}
}
