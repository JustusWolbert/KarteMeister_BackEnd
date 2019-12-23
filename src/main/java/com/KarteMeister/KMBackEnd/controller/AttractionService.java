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
	
	
	public Attraction postAttractionEntry(Attraction attr, long id) {
		Organiser o = or.findById(id).get();
		attr.setOrganiser(o);
		ar.save(attr);
		return attr;
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
	
	public Event postEventEntry(Event ev, long id) {
		Attraction attr = ar.findById(id).get();
		ev.setAttraction(attr);
		er.save(ev);
		return ev;
	}
	
	public Event getEventEntry(String eventName) {
		Event ev = er.findByEventName(eventName);
		return ev;
	}
	
	public void setAmountOfTickets(long id) {
		Event ev = er.findById(id).get();
		ev.sellTicket();
		er.save(ev);
	}


}
