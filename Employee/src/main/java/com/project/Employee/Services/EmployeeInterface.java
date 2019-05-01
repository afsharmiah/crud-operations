package com.project.Employee.Services;

import java.util.List;
import java.util.Optional;

import com.project.Employee.Entity.Employee;

public interface EmployeeInterface {
	List<Employee> findAll();
	Employee createEmployee(Employee emp);
	Employee updateEmployee(Employee empUpdate);
	void deleteEmployee(int uid);
	Optional<Employee>  retrieveEmployeeByid(int empRetrieveByid);
	Optional<Employee> findById(int id);
	
	
	 
	
	

}
