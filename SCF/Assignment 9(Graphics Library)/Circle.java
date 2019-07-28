
/**
 * Class is use to perform operation of circle. 
 * @author devang
 *
 */
public class Circle implements Shape
{
    private final double PI = 3.14;
    private int xCoordinatePoint;
    private int yCoordinatePoint;
    private int radius;
    
    public Circle(int xCoordinatePoint, int yCoordinatePoint, int radius) 
    {
	       this.xCoordinatePoint = xCoordinatePoint;
	       this.yCoordinatePoint = yCoordinatePoint;
	       this.radius = radius;
	       
    }
	
    //method return the area.
	@Override
	public double getArea() 
	{
		return (PI * radius * radius);
	}
    
	//method return the perimeter
	@Override
	public double getPerimeter() 
	{
		return (2 * PI * radius);
	}
    
	//method return the origin coordinates.
	@Override
	public String getOrigin() 
	{
		String originCoordinate = "";
		
		originCoordinate += String.valueOf(xCoordinatePoint) + ",";
		originCoordinate += String.valueOf(yCoordinatePoint);
		
		return originCoordinate;
	}

	//method return the shape type.
	@Override
	public ShapeType getType() 
	{
		return ShapeType.CIRCLE;
	}

	//Method checks for the point whether it is enclosed or not
	@Override
	public boolean isPointEnclosed(Point point)
	{
		int x = point.getxCoordinatePoint();
		int y = point.getyCoordinatePoint();

		double centreX = 0, centreY = 0;
		double m = 0;
		double n = radius;
		
		//calculating coordinates of center
		m = Math.sqrt( (xCoordinatePoint * xCoordinatePoint) + (yCoordinatePoint * yCoordinatePoint) ) + radius;
		centreX = ( m * xCoordinatePoint ) / ( m - n );
		centreY=( m * yCoordinatePoint ) / ( m-n);
		
		//calculate distance of center from the point given
		double distanceToPoint = (double) Math.sqrt( (( x - centreX ) * ( x - centreX )) + (( y - centreY ) * ( y - centreY )) );
		
		if (distanceToPoint < radius) 
		{
			return true;
		}
		
		return false;
	}

}
