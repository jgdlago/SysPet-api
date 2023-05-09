package com.petshopSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopSystem.entities.ServicesType;
import com.petshopSystem.services.ServiceTypeService;

@RestController
@RequestMapping("/servicesType")
public class ServiceTypeController {

	@Autowired
	private ServiceTypeService serviceTypeService;
	
	@GetMapping
    public List<ServicesType> getAllServicesType() {
        return serviceTypeService.getAllServicesType();
    }
	
	@PostMapping
    public ServicesType addServicesType(@RequestBody ServicesType servicesType) {
        return serviceTypeService.addServicesType(servicesType);
    }
	
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getServiceTypeById(@PathVariable Long id) {
    	return serviceTypeService.getServiceTypeById(id);
    }
	
    @PutMapping("/id/{id}")
    public ResponseEntity<Object> updateServiceType(@PathVariable Long id, @RequestBody ServicesType servicesType) {
        return serviceTypeService.updateServiceType(id, servicesType);
    }
}
