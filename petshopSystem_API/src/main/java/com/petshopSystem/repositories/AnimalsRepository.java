package com.petshopSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.petshopSystem.entities.Animals;

public interface AnimalsRepository extends JpaRepository<Animals, Long>{

	@Query("SELECT p FROM Animals p WHERE lower(p.name) LIKE %:name%")
	List<Animals> findByNameContainingIgnoreCase(@Param("name") String name);
	
}
