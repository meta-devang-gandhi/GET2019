package com.parkingSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Sevlet of home page.
 *In which show the employee information.
 */
@WebServlet("/HomePage")
public class HomePage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response){
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			PrintWriter out = response.getWriter();
			int empId = Integer.parseInt(request.getParameter("empId"));
			String query = Query.getEmployeeInformation();
			 statement = Statements.getPrepareStatement(query);
		
			System.out.println("empId =" +empId);
			statement.setInt(1, empId);
			
			 rs = statement.executeQuery();
			String name = null, email = null, vehicleType = null, vehicleNumber = null, vehicleIdentification = null ;
			long contactNumber = 0;
			int OrganizayionId = 0; 
			while(rs.next())
			{
				name = rs.getString("FullName");
				email = rs.getString("email");
				contactNumber = rs.getLong("ContactNumber");
				vehicleType = rs.getString("type");
				vehicleNumber = rs.getString("Number");
				vehicleIdentification = rs.getString("Identification");
				OrganizayionId = rs.getInt("OrganizationId");
			}
			
			ServletContext context=getServletContext();  
			context.setAttribute("empId", empId);
			context.setAttribute("name",name);
			context.setAttribute("email",email);
			context.setAttribute("contactNumber",contactNumber);
			context.setAttribute("vehicleType",vehicleType);
			context.setAttribute("vehicleNumber",vehicleNumber);
			context.setAttribute("vehicleIdentification",vehicleIdentification);
			context.setAttribute("OrganizayionId",OrganizayionId);
			
			out.println("<p align = 'center'>Welecom "+name+" </p>");
			out.println("<div align= 'left'><input type = 'submit' value = 'Friendlist' onclick = \"window.location.href= 'FriendList'\"/></div>");
			out.println("<div align= 'right'><input type = 'submit' value = 'Logout' onclick = \"window.location.href= 'Logout'\"/></div>");
			out.println("<ul>"
					+ "<li> Name = "+name+"<li>"
					+ "<li> Email = "+email+"<li>"
					+ "<li> ContactNumber = "+contactNumber+"<li>"
					+ "<li> VehicleType = "+vehicleType+"<li>"
					+ "<li> vehicleNumber = "+vehicleNumber+"<li>"
					+ "<li> vehicleIdentification = "+vehicleIdentification+"<li>"
					+ "</ul><br/	>");
			
			out.println("<input type ='submit' value = 'update' onclick = \"window.location.href= 'UpdateDetailsPage'\"/>");
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
				try {
					if(statement != null){
							statement.close();
						} 
					if(rs != null){
						rs.close();
					}
					Statements.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
			 }
		   }
	 }	
}
