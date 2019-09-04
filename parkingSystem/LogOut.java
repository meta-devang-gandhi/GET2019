package com.parkingSystem;

import java.io.IOException;  
import java.io.PrintWriter;  
  

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

/**
 *Servelet for log out.
 */
@WebServlet("/Logout")  
public class LogOut extends HttpServlet {  

	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) {  
            PrintWriter out;
			try {
				out = response.getWriter();
			
            //out.print("You are successfully logged out!"); 
            request.getRequestDispatcher("LoginPage.html").include(request, response);  
              
            HttpSession session=request.getSession();  
            session.invalidate();  

            out.close();  
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e){
		   e.printStackTrace();	
		}
    }  
} 