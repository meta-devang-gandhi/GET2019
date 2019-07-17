import java.util.Scanner;
/**
 * 
 * @author Devang
 * It is main Class.
 * It take a input from user and call the ShapOfArea_Class Method.
 */
public class ShapeController
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		ShapOfArea Area = new ShapOfArea();
		double width = 0;
		double height = 0;
		double area = 0;
		double radius = 0;
		
		// area of triangle	
    	try 
    	{
            System.out.println("Enter width of Triangle");
		    width = sc.nextDouble();
			System.out.println("Enter height of Triangle");
			height = sc.nextDouble();
		} 
       catch (Exception e) 
    	{
			System.out.println(e);
			System.out.println("Entered value is wrong");
			System.exit(0);
		}
    	 area = Area.triangleOfArea(width, height);		
    	 System.out.printf("\nArea of Triangle is: %.2f", area);
    	 System.out.println();
	
    	 // area of Rectangle
		try
		{
			System.out.println("Enter width of Rectangle");
			width = sc.nextDouble();
			System.out.println("Enter height of Rectangle");
			height =sc.nextDouble();
    	}
		catch (Exception e) 
		{
			System.out.println(e);
			System.out.println("Entered value is wrong");
			System.exit(0);
		}
         area = Area.rectangleOfArea(width, height);
         System.out.printf("\nArea of Rectangle is: %.2f", area);	
         System.out.println();
		
         // Area of Circle
		try
		{
			System.out.println("Enter radius of Circle");
			radius = sc.nextDouble();
		} 
		catch (Exception e) 
		{
		
			System.out.println(e);
			System.out.printf("Entered value is wrong");
			System.exit(0);
		}
         area = Area.circleOfArea(radius);
         System.out.printf("\nArea of Circle is: %.2f", area);	
         System.out.println();
        
        // Area of Square  
		try 
		{
			System.out.println("\nEnter width of Square");
			width = sc.nextDouble();
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			System.out.println("Entered value is wrong");
			System.exit(0);
		}
        area = Area.squareOfArea(width);
		System.out.printf("\nArea of Square is: %.2f", area);
		sc.close();
	}
}


