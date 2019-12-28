package com.KarteMeister.KMBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KarteMeister.KMBackEnd.domein.Organiser;
import com.KarteMeister.KMBackEnd.domein.SalesAdmin;
import com.KarteMeister.KMBackEnd.domein.Visitor;


@Service
public class ProfileService {
	
	@Autowired
	VisitorRepository vr;
	@Autowired
	OrganiserRepository or;
	@Autowired
	SalesAdminRepository sar;
	
	public Visitor postVisitorEntry(Visitor vtr) {
		vr.save(vtr);
		return vtr;
	}
	
	public Visitor getVisitorEntry(String VisitorName) {
		Visitor vtr = vr.findByVisitorName(VisitorName);
		System.out.println(vtr);
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
	
	public SalesAdmin postAdmin(SalesAdmin sa) {
		sar.save(sa);
		return sa;
	}
	public SalesAdmin getAdmin(String AdminName) {
		SalesAdmin sa = sar.findByName(AdminName);
		return sa;
	}
	
}
