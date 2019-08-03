package question2;

import java.util.HashMap;
import java.util.Map;

/**
 *Class for count unique character from string.
 */
public class UniqueCharacter
{
	Map<String, Integer> uniqueChar = new HashMap<String, Integer>();

	/**
	 * Count the unique character from string.
	 * @param string
	 * @return number of unique character.
	 */
	public int countUniqueCharacter(String string) 
	{	
		string = string.toLowerCase();
		
		int noOfUniqueChar = 0;
		char currentChar = 0;

		// if we already have string on map then we direct get the number of unique char and return it.
		if (uniqueChar.containsKey(string)) 
		{
			return uniqueChar.get(string);
		} 
		else 
		{
			Map<Character, Integer> uniqueCharMap = new HashMap<Character, Integer>();
			
			try
			{
				for (int currentCharIndex = 0; currentCharIndex < string.length(); currentCharIndex++) 
				{
					currentChar = string.charAt(currentCharIndex);
					uniqueCharMap.put(currentChar, uniqueCharMap.getOrDefault(currentChar, 0) + 1);
				}
	
				for (Character currentCharKey : uniqueCharMap.keySet()) 
				{
					if (uniqueCharMap.get(currentCharKey) == 1) 
					{
						noOfUniqueChar++;
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			uniqueChar.put(string, noOfUniqueChar);
			return noOfUniqueChar;
		}
	}
	
	public static void main(String[] args) 
	{
		UniqueCharacter uniqueCharacterInString = new UniqueCharacter ();
		System.out.println(  uniqueCharacterInString.countUniqueCharacter("devannngg gggggadhi"));
		System.out.println(  uniqueCharacterInString.countUniqueCharacter("devannngg gggggadhi"));
	}
}