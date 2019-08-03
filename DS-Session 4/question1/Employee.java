package question1;

/**
 *Create a employee.
 */
public class Employee 
{
	private int employeeID = 0;
	private String employeeName = null;
	private String employeeAddress = null;
	
	public Employee(int employeeID, String employeeName, String employeeAddress)
	{
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}
	
	//Compares two Objects for equality with employee id.
	@Override
	public boolean equals(Object e)
	{
		return this.employeeID == ((Employee)e).employeeID;
	}
	
	 //Returns a hash code value for the object
	 @Override
	 public int hashCode() 
	 { 
	     return this.employeeID; 
         } 
	
	//String representation of the object.
	@Override
	public String toString() 
	{ 
	    return "\nName: '" + this.employeeName + "', ID: '" + this.employeeID + "', address: '" + this.employeeAddress + "'";
	} 
		
	//Return the employee id
	public int getEmployeeID() 
	{
		return employeeID;
	}

	//Return the employee name
	public String getEmployeeName() 
	{
		return employeeName;
	}

	//Return the employee address
	public String getEmployeeAddress() 
	{
		return employeeAddress;
	}
}
