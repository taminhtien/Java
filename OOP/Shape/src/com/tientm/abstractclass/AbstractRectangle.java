package com.tientm.abstractclass;

public class AbstractRectangle extends AbstractShape {

	protected double width;
	protected double length;
	
	public AbstractRectangle() {
		width = 1;
		length = 2;
	}
	
	public AbstractRectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

}
