package question2;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class BinarySearchTest {
	 private int inputNumber[];
	 private int findNum;
	 private int expectedResult;
	 private SearchAlgorithm search;
	 
	 @Before
	 public void initialize() {
		 search = new SearchAlgorithm();
	 }
	 
	 public BinarySearchTest(int[] inputNumber, int findNum, Integer expectedResult) {
	      this.inputNumber = inputNumber;
	      this.findNum = findNum;
	      this.expectedResult = expectedResult;
	 }
	 
	 @Parameterized.Parameters
	   public static Collection<Object[]> parameters() {
	      return Arrays.asList(new Object[][] {
	         { new int[]{1, 2, 3, 8, 9, },3, 2 },
	         {  new int[]{3,4,7,9,10,20,30},9, 3 },
	         {  new int[]{100,120,200},100, 0 },
	         { new int[] {1,2,3,4,5,6}, 7, -1}
	      });
	   }
	   
	   @Test
	   public void testLinearSearch() {
		  for(int arr1 : inputNumber){
			  System.out.print(" " + arr1);
		  }
	      System.out.println();
	      assertEquals(expectedResult, 
	      search.takeInputForBinarySearch(inputNumber, findNum));
	   } 
}