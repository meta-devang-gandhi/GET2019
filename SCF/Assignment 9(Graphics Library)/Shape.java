
/**
 * This class is a super class.
 */
public interface Shape 
{
    //Return the area of shape.
	public double getArea();
	
	//Return the perimeter of shape.
	public double getPerimeter();
	
	//Return the origin of the shape.
	public String getOrigin();
	
	//Return the type of shape.
	public ShapeType getType();
	
	//Check the point is enclosed or not.
	public boolean isPointEnclosed(Point point);
	
}