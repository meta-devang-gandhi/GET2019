package question1;

/**
 * Interface of stack.
 */
public interface IStack
{
	// Method to perform push operation on stack.
    public  void  push(String data);
    
    // Method to perform pop operation on stack.
    public String pop();
    
    //Return the top value of stack. 
    public String peek();   
    
    // Check the stack is empty or not.
    public boolean isEmpty();
}
