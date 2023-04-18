package com.petshopSystem.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "customers")
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCustomer;
	
    @Column(nullable = false, length = 150)
	private String name;
    
    @Column(nullable = false, length = 15)
    private String phone;
    
    @Column(nullable = true, length = 200)
    private String email;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Petshop petshop;

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Petshop getPetshop() {
		return petshop;
	}

	public void setPetshop(Petshop petshop) {
		this.petshop = petshop;
	}
    
}