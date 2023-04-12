package com.petshopSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshopSystem.entities.Petshop;

public interface PetShopRepository extends JpaRepository<Petshop, Long>{

}
