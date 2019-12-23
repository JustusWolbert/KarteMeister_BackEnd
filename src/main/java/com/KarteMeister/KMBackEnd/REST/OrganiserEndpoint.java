package com.KarteMeister.KMBackEnd.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KarteMeister.KMBackEnd.controller.ProfileService;
import com.KarteMeister.KMBackEnd.domein.Organiser;
import com.KarteMeister.KMBackEnd.domein.Visitor;

@RestController
public class OrganiserEndpoint {

	@Autowired
	ProfileService profs;
	
	@GetMapping("organiser/{organiserName}")
	public Visitor xmlGetter(@PathVariable("organiserName") String organiserName) {
		profs.getVisitorEntry(organiserName);
		return null;
	}
	
	@PostMapping("organiser")
	public void xmlPoster(@RequestBody Organiser org) {
		System.out.println("Received: "+org.getName());
		profs.postOrganiserEntry(org);
	}
}