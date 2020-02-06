package com.parkingSystem;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class UpdateOnDataBase extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		ServletContext context=getServletContext();  
		 PreparedStatement statement = null;
		try {
			int empId = (int) context.getAttribute("empId");
			    String query = Query.updateEmployeeDetails();  
			    statement = Statements.getPrepareStatement(query);
			    statement.setString(1, request.getParameter("name"));
			    statement.setString(2, request.getParameter("email"));
			    statement.setLong(3, Long.parseLong(request.getParameter("ContactNumber")));
			    statement.setString(3, request.getParameter("vehicleType"));
			    statement.setString(4, request.getParameter("vehicleNumber"));
			    statement.setString(5, request.getParameter("vehicleIdentification"));
			    statement.setInt(6,  empId);
			    
			    if(statement.executeUpdate() > 0) {
			    	RequestDispatcher rd=request.getRequestDispatcher("HomePage?empId ="+empId); 
			    	rd.include(request, response);
			    }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
				try {
					if(statement != null){
							statement.close();
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
