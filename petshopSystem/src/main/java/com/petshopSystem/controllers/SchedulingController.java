package com.petshopSystem.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopSystem.services.SchedulingService;
import com.petshopSystem.entities.Scheduling;

@RestController
@RequestMapping("/schedulling")
public class SchedulingController {

	@Autowired
	private SchedulingService schedullingService;
	
    @GetMapping
    public List<Scheduling> getAllServices() {
        return schedullingService.getAllServices();
    }
    
    @PostMapping
    public Scheduling addScheduling(@RequestBody Scheduling scheduling) {
    	return schedullingService.addScheduling(scheduling);
    }
    
    @GetMapping("/date/{date}")
    public ResponseEntity<?> getSchedulingByDate(@PathVariable LocalDate date) {
    	return schedullingService.getSchedulingByDate(date);
    }
    
}
