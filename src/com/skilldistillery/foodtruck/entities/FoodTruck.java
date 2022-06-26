package com.skilldistillery.foodtruck.entities;

import java.util.UUID;

/*
 * 	Directions:
 * 	TODO (complete)
 * 	You will define a FoodTruck class with fields for:
 * 	-	a unique numeric id,
 * 	-	a name ("TacoRific", "Mediterranean Medic", etc.),
 * 	-	food type ("Tacos", "Falafel", etc.), and
 * 	-	a numeric rating.
 *
 */

public class FoodTruck {
	private UUID id = null;
	private String name = null, category = null;
	private int rating = -1;
	
	public FoodTruck () {
		this.id = UUID.randomUUID();
		this.name = "unknown";
		this.category = "unknown";
	}
	
	public FoodTruck (String name) {
		this();
		this.name = name;
	}
	
	public FoodTruck (String name, String category) {
		this(name);
		this.category = category;
	}
	
	public FoodTruck (String name, String category, int rating) {
		this(name, category);
		this.rating = rating;
	}

	public String getName() {
		return new String(this.name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return new String(this.category);
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getRating() {
		return this.rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
