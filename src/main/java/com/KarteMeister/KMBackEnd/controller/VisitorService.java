package com.KarteMeister.KMBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KarteMeister.KMBackEnd.domein.Visitor;

@Service
public class VisitorService {
	
	@Autowired
	VisitorRepository vr;
	
	public void postVisitorEntry(Visitor vtr) {
		vr.save(vtr);
	}
	
	public Visitor getVisitorEntry(String VisitorName) {
		Visitor vtr = vr.findByVisitorName(VisitorName);
		return vtr;
	}
	
	
	
	
}
