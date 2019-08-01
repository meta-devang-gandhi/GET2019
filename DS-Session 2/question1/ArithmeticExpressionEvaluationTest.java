package question1;

import static org.junit.Assert.*;
import org.junit.Test;

public class ArithmeticExpressionEvaluationTest 
{
	
	private ArithmeticExpressionEvaluation arithmetic = new ArithmeticExpressionEvaluation();
		
	@Test
	 public void testOp1(){
		assertEquals("22.00", arithmetic.evaluateExpression("11 + 22 / 2")); 
	}
	
	@Test
	 public void testOp2(){
		assertEquals("true", arithmetic.evaluateExpression("11 + 23 <= 56")); 
	}
	
	@Test
	 public void testOp3(){
		assertEquals("false", arithmetic.evaluateExpression("11 == 22 ")); 
	}
	
	@Test
	 public void testOp4(){
		assertEquals("Invalid expression", arithmetic.evaluateExpression("+ 1 + 2 + 3 ")); 
	}
	
	@Test
	 public void testOp5(){
		assertEquals("Invalid expression", arithmetic.evaluateExpression(" 1 + 2 + 3 + ")); 
	}
	
	@Test
	 public void testOp6(){
		assertEquals("Invalid expression", arithmetic.evaluateExpression(" 1 + 2 + 3 + %")); 
	}
	
	@Test
	 public void testOp7(){
		assertEquals("Invalid expression", arithmetic.evaluateExpression(" 1 + 2 + 3 + a + 5")); 
	}
}