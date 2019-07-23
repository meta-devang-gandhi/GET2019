package question2;

/**
 * Immutable class for polynomial operation.
 * @author Devang
 *
 */
final class Poly 
{
	private final int[] polynomial;
	
	/*  Constructor of class to initialize polynomial
	 * @param  array of Polynomial
	 * @throws  if the polynomial array is null
	 */
	Poly(int[] poly)throws Exception	
	{
		if(poly.length == 0)
		{
			throw new Exception("Zero degee polynomial not allowed ");
		}
		
		this.polynomial=poly;
	}
	
	/*
	 * getter method for getting array from polynomial
	 * @return  array of polynomial
	 */
	public int[] getPolynomial() 
	{	
		Poly poly = null;
		try 
		{
			poly = new Poly(polynomial);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return poly.polynomial;
	}
	
	/*
	 * Method evaluate polynomial equation
	 * @param value  value of which evaluation
	 * @return float type solution
	 */
	public float evaluate(float value) 
	{	
		float solution=0.0f;
		int length = polynomial.length;
		for(int indexValue=length-1; indexValue >= 0; indexValue--) 
		{
			solution+= ( polynomial[indexValue] * Math.pow(value,indexValue) );
		}
		
		return solution;
	}
	
	/*
	 * Method return degree of polynomial
	 * @return  value of degree
	 */
	public int degree() 
	{
		return (polynomial.length-1);
	}
	
	/*
	 * Method add two polynomial
	 * @param Object of Poly Class of First Value
	 * @param Object of Poly Class of Second Value
	 * @return  sum of polynomials
	 */
     public Poly addPoly(Poly p1, Poly p2) throws Exception 
     {	
		if(p2.polynomial.length > p1.polynomial.length)
		{
			Poly p3 = p1;
			p1 = p2;
			p2 = p3;
		}
		
		int lengthPoly1 = p1.polynomial.length, lengthPoly2 = p2.polynomial.length;
		int result[]=new int[Math.max(lengthPoly1,lengthPoly2)],  counter=0;
	
		for(int indexFirst = 0; indexFirst < lengthPoly1 ; indexFirst++)
		{
			if(lengthPoly2 > indexFirst) 
			{
				result[counter] = p1.polynomial[indexFirst] + p2.polynomial[indexFirst];
			}
			else 
			{
				result[counter]=p1.polynomial[indexFirst];
			}
			counter++;
		}
		
		return new Poly(result);
	}
	
	/*
	 * Method multiply two polynomial
	 * @param Object of Poly Class of First Value
	 * @param Object of Poly Class of Second Value
	 * @return product of polynomials
	 */
	public Poly multiplyPoly(Poly p1, Poly p2)throws Exception 
	{	
		int lengthPoly1 = p1.polynomial.length, lengthPoly2 = p2.polynomial.length;
		int size = lengthPoly1 + lengthPoly2 - 1;
		int result[] = new int[size];
	
		for(int indexFirst = 0; indexFirst < size; indexFirst++)
		{
			result[indexFirst] = 0;
		}
		
		for(int indexFirst = lengthPoly1 - 1; indexFirst >= 0; indexFirst--)
		{
			for(int indexSecond = lengthPoly2 - 1; indexSecond >= 0; indexSecond--)
			{
				result[indexFirst+indexSecond] += p1.polynomial[indexFirst] * p2.polynomial[indexSecond];		
			}
		}
		
		return new Poly(result);
	}
}