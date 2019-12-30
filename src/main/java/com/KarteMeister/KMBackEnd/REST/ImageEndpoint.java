package com.KarteMeister.KMBackEnd.REST;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.KarteMeister.KMBackEnd.controller.ImageRepository;
import com.KarteMeister.KMBackEnd.domein.Event;
import com.KarteMeister.KMBackEnd.domein.Image;

@RestController
public class ImageEndpoint {
	
	@Autowired 
	ImageRepository ir;
	
	@PostMapping("image")
	public void postImage(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("Post image");
		Image i = new Image();
		i.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		
		ir.save(i);
		
	}
	
	@GetMapping("image/{imageId}/")
	public Image getImage(@PathVariable("imageId") long id) {
		Image i = ir.findById(id).get();
		return i;
	}
	
	
	
//	@PostMapping("{firstValue}/event")
//	public void xmlPoster(@RequestBody Event ev, @PathVariable("firstValue") long id) {
//		System.out.println(id);
//		System.out.println(ev.getEventName());
//		System.out.println("Reveived: ");
//
//		es.postEventEntry(ev, id);
//	}

}
