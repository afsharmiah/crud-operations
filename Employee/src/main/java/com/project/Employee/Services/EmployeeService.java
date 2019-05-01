package com.project.Employee.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Employee.Entity.Employee;
import com.project.Employee.Repository.employeeRepository;


@Service
public class EmployeeService implements EmployeeInterface {
	
	@Autowired
	private employeeRepository repo;
	
	public List<Employee> findAll()
	{
		return (List<Employee>) repo.findAll();
	}
	
	
	public Employee createEmployee(Employee emp)
	{
		return repo.save(emp);
	}
	
	public Employee updateEmployee(Employee empUpdate) {
		return repo.save(empUpdate);
	}

	public Optional<Employee> findById(int id)
	{
		return repo.findById(id);
	}
	
	
	public void deleteEmployee(int uid) {
		
		repo.deleteById(uid);
	}

	public Optional<Employee> retrieveEmployeeByid(int id) {
		
		return repo.findById(id);
	}



	
}
