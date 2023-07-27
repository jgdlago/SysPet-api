package com.petshopSystem.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopSystem.entities.Customer;
import com.petshopSystem.services.CustomerService;
import com.petshopSystem.services.GenericService;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/Customer")
public class CustomerController extends GenericController<Customer> {

	private final CustomerService customerService;
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@Override
	GenericService<Customer> getService() {
		return customerService;
	}
}
