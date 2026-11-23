package com.vehiclerental;

public class Vehicle {

	int vehicleNumber;
	String model;
	double ratePerDay;
	int days;
	
	public Vehicle(int vehicleNumber, String model, double ratePerDay, int days) {
		this.vehicleNumber = vehicleNumber;
		this.model = model;
		this.ratePerDay = ratePerDay;
		this.days = days;
	}

	public void displayDetails() {
		System.out.println("Vehicle Number: " + vehicleNumber);
		System.out.println("Model: Generic Vehicle" );
		System.out.println("Daily rental rate: " + ratePerDay);
		System.out.println("Rental duration (days): " + days);
	}

	public double calculateRent() {
		return ratePerDay * days;
	}
	
}
