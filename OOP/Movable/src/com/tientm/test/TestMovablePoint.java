package com.tientm.test;

import com.tientm.model.Movable;
import com.tientm.model.MovableCircle;
import com.tientm.model.MovablePoint;

public class TestMovablePoint {
	public static void main(String[] args) {
/*		MovablePoint mp = new MovablePoint(0, 0, 1, 1);
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
		
		MovableCircle mc = new MovableCircle(0, 0, 1, 1, 5);
		System.out.println(mc);
		mc.moveUp();
		System.out.println(mc);
		mc.moveUp();
		System.out.println(mc);
		mc.moveUp();
		System.out.println(mc);
		mc.moveDown();
		System.out.println(mc);
		mc.moveDown();
		System.out.println(mc);
		mc.moveLeft();
		System.out.println(mc);
		mc.moveLeft();
		System.out.println(mc);
		mc.moveLeft();
		System.out.println(mc);
		mp.moveRight();
		System.out.println(mp);
		mp.moveRight();
		System.out.println(mp);
		mp.moveRight();
		System.out.println(mp);*/
		
		Movable m1 = new MovablePoint(5, 6, 1, 1);
		System.out.println(m1);
		
		Movable m2 = new MovableCircle(2, 1, 2, 2, 1); // upcast
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);
		m2.moveLeft();
		System.out.println(m2);
		m2.moveUp();
		System.out.println(m2);
		m2.moveDown();
		System.out.println(m2);
	}
}
