package travel.management.system;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class UnitTests {

    @Test
    public void testSignUpForActivity() {
        Activity activity = new Activity("Hiking", "Enjoy a scenic hike", 50.0, 10);
        Passenger passenger = new Passenger("Alice", 1, 200.0, PassengerType.STANDARD);
        
        activity.addPassenger(passenger);
        
        assertEquals(1, activity.getEnrolledPassengers().size());
        assertEquals(passenger, activity.getEnrolledPassengers().get(0));
    }

    @Test
    public void testAddActivityToDestination() {
        Destination destination = new Destination("Beach");
        Activity activity = new Activity("Snorkeling", "Explore underwater life", 100.0, 8);
        
        destination.addActivity(activity);
        
        assertEquals(1, destination.getActivities().size());
        assertEquals(activity, destination.getActivities().get(0));
    }

    @Test
    public void testSignUpForPackage() {
        TravelPackage travelPackage = new TravelPackage("Adventure Package", 20);
        Passenger passenger = new Passenger("Alice", 1, 200.0, PassengerType.STANDARD);
        Destination destination = new Destination("Beach");
        Activity activity = new Activity("Snorkeling", "Explore underwater life", 100.0, 8);
        
        destination.addActivity(activity);
        travelPackage.addDestination(destination);
        travelPackage.addPassenger(passenger);
        travelPackage.signUp(passenger, activity);
        
        assertEquals(1, passenger.getActivities().size());
        assertEquals(activity, passenger.getActivities().get(0));
    }

    @Test
    public void testSignInPassenger() {
        Passenger passenger = Passenger.signIn("Alice", 1, 200.0, PassengerType.STANDARD);
        
        assertEquals("Alice", passenger.getName());
        assertEquals(1, passenger.getPassengerNumber());
        assertEquals(200.0, passenger.getBalance(), 0.001);
        assertEquals(PassengerType.STANDARD, passenger.getType());
    }

    @Test
    public void testSignOutFromActivity() {
        Activity activity = new Activity("Hiking", "Enjoy a scenic hike", 50.0, 10);
        Passenger passenger = new Passenger("Alice", 1, 200.0, PassengerType.STANDARD);
        
        activity.addPassenger(passenger);
        activity.getEnrolledPassengers().remove(passenger);
        
        assertEquals(0, activity.getEnrolledPassengers().size());
    }
}
