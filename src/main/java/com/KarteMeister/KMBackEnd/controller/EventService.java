package com.KarteMeister.KMBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KarteMeister.KMBackEnd.domein.Event;

@Service
public class EventService {
	@Autowired
	EventRepository er;
	
	public void postEventEntry(Event ev) {
		er.save(ev);
		System.out.println(ev);
	}
	
	public Event getEventEntry(String eventName) {
		Event ev = er.findByEventName(eventName);
		return ev;

	}
}



	