package com.parkingSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateDetailsPage")
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void service(HttpServletRequest request, HttpServletResponse response)  {
		System.out.println("update page");
		ServletContext context=getServletContext();  
		PrintWriter out;
		try {
				out = response.getWriter();
			
	//		response.getWriter().println(context.getAttribute("name"));
	//		response.getWriter().println(context.getAttribute("email"));
	//		response.getWriter().println(context.getAttribute("empId"));
	//		response.getWriter().println(context.getAttribute("vehicleType"));
			String name = null, email = null, vehicleType = null, vehicleNumber = null, vehicleIdentification = null ;
			long ContactNumber = 0;
			name = (String) context.getAttribute("name");
			email = (String) context.getAttribute("email");
			vehicleType = (String) context.getAttribute("vehicleType");
			vehicleNumber = (String) context.getAttribute("vehicleNumber");
			vehicleIdentification = (String) context.getAttribute("vehicleIdentification");
			ContactNumber = (long) context.getAttribute("contactNumber");
			out.println("<div align= 'center'>");
			out.println("<h1>Update Form</h1>");
	//        int empId = Integer.parseInt(request.getParameter("empId"));
	//		out.print("<form action='./InsertVehicleData?empId="+empId+"' method='post'>");  
	        
			out.println("<form action ='Update' method='get'>");
			out.print("Full Name:<input name='name' value="+name+" minlength='2'  /><br><br>");
			out.print("Email:<input name='email' value="+email+"  /><br><br>");
			out.print("Vehicle Type:<input name='vehicleType' value="+vehicleType+"  /><br><br>");
			out.print("Vehicle Number:<input name='vehicleNumber' value="+vehicleNumber+"  /><br><br>");
			out.print("Vehicle Identification:<input name='vehicleIdentification' value="+vehicleIdentification+"  /><br><br>");
			out.print("Contact Number:<input name='ContactNumber' value="+ContactNumber+"  /><br><br>");
		
			out.print("<input type='submit' value='Update'>");  
			out.println("</form>");
			out.println("</div>");
		
	     } catch (IOException e) {
		// TODO Auto-generated catch block
		      e.printStackTrace();
		      System.out.println(e.getMessage());
	       }
	}
}
