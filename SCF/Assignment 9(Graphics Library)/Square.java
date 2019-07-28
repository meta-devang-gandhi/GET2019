
/**
 * Class is perform operation of square.
 * @author Devang
 *
 */
public class Square implements Shape
{
	 private int xCoordinatePoint;
	 private int yCoordinatePoint;
	 private int width;
	 
	 /**
	  * 
	  * @param xCoordinatePoint
	  * @param yCoordinatePoint
	  * @param width
	  */
	 public Square(int xCoordinatePoint, int yCoordinatePoint, int width)
	 {
		 this.xCoordinatePoint = xCoordinatePoint;
	     this.yCoordinatePoint = yCoordinatePoint;
   	     this.width = width;
	}

	 //Method return the area.
	@Override
	public double getArea() 
	{
		return ( width * width);
	}

	//Method return the perimeter
	@Override
	public double getPerimeter() 
	{
		return ( 4 * width);
	}

	//Method return the coordinate of origin.
	@Override
	public String getOrigin() 
	{
        String originCoordinate = "";
		
		originCoordinate += String.valueOf(xCoordinatePoint) + ",";
		originCoordinate += String.valueOf(yCoordinatePoint);
		
		return originCoordinate;
	}

	//Method return shape type.
	@Override
	public ShapeType getType() 
	{
		return ShapeType.SQUARE;
	}

	//Method checks for the point whether it is enclosed or not
	@Override
	public boolean isPointEnclosed(Point point) 
	{
		 int x = point.getxCoordinatePoint();
		 int y = point.getyCoordinatePoint();
		
		 if( x < ( xCoordinatePoint + width ) && y < ( yCoordinatePoint + width))
		 {
			 return true;
		 }
		 
		return false;
	}

}
