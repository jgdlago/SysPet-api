package com.petshopSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.petshopSystem.entities.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long>{
	
	@Query("SELECT p FROM Petshop p WHERE lower(p.name) LIKE %:name%")
	List<Customers> findByNameContainingIgnoreCase(@Param("name") String name);

}
