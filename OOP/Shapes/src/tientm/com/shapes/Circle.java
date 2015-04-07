package tientm.com.shapes;

public class Circle extends TwoDimensionalShape {

	private double r;
	final double PI = 3.14f;
	double getArea() {
		return PI * Math.pow(r, 2);
	}
	public Circle(double r) {
		super();
		this.r = r;
	}
	double getVolume() {
		return 0;
	}

	/*void print() {
		System.out.println("Two Dimensional Shape");
		System.out.println("Area: " + getArea());
	}*/
}