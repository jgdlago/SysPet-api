package com.petshopSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.petshopSystem.entities.Petshop;

@Repository
public interface PetShopRepository extends JpaRepository<Petshop, Long>{
	
	@Query("SELECT p FROM Petshop p WHERE lower(p.name) LIKE %:name%")
	List<Petshop> findByNameContainingIgnoreCase(@Param("name") String name);

}
