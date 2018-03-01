package com.Data4Design.webapp;

public class Country {
	
	private String name;
	private String continent;
	//private City capitolCity;
	// add more attributes
	
	public Country(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

}
