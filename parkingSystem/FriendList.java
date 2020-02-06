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
 *Servlet of friend list of employee.
 *which employee's organization is same, which are friend . 
 */
@WebServlet("/FriendList")
public class FriendList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response){
		 PrintWriter out = null;
		 ServletContext context=getServletContext(); 
		 PreparedStatement statement =null;
		 ResultSet rs = null;
		 try {
			out = response.getWriter();
			int OrganizationId = (int) context.getAttribute("OrganizayionId");
			int empId = (int) context.getAttribute("empId");
			
			String query = Query.getFriensList();
			statement = Statements.getPrepareStatement(query);
			statement.setInt(1, OrganizationId);
			statement.setInt(2, empId);
			rs = statement.executeQuery();
			
			out.println("<div align= 'center'>");
			   out.println("<h2>Friend List</h2>");
			   out.println(" <table border='5px'>");
			   out.println("<tr>");
			   out.println(" <th>Name</th> "
                     +" <th>Email</th>"
                     + "<th>Conatct Number</th>");
			   out.println("</tr>");
			
			while(rs.next()){
				empId = rs.getInt("Id");
				out.println("<tr>" 
			                 +"<td>"+"<a href='HomePage?empId="+empId +"'>"+rs.getString("FullName")+"</a></td>"  
	                        +"<td>"+rs.getString("Email")+"</td>"
	                        +"<td>"+rs.getLong("ContactNumber")+"</td>"
	                         +"</tr>");
			}
			 out.println(" </table><br/>");    
			 out.println("</div>");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out !=null){
		      out.close();	
			}
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