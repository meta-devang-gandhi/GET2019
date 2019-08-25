package LinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuickSort 
{	
	@Test
	public void testQuickSort() 
	{
		QuickSortLinkedList QLinkedList = new QuickSortLinkedList();
		
		Employee employee1 = new Employee("atul",22,15000);
		Employee employee2 = new Employee("devang",22,32000);
		Employee employee3 = new Employee("rahul",22,25000);
		Employee employee4 = new Employee("Vinay",21,25000);
		
		QLinkedList.add(employee1);
		QLinkedList.add(employee2);
		QLinkedList.add(employee3);
		QLinkedList.add(employee4);
		
		QLinkedList.quickSort(QLinkedList.head, QLinkedList.rear);
		QuickSortLinkedList expectedLinkedList = new QuickSortLinkedList();
		expectedLinkedList.add(employee2);
		expectedLinkedList.add(employee4);
		expectedLinkedList.add(employee3);
		expectedLinkedList.add(employee1);
		
	    assertEquals(expectedLinkedList, QLinkedList);
	}
	@Test(expected=AssertionError.class)
	public void testQuickSortForEmptyList() 
	{
		QuickSortLinkedList linkedlist = new QuickSortLinkedList();
		linkedlist.quickSort(linkedlist.head, linkedlist.rear);
	}

}