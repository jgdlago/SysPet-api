package com.petshopSystem.controllers;

import java.security.SecureRandom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshopSystem.configs.JwtUtils;
import com.petshopSystem.controllers.payloads.SigninPayload;
import com.petshopSystem.controllers.payloads.SignupPayload;
import com.petshopSystem.entities.Petshop;
import com.petshopSystem.services.PetshopService;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;
	private final PetshopService petshopService;
	private final PasswordEncoder passwordEncoder;
	public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, PetshopService petshopService, PasswordEncoder passwordEncoder) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtUtils = jwtUtils;
		this.petshopService = petshopService;
		this.passwordEncoder = passwordEncoder;
	}
	
// Login
	@PostMapping("/signin")
	public ResponseEntity<Object> signin(@RequestBody SigninPayload login) {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);			
			
			String token = jwtUtils.generateTokenFromEmail(login.getEmail());
			return ResponseEntity.status(HttpStatus.OK).body(token);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
// Cadastro
	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@RequestBody SignupPayload signup) {
		try {
			Petshop newPetshop = new Petshop();
			newPetshop.setName(signup.getNome());
			newPetshop.setAddress(signup.getAddres());
			newPetshop.setPhone(signup.getPhone());
			newPetshop.setEmail(signup.getEmail());
			
			String randomPassword = randomPassword(10);
			newPetshop.setPassword(passwordEncoder.encode(randomPassword));
			
			petshopService.save(newPetshop);
			return ResponseEntity.status(HttpStatus.OK).body(randomPassword);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}	
	}
	
// Gerador de senha
	private String randomPassword(int size) {
		String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=";
		SecureRandom random = new SecureRandom();
		StringBuilder randomPassword = new StringBuilder(size);
		
		for (int i = 0; i < size; i ++) {
			int indice = random.nextInt(ALLOWED_CHARACTERS.length());
			randomPassword.append(ALLOWED_CHARACTERS.charAt(indice));
		}
		return randomPassword.toString();
	}
	
}
