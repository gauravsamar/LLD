package RideSharingApp;

import java.util.ArrayList;
import java.util.List;

public class RideMatching {
    List<Driver> drivers;
    public RideMatching() {
        this.drivers = new ArrayList<>();
    }
    public void addDriver(Driver driver) {
        drivers.add(driver);
    }
    public void bookRide(Passenger passenger, RideType rideType, FareStrategy fareStrategy) {
        if(drivers.isEmpty()) {
            System.out.println("No drivers available for ride matching.");
            return;
        }
        Ride ride = null;
        Driver bestDriver = null;
        for (Driver driver : drivers) 
        {
            double distance = passenger.getLocation().calcuateDistance(driver.getLocation());
            if(distance < Constants.THRESHOLD)
            {
                System.out.println("Ride booked for passenger: " + passenger.getName());
                bestDriver = driver;
                ride = new Ride(RideType.STANDARD, distance, passenger, driver, fareStrategy, RideStatus.BOOKED);
                drivers.remove(driver); // Remove the driver from the list after booking
                break;
            }
        }
        if(bestDriver==null)
        System.out.println("No drivers available within threshold distance for ride matching.");
        else
        {
            double fare = ride.calculateFare();
            System.out.println("Ride booked with driver: " + bestDriver.getName() + " for passenger: " + passenger.getName() + ". Fare: " + fare);
            notify();
        }
        ride.updateRideStatus(RideStatus.IN_PROGRESS);

    }
}
