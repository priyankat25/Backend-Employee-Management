package com.react.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.react.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}