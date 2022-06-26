package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.FoodTruck;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

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
	private FoodTruck[] foodTrucks; // TODO Should this go inside the main?
	private int remainingReviews = 5;

	public static void main(String... args) {
		printSplashScreen();
		getUserReview();
	}

	private void printSplashScreen() {
		int remainingReviews; // no default value because local variable
		System.out.println("**********************");
		System.out.println("*       Truckr       *");
		System.out.println("* Food Truck Reviews *");
		System.out.println("**********************");
		System.out.println();
		if (foodTrucks != null) {
			remainingReviews = 5 - foodTrucks.length;
		}
		System.out.println(remainingReviews + " of 5 available reviews remaining.");
		System.out.println();
		System.out.println("Please leave your food truck review below, and don't forget to follow us on Instagram! @FoodTruckApp");
		System.out.println();
	}
	
	private void printReviewTitle() {
		System.out.print(" Review - Food Truck #" + (remainingReviews - 4));
	}
	
	private void printReviewTitle(int index) {
		System.out.print(" Review - Food Truck #" + foodTrucks[index]);
	}
	
	private void getUserReview() {
		printReviewTitle();
		getNameFromUser();
	}
	
	private String getNameFromUser() {
		System.out.println("Name: ('quit' to quit) ");
		return scanner.nextLine();
	}

	private String getCategoryFromUser() {
		System.out.println("Category: ");
		return scanner.nextLine();
	}

	private int getRatingFromUser() {
		System.out.println("Rating: (1-5) ");
		return scanner.nextLine();
	}
}
