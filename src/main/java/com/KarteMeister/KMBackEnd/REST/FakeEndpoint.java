package com.KarteMeister.KMBackEnd.REST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KarteMeister.KMBackEnd.controller.AttractionService;
import com.KarteMeister.KMBackEnd.controller.EventService;
import com.KarteMeister.KMBackEnd.controller.ProfileService;
import com.KarteMeister.KMBackEnd.controller.PurchaseService;
import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;
import com.KarteMeister.KMBackEnd.domein.Organiser;
import com.KarteMeister.KMBackEnd.domein.Ticket;
import com.KarteMeister.KMBackEnd.domein.Visitor;

@RestController
public class FakeEndpoint {
	
	@Autowired
	AttractionService as;
	@Autowired
	EventService es;
	@Autowired
	ProfileService profs;
	@Autowired
	PurchaseService ps;
	
	
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
		Organiser o = new Organiser();
		//o.setId(10);
		o.setLoginName("XXYYXX");
		o.setName("K. Niebal");
		o.setPassword("YYXXYY");
		o.setWallet(0);
		profs.postOrganiserEntry(o);
		
		System.out.println("received:");
		Attraction attr1 = new Attraction();
		//attr1.setId(2);
		attr1.setAttractionName("Beat Bumpers");
		attr1.setArtistName("DJ Spring and Boot");
		attr1.setCategory("Techno");
		attr1.setDescription("Stamp stamp stamp!");
		
		Attraction attr2 = new Attraction();
		attr2.setAttractionName("Counter-counterpoints");
		attr2.setArtistName("Steve Reich");
		attr2.setCategory("Minimal");
		attr2.setDescription("Min going to the max.");
		
		Organiser oa = profs.getOrganiserEntry("K. Niebal");
		as.postAttractionEntry(attr1, oa.getId());
		as.postAttractionEntry(attr2, oa.getId());
		
		Event e = new Event();
		//e.setId(1);
		e.setEventName("Feestteam");
		e.setLocation("Leiden");
		e.setVenue("B&C");
		e.setDateAndTime("03-10 17:00");
		e.setDescription("Feestje in de bieb");
		e.setAmountTicket(200);
		e.setPriceTicket(1.50);
		e.setLockerAvailable(true);
		e.setConsumptionAvailable(true);
		e.setPriceLocker(1);
		e.setPriceConsumption(2.60);
		e.setAttraction(attr1);
		Attraction a = as.getAttractionEntry("Steve Reich");
		as.postEventEntry(e,a.getId());							//hier gaatie mis
		
		Visitor v = new Visitor();
		//v.setId(4);
		v.setLoginName("Fritsje van Sonnewende");
		v.setPassword("wachtwoord1");
		v.setVisitorName("FritsMeister");
		v.setWallet(100.25);
		profs.postVisitorEntry(v);
		
		Ticket t = new Ticket();
		//t.setId(25);
		t.setIncludeConsumption(true);
		t.setIncludeLocker(true);
		t.setAmountConsumption(25);
		Event ea = as.getEventEntry("Feestteam");
		Visitor va = profs.getVisitorEntry("FritsMeister");
		ps.PostTicketEntry(t, ea.getId(), va.getId());
		
	}

	
	
	
	
	
	
	
	

	
	
}
