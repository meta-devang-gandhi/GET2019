package question3;

import java.util.Stack;

/**
 *Class for calculating molecule mass of compound.
 */
public class MolecularMass 
{	
	private Stack<Element> stack = new Stack<Element>();
	
	/**
	 * Method to calculate molecule mass.
	 * @param compound
	 * @return total molecule mass.
	 */
    public int calculateMass(String compound) 
    {
    	if(stringCheck(compound))
    	{
	        String input = compound.toUpperCase() + ")";    
	        int index = 0, totalMass =0;
	        this.stack.push(new Element('(',1));           
	        int length = input.length();
	        try
	        {
		        while(index < length) 
		        {
		            char symbol = input.charAt(index);
		            switch(symbol) 
		            {
			            
			            case 'C':
			            case 'H':
			            case 'O':
			            {
			            	if(index == input.length() - 1) 
			            	{
			                    this.stack.push(new Element(symbol,1));
			                    index++;
			                }
			                else 
			                {
			                    int base = this.calculateBase(input.substring(index));
			                    this.stack.push(new Element(symbol,base));
			                    index++;
			                } 
			            	
			                break;
			            }
			            case '(':
			            {
			                this.stack.push(new Element('(',1));
			                index++;
			                break;
			            }
			            case ')':
			            {
			                if(index == input.length()-1) 
			                {
			                    totalMass += this.evaluateMass(1);
			                }
			                else 
			                {
			                    int base = this.calculateBase(input.substring(index));
			                    totalMass += this.evaluateMass(base);
			                }
			            }
			            default:
			                index++;
			        }
		        }
		        
		        this.stack.clear();
		        return totalMass;
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
    	}
    	else
    	{
    		System.out.println("Compound is wrong.");
    	}
    	return 0;
    }
    
    /**
     * Method to calculate base for particular symbol.
     * @param subCompound
     * @return
     */
    private int calculateBase(String subCompound) 
    {
        int digit = 0;
        int length = subCompound.length();
        
        for(int index = 1; index < length; index++) 
        {
            char symbol = subCompound.charAt(index);
            if(Character.isDigit(symbol)) 
            {
                digit = digit * 10 + (int)(symbol - '0');
            }
            else 
            {
                break;
            }
        }
        
        if(digit == 0) 
        {
            return 1;
        }
        
        return digit;
    }
   
    /**
     * Method to evaluate subMass of compound. 
     * @param base
     * @return
     */
   private int evaluateMass(int base) 
   {
        int subMass = 0;
        Element element;
        
        while(true) 
        {
           element = this.stack.pop();
           if(element.getSymbol() == '(')
           {
               break;
           }
           else 
           {
               switch(element.getSymbol()) 
               {
                   case 'C':
                             subMass += (12*element.getBase());
                             break;
                   case 'O':
                             subMass += (16*element.getBase());
                             break;
                   case 'H':
                             subMass += (1*element.getBase());
                             break;
               }
            
          } 
       }
       
        return (subMass*base);
    }
   
   /**
    * Method to check compound string is right or not.
    * @param compound
    * @return
    */
   private boolean stringCheck(String compound)
   {
	   int length = compound.length(), index = 0;
	    String compound1 = compound.toUpperCase();
	   while(index < length)
	   {
		   char symbol = compound1.charAt(index);
		   switch(symbol)
		   {
		     case  'C' :
		     case  'H' :
		     case  'O' :
		     case  '(' :
		     case  ')' :
		     case  '0' :
		     case  '1' :
		     case  '2' :
		     case  '3' :
		     case  '4' :
		     case  '5' :
		     case  '6' :
		     case  '7' :
		     case  '8' :
		     case  '9' :
		     default :
		    		 return false;	 
		   }
	   }
	   
	   return true;
   }
   
   public static void main(String[] args) {
		
		MolecularMass moleculeObj = new MolecularMass();
		
		System.out.println("1 "+moleculeObj.calculateMass("COH(COH)22"));
		
		System.out.println("2 "+moleculeObj.calculateMass("C2OH"));
		
		System.out.println("3 "+moleculeObj.calculateMass("CHOC(CH3)3"));
		
	}
}