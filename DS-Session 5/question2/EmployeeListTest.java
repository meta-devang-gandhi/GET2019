package question2;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class EmployeeListTest 
{
	EmployeeList obj = new EmployeeList();
	
	@Before
	public void initialize() throws Exception
	{	   
		   obj.addEmployee("a", 16000, 28);
		   obj.addEmployee("b", 160, 25);
		   obj.addEmployee("c", 106, 35);
		   obj.addEmployee("d", 216, 30);
		   obj.addEmployee("e", 1, 40);
		   obj.addEmployee("f", 6, 30);
		   obj.addEmployee("g", 1600, 1);
		   obj.addEmployee("h", 1600, 3);
		   obj.addEmployee("i", 1060, 30);
		   obj.addEmployee("j", 16, 30);	
	}

	@Test
	public void testModifiedList()
	{
		List<String> expectedList = new LinkedList<String>();
		expectedList.add("a");
		expectedList.add("g");
		expectedList.add("h");
		expectedList.add("i");
		expectedList.add("d");
		expectedList.add("b");
		expectedList.add("c");
		expectedList.add("j");
		expectedList.add("f");
		expectedList.add("e");

		LinkedList<String> actualList = new LinkedList<String>();
		EmployeeNode head = obj.showEmployee();
		
		while(head != null)
		{
			actualList.add(head.getEmployee().getName());
			head = head.next;
		}
		
		assertEquals(expectedList, actualList);
	}
	
	@Test(expected = Exception.class)
	public void testException() throws Exception
	{
		obj.addEmployee("xyz", 0, 0);
	}
}
