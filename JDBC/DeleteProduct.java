package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *Class to delete product which are inactive last 1 year.
 */
public class DeleteProduct 
{
	 public int getDeleteProductNumber()
	 {
		 Connection connection =  null;
		 PreparedStatement statement = null;
		 Connector connector = new Connector("StoreFront");
		 try
		 {
			 connection = connector.connectedToDataBase();
			String query = new Query().deleteProductQuery();
			 statement = connection.prepareStatement(query);
		     return  statement.executeUpdate();
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
	    	   connection.close();
		   }
		 	catch (SQLException e)
		    {
		   	  e.printStackTrace();
		    }
	    }
		 
		 return -1;
	 }
	 
	 public static void main(String arg[])
	 {
		 DeleteProduct deleteproduct = new DeleteProduct();
		 System.out.println(deleteproduct.getDeleteProductNumber());
	   }
}
