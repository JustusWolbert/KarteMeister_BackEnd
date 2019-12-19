package com.KarteMeister.KMBackEnd.domein;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;  
	private String eventName;
	private String location; //stad
	private String venue;
	private String timeAndDate;
	private String description;
	private int amountTicket;
	private int priceTicket;
	private int eventSales;
	private boolean lockerAvailable;
	private boolean consumptionAvailable;
	private int priceLocker;
	private int priceConsumption;
	
	@OneToMany(mappedBy="event")
	private List<Ticket> ticketList;
	@ManyToOne
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
	public String getTimeAndDate() {
		return timeAndDate;
	}
	public void setTimeAndDate(String timeAndDate) {
		this.timeAndDate = timeAndDate;
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
	public int getPriceTicket() {
		return priceTicket;
	}
	public void setPriceTicket(int priceTicket) {
		this.priceTicket = priceTicket;
	}
	public int getEventSales() {
		return eventSales;
	}
	public void setEventSales(int eventSales) {
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
	public int getPriceLocker() {
		return priceLocker;
	}
	public void setPriceLocker(int priceLocker) {
		this.priceLocker = priceLocker;
	}
	public int getPriceConsumption() {
		return priceConsumption;
	}
	public void setPriceConsumption(int priceConsumption) {
		this.priceConsumption = priceConsumption;
	}
	
	
	
	
}
