package com.parkingSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Sevlet of show the price chart of vehicle pass.
 */
@WebServlet("/showPriceChart")
public class ShowPriceChart extends HttpServlet{

	private static final long serialVersionUID = 1L;
        
	  protected void doPost(HttpServletRequest request, HttpServletResponse response){
		  PrintWriter out = null;
		  PreparedStatement statement = null;
		  ResultSet rs = null;
		  try {
			 out = response.getWriter();
			
			 int empId = Integer.parseInt(request.getParameter("empId"));
			 String type = request.getParameter("type");
			 String query = Query.getVehiclePrice();
			 statement = Statements.getPrepareStatement(query);
			 statement.setString(1, type);
			  rs = statement.executeQuery();
			out.println("<div align= 'center'>");
			   out.println("<h2>Select your plan</h2>");
			   out.println(" <table border='5px'>");
			   out.println("<tr>");
			   out.println(" <th>Plan</th> "
                        +" <th>Price in INR</th>");
			   out.println("</tr>");
			   
			   while(rs.next()) {
			       out.println("<tr>" 
			    		   +"<td>Daily</td>"
			    		   +"<td>"+rs.getInt("daily")+"</td"
			    		   +" </tr>"
			    		   + "  <tr>"
	                        +"<td>Montly</td>"
	                        +"<td>"+rs.getInt("monthly")+"</td>"
	                         +"</tr>"
	                         +"<tr>"
	                        +"<td>Yearly</td>"
	                        +"<td>"+rs.getInt("yearly")+"</td>"
	                         +"</tr>");
			    }

			   out.println(" </table><br/>");    
			   out.println("<form action='./HomePage?empId="+empId+"' method='get'>");
				   out.println(" <label><input type='radio' id='pricePlan' name='pricePlan' value='daily' >Daily</label>"
	                   +" <label><input type='radio' id='pricePlan' name='pricePlan' value='monthly'>Monthly</label>"
	                    +"<label><input type='radio' id='pricePlan' name='pricePlan' value='yearly'>Yearly</label>"
	                       +" <br> <br>");
	
	                  out.println("<input type='submit' value= 'get pass' />");
	            out.println("</form>");      
			out.println("</div>");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
