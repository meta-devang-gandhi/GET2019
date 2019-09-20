package com.metacube.SpringMVCStudentDetails.servics;

import java.util.List;

import com.metacube.SpringMVCStudentDetails.Model.Student;

/*
 * Interface of servics layer.
 */
public interface IStudentServics {

	//Method to add student in the database.
	public void addStudnet(Student student);
	
	//Method to get student list from database.
	public List<Student> getAllStudent();
	
	//Method to return the student which name equal to key.
	public List<Student> getStudentByName(String Key);
}
