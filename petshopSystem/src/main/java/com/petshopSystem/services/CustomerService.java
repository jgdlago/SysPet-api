package com.petshopSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<?> getCustomerByName(String name) {
		List<Customers> customer = customerRepository.findByNameContainingIgnoreCase(name);
        if (customer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum cliente encontrado");
        } else {
            return ResponseEntity.ok(customer);
        }
	}

}
