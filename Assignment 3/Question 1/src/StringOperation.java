/**
 * @author Admin
 * It have only Method as specified requirements.
 * It perform  Compare the string, Reverse the String, Change the case of String Vice-Versa  
 */
public class StringOperation
{
	/**
	 * @param str1 is the give input of String form 
	 * @param str2 is the give input of String form 
	 * @return "0" for String is not equal and "1" for String is not equal 
	 */
	public int isEqual(String str1, String str2) 
	{	
		int length1 = str1.length();
		int length2 = str2.length();
		if (length1 == length2) 
		{
			return 0;
		}
		else 
		{
			// if length is equal then check weather they are same by iterating
			for (int index = 0; index < length1; index++) 
			{
				if (str1.charAt(index) != str2.charAt(index)) 
				{	
					return 0;
		    	}	
			}
			return 1;
		}
	}
    
	/**
	 * 
	 * @param str is the give input of String form 
	 * @return reverse String 
	 */
	public String reverse(String str) 
	{
		String revString = "";
		int length = str.length();
		for (int index = length - 1; index >= 0; index--)
		{
			revString = revString + str.charAt(index);
		}
		return revString;
	}

   /**
    * It changed the case of String vice-versa.
    * @param str is the give input of String form 
    * @return Case Converted String 
    */
	public String swapCase(String str)
	{
		int asciiValueOfChar = 0;
		int convertedCaseAsciiValue = 0;
		String caseConvertedString = "";
		int length = str.length();
		for (int index = 0; index < length; index++)
		{
			asciiValueOfChar = str.charAt(index);

			if (asciiValueOfChar >= 65 & asciiValueOfChar <= 90) 
			{
				convertedCaseAsciiValue = asciiValueOfChar + 32;
			}
			else if (asciiValueOfChar >= 97 & asciiValueOfChar <= 122)
			{
				convertedCaseAsciiValue = asciiValueOfChar - 32;
			}
			else
			{	
				convertedCaseAsciiValue = asciiValueOfChar;
			}
			caseConvertedString += (char) (convertedCaseAsciiValue);
		}
		return caseConvertedString;
	}
	
	/**
	 * 
	 * @param str
	 * @return largest Word from the String
	 */
	public String largestWord(String str)
	{
		 String[] words = str.split(" "); 
	     int length = 0;
	     String largestWord = "";
	     
	     for(String word:words)
	     {     
	    	int templength = word.length(); 
	        if(length <= templength)
	        { 
	           length = templength; 
	           largestWord = word;
	        }  
	     } 
	        return largestWord; 
	}
}
