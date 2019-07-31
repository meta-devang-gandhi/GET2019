package question1;

/**
 *Class is hold the node item.
 */
public class Node
{
	String data;
	Node next;
	
	Node(String data)
	{
		this.data = data;
		this.next = null;
	}

	// Method return the data of node.
	public String getData() 
	{
		return data;
	}
}