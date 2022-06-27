package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.FoodTruck;
import java.util.Scanner;
import java.util.InputMismatchException;

/*
 * 	Directions:
 * 
 * 	TODO	(complete)	You will create a separate class with a main method that starts the program.
 * 	TODO	(complete)	It will have an array to store up to five FoodTruck objects.
 * 	TODO	The main method of this class is the only static method in the entire project.
 * 
 */

public class FoodTruckApp {
	private Scanner scanner = new Scanner(System.in);
	FoodTruck[] foodTrucks; // TODO Should this go inside the main?
	String appName, appDescription;
	int remainingReviews;
	
	private FoodTruckApp () {
		this.foodTrucks = new FoodTruck[5];	// Create array of FoodTrucks for each new FoodTruckApp instance
		this.remainingReviews = 5;			// Initialize each new FoodTruckApp instance with 5 available remaining reviews
		this.appName = "Food Truck App";	// Provide a default app name if none is given
		this.appDescription = "Food Truck Reviews";
	}
	
	private FoodTruckApp(String name) {
		this();
		this.appName = name;			// If the name of the app is provided, override the default name with the name provided
	}

	public static void main(String... args) {
		FoodTruckApp truckr = new FoodTruckApp("Truckr");
		truckr.printSplashScreen();
		
		while (truckr.remainingReviews > 0) {
			truckr.addFoodTruck(truckr.getUserReview());
			truckr.remainingReviews -= 1;
		}
		
		System.out.println();
		System.out.println("All reviews complete!");
		truckr.exitApp();
	}

	private void printSplashScreen() {
		System.out.println(this.toString());
		System.out.println();
		System.out.println(this.remainingReviews + " of 5 available reviews remaining.");
		System.out.println();
		System.out.println("Please leave your food truck review below, and don't forget to follow us on Instagram! @" + this.appName);
	}
	
	@Override
	public String toString() {
		int charCount = (this.appDescription.length() - this.appName.length()) / 2;
		StringBuilder message = new StringBuilder();
		String spaces = "",
				asterisks = this.appName.length() > this.appDescription.length()	? 	repeatChar('*', this.appName.length() + 4):
																					repeatChar('*', this.appDescription.length() + 4);
		message.append(asterisks + "\n");
		spaces = repeatChar(' ', charCount);
		message.append("* " + spaces + this.appName + spaces + " *\n");
		spaces = repeatChar(' ', -charCount);
		message.append("* " + spaces + this.appDescription	+ spaces + " *\n");
		message.append(asterisks + "\n");
		return message.toString();
	}
	
	private String repeatChar(char character, int count) {
		String stringOfChars = "";
		for (int charIndex = 0; charIndex < count; charIndex++) {
			stringOfChars += character;
		}
		return stringOfChars;
	}
	
	private void addFoodTruck(FoodTruck foodTruck) {
		for (int truck = 0; truck < this.foodTrucks.length; truck++) {
			if (this.foodTrucks[truck] == null) {
				this.foodTrucks[truck] = new FoodTruck(foodTruck);
				break;
			}
		}
	}
	
	private void printReviewTitle() {
		System.out.println();
		System.out.println("Review - Food Truck #" + (6-this.remainingReviews));
		System.out.println("----------------------");
	}
	
	private FoodTruck getUserReview() {
		FoodTruck foodTruck;
		printReviewTitle();
		foodTruck = new FoodTruck(	getNameFromUser(),
									getCategoryFromUser(),
									getRatingFromUser());
		return foodTruck;
	}
	
	private String getNameFromUser() {
		String name = "";
		System.out.print("Name: ('quit' to quit) ");
		name = scanner.nextLine();
		if (name.toLowerCase().equals("quit")) {	// Check to see whether user wishes to quit
			exitApp();								// If user wishes to quit, invoke method to properly close app
			return name; // Added this in so Eclipse would remove its error message. It is absolutely unnecessary, though.
		} else {
			return name;
		}
	}

	private String getCategoryFromUser() {
		System.out.print("Category: ");
		return scanner.nextLine();
	}

	private int getRatingFromUser() {			
		int rating = -1;
		System.out.print("Rating: (1-5) ");
		try {									// Ensure user enters an integer
			rating = scanner.nextInt();
			scanner.nextLine();					// Catch newline character after Scanner.nextInt()
		} catch (InputMismatchException e) {	// If input not an integer, try again
			System.out.println("Invalid entry. Please enter only whole numbers.");
			rating = this.getRatingFromUser();
		}
		if (!(rating >= 1 && rating <= 5)) {	// Ensure rating within the allowed range, here hard-coded between 1-5
			rating = this.getRatingFromUser();	// If not within range, try again
		} else {
			return rating;
		}
		return rating;	// Included this because, without it, Eclipse throws a return type error,
						// but the try/catch and if statements should be sufficient
						// to ensure that getRatingFromUser() returns an int.
	}
	
	private void exitApp() {
		System.out.println("Thank you for using Truckr!");
		scanner.close();
		System.exit(0);
	}
}
