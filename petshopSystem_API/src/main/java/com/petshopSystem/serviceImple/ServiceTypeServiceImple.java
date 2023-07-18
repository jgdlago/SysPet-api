package com.petshopSystem.serviceImple;

import org.springframework.stereotype.Service;

import com.petshopSystem.entities.ServiceType;
import com.petshopSystem.repositories.GenericRepository;
import com.petshopSystem.repositories.ServiceTypeRepository;
import com.petshopSystem.services.ServiceTypeService;

@Service
public class ServiceTypeServiceImple implements ServiceTypeService {

	private final ServiceTypeRepository serviceTypeRepository;
	public ServiceTypeServiceImple(ServiceTypeRepository serviceTypeRepository) {
		super();
		this.serviceTypeRepository = serviceTypeRepository;
	}
	
	@Override
	public GenericRepository<ServiceType> getRepository() {
		return serviceTypeRepository;
	}

}
