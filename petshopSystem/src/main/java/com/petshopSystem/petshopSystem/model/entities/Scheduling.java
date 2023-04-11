package com.petshopSystem.petshopSystem.model.entities;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "scheduling")
public class Scheduling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idscheduling;
	
	@Id
	@ManyToOne
	@JoinColumn(nullable = false)
	private Long idService;
	
	@Id
	@ManyToOne
	@JoinColumn(nullable = false)
	private Long idCustomer;
	
	@Id
	@ManyToOne
	@JoinColumn(nullable = false)
	private Long idPetshop;
	
	@Column(nullable = false, length = 10)
	private LocalDate date;

	public Long getIdService() {
		return idService;
	}

	public void setIdService(long idService) {
		this.idService = idService;
	}

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Long getIdPetshop() {
		return idPetshop;
	}

	public void setIdPetshop(long idPetshop) {
		this.idPetshop = idPetshop;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
