<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Vehicle Details Form</title>
</head>
<body>
	<div align="center">
		<form:form modelAttribute="vehicleDTO">
			<h1>Vehicle Form</h1>
			<br/>
					Vehicle Name :
					<form:input path="VehicleName" /><br/>
					<form:errors path="VehicleName" cssClass="text-danger"></form:errors><br/>
			
					Vehicle Type :
					<form:select path="VehicleType">
							<form:option value="cycle" label="Cycle" />
							<form:option value="twoWheeler" label="Two Wheeler" />
							<form:option value="fourWheeler" label="Four Wheeler" />
						</form:select>
						<br/><br/>
				
					Vehicle Number :
					<form:input path="vehicleNumber" /><br/>
					<form:errors path="vehicleNumber" cssClass="text-danger"></form:errors><br/>
				
					Employee Id :
					<form:input path="employeeId" value="${empId}" type="Number" readonly="true"/><br/>
					<form:errors path="employeeId" cssClass="text-danger" ></form:errors><br/>
				
					Vehicle Identification :
					<form:textarea path="identification" /><br/>
					<form:errors path="identification" cssClass="text-danger"></form:errors><br/>
			
			<button type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>