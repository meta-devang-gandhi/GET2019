package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public  class MethodClass 
{
	 Connection connection =  null;
     PreparedStatement statement = null;
     
    public  PreparedStatement getConnection(String query)
    {
        Connector connector = new Connector("StoreFront");
        
        try
        {
        	connection = connector.connectedToDataBase();
        	statement = connection.prepareStatement(query);
        	if(statement != null)
        	{
        	return statement;
        	}
        	else
        	{
        		throw new Exception("statement is null");
        	}
        }
        catch(SQLException e)
        {
        	e.printStackTrace();
        } 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
        
        return statement;	
    }
    
    public  void close()
    {
    	try
    	{
    		statement.close();
    		connection.close();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
}
