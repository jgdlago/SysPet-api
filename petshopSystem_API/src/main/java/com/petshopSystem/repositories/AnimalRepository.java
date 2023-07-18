package com.petshopSystem.repositories;

import org.springframework.stereotype.Repository;

import com.petshopSystem.entities.Animal;

@Repository
public interface AnimalRepository extends GenericRepository<Animal> {
	
}
