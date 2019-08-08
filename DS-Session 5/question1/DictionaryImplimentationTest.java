package question1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DictionaryImplimentationTest 
{
	 JsonFileReader js = new JsonFileReader();
	 DictionaryImplimentation dictionary = new DictionaryImplimentation();
     @Before
     public void initialize()
     {
 		js.readJsonFile();	
     }
   
     @Test
     public void getSortedTest()
     {
    	 
     }
}
