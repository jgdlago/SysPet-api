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
    
    public ResponseEntity<Object> addPetshop(Petshop petshop) {
    	String userName = petshop.getUserName();
    	String userPassword = petshop.getUserPassword();
    	
    	if (userName.matches(".*[^a-zA-Z0-9].*") || userName.contains(" ") || userPassword.contains(" ")) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("userName ou userPassword inválidos");
    	}
    	
        Petshop savedPetshop = petShopRepository.save(petshop);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPetshop);
    }
    
    public ResponseEntity<?> getPetshopByName(String name) {
        List<Petshop> petshops = petShopRepository.findByNameContainingIgnoreCase(name);
        
        if (petshops.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum petshop encontrado");
        } else {
            return ResponseEntity.ok(petshops);
        }
    }
    
    public ResponseEntity<Object> getPetshopById(Long id) {
        Optional<Petshop> petshop = petShopRepository.findById(id);
        
        if(petshop.isPresent()) {
        	return ResponseEntity.status(HttpStatus.OK).body(petshop);
        } else {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum petshop encontrado com ID: " + id);
        }
    }
    
    public ResponseEntity<Object> updatePetshop(Long id, Petshop petshop) {
        Optional<Petshop> petshopOptional = petShopRepository.findById(id);

        if(petshopOptional.isPresent()) {
            Petshop existingPetshop = petshopOptional.get();
            
            existingPetshop.setUserName(petshop.getUserName());
            existingPetshop.setName(petshop.getName());
            existingPetshop.setAddress(petshop.getAddress());
            existingPetshop.setPhone(petshop.getPhone());
            Petshop updatedPetshop = petShopRepository.save(existingPetshop);
            return ResponseEntity.status(HttpStatus.OK).body(updatedPetshop);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum petshop encontrado com o ID: " + id);
        }
    }
    
    public ResponseEntity<Object> deletePetshop(Long id) {
        Optional<Petshop> petshop = petShopRepository.findById(id);
        
        if(petshop.isPresent()) {
            petShopRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Petshop excluído com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum petshop encontrado com o ID " + id);
        }
    }
    
}
