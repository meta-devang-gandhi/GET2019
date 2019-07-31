package question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Class create a multivariable polynomial using nested lists. 
 */
public class MultivariablePolynomial 
{	
	List<Term> multivariablePolynomial = new ArrayList<>();
	
	public MultivariablePolynomial(List<Term> termList)
	{	
		this.multivariablePolynomial = termList;
	}
	
	/**
	 * Method to calculate the degree of the multivariable polynomial
	 * @return degree of polynomial.
	 */
	int calculatePolynomialDegree()
	{
		int variablePowerSum;
		int degreeOfPolynomial = 0;
		for(Term term : multivariablePolynomial)
		{
			variablePowerSum = 0;
			for(Variable variable : term.variableList)
			{
				variablePowerSum += variable.getVariablePower();
			}
			
			if(degreeOfPolynomial < variablePowerSum)
			{
				degreeOfPolynomial = variablePowerSum;
			}
		}
		
		return degreeOfPolynomial;
	}
	
	/**
	 *Method to convert multivariable polynomial into string.
	 * @return string form of multivariable polynomial 
	 */
	String visualiseMultivariablePolynomial()
	{
		String polynomialString = "";
		for(Term term : multivariablePolynomial)
		{
			polynomialString = polynomialString + term.termCoefficient;
			
			for(Variable variable : term.variableList)
			{
				polynomialString += "*" + variable.getVaribleName() + "^" + variable.getVariablePower();
			}
			
			if(term != multivariablePolynomial.get(multivariablePolynomial.size() - 1))
			{
				polynomialString = polynomialString + " + ";		
			}
		}
		
		return polynomialString;
	}	
}
