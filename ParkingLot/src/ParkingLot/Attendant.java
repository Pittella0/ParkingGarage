package ParkingLot;
import java.util.List;

public class Attendant {

    public void parkCar(Car car, ParkingLotFloor floorOne, ParkingLotFloor floorTwo, ParkingLotFloor floorThree, double expectedHours) {
        int floor;
        
        if (car.getHours() > 0) {
           floor = determineFloor(car.getHours());
            switch (floor) {
                case 1 -> floorOne.parkCar(car);
                case 2 -> floorTwo.parkCar(car);
                case 3 -> floorThree.parkCar(car);
                default -> System.out.println("Invalid floor determined.");
            }

        } else {
            System.out.println("Invalid car information or expected hours.");
        }
        System.out.println("Attendant is parking you car on level " + car.getFloor() + ".");        
    }


    public int determineFloor(Double expectedHours) {
        if (expectedHours <= 3) {
            return 1;
        } else if (expectedHours <= 6) {
            return 2;
        } else if (expectedHours <= 12) {
            return 3;
        } else {
            return 0; // Unknown floor
        }
    }

    public void removeCarByTicket(int ticket, List<ParkingLotFloor> floors) {
        System.out.println("\nAttendant is bringing your car around.");

        for (ParkingLotFloor floor : floors) {
            Car foundCar = floor.findCarByTicket(ticket);
            if (foundCar != null) {
                floor.removeCar(foundCar);
                System.out.println("Car with the ticket number " + ticket + " removed successfully.");
                return; // Exit the method if the car is found and removed
            }
        }

        // If the loop completes, the car with the specified ticket was not found
        System.out.println("Car with the ticket " + ticket + " not found.");
    }

    public Car findCarByTicket(int ticket, List<ParkingLotFloor> floors) {
        for (ParkingLotFloor floor : floors) {
            Car foundCar = floor.findCarByTicket(ticket);
            if (foundCar != null) {
                return foundCar;
            }
        }
        return null;  // Car not found
    }


//    private void removeFromFloor(Car car, ParkingLotFloor floorOne, ParkingLotFloor floorTwo, ParkingLotFloor floorThree) {
//        int floor = determineFloor(car.getHours());
//        switch (floor) {
//            case 1:
//                floorOne.removeCar(car);
//                break;
//            case 2:
//                floorTwo.removeCar(car);
//                break;
//            case 3:
//                floorThree.removeCar(car);
//                break;
//            default:
//                System.out.println("Invalid floor determined.");
//        }
//    }
}

