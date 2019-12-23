package com.KarteMeister.KMBackEnd.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KarteMeister.KMBackEnd.controller.AttractionService;
import com.KarteMeister.KMBackEnd.domein.Attraction;

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
	
	@PostMapping("{organiserId}/attraction")
	public void xmlPoster(@RequestBody Attraction attr, @PathVariable("organiserId") long id){
		System.out.println("Received: "+ attr.getAttractionName());

		as.postAttractionEntry(attr, id); 	//needs organiser ID
	}
	
	
	
	
	
	@PutMapping("attraction/change/{firstValue}/{secondValue}/")
	public void xmlPut(@PathVariable("firstValue") String firstValue, @PathVariable("secondValue") String secondValue){
		as.setCategoryForAttraction(firstValue, secondValue);
		
	}
	
	@DeleteMapping("attraction/delete/{firstValue}/")
	public void xmlDelete(@PathVariable("firstValue") String firstValue){
		as.delete(firstValue);
	}
	

	
	
	
}
