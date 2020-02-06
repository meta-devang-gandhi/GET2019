package com.metacube.parkingSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.EmployeeDTO;
import com.metacube.parkingSystem.model.EmployeeDetails;
import com.metacube.parkingSystem.model.Login;
import com.metacube.parkingSystem.model.Pass;
import com.metacube.parkingSystem.model.PassType;
import com.metacube.parkingSystem.model.Vehicle;
import com.metacube.parkingSystem.model.VehicleDTO;
import com.metacube.parkingSystem.service.IEmployeeSevice;
import com.metacube.parkingSystem.utils.DTOUtil;

/*
 * Controller class.
 */
@Controller
public class ParkingController {

	@Autowired
	private IEmployeeSevice employeeService;

	/**
	 * Method for register page.
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String registration(Model model) {
		model.addAttribute(new EmployeeDTO());
		return "employeeRegistration";
	}

	/**
	 * Method for store register page data on to database. 
	 * @param emp
	 * @param result
	 * @param attribute
	 * @return
	 */
	@PostMapping("/")
	public String doRegister(@Validated EmployeeDTO emp, BindingResult result,
			RedirectAttributes attribute) {
		if (result.hasErrors()) {
			return "employeeRegistration";
		} else {
			try {
				if (emp.getPassword().equals(emp.getConfirmPassword()) == false) {
					ObjectError error = new ObjectError("Password",
							"Passwords Don't Match!");
					result.addError(error);
					return "employeeRegistration";
				} else {
					short organizationId = employeeService
							.getOrganizationId(emp.getOrganization());
					employeeService.addEmployee(
							DTOUtil.map(emp, Employee.class), organizationId);
					attribute.addFlashAttribute("empId",
							employeeService.getEmpolyeeId());
					return "redirect:/VehicleForm";
				}
			} catch (DuplicateKeyException e) {
				ObjectError error = new ObjectError("Exception",
						"Email must be unique");
				result.addError(error);
				return "employeeRegistration";
			}
		}
	}

	/**
	 * Method for login page.
	 * @param model
	 * @return
	 */
	@GetMapping("/LoginPage")
	public String login(Model model) {
		model.addAttribute(new Login());
		return "LoginPage";
	}

	/**
	 * Method for authentic user.
	 * @param login
	 * @param result
	 * @param attribute
	 * @param request
	 * @return
	 */
	@PostMapping("/LoginPage")
	public String doLogin(@Validated Login login, BindingResult result,
			RedirectAttributes attribute, HttpServletRequest request) {
		String password;
		if (result.hasErrors()) {
			return "LoginPage";
		} else {
			password = employeeService.auth(login.getEmail());
			if (password == null) {
				ObjectError error = new ObjectError("Auth",
						"Email does't exist.");
				result.addError(error);
				return "LoginPage";
			} else if (login.getPassword().equals(password) == false) {
				ObjectError error = new ObjectError("Auth",
						"Password is wrong.");
				result.addError(error);
				return "LoginPage";
			} else {
				if (login.getEmail() != null) {
					HttpSession session = request.getSession();
					session.setAttribute("email", login.getEmail());
				}

				attribute.addAttribute("Email", login.getEmail());
				return "redirect:/home";
			}
		}
	}

	/**
	 * Method to open vehicle form.
	 * @param model
	 * @return
	 */
	@GetMapping("/VehicleForm")
	public String vehicle(Model model) {
		model.addAttribute(new VehicleDTO());
		return "VehicleForm";
	}

	/**
	 * Method to store vehicle form data onto database.
	 * @param vehicle
	 * @param result
	 * @param attribute
	 * @return
	 */
	@PostMapping("/VehicleForm")
	public String addVehicle(@Validated VehicleDTO vehicle,
			BindingResult result, RedirectAttributes attribute) {

		if (result.hasErrors()) {
			return "VehicleForm";
		} else {
			employeeService.addVehicle(DTOUtil.map(vehicle, Vehicle.class));
			attribute.addAttribute("vehicleType", vehicle.getVehicleType());
			return "redirect:/PassDetails";
		}
	}

