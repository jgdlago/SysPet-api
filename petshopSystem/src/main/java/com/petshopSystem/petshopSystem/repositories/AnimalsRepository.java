package com.petshopSystem.petshopSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petshopSystem.petshopSystem.model.entities.Animals;

public interface AnimalsRepository extends JpaRepository<Animals, Long>{

}
