package com.petshopSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshopSystem.entities.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long>{

}
