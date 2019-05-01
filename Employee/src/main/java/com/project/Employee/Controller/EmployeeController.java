package com.project.Employee.Controller;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.Employee.Entity.Employee;
import com.project.Employee.Exceptions.UserNotFoundException;
import com.project.Employee.Services.EmployeeService;



@RestController
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService service;
	
	//private static List<Employee> employees=new ArrayList<>();
	
	// Get /Employees
		//retrieveAllEmployees
		
		@GetMapping("/employees")
		public List<Employee> retrieveAllEmployee(){
			return (List<Employee>) service.findAll();
		}
		
		
		// create a employee or insert a employee
		@PostMapping(value= "/employees", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Employee createEmployee(@Valid @RequestBody Employee employee) {
			return service.createEmployee(employee);
			
		}
		
		
		// update an existing User
		
		@PutMapping("/employees/{id}")
		public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
			Optional<Employee> userOptional = service.findById(id);
			if (!userOptional.isPresent())
				return ResponseEntity.notFound().build();

			//user.setId(id);
			service.updateEmployee(employee);
			
			return ResponseEntity.noContent().build();	
		}
		
		
		// Delete a User
		@DeleteMapping(value= "/employees/{id}")
		public void deleteEmployee(@PathVariable ("id") int uid)  {
			service.deleteEmployee(uid);
		
		}
		
		
		// Get method for retrieve Employees and error handling method. 
		// retrieveUser(int id)
		@GetMapping("/employees/{id}")
		public Optional<Employee> retrieveEmployeeByid(@PathVariable int id) {
			Optional<Employee> employee= service.retrieveEmployeeByid(id);
			
			if(employee==null)
				throw new UserNotFoundException("id-"+id);
			return employee;
		}
		
		
		
		// internationalization
		@GetMapping(path="/hello-world-internationalization")
		public String helloWorldInternationalized() {
			return "Good Morning";
			
		}
		
		
		

		
	}

