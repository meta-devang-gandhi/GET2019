package question1;

/**
 * Class is use to perform linked list operation.
 * @author Devang
 */
public class MyLinkedList 
{
	// hold the first node reference.
	Node head;
	
	/**
	 * Method to add node on linked list
	 * @param list object of linked list.
	 * @param data  
	 * @return  linked list
	 */
	public Response<MyLinkedList> addNode(MyLinkedList list, String data)
	{
		Response<MyLinkedList> response1 = new Response<MyLinkedList>();
		
		Node newNode = new Node(data);
		newNode.next = null;
		
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			Node lastNode = head;
			
			while(lastNode.next != null)
			{
				lastNode = lastNode.next;
			}
			
			lastNode.next = newNode; 
 		}
		
		response1.setType(list);
		return response1;
	}
	
	/**
	 * Method to perform modification as given specification. 
	 * @param list Reference of linked list
	 * @param indexOfLeftPosition First index of sub list
	 * @param indexOfRigthPosition  Last index of sub list
	 * @param numberOfRotation  Number of rotation which perform on sublist.
	 * @return Modified linked list
	 * @throws Exception
	 */
	public Response<MyLinkedList> modifiedlikedList(MyLinkedList list,int indexOfLeftPosition, int indexOfRigthPosition, int numberOfRotation) throws Exception
	{
		Response<MyLinkedList> response2 = new Response<MyLinkedList>();
		
		MyLinkedList subList = new MyLinkedList();
		int lengthOfSubList = indexOfRigthPosition - indexOfLeftPosition + 1, indexOfNode = 0;
		
		Node priviousNodeOfLeftPosition, nodeOfLeftIndexPosition = null,  node = list.head;
	
		if(indexOfLeftPosition <= indexOfRigthPosition)
		{
			try
			{
				while(node != null)
				{
					indexOfNode++;
					priviousNodeOfLeftPosition = nodeOfLeftIndexPosition;
					nodeOfLeftIndexPosition = node;
					
					if(indexOfNode == indexOfLeftPosition)
					{
						int length = 0;
						
						//add the node on sublist between indexOfLeftPosition and indexOfRigthPosition
						while(indexOfNode <= indexOfRigthPosition && node != null)
						{
							subList.addNode(subList, node.getData());
							node = node.next;
							length++;
							indexOfNode++;
						}
						
						// When right index position is not exist on linked list.
						if(length != lengthOfSubList)
						{
							 response2.setErrorMessage("Sub Linked list not exist");
							 response2.setSuccess(false);
							 
							 return response2;
						}
						else
						{
							subList = rotatedSubList(subList, numberOfRotation, lengthOfSubList);
							
							// if left position index is 1. 
							if(priviousNodeOfLeftPosition == null)
							{			
							    Node subListTraverse = subList.head;
							    
								while(subListTraverse.next != null)
								{
									subListTraverse = subListTraverse.next;
								}
								
								subListTraverse.next = node;
								response2.setType(list);
								response2.setSuccess(true);
								
								return response2;
							}
							else
							{
								priviousNodeOfLeftPosition.next = subList.head;
								Node subListTraverse = subList.head;
								
								while(subListTraverse.next != null)
								{
									subListTraverse = subListTraverse.next;
								}
								
								subListTraverse.next = node;
								response2.setType(subList);
								response2.setSuccess(true);
								
								return response2;
							}
						}
					}
					
					if(node != null)
					{
					   node = node.next;
					}
				}
				
			}
		     catch(Exception e)
		    {
               response2.setErrorMessage(e.getMessage());
			   response2.setSuccess(false);
				
				return response2;
		    }
	     }
	     else
	     {
	         response2.setErrorMessage("Enter left or rigth index position is wrong");
			 response2.setSuccess(false);
			 
	         return response2;
	     }
		
		response2.setType(list);
		response2.setSuccess(true);
		
		return response2;	
	 }
	
	/**
	 * Method check the loop exist or not on linked list.
	 * @param list
	 * @return true if loop exist else false.
	 */
	  public boolean ifLoopExists(MyLinkedList list) 
	  {
		  Node fastIterator = list.head;
		  Node slowIterator = list.head;
		  
		  while (fastIterator != null && fastIterator.next != null) 
		  {
		      fastIterator = fastIterator.next.next;
		      slowIterator = slowIterator.next;
		   
		    return  (slowIterator == fastIterator);
		  }
		  
		  return false;	  
	 }
	
	  /*
	   * Method print the element of linked list.
	   */
	  public static void printList(MyLinkedList list) 
      { 
	       Node currNode = list.head; 
	 
	       while (currNode != null)
	       { 
	            System.out.print(currNode.data + " ");
	            currNode = currNode.next; 
	       } 
	          
	        System.out.println(); 
	   }
	
	  /**
	   * Method to rotated the list as clock wise. 
	   * @param subList
	   * @param numberOfRotation 
	   * @param lengthOfSubList
	   * @return rotated list
	   */
	  private MyLinkedList rotatedSubList(MyLinkedList subList, int numberOfRotation, int lengthOfSubList)
	  {
		  int indexOfHeadOfSublist = lengthOfSubList - numberOfRotation + 1, counter = 0;
		  Node lastNodeOfSubList = null,  node = subList.head , firstNodeOfSubList = node;
		  
		  try
		  {
			  while(counter < indexOfHeadOfSublist - 1)
			  {
				  lastNodeOfSubList = node;
				  node = node.next;
				  counter++;
			  }
			  
			  subList.head = node;  
			  
			  while(node.next != null)
			  {
				  node = node.next;
			  }
			
			  node.next = firstNodeOfSubList;
			  lastNodeOfSubList.next = null; 
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  return subList;
	  }	
}
