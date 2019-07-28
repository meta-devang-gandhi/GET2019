import java.util.List;

public class ShapeObjectFactory 
{
	public static Shape createShape(ShapeType shapeType,Point point, List<Integer> parametersList)
	{
		Shape shape=null;
		
		if(point.getxCoordinatePoint() > point.getMAX_X_COORDINATE() || point.getyCoordinatePoint() > point.getMAX_Y_COORDINATE()) 
		{
			System.out.println("Screen limit exceed !");
			return null;
		}
		
		switch (shapeType) 
		{
		case RECTANGLE:
			shape = new Rectangle(point.getxCoordinatePoint(), point.getyCoordinatePoint(), parametersList.get(0),parametersList.get(1));
			break;
			
		case CIRCLE:
			shape = new Circle(point.getxCoordinatePoint(), point.getyCoordinatePoint(), parametersList.get(0));
			break;
			
		case SQUARE:
			shape = new Square(point.getxCoordinatePoint(), point.getyCoordinatePoint(), parametersList.get(0));
			break;
			
		case TRIANGLE:
			shape = new Triangle(point.getxCoordinatePoint(), point.getyCoordinatePoint(), parametersList.get(0),parametersList.get(1),parametersList.get(2));
			break;

		default:
			break;
		}
		return shape;
	}
}
