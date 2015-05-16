<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Html Form</title>
</head>
<body>
	<h3>User register</h3>
	<div style="width: 400px; padding: 10px">
		<form method="GET" action="formProcessing.jsp">
			User Name: <input type="text" name="userName" value="">
			<br>
			Password: <input type="password" name="password" value="">
			
			<hr>
			First Name: <input type="text" name="firstName" value="">
			<br>
			Last Name: <input type="text" name="lastName" value="">
			<br>
			Gender: <input type="radio" name="gender" value="M"> Male
				    <input type="radio" name="gender" value="F"> Female
			
			<hr>
			Address:
			<br>
			<input type="text" name="address" size = "50">
			<input type="text" name="address" size = "50">
			<input type="text" name="address" size = "50">
			
			<hr>
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>