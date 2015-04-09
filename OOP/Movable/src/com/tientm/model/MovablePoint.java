package com.tientm.model;

public class MovablePoint implements Movable {
	private int x;
	private int y;
	private int xSpeed;
	private int ySpeed;

	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		super();
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	//@Override
	public void moveUp() {
		y += ySpeed;
		
	}
	
	//@Override
	public void moveDown() {
		y -= ySpeed;
		
	}

	public void moveLeft() {
		x -= xSpeed;
		
	}

	public void moveRight() {
		x += xSpeed;
	}

	@Override
	public String toString() {
		return "MovablePoint [x=" + x + ", y=" + y + ", xSpeed=" + xSpeed
				+ ", ySpeed=" + ySpeed + "]";
	}
	
	

}
