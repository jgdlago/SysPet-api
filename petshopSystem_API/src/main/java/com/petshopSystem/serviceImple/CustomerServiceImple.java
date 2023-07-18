package com.petshopSystem.serviceImple;

import org.springframework.stereotype.Service;

import com.petshopSystem.entities.Customer;
import com.petshopSystem.repositories.CustomerRepository;
import com.petshopSystem.repositories.GenericRepository;
import com.petshopSystem.services.CustomerService;

@Service
public class CustomerServiceImple implements CustomerService {

	private final CustomerRepository  customerRepository;
	public CustomerServiceImple(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	@Override
	public GenericRepository<Customer> getRepository() {
		return customerRepository;
	}

}
