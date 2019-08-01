
/**
 * Class is perform operation of tringle.
 */
public class Triangle implements Shape 
{
	private int xCoordinatePoint;
    private int yCoordinatePoint;
    private int side1;	
    private int side2;
    private int side3;
    
    /**
     * 
     * @param xCoordinatePoint
     * @param yCoordinate
     * @param side1
     * @param side2
     * @param side3
     */
    public Triangle(int xCoordinatePoint, int yCoordinatePoint, int side1, int side2, int side3) 
    {
	    this.xCoordinatePoint = xCoordinatePoint;
	    this.yCoordinatePoint = yCoordinatePoint;
	    this.side1 = side1;
	    this.side2 = side2;
	    this.side3 = side3;
	}
	
    //Method return the area.
	@Override
	public double getArea() 
	{
		double area;
		double s = ( side1 + side2 + side3 ) / 2;
		area = Math.sqrt( s * ( s - side1 ) * ( s - side2 ) * ( s - side3 ) );
		
		return area;
	}

	//Method return the perimeter
	@Override
	public double getPerimeter() 
	{
		return ( side1 + side2 + side3 );
	}

	// Method return the coordinate of origin. 
	@Override
	public String getOrigin()
	{
        String originCoordinate = "";
		
		originCoordinate += String.valueOf(xCoordinatePoint) + ",";
		originCoordinate += String.valueOf(yCoordinatePoint);
		
		return originCoordinate;
	}

	//Method return the shape type.
	@Override
	public ShapeType getType()
	{
	    return ShapeType.TRIANGLE;
	}

	//Method checks for the point whether it is enclosed or not
	@Override
	public boolean isPointEnclosed(Point point)
	{
		 int x = point.getxCoordinatePoint();
		 int y = point.getyCoordinatePoint();
		
		 int x2 = xCoordinatePoint + side1;
		 int y2 = yCoordinatePoint + side1;

		 int x3 = x2 + side2;
		 int y3 = y2 + side2;
		 if(x >= xCoordinatePoint && x <= x3 && y <= y2) 
		 {
			 return true;
		 }
		 
		return false;	
	}

}
