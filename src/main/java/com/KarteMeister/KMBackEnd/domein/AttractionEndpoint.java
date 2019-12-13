package com.KarteMeister.KMBackEnd.domein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KarteMeister.KMBackEnd.controller.AttractionService;

@RestController
public class AttractionEndpoint {
	@Autowired
	AttractionService as;
	
	@GetMapping("attraction/{firstValue}/")
	public Attraction xmlGetter(@PathVariable("firstValue") String firstValue){
		System.out.println("send");
		
		Attraction attr = as.getAttractionEntry(firstValue);
		return attr;
	}
	
	@PostMapping("attraction")
	public void xmlPoster(@RequestBody Attraction attr){
		System.out.println("received:");
		System.out.println(attr.getId() + " " +	
				attr.getLocation() + " " +
				attr.getDateAndTime() + " " +
				attr.getDescription() + " " +
				attr.getEventName());
		as.postAttractionEntry(attr);
		
	}
}
