/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ParkingLot;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author talam
 */
public class ParkingLotFloorTest {
    
    public ParkingLotFloorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of parkCar method, of class ParkingLotFloor.
     */
    @Test
    public void testParkCar() {
        System.out.println("parkCar");
        Car car = new Car("testOwner", 2.0);
        ParkingLotFloor instance = new ParkingLotFloor(10, 3.0);
        instance.parkCar(car);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParkedCar method, of class ParkingLotFloor.
     */
    @Test
    public void testGetParkedCar() {
        System.out.println("getParkedCar");
        ParkingLotFloor instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.getParkedCar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCar method, of class ParkingLotFloor.
     */
    @Test
    public void testRemoveCar() {
        System.out.println("removeCar");
        Car car = null;
        ParkingLotFloor instance = null;
        instance.removeCar(car);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarByTicket method, of class ParkingLotFloor.
     */
    @Test
    public void testFindCarByTicket() {
        System.out.println("findCarByTicket");
        int ticket = 0;
        ParkingLotFloor instance = null;
        Car expResult = null;
        Car result = instance.findCarByTicket(ticket);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
