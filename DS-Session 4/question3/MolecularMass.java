package question3;

import java.util.Stack;

public class MolecularMass 
{	
	private Stack<Element> stack = new Stack<Element>();
	 
    int calculateMass(String compound) 
    {
        String input = compound.toUpperCase() + ")";    
        int i =0, totalMass =0;
        this.stack.push(new Element('(',1));           
        int length = input.length();
        
        while(i < length) 
        {
            char symbol = input.charAt(i);
            switch(symbol) 
            {
	            
	            case 'C':
	            case 'H':
	            case 'O':
	            {
	            	if(i == input.length()-1) 
	            	{
	                    this.stack.push(new Element(symbol,1));
	                    i++;
	                }
	                else 
	                {
	                    int base = this.calculateBase(input.substring(i));
	                    this.stack.push(new Element(symbol,base));
	                    i++;
	                }
	                break;
	            }
	            case '(':
	            {
	                this.stack.push(new Element('(',1));
	                i++;
	                break;
	            }
	            case ')':
	            {
	                if(i == input.length()-1) 
	                {
	                    totalMass += this.evaluateMass(1);
	                }
	                else 
	                {
	                    int base = this.calculateBase(input.substring(i));
	                    totalMass += this.evaluateMass(base);
	                }
	            }
	            default:
	                i++;
	        }
        }
        
        this.stack.clear();
        return totalMass;
    }
    
   int calculateBase(String subCompound) 
   {
        int digit = 0;
        for(int i = 1;i<subCompound.length();i++) 
        {
            char symbol = subCompound.charAt(i);
            if(Character.isDigit(symbol)) 
            {
                digit = digit*10 + (int)(symbol - '0');
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
   
   int evaluateMass(int base) 
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
        
        System.out.println("sub mass = " + (subMass * base));
        return (subMass*base);
    }

   
   public static void main(String[] args) {
		
		MolecularMass moleculeObj = new MolecularMass();
		
		System.out.println("1 "+moleculeObj.calculateMass("COH(COH)22"));
		
		System.out.println("2 "+moleculeObj.calculateMass("COH"));
		
		System.out.println("3 "+moleculeObj.calculateMass("CHOC(CH3)3"));
		
	}
}