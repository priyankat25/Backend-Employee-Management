package com.react.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.react.employee.entity.Employee;
import com.react.employee.service.EmployeeService;

@CrossOrigin("*")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee e) {
		service.addEmployee(e);
		return "Employee added successfully!";
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee e) {
		service.updateEmployee(e);
		return "Employee updated successfully!";
	}
	
	@GetMapping("/getEmployee")
	 public Employee getEmployee(@RequestParam Long id) {
        return service.getEmployee(id);
    }
	
	// This returns a list of employees
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployee(); 
	}	
}