package com.petshopSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshopSystem.entities.ServicesType;
import com.petshopSystem.repositories.ServiceTypeRepository;

@Service
public class ServiceTypeService {
	
	@Autowired
	private ServiceTypeRepository serviceTypeRepository;
	
    public List<ServicesType> getAllServicesType() {
        return serviceTypeRepository.findAll();
    }
    
    public ServicesType addServicesType(ServicesType servicesType) {
        return serviceTypeRepository.save(servicesType);
    }
    
}
