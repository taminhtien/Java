package com.tientm.test;

import com.tientm.model.MyStack;

public class Main {
	public static void main(String[] args) {
		MyStack ms = new MyStack();
		String s1 = "Linux";
		String s2 = "Vo Chi Thong";
		String s3 = "Le Minh Phu";
		ms.pop();
		System.out.println(ms.toString());
		ms.push(s1);
		System.out.println(ms.toString());
		ms.pop();
		ms.push(s2);
		ms.push(s3);
		System.out.println(ms.toString());
		ms.pop();
		System.out.println(ms.toString());
		Object value = ms.get(1);
		System.out.println(value != null? value.toString() : "NULL");
	}
}
