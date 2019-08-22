# Identify the columns require indexing in order, product, category tables and create indexes.

EXPLAIN
     SELECT OrderId
     FROM Orders
     WHERE ShippingAddressId = 2;
     
ALTER TABLE Orders
ADD INDEX IndexName(ShippingAddressId);

EXPLAIN
     SELECT ProductId
     FROM Product
     WHERE unitPrice = 100;
     
ALTER TABLE Product
ADD INDEX IndexName(unitPrice);

EXPLAIN
     SELECT CategoryId
     FROM Category
     WHERE CategoryName = 'xyz1';

ALTER TABLE Category
ADD INDEX IndexName(CategoryName);