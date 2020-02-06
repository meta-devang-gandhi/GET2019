package com.metacube.parkingSystem.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parkingSystem.dao.IEmployeeDao;
import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.EmployeeDTO;
import com.metacube.parkingSystem.model.EmployeeDetails;
import com.metacube.parkingSystem.model.Pass;
import com.metacube.parkingSystem.model.PassType;
import com.metacube.parkingSystem.model.Vehicle;
import com.metacube.parkingSystem.service.IEmployeeSevice;

/*
 * Implementation of service interface. 
 */
@Service
public class EmployeeServiceImp implements IEmployeeSevice{

	@Autowired
	private IEmployeeDao employeeDao;
	
	@Override
	public boolean addEmployee(Employee emp, short organizationId) {
		return employeeDao.addEmployee(emp,organizationId);
	}

	@Override
	public short getOrganizationId(String organizationName) {
	   return employeeDao.getOrganizationId(organizationName);
	}

	@Override
	public int getEmpolyeeId() {
		
		return employeeDao.getEmployeeId();
	}

	@Override
	public boolean addVehicle(Vehicle vehicle) {
		return employeeDao.addVehicle(vehicle);
	}

	@Override
	public PassType getPrice(String vehicleType) {
		return employeeDao.getPrice(vehicleType);
	}

	@Override
	public boolean addVehiclePass(Pass pass, int empId) {
		return employeeDao.addVehiclePass(pass, empId);
	}

	@Override
	public String auth(String email) {
		return employeeDao.auth(email);
	}

	@Override
	public EmployeeDetails getEmployeeDetails(String emailId) {
		return employeeDao.getEmployeeDetails(emailId);
	}

	@Override
	public boolean updateEmployeeDetails(EmployeeDetails empDetails,
			Short OrganizationId) {
		return employeeDao.updateEmployeeDetails(empDetails, OrganizationId);
	}

	@Override
	public List<Employee> getFriendList(short OrganizationId, String email) {
		return employeeDao.getFriendList(OrganizationId, email);
	}

	@Override
	public short getOrganizationIdByEmail(String email) {
		return employeeDao.getOrganizationIdByEmail(email);
	}

}
