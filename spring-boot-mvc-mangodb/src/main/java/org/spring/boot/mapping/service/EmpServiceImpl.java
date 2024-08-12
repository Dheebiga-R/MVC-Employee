package org.spring.boot.mapping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.spring.boot.mapping.model.Employee;
import org.spring.boot.mapping.repository.EmpRepository;
import org.spring.boot.mapping.validation.UserIdNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//implementation of those abstract methods
@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	public EmpRepository empRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return this.empRepository.save(employee);
	}

	@Override
	public List<Employee> displayAll() {
		return this.empRepository.findAll();
	}

	@Override
	public Employee displayById(String id) {
		return this.empRepository.findById(id).get();
	}

	@Override
	public void deleteById(String id) {
		this.empRepository.deleteById(id);
	}

	@Override
	public Employee getEmployeeById(String id) throws UserIdNotfoundException {
		return this.empRepository.findById(id).orElseThrow(()->new UserIdNotfoundException("Employee id not present!"));
	}
	
	

}
