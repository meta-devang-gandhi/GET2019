package JDBC;

/**
 *Class to hold all query data.
 */
public class Query 
{
	/**
	 * Method have query for user order.
	 * @param shopperId
	 * @return
	 */
   public static String userOrderQuery(int shopperId)
   {
	   String query = "Select DISTINCT o.orderId, o.OrderDate, o.orderAmount "
   			+ "from Orders o "
   			+ "Inner Join orderItem oi ON oi.orderId = o.OrderId "
   			+ "WHERE  oi.status = 'shipped'  AND o.UserId =" + shopperId 
   			+ " Order BY o.OrderDate";
	   
	   return query;
   }
   
   /**
    * Method have query for delete product.
    * @return
    */
   public static String deleteProductQuery()
   {
	   String query = "UPDATE Product  p LEFT OUTER JOIN OrderItem  io ON p.productId = io.productId " 
				 +"LEFT OUTER JOIN Orders  o ON  o.orderId = io.orderId "
				 +"SET p.active = 0 "
				 +"WHERE DATEDIFF(curdate(), o.orderDate) > 365 "
				 +"OR o.orderId is null";
	   
	   return query;
   }
   
   /**
    * Method have query for batch images insert.
    * @return
    */
   public static  String BatchImageInserts()
   {
	   String query = "INSERT INTO storefront.Image "
				+ "(ImageName, ProductId) VALUES (?, ?);";
	   return query;
   }
   
   /**
    * Method have query for get parent category.
    * @return
    */
   public static String ParentCategoryQuery()
   {
	   String query = "SELECT c.CategoryId AS ParentCategory , c.CategoryName, count(c.categoryId) AS NoOfSubChild "
 			  +"FROM category c INNER JOIN category p "
 			  +"ON c.categoryid = p.ParentcategoryId "
 			  +"WHERE c.parentCategoryID IS NULL "
 			  +"GROUP BY p.parentCategoryID "
 			  +"ORDER BY c.categoryName";
	   
	   return query;
   }
}
