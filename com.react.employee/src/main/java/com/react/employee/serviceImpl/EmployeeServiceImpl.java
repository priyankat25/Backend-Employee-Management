package com.react.employee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.react.employee.entity.Employee;
import com.react.employee.repository.EmployeeRepository;
import com.react.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public void addEmployee(Employee e) {
		repo.save(e);
	}

	@Override
	public void updateEmployee(Employee e) {
		repo.save(e);
	}

	@Override
	public Employee getEmployee(Long id) {
        return repo.findById(id).get();
    }

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

}