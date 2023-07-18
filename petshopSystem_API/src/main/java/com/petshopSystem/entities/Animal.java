package com.petshopSystem.entities;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "animal")
public class Animal extends GenericEntity {
	
    @Column(nullable = false, length = 150)
	private String name;
    
    @Column(nullable = false, length = 200)
    private String species;
    
    @Column(nullable = false, length = 150)
    private String race;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
    
}
