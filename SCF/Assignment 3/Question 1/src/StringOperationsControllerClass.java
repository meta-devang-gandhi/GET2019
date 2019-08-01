import java.util.Scanner;

/**
 * @author Admin
 * It is a main class.
 * It take a input from user and call the StringOperation_Class Method.
 */
public class StringOperationsControllerClass
{
	public static void main(String[] args) {

		StringOperation stringOperations = new StringOperation();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter first String");
		String str1 = sc.next();
		System.out.println("Enter second String");
		String str2 = sc.next();
        sc.close();
        
        // Compare the String
		int isEqual = stringOperations.isEqual(str1, str2);
		if (isEqual == 1)
		{
			System.out.println("Strings are equal");
		}
		else 
		{
			System.out.println("Strings are not equal");
		}

		// Reverse of String
		String revStr1 = stringOperations.reverse(str1);
		System.out.println("Reverse of String is: " + revStr1);
		String revStr2 = stringOperations.reverse(str2);
		System.out.println("Reverse of String is: " + revStr2);
		
		// swapping of cases of string
		String swappedCaseString1 = stringOperations.swapCase(str1);
		System.out.println("Swapped Case String is: " + swappedCaseString1);
		String swappedCaseString2 = stringOperations.swapCase(str2);
		System.out.println("Swapped Case String is: " + swappedCaseString2);
		
		// largest word from the String
		String largestWord = stringOperations.largestWord(str1);
		System.out.println("largest Word = "+ largestWord);
	}	
}


