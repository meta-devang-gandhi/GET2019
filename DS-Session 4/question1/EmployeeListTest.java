package question1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class EmployeeListTest 
{
	EmployeeList employee = new EmployeeList();
	
	@Before
    public void initialize()
    {
	     employee.addEmployee(9, "devang", "kumba marg");	
	     employee.addEmployee(2, "rahul", "skit");	
	     employee.addEmployee(1, "atul", "sector 12");
	     employee.addEmployee(4, "vinod", "git");	
	     employee.addEmployee(9, "pankaj", "sector 9");	
	     employee.addEmployee(8, "rahul", "kumba marg");
    }
	
	@Test
	public void testSortByNaturalOrder()
	{
		List<Employee> listOfEmployeesSortedByNaturalOrder = employee.sortByNaturalOrder();
		String [] actual = new String[6];
		int count = 0;
		for(Employee employee : listOfEmployeesSortedByNaturalOrder)
		{
			actual[count] = employee.getEmployeeName();
			count++;		
		}

		 String expected[] = new String[]{"atul", "rahul", "vinod", "rahul", "devang", "pankaj"};
		
		assertArrayEquals(expected, actual);
	}
	
	
	
	@Test
	public void testSortByEmployeeName()
	{
		List<Employee> listOfEmployeesSortedByName = employee.sortByEmployeeName();
		String [] actual = new String[6];
		int count = 0;
		System.out.println(listOfEmployeesSortedByName);
		for(Employee employee : listOfEmployeesSortedByName)
		{
			actual[count] = employee.getEmployeeName();
			count++;		
		}

		 String expected[] = new String[]{"atul", "devang","pankaj", "rahul", "rahul",  "vinod"};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testGetUniqueEmployeesList()
	{
		List<Employee> listOfUniqueEmployee = employee.getUniqueEmployeesList();
		String [] actual = new String[5];
		int count = 0;
		System.out.println(listOfUniqueEmployee);
		for(Employee employee : listOfUniqueEmployee)
		{
			actual[count] = employee.getEmployeeName();
			System.out.println(actual[count]);
			count++;		
		}

		 String expected[] = new String[]{"devang","rahul","atul","vinod","rahul"};
		
		assertArrayEquals(expected, actual);
	}
	
	
}
