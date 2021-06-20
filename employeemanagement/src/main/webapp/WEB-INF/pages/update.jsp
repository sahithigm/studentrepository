<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form:form action="modify?id=${id}" method="POST" modelAttribute="employee">
	<center>
	<h1>${msg}</h1>
	Employee Name:<form:input path="emp_name"/><br><br>
	Department:<form:input path="department"/><br><br>
	<input type="submit" value="Update"/>
	</center>
</form:form>
   

</body>
</html>