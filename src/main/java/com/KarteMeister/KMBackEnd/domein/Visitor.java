package com.KarteMeister.KMBackEnd.domein;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    int wallet;
    String visitorName;
    
    @OneToMany
    private List<Ticket> ticketdemo;

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

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public List<Ticket> getTicketdemo() {
		return ticketdemo;
	}

	public void setTicketdemo(List<Ticket> ticketdemo) {
		this.ticketdemo = ticketdemo;
	}
    
    

}
