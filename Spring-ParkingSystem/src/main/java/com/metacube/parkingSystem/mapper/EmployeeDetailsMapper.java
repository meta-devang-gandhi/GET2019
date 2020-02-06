package com.metacube.parkingSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parkingSystem.model.EmployeeDetails;

/**
 *Class to map attribute on employee details class.
 */
public class EmployeeDetailsMapper implements RowMapper<EmployeeDetails> {

	@Override
	public EmployeeDetails mapRow(ResultSet result, int arg1) throws SQLException {
		EmployeeDetails empDetails = new EmployeeDetails();
		empDetails.setName(result.getString("Name"));
		empDetails.setEmail(result.getString("email"));
		empDetails.setGender(result.getString("Gender"));
		empDetails.setContactNumber(result.getLong("ContactNumber"));
		empDetails.setOrganization(result.getString("Organization"));
		empDetails.setVehicleName(result.getString("VehicleName"));
		empDetails.setVehicleNumber(result.getString("VehicleNumber"));
		empDetails.setVehicleType(result.getString("VehicleType"));
		empDetails.setVehicleIdentification(result.getString("VehicleIdentification"));
		empDetails.setPassRate(result.getString("PassRate"));

		return empDetails;
	}

}
