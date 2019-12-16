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
	
	@Transactional						// Transactional is used for adaptations, not needed for GET
	public Attraction getAttractionEntry(String eventName) {
				
		for(Attraction attr : ar.findAll()) {
			if(attr.getEventName().equals(eventName)) {
				return attr;
			}
		}
		return null;
	}

}
