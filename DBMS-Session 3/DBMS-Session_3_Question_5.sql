#Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
#with latest ordered items should be displayed first for last 60 days.
        
CREATE VIEW OrderInformation
AS SELECT o.OrderId, p.ProductTitle, p.UnitPrice, u.UserId, u.EmailId, o.OrderDate, io.Status
FROM Orders AS o INNER JOIN ItemOrder AS io ON io.OrderId  = o.OrderId 
INNER JOIN Product P ON p.ProductId = io.ProductId
INNER JOIN User AS u ON u.UserId = o.UserId
where DATEDIFF(curdate(),o.OrderDate) <= 60;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT ProductTitle FROM OrderInformation
WHERE Status = 'Shipped';

#Use the above view to display the top 5 most selling products.
SELECT productTitle, count(productTitle) AS 'TotalSell'
From orderInformation
GROUP BY productTitle
order by totalSell desc;

