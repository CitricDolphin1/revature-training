package com.vehiclerental;

public class Car extends Vehicle {

	double insuranceCharge;
	
	public Car(int vehicleNumber, String model, double ratePerDay, int days, double insuranceCharge) {
		super(vehicleNumber, model, ratePerDay, days);
		this.insuranceCharge = insuranceCharge;
	}
	
	@Override
	public double calculateRent() {
		return super.calculateRent() + insuranceCharge * days;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("Vehicle Number: " + vehicleNumber);
		System.out.println("Model: Car" );
		System.out.println("Daily rental rate: " + ratePerDay);
		System.out.println("Rental duration (days): " + days);
		System.out.println("Insurance rate (per day): " + insuranceCharge);
		System.out.println("Total: " + this.calculateRent());
	}
	
}
