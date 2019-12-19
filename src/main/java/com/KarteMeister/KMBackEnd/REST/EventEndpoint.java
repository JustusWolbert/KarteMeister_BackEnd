package com.KarteMeister.KMBackEnd.REST;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.KarteMeister.KMBackEnd.controller.EventService;

import com.KarteMeister.KMBackEnd.domein.Event;

@RestController
public class EventEndpoint {
	@Autowired
	EventService es; 
	
	@GetMapping("event/{firstValue}/")
	public Event xmlGetter(@PathVariable("firstValue") String firstValue) {
		System.out.println("send");
		Event ev = es.getEventEntry(firstValue);
		return ev;
	}
	
	@PostMapping("event")
	public void xmlPoster(@RequestBody Event ev) {
		System.out.println("Reveived: "+ev);
		es.postEventEntry(ev);
	}
}



