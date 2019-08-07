package priorityQueue;

/**
 * It's represent the queue item  with its priority.

 */
public class Item
{
	String data;
	int priority;

	/**
	 * Constructor initialize the data member.
	 * @param item
	 * @param priority
	 */
	public Item(String item, int priority)
	{
		this.data = item;
		this.priority = priority;
	}
	
	//Return the queue item name.
	public String getItem() 
	{
		return data;
	}
	
	//Return the queue item priority.
	public int getPriority() 
	{
		return priority;
	}
}