package tientm.com.shapes;

public class Square extends TwoDimensionalShape{

	private double a;
	double getArea() {
		return Math.pow(a, 2);
	}
	double getVolume() {
		return 0;
	}
	public Square(double a) {
		super();
		this.a = a;
	}
	/*void print() {
		System.out.println("Area: " + getArea());
	}*/
}
