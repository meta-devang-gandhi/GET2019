package cricketMatch;

import java.util.ArrayList;
import java.util.List;

/**
 *Class represents the cricket match in which the bowler is selected according to the number of balls.
 */
public class CricketMatch 
{	
	private int numberOfBowlers;
	private int bowlsToBePlayed;
	List<Bowler> bowlersOrder;
	BowlerHeap heapObject;
	
	public CricketMatch(int numberOfBowlers, int bowlsToBePlayed) 
	{
		this.bowlsToBePlayed = bowlsToBePlayed;
		this.numberOfBowlers = numberOfBowlers;
		bowlersOrder = new ArrayList<>();
		heapObject = new BowlerHeap(numberOfBowlers);
	}

	/**
	 *Bowler is selected and the match is played
	 * @return  list of bowlers.
	 */
	public List<Bowler> playMatch()
	{
		while(bowlsToBePlayed > 0)
		{
			Bowler bowler = heapObject.extractBowler();
			bowlsToBePlayed = bowlsToBePlayed - bowler.getNumberOfBallLeft();
			bowlersOrder.add(bowler);
		}
		
		return bowlersOrder;
	}
	
	/**
	 * Method add a bowler to the cricket match
	 * @param name of the bowler
	 * @param number of balls.
	 */
	void addBowler(String name, int balls)
	{
		heapObject.insertBowler(new Bowler(name,balls));
	}
	
}
