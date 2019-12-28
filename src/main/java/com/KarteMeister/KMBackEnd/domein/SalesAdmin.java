package com.KarteMeister.KMBackEnd.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalesAdmin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double wallet;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	
	public void setName() {
		this.name="Admin";
	}
	
	public String getName() {
		return name;
	}
}
