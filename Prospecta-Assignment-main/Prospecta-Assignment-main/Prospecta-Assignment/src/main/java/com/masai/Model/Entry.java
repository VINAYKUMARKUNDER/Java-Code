package com.masai.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Entry {
	
	@Id
	@JsonProperty("API")
	private String title;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("Auth")
	private String auth;
	
	@JsonProperty("HTTPS")
	private Boolean https;
	
	@JsonProperty("Cors")
	private String cors;
	
	@JsonProperty("Link")
	private String link;
	
	@JsonProperty("Category")
	private String category;

}
