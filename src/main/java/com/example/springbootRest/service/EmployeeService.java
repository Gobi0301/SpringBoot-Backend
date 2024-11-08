package com.example.springbootRest.service;

import java.util.List;

import com.example.springbootRest.model.Employee;

public interface EmployeeService {

	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeebyId(long id);
	Employee updateEmployee(Employee employee,long id);
	void deleteEmployee(long id);
}
