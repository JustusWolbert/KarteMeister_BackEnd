package com.KarteMeister.KMBackEnd.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KarteMeister.KMBackEnd.controller.ProfileService;
import com.KarteMeister.KMBackEnd.controller.PurchaseService;
import com.KarteMeister.KMBackEnd.domein.Visitor;

@RestController
public class VisitorEndpoint {
	
	@Autowired
	ProfileService profs;
	
	@GetMapping("visitor/{visitorName}")
	public Visitor xmlGetter(@PathVariable("visitorName") String visitorName) {
		profs.getVisitorEntry(visitorName);
		return null;
	}
	
	@PostMapping("visitor")
	public void xmlPoster(@RequestBody Visitor vstr) {
		System.out.println("Received: "+vstr.getVisitorName());
		profs.postVisitorEntry(vstr);
	}
}
