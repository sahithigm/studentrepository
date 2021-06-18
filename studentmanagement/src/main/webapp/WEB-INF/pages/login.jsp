<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
</head>
<body>

<div class="container">
<div class="jumbotron text-center">
<h1>Student Management System</h1>
</div>


<form:form class="form-group"  method="post" action="./validatelogin" modelAttribute="loginob">
			<div class="form-group row">
				<label for="Name" class="col-sm-12 col-lg-2 col-form-label">Student Id:</label>
                <form:input type="text" class="form-control col-sm-12 col-lg-10" path="sid"/>
			</div>
			<div class="form-group row">
				<label for="pwd" class="col-sm-12 col-lg-2">Password:</label>
		
                 <form:input type="password" class="form-control col-sm-12 col-lg-10" path="password"/>
			</div>
			<div class="form-group col-sm-12 row">
				<input type="submit" class="btn btn-success col-sm-12 col-lg-5" value="Login">
                <div class="col-lg-2"></div>
                <input type="reset" class="btn btn-warning col-sm-12 col-lg-5" value="Reset">
			</div>
		</form:form>
			

</div>

</body>
</html>