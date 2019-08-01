package question1;
import static org.junit.Assert.*;
import org.junit.Test;

public class ArithmeticExpressionEvaluationTest 
{
	private String expected1 =  "22";
	private String expected2 =  "true";
	private String expected3 =  "true";
	private ArithmeticExpressionEvaluation arithmetic;
		
	@Test
	 public void testOp1(){
		assertEquals(expected1, arithmetic.evaluateExpression("11 + 22 / 2")); 
	}
	
	@Test
	 public void testOp2(){
		assertEquals(expected2, arithmetic.evaluateExpression("(  ( 1 == 1 ) || ( 22  != 3 ) )")); 
	}
	
	@Test
	 public void testOp3(){
		assertEquals(expected3, arithmetic.evaluateExpression("(  ( 1 + 1 ) == ( 22  / 11 ) )")); 
	}
}