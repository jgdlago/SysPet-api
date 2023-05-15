package com.petshopSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.petshopSystem.entities.Animals;
import com.petshopSystem.repositories.AnimalsRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalsRepository animalsRepository;
	
    public List<Animals> getAllAnimals() {
        return animalsRepository.findAll();
    }
    
    public Animals addAnimal(Animals animal) {
        return animalsRepository.save(animal);
    }

	public ResponseEntity<?> getAnimalByName(String name) {
		List<Animals> animals = animalsRepository.findByNameContainingIgnoreCase(name);
		if (animals.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum animal encontrado");
		} else {
			return ResponseEntity.ok(animals);
		}
	}
	
	public ResponseEntity<?> getAnimalById(Long id) {
		Optional<Animals> animals = animalsRepository.findById(id);
		if (animals.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum animal encontrado com ID: " + id);
		} else {
			return ResponseEntity.ok(animals);
		}
	}
	
    public ResponseEntity<Object> updateAnimal(Long id, Animals animal) {
        Optional<Animals> animalOptional = animalsRepository.findById(id);

        if(animalOptional.isPresent()) {
            Animals existingAnimals = animalOptional.get();
            existingAnimals.setName(animal.getName());
            existingAnimals.setSpecies(animal.getSpecies());
            existingAnimals.setRace(animal.getRace());
            
            Animals updateAnimals = animalsRepository.save(existingAnimals);
            return ResponseEntity.status(HttpStatus.OK).body(updateAnimals);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Animal encontrado com o ID: " + id);
        }
    }
    
    public ResponseEntity<Object> deleteAnimal(Long id) {
    	Optional<Animals> animal = animalsRepository.findById(id);
    	if(animal.isPresent()) {
    		animalsRepository.deleteById(id);
    		return ResponseEntity.status(HttpStatus.OK).body("Animal excluido com sucesso!");
    	} else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum animal encontrado com o id" + id);
    	}
    }
}
