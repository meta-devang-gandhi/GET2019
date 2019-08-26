package question1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *Implementation of dictionary class.
 *Use binary search tree approach. 
 */
public class DictionaryImplimentation implements IDictionary
{
	DictionaryNode root;
	Map<Integer, String> sortedList = new LinkedHashMap<Integer, String>();
	Map<Integer, String> sortedInRange = new LinkedHashMap<Integer, String>();
 
	/**
	 * Method add the node on bst tree.
	 */
	@Override
	public void add(DictionaryNode node) 
	{
		root =	bstNodeAdd(root, node);
	}

	/**
	 * Method to delete the node from bst tree.
	 */
	@Override
	public void delete(int key) 
	{
		root = bstNodeDelete(root, key);
		
	}
	
	/**
	 * Method to find value of corresponding key.
	 */
	@Override
	public String getValue(int key) 
	{
		return findValue(root, key).value;
	}
	
	/**
	 * Method to sort the bst tree from comparing key.
	 */
	@Override
	public Map<Integer, String> sorted()
	{
		addSortedListInMap(root);
		return sortedList;
	}
	
	/**
	 * Method to sort tree between range of key.
	 */
	@Override
	public Map<Integer, String> sortedInRange(int key1, int key2)
	{
		addListOfKey1ToKey2( root, key1, key2);	
		return sortedInRange;
	}
	
	/**
	 * Method to traverse tree as inorder.
	 */
	public void inorder()  
   	{
		 printInorder(root); 
    }
	
	/**
	 * Method to add node
	 * Follow the bst tree approach.
	 * @param root
	 * @param node which is added.
	 * @return
	 */
	private DictionaryNode bstNodeAdd(DictionaryNode root, DictionaryNode node)
	{
		try
		{
			if(root == null)
			{
				root = node;
				return root;
		    }
		     if(root.key < node.key)
		     {
			    root.right = bstNodeAdd(root.right, node);
		     }
		     else if(root.key > node.key)
		     {
		    	 root.left = bstNodeAdd(root.left, node);
		     }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	     
	     return root;	
	}
	
	/**
	 * Method to delete node from bst tree.
	 * @param root
	 * @param key which node want to delete.
	 * @return
	 */
	private DictionaryNode bstNodeDelete(DictionaryNode root, int key)
	{
		try
		{
	        if(root == null)
	        {
	        	return root;
	        }
	  
	        if(key < root.key) 
	        {
	            root.left = bstNodeDelete(root.left, key);
	        }
	        else if(key > root.key)
	        {
	            root.right = bstNodeDelete(root.right, key);
	        }
	        else
	        { 
	            if (root.left == null) 
	            {
	                return root.right;
	            }
	            else if (root.right == null)
	            {
	                return root.left;
	            }
	            
	            root.key = getInorderSuccessor(root.right); 
	  
	            // Delete the inorder successor 
	            root.right = bstNodeDelete(root.right, root.key); 
	        } 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
        return root; 
	}
	
	/**
	 * Method to find inorder successor of node.
	 * @param root
	 * @return
	 */
	private int getInorderSuccessor(DictionaryNode root) 
    { 
        int inorderSuccessor = root.key; 
        try
        {
	        while (root.left != null) 
	        { 
	        	inorderSuccessor = root.left.key; 
	            root = root.left; 
	        }
        }
        catch(Exception e)
		{
			System.out.println(e);
		}
        
        return inorderSuccessor; 
    } 
	
	/**
	 * Method to find value of particular key.
	 * @param root
	 * @param key
	 * @return
	 */
	private DictionaryNode findValue(DictionaryNode root, int key)
	{
		try
		{
			if(root.key == key)
			{
				return root;
			}
			else if(root.key < key)
			{
				return findValue(root.right, key);
			}
			else if(root.key >= key)
			{
				return findValue(root.left, key);
			}
			else
			{
				throw new Exception("Key is not found.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}
	
	/**
	 * Method to sort bst tree.
	 * @param root
	 */
	private void addSortedListInMap(DictionaryNode root)
	{
		try
		{
			if(root != null)
			{
				addSortedListInMap(root.left);
				sortedList.put(root.key, root.value);
				addSortedListInMap(root.right);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	/**
	 * Method to sort the tree between key range.
	 * @param root
	 * @param key1
	 * @param key2
	 */
	private void addListOfKey1ToKey2(DictionaryNode root, int key1, int key2)
	{
		try
		{
			for(Entry<Integer, String> list : sortedList.entrySet())
			{
				if(list.getKey() >= key1 && list.getKey() <= key2)
				{
					sortedInRange.put(list.getKey(), list.getValue());
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	 /**
	  * Method to print the inorder sequence of node.    
	  * @param rootNode
	  */
    private void printInorder(DictionaryNode rootNode) 
	{ 
	   if (rootNode != null) 
	   { 
	       printInorder(rootNode.left); 
	       System.out.print(rootNode.key+"  "); 
	       System.out.println(rootNode.value); 
	       printInorder(rootNode.right); 
	   } 
	} 
}
