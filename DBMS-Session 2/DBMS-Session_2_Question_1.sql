
CREATE DATABASE StoreFront;

USE StoreFront;

CREATE TABLE Product
(
  ProductId INT NOT NULL AUTO_INCREMENT,
  Quantity INT NULL ,
  ProductDescription VARCHAR(200) NULL ,
  ProductTitle VARCHAR(45) NULL ,
  UnitPrice INT NULL ,
  QuantityOfSEll INT NOT NULL ,
  PRIMARY KEY (ProductId) 
);

CREATE TABLE Category
(
  CategoryId INT NOT NULL AUTO_INCREMENT,
   CategoryName VARCHAR(30),
   ParentCategoryId INT REFERENCES Category(CategoryId),
   PRIMARY KEY (CategoryId) 
);

CREATE TABLE CategoryProductMap
(
  CategoryId INT REFERENCES Category(CategoryId),
  ProductId INT REFERENCES Product(ProductId)
);

CREATE TABLE Image
(
  ImageId INT NOT NULL AUTO_INCREMENT,
  ImageName VARCHAR(50),
  ProductId INT REFERENCES Product(ProductId),
  PRIMARY KEY (ImageId)
);

CREATE TABLE Address
(
  AddressId INT NOT NULL AUTO_INCREMENT,
  PinCode INT NOT NULL,
  Country VARCHAR(50) NOT NULL,
  State VARCHAR(50) NOT NULL,
  City VARCHAR(50) NOT NULL,
  Area VARCHAR(100),
  PRIMARY KEY (AddressId)
);

CREATE TABLE User
(
  UserId INT NOT NULL AUTO_INCREMENT,
  UserRoll VARCHAR(20) NOT NULL,
  UserName VARCHAR(30) NOT NULL,
  PhoneNo VARCHAR(10) NOT NULL check (len(PhoneNo)=10),
  EmailId VARCHAR(50) NOT NULL UNIQUE,
  PRIMARY KEY (UserId)
);

CREATE TABLE Orders
(
   OrderId INT NOT NULL AUTO_INCREMENT,
   OrderDate DATE NOT NULL,
   OrderStatus VARCHAR(30) NOT NULL,
   ShippingAddressId INT NOT NULL REFERENCES Address(AddressId),
   UserId INT NOT NULL REFERENCES User(UserId),
   OrderAmount INT,
   PRIMARY KEY (OrderId)
);

CREATE TABLE ItemOrder
(
  OrderId INT NOT NULL REFERENCES Orders(OrderId),
  ProductId INT NOT NULL REFERENCES Product(ProductId),
  Status VARCHAR(30),
  Quantity INT NOT NULL,
  UnitPrice INT NOT NULL REFERENCES Product(UnitPrice)
);
