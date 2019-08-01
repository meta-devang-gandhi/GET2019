package question1;

/**
 * Implement the stack interface method. 
 */
public class StackOperation implements IStack
{
	 Node top = null ;

	 // Method push the data on stack.
	@Override
	public void push(String data)
	{ 
       Node node = new Node(data);
       if(isEmpty())
       {
    	   top = node;
       }
       else
       {
    	   node.next = top;
    	   top = node;
       }	
	}

	// Method pop the top data of stack.
	@Override
	public String pop() 
	{
		if(isEmpty())
		{
			System.out.print("Stack is empty");
			return null;
		}
		else
		{
			Node node = top;
			top = node.next;
			return node.data;
		}

	}

	//Return the top most data of stack.
	@Override
	public String peek()
	{
		 if(isEmpty())
		 {
			 System.out.println("Stack is empty");
			 return null;
		 }
		 else
		 {
			 return top.data;
		 }
	}

	// Check the stack is empty or not.
	@Override
	public boolean isEmpty() 
	{
		return (top == null);
	}
    
}
