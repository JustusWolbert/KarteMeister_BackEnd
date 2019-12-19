package com.KarteMeister.KMBackEnd.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.KarteMeister.KMBackEnd.domein.Event;

@Component
public interface EventRepository extends CrudRepository<Event, Long>{
	@Override
	@Transactional
	public List<Event> findAll();
	
	public Event findByEventName(String eventName);
}
