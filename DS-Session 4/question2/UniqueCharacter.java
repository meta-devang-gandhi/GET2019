package question2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *Class for count unique character from string.
 */
public class UniqueCharacter
{
	private Map<String,Integer> cacheMap;
	
	void setCache(Map<String, Integer> cacheMap) 
	{
		this.cacheMap = cacheMap;
	}
	
	UniqueCharacter()
	{	
		this.cacheMap = new HashMap<String, Integer>();
	}
	
	/**
	 *Counts the number of unique characters in a string
	 * @param inputString is to be checked.
	 * @return numbers of unique character. 
	 */
	int countUniqueCharacters(String inputString) 
	{	
		Set<Character> uniqueCharSet = new HashSet<Character>();
		try
		{
			if(inputString == null || inputString.equals(" "))
			{	
				throw new Exception("input string is invalid");	
			}
			else
			{
				if(cacheMap.containsKey(inputString))
				{
					return cacheMap.get(inputString);
				}
				else
				{	
					inputString = inputString.toLowerCase();
					
					int length = inputString.length();
					for(int index = 0; index < length; index++)
					{	
						char charAtIndex = inputString.charAt(index);
						
						if(charAtIndex == ' ')
						{
							continue;
						}
						else
						{
							if(uniqueCharSet.contains(charAtIndex) == false)
							{
								uniqueCharSet.add(charAtIndex);
							}
						}
					}
				}
			}
			
			cacheMap.put(inputString, uniqueCharSet.size());
			return uniqueCharSet.size();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return 0;
	}
	
	public static void main(String[] args) 
	{
		UniqueCharacter uniqueCharacterInString = new UniqueCharacter ();
		System.out.println(  uniqueCharacterInString.countUniqueCharacters("devannngg gggggadhi"));
		System.out.println(  uniqueCharacterInString.countUniqueCharacters("devannngg gggggadhi"));
	}
}
