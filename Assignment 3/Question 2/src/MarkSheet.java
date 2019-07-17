import java.util.ArrayList;

 /**
 * @author Admin
 * It have only Method as specified requirements.
 * It perform average of Grade,  find Maximum and Minimum of Grade, percentage of passed Student 
 */
public class MarkSheet
{
	/**
	 * @param studentGrades is the grades of all students
	 * @return averageGrade of all students
	 * We get studentGrade between 0 to 100 only. and here have validate value.
	 */
	public float averageGrade(ArrayList<Integer> studentGrades)
	{
		float sumOfStudentGrades = 0;
		
		// computing sum of all student's grade
		for (int studentGrade: studentGrades)
		{
			sumOfStudentGrades +=studentGrade;  
		}
		
		// find average of students grade	
		float averageGrade = sumOfStudentGrades/ (float)(studentGrades.size());
		return averageGrade;		
	}
	
	/**
	 * @param studentGrades is the grades of all students
	 * @return maxGrade of all students
	 * We get studentGrade between 0 to 100 only. and here have validate value.
	 */
	public float maxGrade(ArrayList<Integer> studentGrades)
	{
		float maxGrade = 0;
		
		for (int studentGrade: studentGrades)
		{
			if(maxGrade < studentGrade)
			{
				maxGrade = studentGrade;
			}
		}	
		return maxGrade;	
	}
	
	/**
	 * @param studentGrades is the grades of all students
	 * @return minGrade of all students
	 * We get studentGrade between 0 to 100 only. and here have validate value.
	 */
	public float minGrade(ArrayList<Integer> studentGrades)
	{
		float minGrade = 101;
	
		for (int studentGrade: studentGrades)
		{
			if(minGrade > studentGrade)
			{
				minGrade = studentGrade;
			}
		}
		return minGrade;	
	}
		
	/**
	 * @param studentGrades is the grades of all students
	 * @return percentage of students passed.
	 * We get studentGrade between 0 to 100 only. and here have validate value.
	 */
	public float percentageOfStudentPassed(ArrayList<Integer> studentGrades){
		int noOfStudentPassed = 0;
		for (int studentGrade: studentGrades)
		{
			if(studentGrade>=40)
			{
				noOfStudentPassed+=1;
			}	
		}
	
		return ((float)noOfStudentPassed)/ (float) studentGrades.size()*100;
	}
}
