package com.tientm.tutorial.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tientm.tutorial.beans.Constants;

@WebServlet("/other/forwardDemo")
public class ForwardDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForwardDemoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Lấy parameter trên URL
		String redirect = request.getParameter("forward");
		if ("true".equals(redirect)) {
			System.out.println("Forward to ShowMeServlet");

			// Có thể gởi dữ liệu sang trang mới
			request.setAttribute(Constants.ATTRIBUTE_SHOW_ME_KEY,
					"Hi, I'm Tien!");

			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/showMe");
			
			dispatcher.forward(request, response);
			return;
		}

		ServletOutputStream out = response.getOutputStream();
		out.println("<h3>Text of ForwardDemoServlet</h3>");
		out.println("- servletPath = " + request.getServletPath());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
