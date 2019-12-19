package com.KarteMeister.KMBackEnd.REST;

import java.util.ArrayList;
import java.util.List;

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
import com.KarteMeister.KMBackEnd.domein.Event;

@RestController
public class AttractionEndpoint {
	@Autowired
	AttractionService as;
	
	@GetMapping("stub")
	public List<Attraction> getStub() {
		System.out.println("Send stub");
		
		List<Attraction> attrList = new ArrayList<Attraction>();
		
		Attraction attr1 = new Attraction();
		attr1.setTourName("Beat Bumpers");
		attr1.setArtistName("DJ Spring and Boot");
		attr1.setCategory("Techno");
		attr1.setDescription("Stamp stamp stamp!");
		
		Attraction attr2 = new Attraction();
		attr2.setTourName("Counter-counterpoints");
		attr2.setArtistName("Steve Reich");
		attr2.setCategory("Minimal");
		attr2.setDescription("Min going to the max.");
		
		attrList.add(attr1);
		attrList.add(attr2);
		
		return attrList;
	}
	
	@GetMapping("attraction/{firstValue}/")
	public Attraction xmlGetter(@PathVariable("firstValue") String firstValue){
		System.out.println("send");
		Attraction attr = as.getAttractionEntry(firstValue);
		return attr;
	}
	
	@PostMapping("attraction")
	public void xmlPoster(@RequestBody Attraction attr){
		System.out.println("received:");

		as.postAttractionEntry(attr);
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
