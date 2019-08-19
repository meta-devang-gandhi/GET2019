# Create appropriate tables and relationships for the same and write a SQl query for that returns a 
# Resultset containing Zip Code, City Names and States ordered by State Name and City Name.

CREATE TABLE State 
( 
	StateId INT(11) NOT NULL AUTO_INCREMENT, 
	StateName VARCHAR(45) UNIQUE NOT NULL, 
	PRIMARY KEY (StateId)
); 

CREATE TABLE City 
( 
	CityId INT(11) NOT NULL AUTO_INCREMENT,
	CityName VARCHAR(45) NOT NULL,
	ZipCode INT(11) NOT NULL UNIQUE,
	StateId INT(11) NOT NULL,
	PRIMARY KEY (CityId),
	FOREIGN KEY (StateId) REFERENCES State (StateId)
) ;


	INSERT INTO State (StateName) 	
	VALUES ('Rajasthan'),
          ('Goa'),
          ('Gujrat'),
         ('Uttarakhand');

	INSERT INTO City (CityName, Zipcode, StateId) 
	VALUES ('Jaipur', 302033, 1),
	        ('Panaji', 302093, 2),
           ('Gandhinagar', 262033, 3),
           ('Dehradun',985464, 4);
           
        
SELECT c.ZipCode, c.CityName, s.StateName 
FROM City AS c INNER JOIN State AS s ON c.StateId = s.StateId 
ORDER BY s.StateName, c.CityName;
