package LinkedList;

/**
 * Class implement quick sort on linked list.
 */
public class QuickSortLinkedList 
{
	Node head = null;
	Node rear = null;

	/**
	 *Method to add new employee on list. 
	 * @param data is the value of the new node to be added
	 */
	public void add(Employee emp)
	{
		Node newNode = new Node(emp);
		if (head == null) 
		{
			head = newNode;
			rear = newNode;
		}
		else 
		{
			rear.next = newNode;
			rear = newNode;
		}
	}

	/**
	 * Method to perform quick sort
	 * @param front is the first element of the list
	 * @param last  is the last element of the list
	 */
	public void quickSort(Node front, Node last) 
	{
		if (front == null) 
		{
			throw new AssertionError("Empty linked list");
		}
		else 
		{
			recursiveQuickSort(front, last);
		}
	}
	
	/**
	 * Method to print employee list.
	 * @param front the first node of the list
	 * @param last the last node of the list
	 */
	public void showLinkedList(Node front, Node last) 
	{
		Node currentNode = front;
		while (currentNode != last) 
		{
			System.out.println(currentNode.emp.getEmpName() );
			currentNode = currentNode.next;
		}
		
		System.out.println(currentNode.emp.getEmpName());
	}

	/**
	 * Method return the pivot element
	 * @param front is the first node of the list
	 * @param last  is the last node of the list
	 * @return returns the pivot node
	 */
	private Node partition(Node front, Node last) 
	{
		Node currentNode;
		Employee temp;
		if (this.head == front) 
		{
			currentNode = null;
		}
		else
		{
			currentNode = head;
			while (currentNode.next != front) 
			{
				currentNode = currentNode.next;
			}
		}
		Node tempFrontNode = currentNode;
		Employee pivot = last.emp;
		Node curNode = front;
		while (curNode != last) 
		{
			if (curNode.emp.getSalary() > pivot.getSalary()
					|| ((curNode.emp.getSalary() == pivot.getSalary()) && (curNode.emp.getAge() < pivot.getAge()))) 
			{
				if (tempFrontNode == null)
				{
					tempFrontNode = front;
				}
				else 
				{
					tempFrontNode= tempFrontNode.next;
				}
				
				temp = tempFrontNode.emp;
				tempFrontNode.emp = curNode.emp;
				curNode.emp = temp;
			}
			
			curNode = curNode.next;
		}
		if (tempFrontNode == null) 
		{
			tempFrontNode = front;
		} 
		else 
		{
			tempFrontNode = tempFrontNode.next;
		}
		temp = tempFrontNode.emp;
		tempFrontNode.emp = last.emp;
		last.emp = temp;
		
		return tempFrontNode;
	}

	/**
	 *Recursive method to perform quick sort
	 * @param front the first element of the list
	 * @param last the last element of the list
	 */
	private void recursiveQuickSort(Node front, Node last) 
	{
		if (last == front.next) 
		{
			if ((front.emp.getSalary() < last.emp.getSalary()) || ((front.emp.getSalary() == last.emp.getSalary())
					&& (front.emp.getAge() < last.emp.getAge()))) 
			{
				Employee temp = front.emp;
				front.emp = last.emp;
				last.emp = temp;
			}
		}
		else if (front != null && last != front) 
		{
			Node partition = partition(front, last);
			Node currentNode = front;
			while (currentNode.next != partition) 
			{
				currentNode = currentNode.next;
			}
			recursiveQuickSort(front, currentNode);
			recursiveQuickSort(partition.next, last);
		}
	}

	
	public static void main(String[] args)
	{
		QuickSortLinkedList linkedlist = new QuickSortLinkedList();
		Employee employee1 = new Employee("atul",22,15000);
		Employee employee2 = new Employee("devang",22,32000);
		Employee employee3 = new Employee("rahul",22,25000);
		Employee employee4 = new Employee("Vinay",21,25000);
		linkedlist.add(employee1);
		linkedlist.add(employee2);
		linkedlist.add(employee3);
		linkedlist.add(employee4);

		linkedlist.showLinkedList(linkedlist.head, linkedlist.rear);
		linkedlist.quickSort(linkedlist.head, linkedlist.rear);
		linkedlist.showLinkedList(linkedlist.head, linkedlist.rear);
	}

}