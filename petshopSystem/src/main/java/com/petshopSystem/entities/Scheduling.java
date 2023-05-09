package com.petshopSystem.entities;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "scheduling")
public class Scheduling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idscheduling;
	
	@ManyToOne
	@JoinColumn(nullable = true)//@JoinColumn(nullable = false)
	private ServicesType service;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Animals animal;
	
	@Column(nullable = false, length = 10)
	private LocalDate date;

	public Long getIdscheduling() {
		return idscheduling;
	}

	public void setIdscheduling(Long idscheduling) {
		this.idscheduling = idscheduling;
	}

	public ServicesType getService() {
		return service;
	}

	public void setService(ServicesType service) {
		this.service = service;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Animals getAnimal() {
		return animal;
	}

	public void setAnimal(Animals animal) {
		this.animal = animal;
	}
	
	
}
