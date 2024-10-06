package com.react.employee.service;

import java.util.List;

import com.react.employee.entity.Employee;

public interface EmployeeService {
	
	void addEmployee(Employee e);
	
	void updateEmployee(Employee e);
	
	Employee getEmployee(Long id); // or String searchEmployee(String name);
	
	List<Employee> getAllEmployee(); // Adjusted to return a list of employees
	
}