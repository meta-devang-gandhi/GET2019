package question1;

public class Main 
{
    public static void main(String arg[])
    {
    	ArithmeticExpressionEvaluation obj = new  ArithmeticExpressionEvaluation();
    	System.out.println(obj.evaluateExpression(" 11 + 22 / 2 "));
    	System.out.println(obj.evaluateExpression(" + 11 + 23 <= 34  "));
    	//(  ( 1 + 1 ) == ( 22  / 11 ) )
    }
}
