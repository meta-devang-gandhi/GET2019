package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Class to connect with database
 */
public class Connector 
{
	String url, userName, password; 
    public Connector(String DataBase)
    {
    	 this.url = "jdbc:mysql://localhost:3306/" + DataBase ;
		 this.userName = "root";
		 this.password = "root";
    }
    
    /**
     * Method to connect with database.
     * @return Connection object of database.
     */
	public Connection connectedToDataBase()
	{
		try
		{
		    Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		try  
		{
			Connection connection = DriverManager.getConnection(url, userName, password);
			System.out.println("connected");
			return connection;
		}
		catch (SQLException e) 
		{
		    throw new IllegalStateException("Cannot connect the database!", e);
		}	
	}
}


