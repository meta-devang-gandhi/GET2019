package cricketMatch;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
 class CricketMatchTest {
	
	@Test
	public void testCricketMatch()
	{
		CricketMatch match = new CricketMatch(7, 37);
		
		match.addBowler("Dhoni", 1);
		match.addBowler("Chahal", 4);
		match.addBowler("Bhumrah", 15);
		match.addBowler("Shami", 8);
		match.addBowler("Bhuvneshwar", 9);
		match.addBowler("Kuldeep", 3);
		match.addBowler("Pollard", 2);
		
		List<Bowler> bowlersOrder = match.playMatch();
		assertEquals("Bhumrah", bowlersOrder.get(0).getBowlerName());
		assertEquals("Shami", bowlersOrder.get(2).getBowlerName());
	}
	
}