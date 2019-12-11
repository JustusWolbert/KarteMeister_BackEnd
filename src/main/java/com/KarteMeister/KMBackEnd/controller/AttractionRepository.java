package com.KarteMeister.KMBackEnd.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.KarteMeister.KMBackEnd.domein.Attraction;

@Component
public interface AttractionRepository extends CrudRepository<Attraction, Long>{

}
