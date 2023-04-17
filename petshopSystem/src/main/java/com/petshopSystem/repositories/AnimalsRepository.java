package com.petshopSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshopSystem.entities.Animals;

public interface AnimalsRepository extends JpaRepository<Animals, Long>{

}
