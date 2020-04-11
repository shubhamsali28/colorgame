package com.demo.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.cruddemo.entity.Employee;
import com.demo.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	//Get all employees
	@GetMapping("/employee")
	public List<Employee> findAll()
	{
		List<Employee> emps = empService.findAll();
		
		return emps;
	}
	
    //Get only one employee
	@GetMapping("/employee/{empId}")
	public Employee findById(@PathVariable int empId)
	{
		Employee employee = empService.findById(empId);
		
		if(empId == 0)
		{
			throw new RuntimeException("Wrong id");
		}
		
		return employee;
	}
	
	//Insert employee
	@PostMapping("/employee")
	public void saveEmp(@RequestBody Employee employee)
	{
		employee.setId(0);
		
		empService.save(employee);
	}
	
	//Update employee
	@PutMapping("/employee")
	public void updateEmp(@RequestBody Employee employee)
	{
		empService.save(employee);
	}
	
	//Delete employee
	@DeleteMapping("/employee/{empId}")
	public void deleteEmp(@PathVariable int empId)
	{
     Employee employee = empService.findById(empId);
		
		if(employee == null)
		{
			throw new RuntimeException("Employee do not exist");
		}
		
		
		empService.delete(empId);
		
	}
}