	/**
	 * Method to retrieve price of type of pass from database
	 * redirect the pass Details page.
	 * @param vehicleType
	 * @param model
	 * @return
	 */
	@GetMapping("/PassDetails")
	public String passDetails(@RequestParam("vehicleType") String vehicleType,
			Model model) {
		Map<Float, String> prices = new HashMap<Float, String>();
		model.addAttribute(new Pass());
		PassType passType = employeeService.getPrice(vehicleType);
		prices.put(passType.getDaily(), "Daily");
		prices.put(passType.getMonthly(), "Monthly");
		prices.put(passType.getYearly(), "Yearly");

		model.addAttribute("priceList", prices);
		return "PassDetails";
	}

	/**
	 * Method to store pass type which select by employee.
	 * redirect home page.
	 * @param pass
	 * @param result
	 * @param attribute
	 * @return
	 */
	@PostMapping("/PassDetails")
	public String getPass(@Validated Pass pass, BindingResult result,
			RedirectAttributes attribute) {
		if (result.hasErrors()) {
			return "PassDetails";
		} else {
			int empId = employeeService.getEmpolyeeId();
			employeeService.addVehiclePass(pass, empId);
			return "redirect:/home";
		}
	}

	/**
	 * Method to retrieve all details of employee and show on to home page.
	 * @param emailId
	 * @param model
	 * @return
	 */
	@GetMapping("/home")
	public String home(@RequestParam("Email") String emailId, Model model) {
		EmployeeDetails empDetails = employeeService
				.getEmployeeDetails(emailId);
		System.out.println(empDetails.getName());
		System.out.println(empDetails.getEmail());
		model.addAttribute("empDetails", empDetails);
		return "home";
	}

	/**
	 * Method to open edit page.
	 * @param Email
	 * @param model
	 * @return
	 */
	@GetMapping("/EditPage")
	public String edit(@RequestParam(value = "Email") String Email, Model model) {
		EmployeeDetails empDetails = employeeService.getEmployeeDetails(Email);
		model.addAttribute("employeeDetails", empDetails);
		return "EditPage";
	}

	/**
	 * Method to update employee details on database.
	 * @param empDetails
	 * @param result
	 * @param attribute
	 * @return
	 */
	@PostMapping("/EditPage")
	public String update(@Validated EmployeeDetails empDetails,
			BindingResult result, RedirectAttributes attribute) {

		if (result.hasErrors()) {
			return "EditPage";
		} else {
			short OrganizationId = employeeService.getOrganizationId(empDetails
					.getOrganization());
			employeeService.updateEmployeeDetails(empDetails, OrganizationId);

			attribute.addAttribute("Email", empDetails.getEmail());
			return "redirect:/home";
		}

	}

	/**
	 * Method to open employee friend page.
	 * @param Email
	 * @param model
	 * @return
	 */
	@GetMapping("/FriendPage")
	public String friendList(@RequestParam(value = "Email") String Email,
			Model model) {

		short OrganizationId = employeeService.getOrganizationIdByEmail(Email);
		List<Employee> friends = employeeService.getFriendList(OrganizationId,
				Email);
		System.out.println("friend=" + friends + "\norg" + OrganizationId
				+ "email" + Email);
		model.addAttribute("friendsList", friends);
		return "FriendPage";

	}

	/**
	 * method to open friend profile page.
	 * @param email
	 * @param model
	 * @return
	 */
	@GetMapping("/FriendProfile")
	public String friendProfile(@RequestParam(value = "email") String email,
			Model model) {
		EmployeeDetails friendDetails = employeeService
				.getEmployeeDetails(email);
		model.addAttribute("friendDetails", friendDetails);
		return "FriendProfile";
	}

	/**
	 * Method to do log out.
	 * @param request
	 * @return
	 */
	@GetMapping("/LogOutPage")
	public String logOut(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		return "redirect:/LoginPage";
	}
}
