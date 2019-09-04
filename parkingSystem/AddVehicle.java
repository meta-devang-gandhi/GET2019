package com.parkingSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Servlet of add vehicle form.
 */
@WebServlet("/VehicleForm")
public class AddVehicle extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			PrintWriter out = response.getWriter();
			out.println("<div align= 'center'>");
			out.println("<h1>Add Vehicle</h1>");
	        int empId = Integer.parseInt(request.getParameter("empId"));
			out.print("<form action='./InsertVehicleData?empId="+empId+"' method='post'>");  

			out.print("Vehicle Name:<input name='vehicleName' minlength='2'  /><br><br>");
			out.print("Vehicle Type:<select id='vehicleType' name='vehicleType'>"
                    +"<option id = 'cycle' value='cycle'>cycle</option>"
                    +"<option id = 'twoWheeler' value='twoWheeler'>two Wheeler</option>"
                    +"<option id = 'fourWheeler' value='fourWheeler'>Four Wheeler</option>"
                    +"</select><br><br>");
			out.print("Vehicle Number:<input name='vehicleNumber' /><br><br>");			
			out.print("Employee Id:	<input name='empId'	value='"+empId+"' disabled/><br/><br/>");
			out.print("Identification:<textarea rows='2' cols='50' name='identification'></textarea><br><br>");
			out.print("<input type='submit' value='Add Vehicle'>");  

			 
			out.print("</form>");  
			out.println("</div>");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
