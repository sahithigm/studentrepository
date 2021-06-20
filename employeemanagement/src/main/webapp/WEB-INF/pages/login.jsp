<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
  
body{ margin:0 auto;
text-align: center }
</style>
</head>
<body>
<div>
	<form:form method="post" action="./validatelogin" modelAttribute="loginob"><br><br>
	Employee ID: <form:input path="emp_id"/><br><br>
	Employee Name:<form:input path="emp_name"/><br><br>
	

<input type="submit" value="login">

</form:form>
</div>

</body>
</html>