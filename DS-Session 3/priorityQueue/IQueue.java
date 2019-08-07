package priorityQueue;

/**
 *Represent the queue interface.
 */
public interface IQueue 
{
	//Method to add item in queue.
	public void enqueueItem(String data, int priority);
	
	//Method to remove item from queue.
	public Item dequeueItem();
	
	//check the queue is full or not.
	public boolean isQueueFull();
	
	//Check the queue is empty or not.
	public boolean isQueueEmpty();	
}