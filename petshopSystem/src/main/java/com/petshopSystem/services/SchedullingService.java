package com.petshopSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopSystem.repositories.SchedullingRepository;
import com.petshopSystem.entities.Scheduling;

@Service
public class SchedullingService {
    
	@Autowired
	private SchedullingRepository schedullingRepository;
	
	public List<Scheduling> getAllServices() {
		return schedullingRepository.findAll();
	}
	
	public Scheduling addScheduling(Scheduling scheduling) {
		return schedullingRepository.save(scheduling);
	}
}
