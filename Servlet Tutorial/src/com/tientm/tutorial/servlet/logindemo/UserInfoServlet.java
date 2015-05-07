package com.tientm.tutorial.servlet.logindemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tientm.tutorial.beans.Constants;
import com.tientm.tutorial.beans.UserInfo;

@WebServlet("/info/userInfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInfoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		// Lấy ra đối tượng UserInfo đã ghi vào session
		// tại thời điểm đăng nhập thành công
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

		ServletOutputStream out = response.getOutputStream();
		out.println("Hi " + userInfo.getUserName());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
