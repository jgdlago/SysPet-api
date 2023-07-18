package com.petshopSystem.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
