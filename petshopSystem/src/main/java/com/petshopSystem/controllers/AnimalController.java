package com.petshopSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

}
