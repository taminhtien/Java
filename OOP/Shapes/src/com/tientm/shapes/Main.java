package com.tientm.shapes;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Shapes s[] = new Shapes[200];
		Random r1 = new Random();
		Random r2 = new Random();
		double r, a, b, c;
		int type = 0;
		
		for (int i = 0; i < 200; i++) {
			type = r1.nextInt(6) + 0;
			switch (type) {
			case 0:
				r = r2.nextInt(20) + 1;
				s[i] = new Circle(r);
				break;
			case 1:
				a = r2.nextInt(20) + 1;
				s[i] = new Square(a);
				break;
			case 2:
				a = r2.nextInt(20) + 1;
				b = r2.nextInt(20) + 1;
				c = r2.nextInt(20) + 1;
				s[i] = new Triangle(a, b, c);
				break;
			case 3:
				r = r2.nextInt(20) + 1;
				s[i] = new Sphere(r);
				break;
			case 4:
				a = r2.nextInt(20) + 1;
				s[i] = new Cube(a);
				break;
			case 5:
				a = r2.nextInt(20) + 1;
				s[i] = new Tetrahedron(a);
				break;
			default:
				break;
			}
		}

		for (int i = 0; i < 200; i++) {
			System.out.println(s[i]);
		}
	}
}