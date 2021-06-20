
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style>
   table, th, td {
  border: 1px solid black;  
margin-left: auto;  
margin-right: auto;  
border-collapse: collapse;    
width: 500px;  
text-align: center;  
font-size: 20px;  
}
body{ margin:0 auto;
text-align: center }
</style>
</head>
<body>
	<h1>welcome ${name}</h1>
	<br>
	<br>
	<a href="./allemployees">Get All Employee details</a>
	<br>
	<br>

	<table style="border:1px solid black">
		<tr>
			<th>Employee id</th>
			<th>Employee name</th>
			<th>Employee Department</th>
		<tr>
			<c:forEach items="${list }" var="emp">
				<tr>
					<td><c:out value="${emp.emp_id }" /></td>
					<td><c:out value="${emp.emp_name }" /></td>
					<td><c:out value="${emp.department}" /></td>
					<td><a href="./delete?id=${emp.emp_id }">delete</a>
					<td><a href="./modify?id=${emp.emp_id}">modify</a>
				</tr>
			</c:forEach>
	</table>
</body>
</html>