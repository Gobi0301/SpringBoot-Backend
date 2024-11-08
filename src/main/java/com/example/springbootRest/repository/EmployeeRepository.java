package com.example.springbootRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootRest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
