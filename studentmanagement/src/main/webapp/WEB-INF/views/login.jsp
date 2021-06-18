<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<div>
	<form:form method="post" action="./validatelogin" modelAttribute="loginob"><br><br>
	Student ID: <form:input path="stdId"/><br><br>
	Student Name:<form:input path="name"/><br><br>
	<input type="submit" value="login">
</form:form>
</div>

</body>
</html>