#1 Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT p.ProductId, p.ProductTitle, count(cp.CategoryId) AS CountOfCategoriesfrom FROM Product AS p
INNER JOIN CategoryProductMap AS cp ON p.ProductId = cp.ProductId
GROUP BY cp.ProductId;

#2 Display Count of products as per below price range:
SELECT 
(SELECT count(unitPrice)  FROM Product WHERE UnitPrice BETWEEN 0 AND 100) AS  0_To_100,
(SELECT count(unitPrice)  FROM Product WHERE UnitPrice BETWEEN 101 AND 500) AS  101_To_500,
(SELECT count(unitPrice)  FROM Product WHERE UnitPrice > 500) AS  Above_500 ;
 
#3 Display the Categories along with number of products under each category.
SELECT CategoryId, count(productId) FROM CategoryProductMap
GROUP BY CategoryId;

