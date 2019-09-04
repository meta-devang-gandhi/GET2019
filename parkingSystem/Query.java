package com.parkingSystem;

public class Query {
   
	 protected static String getOrganizationId(String organization)
	 {
		 String query = "select Id FROM Organization WHERE Name =\""+organization+"\"";
		 return query;
	 }
	 
	 protected static String insertEmployeeDetails()
	 {
		 String query = "INSERT INTO Employees(FullName, Email, Gender, Password, ContactNumber, OrganizationId) "
					+ "VALUES(?, ?, ?, ?, ?,?)";
		 return query;
	 }
	 
	 protected static String getEmployeeId()
	 {
		 String query = "SELECT ID FROM Employees where Email = ?";
		 return query;
	 }
	 
	 protected static String insertVehicleDetails()
	 {
		 String query = "INSERT INTO Vehicle(Name, Type, Number, Identification, EmployeeId) "
					+ "VALUES(?, ?, ?, ?, ?)";
		 return query;
	 }
	 
	 protected static String getVehiclePrice()
	 {
		 String query = "SELECT daily, monthly, yearly FROM VehiclePass WHERE VehicleType = ?";
		 return query;
	 }
	 
	 protected static String getEmployeePasswordWithId()
	 {
		 String query ="SELECT Id, Password FROM Employees WHERE email = ?";
		 return query;
	 }
	 
	 protected static String getEmployeeInformation()
	 {
		 String query = "SELECT e.FullName, e.email,e.ContactNumber,v.Type,v.Number, v.Identification FROM Employees e " 
                          +" INNER JOIN Vehicle v "
                           +" ON e.Id = v.EmployeeId "
                            +" WHERE e.Id = ? ";
		 return query;
	 }
	 
	 protected static String updateEmployeeDetails()
	 {
		 String query = "UPDATE Employees e INNER JOIN Vehicle v"
		 		          + "ON e.Id = v.EmployeeId "
		 		          + "SET "
		 		          + "e.Name = ?,"
		 		          + "e.email = ?,"
		 		          + "v.Type = ?, "
		 		          + "v.Number = ?, "
		 		          + "v.Identification = ? "
		 		          + "WHERE e.Id = ? ";
		 return query;
	 }
}
