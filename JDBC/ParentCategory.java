package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *Class to get parent category list along with its subchild category number.
 */
public class ParentCategory 
{
    public void getParentCategory()
    {
    	 Connection connection =  null;
		 PreparedStatement statement = null;
		 Connector connector = new Connector("StoreFront");
		 ResultSet rSet = null;
		 try
		    {
		    	connection = connector.connectedToDataBase();
		    	String query = new Query().ParentCategoryQuery();
		    	
		    	statement = connection.prepareStatement(query);
		    	rSet =  statement.executeQuery(query);
		    	
		    	while(rSet.next())
		    	{
		    		System.out.println(rSet.getString(1)+" "+rSet.getString(2)+" "+ rSet.getString(3));
		    	}
		    }
		    catch(SQLException e)
		    {
		    	e.printStackTrace();
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    finally 
		    {
		       try 
		       { 
		    	   statement.close();
		    	   rSet.close();
		    	  connection.close();
		       }
		    	catch (SQLException e)
		       {
		    	  e.printStackTrace();
		      }
		    }
    }
    
    public static void main(String arg[])
    {
    	ParentCategory category = new ParentCategory();
    	category.getParentCategory();
    }
}
