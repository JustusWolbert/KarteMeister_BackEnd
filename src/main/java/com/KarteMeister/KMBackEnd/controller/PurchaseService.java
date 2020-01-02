package com.KarteMeister.KMBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;
import com.KarteMeister.KMBackEnd.domein.Organiser;
import com.KarteMeister.KMBackEnd.domein.SalesAdmin;
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
	
	@Autowired 
	OrganiserRepository or;
	
	@Autowired
	SalesAdminRepository sa;
	

	public Ticket getTicketEntry(long TicketId) {
		Ticket tckt = tr.findById(TicketId).get();
		return tckt;
	}
	
	public Ticket PostTicketEntry(Ticket tckt, long EveId, long VisId) {
		Event ev = er.findById(EveId).get();
		Visitor vs = vr.findById(VisId).get();
		Organiser og = ev.getAttraction().getOrganiser();
		SalesAdmin sad = sa.findByName("Admin");
		
		if(ev.getAmountTicket() > 0) {
			tckt.setVisitor(vs);
			tckt.setEvent(ev);
			tckt.setTicketPrice();
			tckt.addConsumption(tckt.getAmountConsumption());
			tckt.addLocker();
			System.out.println("Ticket price: "+tckt.getTicketPrice());
			
			if( vs.getWallet() > tckt.getTicketPrice()) {
				vs.setWallet(vs.getWallet()-tckt.getTicketPrice());
				vr.save(vs);
				
				ev.sellTicket();
				er.save(ev);
				
				double split = 0.9*tckt.getTicketPrice();
				og.setWallet(og.getWallet()+split);
				or.save(og);
	
				sad.setWallet(sad.getWallet()+tckt.getTicketPrice()-split);
				sa.save(sad);
				
				System.out.println(vs.getVisitorName()+" bought ticket");
				tr.save(tckt);
				return tckt;
			}else {
				System.out.println(vs.getVisitorName()+" did not have enough money.");
				return null;
			}
		}else {
			System.out.println("Sold out");
			return null;
		}
		
	}
	
	
	

}



	