package com.petshopSystem.petshopSystem.model.entities;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "service")
public class Services {
	
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
	private String serviceType;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Petshop petshop;

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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
}
