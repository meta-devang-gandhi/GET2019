package com.metacube.parkingSystem.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *Login class.
 */
public class Login {

	@Email
	String email;
	
	public Login() {
		super();
	}

	@NotBlank
	@Size(min = 2, max = 30)
	String password;

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
}
