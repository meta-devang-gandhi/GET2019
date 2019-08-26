package LinkedList;
/**
 * Class to represent the node of list.
 */
public class Node 
{
    Employee emp;
	Node next;

	/**
	 *Constructor to initialize the node's value
	 * @param data value of data field of node.
	 */
	Node(Employee emp) 
	{
		this.emp = emp;
		this.next = null;
	}

}