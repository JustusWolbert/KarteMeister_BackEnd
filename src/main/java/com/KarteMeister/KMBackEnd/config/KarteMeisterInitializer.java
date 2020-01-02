package com.KarteMeister.KMBackEnd.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.KarteMeister.KMBackEnd.controller.AttractionService;
import com.KarteMeister.KMBackEnd.controller.ProfileService;
import com.KarteMeister.KMBackEnd.controller.PurchaseService;
import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;
import com.KarteMeister.KMBackEnd.domein.Organiser;
import com.KarteMeister.KMBackEnd.domein.SalesAdmin;
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
	
	@SuppressWarnings("unused")
	@PostConstruct
	public void init() {
		
		SalesAdmin sa = createSalesAdmin(0);
		Organiser org1 = createOrganiser("Frits", "Spits","Mits", 100);
		
		Attraction attr1 = createAttraction("13TH HOUR TOUR", "Jo Hoode","Cyberpunk techno","After the first 12 hours, Jo is finally back with his distinct early 2000s cyberpunk flavour. Get ready to pump fists and get jiggly with Jo Hoode.","attraction1",profileService.getOrganiserEntry(org1.getName()).getId());
		Attraction attr2 = createAttraction("Jump around","DJ Spring and Boot","Jumpstyle","Golden oldies from 2003.","attraction2",profileService.getOrganiserEntry(org1.getName()).getId());
		Attraction attr3 = createAttraction("Boerenprotest", "Normaal", "Heukmuziek", "Daar moeten ze wat aan doen in Den Haag!","attraction3", profileService.getOrganiserEntry(org1.getName()).getId());
		Attraction attr4 = createAttraction("Vrijmibo", "Object", "borrel", "Traineeship is klaar, daar moet op gedronken worden!!","attraction4", profileService.getOrganiserEntry(org1.getName()).getId());
//		Organiser oa = profileService.getOrganiserEntry("K. Niebal");
//		attractionService.postAttractionEntry(attr1, oa.getId());
//		attractionService.postAttractionEntry(attr2, oa.getId());
		
		Event event1 = createEvent("QUARTER PAST-FEST","Rotterdam","Maassilo","13-04 13:15","Get in the mood with Hoode at the Maassilo, reachable by metro, tram, bus, bike, car, boat, and horse. Be there. You know you want to. Get your booze in advance, lockers are available on site.",450,42.50,true,true,
									1,2.60,	attractionService.getAttractionEntry("Jo Hoode").getId());
		Event event2 = createEvent("HALF PAST-FEST","Utrecht","DBs","14-04 13:30","You thought the QUARTER PAST-FEST was brutal? Go beyond every limit you've ever thought possible in DBs and party with the dude, Jo Hoode. Consumptions available in advance, no lockers on site.",150,31.50,false,true,
									1,2.60,	attractionService.getAttractionEntry("Jo Hoode").getId());
		Event event3 = createEvent("BLAST FROM THE PAST-FEST","Tilburg","013","15-04 21:30","Remember the Maassilo? Here we go again! Get your booze in advance, lockers are available on site.",320,22.50,true,true,
									1,2.60,	attractionService.getAttractionEntry("Jo Hoode").getId());
		Event event4 = createEvent("GET JAZZED-FEST","Maastricht","Club Vibes","14-05 11:30","Experimental acoustic jazz session with Jo Hoode. Consumptions available in advance, no lockers on site.",150,31.50,false,true,
									1,2.60,	attractionService.getAttractionEntry("Jo Hoode").getId());
		Event event5 = createEvent("SNAZZ-FEST","Amsterdam","Leidsche Plein","03-10 17:00","We've had so many fests, we don't know what the hell is going on anymore. See you there, no lockers.",200,55.50,false,true,
									1,2.60,	attractionService.getAttractionEntry("Jo Hoode").getId());

		Visitor vstr1 = createVisitor("Fritsje van Sonnewende","FritsMeister","wachtwoord1",170.25);
		
		Ticket tick1 = createTicket(true, true, 25, 
				attractionService.getEventEntry("QUARTER PAST-FEST").getId(),
				profileService.getVisitorEntry("FritsMeister").getId());
				
		Ticket tick2 = createTicket(true, false, 10, 
				attractionService.getEventEntry("HALF PAST-FEST").getId(),
				profileService.getVisitorEntry("FritsMeister").getId());
	}
	
	private SalesAdmin createSalesAdmin(double wallet) {
		SalesAdmin as = new SalesAdmin();
		as.setWallet(wallet);
		as.setName();
		return profileService.postAdmin(as);
	}
		
	private Organiser createOrganiser(String loginName, String name, String password, double wallet) {
		Organiser o = new Organiser();
		o.setLoginName(loginName);
		o.setName(name);
		o.setPassword(password);
		o.setWallet(wallet);
		return profileService.postOrganiserEntry(o);
	}
		
	private Attraction createAttraction(String attractionName, String artistName, String category, String description, String imageName, long id) {
		Attraction a = new Attraction();
		a.setAttractionName(attractionName);
		a.setArtistName(artistName);
		a.setCategory(category);
		a.setDescription(description);
		a.setImageName(imageName);
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
	
	
	
