package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);
	
	List<Employee> getAllEmployees();
	
	Employee updateEmployee(Long id, Employee updateEmployee);
	
	void deleteEmployee(Long id);

//	String login(String email, String password);
}
