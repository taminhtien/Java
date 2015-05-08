<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Use Bean</title>
</head>
<body>
	<jsp:useBean id="helloBean" class="com.tientm.tutorial.jsp.beans.HelloBean"></jsp:useBean>
	<h3>Say Hello: </h3>
	
	<!-- Dựa vào property gọi hàm "get + property" bên Java Bean -->
	<jsp:getProperty property="hello" name="helloBean"/>
	
	<!-- Set property name for helloBean -->
	<jsp:setProperty property="name" name="helloBean" value="JSP"/>
	<h3>Say Hello after setName: </h3>
	<jsp:getProperty property="hello" name="helloBean"/>
	
</body>
</html>