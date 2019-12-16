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
    long id;
    boolean locker;
    boolean consumption;
    boolean meal;
    int price;
    int priceLocker;
    int priceConsumption;
    int priceMeal;
    
    @ManyToOne
    private Event event;
    
    public int addLocker(){
        locker = true;
        price += priceLocker;
        return price;
    }
    
    public int addConsumption() {
        consumption = true;
        price += priceConsumption;
        return price;
    }
    
    public int addMeal() {
        meal = true;
        price += priceLocker;
        return price;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isLocker() {
		return locker;
	}

	public void setLocker(boolean locker) {
		this.locker = locker;
	}

	public boolean isConsumption() {
		return consumption;
	}

	public void setConsumption(boolean consumption) {
		this.consumption = consumption;
	}

	public boolean isMeal() {
		return meal;
	}

	public void setMeal(boolean meal) {
		this.meal = meal;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public int getPriceMeal() {
		return priceMeal;
	}

	public void setPriceMeal(int priceMeal) {
		this.priceMeal = priceMeal;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
    
    
    
    

}
