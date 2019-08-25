package LinkedList;

/**
 * Class represent the employee's attribute.
 */
public class Employee 
{
	private String empName;
	private int age;
	private int salary;
	
	/**
	 *Constructor to initialize employee attributes.
	 * @param empName 
	 * @param age 
	 * @param salary 
	 */
	public Employee(String empName, int age, int salary) 
	{
		this.empName = empName;
		this.age = age;
		this.salary = salary;
	}

	/**
	 *Method to return salary of employee.
	 */
	public int getSalary() 
	{
		return salary;
	}

	/**
	 *Method to return age of employee.
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * Method to return the employee name.
	 */
	public String getEmpName()
	{
		return empName;
	}
}