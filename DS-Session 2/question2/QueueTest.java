package question2;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest
{
	@Test
	public void enQueueMethodPositiveCasesTest() throws Exception
	{	
		Queue queue = new Queue();
		assertTrue(queue.enQueue(1));
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(4));
		assertTrue(queue.enQueue(5));
		assertTrue(queue.enQueue(6));
		assertTrue(queue.enQueue(7));
		assertTrue(queue.enQueue(8));
		assertTrue(queue.enQueue(9));
		assertTrue(queue.enQueue(10));	
	}

	@Test
	public void deQueueMethodPositiveCasesTest() throws Exception
	{	
		Queue queue = new Queue();
		
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);
		queue.enQueue(8);
		queue.enQueue(9);
		queue.enQueue(10);
		
		assertEquals(1,queue.deQueue());
		assertEquals(2,queue.deQueue());
		assertEquals(3,queue.deQueue());
		assertEquals(4,queue.deQueue());
		assertEquals(5,queue.deQueue());
		assertEquals(6,queue.deQueue());
		assertEquals(7,queue.deQueue());
		assertEquals(8,queue.deQueue());
		assertEquals(9,queue.deQueue());
		assertEquals(10,queue.deQueue());
		
	}

	@Test
	public void isEmptyMethodPositiveCasesTest() 
	{
		Queue queue = new Queue();
		assertTrue(queue.isEmpty());
	}
	
	@Test(expected = Exception.class)
	public void enQueueMethodNegativeCasesTest() throws Exception
	{	
		Queue queue = new Queue();
		assertTrue(queue.enQueue(1));
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(4));
		assertTrue(queue.enQueue(5));
		assertTrue(queue.enQueue(6));
		assertTrue(queue.enQueue(7));
		assertTrue(queue.enQueue(8));
		assertTrue(queue.enQueue(9));
		assertTrue(queue.enQueue(10));	
		
		assertTrue(queue.enQueue(11));
	}

	@Test(expected = Exception.class)
	public void deQueueMethodNegativeCasesTest() throws Exception 
	{	
		Queue queue = new Queue();
		assertEquals(11,queue.deQueue());	
	}
}
