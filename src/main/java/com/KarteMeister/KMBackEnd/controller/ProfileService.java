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
	
	public Visitor postVisitorEntry(Visitor vtr) {
		vr.save(vtr);
		return vtr;
	}
	
	public Visitor getVisitorEntry(String VisitorName) {
		Visitor vtr = vr.findByVisitorName(VisitorName);
		return vtr;
	}
	
	public Organiser postOrganiserEntry(Organiser org) {
		or.save(org);
		return org;
	}
	
	public Organiser getOrganiserEntry(String organiserName) {
		Organiser org = or.findByName(organiserName);
		return org;
	}
	
	
	
}
