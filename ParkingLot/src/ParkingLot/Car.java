
package ParkingLot;;


import java.util.Scanner;


public class Car {
    private static int nextTicketNumber = 1;  // Static variable for ticket numbers
    private String ticket;
    private String owner;
    private Double hours;
    private int floor;
    private int spot;

    
    
    public Car(String owner, Double hours) {    
        this.owner = owner;
        this.hours = hours; // Assign the value to the class member variable
        this.ticket = generateTicket();        
    }

    public Car(String owner, String ticket){
        this.owner = owner;
        this.ticket = ticket;
    }
    public static Car createCar(Scanner scnr) {
        System.out.print("Enter owner name: ");
        String owner = scnr.nextLine();

        System.out.print("Enter your expected length of stay in hours: ");
        Double hours = scnr.nextDouble();

        // Consume the newline character
        scnr.nextLine();

        return new Car(owner, hours);
    }
    public Double getHours() {
        return hours;
    }

    public String getTicket() {
        return ticket;
    }
    
    public int getFloor() {
        return floor;
    }

    public int getSpot() {
        return spot;
    }

    public void setParkingInfo(int floor, int spot) {
        this.floor = floor;
        this.spot = spot;
    }    

    public String getOwner() {
        return owner;
    }

    public void displayTicket() {
        System.out.println("Your ticket is: " + ticket);
    }

    // Method to generate a new ticket
    private static String generateTicket() {
        if (nextTicketNumber == 1000) {
            nextTicketNumber = 1;  // Reset to 1 when it reaches 1000
        }
        return String.format("%04d", nextTicketNumber++);  // Format as 4-digit ticket number
    }
}