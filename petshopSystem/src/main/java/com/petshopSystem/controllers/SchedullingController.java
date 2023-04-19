package com.petshopSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopSystem.services.SchedullingService;
import com.petshopSystem.entities.Scheduling;

@RestController
@RequestMapping("/schedulling")
public class SchedullingController {

	@Autowired
	private SchedullingService schedullingService;
	
    @GetMapping
    public List<Scheduling> getAllServices() {
        return schedullingService.getAllServices();
    }
    
    @PostMapping
    public Scheduling addScheduling(@RequestBody Scheduling scheduling) {
    	return schedullingService.addScheduling(scheduling);
    }
    
}
