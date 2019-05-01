package com.project.Employee.Repository;

import org.springframework.data.repository.CrudRepository;

import com.project.Employee.Entity.Employee;


public interface employeeRepository extends CrudRepository<Employee, Integer>{
	

	}