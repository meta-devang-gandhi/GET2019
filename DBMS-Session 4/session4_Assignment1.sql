#1. Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
DELIMITER &&
CREATE FUNCTION OrdersInMonth(month INT, year INT) RETURNS INT

BEGIN
DECLARE NoOfOrder INT;
SELECT count(o.OrderId) INTO NoOfOrder
FROM Orders o
WHERE MONTH(o.OrderDate) = month AND YEAR(o.OrderDate) = year
GROUP By MONTH(o.OrderDate);
RETURN NoOfOrder;

END &&

DELIMITER ;

SELECT OrdersInMonth(07,2019),OrdersInMonth(08,2019) ;


#2 Create a function to return month in a year having maximum orders. Year will be input parameter.
DELIMITER &&
DROP FUNCTION IF EXISTS MonthOfMaxOrders &&
CREATE FUNCTION MonthOfMaxOrders(year INT) RETURNS INT

BEGIN
DECLARE maxNoOfOrder INT;

SELECT 
       MONTH(o.orderDate) INTO maxNoOfOrder
FROM Orders o
WHERE YEAR(o.OrderDate) = year 
Group By MONTH(o.orderDate)
Order By count(o.orderDate) DESC
limit 1;
RETURN maxNoOfOrder;
END &&

DELIMITER ;

SELECT MonthOfMaxOrders(2019);



