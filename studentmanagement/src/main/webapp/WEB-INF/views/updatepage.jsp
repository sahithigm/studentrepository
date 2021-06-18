<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>

<form:form action="modify?id=${id}" method="POST" modelAttribute="student">
	<center>
	<h1>${msg}</h1>
	Student Name:<form:input path="name"/><br><br>
	Branch Name:<form:input path="branch"/><br><br>
	<input type="submit" value="Update"/>
	
</form:form>

</center>
</body>
</html>