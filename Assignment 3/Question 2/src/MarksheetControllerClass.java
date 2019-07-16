import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Admin
 * It is a main class.
 * It take a input from user and call the MarkSheet_Class Method.
 */
public class MarksheetControllerClass
{
	public static ArrayList<Integer> studentGrades = new ArrayList<>();

	public static void main(String[] args)
	{
		MarkSheet marksheet = new MarkSheet();
		int noOfStudents = 0;
		int grade = 0;
		System.out.println("Eneter no. of students");
		Scanner sc = new Scanner(System.in);

		// takes no. of students from user
		try 
		{
			noOfStudents = sc.nextInt();
			if (noOfStudents == 0) 
			{
				sc.close();
				throw new Exception("Students not found");	
			}
		} 
		catch (Exception e) 
		{	
			System.out.println("Your input is not positive Integer No  :"+ e);
			System.exit(0);	
		}

		// adding grades
		for (int studentCount = 1; studentCount <= noOfStudents; studentCount++) 
		{
			System.out.println("Enter Grade for student : " + studentCount);
			try 
			{
				grade = sc.nextInt();
				if(grade < 0 || grade > 100) 
				{
					throw new Exception("You can enter grade between 0 to 100");
				}
			}
			catch (Exception e)
			{
				System.out.println("Your input is not positive Integer No  :"+ e);
				System.exit(0);
				break;
			}

			studentGrades.add(grade);
		}
		
		// averageGrade of students
		float averageGrade = marksheet.averageGrade(studentGrades);
		System.out.println("Average Grade of Student is: "+ averageGrade);
				
		// maximum grade
		float maxGrade = marksheet.maxGrade(studentGrades);
		System.out.println("Maximum Grade is: " + maxGrade);

		// minimum grade
		float minGrade = marksheet.minGrade(studentGrades);
		System.out.println("Minimum Grade is: " + minGrade);

		// percentage of students passed
		float percentageOfStudentPassed = marksheet.percentageOfStudentPassed(studentGrades);
		System.out.println("percentage of students passed: "+ percentageOfStudentPassed);

		}
}
