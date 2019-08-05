package question3;

import static org.junit.Assert.*;

import org.junit.Test;


public class MolecularMassTest {
	
	@Test
	public void test1()
	{
		MolecularMass moleculeObj = new MolecularMass();
		assertEquals(667, moleculeObj.calculateMass("COH(COH)22"));
	}
	
	@Test
	public void test2()
	{
		MolecularMass moleculeObj = new MolecularMass();
		assertEquals(29, moleculeObj.calculateMass("COH"));
	}
	
	@Test
	public void test3()
	{
		MolecularMass moleculeObj = new MolecularMass();
		assertEquals(86, moleculeObj.calculateMass("CHOC(CH3)3"));
	}

}
