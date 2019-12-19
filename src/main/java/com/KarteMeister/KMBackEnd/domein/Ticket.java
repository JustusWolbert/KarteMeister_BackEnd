package com.KarteMeister.KMBackEnd.domein;

import javax.persistence.Entity;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean includeLocker;
    private boolean includeConsumption;
    private int amountConsumption;
    private int ticketPrice;
    
    @ManyToOne
    private Event event;
    @ManyToOne
    private Visitor visitor;
    
    public int addLocker(){
        if(this.includeLocker == true) {
        	this.ticketPrice += event.getPriceLocker();
        	return ticketPrice;
        }else {
        	return ticketPrice;
        }
    }
    
    public int addConsumption(int amountConsumptions) {
        if(this.includeConsumption == true) {
        	this.ticketPrice += (amountConsumptions * event.getPriceConsumption());
        	return ticketPrice;
        }else {
        return ticketPrice;
        }
    }
    
    public boolean isIncludeLocker() {
		return includeLocker;
	}

	public void setIncludeLocker(boolean includeLocker) {
		this.includeLocker = includeLocker;
	}

	public boolean isIncludeConsumption() {
		return includeConsumption;
	}

	public void setIncludeConsumption(boolean includeConsumption) {
		this.includeConsumption = includeConsumption;
	}

	public int getAmountConsumption() {
		return amountConsumption;
	}

	public void setAmountConsumption(int amountConsumption) {
		this.amountConsumption = amountConsumption;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int setTicketPrice() {
		this.ticketPrice = event.getPriceTicket();
		return ticketPrice;
	}
	
	public int getTicketPrice() {
		return ticketPrice;
	}


//	public Event getEvent() {
//		return event;
//	}

//	public void setEvent(Event event) {
//		this.event = event;
//	}
    
    
    
    

}
