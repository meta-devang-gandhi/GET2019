package JDBC;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;


public class UserOrdersTest 
{ 
	 @Test
	 public void testorder() 
	 {
		 Map<Integer, String> expected = new LinkedHashMap<Integer, String>();
		 Map<Integer, String> actual = new LinkedHashMap<Integer, String>();
		 expected.put(1, "2");
		 expected.put(2, "1");
		 UserOrders userOrders = new UserOrders(15);
		 actual = userOrders.getUserOrder();
		
	     assertEquals(expected, actual);
	   }  
	 
	 @Test
	 public void testParentCategory()
	 {
		 Map<String, String> expected = new LinkedHashMap<String, String>();
		 Map<String, String> actual = new LinkedHashMap<String, String>();
		 expected.put("10", "3");
		 expected.put("11", "2");
		 expected.put("12", "2");
		 ParentCategory parentCategory = new ParentCategory();
		 actual = parentCategory.getParentCategory();
		
	     assertEquals(expected, actual); 
	 }
}
