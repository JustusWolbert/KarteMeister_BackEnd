package com.KarteMeister.KMBackEnd.domein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KarteMeister.KMBackEnd.controller.AttractionService;

@RestController
public class AttractionEndpoint {
	@Autowired
	AttractionService as;
	
	@GetMapping("attraction")
	public Attraction xmlResponse(){
		System.out.println("send");
		as.proberen();
		Attraction attr = new Attraction();
		attr.setId(27);
		attr.setMessage("Hallo Dylan");
		return attr;
	}
}
