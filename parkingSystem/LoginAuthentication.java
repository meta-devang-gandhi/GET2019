package com.parkingSystem;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginAuthentication")
public class LoginAuthentication extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		 PreparedStatement statement = null;
		try{
			System.out.println("login authentic");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			String query = Query.getEmployeePasswordWithId();
			 statement = Statements.getPrepareStatement(query);
			 statement.setString(1, email);
			 ResultSet rs = statement.executeQuery();
			
			 int empId = 0;
			 String fetchPassword = null;
			try{
				while(rs.next())
				{
				 empId = rs.getInt("Id");
				 fetchPassword = rs.getString("password");
				}
			}catch(SQLException e){
				// response.getWriter().println("Sorry, email is wrong !");  
				System.out.println("email wromg  "+e.getMessage());
		          request.getRequestDispatcher("LoginPage.html").forward(request, response);	 
			}
			
			if(password.equals(fetchPassword)){
				System.out.println("passowrd come");
				 request.getRequestDispatcher("HomePage?empId="+empId).include(request, response);
			}else{
				// response.getWriter().println("Sorry, password is wrong !");  
				System.out.println("password wromg  ");
		          request.getRequestDispatcher("LoginPage.html").include(request, response);	
			}
			
		}catch(Exception e)
		{
			try {
				response.getWriter().println(e.getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
