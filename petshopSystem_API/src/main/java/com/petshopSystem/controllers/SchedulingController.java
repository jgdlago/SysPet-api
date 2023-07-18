package com.petshopSystem.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopSystem.entities.Scheduling;
import com.petshopSystem.services.GenericService;
import com.petshopSystem.services.SchedulingService;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/Scheduling")
public class SchedulingController extends GenericController<Scheduling> {

	private final SchedulingService schedulingService;
	public SchedulingController(SchedulingService schedulingService) {
		super();
		this.schedulingService = schedulingService;
	}
	
	@Override
	GenericService<Scheduling> getService() {
		return schedulingService;
	}
}
