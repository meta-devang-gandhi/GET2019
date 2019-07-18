package arrOperation;

/**
 * @author Devang
 *  It is a method class of Array operation as specified on problem 
 */
public class ArrOperation {

	/**
	 * It find the largest length of mirror section of the array.
	 * Method handle all type Exception
	 * @param aar  Input Array
	 * @return maxLengthMirror "length of maxMirror"
	 */
	public int findMaxMirror(int[] arr)throws AssertionError
	{
        int length = arr.length;
        
        if(length == 0)
        {
        	throw new AssertionError("Array is empty"); 
        }
        else
        {
        	boolean checkInputValidation = inputValidator(arr);
        	if(checkInputValidation == false)
        	{
        		throw new AssertionError("Your input is not positive or not valid");
        	}
        }
        
        int maxLengthMirror = 0;
		for (int i = 0; i < length; i++)
		{
			int mirrorLength = 0;
			for (int j = length - 1; j >= 0 && i + mirrorLength < length; j--)
			{
				if (arr[i + mirrorLength] == arr[j])
				{
					mirrorLength++;
				}
				else 
				{
					if (maxLengthMirror < mirrorLength)
					{
						maxLengthMirror = mirrorLength;
			    	}
					mirrorLength = 0;
				}
			}

			maxLengthMirror = Math.max(maxLengthMirror, mirrorLength);
			mirrorLength = 0;
		}

		return maxLengthMirror;
	}
	
	/**
	 * It find the no of Clumps from the array
	 * Method handle all type Exception
	 * @param arr "Input array"
	 * @return countClumps " no of Clumps "
	 */
	public int countClumps(int[] arr)throws AssertionError
	{
	    int length = arr.length;
	   
	    if (length == 0)
	    {
	    	throw new AssertionError("Array is empty");
	    }
	    else
        {
        	boolean checkInputValidation = inputValidator(arr);
        	if(checkInputValidation == false)
        	{
        		throw new AssertionError("Your input is not positive or not valid");
        	}
        }
	    
	    int  countClumps = 0;
	    
	    for(int index = 1; index < length; index++)
	    { 
	        if(arr[index] == arr[index-1])
	        {
	            countClumps++;
	            while(( index < length-1  && arr[index] == arr[index+1] ))
	            {
	            	index++;
	            }  
	        } 
	    }

	    return countClumps;   
	}
	
	/**
	 * It method used to find the index where sum of leftSet and RightSet is equal.
	 * Method handle all type Exception
	 * @param arr "Input Array"
	 * @return currentIndexOfLeftSplit "index  no " -1 "Sum of leftSet and rightSet is not equal"
	 */
	public int findSplitIndex(int arr[])throws AssertionError
	{ 
		int length = arr.length;
		
		 if (length == 0)
	    {
   	    	throw new AssertionError("Array is empty");
	    }
	    else
        {
	    	boolean checkInputValidation = inputValidator(arr);
	       	if(checkInputValidation == false)
	       	{
	    		throw new AssertionError("Your input is not positive or not valid");
	       	}
        }
		 
	    int leftOfSplitSum = 0; 
	    int rightOfSplitSum = 0;
	    
	    for (int currentIndexOfLeftSplit = 0; currentIndexOfLeftSplit < length-1; currentIndexOfLeftSplit++) 
	    { 
	        leftOfSplitSum += arr[currentIndexOfLeftSplit] ; 
	        rightOfSplitSum = 0;
	        for (int currentIndexOfRightSplit = currentIndexOfLeftSplit+1; currentIndexOfRightSplit < length; currentIndexOfRightSplit++ )
	        {
	             rightOfSplitSum += arr[currentIndexOfRightSplit] ; 
	        }
	      
	        if (leftOfSplitSum == rightOfSplitSum) 
	        {
	            return currentIndexOfLeftSplit+1 ;
	        }
	    } 
	
	    return -1; 
	} 
	
	/**
	 *  rearranged the array as specified in problem
	 *  Method handle all type Exception  
	 * @param arr "input array"
	 * @param x   " X is immediately followed by a Y parameter on array when we return the array || We can't move the x parameter in array  "
	 * @param y   " y  is movable on array"
	 * @return arr " rearranged array"
	 */
	public int[] fixXY(int[] arr, int x, int y) 
	{
		int length = arr.length;
		 if (length == 0)
		 {
	   	   	throw new AssertionError("Array is empty");
	     }
	   else
	   {
		   boolean checkInputValidation = inputValidator(arr);
	       if(checkInputValidation == false)
		   {
		      throw new AssertionError("Your input is not positive or not valid");
		   }
	    }
		 
		 if(x < 0 || y < 0)
		 {
			 	throw new AssertionError("Integer value is not valid ");
		 }
		 
		 // handle unequal number of X and Y
		 int countX = 0;
		 int countY = 0; 
		 for(int value : arr)
		 {
			 if(value == x)
			 {
				 countX++;
			 }
			 else if(value == y)
			 {
				 countY++;
			 }
		 }
		 if(countX == 0 || countY == 0)
		 {
			 throw new AssertionError("given integer is not available on array");
		 }
		 if(countX != countY)
		 {
			 throw new AssertionError("unequal numbers of X and Y in input array");
		 }
		 
		
		 
		 //handle two adjacent X values are there. and  X occurs at the last index of array.
		 for(int i = 0; i < length-1; i++ )
		 {
			 if(arr[i] == x)
			 {
				 if(arr[i+1] == x)
				 {
					 throw new AssertionError(" two adjacents X values are there.");
				 }
			 }
			 
			 if(i == length-2)
			 {
				 if(arr[i+1] == x)
				 {
					 throw new AssertionError(" X occurs at the last index of array.");
				 }
			 }
		 }
		   
		 
		int indexOfY = 1;
		for(int i = 0; i < length - 1; i++)
		{
			if(arr[i] == x && arr[i+1] != indexOfY)
			{
				while(arr[indexOfY] != y)
				{
					// finds the index of y
					if(indexOfY >= length-1)
					{
						indexOfY = 0;
					}
					else
					{
						indexOfY++;
					}
				}
				arr[indexOfY] = arr[i+1];
				arr[i+1] = indexOfY;
			}
		}
		
		return arr;
	}
	
	/**
	 * Method used to validate Input
	 * @param arr "Input Array"
	 * @return FALSE "input is wrong " TRUE "input is right "
	 */
	private boolean inputValidator(int []arr)
	{
		for(int value : arr)
		{
			if(value < 0 )
			{
				return false;
			}
		}
		
		return true;
	}
}



