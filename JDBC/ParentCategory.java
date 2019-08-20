package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *Class to get parent category list along with its subchild category number.
 */
public class ParentCategory 
{
	MethodClass methodObj = new MethodClass();
    public  Map<String, String> getParentCategory()
    {
		 ResultSet rSet = null;
		 Map<String, String> patentCategoryList = new LinkedHashMap<String, String>();
		 try
		    {
		    	String query = Query.ParentCategoryQuery();
		    	rSet =  methodObj.getConnection(query).executeQuery(query);
		    	
		    	while(rSet.next())
		    	{
		    		System.out.println(rSet.getString(1)+" "+rSet.getString(2)+" "+ rSet.getString(3));
		    		patentCategoryList.put(rSet.getString(1),  rSet.getString(3));
		    	}
		    	
		    	return patentCategoryList;
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
		    	   rSet.close();
		    	   methodObj.close();
		       }
		    	catch (SQLException e)
		       {
		    	  e.printStackTrace();
		      }
		    }
		 
		return patentCategoryList;
    }
    
    public static void main(String arg[])
    {
    	ParentCategory category = new ParentCategory();
    	category.getParentCategory();
    }
}
