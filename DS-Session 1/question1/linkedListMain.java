package question1;

/**
 * Class to call method of linkedList.
 */
public class linkedListMain 
{
    public static void main(String arg[]) throws Exception 
    {
    	MyLinkedList list = (MyLinkedList) new MyLinkedList();
    	Response<MyLinkedList> response = new Response<MyLinkedList>();

    	response = list.addNode(list, "1");	
    	response = list.addNode(response.getType(), "2");
    	response = list.addNode(response.getType(), "3");
    	response = list.addNode(response.getType(), "4");
    	response = list.addNode(response.getType(), "5");
    	response = list.addNode(response.getType(), "6");	
    	response = list.addNode(response.getType(), "7");	
    	response = list.addNode(response.getType(), "8");	
    	list.printList(response.getType());
    	
    	Response<MyLinkedList> response1 = new Response<MyLinkedList>();
    	response1 = list.modifiedlikedList(response.getType(),1, 5, 2);
     	list.printList(response1.getType());
        list.head.next.next.next.next = list.head;
        System.out.println(list.ifLoopExists(list));
   
	}	 
}
