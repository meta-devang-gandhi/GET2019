package com.metacube.SpringMVCStudentDetails.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.SpringMVCStudentDetails.Model.Student;
import com.metacube.SpringMVCStudentDetails.servics.IStudentServics;


/**
 * Controller class.
 */
@Controller
public class StudentController {

	@Autowired
	IStudentServics studentServics;
	@Value("${welcome.message}")
	private String message;

	/**
	 * Method to mapped home page.
	 * @param model
	 * @return
	 */
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", message);
		return "home";
	}

	/**
	 * Method to map studentDetailsForm page. 
	 * @param model
	 * @return
	 */
	@GetMapping("/AddStudentDetails")
	public String studentDetail(Model model) {
		model.addAttribute(new Student());
		return "StudentDetailForm";
	}

	/**
	 * Method to get data from studentDetailsForm page. show the data on console. 
	 * @param student
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/AddStudentDetails")
	public String addStudentDetail(@Validated Student student,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "StudentDetailForm";
		} else {
			System.out.println(student);
				studentServics.addStudnet(student);
			return "redirect:/home";
		}
	}

	/**
	 * Method to mapped showStduent page and show the student list. 
	 * @param model
	 * @return
	 */
	@GetMapping("/showStudent")
	public String showStudent(Model model) {
		List<Student> allStudent = studentServics.getAllStudent();
		model.addAttribute("students",allStudent);
		return "showStudent";
	}
}
