package com.tientm.test;

import com.tientm.abstractclass.Circle2;
import com.tientm.abstractclass.Rectangle2;
import com.tientm.abstractclass.Shape2;
import com.tientm.abstractclass.Square2;

public class TestShapeAbstract {
	public static void main(String[] args) {

		// Upcast AbstractCircle to AbstractShape
		Shape2 s1 = new Circle2(5.5, "RED", false);  
		System.out.println(s1);                  
		System.out.println(s1.getArea());       
		System.out.println(s1.getPerimeter());    
		System.out.println(s1.getColor());
		System.out.println(s1.isFilled());
		//System.out.println(s1.getRadius());
		   
		// Downcast back to AbstractCircle
		Circle2 c1 = (Circle2) s1;                 
		System.out.println(c1);
		System.out.println(c1.getArea());
		System.out.println(c1.getPerimeter());
		System.out.println(c1.getColor());
		System.out.println(c1.isFilled());
		System.out.println(c1.getRadius());
		
		//AbstractShape s2 = new AbstractShape(); // Error: Cannot instantiate the type AbstractShape
		   
		
		Shape2 s3 = new Rectangle2(1.0, 2.0, "RED", false); 
		System.out.println(s3);
		System.out.println(s3.getArea());
		System.out.println(s3.getPerimeter());
		System.out.println(s3.getColor());
		//System.out.println(s3.getLength());
		
		// Downcast
		Rectangle2 r1 = (Rectangle2)s3;  
		System.out.println(r1);
		System.out.println(r1.getArea());
		System.out.println(r1.getColor());
		System.out.println(r1.getLength()); // --> OK
		   
		// Upcast
		Shape2 s4 = new Square2(6.6);    
		System.out.println(s4);
		System.out.println(s4.getArea());
		System.out.println(s4.getColor());
		//System.out.println(s4.getSide());
		  
		// Take note that we downcast Shape s4 to Rectangle, 
		// which is a superclass of Square, instead of Square
		Rectangle2 r2 = (Rectangle2)s4;
		System.out.println(r2);
		System.out.println(r2.getArea());
		System.out.println(r2.getColor());
		//System.out.println(r2.getSide()); --> doesn't has this method
		System.out.println(r2.getLength());
		   
		// Downcast Rectangle r2 to Square
		Square2 sq1 = (Square2)r2;
		System.out.println(sq1);
		System.out.println(sq1.getArea());
		System.out.println(sq1.getColor());
		System.out.println(sq1.getSide()); // --> OK
		System.out.println(sq1.getLength());
	}
}
