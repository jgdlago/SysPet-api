package com.petshopSystem.entities;

import java.math.BigDecimal;

import com.petshopSystem.Enums.ServiceTypeEnum;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "service")
public class ServiceType extends GenericEntity {
	
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
	private Animal animal;

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
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