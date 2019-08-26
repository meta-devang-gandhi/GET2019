package question1;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DictionaryImplimentationTest 
{
	 JsonFileReader js = new JsonFileReader();
	 DictionaryImplimentation dictionary ;
     @Before
     public void initialize()
     {
    	 js.readJsonFile();	
 		js.splitKeyAndValueOfJsonArray();
 		dictionary = js.getObj();
     }
   
     @Test
     public void getSortedRangeTest()
     {
    	Map<Integer, String> actual = dictionary.sortedInRange(10,17);
    	Map<Integer, String> expected = new LinkedHashMap<Integer, String>();
    	expected.put(10, "ten");
    	expected.put(11, "eleven");
    	expected.put(12, "twelve");
    	expected.put(13, "thirteen");
    	expected.put(14, "fourteen");
    	expected.put(15, "fifteen");
    	expected.put(16, "sixteen");
    	expected.put(17, "seventeen");
    	System.out.println(actual);
    	System.out.println(expected);
    	assertEquals(expected, actual);
     }
     
     @Test
     public void getSortedList()
     {
    	Map<Integer, String> actual = dictionary.sorted();
    	Map<Integer, String> expected = new LinkedHashMap<Integer, String>();
    	expected.put(1, "one");
    	expected.put(2, "two");
    	expected.put(3, "three");
    	expected.put(4, "four");
    	expected.put(5, "five");
    	expected.put(6, "six");
    	expected.put(7, "seven");
    	expected.put(8, "eight");
    	expected.put(9, "nine");
    	expected.put(10, "ten");
    	expected.put(11, "eleven");
    	expected.put(12, "twelve");
    	expected.put(13, "thirteen");
    	expected.put(14, "fourteen");
    	expected.put(15, "fifteen");
    	expected.put(16, "sixteen");
    	expected.put(17, "seventeen");
    	System.out.println(actual);
    	System.out.println(expected);
    	assertEquals(expected, actual);
     }
     
     @Test
     public void getValueTest()
     {
    	 String actual = dictionary.getValue(10);
    	String expected = "ten";
    	System.out.println(actual);
    	assertEquals(expected, actual);	
     }
}
