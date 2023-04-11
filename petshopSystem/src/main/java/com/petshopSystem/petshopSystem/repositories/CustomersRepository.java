package com.petshopSystem.petshopSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petshopSystem.petshopSystem.model.entities.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long>{

}
