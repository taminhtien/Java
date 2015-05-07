package com.tientm.tutorial.servlet.logindemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tientm.tutorial.beans.Constants;

@WebServlet("/loginForm")
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginFormServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();

		// Lấy thông tin trang callback được gửi từ Filter, hoặc nơi khác
		String callbackURL = (String) request.getAttribute("callbackURL");

		// contextPath luôn luôn là "" hoặc "/contextPath"
		// vd: "/ServletTutorial/doLogin"
		String actionPath = request.getContextPath() + "/doLogin";

		out.println("<html>");
		out.println("<head><title>Login Form</title></head>");
		out.println("<body>");

		out.println("Type UserName and Password");
		out.println("<form action='" + actionPath + "' method='post'>");
		out.println("User name:");
		out.println("<input name='userName' type='text' value=''>");
		out.println("<br>");
		out.println("Password: ");
		out.println("<input name='password' type='password' value=''>");

		if (callbackURL != null) {
			out.println("<input name='callbackURL' type='hidden' value='"
					+ callbackURL + "'>");
		}

		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
