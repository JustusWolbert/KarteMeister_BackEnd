package com.KarteMeister.KMBackEnd.controller;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.KarteMeister.KMBackEnd.domein.Organiser;
import com.KarteMeister.KMBackEnd.domein.SalesAdmin;
import com.KarteMeister.KMBackEnd.domein.Ticket;

@Component
public interface SalesAdminRepository extends CrudRepository<SalesAdmin, Long>{
	SalesAdmin findById(long id);

	SalesAdmin findByName(String string);
	
}




