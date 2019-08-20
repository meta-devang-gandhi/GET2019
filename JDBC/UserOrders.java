package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 *Class to get user order list.
 */
class UserOrders 
{
	 int shopperId;
     MethodClass methodObj = null;
     
	public UserOrders(int id)
	{
    	this.shopperId = id;
    	methodObj = new MethodClass();
	}
			
	/**
	 * Method to get user order list.
	 */
    public Map<Integer, String> getUserOrder()
    {
        ResultSet rSet = null;
        Map<Integer, String> userOrder = new LinkedHashMap<Integer, String>();
	    try
	    {
	    	String query = Query.userOrderQuery(shopperId);
	    	rSet =  methodObj.getConnection(query).executeQuery(query);
	        int i = 1;
	    	while(rSet.next())
	    	{
	    		System.out.println(rSet.getString(1)+" "+rSet.getString(2)+" "+ rSet.getString(3));
	    		userOrder.put(i++, rSet.getString(1));
	    	}
	    	
	    	return userOrder;
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
	    	   if(rSet != null)
	    	   {
	    	     rSet.close();
	    	   }
	    	   methodObj.close();
	       }
	    	catch (SQLException e)
	       {
	    	  e.printStackTrace();
	      }
	    }
	    
		return userOrder;
     }
    
    public static void main(String arg[])
    {
    	UserOrders orders = new UserOrders(15);
    	orders.getUserOrder();
    }
}

