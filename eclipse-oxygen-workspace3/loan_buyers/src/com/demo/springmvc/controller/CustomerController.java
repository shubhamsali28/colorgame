package com.demo.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.springmvc.dao.CustomerDAO;
import com.demo.springmvc.entity.Customer;
import com.demo.springmvc.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String list(Model model)
	{
		//Customers
		List<Customer> theCustomers = customerService.getCustomers();
		
		//Adding to the model
		model.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormToAdd")
	public String showFormToAdd(Model model)
	{
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	//it is post mapping since in the customer-form.jsp it is mentioned in details
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		//for saving the customer
		customerService.saveCustomer(theCustomer);
		
		//redirecting to customer list page after saving
		return "redirect:/customer/list";
	}
	
	//
	@GetMapping("/showFormToUpdate")
	public String showFormToUpdate(@RequestParam("customerId") int theId, Model model)
	{
		//Get customer from service
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre populate the values
		model.addAttribute("customer", theCustomer);
		
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId)
	{
		//For deleting a customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("theSearchName") String theSearchName, Model model)
	{
		List<Customer> theCustomer = customerService.searchCustomer(theSearchName);
		
		model.addAttribute("customer", theCustomer);
		
		return "list-customers";
		
	}
}
