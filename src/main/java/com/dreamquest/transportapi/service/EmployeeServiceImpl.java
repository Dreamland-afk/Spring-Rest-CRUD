package com.dreamquest.transportapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamquest.transportapi.dao.EmployeeDAO;
import com.dreamquest.transportapi.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO daoImpl;
	
	@Override
	public Employee findByID(int id) throws Exception {
		
		return daoImpl.findByID(id);
	}

	@Override
	@Transactional
	public Employee deleteByID(int id) throws Exception {
		
		return daoImpl.deleteByID(id);
	}

	@Override
	public List<Employee> findAll() throws Exception {
		return daoImpl.findAll();
	}

	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) throws Exception {
		
		return daoImpl.saveEmployee(employee);
	}

}
