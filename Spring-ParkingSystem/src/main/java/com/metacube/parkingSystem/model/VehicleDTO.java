package com.metacube.parkingSystem.model;

import javax.validation.constraints.NotBlank;

/*
 *Class to validate vehicle page.
 *Set the value of vehicle page. 
 */
public class VehicleDTO {

	@NotBlank
	private String VehicleName;
	
	@NotBlank
	private String VehicleType;
	
	@NotBlank
	private String vehicleNumber;
	
	private int employeeId;
	
	@NotBlank
	private String identification;
	
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
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = (employeeId);
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
}
