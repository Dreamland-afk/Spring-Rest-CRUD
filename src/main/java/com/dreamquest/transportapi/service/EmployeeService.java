package com.dreamquest.transportapi.service;

import java.util.List;

import com.dreamquest.transportapi.entity.Employee;

public interface EmployeeService {

	public Employee findByID(int id) throws Exception;
	public List<Employee> findAll() throws Exception;
	public Employee saveEmployee(Employee employee) throws Exception;
	public Employee deleteByID(int id) throws Exception;


}
