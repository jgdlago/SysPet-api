package com.petshopSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.petshopSystem.entities.Petshop;
import com.petshopSystem.repositories.PetShopRepository;

@Service
public class PetshopService {
    
	@Autowired
	private PetShopRepository petShopRepository;

    public List<Petshop> getAllPetshops() {
        return petShopRepository.findAll();
    }
    
    public Petshop addPetshop(Petshop petshop) {
        return petShopRepository.save(petshop);
    }
    
    public ResponseEntity<Object> getPetshopById(Long id) {
        Optional<Petshop> petshop = petShopRepository.findById(id);
        if(petshop.isPresent()) {
        	return ResponseEntity.status(HttpStatus.OK).body(petshop);
        } else {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum petshop encontrado" + id);
        }
    }
}
