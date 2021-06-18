<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >


</head>
<body>
<div class="container">
    <div class="jumbotron text-center">
    <h1>Student Management System</h1>
    </div>
    <c:if test="${not empty name}">
      <h1>Hello.... ${name}</h1>
</c:if>
		
		<br><br>
			<a href="./allstudents" style="background-color:#0F2E92;padding:15px;border-radius:4%;color:white;text-decoration:none;">Get All Student details</a>
			<br>
			<br>
		
			<table class="table table-bordered">
  <thead>
    <tr>
      
      <th scope="col">Student Id</th>
      <th scope="col">Student Name</th>
      <th scope="col">Course</th>
      <th scope="col">Delete</th>
      <th scope="col">Modify</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${list}" var="stud">
	<tr>
	<td><c:out value="${stud.sid }"/></td>
	<td><c:out value="${stud.sname }"/></td>
	<td><c:out value="${stud.course }"/></td>
	<td><a href="./delete?id=${stud.sid }" >delete</a>
	<td><a href="./modify?id=${stud.sid}">modify</a>
	</tr>
	</c:forEach>
   
  </tbody>
</table>
			
			
			
		</div>
			
			</div>
		
		
</body>
</html>