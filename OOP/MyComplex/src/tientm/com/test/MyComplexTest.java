package tientm.com.test;

import java.util.Scanner;

import tientm.com.model.MyComplex;

public class MyComplexTest {
	public static void main(String[] args) {
		System.out.print("Enter complex number 1 (real and imaginary part): ");
		Scanner sc = new Scanner(System.in);
		double real1 = sc.nextDouble();
		double imag1 = sc.nextDouble();
		MyComplex c1 = new MyComplex(real1, imag1);

		System.out.print("Enter complex number 2 (real and imaginary part): ");
		double real2 = sc.nextDouble();
		double imag2 = sc.nextDouble();
		MyComplex c2 = new MyComplex(real2, imag2);
		
		System.out.println("Number 1 is: " + c1);
		c1.checkComplex();
		System.out.println("Number 2 is: " + c2);
		c2.checkComplex();
		
		System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));
		System.out.println(c1 + " - " + c2 + " = " + c1.substract(c2));
		System.out.println(c1 + " * " + c2 + " = " + c1.multiplyBy(c2));
		System.out.println(c1 + " / " + c2 + " = " + c1.devideBy(c2));
	}
}
