package com.petshopSystem.entities;

import java.math.BigDecimal;

import com.petshopSystem.Enums.ServiceTypeEnum;

import jakarta.persistence.*;

@Entity
@Table(name = "service")
public class ServicesType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idService;
	
	@Column(nullable = true, length = 200)
	private String description;
	
	@Column(nullable = false)
	private BigDecimal price;
	
	@Column(nullable = false)
	private boolean isChecked;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ServiceTypeEnum serviceType;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Animals animal;

	public Animals getAnimal() {
		return animal;
	}

	public void setAnimal(Animals animal) {
		this.animal = animal;
	}

	public Long getIdService() {
		return idService;
	}

	public void setIdService(Long idService) {
		this.idService = idService;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public ServiceTypeEnum getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceTypeEnum serviceType) {
		this.serviceType = serviceType;
	}

}