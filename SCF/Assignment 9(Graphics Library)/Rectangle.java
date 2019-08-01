
/**
 * Class is perform operation of rectangle.
 * @author Devang
 *
 */
public class Rectangle implements Shape
{
    private int xCoordinatePoint;
    private int yCoordinatePoint;
    private int length;	
    private int width;
    
    /**
     * 
     * @param xCoordinatePoint
     * @param yCoordinatePoint
     * @param length
     * @param width
     */
    public Rectangle(int xCoordinatePoint, int yCoordinatePoint, int length, int width)
    {
	    this.xCoordinatePoint = xCoordinatePoint;
	    this.yCoordinatePoint = yCoordinatePoint;
	    this.length = length;
	    this.width = width;
	}
    
    //Method return the area.
	@Override
	public double getArea() 
	{
		return (length * width);
	}

	//method return the perimeter.
	@Override
	public double getPerimeter()
	{
	     return (2* (length + width));
	}

	//Method return the origin coordinate.
	@Override
	public String getOrigin()
	{
        String originCoordinate = "";
		
		originCoordinate += String.valueOf(xCoordinatePoint) + ",";
		originCoordinate += String.valueOf(yCoordinatePoint);
		
		return originCoordinate;
	}

	//Method return the shape type
	@Override
	public ShapeType getType() 
	{
		return ShapeType.RECTANGLE;
	}

	//Method checks for the point whether it is enclosed or not
	@Override
	public boolean isPointEnclosed(Point point) 
	{
		 int x=point.getxCoordinatePoint();
		 int y=point.getyCoordinatePoint();
		
		 if(x < ( xCoordinatePoint + width ) && y < ( yCoordinatePoint + length ) )
		 {
			 return true;
		 }
		 
		return false;
	}

}
