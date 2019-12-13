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
	
	@Transactional
	public Attraction getAttractionEntry(String eventName) {
		
		Attraction attract = new Attraction();
		
		for(Attraction attr : ar.findAll()) {
			if(attr.getEventName().equals(eventName)) {
				attract = attr;
				break;
			}
		}
		
		return attract;
	}

}
