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
import com.KarteMeister.KMBackEnd.controller.EventService;
import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;

@RestController
public class FakeEndpoint {
	
	@Autowired
	AttractionService as;
	@Autowired
	EventService es;
	
	@GetMapping("stub")
	public List<Attraction> getStub() {
		System.out.println("Send stub");
		
		List<Attraction> attrList = new ArrayList<Attraction>();
		
		Attraction attr1 = new Attraction();
		attr1.setId(2);
		attr1.setAttractionName("Beat Bumpers");
		attr1.setArtistName("DJ Spring and Boot");
		attr1.setCategory("Techno");
		attr1.setDescription("Stamp stamp stamp!");
		
		Attraction attr2 = new Attraction();
		attr2.setAttractionName("Counter-counterpoints");
		attr2.setArtistName("Steve Reich");
		attr2.setCategory("Minimal");
		attr2.setDescription("Min going to the max.");
		
		attrList.add(attr1);
		attrList.add(attr2);		
		
		return attrList;
	}
	
	@PostMapping("stubPost")
	public void stubPoster(Attraction attr){
		System.out.println("received:");
		Attraction attr1 = new Attraction();
		attr1.setId(2);
		attr1.setAttractionName("Beat Bumpers");
		attr1.setArtistName("DJ Spring and Boot");
		attr1.setCategory("Techno");
		attr1.setDescription("Stamp stamp stamp!");
		
		Attraction attr2 = new Attraction();
		attr2.setAttractionName("Counter-counterpoints");
		attr2.setArtistName("Steve Reich");
		attr2.setCategory("Minimal");
		attr2.setDescription("Min going to the max.");
		
		as.postAttractionEntry(attr1);
		as.postAttractionEntry(attr2);
	}
	
	
//	@GetMapping("stubEvent")
//	public Event getStub() {
//		Event e = new Event();
//		e.setId(1);
//		e.setEventName("Feestteam");
//		e.setLocation("Leiden");
//		e.setVenue("B&C");
//		e.setDateAndTime("03-10 17:00");
//		e.setDescription("Feestje in de bieb");
//		e.setAmountTicket(200);
//		e.setPriceTicket(1.50);
//		e.setLockerAvailable(true);
//		e.setConsumptionAvailable(true);
//		e.setPriceLocker(1);
//		e.setPriceConsumption(2.60);
//		e.setAttraction(ar.findByArtistName("DJ Spring and Boot"));
//		return e;
//	}
//	
//	@PostMapping("stubPostEvent")
//	public void postStub() {
//		Event e = new Event();
//		e.setId(1);
//		e.setEventName("Feestteam");
//		e.setLocation("Leiden");
//		e.setVenue("B&C");
//		e.setDateAndTime("03-10 17:00");
//		e.setDescription("Feestje in de bieb");
//		e.setAmountTicket(200);
//		e.setPriceTicket(1.50);
//		e.setLockerAvailable(true);
//		e.setConsumptionAvailable(true);
//		e.setPriceLocker(1);
//		e.setPriceConsumption(2.60);
//		e.setAttraction(ar.findByArtistName("DJ Spring and Boot"));
//		er.save(e);
//	}
	
	
	
}
