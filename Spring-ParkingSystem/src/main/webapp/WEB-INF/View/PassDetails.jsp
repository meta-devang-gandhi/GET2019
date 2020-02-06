<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h2>Select plan</h2>
      <table border ="1">
	      <tr>
	         <th>Plan</th>
	         <th>Price</th>
	      </tr>
	          <c:forEach items = "${priceList}" var = "price"> 
	          <tr>
	            <td> ${price.value}</td>
	             <td>${price.key}</td>
	          </tr>
	       </c:forEach>
      </table>
      <br/>
        <form:form modelAttribute="pass">
        Chose Plan:
          <form:select path="rate" >
             <form:options items="${priceList}"/>
             <form:errors path="rate"></form:errors>
          </form:select>
           
           <button type="submit">Get Pass</button>
        </form:form>
    </div>
 </body>
</html>