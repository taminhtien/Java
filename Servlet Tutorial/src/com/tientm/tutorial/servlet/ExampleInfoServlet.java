package com.tientm.tutorial.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

// Get info from HttpServletRequest
// doGet get du lieu theo phuong thuc GET
// doPost get du lieu theo phuong thuc POST

@WebServlet("/other/exampleInfo")
public class ExampleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExampleInfoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		out.println("<style> span {color: blue;} </style>");
		
		String requestURL = request.getRequestURL().toString();
		out.println("<br><span>requestURL: </span>" + requestURL);
		
		String requestULI = request.getRequestURI();
		out.println("<br><span>requestURI: </span>" + requestULI);
		
		String contextPath = request.getContextPath();
		out.println("<br><span>contextPath: </span>" + contextPath);
		
		String servletPath = request.getServletPath();
		out.println("<br><span>servletPath: </span>" + servletPath);
		
		String queryString = request.getQueryString();
		out.println("<br><span>queryString: </span>" + queryString);
		
		String param1 = request.getParameter("text1");
		out.println("<br><span>getParameter text1: </span>" + param1);
		
		String param2 = request.getParameter("text2");
		out.println("<br><span>getParameter text2: </span>" + param2);

		// Server Infos
		out.println("<br><br><b>Server Infos: </b>");
		out.println("<br><span>serverName: </span>" + request.getServerName());
		out.println("<br><span>serverPort: </span>" + request.getServerPort());
		
		// Client Infos
		out.println("<br><br><b>Client Infos: </b>");
		out.println("<br><span>remoteAddr: </span>" + request.getRemoteAddr());
		out.println("<br><span>remoteHost: </span>" + request.getRemoteHost());
		out.println("<br><span>remotePort: </span>" + request.getRemotePort());
		out.println("<br><span>remoteUser: </span>" + request.getRemoteUser());
		
		// Header Infos
		out.println("<br><br><b>Headers: </b>");
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String string = (String) headers.nextElement();
			out.println("<br><span>" + string + "</span>: " + request.getHeader(string));
		}
		
		// Servlet Context Info
		out.println("<br><br><b>Servlet Context Info</b>");
		ServletContext servletContext = request.getServletContext();
		
		// Location of web application in hard disk
		out.println("<br><span>realPath: </span>" + servletContext.getRealPath(""));
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
