package com.tientm.abstractclass;

public class Square2 extends Rectangle2 {
	
	public Square2() {
		super();
	}
	
	public Square2(double side) {
		super(side, side);
	}
	
	public Square2(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}
	
	public double getSide() {
		return super.getLength();
	}
	
	public void setSide(double side) {
		super.setLength(side);
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
}
