package travel.management.system;

import java.util.ArrayList;
import java.util.List;

class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Travel package " + name + " is already full.");
        }
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() +
                                   ", Cost: " + activity.getCost() +
                                   ", Capacity: " + activity.getCapacity() +
                                   ", Description: " + activity.getDescription());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Name: " + passenger.getName() +
                               ", Passenger Number: " + passenger.getPassengerNumber());
        }
    }

    public void printPassengerDetails(int passengerNumber) {
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerNumber() == passengerNumber) {
                System.out.println("Passenger Details:");
                System.out.println("Name: " + passenger.getName());
                System.out.println("Passenger Number: " + passenger.getPassengerNumber());
                System.out.println("Balance: " + passenger.getBalance());
                System.out.println("Activities Signed Up For:");
                for (Activity activity : passenger.getActivities()) {
                    System.out.println("Activity: " + activity.getName() +
                                       ", Destination: " + getDestinationName(activity) +
                                       ", Price: " + getPrice(passenger, activity));
                }
                return;
            }
        }
        System.out.println("Passenger with number " + passengerNumber + " not found.");
    }

    private String getDestinationName(Activity activity) {
        for (Destination destination : itinerary) {
            if (destination.getActivities().contains(activity)) {
                return destination.getName();
            }
        }
        return "Unknown Destination";
    }

    private double getPrice(Passenger passenger, Activity activity) {
        double cost = activity.getCost();
        if (passenger.getType() == PassengerType.GOLD) {
            cost *= 0.9; 
        }
        return cost;
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                int spacesAvailable = activity.getCapacity() - activity.getEnrolledPassengers().size();
                System.out.println("Activity: " + activity.getName() +
                                   ", Destination: " + destination.getName() +
                                   ", Spaces Available: " + spacesAvailable);
            }
        }
    }
    
    public void signUp(Passenger passenger, Activity activity) {
        passenger.signUpForActivity(activity);
    }

    public void signOut(Passenger passenger, Activity activity) {
        List<Activity> activities = passenger.getActivities();
        if (activities.contains(activity)) {
            activities.remove(activity);
            activity.getEnrolledPassengers().remove(passenger);
            System.out.println(passenger.getName() + " signed out from activity " + activity.getName());
        } else {
            System.out.println(passenger.getName() + " is not signed up for activity " + activity.getName());
        }
    }
}
