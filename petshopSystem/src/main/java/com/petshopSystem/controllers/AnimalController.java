package com.petshopSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopSystem.entities.Animals;
import com.petshopSystem.services.AnimalService;

@RestController
@RequestMapping("/animals")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	@GetMapping
    public List<Animals> getAllAnimals() {
        return animalService.getAllAnimals();
    }
	
	@PostMapping
	public Animals addAnimal(@RequestBody Animals animal) {
		return animalService.addAnimal(animal);
	}
	
    @GetMapping("/name/{name}")
    public ResponseEntity<?> getAnimalByName(@PathVariable String name) {
    	return animalService.getAnimalByName(name);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getAnimalById(@PathVariable Long id) {
    	return animalService.getAnimalById(id);
    }
    
    @PutMapping("/id/{id}")
    public ResponseEntity<Object> updateAnimal(@PathVariable Long id, @RequestBody Animals animal) {
        return animalService.updateAnimal(id, animal);
    }
    
    @DeleteMapping("/id/{id}")
    public void deleteAnimal(@PathVariable Long id) {
    	animalService.deleteAnimal(id);
    }

}
