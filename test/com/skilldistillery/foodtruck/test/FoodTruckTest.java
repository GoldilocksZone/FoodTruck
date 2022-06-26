package com.skilldistillery.foodtruck.test;

import com.skilldistillery.foodtruck.entities.FoodTruck;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/*
 * 	Directions:
 * 
 * 	Food Trucks
Overview
Users will input and rate a list of food trucks, then view the average rating and the highest-rated truck.

Structure
You will define a FoodTruck class with fields for a unique numeric id,
a name ("TacoRific", "Mediterranean Medic", etc.),
food type ("Tacos", "Falafel", etc.), and
a numeric rating.

You will create a separate class with a main method that starts the program.
It will have an array to store up to five FoodTruck objects.
The main method of this class is the only static method in the entire project.

User Stories
User Story #1
The user is prompted to input the name, food type, and rating for up to five food trucks.
For each set of input, a FoodTruck object is created, its fields set to the user's input, and it is added to the array.
The truck id is not input by the user, but instead assigned automatically in the FoodTruck constructor from a static field that is incremented as each truck is created.

User Story #2
If the user inputs quit for the food truck name, input ends immediately and the program continues.

User Story #3
After input is complete, the user sees a menu from which they can choose to:

List all existing food trucks.
See the average rating of food trucks.
Display the highest-rated food truck.
Quit the program.
User Story #4
After choosing a menu item, the user sees the menu again and can choose another item until the choose to quit.

Grading
This is a graded project. You are expected to have your project completed by the start of class next week.

You will be given either a pass or fail based on whether your code works given all of the following test conditions:

Your working solution must be pushed to a Github repo named FoodTruckProject by start of class Monday morning.
Your Github repo has a README.md giving an overview of the program, topics/technologies used, and lessons you learned while working on it.
There are no static methods other than the one main method.
When a FoodTruck is created, its constructor assigns its id field the current value of a static field (such as (nextTruckId) and then increments the static field.
The user can input up to five food trucks.
The user can stop inputing trucks before entering five by entering quit as the truck name, after which all input stops and the program continues.
When a menu item is chosen the list of all trucks entered is displayed. If less than five were input, only those trucks that were created are displayed.
When another menu item is chosen the average rating based on the number of trucks entered is displayed.
When another menu item is chosen the winning truck - the one that was input with the highest rating - is displayed with all its properties.
Food trucks are displayed by printing its toString, which includes all FoodTruck fields.
When the quit menu item is chosen, the program ends with a message.
If the project does work with all of the above test conditions, you will be given a 1 for this week's project.

If the project does not work with the above test conditions, you will be given a 0 for this week's project.

If you get a zero on the project, you can upgrade to a score of .5 if you turn in a working project by the start of class on the following week AND notify an instructor that you wish to get partial credit.
 */

public class FoodTruckTest {
	private FoodTruck foodTruck;
	
	@Before
	public void setup() {
		foodTruck = new FoodTruck();
	}
	
	@After
	public void cleanup() {
		foodTruck = null;
	}
	
	@Test
	public void test_getName_returns_string() {
		assertEquals(foodTruck.getName().getClass(), String.class);
	}
	
	@Test
	public void test_getName_gets_actual_name() {
		String testName = "Test Truck";
		foodTruck = new FoodTruck(testName);
		assertEquals(foodTruck.getName(), testName);
	}
	
	@Test
	public void test_setName_sets_name() {
		String testName = "Test Truck";
		foodTruck.setName(testName);
		assertEquals(foodTruck.getName(), testName);
	}
}






































