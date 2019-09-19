<!-- 
     Jsp page to show the student. 
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
</head>
<body>
	<div align="center">
		<form:form modelAttribute="student">
			<br>
			<h3>List Of Student</h3>
			<table border="1">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Father Name</th>
					<th>Email</th>
					<th>Class</th>
					<th>Age</th>
				</tr>
				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td>${student.fatherName}</td>
						<td>${student.email}</td>
						<td>${student.studentClass}</td>
						<td>${student.age}</td>
					</tr>
				</c:forEach>
			</table>
		</form:form>
	</div>
</body>
</html>