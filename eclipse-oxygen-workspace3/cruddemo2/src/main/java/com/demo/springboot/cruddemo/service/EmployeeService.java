package com.demo.springboot.cruddemo.service;

import java.util.List;

import com.demo.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void delete(int id);

}
