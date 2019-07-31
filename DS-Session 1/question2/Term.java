package question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Class is represent the term of multivaliable polynomial.
 */
public class Term
{
	int termCoefficient;
	List<Variable> variableList = new ArrayList<>();

	Term(int termCoefficient, List<Variable> variableList)
	{
		this.termCoefficient = termCoefficient;
		this.variableList = variableList;
	}
}