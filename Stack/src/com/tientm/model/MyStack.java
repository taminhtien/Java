package com.tientm.model;

import java.util.ArrayList;

public class MyStack {
	ArrayList<Object> stackValues;

	
	public MyStack() {
		super();
		stackValues = new ArrayList<Object>();
	}

	public String toString() {
		return "MyStack [stackValues=" + stackValues + "]";
	}
	
	public ArrayList<Object> getStackValues() {
		return stackValues;
	}

	public void setStackValues(ArrayList<Object> stackValues) {
		this.stackValues = stackValues;
	}
	
	public void push(Object arg0) {
		int top = stackValues.size();
		stackValues.add(top, arg0);
	}
	
	public Object get(int pos) {
		if (pos < stackValues.size())
			return stackValues.get(pos);
		else
			return null;
	}
	
	public void pop() {
		int top = stackValues.size();
		if (top != 0)
			stackValues.remove(top - 1);
	}
}
