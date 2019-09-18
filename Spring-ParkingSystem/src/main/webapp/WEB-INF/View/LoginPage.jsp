<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
<form:form modelAttribute="login">
		<form:errors cssClass="text-danger"></form:errors>
		<h5 class="text-danger">${msg}</h5>
		<h4>Login Here:</h4>
		<table>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="text-danger"></form:errors>
				<br/><br/>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="text-danger"></form:errors>
			</tr>
		</table>
		<br>
		<button type="submit">Login</button>
	</form:form>
</div>
</body>
</html>