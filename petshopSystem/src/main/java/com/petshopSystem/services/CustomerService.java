package com.petshopSystem.services;

import java.util.List;
import java.util.Optional;

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
	
	public ResponseEntity<?> getCustomerById(Long id) {
		Optional<Customers> customer = customerRepository.findById(id);
		if (customer.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum cliente encontrado com o id" + id);
		} else {
			return ResponseEntity.ok(customer);
		}
	}
	
    public ResponseEntity<Object> updateCustomer(Long id, Customers customer) {
        Optional<Customers> customerOptional = customerRepository.findById(id);

        if(customerOptional.isPresent()) {
            Customers existingCustomer = customerOptional.get();
            existingCustomer.setName(customer.getName());
            existingCustomer.setPhone(customer.getPhone());
            existingCustomer.setEmail(customer.getEmail());
            Customers updatedCustomer = customerRepository.save(existingCustomer);
            return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum cliente encontrado com o ID: " + id);
        }
    }
    
    public ResponseEntity<Object> deleteCustomer(Long id) {
        Optional<Customers> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
        	customerRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum cliente encontrado com o ID " + id);
        }
    }

}
