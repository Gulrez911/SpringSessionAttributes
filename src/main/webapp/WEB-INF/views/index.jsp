<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		Welcome 
<a href="test">Change Page</a>
		<form:form action="register" method="post" modelAttribute="std">
First Name: <form:input path="fname" />
Last Name: <form:input path="lname" />
Email:<form:input path="email" />
Password:<form:password path="password" />
				<input type="submit" value="Submit" />
		</form:form>
</body>
</html>