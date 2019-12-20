package com.KarteMeister.KMBackEnd.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.KarteMeister.KMBackEnd.domein.Visitor;

@Component
public interface VisitorRepository extends CrudRepository<Visitor, Long> {
	
	public Visitor findByVisitorName(String VisitorName);
}
