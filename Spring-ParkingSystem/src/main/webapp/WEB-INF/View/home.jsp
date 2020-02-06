<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Home page</title>
</head>
<body align = "center">
	<h4>Welcome ${empDetails.getName()} </h4>
	<form:form>
		<table  align = "center">
			<tr>
			     <td>Name:</td>
				<td>${empDetails.getName()}</td>
			</tr>	
			<tr>
				<td>Gender:</td>
				<td>${empDetails.getGender()}</td>
				</tr>	
				<tr>
				<td>Email:</td>
				<td>${empDetails.getEmail()}</td>
				</tr>	
				<tr>
				<td>Contact Number:</td>
				<td>${empDetails.getContactNumber()}</td>
				</tr>	
				<tr>
				<td>Organization:</td>
				<td>${empDetails.getOrganization()}</td>
				</tr>	
				<tr>
				<td>VehicleName:</td>
				<td>${empDetails.getVehicleName()}</td>
				</tr>	
				<tr>
				<td>VehicleNumber:</td>
				<td>${empDetails.getVehicleNumber()}</td>
				</tr>	
				<tr>
				<td>VehicleType:</td>
				<td>${empDetails.getVehicleType()}</td>
				</tr>	
				<tr>
				<td>VehicleIdentification:</td>
				<td>${empDetails.getVehicleIdentification()}</td>
				</tr>
				<tr>	
				<td>Pass Rate:</td>
				<td>${empDetails.getPassRate()}</td>
				
			</tr>
		</table>
		<br>
		<a href="/EditPage?Email=${empDetails.getEmail()}"><input type = "button" value = "Edit" /></a>
       
		<a href="/FriendPage?Email=${empDetails.getEmail()}"><input type="button" value="Friends"/></a>
		<a href="/LogOutPage"><input type="button" value="Log Out"/></a>
		
	</form:form>
</body>

</html>