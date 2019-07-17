
public class ArrOperation
{

	/**
	 * @param nums array of integers
	 * @return length of maxMirror
	 */
	public int findMaxMirror(int[] nums)
	{
		int maxLengthMirror = 0;
        int length = nums.length;
		for (int i = 0; i < length; i++)
		{
			int mirrorLength = 0;
			for (int j = length - 1; j >= 0 && i + mirrorLength < length; j--)
			{
				if (nums[i + mirrorLength] == nums[j])
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
			if (maxLengthMirror < mirrorLength)
			{
				maxLengthMirror = mirrorLength;
			}
			mirrorLength = 0;

		}

		return maxLengthMirror;
	}

	
	/**
	 * @param nums array of integers
	 * @return clumps count
	 */
	public int countClumps(int[] nums) {
	    final int len=nums.length;
	    int  count=0;

	    if (nums.length==0)
	    {
	    	System.out.println(" Array is empty");
	    }
	    
	    for(int i=0;i<len;i++)
	    {
	        int j=i+1;
	        if(nums[i]==nums[j])
	        {
	            count++;
	            while((nums[i]==nums[j]))
	            {
	                if(j==len-1)
	                    break;
	                j++;
	            }  
	        } 
	        i=j-1;
	        if(i==len-2)
	            break;
	    }

	    return count;   
	}
	
	
	/**
	 * @param nums array of numbers
	 * @return if found any split position then return split position  o/w returns -1
	 */
	int findSplitIndex(int nums[]) 
	{ 
	    int leftOfSplitSum = 0 ; 
	    int rightOfSplitSum = 0;
	    int arrayLength = nums.length;
	   
	    for (int currentIndexOfLeftSplit = 0; currentIndexOfLeftSplit < arrayLength-1; currentIndexOfLeftSplit++) 
	    { 
	    	// sum of left side 
	        leftOfSplitSum += nums[currentIndexOfLeftSplit] ; 
	  
	        // sum of elements on rigth side
	        for (int currentIndexOfRightSplit = currentIndexOfLeftSplit+1 ; currentIndexOfRightSplit < arrayLength ; currentIndexOfRightSplit++ ) 
	            rightOfSplitSum += nums[currentIndexOfRightSplit] ; 
	  
	        // check if left side sum is equal to right side
	        if (leftOfSplitSum == rightOfSplitSum) 
	            return currentIndexOfLeftSplit+1 ; 
	    } 
	  
	    // if it is not possible to split array into 
	    // two parts 
	    return -1; 
	} 
	
	
	public int[] fixXY(int[] nums, int x, int y) 
	{
		int j = 1;
		for(int i = 0; i < nums.length - 1; i++)
		{
			if(nums[i] == x && nums[i+1] != y)
			{
				while(nums[j]!=y)
				{
					// finds the index of y
					if(j>=nums.length-1)
						j=0;
					else
						j++;
					
				}
				nums[j] = nums[i+1];
				nums[i+1] = y;
			}
		}
		return nums;
	}
	
}
