package com.metacube.parkingSystem.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

/**
 *Class entity of Employee Details.
 *Class hold the all information of employee.
 */
public class EmployeeDetails {

	@NotBlank
	private String Name;
	
	private String email;
	
	@NotBlank
	private String Gender;
	
	@Column(precision = 10)
	private long ContactNumber;
	
	@NotBlank
	private String Organization;
	
	@NotBlank
	private String VehicleName;
	
	@NotBlank
	private String VehicleNumber;
	
	@NotBlank
	private String VehicleType;
	
	@NotBlank
	private String VehicleIdentification;
	
	private String PassRate;

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public long getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(long contactNumber) {
		ContactNumber = contactNumber;
	}

	public String getOrganization() {
		return Organization;
	}

	public void setOrganization(String organization) {
		Organization = organization;
	}

	public String getVehicleNumber() {
		return VehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		VehicleNumber = vehicleNumber;
	}

	public String getVehicleName() {
		return VehicleName;
	}

	public void setVehicleName(String vehicleName) {
		VehicleName = vehicleName;
	}

	public String getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(String vehicleType) {
		VehicleType = vehicleType;
	}

	public String getVehicleIdentification() {
		return VehicleIdentification;
	}

	public void setVehicleIdentification(String vehicleIdentification) {
		VehicleIdentification = vehicleIdentification;
	}

	public String getPassRate() {
		return PassRate;
	}

	public void setPassRate(String passRate) {
		PassRate = passRate;
	}
}
