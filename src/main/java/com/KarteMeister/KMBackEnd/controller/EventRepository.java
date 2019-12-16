package com.KarteMeister.KMBackEnd.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.KarteMeister.KMBackEnd.domein.Event;

@Component
public interface EventRepository extends CrudRepository<Event, Long>{

}
