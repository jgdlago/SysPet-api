package com.petshopSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshopSystem.entities.Services;

public interface ServiceRepository extends JpaRepository<Services, Long>{

}
