package org.spring.boot.mapping.controller;

import org.spring.boot.mapping.model.Employee;
import org.spring.boot.mapping.service.EmpService;
import org.spring.boot.mapping.validation.UserIdNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

//controller layer
@CrossOrigin("http://localhost:8080")
@Controller
public class EmpController {

	@Autowired 
	private EmpService empService;

	//to add employee
	@GetMapping("/index")
	public String homePage(Model model) {
		model.addAttribute("employee", new Employee());
		return "index";
	}
	//processing the user inputs by validation
	@PostMapping("/process")
	public String addEmployee(@Valid Employee employee,BindingResult result){
		if(result.hasErrors()) {
			return "index";
		}
		this.empService.addEmployee(employee);
		return "result";
	}
	//display all employees
	@GetMapping("/display")
	public String displayAllEmployee(Model model) {
		model.addAttribute("employees",this.empService.displayAll());
		return "display";
	}
	//to enter the employee id by user
	@GetMapping("/employee")
	public String employeeSearch(Model model) {
		model.addAttribute("id", "");
		return "displayId";
	}
	//to check whether the employee id found or else it will throw custom exception
	@GetMapping("/submit")
	public String displayById(@RequestParam("id") String id,Model model) throws UserIdNotfoundException{
		Employee emp = this.empService.getEmployeeById(id);
		model.addAttribute("employee", this.empService.getEmployeeById(id));
		return "employeedetail";
	}
	
}
