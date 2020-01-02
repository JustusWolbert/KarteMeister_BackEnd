package com.KarteMeister.KMBackEnd.domein;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Attraction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String attractionName;
	private String artistName;
	private String category;
	private String description;
	
	private String imageName;
	
	



	//@JsonBackReference
	@OneToMany(mappedBy="attraction", orphanRemoval=true /*, cascade=CascadeType.ALL*/)
	//@JsonIgnoreProperties(value = "eventList")
	private List<Event> eventList;
	
	@ManyToOne
	@JoinColumn(name="organiser_id", nullable = false)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JsonManagedReference
	private Organiser organiser;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAttractionName() {
		return attractionName;
	}

	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	public Organiser getOrganiser() {
		return organiser;
	}

	public void setOrganiser(Organiser organiser) {
		this.organiser = organiser;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
}
