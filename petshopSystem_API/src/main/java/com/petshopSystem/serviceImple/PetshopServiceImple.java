package com.petshopSystem.serviceImple;

import org.springframework.stereotype.Service;

import com.petshopSystem.entities.Petshop;
import com.petshopSystem.repositories.GenericRepository;
import com.petshopSystem.repositories.PetShopRepository;
import com.petshopSystem.services.PetshopService;

@Service
public class PetshopServiceImple implements PetshopService {

	private final PetShopRepository petShopRepository;
	public PetshopServiceImple(PetShopRepository petShopRepository) {
		super();
		this.petShopRepository = petShopRepository;
	}
	
	@Override
	public GenericRepository<Petshop> getRepository() {
		return petShopRepository;
	}

}
