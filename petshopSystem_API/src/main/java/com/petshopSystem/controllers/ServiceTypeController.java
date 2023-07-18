package com.petshopSystem.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopSystem.entities.ServiceType;
import com.petshopSystem.services.GenericService;
import com.petshopSystem.services.ServiceTypeService;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/Service")
public class ServiceTypeController extends GenericController<ServiceType> {

	private final ServiceTypeService serviceTypeService;
	public ServiceTypeController(ServiceTypeService serviceTypeService) {
		super();
		this.serviceTypeService = serviceTypeService;
	}
	
	@Override
	GenericService<ServiceType> getService() {
		return serviceTypeService;
	}
}
