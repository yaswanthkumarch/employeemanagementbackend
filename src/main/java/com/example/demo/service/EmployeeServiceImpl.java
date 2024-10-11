package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repository;
	
	
	
	public Employee createEmployee(Employee employee) {
		return repository.save(employee);
	}


	public Employee getEmployeeById(Long id) {
		return repository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee not found with id: "+id));

	}


	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	public Employee updateEmployee(Long id, Employee updateEmployee) {
		Employee employee = getEmployeeById(id);
		employee.setName(updateEmployee.getName());
//		employee.setEmail(updateEmployee.getEmail());
//		employee.setFirstName(updateEmployee.getFirstName());
//		employee.setLastName(updateEmployee.getLastName());
//		employee.setPassword(updateEmployee.getPassword());
		return repository.save(employee);
	}


	
	public void deleteEmployee(Long id) {
		Employee employee = getEmployeeById(id);
		repository.deleteById(id);
	}



//	public String login(String email,String password) {
//		  Employee db = repository.fetchByEmail(email);
//		  if(db!=null) {
//			  if(db.getPassword().equals(password)) {
//				  return "Login Done..";
//			  }
//		  }
//		  return "Invalid Credentials";
//	}

}
