package com.tientm.model;

public class ResizableCircle extends Circle implements Resizable {

	public double resize(int percent) {
		return radius * percent;
	}

	public ResizableCircle(double radius) {
		//this.radius = radius;
		super(radius);
	}
	
	public ResizableCircle() {
	}
}
