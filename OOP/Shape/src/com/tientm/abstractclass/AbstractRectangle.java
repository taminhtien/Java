package com.tientm.abstractclass;

import java.awt.HeadlessException;

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
	
	public AbstractRectangle(double width, double length, String color, boolean filled) {
		this.width = width;
		this.length = length;
		this.color = color;
		this.filled = filled;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double getArea() {
		return width * length;
	}

	@Override
	public double getPerimeter() {
		return 2 * (width + length);
	}

	@Override
	public String toString() {
		return "AbstractRectangle [width=" + width + ", length=" + length + "]";
	}

	
}
