package com.metacube.parkingSystem.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Employee class which validate the register page. Set the values of register form.
 */
public class EmployeeDTO {

	@NotBlank(message = "Please enter name")
	String fullName;

	@NotBlank
	String gender;

	@NotBlank
	@Email(message = "Please enter email")
	String email;

	@NotBlank(message = "Please enter password")
	@Size(min = 2, max = 30)
	String password;

	@NotBlank(message = "Please enter password")
	@Size(min = 2, max = 30)
	String confirmPassword;

	@Column(precision = 10)
	long contactNumber;

	String organization;

	public EmployeeDTO() {
		super();
	}

	public String getFullName() {
		return fullName;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public String getOrganization() {
		return organization;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = (contactNumber);
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

}
