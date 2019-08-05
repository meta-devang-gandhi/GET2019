package cricketMatch;

/**
 *Represents the heap of the bowlers.
 */
public class BowlerHeap 
{	
	private Bowler[] bowlersList;
	private int numberOfBowlers;
	private int size;
	
	/**
	 * Constructor to initialize the data members
	 */
	public BowlerHeap(int numberOfBowlers) 
	{
		this.numberOfBowlers = numberOfBowlers;
		this.size = 0;
		bowlersList = new Bowler[this.numberOfBowlers + 1];
	}
	
	/**
	 * Returns the parent of the bowler at position
	 * @param position which parent's bowler we determined.
	 * @return position of parent.
	 */
	public int returnParent(int position) 
        { 
            return position / 2; 
        } 

	/**
	 * Returns the left child of the bowler at position
	 * @param position which left's bowler we determined.
	 * @return position of left child.
	 */
	public int returnLeftChild(int position) 
       { 
           return (2 * position); 
       } 
	
	/**
	 * Returns the right child of the bowler at position
	 * @param postion which rigth's bowler we determined.
	 * @return Position of right child.
	 */
	public int returnRightChild(int position) 
        { 
             return ((2 * position) + 1); 
        }
	
	/**
	 *Swaps the bowlers.
	 * @param position1  first position
	 * @param position2  second position
	 */
	public void swapBowlers(int position1, int position2)
	{
		Bowler temp = bowlersList[position1];
		bowlersList[position1] = bowlersList[position2];
		bowlersList[position2] = temp;
	}
	
	/**
	 * This method checks whether an element is at leaf of the heap or not
	 * @param position is the element's position which is to be checked
	 * @return true if element have leaf else false.
	 */
	public boolean isLeaf(int position) 
        { 
        if (position > (size / 2) && position < size) 
        { 
            return true; 
        }
        
        return false; 
        } 
	
	/**
	 * Method arrange the bowlers as maxheap.
	 * @param position 
	 */
	public void maxHeap(int position) 
        { 
        if (isLeaf(position)) 
            return; 
        
        if ((bowlersList[position].getNumberOfBallLeft() < bowlersList[returnLeftChild(position)].getNumberOfBallLeft()) ||  
            (bowlersList[position].getNumberOfBallLeft() < bowlersList[returnRightChild(position)].getNumberOfBallLeft())) 
        { 
            if (bowlersList[returnLeftChild(position)].getNumberOfBallLeft() > bowlersList[returnRightChild(position)].getNumberOfBallLeft()) 
            { 
                swapBowlers(position, returnLeftChild(position)); 
                maxHeap(returnLeftChild(position)); 
            } 
            else 
            { 
                swapBowlers(position, returnRightChild(position)); 
                maxHeap(returnRightChild(position)); 
            } 
        } 
    } 
	
	/**
	 *Inserts a bowler in the heap
	 * @param bowler
	 */
	void insertBowler(Bowler bowler) 
        { 
	   bowlersList[++size] = bowler; 
           int current = size; 
            while ((current != 1) && (bowlersList[current].getNumberOfBallLeft() > bowlersList[returnParent(current)].getNumberOfBallLeft())) 
            { 
            swapBowlers(current, returnParent(current)); 
            current = returnParent(current); 
            }
          } 

	/**
	 * This method extracts the bowler which has the maximum number of balls
	 * @return 
	 */
	public Bowler extractBowler() 
        { 
        Bowler poppedBowler = bowlersList[1]; 
        bowlersList[1] = bowlersList[size--]; 
        maxHeap(1);
        
        return poppedBowler; 
        } 
	
}
