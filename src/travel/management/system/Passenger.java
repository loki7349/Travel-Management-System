package travel.management.system;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
	private String name;
    private int passengerNumber;
    private double balance;
    private PassengerType type;
    private List<Activity> activities;

    public Passenger(String name, int passengerNumber, double balance, PassengerType type) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.type = type;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public PassengerType getType() {
        return type;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void signUpForActivity(Activity activity) {
        if (activity.getEnrolledPassengers().size() < activity.getCapacity()) {
            double cost = activity.getCost();
            if (type == PassengerType.GOLD) {
                cost *= 0.9; 
            }
            if (type == PassengerType.STANDARD || type == PassengerType.GOLD) {
                if (balance >= cost) {
                    balance -= cost;
                    activities.add(activity);
                    activity.addPassenger(this);
                } else {
                    System.out.println("Insufficient balance to sign up for activity " + activity.getName());
                }
            } else { 
                activities.add(activity);
                activity.addPassenger(this);
            }
        } else {
            System.out.println("Activity " + activity.getName() + " is already full.");
        }
    }
	
	
	public static Passenger signIn(String name, int passengerNumber, double balance, PassengerType type) {
        return new Passenger(name, passengerNumber, balance, type);
    }
}
