package com.tientm.tutorial.servlet;

// Redirect page
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tientm.tutorial.beans.Constants;

@WebServlet("/showMe")
public class ShowMeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowMeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Lấy giá trị trong Attribute gởi từ trang foward
		String value = (String) request
				.getAttribute(Constants.ATTRIBUTE_SHOW_ME_KEY);
		ServletOutputStream out = response.getOutputStream();
		out.println("<h1>ShowMeServlet</h1>");
		out.println(value);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
