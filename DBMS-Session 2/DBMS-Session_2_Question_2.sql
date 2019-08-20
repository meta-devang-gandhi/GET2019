SELECT p.ProductId, ProductTitle, UnitPrice, ct.categoryName from product p
INNER JOIN CategoryProductMap c ON c.ProductId = p.ProductId
INNER JOIN Category ct ON ct.categoryId = c.categoryId
where Quantity > 0 
ORDER BY p.ProductId DESC;


#2

SELECT ProductId, Quantity, ProductDescription, ProductTitle, UnitPrice, QuantityOfSell FROM product
WHERE ProductId NOT IN(Select ProductId from Image);

#3
SELECT C.CategoryId, C.CategoryName, (SELECT categoryName FROM category where CategoryId = C.parentCategoryId) as topCategory FROM category as C
ORDER BY C.ParentCategoryId ASC , C.CategoryId ASC;

#4
SELECT C.CategoryId, C.CategoryName FROM Category as C WHERE (C.categoryId NOT IN 
(SELECT distinct parentCategoryId  FROM category where parentCategoryId != 0));

#5
SELECT ProductTitle, UnitPrice, ProductDescription FROM Product
WHERE ProductId IN (select ProductId FROM CategoryProductMap WHERE 
CategoryId = (SELECT CategoryId  FROM Category WHERE CategoryName = "xyz1") )

#6
SELECT * FROM Product WHERE Quantity BETWEEN 1 and 50;