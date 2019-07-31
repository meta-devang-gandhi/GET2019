package question1;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest 
{
	MyLinkedList list = new MyLinkedList();
	Response<MyLinkedList> response = new Response<MyLinkedList>();
	
	@Before
	public void initialize()
	{
	    response = list.addNode(response.getType(), "1");
	    response = list.addNode(response.getType(), "2");
	    response = list.addNode(response.getType(), "3");
	    response = list.addNode(response.getType(), "4");
	    response = list.addNode(response.getType(), "5");
	    response = list.addNode(response.getType(), "6");
	    response = list.addNode(response.getType(), "7");
	    response = list.addNode(response.getType(), "8");
	    response = list.addNode(response.getType(), "9");
	    
	}
	
	@Test
	public void testModifiedLinkedList() throws Exception
	{
		response = list.modifiedlikedList(list, 2, 6, 2);
		String expected[] = new String[]{"1","5","6","2","3","4","7","8","9"};
		String actual[] = new String[8];
		
		Node node = response.getType().head;
		int index = 0;
		while(node != null)
		{
			actual[index] = node.data;
			index++;
			node = node.next;
		}
		
		 assertArrayEquals(expected, actual);
		
	}


}
