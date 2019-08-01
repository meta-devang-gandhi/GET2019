import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class implement virtual screen.
 * @author devang2304
 *
 */
public class Screen
{
     private Map <Integer, Shape> mapOfShapeOnScreen = new HashMap <Integer , Shape>();
     private Map <Shape, Date> timeStampMap = new HashMap <Shape, Date>();
     private int uniqueId =1;
     
     /**
      * Method adds the shape on the screen.
      * @param shape object of shape.
      * @return 1 if shape added on screen else return 0.
      */
     public int addShape(Shape shape) 
     {
    	 if (shape != null) 
    	 {
             Date date = new Date();
             mapOfShapeOnScreen.put(uniqueId, shape);
             uniqueId++;
             timeStampMap.put(shape, date);
             System.out.println("Shape added at origin location " + shape.getOrigin() + " with id: " + uniqueId + " having timestamp: " + date);
             System.out.println("\nShapes On screen:\n");
             showShapesOnScreen();
             return 1;
         }
    	 
    	 return 0;
     }
     
     /**
      * Method remove the object of shape from screen.
      * @param uniqueShapeId  
      * @return 1 if removed else return 0. 
      */
     public int deleteShapeFromScreen(int uniqueShapeId) 
     {
         if (uniqueShapeId != 0)
         {
             timeStampMap.remove(mapOfShapeOnScreen.get(uniqueShapeId));
             mapOfShapeOnScreen.remove(uniqueShapeId);
             showShapesOnScreen();
             return 1;
         }
         
         return 0;
     }

     /**
      * Method remove all the shape of specific type on screen.
      * @param shapeType
      * @return 1 if removed else 0.
      */
     public int deleteAllShapeOfSpecificType(String shapeType) 
     {
    	 int flag = 0;
         for (Shape value: mapOfShapeOnScreen.values()) 
         {
             if ((value.getType().name()).equals(shapeType))
             {
            	 flag = 1;
                 mapOfShapeOnScreen.remove(value);
                 timeStampMap.remove(value);
             }
         }
         showShapesOnScreen();
         
         return flag;
     }
     
     /**
      * Method sort the list of shapes in ascending order based on area
      * @return list of shape.
      */
     public List < Shape > getSortedListOfShapes() 
     {
         List < Shape > listOfShapes = new ArrayList < Shape > ();
         for (Shape value: mapOfShapeOnScreen.values()) 
         {
             listOfShapes.add(value);
         }

         int size = listOfShapes.size();
         for (int i = 0; i < size; i++) 
         {
             for (int j = 0; j < size - 1 - i; j++) 
             {
                 double area1 = listOfShapes.get(j).getArea();
                 double area2 = listOfShapes.get(j + 1).getArea();
                 if (area1 > area2) 
                 {
                     Shape temp1 = listOfShapes.get(j);
                     Shape temp2 = listOfShapes.get(j + 1);
                     listOfShapes.remove(j);
                     listOfShapes.add(j, temp2);
                     listOfShapes.remove(j + 1);
                     listOfShapes.add(j + 1, temp1);
                 }
             }
         }
         
         return listOfShapes;
     }
     
     /**
      *Method to find the shapes enclosing a particular point
      * @param point object of point which is enclosed.	
      * @return list of enclosing shapes.
      */
     public List < Shape > getListOfShapesEnclosingThePoint(Point point) 
     {
         List < Shape > ListOfEnclosingShapes = new ArrayList < Shape > ();
         for (Shape value: mapOfShapeOnScreen.values()) 
         {
             if (value.isPointEnclosed(point)) 
             {
            	 ListOfEnclosingShapes.add(value);
             }
         }

         return ListOfEnclosingShapes;
     }
     
     /**
      *Method return the id of shape. 
      */
     public int getUniqueId()
     {
         return uniqueId;
     }
     
     /**
      *Method shows the shapes present on the screen
      */
     private void showShapesOnScreen() 
     {
         for (Shape shape: mapOfShapeOnScreen.values()) 
         {
             System.out.println("Shape Type : " + shape.getType().name());
             System.out.println("Origin : " + shape.getOrigin());
             System.out.println("Area : " + shape.getArea());
             System.out.println("Perimeter : " + shape.getPerimeter());
             System.out.println("-----------------------------------------------------");
         }
     }       
}
