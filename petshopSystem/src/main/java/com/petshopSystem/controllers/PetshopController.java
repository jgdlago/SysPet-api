package com.petshopSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.petshopSystem.entities.Petshop;
import com.petshopSystem.services.PetshopService;


@RestController
@RequestMapping("/petshops")
public class PetshopController {

    @Autowired
    private PetshopService petshopService;

    @GetMapping
    public List<Petshop> getAllPetshops() {
        return petshopService.getAllPetshops();
    }

    @PostMapping
    public Petshop addPetshop(@RequestBody Petshop petshop) {
    	return petshopService.addPetshop(petshop);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPetshopById(@PathVariable Long id) {
        return petshopService.getPetshopById(id);
    }

//    @PutMapping("/{id}")
//    public Petshop updatePetshop(@PathVariable Long id, @RequestBody Petshop petshop) {
//        return petshopService.updatePetshop(id, petshop);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deletePetshop(@PathVariable Long id) {
//        petshopService.deletePetshop(id);
//    }
}