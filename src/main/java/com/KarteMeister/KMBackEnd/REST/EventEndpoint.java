package com.KarteMeister.KMBackEnd.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.KarteMeister.KMBackEnd.controller.AttractionRepository;
import com.KarteMeister.KMBackEnd.controller.AttractionService;
import com.KarteMeister.KMBackEnd.controller.EventService;
import com.KarteMeister.KMBackEnd.domein.Event;

@RestController
public class EventEndpoint {
	@Autowired
	AttractionService as; 
	@Autowired
	AttractionRepository ar;

	
	@GetMapping("event/{eventName}/")
	public Event xmlGetter(@PathVariable("eventName") String eventName) {
		System.out.println("send");
		Event ev = as.getEventEntry(eventName);
		return ev;
	}
	
	@PostMapping("{attractionId}/event")
	public void xmlPoster(@RequestBody Event ev, @PathVariable("attractionId") long id) {
		System.out.println("Reveived: "+ev.getEventName());
		as.postEventEntry(ev, id);
	}

	
}



