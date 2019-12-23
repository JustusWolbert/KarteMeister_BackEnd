package com.KarteMeister.KMBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KarteMeister.KMBackEnd.domein.Organiser;
import com.KarteMeister.KMBackEnd.domein.Visitor;


@Service
public class ProfileService {
	
	@Autowired
	VisitorRepository vr;
	@Autowired
	OrganiserRepository or;
	
	public void postVisitorEntry(Visitor vtr) {
		vr.save(vtr);
	}
	
	public Visitor getVisitorEntry(String VisitorName) {
		Visitor vtr = vr.findByVisitorName(VisitorName);
		return vtr;
	}
	
	public void postOrganiserEntry(Organiser org) {
		or.save(org);
	}
	
	public Organiser getOrganiserEntry(String organiserName) {
		Organiser org = or.findByName(organiserName);
		return org;
	}
	
	
	
}
