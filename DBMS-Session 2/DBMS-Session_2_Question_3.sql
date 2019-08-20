#1
SELECT OrderId, OrderDate, OrderDate OrderAmount FROM Orders 
ORDER BY OrderId DESC
LIMIT 50;

#2
SELECT OrderId, OrderDate, OrderDate OrderAmount FROM Orders 
ORDER BY OrderAmount DESC
LIMIT 10;

#3
SELECT o.OrderId
FROM orders AS o inner join ItemOrder AS i on o.OrderId = i.OrderId
where DATEDIFF(curdate(), o.OrderDate) > 10
and i.Status NOT IN("Shipped")
group by OrderId;

#4
SELECT UserName FROM User 
WHERE UserRoll = "Shopper"  AND UserId NOT IN (SELECT UserId FROM Orders 
WHERE DATEDIFF(curdate(), OrderDate) < 31);

#5
SELECT u.UserName, o.OrderId FROM User AS u 
INNER JOIN Orders AS o ON u.UserId = o.UserId
WHERE DATEDIFF(curdate(),o.OrderDate) < 15;

#6
SELECT ProductId FROM ItemOrder
WHERE Status = 'Shipped'
AND OrderId = 1;

#7
SELECT p.ProductTitle, o.OrderDate FROM Orders AS o 
INNER JOIN ItemOrder AS i ON o.OrderId = i.OrderId
INNER JOIN Product p ON p.ProductId = i.ProductId
WHERE p.UnitPrice BETWEEN 20 AND 50;    