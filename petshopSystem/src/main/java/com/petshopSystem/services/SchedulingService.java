package com.petshopSystem.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.petshopSystem.repositories.SchedulingRepository;
import com.petshopSystem.entities.Scheduling;

@Service
public class SchedulingService {
    
	@Autowired
	private SchedulingRepository schedulingRepository;
	
	public List<Scheduling> getAllServices() {
		return schedulingRepository.findAll();
	}
	
	public Scheduling addScheduling(Scheduling scheduling) {
	    LocalDate currentDate = LocalDate.now();

	    if (scheduling.getDate().isAfter(currentDate)) {
	        return schedulingRepository.save(scheduling);
	    } else {
	    	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data inválida para agendamento");
	    }
	}
	
	public ResponseEntity<?> getSchedulingByDate(LocalDate date) {
		List<Scheduling> schedulingList = schedulingRepository.findByDate(date);
		if (schedulingList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum agendamento encontrado");
		} else {
			return ResponseEntity.ok(schedulingList);
		}
	}
}
