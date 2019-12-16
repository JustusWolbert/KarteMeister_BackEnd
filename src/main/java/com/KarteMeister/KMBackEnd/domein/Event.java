package com.KarteMeister.KMBackEnd.domein;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;  
    private String location;
    private String dateAndTime;
    private String description;
    private String eventName;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
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
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

}
