package com.dreamquest.transportapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamquest.transportapi.entity.Employee;
import com.dreamquest.transportapi.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/dreamquest")
public class EmployeeController {

	@Autowired
	EmployeeService daoImpl;

	Employee employee;

	@GetMapping("/employees/{id}")
	public Employee getByID(@PathVariable int id) throws Exception {

		employee = daoImpl.findByID(id);
		return employee;
	}

	@GetMapping("/employees")
	public List<Employee> getAll(@RequestBody(required = false) Object object) throws Exception {

		if(object != null)
			throw new RuntimeException("no body");
		return daoImpl.findAll();
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) throws Exception {
		employee.setId(0);
		System.out.println(employee.toString());
		employee = daoImpl.saveEmployee(employee);
		
		return employee;
	}

	@PutMapping(value = "/employees", consumes = "application/json", produces = "application/json")
	public Employee updateEmployee(@RequestBody Employee employee) throws Exception {
		if (employee.getId() == 0)
			throw new RuntimeException("To update the employee please provide the id in the request body");
		employee = daoImpl.saveEmployee(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public Employee deleteUser(@PathVariable int id) throws Exception {

		employee = daoImpl.deleteByID(id);
		return employee;
	}

	@ExceptionHandler
	public ResponseEntity<String> handleException(Exception exception, HttpServletRequest requests) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
