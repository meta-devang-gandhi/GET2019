package servletExample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Servlet to add student details in database.
 */
public class AddStudentServlet extends HttpServlet{

	private static final long serialVersionUID = -5204576482324229256L;

	/**
	 * Override method of HttpServlet class.
	 * This method only response when post request is come.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		// fetch the data from  student registration form.
		String firstName = request.getParameter("firstName");
		 String lastName = request.getParameter("lastName");
		 String fatherName = request.getParameter("fatherName");
		 String email = request.getParameter("email");
		 String  studentClass = request.getParameter("class");
		 String age = request.getParameter("age");
		
		 Connection connection = null;
		 PreparedStatement statement = null;
		 
		 //Connected with database.
			try {
				connection = DataBaseConnector.getConnection();
		    } catch (ClassNotFoundException e) {
					e.printStackTrace();
			  }
			
			try {
				String query = "INSERT INTO Students(FirstName, LastName, FatherName, Email, Class, Age) "
						+ "VALUES(?, ?, ?, ?, ?, ?)";
				statement = connection.prepareStatement(query);
				
				statement.setString (1, firstName);
				statement.setString (2, lastName);
				statement.setString (3, fatherName);
				statement.setString (4, email);
				statement.setString (5, studentClass);
				statement.setString (6, age);
				
				statement.execute();
                   
				response.getWriter().println("Student is  Successfully registered");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new AssertionError("not able to execute query"+ e);
			} 
			finally{
			      if(statement != null) {
				    	  try {
							statement.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
				    	  try {
							connection.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
			      }
			      
			}
	}
}
   

