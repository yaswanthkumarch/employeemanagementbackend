package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//	@Query("select a from Employee a where a.email=?1")
//	Employee fetchByEmail(String email);
}
