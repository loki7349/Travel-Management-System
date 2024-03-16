package travel.management.system;

public class Main {
    public static void main(String[] args) {
        Activity hiking = new Activity("Hiking", "Enjoy a scenic hike", 50.0, 10);
        Activity snorkeling = new Activity("Snorkeling", "Explore underwater life", 100.0, 8);
        Activity sightseeing = new Activity("Sightseeing", "Visit local landmarks", 30.0, 15);

        Destination beach = new Destination("Beach");
        beach.addActivity(snorkeling);

        Destination mountains = new Destination("Mountains");
        mountains.addActivity(hiking);

        Destination city = new Destination("City");
        city.addActivity(sightseeing);

        TravelPackage package1 = new TravelPackage("Adventure Package", 20);
        package1.addDestination(beach);
        package1.addDestination(mountains);
        package1.addDestination(city);

        Passenger passenger1 = new Passenger("Alice", 1, 200.0, PassengerType.STANDARD);
        Passenger passenger2 = new Passenger("Bob", 2, 300.0, PassengerType.GOLD);
        Passenger passenger3 = new Passenger("Charlie", 3, 0.0, PassengerType.PREMIUM);


        passenger1.signUpForActivity(snorkeling);
        passenger2.signUpForActivity(hiking);
        passenger3.signUpForActivity(sightseeing);


        package1.addPassenger(passenger1);
        package1.addPassenger(passenger2);
        package1.addPassenger(passenger3);


        package1.printItinerary();


        package1.printPassengerList();


        package1.printPassengerDetails(1);

        package1.printAvailableActivities();
    }
}