package question1;
/**
 * Class is used to find HCF and LCM of two number.
 * @author Devang
 */
public class HcfLcm 
{
	/**
	 * I have used Euclid’s algorithm for HCF.
	 * @param num1 "Input Number 1"
	 * @param num2 "Input Number 2"
	 * @return HCf of two number
	 */
    private int MainHcf(int num1, int num2)
    {
    	if(num2 == 0)
    	{
    		return num1;
    	}
    	else
    	{
    		return MainHcf(num2, num1 % num2);
    	} 	
    }
    
    /**
     * Method check if any input no is ZERO return 0 else we call private method MainHcf.
     * @param num1 "Input number 1"
     * @param num2 "Input number 2"
     * @return "Hcf of two no" 
     * @throws AssertionError
     */
    public int hcfOfTwoNo(int num1, int num2)throws AssertionError
    {
    	if(num1 < 0 || num2 <0)
    	{
    		throw new AssertionError("Input is not valid......You can only put Positive integer ");
    	}
    	
    	if(num1 ==0 || num2 == 0)
    	{
    		return 0;
    	}
    	else
    	{
    		return MainHcf(num1, num2);
    	}
    }
    
    /**
     * Method used to calculate Lcm.
     * @param num1 "Input number 1"
     * @param num2 "Input number 2"
     * @return "Lcm of two no" 
     */
    public int lcmOfTwoNo(int num1, int num2)
    {
    	int Hcf = hcfOfTwoNo(num1, num2);
    	
    	if(Hcf == 0)	
    	{
    		return 0;
    	}
    	else
    	{
    	return ( (num1 * num2) / Hcf );
    	}
    }
}
