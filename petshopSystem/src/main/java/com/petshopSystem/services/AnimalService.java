package com.petshopSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
