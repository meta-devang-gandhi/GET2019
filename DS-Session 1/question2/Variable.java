package question2;

/**
 * Class is represent the variable of multivariable polynomial along with its power. 
 */
public class Variable 
{	
	private char varibleName;
	private int variablePower;
	
	Variable(char variableName, int variablePower)
	{
		this.variablePower  = variablePower;
		this.varibleName = variableName;
	}

	//Method return the name of variable.
	public char getVaribleName() 
	{
		return varibleName;
	}
	
	//Method return the power of variable.
	public int getVariablePower() 
	{
		return variablePower;
	}
}