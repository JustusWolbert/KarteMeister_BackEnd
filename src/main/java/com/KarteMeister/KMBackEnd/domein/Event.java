package com.KarteMeister.KMBackEnd.domein;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;  
	
	private String eventName;
	private String location; //stad
	private String venue;
	private String dateAndTime;
	private String description;
	private int amountTicket;
	private double priceTicket;
	private double eventSales;
	private boolean lockerAvailable;
	private boolean consumptionAvailable;
	private double priceLocker;
	private double priceConsumption;
	
	@OneToMany(mappedBy="event")
	private List<Ticket> ticketList;
	
	@ManyToOne//(fetch = FetchType.EAGER)
	@JoinColumn(name="attraction_id", nullable=false)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Attraction attraction;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmountTicket() {
		return amountTicket;
	}
	public void setAmountTicket(int amountTicket) {
		this.amountTicket = amountTicket;
	}
	public double getPriceTicket() {
		return priceTicket;
	}
	public void setPriceTicket(double priceTicket) {
		this.priceTicket = priceTicket;
	}
	public double getEventSales() {
		return eventSales;
	}
	public void setEventSales(double eventSales) {
		this.eventSales = eventSales;
	}
	public boolean isLockerAvailable() {
		return lockerAvailable;
	}
	public void setLockerAvailable(boolean lockerAvailable) {
		this.lockerAvailable = lockerAvailable;
	}
	public boolean isConsumptionAvailable() {
		return consumptionAvailable;
	}
	public void setConsumptionAvailable(boolean consumptionAvailable) {
		this.consumptionAvailable = consumptionAvailable;
	}
	public double getPriceLocker() {
		return priceLocker;
	}
	public void setPriceLocker(double priceLocker) {
		this.priceLocker = priceLocker;
	}
	public double getPriceConsumption() {
		return priceConsumption;
	}
	public void setPriceConsumption(double priceConsumption) {
		this.priceConsumption = priceConsumption;
	}
	public Attraction getAttraction() {
		return attraction;
	}
	public void setAttraction(Attraction attraction) {
		this.attraction = attraction;
	}
	public void sellTicket() {
		this.amountTicket -= 1;
		
	}
	
	
	
	
	
}
