import static org.junit.Assert.*;

import org.junit.Test;


import static org.junit.Assert.*;
import org.junit.Test;

public class AddmissionManagementTest 
{
	/**
	 * This test method test allocateCourses method of AddmissionManagement Class
	 */
	@Test
	public void allocateCoursesPositiveCasesTest() 
	{	
		String availableCoursesExcelFile = "College_Courses.xls";
		String studentDetailsExcelFile = "Student_Details.xls";
		String allocatedCoursesExcelFile = "Course_Allocation.xls";
		
		AddmissionManagement addmissionManagement = new AddmissionManagement();
		assertTrue(addmissionManagement.allocateCourses(availableCoursesExcelFile, studentDetailsExcelFile, allocatedCoursesExcelFile));
	}
}
