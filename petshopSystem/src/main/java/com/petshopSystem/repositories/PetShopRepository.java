package com.petshopSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshopSystem.entities.Petshop;

@Repository
public interface PetShopRepository extends JpaRepository<Petshop, Long>{
	
	List<Petshop> findByNameContainingIgnoreCase(String name);
}
