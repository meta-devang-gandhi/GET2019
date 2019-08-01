import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Main class Contain main method.
 */
public class ShapeMain 
{
    public static void main(String args[]) 
    {
        List <Integer> parametersList = new ArrayList <Integer> ();
        Screen screen = new Screen();
        Scanner scanner = new Scanner(System.in);
        int operationChoice = 0;
        boolean flag = true;
        while (operationChoice < 6) 
        {
            Shape shape = null;
            System.out.println("Select the operation you want to perform:");

            System.out.println("1. Add shape to screen\n2. delete shape from screen\n3. delete all shape of specific type from screen\n4. get shape list in sorted order\n5. get list of shapes enclosing a point\n6.exit");
            operationChoice = scanner.nextInt();
            switch (operationChoice) 
            {
                case 1:
                {
                    System.out.println("Enter the shape type from below list:");

                    for (ShapeType value: ShapeType.values())
                    {
                        System.out.println(value.name());
                    }

                    String choice = scanner.next();
                    ShapeType shapeSelected = null;
                    for (ShapeType value : ShapeType.values()) 
                    {
                        if (value.name().equalsIgnoreCase(choice)) 
                        {
                            shapeSelected = value;
                        }
                    }
                    if (shapeSelected == null) 
                    {
                        System.out.println("Invalid shape entered !");
                        break;
                    }
                     
                    try
                    {
                        flag = true;
                        while(flag)
                        {
                             System.out.println("Enter origin coordinate:");
                             System.out.println("X= ");
                             int originX = scanner.nextInt();
                             System.out.println("Y= ");
                             int originY = scanner.nextInt();
                            
                            if(originX < 0 || originY < 0)
                            {
                                System.out.println("Your input is negative, please enter positive vlaue of origin coordinate ");
                            }
                            else
                            {
                                flag = false;
                            }
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    Point point = new Point(originX, originY);
                    parametersList.removeAll(parametersList);
                    switch (shapeSelected) 
                    {
                        case RECTANGLE:
                        {
                            try
                            {
                               flag = true;
                               while(flag)
                               {
                                   System.out.println("Enter the length: ");
                                   int length = scanner.nextInt();
                                   parametersList.add(length);
                                   System.out.println("Enter the width: ");
                                   int width = scanner.nextInt();
                                   parametersList.add(width);
                                   
                                   if(length < 0 || width < 0)
                                   {
                                       System.out.println("Your input is negative, please again enter rectangle positive length and width");
                                   }
                                   else
                                   {
                                       flag = false;
                                   }
                               }
                            }
                            catch(Exception e)
                            {
                               System.out.println(e);
                            }
                            break;
                        }
                        case SQUARE:
                        {
                            try
                            {
                                flag = true;
                                while(flag)
                                {
                                    System.out.println("Enter the side: ");
                                    int side = scanner.nextInt();
                                     parametersList.add(side);
                                    
                                    if(side < 0)
                                    {
                                         System.out.println("Your input is negative, please again enter square positive side");
                                    }
                                    else
                                    {
                                       flag = false;
                                    }
                                }
                            }
                            catch(Exception e)
                            {
                               System.out.println(e);
                            }
                            break;
                        }
                        case CIRCLE:
                        {
                            try
                            {
                                flag = true;
                                while(flag)
                                {
                                    System.out.println("Enter the radius: ");
                                    int radius = scanner.nextInt();
                                    parametersList.add(radius);
                                    
                                    if(radius < 0)
                                    {
                                        System.out.println("Your input is negative, please again enter circle positive radius");
                                    }
                                    else 
                                    {
                                      flag = false;
                                    }
                                }
                            }
                            catch(Exception e)
                            {
                               System.out.println(e);
                            }
                            break;
                        }
                        case TRIANGLE:
                        {
                            try
                            {
                                flag = true;
                                while(flag)
                                {
                                   System.out.println("Enter the side1: ");
                                   int side1 = scanner.nextInt();
                                   parametersList.add(side1);
                                   System.out.println("Enter the side2: ");
                                    int side2 = scanner.nextInt();
                                   parametersList.add(side2);
                                    System.out.println("Enter the side3: ");
                                    int side3 = scanner.nextInt();
                                    parametersList.add(side3);
                                    
                                    if(side1 < 0 || side2 <0 || side3 <0)
                                    {
                                        System.out.println("Your input is negative, please again enter tringle positive side");
                                    }
                                    else
                                    {
                                        flag = false;
                                    }
                                }
                            }
                            catch(Exception e)
                            {
                               System.out.println(e);
                            }
                            break;
                        }
                        default:
                            break;
                    }
                    shape = ShapeObjectFactory.createShape(shapeSelected, point, parametersList);
                    screen.addShape(shape);

                    break;
                }
                case 2:
                {
                    System.out.println("Enter unique Id of the shape:");
                    int uniqueShapeId = scanner.nextInt();
                    screen.deleteShapeFromScreen(uniqueShapeId);
                    break;
                }
                case 3:
                {
                    System.out.println("Enter shape type: ");
                    String shapeType = scanner.next();
                    screen.deleteAllShapeOfSpecificType(shapeType);
                    break;
                }
                case 4:
                {
                    System.out.println("\nSorted based on area (ascending):");
                    for (Shape value: screen.getSortedListOfShapes()) 
                    {
                        System.out.println("Shape Type : " + value.getType().name());
                        System.out.println("Origin : " + value.getOrigin());
                        System.out.println("Area : " + value.getArea());
                        System.out.println("Perimeter : " + value.getPerimeter());
                        System.out.println("-----------------------------------------------------\n");
                    }
                    break;
                }
                case 5:
                {
                    try
                    {
                       System.out.println("Enter x coordinate: ");
                       int xCoordinate = scanner.nextInt();
                       System.out.println("Enter Y coordinate: ");
                        int yCoordinate = scanner.nextInt();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    Point point1 = new Point(xCoordinate, yCoordinate);
                    for (Shape value: screen.getListOfShapesEnclosingThePoint(point1)) 
                    {
                        System.out.println("Shape Type : " + value.getType().name());
                        System.out.println("Origin : " + value.getOrigin());
                        System.out.println("Area : " + value.getArea());
                        System.out.println("Perimeter : " + value.getPerimeter());
                        System.out.println("-----------------------------------------------------\n");
                    }
                    break;
                }
                default:
                    break;
            }
        }
    }
}
