package com.petshopSystem.petshopSystem.model.entities;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "scheduling")
public class Scheduling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idscheduling;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Services service;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Customers customer;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Petshop petshop;
	
	@Column(nullable = false, length = 10)
	private LocalDate date;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
