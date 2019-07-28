import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ScreenTest 
{

	ShapeType shapeType=  ShapeType.RECTANGLE;
	Point point=new Point(2, 3);
	List<Integer> parametersList1 = new ArrayList<Integer>();
	List<Integer> parametersList2 = new ArrayList<Integer>();
	List<Integer> parametersList3 = new ArrayList<Integer>();
	Shape shape;
	Screen screen=new Screen();
	
	@Test
	public void testAddShapeToScreen_Success() 
	{
		parametersList1.add(4);
		parametersList1.add(5);
		shape = ShapeObjectFactory.createShape(ShapeType.RECTANGLE, point, parametersList1);
		
		parametersList2.add(3);
		Shape shape1 = ShapeObjectFactory.createShape(ShapeType.SQUARE, point, parametersList2);
		
		parametersList3.add(2);
		Shape shape2=ShapeObjectFactory.createShape(ShapeType.CIRCLE, point, parametersList3);
		
		int result = screen.addShape(shape);
		assertEquals(1, result);

		result = screen.addShape(shape1);
		assertEquals(1, result);

        result = screen.addShape(shape2);
		assertEquals(1, result);
	}
	
	
	@Test
	public void testAddShapeToScreen_Failure() 
	{
		int result = screen.addShape(shape);	
		assertEquals(0, result);
	}
	
	@Test
	public void testDeleteShapeFromScreen_Success() 
	{
		int result = screen.deleteShapeFromScreen(screen.getUniqueId());
		
		assertEquals(1, result);
	}
	
	@Test
	public void testDeleteShapeFromScreen_Failure() 
	{
		int result = screen.deleteShapeFromScreen(screen.getUniqueId());
		
		assertNotEquals(0, result);
	}

	@Test
	public void testIsEnclosed_Success() 
	{
		parametersList1.add(4);
		parametersList1.add(5);
		Point point1 = new Point(3,4);
		shape = ShapeObjectFactory.createShape(ShapeType.RECTANGLE, point, parametersList1);
		boolean result = shape.isPointEnclosed(point1);
		
		assertEquals(true, result);
	}

	@Test
	public void testIsEnclosed_Failure() 
	{
		Point point1 = new Point(3,15);
		parametersList1.add(4);
		parametersList1.add(5);
		shape = ShapeObjectFactory.createShape(ShapeType.RECTANGLE, point, parametersList1);
		boolean result = shape.isPointEnclosed(point1);
		
		assertEquals(false, result);
	}

	@Test
	public void testDeleteAllShapeOfSpecificType_Success() 
	{
		parametersList2.add(3);
		Shape shape1 = ShapeObjectFactory.createShape(ShapeType.SQUARE, point, parametersList2);
		screen.addShape(shape1);
		int result = screen.deleteAllShapeOfSpecificType("SQUARE");
		
		assertEquals(1, result);
	}
	
	
	@Test
	public void testDeleteAllShapeOfSpecificType_Failure() 
	{
		int result = screen.deleteAllShapeOfSpecificType("RECTANGLE");
		
		assertEquals(0, result);
	}
}