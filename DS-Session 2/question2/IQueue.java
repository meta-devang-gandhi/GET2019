package question2;

/**
 * Interface of queue.
 */
public interface IQueue 
{
    //Method add element to the queue if its not full	
	public boolean enQueue(int value)throws Exception;
	
	// Method remove element from the queue
	public int deQueue()throws Exception;
	
	//Method check the queue is empty or not.
	public boolean isEmpty();
	
	//Method check the queue is full or not.
	public boolean isFull();
}
