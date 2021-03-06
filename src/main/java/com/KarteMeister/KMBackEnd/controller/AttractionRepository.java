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
	
	public List<Attraction> findAll();
	
	public Attraction findByArtistName(String artistName);
	
	@Modifying
	@Transactional(readOnly=false)
	@Query("DELETE FROM Attraction att WHERE att.id = ?1")
	public void removeById(long id);
	
	
	/*
	@Modifying
	@Query("update Attraction att set att.location = ?1 where u.eventName = ?2")
	public int setLocationForEvent(String location, String eventName);
	*/
	


}
