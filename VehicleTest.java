package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {
    
    Car car;
    Motorcycle motorcycle;
    
    @BeforeEach
    public void setUp() {
        car = new Car();
        motorcycle = new Motorcycle();
    }
    
    @Test
    public void testCarInstanceIsVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    public void testCarHasFourWheels() {
        assertEquals(4, car.getNumWheels());
    }
    
    @Test
    public void testMotorcycleHasTwoWheels() {
        assertEquals(2, motorcycle.getNumWheels());
    }

    
    @Test
    public void testCarCanReachSpeed60() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }
    
    @Test
    public void testMotorcycleCanReachSpeed75() {
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }
    
    @Test
    public void testCarStopsWhenParked() {
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }
    
    @Test
    public void testMotorcycleStopsWhenParked() {
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}
