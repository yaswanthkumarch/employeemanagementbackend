package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin({"https://localhost:3000,http://localhost:3000","https://employemanagementfrontend-d9eggcfpepcjhzhr.southindia-01.azurewebsites.net","http://192.168.100.210:3000"})
public class EmployeeController {
	@GetMapping("/message")
	public String message() {
		System.out.println("Message endpoint accessed");
		return "Hello from the message endpoint!";
	}

	// Endpoint for name
	@GetMapping("/name")
	public String name() {
		System.out.println("Name endpoint accessed");
		return "Hello, this is Azure Portal!";
	}
	@Autowired
	private EmployeeServiceImpl serviceImpl;
	
	@PostMapping
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		Employee save = serviceImpl.createEmployee(employee);
		return new ResponseEntity<>(save, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Employee> getAll(){
		return serviceImpl.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = serviceImpl.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee updateEmployee){
		Employee updated = serviceImpl.updateEmployee(id, updateEmployee);
		return 	ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
		serviceImpl.deleteEmployee(id);
		return ResponseEntity.ok("Employee id deleted successfully");
//		return ResponseEntity.noContent().build();
	}
	
//	@GetMapping("login")
//	public String login(@RequestParam String email, @RequestParam String password) {
//		return serviceImpl.login(email, password);
//	}
}
