package travel.management.system;

import java.util.ArrayList;
import java.util.List;

class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private List<Passenger> enrolledPassengers;

    public Activity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.enrolledPassengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Passenger> getEnrolledPassengers() {
        return enrolledPassengers;
    }

    public void addPassenger(Passenger passenger) {
        if (enrolledPassengers.size() < capacity) {
            enrolledPassengers.add(passenger);
        } else {
            System.out.println("Activity " + name + " is already full.");
        }
    }
}