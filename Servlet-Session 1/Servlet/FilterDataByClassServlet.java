package servletExample;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet handle the requests to filter the data by class of student and dynamically generates html page response.
 */
@WebServlet("/FilterDataByClassServlet")
public class FilterDataByClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Override method of HttpServlet.
	 */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		String class1 = request.getParameter("class");
	
		Connection connection = null;
		try {
			connection = DataBaseConnector.getConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			Statement statement = connection.createStatement();
			ResultSet output = statement.executeQuery("select * from students where class = "+ class1);
			PrintWriter out = response.getWriter();

			out.print("<div align=center>");
			out.print("<table width=50% border=1>");  
			ResultSetMetaData rsmd = output.getMetaData();  
			int columnNo = rsmd.getColumnCount();  
			out.print("<tr>");
			
			for(int index = 1; index <= columnNo; index++)  
			{  
			   out.print("<th>"+rsmd.getColumnName(index)+"</th>");  
			}  
			
			out.print("</tr>");  
			
			while(output.next()) {  
				out.print("<tr>");
				for(int columnIndex = 1; columnIndex <= columnNo; columnIndex++){
					Object dataType = rsmd.getColumnTypeName(columnIndex);
					if(dataType instanceof String) {
						out.print("<td>" + output.getString(columnIndex)+ "</td>");
					}
					else if(dataType instanceof Integer) {
						out.print("<td>" + output.getString(columnIndex)+ "</td>");
					}	
				}		
			}  
			  
			out.print("</table>");  
			out.print("</div>");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new AssertionError("not able to execute query");
		} 
		finally {
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				System.out.println();
			}
		}
	}
}