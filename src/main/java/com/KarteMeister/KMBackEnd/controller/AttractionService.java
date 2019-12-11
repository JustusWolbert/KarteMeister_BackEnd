package com.KarteMeister.KMBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KarteMeister.KMBackEnd.domein.Attraction;

@Service
public class AttractionService {
	@Autowired
	AttractionRepository ar;
	
	public void proberen() {
		ar.save(new Attraction());
	}

}
