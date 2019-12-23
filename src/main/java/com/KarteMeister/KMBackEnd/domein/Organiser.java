package com.KarteMeister.KMBackEnd.domein;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Organiser {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String loginName;
    private String password;
    private double wallet;
    
    @OneToMany
    private List<Attraction> AttractionList;
    
    public Collection<Attraction> getAttractionList() {
        return AttractionList;
    }
    
    
    public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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



	public double getWallet() {
		return wallet;
	}



	public void setWallet(double wallet) {
		this.wallet = wallet;
	}



	public void setAttractionList(List<Attraction> attractionList) {
		AttractionList = attractionList;
	}
	
 
}