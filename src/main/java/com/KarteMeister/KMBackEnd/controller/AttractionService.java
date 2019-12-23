package com.KarteMeister.KMBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;
import com.KarteMeister.KMBackEnd.domein.Image;
import com.KarteMeister.KMBackEnd.domein.Organiser;

@Service
public class AttractionService {
	@Autowired
	AttractionRepository ar;
	
	@Autowired
	EventRepository er;
	
	@Autowired
	OrganiserRepository or;
	
	@Autowired
	ImageRepository ir;
	
	
	public void postAttractionEntry(Attraction attr, long id) {
		Organiser o = or.findById(id).get();
		attr.setOrganiser(o);
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
	
	public void postOrganiserEntry(Organiser orga) {
		or.save(orga);
	}

	public Organiser getOrganiserEntry(String string) {
		Organiser o = or.findByName(string);
		return o;
	}



}
