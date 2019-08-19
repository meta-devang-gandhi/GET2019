#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT u.UserId, u.UserName, Count(orderId) AS NOOfOrder FROM User AS u
INNER JOIN Orders AS o ON u.UserId = o.UserId
Where u.userRoll = "Shopper" AND DATEDIFF(curdate(), o.OrderDate ) < 30
GROUP BY o.UserId;

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT u.UserId, u.UserName, sum(o.OrderAmount) FROM User AS u 
INNER JOIN Orders AS o ON u.UserId = o.userId
WHERE DATEDIFF(curdate(), o.OrderDate ) < 30
GROUP BY o.UserId
LIMIT 10;

#Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT t.ProductId, count(t.ProductId) AS NoOfOrderOfProduct FROM ItemOrder t
INNER JOIN Orders o ON t.OrderId = o.OrderId 
WHERE  DATEDIFF(curdate(), o.OrderDate ) < 60
GROUP BY ProductId
ORDER BY NoOfOrderOfProduct DESC
LIMIT 20;

#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT sum(OrderAmount),
CASE WHEN datediff(curdate(), OrderDate) / 30 <= 1 THEN '1st month'
WHEN datediff(curdate(), OrderDate) / 30  BETWEEN 1 AND 2 THEN '2nd month'
WHEN datediff(curdate(), OrderDate) / 30  BETWEEN 2 AND 3 THEN '3rd month'
WHEN datediff(curdate(), OrderDate) / 30  BETWEEN 3 AND 4 THEN '4th month'
WHEN datediff(curdate(), OrderDate) /30  BETWEEN 4 AND 5 THEN '5th month'
WHEN datediff(curdate(), OrderDate) /30  BETWEEN 5 AND 6 THEN '6th month'
ELSE 'OtherMonths'
end AS MonthlySale
FROM Orders
GROUP BY MonthlySale
ORDER BY datediff(curdate(),OrderDate)/30;

#Mark the products as Inactive which are not ordered in last 90 days
alter table Product
add active BOOLEAN default 1;

UPDATE product AS p LEFT OUTER JOIN ItemOrder AS io on p.productId = io.productId 
left outer join Orders AS o on  o.orderId = io.orderId
set p.active = 0
where datediff(curdate(), o.orderDate) > 90
or o.orderId is null;


#Given a category search keyword, display all the Products present in this category/categories. 
SELECT p.productId, p.productTitle
FROM categoryProductMap AS cp INNER JOIN Category AS c
ON cp.categoryId = c.categoryId
INNER JOIN Product AS p
ON p.ProductId = cp.productId
WHERE c.categoryName IN ('xyz1', 'xyz2'); 

#Display top 10 Items which were cancelled most.
SELECT ot.ProductId, p.ProductTitle, count(*) AS Cancel FROM ItemOrder ot
INNER JOIN Product p ON p.ProductId = ot.ProductId
WHERE Status = "cancelled"
Group By ProductId
ORDER BY Cancel
LIMIT 10;

