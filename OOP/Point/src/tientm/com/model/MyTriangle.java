package tientm.com.model;

public class MyTriangle {
	private MyPoint v1;
	private MyPoint v2;
	private MyPoint v3;

	public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		v1 = new MyPoint(x1, y1);
		v2 = new MyPoint(x2, y2);
		v3 = new MyPoint(x3, y3);
	}

	public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	public String toString() {
		return "Triangle @ (" + v1.getX() + ", " + v1.getY() + "), ("
				+ v2.getX() + ", " + v2.getY() + "), (" + v3.getX() + ", "
				+ v3.getY() + ")";
	}

	public double getPerimeter() {
		double v12Diff = v1.distance(v2);
		double v23Diff = v2.distance(v3);
		double v31Diff = v3.distance(v1);
		return v12Diff + v23Diff + v31Diff;
	}
	
	public void printType() {
		double v12Diff = v1.distance(v2);
		double v23Diff = v2.distance(v3);
		double v31Diff = v3.distance(v1);
		System.out.println(v12Diff + ", " + v23Diff + ", " + v31Diff);
		if (v12Diff == v23Diff || v23Diff == v31Diff || v31Diff == v12Diff) {
			System.out.println("Isoscales");
		} else if (v12Diff == v23Diff && v23Diff == v12Diff) {
			System.out.println("Equilateral");
		} else {
			System.out.println("Scalene");
		}
		
	}

}
