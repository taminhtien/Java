package com.tientm.tutorial.servlet.logindemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tientm.tutorial.beans.UserInfo;

// Kiểm tra đăng nhập hợp lệ không
@WebServlet("/doLogin")
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String callbackURL = request.getParameter("callbackURL");

		if (userName != null && userName.length() > 0 && "123".equals(password)) {
			System.out.println("Login ok");

			UserInfo userInfo = new UserInfo(userName);
			HttpSession session = request.getSession();

			// Ghi userInfo vào session
			session.setAttribute("userInfo", userInfo);

			if (callbackURL != null) { // Đã login rồi
				// Redirect to callbackURL
				response.sendRedirect(callbackURL);
				return;
			} else {
				// Login thành công - > redirect to UserInfoServlet
				response.sendRedirect(request.getContextPath()
						+ "/info/userInfo");
			}
		} else {
			// Ghi lại callbackURL vào request Attribute
			request.setAttribute("callbackURL", callbackURL);
			// Forward to LoginFormServlet để đăng nhập lại
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/loginForm");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
