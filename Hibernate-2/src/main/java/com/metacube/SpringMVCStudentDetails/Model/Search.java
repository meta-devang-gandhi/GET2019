package com.metacube.SpringMVCStudentDetails.Model;

import javax.validation.constraints.NotBlank;

/*
 * POJO class of search page.
 */
public class Search {

	@NotBlank
	String key;

	//return the key .
	public String getKey() {
		return key;
	}

	//set the key by search page.
	public void setKey(String key) {
		this.key = key;
	}
}
