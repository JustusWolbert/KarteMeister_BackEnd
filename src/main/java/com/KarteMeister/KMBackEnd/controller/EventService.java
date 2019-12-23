package com.KarteMeister.KMBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;

@Service
public class EventService {
	
	@Autowired
	EventRepository er;
	@Autowired
	AttractionRepository ar;
	
	public void postEventEntry(Event ev, long id) {
		Attraction attr = ar.findById(id).get();
		ev.setAttraction(attr);
		er.save(ev);
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



	