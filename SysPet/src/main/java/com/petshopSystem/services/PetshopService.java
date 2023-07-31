package com.petshopSystem.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.petshopSystem.dataTransferObject.BasicPetshopInfoDTO;
import com.petshopSystem.entities.Petshop;

public interface PetshopService extends GenericService<Petshop>, UserDetailsService {
	
	public BasicPetshopInfoDTO getBasicPetshopInfo(String email) throws Exception;
	
}
