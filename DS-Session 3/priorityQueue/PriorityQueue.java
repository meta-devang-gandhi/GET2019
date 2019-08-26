package priorityQueue;

/**
 * Class perform the queue operations.
 */
public class PriorityQueue implements IQueue
{	
	private  int front, back;
	private  Item queue[];
	int capacity;
	
	/**
	 * Initialize the capacity of queue.
	 * @param capacity
	 */
    public PriorityQueue(int capacity) 
    {
		this.capacity = capacity;
		front = back = -1;
		queue = new Item[capacity];
	}

	/**
	 * Add to item object in queue.
	 */
    @Override
	public void enqueueItem(String data, int priority) 
	{
		Item item = new Item(data, priority);
		try
		{
			if (isQueueFull()) 
			{
				throw new Exception("Queue is Full");
			} 
			if (front == -1 && back == -1) 
			{
				front = 0;
				back = 0;
				queue[back] = item;
				
			}
			else if (front > 0 && (back + 1) == capacity) 
			{
				back = 0;
				queue[back] = item;
				arrangeAsPriority();
			}
			else
			{
			back++;
			queue[back] = item;
	    	arrangeAsPriority();
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array out of bound"+ e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
    
    /**
     * Method arrange the queue as priority.
     */
    public void arrangeAsPriority()
    {
    	int tempFront = front;
    	while(tempFront != back + 1 )
    	{
    		int traverseFront = front;
    		while(traverseFront != back + 1)
    		{
    			if(queue[tempFront].getPriority() > queue[traverseFront].getPriority() )
    			{
    				
    				Item temp = queue[tempFront];
    				queue[tempFront] = queue[traverseFront];
    				queue[traverseFront] = temp;
    			}
    			
    			if(tempFront == back)
    			{
    				break;
    			}
    			if(traverseFront + 1 == capacity)
    			{
    				traverseFront = 0;
    				
    			}
    			else
    				traverseFront++;
    		}
    		
    		if(tempFront == back)
    		{
    			break;
    		}
    		if(tempFront + 1 == capacity )
			{
				tempFront = 0;
				
			}
			else
				tempFront++;
    	}	
    }

	/**
	 * delete element from queue
	 */
	@Override
	public Item dequeueItem() 
	{	
		try
		{
			if (this.isQueueEmpty()) 
			{
				throw new Exception("Queue is empty");
			}
			
			if (front == back) 
			{
				Item item = queue[front];
				front = -1;
				back = -1;
				return item;
			}
			else if ((front + 1) == queue.length) 
			{
				Item item = queue[front];
				front = 0;
				return item;
			}
			else
			{
			Item item = queue[front];
			front++;
			return item;
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array out og bound"+ e);
			return null;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	/**
	 * @return true if queue is full else false
	 */
	@Override
	public boolean isQueueFull() 
	{
		return  (((back + 1) == queue.length && front == 0) || (back + 1) == front) ;
	}

	/**
	 * @return true if queue is empty else false
	 */
	@Override
	public boolean isQueueEmpty()
	{
	    return (front == -1 && back == -1);
	}

	// Print the queue item.
	public void print()
	{
		int temp = front;
		 while(temp != back)
		{
			System.out.println(queue[temp].getItem() +"  "+ queue[temp].getPriority());
			if(temp + 1 == capacity && temp != back)
			{
				temp = 0;
			}
			else
			{
			temp++;
			}
		}
	  
	}
	
	//Return the queue.
	public Item[]  getPriorityQueue()
	{
		return queue;
	}

    public static void main(String arg[])
    {
    	PriorityQueue queue = new PriorityQueue(9);
    	queue.enqueueItem("abc1", 1);
    
    	queue.enqueueItem("abc2", 10);

    	queue.enqueueItem("abc3", 5);
 
    	queue.enqueueItem("abc4", 12);
    	
    	queue.enqueueItem("abc", 9);
    	queue.arrangeAsPriority();
    	System.out.println(1+"------------------------");
    	queue.print();
    	queue.dequeueItem();
    	System.out.println(2+"---------------------------------------");
    	queue.print();
    	queue.enqueueItem("abc", 15);
    	System.out.println(3+"---------------------------------------");
    	queue.print();
    }
}