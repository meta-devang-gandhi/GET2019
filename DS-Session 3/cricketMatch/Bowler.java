package cricketMatch;

/**
 *Stores the information about a bowler such as name and number of balls left.
 */
public class Bowler 
{	
	private String bowlerName;
	private int numberOfBallLeft;
	
	/**
	 * Constructor to initialize the data members.
	 * @param bowlerName Name of the bowler.
	 * @param numberOfBallsLeft Number of balls left.
	 */
	Bowler(String bowlerName, int numberOfBallsLeft)
	{
		this.bowlerName = bowlerName;
		this.numberOfBallLeft = numberOfBallsLeft;
	}

	//Return the bowler name.
	public String getBowlerName()
	{
		return bowlerName;
	}

	//Return the number of balls left.
	public int getNumberOfBallLeft() 
	{
		return numberOfBallLeft;
	}
}