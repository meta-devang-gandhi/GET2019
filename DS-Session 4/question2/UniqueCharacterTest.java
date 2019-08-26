package question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharacterTest 
{	
	@Test
	public void testCountUniqueCharater_Success() 
	{
		int result = new UniqueCharacter().countUniqueCharacter("devannngg gggggadhi");	
		assertEquals(8, result);
	}

	@Test
	public void testCountUniqueCharater_Failure()
	{
		int result = new UniqueCharacter().countUniqueCharacter("devannngg gggggadhi");	
		assertNotEquals(7, result);
	}
}
