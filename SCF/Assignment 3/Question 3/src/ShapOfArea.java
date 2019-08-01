/**
 * @author Devang
 * It have a specified method.
 * It find the area of Shapes. 
 */
public class ShapOfArea 
{
	/**
	 * 
	 * @param radius
	 * @return area of Circle
	 */
   public double circleOfArea(double radius)
   {
	   return ((double)22/(double)7)*radius*radius ;
   }
  
   /**
    * 
    * @param width
    * @param height
    * @return area of Triangle
    */
    public double triangleOfArea(double width, double height)
    {
    	return ((double)1/(double)2)*width*height;
    }
    
    /**
     * 
     * @param width
     * @param height
     * @return area of Rectangle
     */
    public double rectangleOfArea(double width, double height)
    {
    	return  width*height;
    }
    /**
     * @param width
     * @return area of square 
     */
    public double squareOfArea(double width)
    {
    	return  width*width;
    }
}
