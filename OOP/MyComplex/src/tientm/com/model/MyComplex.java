package tientm.com.model;

public class MyComplex {
	private double real;
	private double imag;

	public MyComplex(double real, double imag) {
		super();
		this.real = real;
		this.imag = imag;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public void setValue(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public String toString() {
		if (imag >= 0) {
			return "(" + real + " + " + imag + "i)";
		} else
			return "(" + real + " - " + imag * (-1) + "i)";

	}

	public boolean isReal() {
		if (imag == 0) {
			return true;
		}
		return false;
	}

	public boolean isImaginary() {
		if (real == 0) {
			return true;
		}
		return false;
	}

	public boolean equals(double real, double imag) {
		if (this.real == real && this.imag == imag) {
			return true;
		}
		return false;
	}

	public boolean equals(MyComplex another) {
		if (real == another.real && imag == another.imag) {
			return true;
		}
		return false;
	}

	public double magnitude() {
		return Math.sqrt(real * real + imag * imag);
	}

	public double argumentInRadians() {
		return Math.atan2(imag, real);
	}

	public int argumentDegrees() {
		return (int) Math.atan2(imag, real);
	}

	public MyComplex conjugate() {
		return new MyComplex(real, -imag);
	}

	public MyComplex add(MyComplex another) {
		return new MyComplex(real + another.real, imag + another.imag);
	}

	public MyComplex substract(MyComplex another) {
		return new MyComplex(real - another.real, imag - another.imag);
	}

	public MyComplex multiplyBy(MyComplex another) {
		return new MyComplex(real * another.real - imag * another.imag, real
				* another.imag + imag * another.real);
	}

	public MyComplex devideBy(MyComplex another) {
		MyComplex multiply = this.multiplyBy(another.conjugate());
		double temp = another.real * another.real + another.imag * another.imag;
		return new MyComplex(multiply.real / temp, multiply.imag / temp);
	}

	public void checkComplex() {
		if (!this.isReal()) {
			System.out.println(this + " is NOT a pure real number");
		} else {
			System.out.println(this + " is a pure real number");
		}
		if (!this.isImaginary()) {
			System.out.println(this + " is NOT a pure imaginary number");
		} else {
			System.out.println(this + " is a pure imaginary number");
		}
	}
}
