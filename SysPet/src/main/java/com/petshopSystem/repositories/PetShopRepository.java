package com.petshopSystem.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.petshopSystem.entities.Petshop;

@Repository
public interface PetShopRepository extends GenericRepository<Petshop>{

	Optional<Petshop> findByEmail(String email);
	
}
