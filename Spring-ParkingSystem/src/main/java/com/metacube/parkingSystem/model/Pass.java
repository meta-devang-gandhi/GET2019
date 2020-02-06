package com.metacube.parkingSystem.model;

import javax.validation.constraints.NotBlank;

/**
 * Class to set pass rate of employee.
 */
public class Pass {

	private int empID;
	@NotBlank
	private String rate;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

}
