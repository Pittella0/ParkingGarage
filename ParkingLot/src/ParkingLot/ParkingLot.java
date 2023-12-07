
package ParkingLot;

import java.util.Scanner;
import java.util.List;
public class ParkingLot {

    public static void main(String[] args) {

    ParkingLotFloor floorOne = new ParkingLotFloor(5000, 4.0);
    ParkingLotFloor floorTwo = new ParkingLotFloor(5000, 3.5);
    ParkingLotFloor floorThree = new ParkingLotFloor(5000, 3.0);
    
    Scanner scnr = new Scanner(System.in);
    Attendant attendant = new Attendant();
    
        while (true) {
            System.out.println("\nParking Lot Menu:");
            System.out.println("1. Add a new car");
            System.out.println("2. Pick up a car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            int choice = scnr.nextInt();
            scnr.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    Car newCar = Car.createCar(scnr);
                    attendant.parkCar(newCar, floorOne, floorTwo, floorThree, newCar.getHours());
                    newCar.displayTicket();
                    break;
                case 2:
                    System.out.print("\nWhat is your ticket number: ");
                    int ticket = scnr.nextInt();
                    Car foundCar = attendant.findCarByTicket(ticket, List.of(floorOne, floorTwo, floorThree));

                    if (foundCar != null) {
                        System.out.println("Car found with ticket number " + ticket);
                        attendant.removeCarByTicket(ticket, List.of(floorOne, floorTwo, floorThree));
                        // Handle the found car as needed
                    } else {
                        System.out.println("Car not found with ticket number " + ticket);
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }
}