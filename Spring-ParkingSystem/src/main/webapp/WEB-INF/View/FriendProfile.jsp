<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Friend Profile Page</title>
</head>
<body align = "center">
	<h4>Friend Profile :</h4>
	<form:form>
		<table  align = "center">
			<tr>
			     <td>Name:</td>
				<td>${friendDetails.getName()}</td>
			</tr>	
			<tr>
				<td>Gender:</td>
				<td>${friendDetails.getGender()}</td>
				</tr>	
				<tr>
				<td>Email:</td>
				<td>${friendDetails.getEmail()}</td>
				</tr>	
				<tr>
				<td>Contact Number:</td>
				<td>${friendDetails.getContactNumber()}</td>
				</tr>	
				<tr>
				<td>Organization:</td>
				<td>${friendDetails.getOrganization()}</td>
				</tr>	
				<tr>
				<td>VehicleName:</td>
				<td>${friendDetails.getVehicleName()}</td>
				</tr>	
				<tr>
				<td>VehicleNumber:</td>
				<td>${friendDetails.getVehicleNumber()}</td>
				</tr>	
				<tr>
				<td>VehicleType:</td>
				<td>${friendDetails.getVehicleType()}</td>
				</tr>	
				<tr>
				<td>VehicleIdentification:</td>
				<td>${friendDetails.getVehicleIdentification()}</td>
				</tr>
				<tr>	
				<td>Pass Rate:</td>
				<td>${friendDetails.getPassRate()}</td>
				
			</tr>
		</table>
	</form:form>
</body>
</html>

