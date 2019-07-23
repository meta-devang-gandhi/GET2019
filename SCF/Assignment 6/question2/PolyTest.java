package question2;

import static org.junit.Assert.*;
import org.junit.Test;

public class PolyTest 
{	
	@Test
	public void testGetPolynomial() throws Exception
	{
		int array[] = new int[] {1,2,3,4,5};
		Poly pol = new Poly(array);
		int expected[] = new int[] {1,2,3,4,5};
		int actual[] = pol.getPolynomial();
		assertArrayEquals( expected, actual );
	}
	
	@Test
	public void testEvaluate() throws Exception
	{
		int a[] = new int[] {1,2,3,4,5};
		Poly object1 = new Poly(a);
		
		float number = 5;
		float actualResult = object1.evaluate(number);
		assertEquals(3711, actualResult, 0);
		
		number=0;
		actualResult = object1.evaluate(number);
    	assertEquals(1, actualResult, 0);
	}
	
	@Test
	public void testDegree() throws Exception 
	{
		int a[] = new int[]{1,2,3,4,5};
		Poly object1 = new Poly(a);
		assertEquals(4, object1.degree() );

		int c[] = new int[]{0};
		Poly object3 = new Poly(c);
		assertEquals(0, object3.degree() );
	 
	}
	
	@Test
	public void testAddPoly() throws Exception 
	{
		int arrayFirst[] = new int[]{1,2,3,4,5};
		int arraySecond[] = new int[]{1,3,5,7,9,11,13,15};
		Poly objectFirst = new Poly(arrayFirst);
		Poly objectSecond = new Poly(arraySecond);
		int actual[] = (objectFirst.addPoly(objectFirst, objectSecond)).getPolynomial();
		int expected[] = new int[]{2,5,8,11,14,11,13,15};
		assertArrayEquals(expected,actual);
		
		int arrayThird[] = new int[]{1,3,5,7,9,11,13,15};
		int arrayFourth[] = new int[]{1,2,3,4,5};
		Poly objectThird = new Poly(arrayThird);
		Poly objectFourth = new Poly(arrayFourth);
		int actualSecond[] = (objectThird.addPoly(objectThird, objectFourth)).getPolynomial();
		int expectedSecond[] = new int[]{2,5,8,11,14,11,13,15};
		assertArrayEquals(expectedSecond,actualSecond);
	}
	
	@Test
	public void testMultiplyPoly() throws Exception
	{
		int arrayFirst[] = new int[]{1,2,3,4,5};
		int arraySecond[] = new int[]{1,3,5,7,9,11,13,15};
		Poly objectFirst = new Poly(arrayFirst);
		Poly objectSecond = new Poly(arraySecond);
		int actual[] = (objectFirst.multiplyPoly(objectFirst, objectSecond)).getPolynomial();
		int expected[] = new int[]{1,5,14,30,55,85,115,145,158,152,125,75};
		assertArrayEquals(expected,actual);
	
		int arrayThird[] = new int[]{1,3,5,7,9,11,13,15};
		int arrayFourth[] = new int[]{1,2,3,4,5};
		Poly objectThird = new Poly(arrayThird);
		Poly objectFourth = new Poly(arrayFourth);
		int actualSecond[] = (objectThird.multiplyPoly(objectThird, objectFourth)).getPolynomial();
		int expectedSecond[] = new int[]{1,5,14,30,55,85,115,145,158,152,125,75};
		assertArrayEquals(expectedSecond,actualSecond); 
	}
}