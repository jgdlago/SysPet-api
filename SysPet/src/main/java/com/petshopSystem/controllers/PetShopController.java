package com.petshopSystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopSystem.dataTransferObject.BasicPetshopInfoDTO;
import com.petshopSystem.entities.Petshop;
import com.petshopSystem.services.GenericService;
import com.petshopSystem.services.PetshopService;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/Petshop")
public class PetShopController extends GenericController<Petshop> {

	private final PetshopService petshopService;
	public PetShopController(PetshopService petshopService) {
		super();
		this.petshopService = petshopService;
	}
	
	@Override
	GenericService<Petshop> getService() {
		return petshopService;
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> getBasicPetshopInfo(@PathVariable String email) {
	    try {
	        BasicPetshopInfoDTO petshopInfo = petshopService.getBasicPetshopInfo(email);
	        return ResponseEntity.ok(petshopInfo);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	    }
	}

	
}
