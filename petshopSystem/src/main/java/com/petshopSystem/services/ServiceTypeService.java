package com.petshopSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
	public ResponseEntity<?> getServiceTypeById(Long id) {
		Optional<ServicesType> servicesType = serviceTypeRepository.findById(id);
		if (servicesType.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum serviço encontrado com ID: " + id);
		} else {
			return ResponseEntity.ok(servicesType);
		}
	}
	
    public ResponseEntity<Object> updateServiceType(Long id, ServicesType servicesType) {
        Optional<ServicesType> servicesTypeOptional = serviceTypeRepository.findById(id);

        if(servicesTypeOptional.isPresent()) {
        	ServicesType existingServices = servicesTypeOptional.get();
        	existingServices.setDescription(servicesType.getDescription());
        	existingServices.setServiceType(servicesType.getServiceType());
        	existingServices.setAnimal(servicesType.getAnimal());
        	existingServices.setPrice(servicesType.getPrice());
        	existingServices.setChecked(servicesType.isChecked());
            
            ServicesType updateServiceType = serviceTypeRepository.save(existingServices);
            return ResponseEntity.status(HttpStatus.OK).body(updateServiceType);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum serviço encontrado com o ID: " + id);
        }
    }
}
