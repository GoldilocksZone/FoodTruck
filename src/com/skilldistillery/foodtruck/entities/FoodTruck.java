package com.skilldistillery.foodtruck.entities;

/*
 * 	Directions:
 * 	You will define a FoodTruck class with fields for:
 * 	-	a unique numeric id,
 * 	-	a name ("TacoRific", "Mediterranean Medic", etc.),
 * 	-	food type ("Tacos", "Falafel", etc.), and
 * 	-	a numeric rating.
 *
 */

public class FoodTruck {
	private int id;
	private String name, category;
	private int rating;
	
	public FoodTruck() {
		
	}
	
	public FoodTruck (int id) {
		this.id = id;
	}
	
	public FoodTruck (int id, String name, String category, int rating) {
		this(id);
		this.name = name;
		this.category = category;
		this.rating = rating;
	}

	public FoodTruck (FoodTruck foodTruck) {
		this(foodTruck.id, foodTruck.name, foodTruck.category, foodTruck.rating);
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

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		description.append("\n").append(this.name).append(": \n");
		description.append("\tid = ").append(this.id).append("\n");
		description.append("\tcategory = ").append(this.category).append("\n");
		description.append("\trating = ").append(this.rating);
		
		return description.toString();
	}
	
	
	
}
