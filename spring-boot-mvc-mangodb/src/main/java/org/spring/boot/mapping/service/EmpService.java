package org.spring.boot.mapping.service;

import java.util.List;
import java.util.Optional;

import org.spring.boot.mapping.model.Employee;
import org.spring.boot.mapping.validation.UserIdNotfoundException;

public interface EmpService {
    //method to add employee
	public Employee addEmployee(Employee employee);
	//method to get employee by id and if not found throws custom exception
	public Employee getEmployeeById(String id) throws UserIdNotfoundException;
	//method to get all employees
	public List<Employee> displayAll();
	//method similar to get employee by id
	public Employee displayById(String id);
	//method to delete employee by id
	public void deleteById(String id);
}
