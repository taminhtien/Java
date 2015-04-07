package tientm.com.shapes;

public class Cube extends ThreeDimensionalShape{

	private double a;
	double getArea() {
		return 6 * Math.pow(a, 2);
	}

	double getVolume() {
		return Math.pow(a, 3);
	}

	public Cube(double a) {
		super();
		this.a = a;
	}
}
