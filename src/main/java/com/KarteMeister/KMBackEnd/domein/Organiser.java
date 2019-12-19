package com.KarteMeister.KMBackEnd.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Organiser {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private int wallet;
	private String name;
	private String loginName;
	private String password;
	
	@OneToMany(mappedBy="organiser")
	private List<Attraction> attractionList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Attraction> getAttractionList() {
		return attractionList;
	}

	public void setAttractionList(List<Attraction> attractionList) {
		this.attractionList = attractionList;
	}
    

    
}
