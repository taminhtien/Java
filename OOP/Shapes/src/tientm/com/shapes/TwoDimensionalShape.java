package tientm.com.shapes;

public abstract class TwoDimensionalShape extends Shapes {
	abstract double getArea();
	abstract double getVolume();
	void print() {
		System.out.println("Two Dimensional Shape");
		System.out.println("Area: " + getArea());
	}
}
