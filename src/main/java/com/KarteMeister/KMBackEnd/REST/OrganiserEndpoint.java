package com.KarteMeister.KMBackEnd.REST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KarteMeister.KMBackEnd.controller.ProfileService;
import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Organiser;

@RestController
public class OrganiserEndpoint {

	@Autowired
	ProfileService profs;
	
	@GetMapping("organiser/{organiserName}/")
	public Organiser getOrganiser(@PathVariable("organiserName") String organiserName){
		System.out.println("send");
		Organiser org = profs.getOrganiserEntry(organiserName);
		List<Attraction> attrList = new ArrayList<Attraction>();
		for(Attraction a : org.getAttractionList()) {
			Attraction attr = new Attraction();
			attr.setId(a.getId());
			attrList.add(attr);
		}
		org.setAttractionList(attrList);	
		return org;
	}
	
	@PostMapping("organiser")
	public void xmlPoster(@RequestBody Organiser org) {
		System.out.println("Received: "+org.getName());
		profs.postOrganiserEntry(org);
	}
	
	
	
	
	
	

	

	
}