package question1;

/**
 * Class used to array method like union, isMember, isSubset.
 * Class is a immutable. 
 * @author Devang
 */
public final class IntSet
{
	private final int[] immutableArray;
	
	/**
	 * Constructor store the element of array
	 * @param array "Input Array"
	 * @throws Exception 
	 */
	public IntSet(int[] array) throws Exception
	{
		if(array.length==0)
		{
			throw new Exception("Set is Null.......can't perform any operation ");
		}
		
		this.immutableArray = array;
	}
	
	/**
	 * Method check the input value is member of the set or not.
	 * @param value "Search value" 
	 * @return if value is a member of set then return true else false.
	 */
	public boolean isMember(int value)
	{
		int length = immutableArray.length;
		for (int index = 0; index <= length; index++)
		{
			if(value == this.immutableArray[index])
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * method used to get size of set.
	 * @return size of set.
	 */
	public int size()
	{
		return this.immutableArray.length;
	}
	
	/**
	 * Method find the set is subset or not.
	 * @param s "Input Subset"
	 * @return if set is a subset then return true else false.
	 */
	public boolean isSubSet(IntSet s)
	{
		int subLength = s.size(), superLength = this.immutableArray.length;
		
		for(int indexOfSubSet = 0; indexOfSubSet < subLength; indexOfSubSet++)
		{
			for(int indexOfSuperSet = 0; indexOfSuperSet < superLength; indexOfSuperSet++ )
			{
				if(this.immutableArray[indexOfSuperSet] == s.immutableArray[indexOfSubSet])
				{
					break;
				}
				
				if(indexOfSuperSet == superLength-1)
				{
					return false;
				}
			}	
		}
		
		return true;
	}
	
	/**
	 * Method used to find complement of two set.
	 * We assume that we have universal set between 1 to 1000.
	 * @return Complement array of two set. 
	 * @throws Exception 
	 */
	public  IntSet getComplement() throws Exception
	{
		int targetSetLength = this.size();
		int[] complementArray = new int [1000 - targetSetLength];
		int complementArrayIndex = 0;
		
		for (int value = 0; value <= 1000; value++)
		{
			boolean flag = false;
		    for(int index = 0; index < this.size(); index++)
		    {
	         	if(this.immutableArray[index] == value)
		        {
		          flag = true;
		          break;
		        }
		     }
		    if(flag != true)
		    {
		        complementArray[complementArrayIndex] = value;
		        complementArrayIndex++;
		    }
		}
		
		   return new IntSet(complementArray);
	}

	/**
	 * Method used to find union of two array. 
	 * @param s1 "Input 1st set"
	 * @param s2 "Input 2nd set"
	 * @return "Union set"
	 * @throws Exception 
	 */
    public  IntSet union(IntSet set1, IntSet set2) throws Exception
    {
    	int set1Length = set1.size(), set2Length = set2.size();
    	int unionLength = set1Length + set2Length;
    	int[] unionArray = new int [unionLength];
    	int index = 0;
    	int indexUnionArray = 0;
    	int number1 = 0;
    	int noOfCommon = 0;

    	while(index < set2Length)
    	{
    	    number1 = set2.immutableArray[index];
         	if(this.isMember(number1) == false)
        	{
    	           unionArray[indexUnionArray]=number1;
    	           indexUnionArray++;
    	        }
    	       else 
    	       {
    	           noOfCommon++;
    	       }
		
    	    index++;
    	}
        
    	index = 0;
    	while(index < this.size())
    	{
    	    unionArray[indexUnionArray] = this.immutableArray[index];
    	    index++;
        	indexUnionArray++;
    	}

    	int unionLengthWithOutCommonElement = unionLength - noOfCommon;
    	int unionArray1[]  = new int [unionLengthWithOutCommonElement];
    	for(index =0; index < unionLengthWithOutCommonElement; index++ )
    	{
    	   unionArray1[index] = unionArray[index];
    	}
    	
    	return  new IntSet(unionArray1);
    }
    
    /** Method return the set as  array
    */
    public int[] setAsArray() throws Exception
    {
    	IntSet set = new IntSet(this.immutableArray);
    	return set.immutableArray;
    }
}
