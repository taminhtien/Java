package model;

public class CylinderComposition {
	private Circle base;
	private double height;

	public CylinderComposition() {
		base = new Circle(); // Call constructor default of circle
		height = 1;
	}

	public CylinderComposition(double height) {
		this.base = new Circle(); // Call constructor with default parameter of
									// circle
		this.height = height;
	}

	public CylinderComposition(double radius, double height) {
		this.base = new Circle(radius); // Call constructor with radius
										// parameter of circle
		this.height = height;
	}

	public CylinderComposition(String color, double radius, double height) {
		this.base = new Circle(radius, color); // Call constructor with radius
												// and color parameter of circle
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getArea() {
		return base.getArea() * height;
	}

	@Override
	public String toString() {
		return "CylinderComposition [base=" + base + ", height=" + height + "]";
	}
	
	

}
