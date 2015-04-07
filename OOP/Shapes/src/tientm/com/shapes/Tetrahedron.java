package tientm.com.shapes;

public class Tetrahedron extends ThreeDimensionalShape{

	private double a;
	double getArea() {
		return Math.sqrt(3) * Math.pow(a, 3);
	}

	double getVolume() {
		return (Math.sqrt(2) / 12) * Math.pow(a, 3);
	}

	public Tetrahedron(double a) {
		super();
		this.a = a;
	}
}
