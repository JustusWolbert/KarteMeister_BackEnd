package com.KarteMeister.KMBackEnd.REST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KarteMeister.KMBackEnd.controller.AttractionService;
import com.KarteMeister.KMBackEnd.controller.ProfileService;
import com.KarteMeister.KMBackEnd.controller.PurchaseService;
import com.KarteMeister.KMBackEnd.domein.Event;
import com.KarteMeister.KMBackEnd.domein.Ticket;
import com.KarteMeister.KMBackEnd.domein.Visitor;

@RestController
public class VisitorEndpoint {
	
	@Autowired
	ProfileService profs;
	@Autowired 
	PurchaseService ps;
	@Autowired
	AttractionService as;
	
	@GetMapping("visitor/{visitorName}/")
	public Visitor getVisitor(@PathVariable("visitorName") String visitorName) {
		System.out.println("send");
		Visitor v = profs.getVisitorEntry(visitorName);
		List<Ticket> ticketList = new ArrayList();
		for(Ticket t : v.getTicketList()) {
			Ticket tckt = new Ticket();
			tckt.setId(t.getId());
			ticketList.add(tckt);
		}
		v.setTicketList(ticketList);
		return v;
	}
	
	@PostMapping("visitor")
	public void xmlPoster(@RequestBody Visitor vstr) {
		System.out.println("Received: "+vstr.getVisitorName());
		profs.postVisitorEntry(vstr);
	}

	
	
	
	

	

	
	
	
}
