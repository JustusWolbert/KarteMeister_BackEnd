package com.KarteMeister.KMBackEnd.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.KarteMeister.KMBackEnd.domein.Attraction;
import com.KarteMeister.KMBackEnd.domein.Event;

@Component
public interface EventRepository extends CrudRepository<Event, Long>{
	
	public List<Event> findAll();
	
	public Event findByEventName(String eventName);

	public Event findByEventNameAndVenue(String eventName, String venue);

	@Modifying
	@Transactional(readOnly=false)
	@Query("DELETE FROM Event et WHERE et.id = ?1")
	public void removeById(long id);
	
	public List<Event> findAllByAttractionId(long attractionId);
}
