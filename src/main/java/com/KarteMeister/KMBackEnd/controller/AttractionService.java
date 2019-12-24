package com.KarteMeister.KMBackEnd.controller;

import java.util.List;

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
		
//		List<Attraction> attractionList = o.getAttractionList();
//		attractionList.add(attr);
//		o.setAttractionList(attractionList);
//		or.save(o);
		return attr;
	}
	
	public Attraction getAttractionEntry(String artistName) {
		Attraction attr = ar.findByArtistName(artistName);
		return attr;
	}
	
	public List<Attraction> findAll(){
		List<Attraction> attrList = ar.findAll();
		return attrList;
	}
	
	public List<Event> getAllEvents(){
		List<Event> eventList = er.findAll();
		return eventList;
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
		
//		List<Event> eventList = attr.getEventList();
//		eventList.add(ev);
//		attr.setEventList(eventList);
//		ar.save(attr);
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
