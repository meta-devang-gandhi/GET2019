package question2;

/**
 *  Represent Queue and methods of queue.
 */
public class Queue implements IQueue
{
	//size of queue
	private final int QUEUE_SIZE = 10;
	
	//front index of queue when queue is empty
	private int frontIndex = -1;
	
	//back index of queue when queue is empty
	private int backIndex = -1;
	
	//integer array representing queue
	private int queue[] = new int[QUEUE_SIZE];

	/**
	 *Method add element to the queue if its not full
	 * @param  value to be added to queue
	 * @return true if value is added else false
	 * @throws
	 */
	@Override
	public boolean enQueue(int value) throws Exception
	{
		if (this.isFull()) 
		{
			throw new Exception("Queue is full");
		}
		
		if (frontIndex == -1 && backIndex == -1) 
		{
			frontIndex = 0;
			backIndex = 0;
			queue[backIndex] = value;
			return true;
		}

		if (frontIndex > 0 && (backIndex + 1) == queue.length) 
		{
			backIndex = 0;
			queue[backIndex] = value;
			return true;
		}

		backIndex++;
		queue[backIndex] = value;
		return true;
	}

	/**
	 * Method remove element from the queue
	 * @return element which is removed
	 * @throws
	 */
	@Override
	public int deQueue() throws Exception
	{
		if (this.isEmpty()) 
		{
			throw new Exception("Queue is empty");
		}
		
		if (frontIndex == backIndex) 
		{
			int value = queue[frontIndex];
			frontIndex = -1;
			backIndex = -1;
			return value;
		}
		
		if ((frontIndex + 1) == queue.length) 
		{
			int value = queue[frontIndex];
			frontIndex = 0;
			return value;
		}
		
		int value = queue[frontIndex];
		frontIndex++;
		return value;
	}

	/**
	 *Method find the first element of the queue
	 * @return First element in the queue
	 * @throws 
	 */
	public int getFirst() throws Exception
	{
		if (this.isEmpty()) 
		{
			throw new Exception("Queue is empty");
		}
		
		return queue[frontIndex];
	}

	/**
	 *Method find the last element of the queue
	 * @return last element in the queue
	 * @throws 
	 */
	public int getLast() throws Exception 
	{
		if (this.isEmpty()) 
		{
			throw new Exception("Queue is empty");
		}
		
		return queue[backIndex];
	}

	/**
	 *Method check the queue is empty or not.
	 * @return true if queue is empty else false
	 */
	public boolean isEmpty() 
	{
		if (frontIndex == -1 && backIndex == -1) 
		{
			return true;
		}
		
		return false;
	}

	/**
	 *Method check the queue is full or not.
	 * @return true if queue is full else false
	 */
	public boolean isFull()
	{
		if (((backIndex + 1) == queue.length && frontIndex == 0) || (backIndex + 1) == frontIndex) 
		{
			return true;
		}
		
		return false;
	}
}
