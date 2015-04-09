package com.tientm.model;

public class MovableCircle implements Movable{
	private int radius;
	private MovablePoint center;

	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		super();
		this.radius = radius;
		this.center = new MovablePoint(x, y, xSpeed, ySpeed);
	}

	@Override
	public String toString() {
		return "MovableCircle [radius=" + radius + ", center=" + center + "]";
	}

	// @Override
	public void moveUp() {
		center.setY(this.center.getY() + 1);

	}

	// @Override
	public void moveDown() {
		center.setY(this.center.getY() - 1);
	}

	public void moveLeft() {
		center.setX(this.center.getX() - 1);

	}

	public void moveRight() {
		center.setX(this.center.getX() + 1);
	}

}
