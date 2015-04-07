package tientm.com.shapes;

public class Sphere extends ThreeDimensionalShape{

	final double PI = 3.14f;
	private double r;
	double getArea() {
		return 4 * PI * Math.pow(r, 2) ;
	}

	double getVolume() {
		return (4 / 3) * PI * Math.pow(r, 3) ;
	}

	public Sphere(double r) {
		super();
		this.r = r;
	}
}
