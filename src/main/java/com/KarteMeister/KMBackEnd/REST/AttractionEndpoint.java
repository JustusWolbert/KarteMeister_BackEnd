package com.KarteMeister.KMBackEnd.REST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KarteMeister.KMBackEnd.controller.AttractionService;
import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;

@RestController
public class AttractionEndpoint {
	
	@Autowired
	AttractionService as;
	
	@GetMapping("attraction/{artistName}/")
	public Attraction xmlGetter(@PathVariable("artistName") String artistName){
		System.out.println("send");
		Attraction attr = as.getAttractionEntry(artistName);
		List<Event> eventList = new ArrayList<Event>();
		for(Event e : attr.getEventList()) {
			Event ev = new Event();
			ev.setId(e.getId());
			eventList.add(ev);
			System.out.println(ev.getId());
		}
		attr.setEventList(eventList);	
		return attr;
	}
	
	@GetMapping("attraction/all") 
	public List<Attraction> xmlGetAll(){
		System.out.println("send all attractions");
		List<Attraction> attrList = as.findAll();
		List<Attraction> returnList = new ArrayList<Attraction>();
		for(Attraction a : attrList) {
			List<Event> eventList = new ArrayList<Event>();
			for(Event e : a.getEventList()) {
				Event ev = new Event();
				ev.setId(e.getId());
				eventList.add(ev);
				System.out.println(ev.getId());
			}
			a.setEventList(eventList);
			returnList.add(a);
		}
		return returnList;
	}
	
	@PostMapping("{organiserId}/attraction")
	public void xmlPoster(@RequestBody Attraction attr, @PathVariable("organiserId") long id){
		System.out.println("Received: "+ attr.getAttractionName());
		as.postAttractionEntry(attr, id); 	//needs organiser ID
	}
	
	@GetMapping("{artistName}/allEvents")
	public List<Event> getAllEvents(@PathVariable("artistName") String artistName){
		System.out.println("Send all events");
		List<Event> eventList = as.getAllEventsByAttractionId(artistName);
		return eventList;
	}
	
	@PutMapping("attraction/change/{artistName}/{category}/")
	public void xmlPut(@PathVariable("artistName") String artistName, @PathVariable("category") String category){
		as.setCategoryForAttraction( artistName, category);
		
	}
	
	@DeleteMapping("attraction/delete/{artistName}/")
	public void xmlDelete(@PathVariable("artistName") String artistName){
		as.removeAttraction(artistName);
	}
	

	
	
	
}
