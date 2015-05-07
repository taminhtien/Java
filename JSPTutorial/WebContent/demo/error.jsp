<%@ page isErrorPage="true" import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>
	<h2>Some error in page</h2>
	Message:
	<%=exception.getMessage()%>
	<h3>StackTrace</h3>
	<%
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		exception.printStackTrace(printWriter);
		out.println("<pre>");
		out.println(stringWriter);
		out.println("</pre>");
		printWriter.close();
		stringWriter.close();
	%>
</body>
</html>