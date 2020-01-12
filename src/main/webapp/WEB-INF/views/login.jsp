<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form:form action="authenticate" method="post" modelAttribute="student">
Email:<form:input path="email" />
Password:<form:password path="password" />
				<input type="submit" value="Login">
		</form:form>
</body>
</html>