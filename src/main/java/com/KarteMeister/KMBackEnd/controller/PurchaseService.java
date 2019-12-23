package com.KarteMeister.KMBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;
import com.KarteMeister.KMBackEnd.domein.Ticket;
import com.KarteMeister.KMBackEnd.domein.Visitor;

@Service
public class PurchaseService {

	@Autowired
	EventRepository er;
	
	@Autowired
	VisitorRepository vr;

	@Autowired
	TicketRepository tr;

	public Ticket getTicketEntry(long TicketId) {
		Ticket tckt = tr.findById(TicketId).get();
		return tckt;
	}
	
	public void PostTicketEntry(Ticket tckt, long EveId, long VisId) {
		System.out.println(tckt.getId() + EveId + VisId);
		Event ev = er.findById(EveId).get();
		System.out.println(ev.getId());
		ev.sellTicket();
		er.save(ev);
		
		Visitor vs = vr.findById(VisId).get();
				
		tckt.setVisitor(vs);
		tckt.setEvent(ev);
		
		tckt.addConsumption(tckt.getAmountConsumption());
		tckt.addLocker();
		System.out.println(tckt.getTicketPrice());
		
		tr.save(tckt);
	}
	
	
	

}



	