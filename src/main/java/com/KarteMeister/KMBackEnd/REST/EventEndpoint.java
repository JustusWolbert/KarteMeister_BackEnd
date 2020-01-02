package com.KarteMeister.KMBackEnd.REST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.KarteMeister.KMBackEnd.controller.AttractionRepository;
import com.KarteMeister.KMBackEnd.controller.AttractionService;
import com.KarteMeister.KMBackEnd.domein.Event;
import com.KarteMeister.KMBackEnd.domein.Ticket;

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
		List<Ticket> ticketList = new ArrayList<Ticket>();
		for(Ticket t : ev.getTicketList()) {
			Ticket tckt = new Ticket();
			tckt.setId(t.getId());
			ticketList.add(tckt);
		}
		ev.setTicketList(ticketList);
		return ev;
	}
	
	@PostMapping("{artistName}/event")
	public void xmlPoster(@RequestBody Event ev, @PathVariable("artistName") String artistName) {
		System.out.println("Reveived: "+ev.getEventName());
		as.postEventEntry(ev, as.getAttractionEntry(artistName).getId());
	}
	
	@GetMapping("event/all")		
	public List<Event> xmlGetAll(){
		System.out.println("send all attractions");
		List<Event> eventList = as.getAllEvents();
		List<Event> returnList = new ArrayList<Event>();
		for(Event a : eventList) {
			List<Ticket> eList = new ArrayList<Ticket>();
			for(Ticket t : a.getTicketList()) {
				Ticket tckt = new Ticket();
				tckt.setId(t.getId());
				eList.add(tckt);
			}
			a.setTicketList(eList);
			returnList.add(a);
		}
		return returnList;
	}
	
	@DeleteMapping("event/delete/{eventName}/{venueName}")
	public void xmlDelete(@PathVariable("eventName") String eventName, @PathVariable("venueName") String venue){
		as.deleteEvent(eventName, venue);
	}
	
	

	
	
}



