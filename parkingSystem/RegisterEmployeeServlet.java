package com.parkingSystem;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Servlet for register the employee on data base.
 */
@WebServlet("/RegisterEmployee")
public class RegisterEmployeeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
		    String name = request.getParameter("name").trim();
		    String email = request.getParameter("email").trim();
		    String gender = request.getParameter("gender");
		    String password = request.getParameter("password");
		    long  contactNumber = Long.parseLong(request.getParameter("ContactNumber"));
		    String organization = request.getParameter("organization");
		
		     statement = null;
		 
		    String query1 = Query.getOrganizationId(organization); 
		    
		    statement = Statements.getPrepareStatement(query1);
		     rs = statement.executeQuery(query1);
		    int organizationId = 0 ;
		    while(rs.next()) {
		    	organizationId = rs.getInt("Id");
		    }
		    if(rs != null){
			rs.close();
		    }
		    statement.close();
		    Statements.close();
		    
		    String query2 = Query.insertEmployeeDetails();
			statement = Statements.getPrepareStatement(query2);
			statement.close();
			statement.setString (1, name);
			statement.setString (2, email);
			statement.setString (3, gender);
			statement.setString (4, password);
			statement.setLong (5, contactNumber);
			statement.setInt (6, organizationId);
			statement.execute();
              Statements.close(); 
	           int empId = 0; 
              String query3 = Query.getEmployeeId();
              statement = Statements.getPrepareStatement(query3);
              statement.setString(1, email);
              rs = statement.executeQuery();
              while(rs.next()) {
  		    	 empId = rs.getInt("Id");
  		    	 
  		      }
              
              if(empId == 0){
            	  throw new Exception("Employee is not registered.");
              }
              
              if(rs != null){
      			rs.close();
      		    }
      		    Statements.close();
              RequestDispatcher rd = request.getRequestDispatcher("VehicleForm?empId="+empId);
              rd.forward(request, response);	
		} catch (SQLException e) {
		    e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
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
