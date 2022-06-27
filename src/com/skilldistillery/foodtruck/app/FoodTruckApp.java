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
	private FoodTruck[] foodTrucks;
	private String appName, appDescription;
	private static int MAX_REVIEWS = 5;
	private static int nextTruckID = 1;
	
//	Constructors
	public FoodTruckApp () {
		this.foodTrucks = new FoodTruck[MAX_REVIEWS];	// Create array of FoodTrucks for each new FoodTruckApp instance
		this.appName = "Food Truck App";	// Provide a default app name if none is given
		this.appDescription = "Food Truck Reviews";
	}
	
	public FoodTruckApp(String name) {
		this();
		this.appName = name;			// If the name of the app is provided, override the default name with the name provided
	}

	public static void main(String... args) {
		FoodTruckApp app = new FoodTruckApp("Truckr");
		int truckID = nextTruckID;
		int remainingReviews = MAX_REVIEWS;
		
		System.out.println("Please enlarge your console.");
		System.out.println();
		
		app.printSplashScreen(remainingReviews);

		while (remainingReviews > 0) {
			app.addFoodTruck(app.inputUserReview(truckID, remainingReviews));
			truckID += 1;
			remainingReviews -= 1;
		}
		
		System.out.println();
		System.out.println("All reviews complete!");
		app.printMenu();
	}
	
//	Publicly available class methods
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

	public void addFoodTruck(FoodTruck foodTruck) {
		for (int truck = 0; truck < this.foodTrucks.length; truck++) {
			if (this.foodTrucks[truck] == null) {
				this.foodTrucks[truck] = new FoodTruck(foodTruck);
				break;
			}
		}
	}
	
//	Getters and setters
	private double getAverageRating() {
		int truckCount = 0, totalRatings = 0;
		for (int i = 0; i < this.foodTrucks.length; i++) {
			if (this.foodTrucks[i] != null) {
				totalRatings += this.foodTrucks[i].getRating();
				truckCount += 1;
			}
		}
		return (double) totalRatings / truckCount;
	}
	
	private FoodTruck getHighestRated() {
		int highestRating = 0;
		FoodTruck highestRated = new FoodTruck();
		for (int i = 0; i < this.foodTrucks.length; i++) {
			if (this.foodTrucks[i] != null) {
				if (this.foodTrucks[i].getRating() > highestRating) {
					highestRated = this.foodTrucks[i];
					highestRating = this.foodTrucks[i].getRating();
				}
			}
		}
		return highestRated;
	}

	//	Output methods
	private void printSplashScreen(int remainingReviews) {
		System.out.println(this.toString());
		System.out.println();
		System.out.println(remainingReviews + " of 5 available reviews remaining.");
		System.out.println();
		System.out.println("Please leave your food truck review below, and don't forget to follow us on Instagram! @" + this.appName);
	}
	
	private void printReviewTitle(int remainingReviews) {
		System.out.println();
		System.out.println("Review - Food Truck #" + (6-remainingReviews));
		System.out.println("----------------------");
	}
	
	private void printMenu() {
		int selection;

		do {
			System.out.println(this.toString());
			System.out.println();
			System.out.println("Please select an item from the following menu:");
			System.out.println();
			System.out.println("1 - List all existing food trucks");
			System.out.println("2 - See the average rating of all food trucks");
			System.out.println("3 - View the highest-rated food truck");
			System.out.println("4 - Quit");
			System.out.println();
			System.out.println("> ");

			try { // Ensure user enters an integer
				selection = scanner.nextInt();
				scanner.nextLine(); // Catch newline character after Scanner.nextInt()
			} catch (InputMismatchException e) { // If input not an integer, try again
				System.out.println("Invalid entry. Please enter the number of the item you wish to select.");
				selection = this.inputRating();
			}
			if (!(selection >= 1 && selection <= 4)) { // Ensure rating within the allowed range, here hard-coded
														// between 1-5
				System.out.println("Invalid entry. Please enter the number of the item you wish to select.");
			}
			switch (selection) {
			case 1:
				displayFoodTrucks();
				break;
			case 2:
				displayAverageRating();
				break;
			case 3:
				displayHighestRated();
				break;
			}
		} while (selection != 4);
		exitApp();
	}
	
	private void displayFoodTrucks() {
		System.out.println("All Food Trucks");
		System.out.println("---------------");
		for (int i = 0; i < this.foodTrucks.length; i++) {
			if (this.foodTrucks[i] != null) {
				System.out.println(this.foodTrucks[i].toString());
				System.out.println();
			}
		}
		System.out.println();
	}

	private void displayAverageRating() {
		System.out.printf("The average rating for all food trucks is: %1.2f", getAverageRating());
		System.out.println();
	}

	private void displayHighestRated() {
		System.out.println("Highest Rated Foodtruck");
		System.out.println("-----------------------");
		System.out.println(this.getHighestRated().toString());
		System.out.println();
	}

//	Input Methods
	private FoodTruck inputUserReview(int id, int remainingReviews) {
		FoodTruck foodTruck;
		printReviewTitle(remainingReviews);
		foodTruck = new FoodTruck(	id,
									inputName(),
									inputCategory(),
									inputRating());
		return foodTruck;
	}
	
	private String inputName() {
		String name = "";
		System.out.print("Name: (type 'quit' to stop reviewing) ");
		name = scanner.nextLine();
		if (name.toLowerCase().equals("quit")) {	// Check to see whether user wishes to quit
			printMenu();								// If user wishes to quit, invoke method to properly close app
			return name; // Added this in so Eclipse would remove its error message. I believe it is unnecessary, though.
		} else {
			return name;
		}
	}

	private String inputCategory() {
		System.out.print("Category: ");
		return scanner.nextLine();
	}

	private int inputRating() {			
		int rating;
		System.out.print("Rating: (1-5) ");
		try {							// Ensure user enters an integer
			rating = scanner.nextInt();
			scanner.nextLine();					// Catch newline character after Scanner.nextInt()
		} catch (InputMismatchException e) {	// If input not an integer, try again
			System.out.println("Invalid entry. Please enter only whole numbers.");
			rating = this.inputRating();
		}
		if (!(rating >= 1 && rating <= 5)) {	// Ensure rating within the allowed range, here hard-coded between 1-5
			rating = this.inputRating();	// If not within range, try again
		} else {
			return rating;
		}
		return rating;	// Included this because, without it, Eclipse throws a return type error,
						// but I suspect that the try/catch and if statements should be sufficient
						// to ensure that getRatingFromUser() returns an int.
	}

	//	Helper methods
	private String repeatChar(char character, int count) {
		String stringOfChars = "";
		for (int charIndex = 0; charIndex < count; charIndex++) {
			stringOfChars += character;
		}
		return stringOfChars;
	}
	
//	Quit Application Method
	private void exitApp() {
		System.out.println("Thank you for using Truckr!");
		scanner.close();
		System.exit(0);
	}
}
