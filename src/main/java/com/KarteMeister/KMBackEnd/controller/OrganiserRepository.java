package com.KarteMeister.KMBackEnd.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.KarteMeister.KMBackEnd.domein.Organiser;

@Component
public interface OrganiserRepository extends CrudRepository<Organiser, Long> {

}
