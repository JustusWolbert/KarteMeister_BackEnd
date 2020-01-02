package com.KarteMeister.KMBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;
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
	
	/*
	 * Attraction entries 
	 */
	public Attraction postAttractionEntry(Attraction attr, long OrganiserId) {	//post attraction
		Organiser o = or.findById(OrganiserId).get();
		attr.setOrganiser(o);
		ar.save(attr);
		return attr;
	}
	
	public Attraction getAttractionEntry(String artistName) {			//get attraction
		Attraction attr = ar.findByArtistName(artistName);
		return attr;
	}
	
	public List<Attraction> findAll(){									//get all attraction
		List<Attraction> attrList = ar.findAll();
		return attrList;
	}
	
	public void setCategoryForAttraction(String artistName, String category) { //put caterory for attraction
		Attraction attr = ar.findByArtistName(artistName);
		attr.setCategory(category);
		ar.save(attr);
	}
	
	public void removeAttraction(String artistName) {					//delete attraction 
		ar.deleteById(ar.findByArtistName(artistName).getId());			//removes children
		ar.removeById(ar.findByArtistName(artistName).getId());			//removes attraction	
	}
	
	
	/*
	 * Event entries 
	 */
	public List<Event> getAllEvents(){					//get all events
		List<Event> eventList = er.findAll();
		return eventList;
	}
	
	public List<Event> getAllEventsByAttractionId(String artistName){
		List<Event> eventList = er.findAllByAttractionId(getAttractionEntry(artistName).getId());
		return eventList;
	}
	
	public Event postEventEntry(Event ev, long id) {	//post event
		Attraction attr = ar.findById(id).get();
		ev.setAttraction(attr);
		er.save(ev);
		return ev;
	}
	
	public Event getEventEntry(String eventName) {		//get event
		Event ev = er.findByEventName(eventName);
		return ev;
	}
	
	public void setAmountOfTickets(long id) {			//set event
		Event ev = er.findById(id).get();
		ev.sellTicket();
		er.save(ev);
	}
	
	public void deleteEvent(String eventName, String venue) {
		er.deleteById(er.findByEventNameAndVenue(eventName, venue).getId());			//removes children
		//er.removeById(er.findByEventNameAndVenue(eventName, venue).getId());			//removes attraction
	}

		
	


}
