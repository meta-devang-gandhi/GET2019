<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Friends</title>
</head>
<body align = "center">
		<form:form>
			<h3>Friends</h3>
			<table border = "1" align = "center">
				<tr>
					<td>Name</td>
					<td>Email</td>
					<td>Profile</td>
				</tr>
				<c:forEach items="${friendsList}" var="friend">
					<tr>
						<td>${friend.getFullName()}</td>
						<td>${friend.getEmail()}</td>
						<td><a href="/FriendProfile?email=${friend.getEmail()}">Profile</a></td>
					</tr>
				</c:forEach>
			</table>
		</form:form>
</body>
</html>