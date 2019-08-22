#1 Create a Stored procedure to retrieve average sales of each product in a month. 
-- Month and year will be input parameter to function.

DELIMITER &&
DROP PROCEDURE IF EXISTS averageSale &&
CREATE PROCEDURE averageSale(month1 INT, year1 INT)
BEGIN
DECLARE NoOfProductInMonth INT;

DROP TEMPORARY TABLE IF EXISTS ordersDetails ;
CREATE TEMPORARY TABLE IF NOT EXISTS ordersDetails
SELECT ot.ProductId, ot.Quantity, o.OrderId, o.OrderDate FROM Orders o
INNER JOIN OrderItem ot
ON o.OrderId = ot.OrderId
WHERE MONTH(o.OrderDate) = month1 AND YEAR(o.OrderDate) = year1;

SET NoOfProductInMonth = (SELECT sum(Quantity) FROM ordersDetails);

SELECT ProductId, sum(Quantity) / NoOfProductInMonth AS AverageSale
FROM ordersDetails
GROUP BY ProductId;

END &&

DELIMITER  ;

Call averageSale(08,2019);

#2 Create a stored procedure to retrieve table having order detail with status for a given period. 
-- Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. 
-- If start date is greater than end date take first date of month as start date.

DELIMITER &&
DROP PROCEDURE IF EXISTS averageSale &&
CREATE PROCEDURE ordersOfTheGivenPeriod(startDate DATE, endDate DATE)

BEGIN
 IF(startDate > endDate) THEN 
 SELECT DATE_SUB(endDate, INTERVAL Day(endDate) + 1 day) INTO startDate;
 END IF;

 SELECT 
        o.OrderId,
        oi.Status,
        o.OrderAmount,
        o.UserId,
        oi.ProductId
 FROM Orders o 
 INNER JOIN OrderItem oi
 ON oi.OrderId = o.OrderId
 WHERE OrderDate >= startDate 
      AND OrderDate <= endDate;
END &&

DELIMITER ;

call ordersOfTheGivenPeriod('2019-05-03','2019-08-12');

