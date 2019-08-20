package JDBC;

import java.sql.SQLException;

/**
 *Class to delete product which are inactive last 1 year.
 */
public class DeleteProduct 
{
	MethodClass methodObj = new MethodClass();
	
	 public int getDeleteProductNumber()
	 {
		 try
		 {
			 String query = Query.deleteProductQuery();
		     return  methodObj.getConnection(query).executeUpdate();
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
	       methodObj.close();
	    }
		 
		 return -1;
	 }
	 
	 public static void main(String arg[])
	 {
		 DeleteProduct deleteproduct = new DeleteProduct();
		 System.out.println(deleteproduct.getDeleteProductNumber());
	  }
}
