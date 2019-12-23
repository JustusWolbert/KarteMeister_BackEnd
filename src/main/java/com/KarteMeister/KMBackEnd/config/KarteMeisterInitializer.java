package com.KarteMeister.KMBackEnd.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.KarteMeister.KMBackEnd.controller.AttractionService;
import com.KarteMeister.KMBackEnd.controller.ProfileService;
import com.KarteMeister.KMBackEnd.controller.PurchaseService;
import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;
import com.KarteMeister.KMBackEnd.domein.Organiser;
import com.KarteMeister.KMBackEnd.domein.Ticket;
import com.KarteMeister.KMBackEnd.domein.Visitor;

@Component
public class KarteMeisterInitializer {
	
	private final AttractionService attractionService;
	private final ProfileService profileService;
	private final PurchaseService purchaseService;
	
	
	@Autowired
	public KarteMeisterInitializer(AttractionService attractionService, ProfileService profileService, PurchaseService purchaseService) {
		this.attractionService = attractionService;
		this.profileService = profileService;
		this.purchaseService = purchaseService;
	}
	
	@PostConstruct
	public void init() {
		
		Organiser org1 = createOrganiser("Frits", "Spits","Mits", 100);
		
		Attraction attr1 = createAttraction("Beat Bumpers", "DJ Spring and Boot","Techno","Stamp stamp stamp!",profileService.getOrganiserEntry(org1.getName()).getId());
		Attraction attr2 = createAttraction("Counter-counterpoints","Steve Reich","Minimal","Min going to the max.",profileService.getOrganiserEntry(org1.getName()).getId());
		
//		Organiser oa = profileService.getOrganiserEntry("K. Niebal");
//		attractionService.postAttractionEntry(attr1, oa.getId());
//		attractionService.postAttractionEntry(attr2, oa.getId());
		
		Event event1 = createEvent("Feestteam","Leiden","B&C","03-10 17:00","Feestje in de bieb",200,1.50,true,true,
									1,2.60,	attractionService.getAttractionEntry("Steve Reich").getId());						//hier gaatie mis
		
		Visitor v = createVisitor("Fritsje van Sonnewende","FritsMeister","wachtwoord1",100.25);
		
		Ticket t = createTicket(true, true, 25, 
				attractionService.getEventEntry("Feestteam").getId(),
				profileService.getVisitorEntry("FritsMeister").getId());
				

				

			
	}
		
	private Organiser createOrganiser(String loginName, String name, String password, double wallet) {
		Organiser o = new Organiser();
		o.setLoginName(loginName);
		o.setName(name);
		o.setPassword(password);
		o.setWallet(wallet);
		return profileService.postOrganiserEntry(o);
		
	}
		
	private Attraction createAttraction(String attractionName, String artistName, String category, String description, long id) {
		Attraction a = new Attraction();
		a.setAttractionName(attractionName);
		a.setArtistName(artistName);
		a.setCategory(category);
		a.setDescription(description);
		return attractionService.postAttractionEntry(a, id);
	}

	private Event createEvent(String eventName, String location, String venue, String DateAndTime, String description, 
			int amountTicket, double priceTicket, boolean lockerAvailable, boolean consumptionAvailable, 
			double priceLocker, double priceConsumption, long id) {
		Event e = new Event();
		//e.setId(1);
		e.setEventName(eventName);
		e.setLocation(location);
		e.setVenue(venue);
		e.setDateAndTime(DateAndTime);
		e.setDescription(description);
		e.setAmountTicket(amountTicket);
		e.setPriceTicket(priceTicket);
		e.setLockerAvailable(lockerAvailable);
		e.setConsumptionAvailable(consumptionAvailable);
		e.setPriceLocker(priceLocker);
		e.setPriceConsumption(priceConsumption);
		return attractionService.postEventEntry(e, id);	
	}
	
	private Visitor createVisitor(String loginName, String name, String password, double wallet) {
		Visitor v = new Visitor();
		v.setLoginName(loginName);
		v.setVisitorName(name);
		v.setPassword(password);
		v.setWallet(wallet);
		return profileService.postVisitorEntry(v);
	
	}
	
	private Ticket createTicket(boolean includeConsumption, boolean includeLocker, int amountConsumption, long id1, long id2) {
		Ticket t = new Ticket();
		t.setIncludeConsumption(includeConsumption);
		t.setIncludeLocker(includeLocker);
		t.setAmountConsumption(amountConsumption);
		return purchaseService.PostTicketEntry(t, id1, id2);

	}
	
	
}
	
	
	
