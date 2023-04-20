package com.petshopSystem.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.petshopSystem.repositories.SchedulingRepository;
import com.petshopSystem.entities.Scheduling;

@Service
public class SchedulingService {
    
	@Autowired
	private SchedulingRepository schedulingRepository;
	
	public List<Scheduling> getAllScheduling() {
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
	
	public ResponseEntity<Object> getSchedulingByid(@PathVariable Long id) {
		Optional<Scheduling> schedulingList = schedulingRepository.findById(id);
		
        if(schedulingList.isPresent()) {
        	return ResponseEntity.status(HttpStatus.OK).body(schedulingList);
        } else {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum agendamento encontrado com ID: " + id);
        }
	}
	
    public ResponseEntity<Object> updateScheduling(Long id, Scheduling scheduling) {
        Optional<Scheduling> schedulingList = schedulingRepository.findById(id);

        if(schedulingList.isPresent()) {
            Scheduling existingScheduling = schedulingList.get();
            existingScheduling.setAnimal(scheduling.getAnimal());
            existingScheduling.setCustomer(scheduling.getCustomer());
            existingScheduling.setDate(scheduling.getDate());
            Scheduling updatedScheduling = schedulingRepository.save(existingScheduling);
            return ResponseEntity.status(HttpStatus.OK).body(updatedScheduling);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum petshop encontrado com o ID: " + id);
        }
    }
	
}
