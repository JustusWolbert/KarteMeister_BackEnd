package com.KarteMeister.KMBackEnd.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KarteMeister.KMBackEnd.controller.PurchaseService;
import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Ticket;

@RestController
public class TicketEndpoint {
	@Autowired
	PurchaseService ps;
	
	@GetMapping("ticket/{ticketId}/")
	public Ticket xmlGetter(@PathVariable("ticketId") long ticketId){
		System.out.println("send");
		Ticket tckt = ps.getTicketEntry(ticketId);
		return tckt;
	}
	
	@PostMapping("{VisitorId}/{EventId}/ticket")
	public void xmlPoster(@RequestBody Ticket tckt,@PathVariable("EventId") long EventId,@PathVariable("VisitorId") long VisitorId){
		System.out.println("Received ticket: "+tckt.getId());
		ps.PostTicketEntry(tckt, EventId, VisitorId);
	}
	
//	@PutMapping("ticket/change/{firstValue}/{secondValue}/")
//	public void xmlPut(@PathVariable("firstValue") String firstValue, @PathVariable("secondValue") String secondValue){
//		ps.setCategoryForAttraction(firstValue, secondValue);
//		
//	}
//	
//	@DeleteMapping("ticket/delete/{firstValue}/")
//	public void xmlDelete(@PathVariable("firstValue") String firstValue){
//		ps.delete(firstValue);
//	}
}
