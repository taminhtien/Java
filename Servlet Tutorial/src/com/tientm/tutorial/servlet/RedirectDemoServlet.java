package com.tientm.tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other/redirectDemo")
public class RedirectDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RedirectDemoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lấy parameter trên URL
		String redirect = request.getParameter("redirect");
		if ("true".equals(redirect)) {
			System.out.println("Redirect to ShowMeServlet");
			// ContextPath luôn luôn là "" hoặc "/contextPath"
			// ==> /ServletTutorial
			String contextPath = request.getContextPath();
			
			// Gọi hàm sendRedirect
			response.sendRedirect(contextPath + "/showMe"); 
		}
		
		ServletOutputStream out = response.getOutputStream();
		out.println("<h3>Text of RedirectDemoServlet</h3>");
		out.println("- servletPath = " + request.getServletPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
