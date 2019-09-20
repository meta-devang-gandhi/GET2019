package com.metacube.SpringMVCStudentDetails.servics.Implement;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.SpringMVCStudentDetails.Model.Student;
import com.metacube.SpringMVCStudentDetails.repository.StudentRepository;
import com.metacube.SpringMVCStudentDetails.servics.IStudentServics;

/*
 * Class to implement servics layer method.
 */
@Service
public class StudentServics implements IStudentServics {

	@Autowired
	private StudentRepository repository;
	
	//Method to add student in the database.
	@Override
	@Transactional
	public void addStudnet(Student student) {
		repository.save(student);
	}
	
	//Method to get student list from database.
	@Override
	@Transactional
	public List<Student> getAllStudent() {
		return (List<Student>) repository.findAll();
	}

	//Method to return the student which name equal to key.
	@Override
	@Transactional
	public List<Student> getStudentByName(String Key) {
		return repository.findByfirstNameContainingIgnoreCase(Key);
	}

}
