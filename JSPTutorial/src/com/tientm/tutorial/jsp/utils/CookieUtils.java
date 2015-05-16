package com.tientm.tutorial.jsp.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class CookieUtils {
	public static void demoUserCookie(HttpServletRequest request,
			HttpServletResponse response, JspWriter out) throws IOException {
		boolean found = false;

		// Danh sách các cookies được website này lưu vào máy tính người dùng
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			String userName = null;
			String lastLoginDatetime = null;
			out.println("<h3>Cookies: </h3>");

			for (int i = 0; i < cookies.length; i++) {
				out.println(cookies[i].getName() + " : "
						+ cookies[i].getValue() + "<br>");
				if (cookies[i].getName().equals("userName")) {
					userName = cookies[i].getValue();
				} else if (cookies[i].getName().equals("lastLoginDatetime")) {}
					lastLoginDatetime = cookies[i].getValue();
			}
			if (userName != null) {
				found = true;
				out.print("<h4>Last login info:</h4>");
				out.print("User Name: " + userName + "<br>");
				out.print("Last Login Datetime: " + lastLoginDatetime + "<br>");
			}
		}
		if (!found) {
			out.println("No cookies founds!, write some cookies into client computer</h3>");
			String userName = "someUserName";
			Cookie cookieUserName = new Cookie("userName", userName);
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date now = new Date();
			String lastLoginDatetime = df.format(now);
			Cookie cookieLonginDatetime = new Cookie("lastLoginDatetime", lastLoginDatetime);
			
			// Set thoi gian song la 24h
			cookieUserName.setMaxAge(24 * 60 * 60);
			cookieLonginDatetime.setMaxAge(24 * 60 * 60);
			response.addCookie(cookieUserName);
			response.addCookie(cookieLonginDatetime);
		}
	}
}

