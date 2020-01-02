package com.KarteMeister.KMBackEnd.domein;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean includeLocker;
    private boolean includeConsumption;
    private int amountConsumption;
    private double ticketPrice;
    
    @ManyToOne
    @JoinColumn(name="event_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    //@JsonManagedReference
    private Event event;
    
    @ManyToOne
    @JoinColumn(name="visitor_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    //@JsonManagedReference
    private Visitor visitor;
    
   
    
    public double addLocker(){
        if(this.includeLocker == true) {
        	this.ticketPrice += event.getPriceLocker();
        	return ticketPrice;
        }else {
        	return ticketPrice;
        }
    }
    
    public double addConsumption(int amountConsumptions) {
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
	
	public double setTicketPrice() {
		this.ticketPrice += event.getPriceTicket();
		return ticketPrice;
	}
	
	public double getTicketPrice() {
		return ticketPrice;
	}


	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
    
    
    
    

}
