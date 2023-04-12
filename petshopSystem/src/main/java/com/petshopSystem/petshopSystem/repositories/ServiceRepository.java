package com.petshopSystem.petshopSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petshopSystem.petshopSystem.model.entities.Services;

public interface ServiceRepository extends JpaRepository<Services, Long>{

}
