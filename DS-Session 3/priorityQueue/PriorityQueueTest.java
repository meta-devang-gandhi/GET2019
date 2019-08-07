package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest 

{
	PriorityQueue queue = new PriorityQueue(5);
    @Before
    public void initialize()
    {
    	queue.enqueueItem("abc1", 1);
    
    	queue.enqueueItem("abc2", 10);

    	queue.enqueueItem("abc3", 5);
 
    	queue.enqueueItem("abc4", 12);
    	
    	queue.enqueueItem("abc", 9);
    }
    
    @Test
    public void queueAsPriorityPrint()
    {
    	int expected[] = new int[] {12, 10, 9, 5, 1};
    	int actual[] = new int[5];
    	Item Itemqueue[] = queue.getPriorityQueue();
    	int length = Itemqueue.length;
    	
    	for(int i = 0; i < length; i++)
    	{
    		actual[i] = Itemqueue[i].getPriority();
    	}
    	
    	assertArrayEquals(expected, actual);
    }
    
    @Test
    public void deQueueTest()
    {
    	int expected = 12;
    	int actual = queue.dequeueItem().getPriority();
    	
    	assertEquals(expected, actual);
    }
}
