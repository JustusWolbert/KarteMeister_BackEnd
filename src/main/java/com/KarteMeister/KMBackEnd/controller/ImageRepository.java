package com.KarteMeister.KMBackEnd.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.KarteMeister.KMBackEnd.domein.Image;

@Component
public interface ImageRepository extends CrudRepository<Image, Long>{
	
}
