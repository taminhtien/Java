package tientm.com.shapes;

public class Triangle extends TwoDimensionalShape {

	private double a, b, c;

	double getArea() {
		double p = 0.5 * (a + b + c);
		double temp = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		return temp;
	}

	double getVolume() {
		return 0;
	}

	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
}
