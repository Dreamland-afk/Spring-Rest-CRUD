package com.dreamquest.transportapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreamquest.transportapi.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	EntityManager entityManager;

	@Override
	public Employee findByID(int id) throws Exception {
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.id = :id",
				Employee.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public List<Employee> findAll() throws Exception {
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e",
				Employee.class);
		
		return query.getResultList();
	}

	@Override
	public Employee saveEmployee(Employee employe) throws Exception {
		 
		Employee employee = entityManager.merge(employe);
		System.out.println(employee.toString());
		
		return employee;
	}

	@Override
	public Employee deleteByID(int id) throws Exception {
		
		Employee employee = entityManager.find(Employee.class, id);
		
		if (employee == null) {
			throw new RuntimeException("Employee with the given id: "+id+" not found");
		}
		
		entityManager.remove(employee);
		
		return employee;
	}
	
	

}
