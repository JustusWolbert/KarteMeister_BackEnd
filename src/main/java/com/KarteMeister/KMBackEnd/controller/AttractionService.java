package com.KarteMeister.KMBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KarteMeister.KMBackEnd.domein.Attraction;

@Service
public class AttractionService {
	@Autowired
	AttractionRepository ar;
	
	public void postAttractionEntry(Attraction attr) {
		ar.save(attr);
	}
	
	public Attraction getAttractionEntry(String eventName) {
		/*		
		for(Attraction attr : ar.findAll()) {
			if(attr.getEventName().equals(eventName)) {
				return attr;
			}
		}
		return null;
		*/
		Attraction attr = ar.findByEventName(eventName);
		return attr;
	}
	
	/*
	@Transactional						
	public Attraction changeAttractionEntry(String eventName, String newDateAndTime) {
		Attraction att = getAttractionEntry(eventName);
		att.setDateAndTime(newDateAndTime);
		return null;
	} */
	
	public void setLocationForEvent(String location, String eventName) {
		Attraction attr = ar.findByEventName(eventName);
		attr.setLocation(location);
		ar.save(attr);
		
		//return 0;
	}
	
	public void delete(String eventName) {
		Attraction attr = ar.findByEventName(eventName);
		
		ar.deleteById(attr.getId());
	}
	

}
