package com.vehiclerental;

public class Bike extends Vehicle {

	public Bike(int vehicleNumber, String model, double ratePerDay, int days) {
		super(vehicleNumber, model, ratePerDay, days);
	}
	
	@Override
	public double calculateRent() {
		return super.calculateRent() - (super.calculateRent() * 0.1);
	}
	
	@Override
	public void displayDetails() {
		System.out.println("Vehicle Number: " + vehicleNumber);
		System.out.println("Model: Bike" );
		System.out.println("Daily rental rate: " + ratePerDay);
		System.out.println("Rental duration (days): " + days);
		System.out.println("10% Discount: -" + (super.calculateRent() * 0.1));
		System.out.println("Total: " + this.calculateRent());
	}
	
}
