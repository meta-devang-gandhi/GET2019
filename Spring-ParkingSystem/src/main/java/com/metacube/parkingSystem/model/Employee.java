package com.metacube.parkingSystem.model;

/*
 * Entity class employee.
 */
public class Employee {

	private int empId;
	private String fullName;
	private String gender;
	private String email;
	private String password;
	private long contactNumber;
	private short organizationId;

	public Employee()
	{
		super();
	}
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = Long.parseLong(contactNumber);
	}

	public short getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(short organizationId) {
		this.organizationId = organizationId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

}
