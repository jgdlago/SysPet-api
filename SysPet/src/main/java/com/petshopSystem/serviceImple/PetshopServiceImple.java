package com.petshopSystem.serviceImple;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.petshopSystem.dataTransferObject.BasicPetshopInfoDTO;
import com.petshopSystem.entities.Petshop;
import com.petshopSystem.repositories.GenericRepository;
import com.petshopSystem.repositories.PetShopRepository;
import com.petshopSystem.services.PetshopService;

import jakarta.transaction.Transactional;

@Service
@Transactional
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
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Petshop petshop = this.petShopRepository.findByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
	    return petshop;
	}

	@Override
	public BasicPetshopInfoDTO getBasicPetshopInfo(String email) throws Exception {
	    try {
	        Petshop petshop = this.petShopRepository.findByEmail(email)
	                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
	        
	        BasicPetshopInfoDTO basicInfo = new BasicPetshopInfoDTO();
	        basicInfo.setId(petshop.getId());
	        basicInfo.setName(petshop.getName());
	        basicInfo.setEmail(petshop.getEmail());
	        
	        return basicInfo;
	    } catch (Exception e) {
	        throw new Exception("Erro ao obter informações do petshop.", e);
	    }
	}

	

}
