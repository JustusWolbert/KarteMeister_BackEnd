package com.KarteMeister.KMBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;

@Service
public class EventService {
	
	@Autowired
	EventRepository er;
	@Autowired
	AttractionRepository ar;
	

	

}



	