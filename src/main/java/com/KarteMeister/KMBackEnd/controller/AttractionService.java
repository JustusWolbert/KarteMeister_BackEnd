package com.KarteMeister.KMBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;

@Service
public class AttractionService {
	@Autowired
	AttractionRepository ar;
	
	@Autowired
	EventRepository er;
	
	
	public void postAttractionEntry(Attraction attr) {
		ar.save(attr);
	}
	
	public Attraction getAttractionEntry(String artistName) {
		Attraction attr = ar.findByArtistName(artistName);
		return attr;
	}
	
	
	public void setCategoryForAttraction(String category, String artistName) {
		Attraction attr = ar.findByArtistName(artistName);
		attr.setCategory(category);
		ar.save(attr);
	}
	
	public void delete(String artistName) {
		Attraction attr = ar.findByArtistName(artistName);
		ar.deleteById(attr.getId());
	}
	

}
