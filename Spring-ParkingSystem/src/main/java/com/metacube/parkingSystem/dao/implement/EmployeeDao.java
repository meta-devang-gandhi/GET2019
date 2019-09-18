package com.metacube.parkingSystem.dao.implement;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.dao.IEmployeeDao;
import com.metacube.parkingSystem.mapper.EmployeeDetailsMapper;
import com.metacube.parkingSystem.mapper.EmployeeMapper;
import com.metacube.parkingSystem.mapper.PassTypeMapper;
import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.EmployeeDetails;
import com.metacube.parkingSystem.model.Pass;
import com.metacube.parkingSystem.model.PassType;
import com.metacube.parkingSystem.model.Vehicle;

/**
 * Repository class Class implement method of Employee Dao interface.
 */
@Repository
public class EmployeeDao implements IEmployeeDao {

	private final String INSERT_EMPLOYEE = "INSERT INTO Employees(FullName, Email, Gender, password, ContactNumber, OrganizationId) values(?,?,?,?,?,?)";

	private final String GET_ORGANIZATION_ID = "SELECT Id FROM Organization WHERE Name = ?";

	private final String GET_EMP_ID = "SELECT last_insert_id() as employee_id";

	private final String INSERT_VEHICLE = "INSERT INTO Vehicle VALUES(?,?,?,?,?)";

	private final String GET_PRICE_OF_PASS = "SELECT daily, monthly, yearly FROM vehiclePass WHERE vehicleType = ?";

	private final String ADD_VEHICLE_PASS = "INSERT INTO EmployeePass VALUES(?, ?)";

	private final String AUTH = "SELECT Password FROM Employees WHERE email=?";

	private final String GET_ORGANIZATIONID_BY_EMAIL = "SELECT OrganizationId FROM Employees WHERE email = ?";

	private final String GET_EMPLOYEE_DETAILS = "SELECT  e.FullName AS Name,  e.email AS email,e.Gender AS Gender, e.ContactNumber AS ContactNumber, "
			+ "o.name AS Organization,  v.Name AS VehicleName, v.Number AS VehicleNumber, v.Type AS VehicleType, "
			+ "v.Identification AS VehicleIdentification, ep.passTypeRate AS PassRate "
			+ "FROM Employees e INNER JOIN Vehicle v ON e.ID = v.EmployeeId INNER JOIN EmployeePass ep ON ep.employeeId = e.id "
			+ "INNER JOIN Organization o ON e.organizationId = o.id  WHERE email = ? ";

	private final String UPDATE_EMPLOYEE_DETAILS = "UPDATE Employees e INNER JOIN Vehicle v "
			+ "ON e.Id = v.EmployeeId "
			+ " SET "
			+ " e.FullName = ?,  "
			+ " e.Gender = ?, "
			+ " e.ContactNumber = ?, "
			+ " e.OrganizationId = ?,  "
			+ " v.Name = ?, "
			+ " v.Type = ?, "
			+ " v.number = ?, "
			+ " v.Identification = ? "
			+ "Where e.email = ?";

	private final String GET_FRIEND_LIST = " SELECT FullName AS Name, email FROM Employees WHERE OrganizationId = ? AND email != ? ";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDao(DataSource dataSource) {
		System.out.println("connection....");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean addEmployee(Employee emp, short organizationId) {

		return jdbcTemplate.update(INSERT_EMPLOYEE, emp.getFullName(),
				emp.getEmail(), emp.getGender(), emp.getPassword(),
				emp.getContactNumber(), organizationId) > 0;

	}

	@Override
	public short getOrganizationId(String organizationName) {
		return jdbcTemplate.queryForObject(GET_ORGANIZATION_ID,
				new Object[] { organizationName }, Short.class);
	}

	@Override
	public int getEmployeeId() {
		return jdbcTemplate.queryForObject(GET_EMP_ID, Integer.class);
	}

	@Override
	public boolean addVehicle(Vehicle vehicle) {
		return jdbcTemplate.update(INSERT_VEHICLE, vehicle.getVehicleName(),
				vehicle.getVehicleType(), vehicle.getVehicleNumber(),
				vehicle.getIdentification(), vehicle.getEmployeeId()) > 0;
	}

	@Override
	public PassType getPrice(String vehicleType) {
		return jdbcTemplate.queryForObject(GET_PRICE_OF_PASS,
				new Object[] { vehicleType }, new PassTypeMapper());
	}

	@Override
	public boolean addVehiclePass(Pass pass, int empId) {
		return jdbcTemplate.update(ADD_VEHICLE_PASS, empId, pass.getRate()) > 0;
	}

	@Override
	public String auth(String email) {
		try {
			return (String) jdbcTemplate.queryForObject(AUTH,
					new Object[] { email }, String.class);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public EmployeeDetails getEmployeeDetails(String emailId) {
		return jdbcTemplate.queryForObject(GET_EMPLOYEE_DETAILS,
				new Object[] { emailId }, new EmployeeDetailsMapper());
	}

	@Override
	public boolean updateEmployeeDetails(EmployeeDetails empDetails,
			Short OrganizationId) {
		return jdbcTemplate.update(UPDATE_EMPLOYEE_DETAILS,
				empDetails.getName(), empDetails.getGender(),
				empDetails.getContactNumber(), OrganizationId,
				empDetails.getVehicleName(), empDetails.getVehicleType(),
				empDetails.getVehicleNumber(),
				empDetails.getVehicleIdentification(), empDetails.getEmail()) > 0;
	}

	@Override
	public List<Employee> getFriendList(short OrganizationId, String email) {
		return jdbcTemplate.query(GET_FRIEND_LIST, new Object[] {
				OrganizationId, email }, new EmployeeMapper());
	}

	@Override
	public short getOrganizationIdByEmail(String email) {
		return jdbcTemplate.queryForObject(GET_ORGANIZATIONID_BY_EMAIL,
				new Object[] { email }, Short.class);
	}

}
