package com.petshopSystem.petshopSystem.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "animal")
public class Animals {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnimal;
	
    @Column(nullable = false, length = 150)
	private String name;
    
    @Column(nullable = false, length = 200)
    private String species;
    
    @Column(nullable = false, length = 150)
    private String race;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Customers customer;

	public Long getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Long idAnimal) {
		this.idAnimal = idAnimal;
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
