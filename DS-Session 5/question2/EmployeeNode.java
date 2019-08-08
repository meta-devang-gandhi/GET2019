package question2;

/**
 *Represent the employee object.
 */
public class EmployeeNode 
{
    private Employee employee;
    EmployeeNode previous;
    EmployeeNode next;
    
    /**
     * Initialize the attributes.
     * @param employee
     */
    public EmployeeNode(Employee employee)
    {
    	this.employee = employee;
    	next = null;
    	previous = null;
    }
    
    //Return the employee.
    public Employee getEmployee()
    {
    	return employee;
    }
}
