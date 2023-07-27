package com.petshopSystem.serviceImple;

import org.springframework.stereotype.Service;

import com.petshopSystem.entities.Animal;
import com.petshopSystem.repositories.AnimalRepository;
import com.petshopSystem.repositories.GenericRepository;
import com.petshopSystem.services.AnimalService;

@Service
public class AnimalServiceImple implements AnimalService {
	
	private final AnimalRepository animalRepository;
	public AnimalServiceImple(AnimalRepository animalRepository) {
		super();
		this.animalRepository = animalRepository;
	}
	
	@Override
	public GenericRepository<Animal> getRepository() {
		return animalRepository;
	}
}
