import java.util.Scanner;

/**This is a main class. which can do perform many function like addition, Subtraction, multiply, Divided
 * also it can check the equal , grater than and less than of HexaDecimal No.
*/
public class HexCalc
{
	//method used to remove initial zero from the HexaDecimal 
	public String omitInitialZero(String Hexa)
	{
		int length = Hexa.length();
		if(length == 1 || Hexa.charAt(0) != '0')
           return Hexa;
		else
		{
			int count = 0;
			while(count < length-1 && Hexa.charAt(count) == '0')
			{
				count++;
			}
			String str = "";
			for(int i = count; i < length; i++)
			  str += Hexa.charAt(i);
			
			return str;
		}
	}
	
	// Method used for Convert the Hexadecimal to decimal no
	public int hexToDecimal(String hexno, int base)
	{
		String digits = "0123456789ABCDEF";  
        hexno = hexno.toUpperCase();  
        int val = 0;  
        for (int i = 0; i < hexno.length(); i++)  
        {  
            char c = hexno.charAt(i);  
            int d = digits.indexOf(c);  
            val = base*val + d;  
        }  
        return val;
	}
	
	// Method used for Convert the decimal no to Hexadecimal 
	public String decimalToHex(int decimal, int base)
	{
	   int rem;  
	   String hex = "";   
	   char hexchars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
	   while(decimal > 0)  
       {  
		   rem = decimal % base;   
           hex = hexchars[rem] + hex;   
	       decimal = decimal / base;  
	   }  
	   return hex;  
	}
	
	// Method used for adding of hexadecimal no
	public void addOfHexa(String Hexa1, String Hexa2)
	{
		int decimal1 = hexToDecimal(Hexa1, 16);
		int decimal2 = hexToDecimal(Hexa2, 16);
		int sum = decimal1+decimal2;
		String sumOfHexa = decimalToHex(sum, 16) ;
		System.out.println("Addition of 2 hexadecimal no= "+ sumOfHexa);	
	}
	
	// Method used for Subtraction of hexaDecimal no
	public void subtractOfHexa(String Hexa1, String Hexa2)
	{
		int decimal1 = hexToDecimal(Hexa1, 16);
		int decimal2 = hexToDecimal(Hexa2, 16);
		int sum = decimal1-decimal2;
		String subOfHexa = decimalToHex(sum, 16) ;
		System.out.println("Subtraction  of 2 hexadecimal no= "+ subOfHexa);
	}
	
	// Method used to Multiply of hexaDecimal no
	 public void multiplyOfHexa(String Hexa1, String Hexa2)
	 {
		int decimal1 = hexToDecimal(Hexa1, 16);
		int decimal2 = hexToDecimal(Hexa2, 16);
			
		int sum = decimal1*decimal2;
			
		String multiplyOfHexa = decimalToHex(sum, 16) ;
		System.out.println("Multiply of 2 hexadecimal no= "+ multiplyOfHexa);
		}
		
	// Method used to Divided  of hexaDecimal no
	public void dividedOfHexa(String Hexa1, String Hexa2)
	{
		int decimal1 = hexToDecimal(Hexa1, 16);
		int decimal2 = hexToDecimal(Hexa2, 16);
			
		int sum = decimal1 / decimal2;
			
		String dividedOfHexa = decimalToHex(sum, 16) ;
		System.out.println("Divided of 2 hexadecimal no= "+ dividedOfHexa);	
		}
		
	//Method use to check equal HexaDecimal No
	public boolean checkEqual(String Hexa1, String Hexa2)
	{
		int len1 = Hexa1.length();
		int len2 = Hexa2.length();
			
		if(len1 == len2)
		{
	    	for(int i = 0; i < len1; i++)
		 	{
	    		if(Hexa1.charAt(i) != Hexa2.charAt(i) )
			      	return false;
	     	}
		}
		else
	    	return false;
			
		return true;
	}
		
	// Method check the First Hexadecimal No is grater than 2nd HexaDecimal No or not
	public boolean checkGraterThan(String Hexa1, String Hexa2)
	{
    	int len1 = Hexa1.length();
		int len2 = Hexa2.length();
			
		if(len1 > len2)
		   return true;
		else if(len1 < len2)
	    	return false;
		else
		{
	    	for(int i = 0; i < len1; i++)
			{
			   if(Hexa1.charAt(i) < Hexa2.charAt(i))
				  return false;
			}
		}
		return true;
	}
		
	// Method check the First Hexadecimal No is less than 2nd hexadecimal No or not
	public boolean checkLessThan(String Hexa1, String Hexa2)
	{
	  int len1 = Hexa1.length();
	  int len2 = Hexa2.length();
			
	  if(len1 < len2)
	     return true;
      else if(len1 > len2)
		 return false;
	  else
	  {
	   	 for(int i = 0; i < len1; i++)
		 {
			if(Hexa1.charAt(i) > Hexa2.charAt(i))
				return false;
		 }
       }
	  return true;
	}
		
   // Method Check the Input is right or not
	public boolean checkInputString(String Number)
	{
		String digits = "0123456789ABCDEF";  
        Number = Number.toUpperCase();
        for(int i = 0; i < Number.length(); i++)
	    {
	        char c = Number.charAt(i);  
	        int d = digits.indexOf(c);  
	        if(d == -1)
	       	  return false;
	     }
		return true;
	}
		
	//Main Method 
	public static void main(String arg[])
	{
	    String hexno1 = null; // take a variable for store 1st hex no 
		String hexno2 = null; // take a variable for store 2nd hex no 
		Scanner sc= new Scanner(System.in);
		HexCalc obj = new HexCalc();
		System.out.println("Enter the 1st and 2nd hexadecimal No");
		boolean check= false;
	    while(check == false)
	    {
		   hexno1 = sc.next();
	   	   check = obj.checkInputString(hexno1);
	   	    if(check == false)
	   		   System.out.println(" Enter valued is not correct \n Please Enter correct value "); 
	    }
	   
	   check = false;
	   while(check == false)
	   {
		   hexno2 = sc.next();
	   	   check = obj.checkInputString(hexno1);
	   	   if(check == false)
	   		  System.out.println(" Enter valued is not correct \n Please Enter correct value "); 
	   }
		
	   hexno1 = obj.omitInitialZero(hexno1);
	   hexno2 = obj.omitInitialZero(hexno2);
	   obj.addOfHexa(hexno1, hexno2);
	   obj.subtractOfHexa(hexno1, hexno2);
	   obj.multiplyOfHexa(hexno1, hexno2);
	   obj.dividedOfHexa(hexno1, hexno2);
	   System.out.println("Hexa no Equal = " + obj.checkEqual(hexno1, hexno2));
	   System.out.println("1st Hexa no is Grater than 2nd Hexadecimal No =" + obj.checkGraterThan(hexno1, hexno2));
	   System.out.println("1st Hexa no is Less than 2nd Hexadecimal No  =" + obj.checkLessThan(hexno1, hexno2));
	   sc.close();	
	}
}
