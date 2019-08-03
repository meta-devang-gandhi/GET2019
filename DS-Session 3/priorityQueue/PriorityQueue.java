package priorityQueue;

public class PriorityQueue implements IQueue<String>
{
	private String[][] queue;
	private int frontIndex , backIndex;
	
    public PriorityQueue(int size)
    {
    	queue = new String[size][2];
    	frontIndex = backIndex = -1;
    }
	@Override
	public boolean enQueue(String value, int priority)
	{
		
		try
		{
			String stringPriority = Integer.toString(priority);
					
			if (this.isFull()) 
			{
				throw new Exception("Queue is full");
			}
			
			if (frontIndex == -1 && backIndex == -1) 
			{
				frontIndex = 0;
				backIndex = 0;
				queue[backIndex][0] = value;
				queue[backIndex][1] = stringPriority;
				return true;
			}
	
			if (frontIndex > 0 && (backIndex + 1) == queue.length) 
			{
				backIndex = 0;
				queue[backIndex][0] = value;
				return true;
			}
	
			backIndex++;
			queue[backIndex][1] = value;
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
 
	public void priorityCheck(String priority)
	{
		if(Integer.parseInt(queue[backIndex][1]) > Integer.parseInt(priority))
		{
			swap(queue[backIndex][1], priority);
		}
	}

	public void swap(String a, String b)
	{
		
	}
	@Override
	public String deQueue() 
	{
		String value = null;
		try
		{	
			if (this.isEmpty()) 
			{
				try 
				{
					throw new Exception("Queue is empty");
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			
			if (frontIndex == backIndex) 
			{
				value = queue[frontIndex][1];
				queue[frontIndex][1] = null; 
				frontIndex = -1;
				backIndex = -1;
				return value;
			}
			
			if ((frontIndex + 1) == queue.length) 
			{
				value = queue[frontIndex][1];
				queue[frontIndex][1] = null;
				frontIndex = 0;
				return value;
			}
			
			value = queue[frontIndex][1];
			queue[frontIndex][1] = null;
			frontIndex++;
			return value;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return value;
	}

	@Override
	public boolean isEmpty()
	{
		return (frontIndex == -1 && backIndex == -1);
	}

	@Override
	public boolean isFull() 
	{
		return (((backIndex + 1) == queue.length && frontIndex == 0) || (backIndex + 1) == frontIndex) ;
	}
	
	public int getFirstIndex()
	{
		return frontIndex;
	}
	
	public int getBackIndex()
	{
		return backIndex;
	}
	

}
