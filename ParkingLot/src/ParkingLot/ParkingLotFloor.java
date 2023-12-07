
package ParkingLot;;

import java.util.ArrayList;
import java.util.List;
import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingLotFloor {

    private List<Car> parkedCars;
    private int totalSpaces;
    private double hours;
    private double fee;
    private boolean[] spotAvail;

    public ParkingLotFloor(int spaces, double expectedHours) {
        this.parkedCars = new ArrayList<>();
        this.totalSpaces = spaces;
        this.hours = expectedHours;
        this.spotAvail = new boolean[spaces];
        isSpotAvail();
    }
    
    private void isSpotAvail() {
        for (int i = 0; i < spotAvail.length; i++) {
            spotAvail[i] = true; // All spots are initially available
        }
    }

    private int findAvailableSpot() {
        for (int i = 0; i < spotAvail.length; i++) {
            if (spotAvail[i]) {
                spotAvail[i] = false; // Mark the spot as occupied
                return i + 1; // Return the spot number (add 1 to make it human-readable)
            }
        }
        return -1; // No available spot
    }

    public void parkCar(Car car) {
        if (parkedCars.size() < totalSpaces) {
            if (!parkedCars.contains(car)) {
                int spot = findAvailableSpot();
                if (spot != -1) {
                    car.setParkingInfo(car.getFloor(), spot);
                    parkedCars.add(car);
                    System.out.println("Car with the ticket: " + car.getTicket() +
                            " parked successfully on Floor " + car.getFloor() +
                            " at Spot " + spot);
                } else {
                    System.out.println("No available spots on Floor " + car.getFloor());
                }
            } else {
                System.out.println("Car with the ticket: " + car.getTicket() + " is already parked.");
            }
        } else {
            System.out.println("Parking lot is full.");
        }
    }    
    
    public List<Car> getParkedCar() {
        return parkedCars;
    }
    
    
    

    public void removeCar(Car car) {
        if (parkedCars.contains(car)) {
            double parkingFee = CalcFee(hours);

            System.out.println("Car with the ticket: " + car.getTicket() + " removed.");
            System.out.println("Parking fee: $" + parkingFee);

            parkedCars.remove(car);
        } else {
            System.out.println("Car with the ticket: " + car.getTicket() + " not found.");
        }
    }

    private double CalcFee(double hours) {

        if (hours <= 3) {
            return fee = hours * 4; // Floor 1
        } else if (hours <= 6) {
            return fee = hours * 3.5; // Floor 2
        } else if (hours <= 12) {
            return fee = hours * 3; // Floor 3
        }
        return fee;
    }
    
    public Car findCarByTicket(int ticket) {
    for (Car car : parkedCars) {
        if (car.getTicket().equals(String.format("%04d", ticket))) {
            return car;
        }
    }
    return null;  // Car not found
    }
}