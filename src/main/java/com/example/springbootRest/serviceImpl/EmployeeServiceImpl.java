package com.example.springbootRest.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springbootRest.exception.ResourceNotFoundException;
import com.example.springbootRest.model.Employee;
import com.example.springbootRest.repository.EmployeeRepository;
import com.example.springbootRest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeebyId(long id) {
		// TODO Auto-generated method stub
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee","Id",id);
//		}
		
		return employeeRepository.findById(id).orElseThrow(()-> 
		          new ResourceNotFoundException("Employee","Id",id));
		
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		// we need to check whether employee with given id is exists in DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->   
		            new ResourceNotFoundException("Employee","Id",id) );
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		// save existing employee to DB
		employeeRepository.save(existingEmployee);
		
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		//check whether a employee exist in a DB or not.
		employeeRepository.findById(id).orElseThrow(()
				       -> new ResourceNotFoundException("Employee","Id",id));
		
		employeeRepository.deleteById(id);
	}

}
