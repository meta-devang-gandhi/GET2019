package servletExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Class connected to database.
 */
public class DataBaseConnector {
	
	/**
	 * Method give the connection with database.
	 * @return connection.
	 * @throws ClassNotFoundException
	 */
       protected static Connection getConnection() throws ClassNotFoundException {
    	   
    	   String url = "jdbc:mysql://localhost:3306/StudentDetails" ;
  		   String userName = "root";
  		   String password = "root";
  		   
  		 try{
 		    Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, userName, password);
 		} catch (ClassNotFoundException e) {
 		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
 		}
  		catch (SQLException e) {
 		    throw new IllegalStateException("Cannot connect the database!", e);
 		}
	}
}
