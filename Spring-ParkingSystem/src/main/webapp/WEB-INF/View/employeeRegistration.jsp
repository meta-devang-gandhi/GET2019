<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
<title>Student Detail Page</title>
</head>
<body>
   
<div align="center">
		<form:form modelAttribute="employeeDTO" >
		
			<h2>Employee Registration</h2>
	
			<form:errors cssClass="text-danger"></form:errors>
			<br>
		
					Full Name:
					<form:input path="fullName"  /><br/>
					<form:errors path = "fullName" cssClass="text-danger"></form:errors>
					<br/>
				
				    Gender:
					<form:radiobutton  path="gender" value="male"/>Male 
                    <form:radiobutton  path="gender" value="female"/>Female
                    <form:radiobutton  path="gender" value="other"/>Other
                    <br/><br/>
		
					Email:
					<form:input path="email" /><br/>
			    	<form:errors path = "email" cssClass="text-danger"></form:errors>
			    	<br/>
				
					Password:
					<form:password path="password"/><br/>
					<form:errors path = "password" cssClass="text-danger"></form:errors>
			    	<br/>
			    	
			    	Confirm Password:
					<form:password path="confirmPassword"/><br/>
					<form:errors path = "confirmPassword" cssClass="text-danger"></form:errors>
			    	<br/>
			    	
			    	Contact Number:
					<form:input path="contactNumber" type = "Number" /><br/>
					<form:errors path = "contactNumber" cssClass="text-danger"></form:errors>
					<br/>
					
					Organization:
					<form:select path="organization">
							<form:option value="metacube" label="Metacube" />
							<form:option value="facebook" label="Facebook" />
							<form:option value="instagram" label="Instagram" />
							<form:option value="google" label="Google" />
					</form:select>
		            <br/>
		
		      <br/>
			<button type="submit">Submit</button>
			<h4>
				<a href='/LoginPage'>Login Here</a>
			</h4>
		</form:form>
	</div>
</body>
</html>