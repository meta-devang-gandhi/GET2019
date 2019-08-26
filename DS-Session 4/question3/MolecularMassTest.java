package question3;

import static org.junit.Assert.*;

import org.junit.Test;


public class MolecularMassTest 
{
	
	@Test
	public void testEvaluateMass()
	{
		MolecularMass moleculeObj = new MolecularMass();
		assertEquals(667, moleculeObj.calculateMass("COH(COH)22"));
	}
	
	@Test
	public void testEvaluateMass2()
	{
		MolecularMass moleculeObj = new MolecularMass();
		assertEquals(29, moleculeObj.calculateMass("COH"));
	}
	
	@Test
	public void testEvaluateMass3()
	{
		MolecularMass moleculeObj = new MolecularMass();
		assertEquals(86, moleculeObj.calculateMass("CHOC(CH3)3"));
	}

}