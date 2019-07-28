/**
 * Class Contain the attribute of coordinate of shape.
 * @author devang
 *
 */
public class Point 
{
    private final int MAX_X_COORDINATE = 500;
    private final int MAX_Y_COORDINATE = 500;
    
    private int xCoordinatePoint ;
    private int yCoordinatePoint;
    
    /**
     * 
     * @param xCoordinate point of x axis.
     * @param yCoordinate point of y axis.
     */
    public Point(int xCoordinatePoint, int yCoordinatePoint)
    {
        	this.xCoordinatePoint = xCoordinatePoint;
        	this.yCoordinatePoint = yCoordinatePoint;
    }
    
    //Method return the maximum value of x coordinate.
	public int getMAX_X_COORDINATE() 
	{
		return MAX_X_COORDINATE;
	}
	
	//Method return the maximum value of y coordinate.
	public int getMAX_Y_COORDINATE() 
	{
		return MAX_Y_COORDINATE;
	}
	
	//method return the value of x coordinate.
	public int getxCoordinatePoint()
	{
		return xCoordinatePoint;
	}
	
	//method return the value of y coordinate.
	public int getyCoordinatePoint()
	{
		return yCoordinatePoint;
	}	
}
