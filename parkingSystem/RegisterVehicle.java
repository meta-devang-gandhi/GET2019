package com.parkingSystem;

import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertVehicleData")
public class RegisterVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {

			String name = request.getParameter("vehicleName").trim();
		    String type = request.getParameter("vehicleType").trim();
		    String number = request.getParameter("vehicleNumber").trim();
		    int empId = Integer.parseInt(request.getParameter("empId"));
		    String identification = request.getParameter("identification").trim();
            
		    PreparedStatement statement = null;
			 
		    String query = Query.insertVehicleDetails(); 
		    statement = Statements.getPrepareStatement(query);
		    statement.setString(1, name);
		    statement.setString(2, type);
		    statement.setString(3, number);
		    statement.setString(4, identification);
		    statement.setInt(5, empId);
		    
		     statement.executeUpdate();
            Statements.close();

            RequestDispatcher rd = request.getRequestDispatcher("showPriceChart?empId="+empId+"&type="+type);
            rd.forward(request, response);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}