package com.parkingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *Class for create connection and statement .
 */
public class Statements {

	 static Connection connection =  null;
     static PreparedStatement statement = null;
     
    protected static PreparedStatement getPrepareStatement(String query){
      
        try{
        	connection = DataBaseConnector.getConnection();
        	statement = connection.prepareStatement(query);
        	
        	if(statement != null){
        	return statement;
        	}else{
        		throw new Exception("statement is null");
        	}
        } catch(SQLException e)
        {
        	e.printStackTrace();
        }  catch (Exception e){
			e.printStackTrace();
		}
        
        return statement;	
    }
    
    //Method for close connection and statement. 
    protected static void close(){
    	try{
    		statement.close();
    		if(connection != null){
    		connection.close();
    		}
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    	}
    }
}

