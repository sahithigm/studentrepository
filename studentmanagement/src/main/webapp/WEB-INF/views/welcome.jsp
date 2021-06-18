<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
		<h1> welcome ${name}</h1>
		<br><br>
			<a href="./allstudents">Get all student details</a>
			<br>
			<br>
		
	<table >
	<tr>
	<th>Student id</th>
	<th>Student name</th>
	<th>Branch</th>
	</tr>
	<c:forEach items="${list}" var="stu">
	<tr>
		<td>${stu.stdId}</td>
		<td><c:out value="${stu.name}" /></td>
		<td><c:out value="${stu.branch}" /></td>
		<td><a href="./delete?id=${stu.stdId}" >delete</a>
		<td><a href="./modify?id=${stu.stdId}">modify</a>
	</tr>
	</c:forEach>
	
	</table>	
					
</body>
</html>