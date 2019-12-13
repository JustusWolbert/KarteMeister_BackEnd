package com.KarteMeister.KMBackEnd.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.KarteMeister.KMBackEnd.domein.Attraction;

@Component
public interface AttractionRepository extends CrudRepository<Attraction, Long>{
	
	@Override
	@Transactional(timeout=10)
	public List<Attraction> findAll();

}
