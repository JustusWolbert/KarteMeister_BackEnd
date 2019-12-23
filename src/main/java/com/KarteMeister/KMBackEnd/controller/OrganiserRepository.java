package com.KarteMeister.KMBackEnd.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.KarteMeister.KMBackEnd.domein.Organiser;

@Component
public interface OrganiserRepository extends CrudRepository<Organiser, Long> {

	Organiser findByName(String string);

	}
	
	

