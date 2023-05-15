package com.petshopSystem.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.petshopSystem.entities.Scheduling;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long>{
	
	@Query("SELECT p FROM Scheduling p WHERE p.date = :date")
	List<Scheduling> findByDate(@Param("date") LocalDate date);

}
