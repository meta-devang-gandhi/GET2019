package question2;

import java.util.Arrays; 

/**
 * Class have method for Searching Algorithm.
 * @author Devang
 *
 */
public class SearchAlgorithm 
{
	/**
	 * It is private method for BinarySearch.
	 * Here All input is validate
	 * @param array "Input Index"
	 * @param firstIndex " first index of array from where you want to search"
	 * @param lastIndex " last index of array  where you want to search"
	 * @param searchValue "value which want to search"
	 * @return
	 */
	    private int binarySearch(int array[], int firstIndex, int lastIndex, int searchValue) 
	    { 
	        if (lastIndex >= firstIndex)
	        { 
	            int midIndex = firstIndex + (lastIndex - firstIndex) / 2; 
	  
	            if (array[midIndex] == searchValue) 
	            {
	                return midIndex;
	            }
	  
	            if (array[midIndex] > searchValue) 
	            {
	                return binarySearch(array, firstIndex, midIndex - 1, searchValue);
	            }
	   
	            return binarySearch(array, midIndex + 1, lastIndex, searchValue); 
	        } 
	  
	        return -1; 
	    }
	    
	    /**
	     * It take a input and check input then call BinarySearch Method
	     * @param array "Input Index"
	     * @param searchValue "value which want to search"
	     * @return "index of search value "
	     * @throws AssertionError
	     */
	    public int takeInputForBinarySearch(int array[], int searchValue)throws AssertionError
	    {
	    	 int length = array.length;
	    	 if(length == 0)
	    	 {
	    		 throw new AssertionError("Array is Empty");
	    	 }
	    	 Arrays.sort(array);
	    	 int searchValueIndex = binarySearch(array, 0, length-1, searchValue);
	    	return searchValueIndex;
	    }
	    
	    /**
	     * It is private method for LinearSearch.
	     * Here All input is validate
	     * @param array "Input Index"
	     * @param searchValue "value to search on array"
	     * @param index "index where you search searchValue "
	     * @param length "length of array"
	     * @return  index of search value else -1
	     */
	    private int linearSearch(int array[], int searchValue, int index, int length)
	    {
	    	if(index <= length)
	    	{
	    	  if(array[index] == searchValue)
	    	  {
	    		return index;
	    	  }
	    	  else
	    	  {
	    		 return linearSearch(array, searchValue, ++index, length);
	    	  }
	    	} 
	    	return -1;
	    }
	    
	    /**
	     * It take a input then call LinearSearch Method.
	     * @param array "Input Value"
	     * @param searchValue "Value which you want to search on array"
	     * @return index of search value.
	     * @throws AssertionError
	     */
	    public int takeInputForLinearSearch(int array[], int searchValue)throws AssertionError
	    {
	    	 int length = array.length;
	    	 if(length == 0)
	    	 {
	    		 throw new AssertionError("Array is Empty");
	    	 }
	    	 
	    	return linearSearch(array, searchValue, 0, length-1);
	    }
}
