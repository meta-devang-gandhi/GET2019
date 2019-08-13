INSERT INTO Product(Quantity, ProductDescription, ProductTitle, UnitPrice, QuantityOfSell)
VALUES
     (5, "xyz1", "a", 500, 1),
     (2, "xyz2", "b", 50, 1),
     (50, "xy3", "c", 150, 1), 
     (30, "xy4", "d", 100, 8),
      (10, "xyz5", "e", 250, 4),
       (45, "xyz6", "f", 450, 2),
        (35, "xyz7", "g", 1150, 1);
     
     
     
INSERT INTO User(UserRoll, UserName, PhoneNo, EmailId)
VALUES
     ("Shopper", "Devang", "8387923931", "xyz@gmail.com"),
     ("Administrator", "Devang", "8387230127", "xyz1@gmail.com"),
     ("Shopper", "rahul", "9865426711", "xyz3@gmail.com"),
     ("Shopper", "vinod", "6723109871", "xyz2@gmail.com"),
     ("Shopper", "vinay", "9876543210", "xyz4@gmail.com"),
     ("Shopper", "atul", "9870937628", "xyz5@gmail.com"),
     ("Shopper", "ajay", "8127943731", "xyz6@gmail.com");    
     
     
     
INSERT INTO Category(CategoryName, ParentCategoryId)
VALUES
         ("xyz1", null),
         ("xyz2", null),
         ("xyz3", null), 
         ("xyz4", null),
          ("xyz5", null),
           ("xyz6", null),
            ("xyz7", null), 
            ("xyz8", null),
             ("xyz9", null);
             


INSERT INTO Image(ImageName, ProductId)
VALUES
     ("xyz", 15),
     ("xyz", 16),
     ("xyz", 17),
     ("xyz", 18),
     ("xyz", 19),
     ("xyz", 20),
     ("xyz", 21);
     

INSERT INTO Address(PinCode, Country, State, City,Area)
VALUES
       (302017, "India", "Rajasthan", "Jaipur", "Skit College"),
        (302017, "India", "Rajasthan", "Jaipur", "Metacube"),
         (302017, "India", "Rajasthan", "Jaipur", "GT"),
          (302017, "India", "Rajasthan", "Jaipur", "Ajmeri Gate");     
          
          
INSERT INTO Orders(OrderDate, OrderStatus, ShippingAddressId, UserId, OrderAmount)
VALUES
      (23/04/2019, "Booked", 2, 15,null);
   
   
   
INSERT INTO ItemOrder(OrderId, ProductId, Status, Quantity, UnitPrice)
VALUES
    (1, 1,"shipped",3,500),
    (1, 2,"shipped", 1, 50);
   
INSERT INTO AddressUserMap(AddressId, UserId)
VALUES
    (1,15),
    (1,20),
    (2,15),
    (2,16);
     
     
INSERT INTO CategoryProductMap(CategoryId, ProductId)
VALUES
    (1,1),
    (1,2),
    (2,3),
    (2,4),
     (3,5),
     (4,6),
     (2,7);     