package com.tientm.tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet(urlPatterns = { "/Hello" }, initParams = { @WebInitParam(name = "name", value = "Guest") })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Để lấy giá trị từ initParams, ta dùng this.getInitParameter
		// Lấy giá trị từ queryString, dùng request.getParameter
		String name = this.getInitParameter("name");
		//String name = (String) request.getParameter("name");
		System.out.println(name);
		ServletOutputStream out = response.getOutputStream();
		out.print("<html>");
		out.print("<head><title>Hello Servlet</title></head>");

		out.print("<body>");
		out.print("<h1>Hello " + name + "</h1>");
		out.print("</body>");
		out.print("<html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
