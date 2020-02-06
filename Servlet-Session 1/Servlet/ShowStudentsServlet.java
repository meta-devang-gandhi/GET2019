package servletExample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Servlet to show the all registered student list.
 *Generate the dynamic html page.  
 *Also have update functionality. which update the student record.  
 */
public class ShowStudentsServlet extends HttpServlet{
 
	private static final long serialVersionUID = 1L;

	/**
	 * Override function of HttpServlet class.
	 * This Method only response when request type is GET.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 Connection connection = null;
		 PreparedStatement statement = null;
		 ResultSet output = null;
		 PrintWriter out = response.getWriter();  
		
		 //Connected to database.
		 try {
			connection = DataBaseConnector.getConnection();
		 } catch (ClassNotFoundException e) {
					e.printStackTrace();
		   }
		 
		 try {
				String query = "SELECT * FROM Students";
				statement = connection.prepareStatement(query);
				out.print("<div align=center>");
				out.print("<table width=50% border=1>");  
				out.print("<h2>Stdent Information </h2><br>");  
				
				 output = statement.executeQuery();
				
				ResultSetMetaData rsmd = output.getMetaData();  
				int columnNo = rsmd.getColumnCount();  
				out.print("<tr>");
				
				//Print the column name of table.
				for(int index = 1; index <= columnNo; index++)  
				{  
				   out.print("<th>"+rsmd.getColumnName(index)+"</th>");  
				}  
				out.print("<th></th>");  
				out.print("</tr>");  
				
				while(output.next()) {  
					out.print("<tr>");
					//Print the record of table.
					for(int columnIndex = 1; columnIndex <= columnNo; columnIndex++){
						Object dataType = rsmd.getColumnTypeName(columnIndex);
						if(dataType instanceof String) {
							out.print("<td>" + output.getString(columnIndex)+ "</td>");
						}
						else if(dataType instanceof Integer) {
							out.print("<td>" + output.getString(columnIndex)+ "</td>");
						}
					}
					
					out.println("<td> <a href=\"UpdateStudentServlet?id="+output.getString("id")+ "\">update </a></td>");
				}  
				  
				out.print("</table>");  
				out.print("</div>");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				try {
					throw new Exception("not able to execute query"+ e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} catch(Exception e){
				System.out.println(e.getMessage());
				try {
					throw new Exception(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}finally
			{
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				 }
				
				try {
					output.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				out.close();
				
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}
