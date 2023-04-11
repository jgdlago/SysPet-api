package com.petshopSystem.petshopSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petshopSystem.petshopSystem.model.entities.Petshop;

public interface PetShopRepository extends JpaRepository<Petshop, Long>{

}
