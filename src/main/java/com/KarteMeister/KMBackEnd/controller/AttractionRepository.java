package com.KarteMeister.KMBackEnd.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.KarteMeister.KMBackEnd.domein.Attraction;

@Component
public interface AttractionRepository extends CrudRepository<Attraction, Long>{
	
	@Override
	@Transactional
	public List<Attraction> findAll();
	
	public Attraction findByArtistName(String artistName);
	
	
	
	/*
	@Modifying
	@Query("update Attraction att set att.location = ?1 where u.eventName = ?2")
	public int setLocationForEvent(String location, String eventName);
	*/

}
