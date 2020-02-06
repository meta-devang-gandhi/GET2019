package servletExample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to update the details of student.
 * And response dynamic html page where student can update details.
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Connection connection = null;
		try {
			connection = DataBaseConnector.getConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Students where id = " + id);
			PrintWriter out = response.getWriter();

			out.println("<html><body align=\"center\">");
			out.println("<form action=\"UpdateServlet\" method=\"post\" >" );
			while (rs.next()) {
				out.println("student ID: <input type=\"hidden\" name=\"id\" value=" + rs.getString("id") + "> <br><br>");
				out.println("first Name: <input type=\"text\" name=\"firstName\" value=" + rs.getString("firstName") + "> <br><br>");
				out.println("last Name: <input type=\"text\" name=\"lastName\" value=" + rs.getString("lastName") + "> <br><br>");
				out.println("father Name: <input type=\"text\" name=\"fatherName\" value=" + rs.getString("fatherName") + "> <br><br>");
				out.println("email: <input type=\"text\" name=\"email\" value=" + rs.getString("email") + "> <br><br>");
				out.println("class: <input type=\"number\" name=\"class\" min=\"1\" max=\"12\"value=" + rs.getString("class") + "> <br><br>");
				out.println("age: <input type=\"number\" name=\"age\" value=" + rs.getString("age") + "> <br><br>");
			}
			out.print("<input type=\"submit\" value=\"update\">");
			out.println("</form>");
			out.println("</table><body></html>");
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
			throw new AssertionError("not able to execute query");
		} 
		finally {
			 try {
				connection.close();
			} catch (SQLException e) {
				System.out.println();
			}
		}	
	}
}