package com.parkingSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *Class connected to database.
 */
public class DataBaseConnector {
	
	/**
	 * Method give the connection with database.
	 * @return connection.
	 * @throws ClassNotFoundException
	 */
       protected static Connection getConnection() {
    	  
    	   try { 
    	        Properties properties = new Properties();
    	   
			    properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		 
		    	   String url = properties.getProperty("jdbc.url");
		    	   String driver = properties.getProperty("jdbc.driver");
		    	   String userName = properties.getProperty("jdbc.username");
		    	   String password = properties.getProperty("jdbc.password");
  		   
 		           Class.forName(driver);
			       return DriverManager.getConnection(url, userName, password);
 		} catch (ClassNotFoundException e) {
 		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
 		}
  		catch (SQLException e) {
 		    throw new IllegalStateException("Cannot connect the database!", e);
 		}
  		catch (IOException e1) {
			e1.printStackTrace();
	     }
		return null;
      }  
}
