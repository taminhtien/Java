package tientm.com.shapes;

public abstract class ThreeDimensionalShape extends Shapes{
	abstract double getArea();
	abstract double getVolume();
	protected void print() {
		System.out.println("Three Dimensional Shape");
		System.out.println("Area: " + getArea());
		System.out.println("Volume: " + getVolume());
	}
}
