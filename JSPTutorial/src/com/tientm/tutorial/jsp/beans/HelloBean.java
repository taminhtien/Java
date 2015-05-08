package com.tientm.tutorial.jsp.beans;

public class HelloBean {
	private String name;
	
	// Bắt buộc phải có một cấu tử không tham số
	public HelloBean() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHello2() {
		if (name == null) {
			return "Hello everybody";
		}
		return "Hello " + name;
	}
}
