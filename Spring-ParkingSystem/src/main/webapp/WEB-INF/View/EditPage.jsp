<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Update Details Form</title>
</head>
<body>
	<div align="center" id="reg">
		<form:form modelAttribute="employeeDetails">
		<form:errors cssClass="text-danger"></form:errors>
			<h1>Update Details</h1>
			<table>
				<tr>
					<td>Name :</td>
					<td><form:input path="Name" value="${employeeDetails.getName()}"/></td>
					<td><form:errors path="Name" cssClass="text-danger"></form:errors>
				</tr>
				<tr>
					<td>Gender :</td>
					<td><form:select path="Gender" value="${employeeDetails.getGender()}">
							<form:option value="male" label="Male" />
							<form:option value="female" label="feMale" />
							<form:option value="other" label="Other" />
						</form:select></td>
				</tr>
		
				<tr>
					<td>Contact Number :</td>
					<td><form:input path="ContactNumber" value="${employeeDetails.getContactNumber()}"/></td>
					<td><form:errors path="ContactNumber" cssClass="text-danger"></form:errors>
				</tr>
				<tr>
					<td>Organization :</td>
					<td><form:select path="Organization" value="${employeeDetails.getOrganization()}">
							<form:option value="metacube" label="Metacube" />
							<form:option value="facebook" label="Facebook" />
							<form:option value="instagram" label="Instagram" />
							<form:option value="google" label="Google" />
						</form:select></td>
				</tr>
				<tr>
					<td>Vehicle Name :</td>
					<td><form:input path="VehicleName" value="${employeeDetails.getVehicleName()}"/></td>
					<td><form:errors path="VehicleName" cssClass="text-danger"></form:errors>
				</tr>
				
				<tr>
					<td>Vehicle Number :</td>
					<td><form:input path="VehicleNumber" value="${employeeDetails.getVehicleNumber()}"/></td>
					<td><form:errors path="VehicleNumber" cssClass="text-danger"></form:errors>
				</tr>

				<tr>
				    <td> Vehicle Type :</td>
					<td><form:select path="VehicleType" value ="${employeeDetails.getVehicleType()}">
							<form:option value="cycle" label="Cycle" />
							<form:option value="twoWheeler" label="Two Wheeler" />
							<form:option value="fourWheeler" label="Four Wheeler" />
						</form:select></td>
						
				</tr>
				<tr>
					<td>Vehicle Identification :</td>
					<td><form:input path="VehicleIdentification" value="${employeeDetails.getVehicleIdentification()}"/></td>
					<td><form:errors path="VehicleIdentification" cssClass="text-danger"></form:errors>
				</tr>
			</table>
			<br>
			<button type="submit">Update</button>
			<br>
		</form:form>
	</div>
</body>
</html>