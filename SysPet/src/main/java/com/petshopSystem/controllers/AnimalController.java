package com.petshopSystem.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopSystem.entities.Animal;
import com.petshopSystem.services.AnimalService;
import com.petshopSystem.services.GenericService;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/Animal")
public class AnimalController extends GenericController<Animal> {

	private final AnimalService animalService;
	public AnimalController(AnimalService animalService) {
		super();
		this.animalService = animalService;
	}
	
	@Override
	GenericService<Animal> getService() {
		return animalService;
	}
}
