
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * This class contain method for college course allocation
 */
public class AddmissionManagement
{
	/**
	 * This method allocate course to students as their ranks and available seats
	 * @param availableCoursesExcelFile path of excel file containing details of available courses and seats
	 * @param studentDetailsExcelFile path of excel file containing details of students and their five course choices
	 * @param allocatedCoursesExcelFile path of excel file where excel file containing details of allocation should stored
	 * @return true if courses is allocated else false
	 */
	public boolean allocateCourses(String availableCoursesExcelFile,String studentDetailsExcelFile,String allocatedCoursesExcelFile)
	{	
		/*
		 * creating HashMap which will contain data about courses
		 * key as their name and value is available seats
		 * calling method which return HashMap which contain available course details
		 */
		HashMap<String,Integer> courseAvailable = getAvailableCoursesAndCapacity(availableCoursesExcelFile);
		
		try
		{
			//creating the excel file which will store course allocation details
			WritableWorkbook courseAllocationExcelSheet= Workbook.createWorkbook(new File(allocatedCoursesExcelFile));
			
			//creating first sheet in excel file
			WritableSheet courseAllocationSheet = courseAllocationExcelSheet.createSheet("Sheet 1", 0);

			//creating Label for heading "Student Name" and adding to sheet at first column and first row
			Label label = new Label(0,0,"Student Name");
			courseAllocationSheet.addCell(label);
			
			//creating Label for heading "Allocated Course" and adding to sheet at second column and first row
			label = new Label(1,0,"Allocated Course");
			courseAllocationSheet.addCell(label);

			//getting the excel file which contain details about student and their choices from given path
			Workbook studentDetailsExcelSheet = Workbook.getWorkbook(new File(studentDetailsExcelFile));
			
			//getting the first sheet which contain data
			Sheet studentSheet = studentDetailsExcelSheet.getSheet(0);

			/*
			 * getting total number of student
			 * which is done by getting total row filled in first column
			 * number of student is one less than total row filled because first row contain heading 
			 */
			int numberOfStudent = studentSheet.getColumn(0).length-1;
			/**
			 * getting total number of course choices
			 * which is done by getting the total columns filled 
			 * total course is one less than total column filled because first column contain name of student
			 */
			int totalCourse = studentSheet.getColumns()-1;

			//Reading student name one by one
			for(int studentIndex =1; studentIndex <=numberOfStudent; studentIndex++)
			{
				boolean isCourseAllocated = false;
				
				//reading name of student from sheet
				Label studentName = new Label(0,studentIndex,studentSheet.getCell(0,studentIndex).getContents());

				//reading the preferred courses of selected student one by one
				for(int courseIndex =1; courseIndex <= totalCourse; courseIndex++)
				{
					//reading the course from sheet
					String preferredCourse= studentSheet.getCell(courseIndex, studentIndex).getContents();

					/*
					 * if seats available for course than allocating the course to student
					 * and reducing seat by one
					 */
					if(courseAvailable.get(preferredCourse) > 0)
					{
						//reading course from sheet
						Label courseAllocated = new Label(1,studentIndex,preferredCourse);
						//adding student and course allocated to excel file
						courseAllocationSheet.addCell(studentName);
						courseAllocationSheet.addCell(courseAllocated);
						isCourseAllocated = true;
						//reducing seat by one after allocation
						courseAvailable.replace(preferredCourse, courseAvailable.get(preferredCourse)-1);
						break;
					}
				}

				/*
				 * if course is not allocated because seats not available than
				 * adding name in excel file and assigning not allocated  
				 */
				if(isCourseAllocated == false)
				{
					courseAllocationSheet.addCell(studentName);
					Label courseAllocated = new Label(1,studentIndex,"Not Allocated");
					courseAllocationSheet.addCell(courseAllocated);
				}

			}
			
			//writing data to Excel file Course_Allocation
			courseAllocationExcelSheet.write();
			//closing Excel file which contain student details
			studentDetailsExcelSheet.close();
			//closing Excel file which contain details about allocated courses
			courseAllocationExcelSheet.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * This method read the excel file containing details of courses and seats and create a HashMap in which key is course name and value is available seats
	 * @param availableCoursesExcelFile path of excel file containing details of courses available and their seats
	 * @return HashMap<String,Integer> where key is course name and value is available seats
	 */
	private HashMap<String,Integer> getAvailableCoursesAndCapacity(String availableCoursesExcelFile)
	{
		/*
		 * creating HashMap which will contain data about courses
		 * key as their name and value is available seats
		 */
		HashMap<String,Integer> courseAvailable = new HashMap<String,Integer>();

		try {
			//getting the excel file which contain details of available courses and seats from given path
			Workbook courseAvailableExcelFile = Workbook.getWorkbook(new File(availableCoursesExcelFile));
			
			//getting the first sheet which contain data
			Sheet courseSheet = courseAvailableExcelFile.getSheet(0);

			/*
			 * getting total courses available which is done by getting the total filled row in first column 
			 * first row contain heading so total Course is one less than total row filled
			 */
			int totalCourses = courseSheet.getColumn(0).length-1;

			//creating Cell objects which represent single cell in sheet
			Cell courseName;
			Cell availableCapacity;
			
			/*
			 * creating index which contain column index where course names are stored
			 * which is 0 because course name stored in first column and index start from 0
			 */
			int courseNamecolIndex =0;
			
			/*
			 * creating index which contain column index where available seats are stored
			 *  which is 1 because seats stored in second column and index start from 0
			 */
			int availableCapacityColIndex = 1;
			
			/*
			 * creating index which contain row index from important data start
			 * which is 1 because first is heading
			 */
			int courseRowIndex =1;
			
			//reading courses and available seats and adding to HashMap
			while(courseRowIndex <= totalCourses)
			{
				courseName = courseSheet.getCell(courseNamecolIndex,courseRowIndex);
				availableCapacity = courseSheet.getCell(availableCapacityColIndex, courseRowIndex);
				courseAvailable.put(courseName.getContents(), Integer.parseInt(availableCapacity.getContents()));
				courseRowIndex++;
			}
			courseAvailableExcelFile.close();
			
		} 
		catch (BiffException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return courseAvailable;
	}
}
