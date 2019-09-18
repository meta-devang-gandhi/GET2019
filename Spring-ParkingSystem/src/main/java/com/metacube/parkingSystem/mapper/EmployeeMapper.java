package com.metacube.parkingSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parkingSystem.model.Employee;

/**
 *Class to map attribute on employee class.
 */
public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet result, int arg1) throws SQLException {
		Employee employee = new Employee();
		employee.setFullName(result.getString("Name"));
		employee.setEmail(result.getString("email"));
		return employee;
	}

}
