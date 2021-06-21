<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>	
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>  
body{
 margin:0 auto;
 text-align: center }
</style>
</head>
<body>
<h1>Registration page</h1>
	<h1>	${msg}</h1>
<form:form method="get" action="save" modelAttribute="employee"><br><br>
	
	Employee Name:<form:input path="emp_name"/><br><br>
	Department: <form:input path="department"/><br><br>

<input type="submit" value="Register">


</form:form>
<br>
<a href="./loginpage" >login</a>
</body>
</html>
