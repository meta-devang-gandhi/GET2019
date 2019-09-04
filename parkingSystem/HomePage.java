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

@WebServlet("/HomePage")
public class HomePage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response){
		
		try {
			PrintWriter out = response.getWriter();
			int empId = Integer.parseInt(request.getParameter("empId"));
			String query = Query.getEmployeeInformation();
			PreparedStatement statement = Statements.getPrepareStatement(query);
		
			statement.setInt(1, empId);
			
			ResultSet rs = statement.executeQuery();
			String name = null, email = null, vehicleType = null, vehicleNumber = null, vehicleIdentification = null ;
			long contactNumber = 0;
			while(rs.next())
			{
				name = rs.getString("FullName");
				email = rs.getString("email");
				contactNumber = rs.getLong("ContactNumber");
				vehicleType = rs.getString("type");
				vehicleNumber = rs.getString("Number");
				vehicleIdentification = rs.getString("Identification");
			}
			
			ServletContext context=getServletContext();  
			context.setAttribute("empId", empId);
			context.setAttribute("name",name);
			context.setAttribute("email",email);
			context.setAttribute("contactNumber",contactNumber);
			context.setAttribute("vehicleType",vehicleType);
			context.setAttribute("vehicleNumber",vehicleNumber);
			context.setAttribute("vehicleIdentification",vehicleIdentification);
			
			out.println("<p align = 'center'>Welecom "+name+" </p>");
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
			//onclick="window.location.href='/page2'"
//			+ "<ul>  "
//			+ "<li><a class='active' href='#home'>Home</a></li> "
//			+ "<li><a href=''>Friends list</a></li>"
//			+ " <li><a href=''>LogOut</a></li>"
//			+ "</ul>"
//			+ "</body></html>");
//			out.print("<html><head><style>");
//			out.print(".topnav {"
//					+"  overflow: hidden;"
//					+"  background-color: #333;}"
//					
//					+".topnav a {"
//					+"  float: left;"
//					+"  color: #f2f2f2;"
//					+"  text-align: center;"
//					+"  padding: 14px 16px;"
//					+"  text-decoration: none;"
//					+"  font-size: 17px;}"
//
//					+".topnav a:hover {"
//					+"  background-color: #ddd;"
//					+"  color: black;}"
//
//					+".topnav a.active {"
//					+"  background-color: #4CAF50;"
//					+"  color: white;}"
//					
//					+"#profile-container {"
//					+ "position: absolute;"
//					+ "right: 0px;"
//					+ "top: 60px;"
//					+ "background-color: white;}"
//					
//					
//					
//					+"#profile-container img{"
//					+ "position: relative;"
//					+ "right: 0px;"
//					+ "top: 0px;"
//					+ "background-color: white;"
//					+ "width: 120;"
//					+ "height: 150}"
//					
//					+"#profile-container button{"
//					+ "postion:relative;"
//					+ "top:240px;"
//					+ "right:0px}"
//					
//					+"</style>");
//			
//			out.print("<div class='topnav' name='topnav'>"
//					+ "<a  href='#home'>Home</a>"
//					+ "<a href='friends?empId="+rs.getInt(1)+"'>Friends</a>"
//					+ "<a href='Logout' style=\"float:right;\">Logout</a>"
//					+ "</div>"
//					+ "<br/>");
//			out.print("<div id='profile-container' '>");
//			
////			if(gender.equals("male")){
////				out.print("<img src='"+ request.getContextPath() +"/images/default-profile-picture.jpg' alt='image'/>");
////			}
////			else{
////				out.print("<img src='"+ request.getContextPath() +"/images/user_profile_female.jpg' alt='image'/>");
////			}
//			out.print("<button type=button  onclick='changeImage.htm'>change</button>"
//					+"</div>");
//			out.println("<body><h1>Welcome !<br/> "+name+"</h1><br/><br/>");
//			out.print("<p>email: "+email+"<br/>");
//			out.print("<p>contact: "+contactNumber+"<br/>");
//			out.print("<p>VehicleType: "+vehicleType+"</p><br/><br/>");
//			
////			 out.print("<button type=button onclick=\"window.location.href = 'UpdateStudent?id="+rs.getInt(1)
////                		+ "&fullName="+rs.getString(2)+"&gender="+rs.getString(3)
////                		+ "&email="+rs.getString(4)
////                		+ "&contactNumber="+rs.getInt(6)+"&organization="+rs.getString(7)+"';\">Edit</button><br/><br/>");
////               
//			out.print("<button type=button onclick=\"window.location.href = 'VehicleForm'>"
//					+ "Add New Vehicle</button>");
//			
//			
//			out.print("</body>");
//		
//			out.println("<html><head><style>"
//					
//					+ "ul {"
//					+ " list-style-type: none;  "
//					+ "margin: 0;"
//					+ "  padding: 0;"
//					+ "overflow: hidden; "
//					+ "background-color: black;"
//
//					+ "li{"
//					+ " float: right;}"
//					
//					+"li a { "
//					+ "display: block;"
//					+ " color: white;"
//					+ "text-align: center; "
//					+ "padding: 14px 16px;"
//					+ "text-decoration: none;}"
//					
//					+"li a:hover {"
//					+ "background-color: #111;}"
//					+ "</style></head><body>"
//					
//					+ "<ul>  "
//					+ "<li><a class='active' href='#home'>Home</a></li> "
//					+ "<li><a href=''>Friends list</a></li>"
//					+ " <li><a href=''>LogOut</a></li>"
//					+ "</ul>"
//					+ "</body></html>");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }	
}
