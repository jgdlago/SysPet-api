package com.petshopSystem.petshopSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petshopSystem.petshopSystem.model.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{

}
