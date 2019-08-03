package priorityQueue;

public interface IQueue<T>
{
	//Method add element to the queue if its not full	
	public boolean enQueue(T value, int priority);
	
	// Method remove element from the queue
	public String deQueue();
	
	//Method check the queue is empty or not.
	public boolean isEmpty();
	
	//Method check the queue is full or not.
	public boolean isFull();
}
