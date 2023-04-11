package com.petshopSystem.petshopSystem.model.entities;

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
    
    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private long idPetshop;

	public long getIdCliente() {
		return idCustomer;
	}

	public void setIdCliente(long idCustomer) {
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

	public long getIdPetshop() {
		return idPetshop;
	}

	public void setIdPetshop(long idPetshop) {
		this.idPetshop = idPetshop;
	}
    
}
