package com.KarteMeister.KMBackEnd.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.KarteMeister.KMBackEnd.domein.SalesAdmin;

@Component
public interface SalesAdminRepository extends CrudRepository<SalesAdmin, Long>{
	SalesAdmin findById(long id);

	SalesAdmin findByName(String string);
	
}




