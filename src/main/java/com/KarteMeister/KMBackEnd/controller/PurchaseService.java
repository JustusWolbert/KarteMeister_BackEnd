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
	
	public Ticket PostTicketEntry(Ticket tckt, long EveId, long VisId) {
		Event ev = er.findById(EveId).get();
		
		Visitor vs = vr.findById(VisId).get();
				
		tckt.setVisitor(vs);
		tckt.setEvent(ev);
		tckt.setTicketPrice();
		tckt.addConsumption(tckt.getAmountConsumption());
		tckt.addLocker();
		System.out.println("Ticket price: "+tckt.getTicketPrice());
		
		if( vs.getWallet() > tckt.getTicketPrice()) {
			vs.setWallet(vs.getWallet()-tckt.getTicketPrice());
			tr.save(tckt);
			vr.save(vs);
			ev.sellTicket();
			er.save(ev);
			System.out.println(vs.getVisitorName()+" bought ticket "+tckt.getId());
			return tckt;
		}else {
			System.out.println(vs.getVisitorName()+" did not have enough money.");
			return null;
		}
		
	}
	
	
	

}



	