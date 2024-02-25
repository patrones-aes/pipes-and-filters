package com.example.demotrack.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Country {

	private String name;
	private String region;
	private String language;

	
	public Country(String name, String region, String language) {
		super();
		this.name = name;
		this.region = region;
		this.language = language;
	}

}
