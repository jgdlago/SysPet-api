package com.petshopSystem.serviceImple;

import org.springframework.stereotype.Service;

import com.petshopSystem.entities.Scheduling;
import com.petshopSystem.repositories.GenericRepository;
import com.petshopSystem.repositories.SchedulingRepository;
import com.petshopSystem.services.SchedulingService;

@Service
public class SchedulingTypeServiceImple implements SchedulingService {

	private final SchedulingRepository schedulingRepository;
	public SchedulingTypeServiceImple(SchedulingRepository schedulingRepository) {
		super();
		this.schedulingRepository = schedulingRepository;
	}
	
	@Override
	public GenericRepository<Scheduling> getRepository() {
		return schedulingRepository;
	}

}
