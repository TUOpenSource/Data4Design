package com.Data4Design.webapp;

public class Country {
	
	private String country;
	private String id;
	private int population; 		// population provided by World Bank API
	
	// add more attributes
	
	public Country() {}
	
	public Country(String name) {
		this.country = name;
	}
	
	public Country(String name, String id, int population) {
		this.country = name;
		this.id = id;
		this.population = population;
	}

	public String getName() {
		return country;
	}

	public void setName(String country) {
		this.country = country;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}

}
