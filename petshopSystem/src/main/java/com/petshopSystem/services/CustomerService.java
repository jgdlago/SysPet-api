package com.petshopSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.petshopSystem.entities.Customers;
import com.petshopSystem.repositories.CustomersRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomersRepository customerRepository;
	
	public List<Customers> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	public Customers addCustomer(@RequestBody Customers customer) {
		return customerRepository.save(customer);
	}

}
