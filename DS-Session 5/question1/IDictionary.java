package question1;

import java.util.Map;

/**
 *Interface of dictionary. 
 */
public interface IDictionary 
{
	//Method to add node in bst tree.
	public void add(DictionaryNode node);
	
	//Method to delete node from bst tree.
	public void delete(int key);
	
	//Method find the value of key.
	public String getValue(int key);
	
	//Method to sorted the bst tree and arrange the sorted node of bst tree on map. 
	public Map<Integer, String> sorted();
	
	//Method to sorted the bst tree between two key.
	public Map<Integer, String> sortedInRange(int key1, int key2);
}
