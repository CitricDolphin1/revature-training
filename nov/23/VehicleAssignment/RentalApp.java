package com.vehiclerental;
import java.util.*;

public class RentalApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many vehicles?: ");
		int vehicleCount = sc.nextInt();
		sc.nextLine();
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		for (int i = 0; i < vehicleCount; i++) {
			double insuranceRate = 0;
			System.out.print("car or bike?: ");
			String model = sc.nextLine();
			
			if (!model.equals("car") && !model.equals("bike")) {
				System.out.println("Invalid model, enter 'car' or 'bike'");
				i--;
				continue;
			}
			
			System.out.print("Enter vehicle number: ");
			int vehicleNumber = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Enter daily rate: ");
			double dailyRate = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Enter rental duration (days): ");
			int days = sc.nextInt();
			sc.nextLine();
			
			if (model.equals("car")) {
				System.out.print("Enter insurance rate: ");
				insuranceRate = sc.nextDouble();
				sc.nextLine();
			}
			
			switch (model) {
			case "bike":
				vehicles.add(new Bike(vehicleNumber, "Bike", dailyRate, days));
				break;
			case "car":
				vehicles.add(new Car(vehicleNumber, "Car", dailyRate, days, insuranceRate));
				break;
			}
		}
		
		double total = 0;
		for (int i = 0; i < vehicles.size(); i++) {
			System.out.println();
			Vehicle vehicle = vehicles.get(i);
			vehicle.displayDetails();
			System.out.println(vehicle.calculateRent());
			total += vehicle.calculateRent();
		}
		
		System.out.println("Grand total: " + total);
		
		sc.close();

	}

}
