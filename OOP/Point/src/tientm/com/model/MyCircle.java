package tientm.com.model;

public class MyCircle {
	private MyPoint center;
	private int radius;

	public MyCircle(int x, int y, int radius) {
		this.center = new MyPoint(x, y);
		this.radius = radius;
	}

	public MyCircle(MyPoint center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public MyPoint getCenter() {
		return center;
	}

	public void setCenter(MyPoint center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String toString() {
		return "Circle @(" + center.getX() + ", " + center.getY() + ")" + " radius = " + radius;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
}
