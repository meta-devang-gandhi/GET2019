package cricketMatch;

import java.util.List;


public class Main
{

	public static void main(String[] args) 
	{
		
		CricketMatch match = new CricketMatch(7, 30);
		
		match.addBowler("Dhoni", 1);
		match.addBowler("Chahal", 4);
		match.addBowler("Bhumrah", 8);
		match.addBowler("Shami", 8);
		match.addBowler("Bhuvneshwar", 10);
		match.addBowler("Kuldeep", 3);
		match.addBowler("Pollard", 2);
		
		List<Bowler> bowlersOrder = match.playMatch();
		
		System.out.println("The bowlers are in the following order : ");
		for(int i = 0; i < bowlersOrder.size(); i++)
		{
			System.out.println(bowlersOrder.get(i).getBowlerName());
		}

	}

}