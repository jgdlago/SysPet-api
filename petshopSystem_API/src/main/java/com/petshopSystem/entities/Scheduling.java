package com.petshopSystem.entities;

import java.time.LocalDate;
import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "scheduling")
public class Scheduling extends GenericEntity {
	
	@ManyToOne
	@JoinColumn(nullable = true)//@JoinColumn(nullable = false)
	private ServiceType service;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Animal animal;
	
	@Column(nullable = false, length = 10)
	private LocalDate date;

	public ServiceType getService() {
		return service;
	}

	public void setService(ServiceType service) {
		this.service = service;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
}
